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
    
    public double getBasePremium() { // for car
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getAge() < 25) {
                if (mechBreakdown = true) {
                    return (double) (sum * 0.15) + 80;
                } else {
                    return (double) (sum * 0.15);
                }
            } else {
                if (mechBreakdown = true) {
                    return (double) (sum * 0.1) + 80;
                } else {
                    return (double) (sum * 0.1);
                }
            }
        }   
    }
}
// Base premium:
// if client is under 25 years old = base premium is 15% of sum
// if client is 25 or older = base premium is 10% of sum
// if the mechBreakdown is true = the base premium is increased by a further $80 regardless of age
