package nz.ac.auckland.se281;

public class Home extends Policy{
    protected String address; // home
    protected boolean rental; //home
    private int discountPremium;


    public Home (String sum, String address, String rentalStr) {
        super(sum);
        this.address = address;
        this.rental = rentalStr.toLowerCase().startsWith("y");
    }

    public String getAddress() {
        return address;
    }

    public boolean getRental() {
       return rental;       
    }

    public int getBasePremium() {
        if (rental) {
            return (int) (sum * 0.02);
        } else {
            return (int) (sum * 0.01);
        }
    }

    public int getDiscountPremium() {
        return discountPremium;
    }

    public void setDiscountPremium(int discountPremium) {
        this.discountPremium = discountPremium;
    }

}
// Base premium:
// if home is rented = base premium is 2% of the sum
// if home is not rented = base premium is 1% of the sum
