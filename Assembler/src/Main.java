import java.io.*;
import java.util.ArrayList;
public class Main {
    private static ArrayList<Symbol> symbolTable=new ArrayList<Symbol>();
    private static ArrayList<Opcode> opcodeTable=new ArrayList<Opcode>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("./Assembler/sample_input.txt"));
        passOne(input);
        input = new BufferedReader(new FileReader("./Assembler/sample_input.txt"));
        passtwo(input);

    }
    public static boolean is_not_comment(String line){
        int flag=0;
        for(int i=0;i<line.length();i++)
        {
            if(check(line.charAt(i))) {
                if (flag == 0)
                    return true;
                else
                {
                    System.out.println(line);
                    System.out.println("Invalid Token");
                    return false;
                }
            }
                else if(line.charAt(i)=='/'&&flag==0)
                    flag=1;
                else if(line.charAt(i)=='/'&&flag==1)
                    return false;
            }
        return false;
    }
    public static boolean check(char c)
    {
        if(Character.isLetter(c)||Character.isDigit(c)||c=='_')
            return true;
        return false;
    }
   public static void addToTable(Symbol o){
        int flag=0;
        for(int i=0;i<symbolTable.size();i++){
            if(symbolTable.get(i).getName().equals(o.getName())) {
                symbolTable.get(i).update(o);
                flag = 1;
            }

        }
        if(flag==0)
            symbolTable.add(o);
    }
    public static boolean check_valid_label(String x)
    {
        String is=AssemblyToOpcode.table.get(x);
        if(is==null)
            return true;
        return false;
    }

    public static void passOne(BufferedReader input) throws IOException {

        String line;
        int locationCounter;
        locationCounter = 0;
        Opcode o=null;
        while ((line = input.readLine()) != null) {
            //System.out.println(line);
            if(is_not_comment(line))
            {
                //System.out.println(line);
                int f1=0;
                String v1="";
                int f2=0;
                for(int i=0;i<line.length();i++)
                {
                    if(check(line.charAt(i))&&f1==0)
                    {
                        if(f2==3){
                            System.out.println(line);
                            System.out.println("More Inputs Supplied");
                            break;
                        }
                        if(line.charAt(i)!=':')
                            v1+=String.valueOf(line.charAt(i));
                    }
                    else if(line.charAt(i)!=' '&&!check(line.charAt(i))&&!(line.charAt(i)==':'&&f2==0))
                    {
                        System.out.println(line);
                        System.out.println("Invalid token");
                        break;
                    }
                    if(line.charAt(i)==' '&&f1==0&&v1.length()!=0)
                        f1=1;
                    if((check(line.charAt(i))&&f1==1)||i==line.length()-1||line.charAt(i)==':')
                    {
                        //System.out.println("v1:"+v1);
                        if(line.charAt(i)==':')
                        {
                            if(check_valid_label(v1))
                                addToTable(new Symbol(v1,"label",locationCounter,-1,12));
                            else
                            {
                                System.out.println(line);
                                System.out.println("Invalid label");
                                break;
                            }
                            f2=1;
                        }
                        else if(f2==1||f2==0) {
                            f2=2;
                            o = new Opcode(v1);
                            if(o.opcode==null)
                            {
                                System.out.println(line);
                                System.out.println("Invalid opcode");
                                break;
                            }
                            if(v1.equals("CLA")||v1.equals("STP")){
                                opcodeTable.add(o);
                                f2=3;
                            }
                            else
                            {
                                int initial=i;
                                //System.out.println(line);
                                i++;
                                while(i<line.length()&&(!check(line.charAt(i))))
                                    i++;
                                //System.out.println(i+" "+line.length());
                                if(i==line.length()){
                                    System.out.println(line);
                                    System.out.println("Less Input Supplied");
                                    break;
                                }
                                i=initial;

                            }

                        }
                        else
                        {
                            addToTable(new Symbol(v1,"variable",-1,-1,-1));
                            o.setOperand(v1);
                            //System.out.println(v1);
                            f2=3;
                            opcodeTable.add(o);
                        }
                        if(line.charAt(i)!=':')
                            v1=""+String.valueOf(line.charAt(i));
                        else
                            v1="";
                        f1=0;
                    }
                }
            }
            locationCounter+=12;
        }
        for(int i=0;i<symbolTable.size();i++){
            if(symbolTable.get(i).offset==-1)
            {
                symbolTable.get(i).offset=locationCounter;
                locationCounter+=12;
            }
        }
        input.close();
        printTable();
    }
    public static void printTable()
    {
        for(int i=0;i<symbolTable.size();i++)
            System.out.println(symbolTable.get(i));
        for(int i=0;i<opcodeTable.size();i++)
            System.out.println(opcodeTable.get(i));
    }
    public static String toBinary(String o)
    {
        int t=-1;
        for(int i=0;i<symbolTable.size();i++){
            if(o.equals(symbolTable.get(i).getName()))
                t=symbolTable.get(i).offset;
        }
        String x="";
        if(t!=-1) {
            x = Integer.toBinaryString(t);
            int a = 8 - x.length();
            String temp = "";
            for (int j = 0; j < a; j++) {
                temp += "0";
            }
            temp += x;
            return x;
        }
        return null;
    }
    public static void passtwo(BufferedReader input) throws IOException
    {
        PrintWriter output=null;
        String line="";
        try
        {
            output=new PrintWriter(("./Assembler/Output.txt"));
            for(int i=0;i<opcodeTable.size();i++)
            {
                line=input.readLine();
                String x="";
                x+=opcodeTable.get(i).opcode;
                if(opcodeTable.get(i).operand!=null)
                {

                    String a=toBinary(opcodeTable.get(i).operand);
                    if(a==null)
                    {
                        System.out.println(line);
                        System.out.println("Variable not declared");
                        continue;
                    }
                    else {
                        x += a;
                    }
                }
                else
                    x+="00000000";
                if(x!=null)
                   output.println(x);
            }

        }
        finally {
            if(output!=null)
                output.close();
            if(input!=null)
                input.close();
        }
    }
}
