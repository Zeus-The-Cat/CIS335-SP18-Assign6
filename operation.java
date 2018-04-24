package assembler;

public class Operation {

    private String _format;
    private String _mnemonic;
    private String _opcode;
    
    public Operation(String mnemonic, String format, String opcode) {
        _mnemonic = mnemonic;
        _opcode = opcode;
        _format = format;
    }
    
    public String format() {
        return _format;
    }
    
    public String mnemonic() {
        return _mnemonic;
    }
    
    public String opcode() {
        return _opcode;
    }
}
