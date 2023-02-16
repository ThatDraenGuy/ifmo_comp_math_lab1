package commands;

public enum ArgsType {
    NONE,
    NUM,
    FILE,
    RANGE;


    public String display() {
        return switch (this) {
            case NONE -> "";
            case NUM -> "<number>";
            case FILE -> "<file name>";
            case RANGE -> "<min number> <max number>";
        };
    }
}
