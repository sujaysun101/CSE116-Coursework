package calculator.model;

public class NewCalc implements CalcState {
    private Calculator calculator;
    public NewCalc(Calculator calculator) {
        this.calculator = calculator;
    }
    public double displayNumber() {
        return calculator.displayNumber();
    }

    public void clearPressed() {

    }

    public void numberPressed(int number) {

    }

    public void dividePressed() {

    }

    public void multiplyPressed() {

    }

    public void subtractPressed() {

    }

    public void addPressed() {

    }

    public void equalsPressed() {

    }

    public void decimalPressed() {

    }
}
