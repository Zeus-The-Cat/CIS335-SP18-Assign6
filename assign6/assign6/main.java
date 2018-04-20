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
   
     public class main {
     public static void main(String [ ] args) {
      try {
         GenerateOpTable.writeOP();
       GenerateSymTable sym = new GenerateSymTable();
          sym.SymTable(args[0]);
      }
      catch(IOException e) {
      }  
}
}
