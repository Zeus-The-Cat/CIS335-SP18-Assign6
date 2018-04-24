package assign6;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


public class GenerateOpTable {    
private static final Map<String, Operation> OperationTable;
    
    static {
       OperationTable = new HashMap<>();
       
       OperationTable.put("ADDR",  new Operation("2",   "90"));
       OperationTable.put("COMPR", new Operation("2",   "A0"));
       OperationTable.put("SUBR",  new Operation("2",   "94"));
       OperationTable.put("ADD",   new Operation("3/4", "18"));
       OperationTable.put("SUB",   new Operation("3/4", "1C"));
       OperationTable.put("MUL",   new Operation("3/4", "20"));
       OperationTable.put("DIV",   new Operation("3/4", "24"));
       OperationTable.put("COMP",  new Operation("3/4", "28"));
       OperationTable.put("J",     new Operation("3/4", "3C"));
       OperationTable.put("JEQ",   new Operation("3/4", "30"));
       OperationTable.put("JGT",   new Operation("3/4", "34"));
       OperationTable.put("JLT",   new Operation("3/4", "38"));
       OperationTable.put("JSUB",  new Operation("3/4", "48"));
       OperationTable.put("LDCH",  new Operation("3/4", "50"));
       OperationTable.put("RSUB",  new Operation("3/4", "4C"));
       OperationTable.put("TIX",   new Operation("3/4", "2C"));
       OperationTable.put("TIXR",  new Operation("2",   "B8"));
       OperationTable.put("RD",    new Operation("3/4", "D8"));
       OperationTable.put("TD",    new Operation("3/4", "E0"));
       OperationTable.put("WD",    new Operation("3/4", "DC"));
       OperationTable.put("STCH",  new Operation("3/4", "54"));
       OperationTable.put("CLEAR", new Operation("2",   "B4"));
       //OperationTable.put("MOV",   new Operation("3/4", "00"));
       OperationTable.put("LDA", new Operation("3/4",   "00"));
       OperationTable.put("LDB", new Operation("3/4",   "68"));
       OperationTable.put("LDL", new Operation("3/4",   "08"));
       OperationTable.put("LDS", new Operation("3/4",   "6C"));
       OperationTable.put("LDT", new Operation("3/4",   "74"));
       OperationTable.put("STA", new Operation("3/4",   "0C"));
       OperationTable.put("STB", new Operation("3/4",   "78"));
        OperationTable.put("STL", new Operation("3/4",   "14"));
        OperationTable.put("STS", new Operation("3/4",   "7C"));
        OperationTable.put("STT", new Operation("3/4",   "84"));
        OperationTable.put("STX", new Operation("3/4",   "10"));
       }
       
    public static Map<String, Operation> getOperationTable() {
        return OperationTable;
    }
    
    public static void writeOP() throws IOException {
   String outputFile = "OpTab.txt"; 
    FileWriter ostream;
    BufferedWriter out;
    
    ostream = new FileWriter(outputFile);
    out = new BufferedWriter(ostream);
    Map<String, Operation> map = getOperationTable();
    
    for(Map.Entry<String, Operation> entry :map.entrySet()) {
        out.write("Entry: " +entry.getKey()+"\tValues: "+entry.getValue().toString() + "\n");
    }
    out.close();
    }
    }

