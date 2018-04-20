package assign6;

public class Operation {
    private String opcode;
    private String format;
    
    public Operation(String format, String opcode) {
        this.opcode = opcode;
        this.format = format;
    }
    
    public String opcode() {
        return opcode;
    }
    
    public String format() {
        return format;
    }
    
    @Override
    public String toString() {
      return String.format(format + ", " + opcode);
    }
}