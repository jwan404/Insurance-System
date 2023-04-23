package nz.ac.auckland.se281;

public class Life extends Policy {

  public Life(String sum) {
    super(sum);
  }

  public int getBasePremium(int loadedAge) {
    return (int) (sum * (1 + (double) loadedAge / 100) / 100);
  }
}
// base premium = (1 + age/100) of the sum
// eg age:25 so base premium = 1.25% of the sum
// max age for life policy is 100 years old = shows error msg
// only one life policy per client profile = shows error msg
