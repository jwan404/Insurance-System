package nz.ac.auckland.se281;

import java.util.Scanner;

public class Home extends Policy{
    private int sum;
    private String address;
    private boolean rental;

    public Home (String sum, String address, String rental) {
        this.sum = Integer.parseInt(sum);
        this.address = address;
        this.rental = rental != null;
    }

    public int getSum() {
        return sum;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getRental() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Rental? (yes/no): ");
        String n = reader.next();
        reader.close();

        if(n.equals("yes")) {
            System.out.println("yes");
            return true;
        } else {
            System.out.println("no");
            return false;
        }
            
    }


}
// Base premium:
// if home is rented = base premium is 2% of the sum
// if home is not rented = base premium is 1% of the sum
