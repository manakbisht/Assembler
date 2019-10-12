public final class Opcode 
{
    public String operand;
    public String opcode=null;

    public Opcode(String assemblyOpcode ) 
    {
        opcode = AssemblyToOpcode.table.get(assemblyOpcode);
    }
    @Override
    public String toString()
    {
        String x="";
        x+=opcode+" "+operand;
        return x;
    }
    public void setOperand(String _operand)
    {

        switch (opcode) {
            case "0000":
                operand = null;
                break;
            case "0001":
                operand = _operand;
                break;
            case "0010":
                operand = _operand;
                break;
            case "0011":
                operand = _operand;
                break;
            case "0100":
                operand = _operand;
                break;
            case "0101":
                operand = _operand;
                break;
            case "0110":
                operand = _operand;
                break;
            case "0111":
                operand = _operand;
                break;
            case "1000":
                operand = _operand;
                break;
            case "1001":
                operand = _operand;
                break;
            case "1010":
                operand = _operand;
                break;
            case "1011":
                operand = _operand;
            case "1100":
                operand = null;
                break;
            default:
                operand = null;
                break;
        }
        //System.out.println(operand);
    }
}
