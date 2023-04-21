package nz.ac.auckland.se281;

public class Life extends Policy{
    private int discountPremium;


    public Life(String sum) {
        super(sum);
    }

    public int getBasePremium(String loadedUsername, int loadedAge) {
        if (loadedAge > 100) {
            MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(loadedUsername);
            return 0;
        } else {
            return (int) (sum * (1 + (loadedAge / 100)));
        }
    }
    public int getDiscountPremium() {
        return discountPremium;
    }

    public void setDiscountPremium(int discountPremium) {
        this.discountPremium = discountPremium;
    }

}
// base premium = (1 + age/100) of the sum 
// eg age:25 so base premium = 1.25% of the sum
// max age for life policy is 100 years old = shows error msg
// only one life policy per client profile = shows error msg