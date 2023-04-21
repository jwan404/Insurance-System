package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public abstract class Policy {
    protected int sum; //home, car, life

    public Policy(String sum) {
        this.sum = Integer.parseInt(sum);
    }

    public int getSum() {
        return sum;
    }

    public PolicyType getType() {
        if (this instanceof Home) {
            return PolicyType.HOME;
        } else if (this instanceof Car) {
            return PolicyType.CAR;
        } else if (this instanceof Life) {
            return PolicyType.LIFE;
        } else {
            return null;
        }
    }


    
}
