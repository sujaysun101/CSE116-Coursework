package calculator.model;

public class Subtract implements OperatorState {
    private Calculator calculator;
    public Subtract(Calculator calculator) {
        this.calculator = calculator;
    }
    public void subtractPressed() {
        this.calculator.setState(new Calculator(this));
    }
}
