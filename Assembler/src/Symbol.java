public final class Symbol {
    public final String name;
    public String type;
    public  int offset;
    public final int value;
    public final int size;
    @Override
    public String toString()
    {
        String x="";
        x+=name+" "+type+" "+String.valueOf(offset)+" "+String.valueOf(value)+" "+String.valueOf(size);
        return x;
    }
    public int update(Symbol o)
    {
        if(type!=o.type)
        {
            System.out.println(name);
            System.out.println("Label name cannot be same as variable name");
        }
        else if(offset!=-1&&o.offset!=-1)
        {
            System.out.println(name);
            System.out.println("Symbol already declared");               
        }
        else if(o.offset!=-1)
        {
            offset=o.offset;
            return 0;
        }
        return 1;
    }
    public Symbol(String name, String type, int offset, int value, int size) {
        this.name = name;
        this.type = type;
        this.offset = offset;
        this.value = value;
        this.size = size;
    }
    public String getName()
    {
        return name;
    }
}
