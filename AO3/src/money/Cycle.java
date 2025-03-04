package money;

import java.util.ArrayList;

public class Cycle {

    private ArrayList<String> peopleInCycle;
    private int cycleAmount;

    public Cycle(ArrayList<String> peopleInCycle, int cycleAmount) {
        this.peopleInCycle = peopleInCycle;
        this.cycleAmount = cycleAmount;
    }

    public ArrayList<String> getPeopleInCycle() {
        return this.peopleInCycle;
    }

    public void setPeopleInCycle(ArrayList<String> peopleInCycle) {
        this.peopleInCycle = peopleInCycle;
    }

    public int getCycleAmount() {
        return this.cycleAmount;
    }

    public void setCycleAmount(int cycleAmount) {
        this.cycleAmount = cycleAmount;
    }

}
