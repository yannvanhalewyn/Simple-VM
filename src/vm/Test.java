package vm;

import static vm.Bytecode.*;
import static vm.ExamplePrograms.*;

public class Test {

  public static void main(String[] args) {
    int stackSize = 100;
    Program program = fibonacci; // Checkout vm.SamplePrograms for more
    VM vm = new VM(program, stackSize);
    vm.trace = false;
    vm.cpu();
  }

}
