uForth
======

Micro Forth (uForth), a model-based implementation of a Forth-like
language interpreter in Java and Erlang.

## Introduction ##

This repository contains three projects:

- **uForth** (under the directory `eclipse-workspace`): Includes
  the Eclipse Modeling Framework (EMF) Ecore meta-model representing
  static instances of a uForth program. It also includes a reader (a
  program that interprets uForth programs and converts them into
  instances of the uForth metamodel) and an interpreter (incomplete by
  now, but easily understandable).
- **uForthProgGen** (under the directory `eclipse-workspace`):
  Includes a Xpand program that converts instances of the uForth
  metamodel into the original program (modulo comments and
  indentation). It is used to show my students how to process a model
  to generate code. It could be used to generate machine code (a
  compiler, for instance) or, as the assignment for my students, to
  generate Erlang code that uses the next project to run.
- **forth_interpreter.erl** (under the directory `erlang`): It
  includes an Erlang interpreter for the uForth language. The
  interpreter is able to run programs, but it does not contain a
  reader, so programs have to be input using the module API. I'll show
  examples below.

## uForth ##

uForth (micro-Forth) is a variant of
[Forth](http://www.forth.com/starting-forth/) that treats strings as
an independent token. Also, it only includes one type of number, a
double precision floating point number (similar to a Java `double`).
So, an uForth program is a sequence of *words*. A *word* in uForth can
be of three different types:

- **Strings**: Any set of characters delimited by double quotes. For
  example `"Hello"`.
- **Numbers**: Double precision floating point number. Ex: `1.23`.
- **Identifiers**: Any set of chars not included within the two above
  word types. Usually in upper case. For instance, `DUP`.

As in normal Forth, definitions start with the word `:` and end with
the word `;`. Finally, programs end with `END`.

Following the examples in the cited Starting Forth, an example uForth
program that can be used as reference is:

    : STAR 42 EMIT ;
    : STARS 0 DO STAR LOOP ;

    20 STARS END

The previous program writes 20 stars in the screen.

The project includes a standard implementation of an EMF Ecore
metamodel representing static uForth programs. Using a genmodel, the
Java classes are generated for manipulating models of that metamodel,
and allows populating models from uForth programs.

The `ForthReader` class (within package `es.um.ssdd.uForth.main`)
reads a uForth program and produces a model of that program (that
conforms to the uForth metamodel).

Using uForth models previously generated by the reader, the
`ForthInterpreterBare` class (within package `es.um.ssdd.uForth.main`)
can run uForth programs. The interpreter is not complete at the
moment, and includes just a few system words, but can be taken as an
example of building an interpreter. Also, the interpreter is not
optimized, as could include a previous "compiling" phase that would
optimize location for jumps for ifs and loops. I will implement these
optimizations in the future.

## uForthProgGen ##

This is an example project that uses Xpand to produce the original
uForth program from a model. It could be used as a bare-bones of a
code generator in any language that implements the instructions of the
uForth program. It us used in fact by my students as an example for
generating code for the following project in Erlang.

## forth_interpreter.erl ##

This erlang module is implemented as a server (in the future it will
be a normal `gen_server`), and, given a constructed uForth program, it
is able to run it in a simulated memory. Again, it does not contain
optimizations, but it works. As can be seen, the code for using the
interpreter from a uForth program could be generated easily by the
`uForthProgGen` project (exactly the assignment for my students, so
it is not shown).

The API for the server is easy. It is shown via an example of how to
build a program with a definition, and how to run it:

    FI = forth_interpreter:start(),
    forth_interpreter:def_marker(FI, {def, "STARS"}),
    forth_interpreter:new_instruction(FI, {number, 0}),
    forth_interpreter:new_instruction(FI, {plainid, "DO"}),
    forth_interpreter:new_instruction(FI, {number, 42}),
    forth_interpreter:new_instruction(FI, {plainid, "EMIT"}),
    forth_interpreter:new_instruction(FI, {plainid, "LOOP"}),
    forth_interpreter:new_instruction(FI, {plainid, ";"}),
    forth_interpreter:program_start_marker(FI),
    forth_interpreter:new_instruction(FI, {number, 20}),
    forth_interpreter:new_instruction(FI, {plainid, "STARS"}),
    forth_interpreter:new_instruction(FI, {plainid, "END"}),
    forth_interpreter:run(FI).

Each definition starts with a call to `def_marker/2`, and tells the
interpreter that a new definition starts at the point in memory. When
the program is meant to start, a call to `program_start_marker/1` tells the
interpreter so, and the following words form he program itself.

Tests in the module are written *ad-hoc* but will be enhanced in the
future.

Each system word in the module is implemented as a function that
transform the `fiState` record that holds the state of the
interpreter. For instance, for the `+` system word:

    plus_word(State=#fiState{stack=[E1,E2|S], ip=IP}) ->
        {number, N1} = E1,
        {number, N2} = E2,
        State#fiState{stack=[{number,N1+N2}|S], ip=1+IP}.
