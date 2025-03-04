package calculator.model;

public class Multiply implements OperatorState {
    private Calculator calculator;
    public Multiply(Calculator calculator) {
        this.calculator = calculator;
    }
    public void multiplyPressed() {
        this.calculator.setState(new Multiply(this));
    }
}
