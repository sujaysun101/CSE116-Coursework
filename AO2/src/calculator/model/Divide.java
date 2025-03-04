package calculator.model;

public class Divide implements OperatorState {
    private String str2;
    public Divide(String str) {
        this.str2 = str;
    }
    public void dividePressed() {
        System.out.println("/");
    }
}
