A simple JAVA-Based Virtual Machine
===================================

This was written as a personal exercice after watching [this](https://newcircle.com/s/post/1617/how_to_build_a_virtual_machine_terrence_parr_video) great presentation about VM's by Terence Parr.

**NOTE**: I built this in order to learn the basics of VM's, and learn some Java while I was at it. It's an extremely simplistic implementation!

BUILD
-----

There's a makefile. In the project root, simply run `make` to build, or `make run` to build and run. `make clean` cleans up the built objects.

INFO
----

It handles 18 basic bytecode instructions, including calling a function whilst preserving state. Check out vm.Bytecode to see all 18 Instructions.

To run a program, simply create an int[] array with any instruction set and hand it over to the VM. Setting the `trace` property to `true` will print the stack trace as the program runs. See the main function in vm.Test for more information.

