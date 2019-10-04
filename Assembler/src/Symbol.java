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
    public void update(Symbol o)
    {
        if(o.offset!=-1)
            offset=o.offset;
        type=o.type;
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
