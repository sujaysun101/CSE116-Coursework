package calculator.model;

public class Calculator {
    private StrState str;
    private CalcState state;
    public void Calculator() {
        this.state = null;
        this.str = new StrState("0");
        displayNumber();
    }

    // Accessed by View. You should edit this method as you build functionality
    public double displayNumber() {
        return Double.parseDouble(this.str.getString());
        // TODO
    }

    public void clearPressed() {
        this.state = null;
        this.str = new StrState("0");
        // TODO
    }

    public void numberPressed(int number) {
        //System.out.println(number);
        this.str.append(String.valueOf(number));
        // TODO
    }

    public void dividePressed() {
        this.state = new Divide(Double.parseDouble(this.str.getString()));
        // TODO
    }

    public void multiplyPressed() {
        this.state3.multiplyPressed();
        // TODO
    }

    public void subtractPressed() {
        // TODO
        this.state2.subtractPressed();
    }

    public void addPressed() {
        // TODO
        this.state1.addPressed();
    }

    public void equalsPressed() {
        this.state.equalsPressed();
        // TODO
    }

    public void decimalPressed() {
        this.state.decimalPressed();
        // TODO
    }


}
