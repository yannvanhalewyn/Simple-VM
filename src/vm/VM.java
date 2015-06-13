package vm;

import static vm.Bytecode.*;

public class VM {
  int[] data;
  int[] code;
  int[] stack;

  int ip;
  int sp = -1;
  int fp;

  boolean trace = false;

  public VM(int[] code, int main, int dataSize) {
    this.code = code;
    this.ip = main;
    this.data = new int[dataSize];
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
          break;
        case IMUL:
          break;
        case ILT:
          break;
        case IEQ:
          break;
        case BR:
          break;
        case BRT:
          break;
        case BRF:
          break;

        case ICONST:
          stack[++sp] = code[ip++];
          break;

        case LOAD:
          break;

        case GLOAD:
          stack[++sp] = data[code[ip++]];
          break;

        case STORE:
          break;

        case GSTORE:
          data[code[ip++]] = stack[sp--];
          break;

        case PRINT:
          System.out.println("\n" +stack[sp--]);
          break;

        case POP:
          break;

        case HALT:
          System.out.println();
          return;
      }
      if (trace) {
        System.err.println(stackString());
      }
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

}
