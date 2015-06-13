package vm;

import static vm.Bytecode.*;

public class VM {
  int[] globals;
  int[] code;
  int[] stack;

  int ip;
  int sp = -1;
  int fp;

  static final int TRUE = 1;
  static final int FALSE = 0;

  boolean trace = false;

  public VM(int[] code, int main, int dataSize) {
    this.code = code;
    this.ip = main;
    this.globals = new int[dataSize];
    stack = new int[100];
  }

  public void cpu() {
    while (ip < code.length) {
      if (trace) {
        System.err.printf("%-30s", dissassemble());
      }
      int opcode = code[ip++];
      switch(opcode) {

        case IADD:
          int b = stack[sp--];
          int a = stack[sp--];
          stack[++sp] = a + b;
          break;

        case ISUB:
          b = stack[sp--];
          a = stack[sp--];
          stack[++sp] = a - b;
          break;

        case IMUL:
          break;
        case ILT:
          b = stack[sp--];
          a = stack[sp--];
          stack[++sp] = (a < b) ? TRUE : FALSE;
          break;

        case IEQ:
          b = stack[sp--];
          a = stack[sp--];
          stack[++sp] = (a == b) ? TRUE : FALSE;
          break;

        case BR:
          ip = code[ip++];
          break;

        case BRT:
          int addr = code[ip++];
          if(stack[sp--] == TRUE) ip = addr;
          break;

        case BRF:
          addr = code[ip++];
          if(stack[sp--] == FALSE) ip = addr;
          break;

        case ICONST:
          stack[++sp] = code[ip++];
          break;

        case LOAD:
          break;

        case GLOAD:
          addr = code[ip++];
          int v = globals[addr];
          stack[++sp] = v;
          break;

        case STORE:
          break;

        case GSTORE:
          v = stack[sp--];
          addr = code[ip++];
          globals[addr] = v;
          break;

        case PRINT:
          System.out.println(stack[sp--]);
          break;

        case POP:
          break;

        case HALT:
          if (trace) dumpDataMemory();
          return;
      }
      if (trace) System.err.println(stackString());
    }
  }

  private String dissassemble() {
    int opcode = code[ip];
    String opName = Bytecode.opcodes[opcode].name;
    StringBuilder buf = new StringBuilder();
    buf.append(String.format("%04d:\t%-11s", ip, opName));
    for (int i = 1; i <= opcodes[opcode].nOpnds; i++) {
      buf.append(code[ip + i] + " ");
    }
    return buf.toString();
  }

  private String stackString() {
    StringBuilder buf = new StringBuilder();
    buf.append("stack:[");
    for (int i = 0; i <= sp; i++) {
      buf.append(stack[i] + " ");
    }
    buf.append("]");
    return buf.toString();
  }

  private void dumpDataMemory() {
    System.err.println("\nData memory:");
    int addr = 0;
    for (int o : globals) {
      System.out.printf("%04d: %s\n", addr, o);
      addr++;
    }
    System.err.println();
  }
}
