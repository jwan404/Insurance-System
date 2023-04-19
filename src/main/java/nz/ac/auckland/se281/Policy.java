package nz.ac.auckland.se281;

public class Policy {
    protected int sum; //home, car, life
    protected String address; // home
    protected boolean rental; //home
    protected String makeModel; // car
    protected String licensePlate; // car
    protected boolean mechBreakdown; // car

    public Policy(String sum, String address, String rental, String makeModel, String licensePlate,
    String mechBreakdown) {
        this.sum = Integer.parseInt(sum);
        this.address = address;
        this.rental = rental != null;
        this.makeModel = makeModel;
        this.licensePlate = licensePlate;
        this.mechBreakdown = mechBreakdown != null;
    }

    public int getSum() {
        return sum;
    }
    public String getAddress() {
        return address;
    }
    public boolean isRental() {
        return rental;
    }
    public String getMakeModel() {
        return makeModel;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public boolean isMechBreakdown() {
        return mechBreakdown;
    }

   
    
   
    
    
}
