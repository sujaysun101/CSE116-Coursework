package calculator.model;

public class StrState {
    private String str2;
    public StrState(String str) {
        this.str2 = str;
    }
    public String getString() {
        return this.str2;
    }
    public String setString(String str) {
        this.str2 = str;
    }
    public void append(String number) {
        this.str2 += number;
    }
    public void appendDecimal() {
        this.str2 += ".";
    }
}
