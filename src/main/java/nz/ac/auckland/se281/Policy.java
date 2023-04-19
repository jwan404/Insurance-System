package nz.ac.auckland.se281;

public abstract class Policy {
    protected int sum; //home, car, life

    public Policy(String sum) {
        this.sum = Integer.parseInt(sum);
    }

    public int getSum() {
        return sum;
    }
    
}
