public class Car {
    private boolean totaled;
    public Car() {
        this.totaled = false;
    }
    public void drive(boolean overweight) {
        if (this.totaled) {
            System.out.println("Can't drive samshed car");
        } else if (overweight) {
            System.out.println("Suspension was damaged");
        } else {
            System.out.println("Driving");
        }

        public void smash() {
            this.totaled = true;
            System.out.println("car was totaled");
        }
    }
}
