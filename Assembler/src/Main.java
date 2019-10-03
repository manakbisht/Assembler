import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Symbol> symbolTable=new ArrayList<Symbol>();
    private static ArrayList<Opcode> opcodeTable=new ArrayList<Opcode>();
    public static void main(String[] args) throws IOException {
	// write your code here

        BufferedReader input = new BufferedReader(new FileReader("./Assembler/sample_input.txt"));
        passOne(input);
    }
    public static boolean is_not_comment(String line){
        int flag=0;
        for(int i=0;i<line.length();i++)
        {
            if(Character.isLetter(line.charAt(i)))
                return true;
            else if(line.charAt(i)=='/'&&flag==0)
                flag=1;
            else if(line.charAt(i)=='/'&&flag==1)
                return false;
        }
        return false;
    }
    public static String check_label(String line){
        int flag=0;
        String ans="";
        for(int i=0;i<line.length();i++)
        {

            if(line.charAt(i)==':')
                return ans;
            else if(!(line.charAt(i)==' ')&&flag==0)
                ans+=String.valueOf(line.charAt(i));
            else if(flag==0&&line.charAt(i)==' '&&ans.length()==0)
                flag=1;
            else if(!(line.charAt(i)==' ')&&flag==1)
                return null;

        }
        return null;
    }
    public static void passOne(BufferedReader input) throws IOException {

        String line, label, opcode;
        int locationCounter, length, value, type;
        locationCounter = 0;
        String moreInput;
        while ((moreInput = input.readLine()) != null) {
            if(is_not_comment(moreInput))
            {
                label=check_label(moreInput);
                if(label!=null)
                    symbolTable.add(new Symbol(label,"Label",locationCounter,-1,12));
            }

        }

        input.close();
    }
}
