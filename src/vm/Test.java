package vm;

import static vm.Bytecode.*;

public class Test {

  static int[] hello = {
    ICONST, 99,
    GSTORE, 0,
    GLOAD, 0,
    PRINT,
    HALT
  };

  public static void main(String[] args) {
    int dataSize = 1;
    int mainip = 0;
    VM vm = new VM(hello, mainip, dataSize);
    vm.trace = true;
    vm.cpu();
  }

}
