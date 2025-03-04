package calculator.model;

public class Add implements OperatorState {
    private Calculator calculator;
    public Add(Calculator calculator) {
        this.calculator = calculator;
    }
    public void addPressed() {
        this.calculator.setState(new Subtract(this));
    }
}
