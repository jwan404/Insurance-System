package nz.ac.auckland.se281;

public class Car extends Policy {
    private int sum;
    private String makeModel;
    private String licensePlate;
    private boolean mechBreakdown;

    public Car(String sum, String makeModel, String licensePlate, boolean mechBreakdown) {
        this.sum = Integer.parseInt(sum);
        this.makeModel = makeModel;
        this.licensePlate = licensePlate;
        this.mechBreakdown = mechBreakdown;
    }
    
    
}
// Base premium:
// if client is under 25 years old = base premium is 15% of sum
// if client is 25 or older = base premium is 10% of sum
// if the mechBreakdown is true = the base premium is increased by a further $80 regardless of age
