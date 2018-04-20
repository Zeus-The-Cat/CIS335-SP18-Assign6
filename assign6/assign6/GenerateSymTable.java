package assign6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.*;
import java.util.*;

public class GenerateSymTable{

    public int locCtr;
    private int startAddress;
    private static Map<String, Integer> SymbolTable;
    String [] current;
    String line;
    int errorFlag; 
    int end;
    
    public void SymTable(String inputFile) throws IOException{

    String outputFile = "SymTab.txt"; 
    
    SymbolTable = new HashMap<>();
    startAddress = 0;
    locCtr = startAddress;
    errorFlag = 0;

   
      File file = new File(inputFile);
      Scanner scanner = new Scanner(file);
      
      while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        current = line.split("[\t\\,]+");
        end = current.length - 1;
        
         for (int i = 0; i < current.length; i++) {
               if (i == 0) {
                  if(current[0].length() != 0) {
                      SymbolTable.put(current[0], locCtr);
                  } else if(SymbolTable.containsKey(current[0])) {
                     errorFlag = 1;
                     System.out.println("Duplicate error");
                  }
              }        
         }

         if (current[1].equals("START")) {
            startAddress = Integer.parseInt(current[end]);
            locCtr = startAddress;
         } else if (current[1].equals("RESW")) {
            locCtr = locCtr + (3 * Integer.parseInt(current[end]));
         } else if (current[1].equals("RESB")) {
            locCtr = locCtr + Integer.parseInt(current[end]);
         } else if (current[1].equals("WORD")) {
            locCtr += 3;
         } else if (current[1].equals("BASE")) {
         } else if (current[1].equals("NOBASE")) {
 
         } else if (current[1].equals("BYTE")) {
            String s = current[end];
            if (s.charAt(0) == 'C') {
               locCtr += (s.length() - 3);
            } else if (s.charAt(0) == 'X') {
               locCtr += (s.length() - 3) / 2;
            } else {
               errorFlag = 1;
               System.out.println("Byte error");
            }
         } else if (current[1].equals("END")) {
            break;
         } else {
            Map<String, Operation> mapOp = GenerateOpTable.getOperationTable();
            for(Map.Entry<String, Operation> entry :mapOp.entrySet()) {   
               if ((entry.getKey().equals(current[1])) || ('+' + entry.getKey()).equals(current[1])) {
                  if (entry.getValue().format().equals("2")) {
                     locCtr += 2;
                  } else if (entry.getValue().format().equals("3/4")) {
                     locCtr += 3;
                     if (current[1].charAt(0) == '+' ) {
                     locCtr += 1;
                     }
                  }
               }
            }
         }
         }     
         writeSYM();
        }
         
        public static void writeSYM() throws IOException {
         String outputFile = "SymTab.txt"; 
         FileWriter ostream;
         BufferedWriter out;
    
         ostream = new FileWriter(outputFile);
         out = new BufferedWriter(ostream);
      
         Map<String, Integer> mapz = SymbolTable;
         String formatting;
    
         for(Map.Entry<String, Integer> entry :mapz.entrySet()) {
         formatting = String.format ("%04X",entry.getValue ());
            out.write("Symbol: " +entry.getKey()+"\t Address: "+ formatting + "\n");
         }
      out.close();
      }
      }
