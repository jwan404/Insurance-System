package nz.ac.auckland.se281;

public class Life extends Policy{

    public Life(String sum) {
        super(sum);
    }

    public double getBasePremium() {
        for (int i = 0; db.size(); i++) {
            if ( lifePolicyCount == 1) {
                MessageCli.ONE_LIFE_POLICY_PER_CLIENT.printMessage(db.getName());
                return;
            }
            if (db.get(i).getAge() < 100) {
                return (double) (sum * 0.01) + db.get(i).getAge();
            } else {
                MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(db.getName());
            }
    }

}
// base premium = (1 + age/100) of the sum 
// eg age:25 so base premium = 1.25% of the sum
// max age for life policy is 100 years old = shows error msg
// only one life policy per client profile = shows error msg