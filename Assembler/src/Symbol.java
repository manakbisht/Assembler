public final class Symbol {
    public final String name;
    public final String type;
    public final int offset;
    public final int value;
    public final int size;

    public Symbol(String name, String type, int offset, int value, int size) {
        this.name = name;
        this.type = type;
        this.offset = offset;
        this.value = value;
        this.size = size;
    }
}
