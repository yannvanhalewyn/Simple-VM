package vm;

import static vm.Bytecode.*;

public class Test {

  static int[] hello = {
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
    ICONST, 100000,
    ILT,
    BRT, 8,
    HALT
  };

  public static void main(String[] args) {
    int dataSize = 2;
    int mainip = 0;
    VM vm = new VM(hello, mainip, dataSize);
    vm.trace = false;
    vm.cpu();
  }

}
