package nz.ac.auckland.se281;

public class Car extends Policy {
    protected String makeModel; // car
    protected String licensePlate; // car
    protected boolean mechBreakdown; // car

    public Car(String sum, String makeModel, String licensePlate, String mechBreakdownStr) {
        super(sum);
        this.makeModel = makeModel;
        this.licensePlate = makeModel;
        this.mechBreakdown = mechBreakdownStr.toLowerCase().startsWith("y");
    }

    public String getMakeModel() {
        return makeModel;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean getMechBreakdown() {
        return mechBreakdown;
    }
    
    public int getBasePremium(int loadedAge) { // for car

       if (mechBreakdown == true) {
           if (loadedAge < 25) {
               return (int) (sum * 0.15 + 80);
           } else {
               return (int) (sum * 0.1 + 80);
           }
       } else {
           if (loadedAge < 25) {
               return (int) (sum * 0.15);
           } else {
               return (int) (sum * 0.1);
           }
       }
    }
}
// Base premium:
// if client is under 25 years old = base premium is 15% of sum
// if client is 25 or older = base premium is 10% of sum
// if the mechBreakdown is true = the base premium is increased by a further $80 regardless of age
