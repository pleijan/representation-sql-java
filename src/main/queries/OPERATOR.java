package main.queries;

public enum OPERATOR {
    EQUAL (" = "),
    NOTEQUAL (" <> "),
    GT( " > "),
    LT(" < "),
    GTE(" >= "),
    ;

    private final String s;
    OPERATOR(String s) {
        this.s = s;
    }
}
