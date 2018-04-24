package assembler;

public class HeaderRecord implements Record {

    private final int _startAddress;
    private final int _programLength;
    private final String _programName;
    
    public HeaderRecord(String name, int startAddr, int length) {
    
        _startAddress = startAddr;
        _programLength = length;
        _programName = name;
        
    }
    
    @Override
    public String toObjectProgram() {
    
        return String.format("H%1$-6s%2$06X%3$06X", _programName, _startAddress, _programLength);
        
    }
    
}
