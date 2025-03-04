package calculator.model;

public class Display implements CalcState {
    private Calculator calculator;
    public Display(Calculator calculator) {
        this.calculator = calculator;
    }
    public double displayNumber() {
        return this.calculator.numberPressed();
        //this.calculator.setState(new Multiply(this));
    }
    public void numberPressed(int number) {

    }
    public void equalsPressed() {

    }
    public void clearPressed() {

    }
}
