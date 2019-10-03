import java.util.HashMap;

public final class AssemblyToOpcode {
    public final static HashMap<String, String> table = new HashMap<>();
    static {
        table.put("CLA","0000");
        table.put("LAC","0001");
        table.put("SAC","0010");
        table.put("ADD","0011");
        table.put("SUB","0100");
        table.put("BRZ","0101");
        table.put("BRN","0110");
        table.put("BRP","0111");
        table.put("INP","1000");
        table.put("DSP","1001");
        table.put("MUL","1010");
        table.put("DIV","1011");
        table.put("STP","1100");
    }
}
