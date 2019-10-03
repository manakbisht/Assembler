public final class Opcode {
    public String operand;
    public final String opcode;

    public Opcode(String assemblyOpcode, String _operand) {
        opcode = AssemblyToOpcode.table.get(assemblyOpcode);

        switch (opcode) {
            case "CLA":
                operand = null;
                break;
            case "LAC":
                operand = _operand;
                break;
            case "SAC":
                operand = _operand;
                break;
            case "ADD":
                operand = _operand;
                break;
            case "SUB":
                operand = _operand;
                break;
            case "BRZ":
                operand = _operand;
                break;
            case "BRN":
                operand = _operand;
                break;
            case "BRP":
                operand = _operand;
                break;
            case "INP":
                operand = _operand;
                break;
            case "DSP":
                operand = _operand;
                break;
            case "MUL":
                operand = _operand;
                break;
            case "DIV":
                operand = _operand;
            case "STP":
                operand = null;
                break;
            default:
                operand = null;
                break;
        }
    }
}
