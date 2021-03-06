package vm;

import static vm.Bytecode.*;

public class ExamplePrograms {

/*
 * =============================================
 * Some Programs (arrays of ints = instructions)
 * =============================================
 */

  // Prints out all natural integers between 1 and 10 (including)
  static Program countToTen = new Program(0, 2, new int[]{
    ICONST, 1,
    GSTORE, 0,
    ICONST, 0,
    GSTORE, 1,
    GLOAD, 0,
    GLOAD, 1,
    IADD,
    GSTORE, 1,
    GLOAD, 1,
    PRINT,
    GLOAD, 1,
    ICONST, 10,
    ILT,
    BRT, 8,
    HALT
  });

  // Demonstrates the stacking of CALL
  static Program simpleFunctionCall = new Program(0, 2, new int[]{
    // MAIN
    CALL, 5, 0,
    PRINT,
    HALT,
    // Return 30
    ICONST, 30,
    RET
  });

  static Program divide = new Program(28, 1, new int[]{
// Def DIV(x, y) x is at fp-4, y is at fp-3
    LOAD, -4,       // 0
    LOAD, -3,       // 2
    ILT,            // 4
    BRF, 10,        // 5
    GLOAD, 0,       // 7
    RET,            // 9

// Increment counter
    GLOAD, 0,       // 10
    ICONST, 1,      // 12
    IADD,           // 14
    GSTORE, 0,      // 15
// DIV(x-y, y)
    LOAD, -4,       // 17
    LOAD, -3,       // 19
    ISUB,           // 21
    LOAD, -3,       // 22
    CALL, 0, 2,     // 24
    RET,            // 27

// MAIN
    ICONST, 405,    // 28 (Divident)
    ICONST, 45,     // 30 (Divisor)
    ICONST, 0,      // 32 (Global counter)
    GSTORE, 0,      // 34
    CALL, 0, 2,     // 36
    PRINT,          // 39
    HALT            // 40
  });

  // Returns the factorial of input (mem addr 23)
  static Program factorial = new Program(22, 0, new int[]{
  // Factorial: Args=1, LOCALS=0     MEMADDR
    LOAD, -3,                      // 0
    ICONST, 2,                     // 2
    ILT,                           // 4
    BRF, 10,                       // 5
    ICONST, 1,                     // 7
    RET,                           // 9
  // Return N * FACT(N-1)
    LOAD, -3,                      // 10
    LOAD, -3,                      // 12
    ICONST, 1,                     // 14
    ISUB,                          // 16
    CALL, 0, 1,                    // 17
    IMUL,                          // 20
    RET,                           // 21
  // MAIN
    ICONST, 5,                     // 22
    CALL, 0, 1,                    // 24
    PRINT,                         // 27
    HALT                           // 28
  });

  // Prints out the value of the Fibonacci serie at given index (mem addr 29)
  // SETUP: mainip = 22, datasize = 0
  // For input > 25, the VM requires a bigger stackSize than 100
  static Program fibonacci = new Program(28, 0, new int[]{
// FIB(N)                          MEMADDR
    LOAD, -3,                      // 0
    ICONST, 3,                     // 2,
    ILT,                           // 4
    BRF, 10,                       // 5
    ICONST, 1,                     // 7
    RET,                           // 9

// Return FIB(n-1) + FIB(n-2)
    // FIB(n-1)
    LOAD, -3,                      // 10
    ICONST, 1,                     // 12
    ISUB,                          // 14
    CALL, 0, 1,                    // 15
    // FIB(n-2)
    LOAD, -3,                      // 18
    ICONST, 2,                     // 20
    ISUB,                          // 22
    CALL, 0, 1,                    // 23
    // return FIB(n-1) + FIB(n-2)
    IADD,                          // 26
    RET,                           // 27

// MAIN
    ICONST, 8,                     // 28 ! MAIN INPUT FIB(x)
    CALL, 0, 1,                    // 32
    PRINT,                         // 35
    HALT                           // 36
  });

}
