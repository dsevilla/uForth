%%%-------------------------------------------------------------------
%%% @author Diego Sevilla Ruiz <dsevilla@ditec.um.es>
%%% @copyright (C) 2013, Diego Sevilla Ruiz
%%% @doc
%%% uForth interpreter, gen_server version.
%%% @end
%%% Created : 29 Jun 2013 by Diego Sevilla Ruiz <dsevilla@ditec.um.es>
%%%-------------------------------------------------------------------
-module(forth_interpreter_gen_server).

-behaviour(gen_server).

%% API
-export([start_link/0,def_marker/2,program_start_marker/1,
         has_def/2,new_instruction/2,run/1,
         push_data/2,pop_data/1,
         tests/0 % tests
        ]).


%% gen_server callbacks
-export([init/1, handle_call/3, handle_cast/2, handle_info/2,
         terminate/2, code_change/3]).

-define(SERVER, ?MODULE). 

-record(state, 
        {ip=0, %% IP
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

def_marker(Def) ->
    gen_server:call(?MODULE, {def_marker, Def}).

program_start_marker() ->
    gen_server:call(?MODULE, program_start_marker).

has_def(DefName) ->
    gen_server:call(?MODULE, {has_def, DefName}).

new_instruction(W) ->
    gen_server:call(?MODULE, {new_instruction, W}).

push_data(W) ->
    gen_server:call(?MODULE, {push_data, W}).

pop_data() ->
    gen_server:call(?MODULE, pop_data).

run() ->
    gen_server:cast(?MODULE, run). % async


%%--------------------------------------------------------------------
%% @doc
%% Starts the server
%%
%% @spec start_link() -> {ok, Pid} | ignore | {error, Error}
%% @end
%%--------------------------------------------------------------------
start_link() ->
    gen_server:start_link({local, ?SERVER}, ?MODULE, [], []).

%%%===================================================================
%%% gen_server callbacks
%%%===================================================================

%%--------------------------------------------------------------------
%% @private
%% @doc
%% Initializes the server
%%
%% @spec init(Args) -> {ok, State} |
%%                     {ok, State, Timeout} |
%%                     ignore |
%%                     {stop, Reason}
%% @end
%%--------------------------------------------------------------------
init([]) ->
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
    {ok, #state{stack = [], %% data stack
                cstack = [], %% control stack
                lstack = [], %% loop stack
                memory = array:new( [{size, 1024*1024}, fixed] ),
                defs = Defs,
                vars = ets:new(variables, [set])}.

%%--------------------------------------------------------------------
%% @private
%% @doc
%% Handling call messages
%%
%% @spec handle_call(Request, From, State) ->
%%                                   {reply, Reply, State} |
%%                                   {reply, Reply, State, Timeout} |
%%                                   {noreply, State} |
%%                                   {noreply, State, Timeout} |
%%                                   {stop, Reason, Reply, State} |
%%                                   {stop, Reason, State}
%% @end
%%--------------------------------------------------------------------
handle_call({def_marker, Def}, _From, State=#state{defs=D,maxip=MIP}) ->
    {def, DefName} = Def,
    ets:insert(D, {DefName, user_defined_word(MIP)}),
    Reply = ok,
    {reply, Reply, State}.

%%--------------------------------------------------------------------
%% @private
%% @doc
%% Handling cast messages
%%
%% @spec handle_cast(Msg, State) -> {noreply, State} |
%%                                  {noreply, State, Timeout} |
%%                                  {stop, Reason, State}
%% @end
%%--------------------------------------------------------------------
handle_cast(_Msg, State) ->
    {noreply, State}.

%%--------------------------------------------------------------------
%% @private
%% @doc
%% Handling all non call/cast messages
%%
%% @spec handle_info(Info, State) -> {noreply, State} |
%%                                   {noreply, State, Timeout} |
%%                                   {stop, Reason, State}
%% @end
%%--------------------------------------------------------------------
handle_info(_Info, State) ->
    {noreply, State}.

%%--------------------------------------------------------------------
%% @private
%% @doc
%% This function is called by a gen_server when it is about to
%% terminate. It should be the opposite of Module:init/1 and do any
%% necessary cleaning up. When it returns, the gen_server terminates
%% with Reason. The return value is ignored.
%%
%% @spec terminate(Reason, State) -> void()
%% @end
%%--------------------------------------------------------------------
terminate(_Reason, _State) ->
    ok.

%%--------------------------------------------------------------------
%% @private
%% @doc
%% Convert process state when code is changed
%%
%% @spec code_change(OldVsn, State, Extra) -> {ok, NewState}
%% @end
%%--------------------------------------------------------------------
code_change(_OldVsn, State, _Extra) ->
    {ok, State}.

%%%===================================================================
%%% Internal functions
%%%===================================================================
