package assembler;
        
public class MOVStatements {
   public static String original;
   public static String label;
   public static String param;
   public static String loadOrStore;
   public static String processedStatement;
    /**
     * { LDA, LDB, LDL, LDS, LDT, D, STA, STB, STL, STS, STT, STX } = MOV
     * { A, B, L, S, T } = {%RA, %RB, %RL, %RS, %RT}
     *  Whenever MOV is used need to replace it with its complementary SIC/XE
     *  MOV %RA,#3 = LDA #3
     *  MOV LENGTH,%RA = STB LENGTH
     *  Load, Store, D (dump command)
     *  processedStatement = label + " " + loadOrStore + " " + param
     */
    public MOVStatements(){
        original = "";
        label = "";
        
    }
    public MOVStatements(String origin){
        original = origin.trim();
        original = original.toUpperCase();
        label = "";
        parseMOV(original);
    }
    
    public static void parseMOV(String passed){
        //check that MOV is passed
        if(passed.substring(0,3).compareTo("MOV") != 0){
            //label or +  
            int i = passed.indexOf("MOV");
            label = passed.substring(0,i);
           // System.out.println(label);
            label = label.trim();
            if(label.length()>1){
                label = label + " ";
            }
            passed = passed.substring(i);
        }
            String temp = passed.substring(4);
            //System.out.println(temp);
            temp = temp.trim();
            String temp2[] = temp.split(",");
            if(temp2.length != 2){
                //too many or too few arguments passed
                //System.out.println("error");
            }else{
                sourceOrDest(temp2[0],temp2[1]);
            }
    }
    
    //determines which is source and which is destination and sets accourdingly
    public static void sourceOrDest(String arg1, String arg2){
        if(arg1.contains("%")){
            loadOrStore = "LD";
            loadOrStore = loadOrStore.concat(arg1.substring(2));
            param = arg2;
        }
        if(arg2.contains("%")){
            if(arg2.contains("[")){
                String temp[] = arg2.split("\\[");
                param = temp[0] + "," + temp[1].substring(2,3);
            }else{
            loadOrStore = "ST";
            loadOrStore = loadOrStore.concat(arg2.substring(2));
            param = arg1;
            }
        }
        processedStatement = label + loadOrStore + " " + param;

    }
//    public static void main(String[] args) {
//        //Test Cases 
////        MOVStatements mov = new MOVStatements("MOV %RA,#3");
////        System.out.println("Done\n");
////        System.out.println(mov.original);
////        System.out.println(mov.processedStatement);
////        MOVStatements mov2 = new MOVStatements("MOV LENGTH,%RB");
////        System.out.println(mov2.original);
////        System.out.println(mov2.processedStatement);
////        MOVStatements mov3 = new MOVStatements("MOV %RA,ALPHA[%RX]");
////        System.out.println(mov3.original);
////        System.out.println(mov3.processedStatement);
//        MOVStatements mov4 = new MOVStatements("FIRST MOV %RA,ALPHA[%RX]");
//        System.out.println(mov4.original);
//        System.out.println(mov4.processedStatement);
//        
//    }
    
}
