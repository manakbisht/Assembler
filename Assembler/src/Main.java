import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        ArrayList<Symbol> symbolTable;
        ArrayList<Opcode> opcodeTable;
        BufferedReader input = new BufferedReader(new FileReader("sample_input.txt"));
        passOne(input);
    }

    public static void passOne(BufferedReader input) throws IOException {

        String line, symbol, opcode;
        int locationCounter, length, value, type;
        locationCounter = 0;

        int moreInput;
        while ((moreInput = input.read()) != -1) {
            System.out.println((char) moreInput);
        }

        input.close();
    }
}
