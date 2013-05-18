uForth
======

Micro Forth (uForth), a model-based implementation of a Forth-like
language interpreter in Java and Erlang.

## Introduction ##

This repository contains three projects:

- uForth (under the directory `eclipse-juno-workspace`): Includes the
  Eclipse Modeling Framework (EMF) Ecore meta-model representing
  static instances of a uForth program. It also includes a reader (a
  program that interprets uForth programs and converts them into
  instances of the uForth metamodel) and an interpreter (incomplete by
  now, but easily understandable).
- uForthProgGen (under the directory `eclipse-juno-workspace`)
