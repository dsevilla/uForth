%%%-------------------------------------------------------------------
%%% @author Diego Sevilla <dsevilla@ditec.um.es>
%%% @copyright (C) 2013, Diego Sevilla
%%% @doc
%%% Runs a forth program described as a memory of tuples
%%% @end
%%% Created : 11 May 2013 by Diego Sevilla <dsevilla@ditec.um.es>
%%%-------------------------------------------------------------------
-module(forth_interpreter).

%% API
-export([start/0,def_marker/2,program_start_marker/1,has_def/2,new_instruction/2,run/1,
         push_data/2,pop_data/1,
         tests/0 % tests
        ]).

%% State
-record(fiState, {ip=0, %% IP
                  startip=undef, % IP of the start of the program
                  maxip=0, %% max assigned IP for memory management
                  stack, %% data stack
                  cstack, %% control stack
                  lstack, %% loop stack
                  memory, %% simulated memory array
                  defs,
                  vars
                 }).


%%%===================================================================
%%% API
%%%===================================================================
%%
start() ->
    spawn(fun () -> loop(prepare_state()) end).

%%
def_marker(Pid, Def) ->
    Ref = make_ref(),
    Pid ! {def_marker, self(), Ref, Def},
    receive
        {Pid, Ref, M} ->
            M
    end.

program_start_marker(Pid) ->
    Ref = make_ref(),
    Pid ! {program_start_marker, self(), Ref},
    receive
        {Pid, Ref, M} ->
            M
    end.

has_def(Pid, DefName) ->
    Ref = make_ref(),
    Pid ! {has_def, self(), Ref, DefName},
    receive
        {Pid, Ref, M} ->
            M
    end.

new_instruction(Pid, W) ->
    Ref = make_ref(),
    Pid ! {new_instruction, self(), Ref, W},
    receive
        {Pid, Ref, M} ->
            M
    end.

push_data(Pid, W) ->
    Ref = make_ref(),
    Pid ! {push_data, self(), Ref, W},
    receive {Pid, Ref, M} ->
            M
    end.

pop_data(Pid) ->
    Ref = make_ref(),
    Pid ! {pop_data, self(), Ref},
    receive {Pid, Ref, M} ->
            M
    end.

run(Pid) ->
    Ref = make_ref(),
    Pid ! {run, self(), Ref},
    receive {Pid, Ref, DataStack} ->
            DataStack
    end.

%%%===================================================================
%%% Internal functions
%%%===================================================================
%%
loop(State=#fiState{ip=IP, startip=Start,
                    memory=M, stack=S, cstack=CS,
                    maxip=MIP,defs=D,vars=V}) ->
    receive
        {def_marker, Pid, Ref, Def} ->
            {def, DefName} = Def,
            ets:insert(D, {DefName, user_defined_word(MIP)}),
            Pid ! {self(), Ref, {ok, def_marker, DefName}},
            loop(State);

        {program_start_marker, Pid, Ref} ->
            Pid ! {self(), Ref, {ok, program_start_marker, MIP}},
            loop(State#fiState{startip=MIP});

        {has_def, Pid, Ref, DefName} ->
            Pid ! {self(), Ref, {has_def, ets:lookup(D, DefName)}},
            loop(State);

        {new_instruction, Pid, Ref, W} ->
            Pid ! {self(), Ref, {ok, new_instruction}},
            loop(State#fiState{maxip=1+MIP,
                               memory=array:set(MIP, W, M)});

        {push_data, Pid, Ref, W} ->
            Pid ! {self(), Ref, {ok, push_data}},
            loop(State#fiState{stack=[W|S]});

        {pop_data, Pid, Ref} ->
            [Top|Rest] = S,
            Pid ! {self(), Ref, {ok, Top}},
            loop(State#fiState{stack=Rest});

        {run, Pid, Ref} ->
            NewState=do_run(State#fiState{ip=Start}),
            Pid ! {self(), Ref, {run, NewState#fiState.stack}};
            % END

        _ ->
            loop(State)
    end.

do_run(State=#fiState{ip=IP, memory=M, stack=S, cstack=CS,
                      defs=D,vars=V}) ->
    case array:get(IP, M) of
        {plainid, "END"} ->
            State;
        % END

        {plainid, ID} ->
            [{_, Fun}] = ets:lookup(D, ID),
            do_run(Fun(State));

        X={T, _V} when T =:= string orelse T =:= number ->
            % Push
            do_run(State#fiState{ip=1+IP,stack=[X|S]})
    end.

%% Operators that are in the defs.
user_defined_word(IP) ->
    fun(S=#fiState{cstack=CS, ip=CIP}) ->
            S#fiState{cstack=[1+CIP|CS], ip=IP}
    end.

%% EMIT
emit_word(State=#fiState{stack=[H|S], ip=IP}) ->
    {number, Val} = H,
    io:format("~c", [round(Val)]),
    State#fiState{stack=S, ip=1+IP}.

%% PRINTLN
println_word(State=#fiState{stack=[H|S], ip=IP}) ->
    {Type, Val} = H,
    case Type of
        string -> io:format("~s~n", [Val]);
        _ -> io:format("~p~n", [Val])
    end,
    State#fiState{stack=S, ip=1+IP}.

%% ';'. End of definition
semicolon_word(State=#fiState{cstack=[H|CS]}) ->
    State#fiState{cstack=CS, ip=H}.

%% '+'
plus_word(State=#fiState{stack=[E1,E2|S], ip=IP}) ->
    {number, N1} = E1,
    {number, N2} = E2,
    State#fiState{stack=[{number,N1+N2}|S], ip=1+IP}.

%% '*'
star_word(State=#fiState{stack=[E1,E2|S], ip=IP}) ->
    {number, N1} = E1,
    {number, N2} = E2,
    State#fiState{stack=[{number,N1*N2}|S], ip=1+IP}.

%% DUP
dup_word(State=#fiState{stack=[E|S], ip=IP}) ->
    State#fiState{stack=[E,E|S], ip=1+IP}.

%% SWAP
swap_word(State=#fiState{stack=[E1,E2|S], ip=IP}) ->
    State#fiState{stack=[E2,E1|S], ip=1+IP}.

%% DROP
drop_word(State=#fiState{stack=[_E|S], ip=IP}) ->
    State#fiState{stack=S, ip=1+IP}.

%% aux
find_else_or_then_counting_ifs(Memory, IP, IFCount) ->
    case array:get(IP, Memory) of
        {plainid, Word}
          when IFCount =:= 0 andalso (Word == "ELSE" orelse Word == "THEN") ->
            IP+1;
        {plainid, "IF"} ->
            find_else_or_then_counting_ifs(Memory, IP+1, IFCount+1);
        {plainid, "THEN"} ->
            find_else_or_then_counting_ifs(Memory, IP+1, IFCount-1);
        _ ->
            find_else_or_then_counting_ifs(Memory, IP+1, IFCount)
    end.

%% aux
find_then_counting_ifs(Memory, IP, IFCount) ->
    case array:get(IP, Memory) of
        {plainid, "THEN"} when IFCount =:= 0 ->
            IP+1;
        {plainid, "IF"} ->
            find_then_counting_ifs(Memory, IP+1, IFCount+1);
        {plainid, "THEN"} ->
            find_then_counting_ifs(Memory, IP+1, IFCount-1);
        _ ->
            find_then_counting_ifs(Memory, IP+1, IFCount)
    end.


%% IF
if_word(State=#fiState{stack=[C|S], memory=M, ip=IP}) ->
    NIP = case C of
              {number, N} when N == 0 ->
                  find_else_or_then_counting_ifs(M, IP+1, 0);
              _ -> IP+1
          end,
    State#fiState{stack=S, ip=NIP}.

%% ELSE
else_word(State=#fiState{memory=M, ip=IP}) ->
    NIP = find_then_counting_ifs(M, IP+1, 0),
    State#fiState{ip=NIP}.

%% THEN
then_word(State=#fiState{ip=IP}) ->
    State#fiState{ip=1+IP}.

%% aux
find_loop_counting_dos(Memory, IP, DOCount) ->
    case array:get(IP, Memory) of
        {plainid, L} when DOCount =:= 0
                          andalso (L == "LOOP" orelse L == "+LOOP") ->
            IP+1;
        {plainid, "DO"} ->
            find_loop_counting_dos(Memory, IP+1, DOCount+1);
        {plainid, L} when L == "LOOP" orelse L == "+LOOP" ->
            find_loop_counting_dos(Memory, IP+1, DOCount-1);
        _ ->
            find_loop_counting_dos(Memory, IP+1, DOCount)
    end.


%% DO
do_word(State=#fiState{memory=M,
                       stack=[{number,To},{number,From}|S],
                       cstack=CS,lstack=LS,ip=IP}) ->
    %% Special case: To == From
    if To == From ->
            NIP = find_loop_counting_dos(M, 1+IP, 0),
            State#fiState{stack=S, ip=NIP};
       true ->
            State#fiState{lstack=[From,To|LS],
                          cstack=[1+IP|CS],stack=S,ip=1+IP}
    end.

%% I
i_word(State=#fiState{stack=S,lstack=[From|_LS],ip=IP}) ->
    State#fiState{stack=[{number,From}|S],ip=1+IP}.

%% LOOP
loop_word(State=#fiState{lstack=[From,To|LS],cstack=[LastDo|CS],ip=IP}) ->
    if From-1 == To ->
            State#fiState{cstack=CS,lstack=LS,ip=IP+1};
       true ->
            State#fiState{lstack=[From-1,To|LS],ip=LastDo}
    end.

%% +LOOP
plusloop_word(State=#fiState{lstack=[From,To|LS],cstack=[LastDo|CS],ip=IP}) ->
    if From+1 == To ->
            State#fiState{cstack=CS,lstack=LS,ip=1+IP};
       true ->
            State#fiState{lstack=[From+1,To|LS],ip=LastDo}
    end.

%% STRLEN
strlen_word(State=#fiState{stack=[Str|S],ip=IP}) ->
    {_T,String} = Str,
    State#fiState{stack=[{number,length(String)}|S],ip=1+IP}.

%% binary comparators
binary_comp_word(Fun) ->
    fun(State=#fiState{stack=[E1,E2|S], ip=IP}) ->
            Result =
                case {E1,E2} of
                    {{T,V1},{T,V2}} when T =:= string orelse T =:= number ->
                        Z = Fun(V2,V1),
                        if Z =:= true -> 1; true -> 0 end;
                    _ -> 0
                end,
            State#fiState{stack=[{number,Result}|S], ip=1+IP}
    end.

%% 0<
zero_less_word(State=#fiState{stack=[E|S], ip=IP}) ->
    Result = if E < 0 -> 1; true -> 0 end,
    State#fiState{stack=[{number,Result}|S], ip=1+IP}.

%% 0>
zero_greater_word(State=#fiState{stack=[E|S], ip=IP}) ->
    Result = if E > 0 -> 1; true -> 0 end,
    State#fiState{stack=[{number,Result}|S], ip=1+IP}.

%% 0=
zero_equal_word(State=#fiState{stack=[E|S], ip=IP}) ->
    Result = if E == 0 -> 1; true -> 0 end,
    State#fiState{stack=[{number,Result}|S], ip=1+IP}.

prepare_state() ->
    Defs = ets:new(definitions,[set]),
    % Insert predefined functions
    ets:insert(Defs, {"EMIT", fun emit_word/1}),
    ets:insert(Defs, {"PRINTLN", fun println_word/1}),
    ets:insert(Defs, {";", fun semicolon_word/1}),
    ets:insert(Defs, {"+", fun plus_word/1}),
    ets:insert(Defs, {"*", fun star_word/1}),
    ets:insert(Defs, {"DUP", fun dup_word/1}),
    ets:insert(Defs, {"SWAP", fun swap_word/1}),
    ets:insert(Defs, {"DROP", fun drop_word/1}),
    ets:insert(Defs, {"IF", fun if_word/1}),
    ets:insert(Defs, {"THEN", fun then_word/1}),
    ets:insert(Defs, {"ELSE", fun else_word/1}),
    ets:insert(Defs, {"DO", fun do_word/1}),
    ets:insert(Defs, {"I", fun i_word/1}),
    ets:insert(Defs, {"LOOP", fun loop_word/1}),
    ets:insert(Defs, {"+LOOP", fun plusloop_word/1}),
    ets:insert(Defs, {"STRLEN", fun strlen_word/1}),
    ets:insert(Defs, {"<", binary_comp_word(fun(X,Y)->X<Y end)}),
    ets:insert(Defs, {"==", binary_comp_word(fun(X,Y)->X==Y end)}),
    ets:insert(Defs, {">", binary_comp_word(fun(X,Y)->X>Y end)}),
    ets:insert(Defs, {">=", binary_comp_word(fun(X,Y)->X>=Y end)}),
    ets:insert(Defs, {"<=", binary_comp_word(fun(X,Y)->X=<Y end)}),
    ets:insert(Defs, {"<>", binary_comp_word(fun(X,Y)->X/=Y end)}),
    ets:insert(Defs, {"0<", fun zero_less_word/1}),
    ets:insert(Defs, {"0>", fun zero_greater_word/1}),
    ets:insert(Defs, {"0=", fun zero_equal_word/1}),
    #fiState{stack = [], %% data stack
             cstack = [], %% control stack
             lstack = [], %% loop stack
             memory = array:new( [{size, 1024*1024}, fixed] ),
             defs = Defs,
             vars = ets:new(variables, [set])}.


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% TESTS
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
tests() ->
    test1(),
    test2(),
    test3(),
    test4(),
    test_if1(),
    test_if2(),
    test5(),
    test6(),
    test7(),
    test8(),
    test9(),
    test10().


test1() ->
    FI = start(),
    program_start_marker(FI),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {plainid, "EMIT"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test2() ->
    FI = start(),
    program_start_marker(FI),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {plainid, "PRINTLN"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test3() ->
    FI = start(),
    program_start_marker(FI),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {plainid, "+"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test4() ->
    FI = start(),
    program_start_marker(FI),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {plainid, "DUP"}),
    new_instruction(FI, {plainid, "+"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test_if1() ->
    FI = start(),
    program_start_marker(FI),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {plainid, "IF"}),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {plainid, "ELSE"}),
    new_instruction(FI, {number, 43}),
    new_instruction(FI, {plainid, "THEN"}),
    new_instruction(FI, {plainid, "EMIT"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test_if2() ->
    FI = start(),
    program_start_marker(FI),
    new_instruction(FI, {number, 0}),
    new_instruction(FI, {plainid, "IF"}),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {plainid, "ELSE"}),
    new_instruction(FI, {number, 43}),
    new_instruction(FI, {plainid, "THEN"}),
    new_instruction(FI, {plainid, "EMIT"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test5() ->
    FI = start(),
    def_marker(FI, {def, "STAR"}),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {plainid, "EMIT"}),
    new_instruction(FI, {plainid, ";"}),
    program_start_marker(FI),
    new_instruction(FI, {plainid, "STAR"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test6() ->
    FI = start(),
    def_marker(FI, {def, "STARS"}),
    new_instruction(FI, {number, 0}),
    new_instruction(FI, {plainid, "DO"}),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {plainid, "EMIT"}),
    new_instruction(FI, {plainid, "LOOP"}),
    new_instruction(FI, {plainid, ";"}),
    program_start_marker(FI),
    new_instruction(FI, {number, 20}),
    new_instruction(FI, {plainid, "STARS"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test7() ->
    FI = start(),
    def_marker(FI, {def, "STARS"}),
    new_instruction(FI, {number, 0}),
    new_instruction(FI, {plainid, "DO"}),
    new_instruction(FI, {number, 43}),
    new_instruction(FI, {plainid, "EMIT"}),
    new_instruction(FI, {plainid, "LOOP"}),
    new_instruction(FI, {plainid, ";"}),
    program_start_marker(FI),
    new_instruction(FI, {number, 20}),
    new_instruction(FI, {number, 0}),
    new_instruction(FI, {plainid, "DO"}),
    new_instruction(FI, {plainid, "I"}),
    new_instruction(FI, {plainid, "STARS"}),
    new_instruction(FI, {string, ""}),
    new_instruction(FI, {plainid, "PRINTLN"}),
    new_instruction(FI, {plainid, "LOOP"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test8() ->
    FI = start(),
    def_marker(FI, {def, "STARS"}),
    new_instruction(FI, {number, 0}),
    new_instruction(FI, {plainid, "DO"}),
    new_instruction(FI, {number, 42}),
    new_instruction(FI, {plainid, "EMIT"}),
    new_instruction(FI, {plainid, "LOOP"}),
    new_instruction(FI, {plainid, ";"}),
    program_start_marker(FI),
    new_instruction(FI, {number, 0}),
    new_instruction(FI, {number, 20}),
    new_instruction(FI, {plainid, "DO"}),
    new_instruction(FI, {plainid, "I"}),
    new_instruction(FI, {plainid, "STARS"}),
    new_instruction(FI, {string, ""}),
    new_instruction(FI, {plainid, "PRINTLN"}),
    new_instruction(FI, {plainid, "+LOOP"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test9() ->
    FI = start(),
    program_start_marker(FI),
    new_instruction(FI, {string, "abcdef"}),
    new_instruction(FI, {plainid, "STRLEN"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).

test10() ->
    FI = start(),
    program_start_marker(FI),
    new_instruction(FI, {string, "abcdef"}),
    new_instruction(FI, {plainid, "STRLEN"}),
    new_instruction(FI, {number, 5}),
    new_instruction(FI, {plainid, ">"}),
    new_instruction(FI, {plainid, "IF"}),
    new_instruction(FI, {string, "Si!"}),
    new_instruction(FI, {plainid, "ELSE"}),
    new_instruction(FI, {string, "No!"}),
    new_instruction(FI, {plainid, "THEN"}),
    new_instruction(FI, {plainid, "PRINTLN"}),
    new_instruction(FI, {plainid, "END"}),
    run(FI).
