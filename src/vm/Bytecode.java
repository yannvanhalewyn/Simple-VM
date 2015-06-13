package vm;

public class Bytecode {

  public static final int IADD   = 1;      // Int add
  public static final int ISUB   = 2;      // Int subtract
  public static final int IMUL   = 3;      // Int multiply
  public static final int ILT    = 4;      // Int less than
  public static final int IEQ    = 5;      // Int equal
  public static final int BR     = 6;      // Branch
  public static final int BRT    = 7;      // Branch if true
  public static final int BRF    = 8;      // Branch if false
  public static final int ICONST = 9;      // Push constant int
  public static final int LOAD   = 10;     // Load local var
  public static final int GLOAD  = 11;     // Load global var
  public static final int STORE  = 12;     // Store local var
  public static final int GSTORE = 13;     // Store global var
  public static final int PRINT  = 14;     // Print stack top and pop
  public static final int POP    = 15;     // Throw away top of stack
  public static final int HALT   = 16;     // exit program
  public static final int CALL   = 17;     // call function
  public static final int RET    = 18;     // Return from function

  public static class Instruction {
    String name;
    int nOpnds = 0;
    public Instruction(String name) { this(name, 0); }
    public Instruction(String name, int nOpnds) {
      this.name = name;
      this.nOpnds = nOpnds;
    }
  }

  static Instruction[] opcodes = {
    null,
    new Instruction("IADD"),
    new Instruction("ISUB"),
    new Instruction("IMUL"),
    new Instruction("ILT"),
    new Instruction("IEQ"),
    new Instruction("BR", 1),
    new Instruction("BRT", 1),
    new Instruction("BRF", 1),
    new Instruction("ICONST", 1),
    new Instruction("LOAD", 1),
    new Instruction("GLOAD", 1),
    new Instruction("STORE", 1),
    new Instruction("GSTORE", 1),
    new Instruction("PRINT"),
    new Instruction("POP"),
    new Instruction("HALT"),
    new Instruction("CALL", 2),
    new Instruction("RET")
  };

}
