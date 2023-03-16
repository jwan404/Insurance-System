package nz.ac.auckland.se281;

public class Profile {
    private String userName;
    private int age;

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

}