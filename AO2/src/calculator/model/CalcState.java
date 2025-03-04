package calculator.model;

public interface CalcState {
    void equalsPressed();
    double displayNumber();
    void clearPressed();
    void numberPressed(int number);
    void decimalPressed();
}
