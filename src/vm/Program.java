package vm;

public class Program {

  int[] code;
  int mainip;
  int dataSize;

  public Program(int mainip, int dataSize, int[] code)  {
    this.code = code;
    this.mainip = mainip;
    this.dataSize = dataSize;
  }

}
