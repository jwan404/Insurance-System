package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {
    private String userName;
    private int age;
    private ArrayList<Policy> policies = new ArrayList<>();

    public ArrayList<Policy> getPolicies() {
        return policies; // print policies
    }

    public Profile(String userName, String age) {
        this.age = Integer.parseInt(age);
        this.userName = userName;
    }

    public String getName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public void addPolicy(Policy newPolicy) {
        policies.add(newPolicy);
    }

}