package nz.ac.auckland.se281;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private int nProfile;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    //System.out.println("Database has 1 profile: ");
    if (nProfile == 0) {
      Profile p0 = new Profile();
      p0.zeroProfiles();
    }
    else if (nProfile == 1) {
      Profile p1 = new Profile();
      p1.oneProfile();
    }
    else {
      Profile p2 = new Profile();
      p2.twoProfiles();
    }
  }

  public void createNewProfile(String userName, String age) {
    
    //Profile p1 = new Profile();
    int size = userName.length();
    int nProfile = 0;

    if (size >= 3) {
      nProfile++;
       if (nProfile == 1) {
        printDatabase();//System.out.println("Database has 1 profile: "); //ref
        System.out.println("New profile created for " + userName + " " + "with age " + age + ".");
        System.out.println(" " + "1" + ":" + " " + userName + ", " + age);
      }
      else {
        printDatabase(); //System.out.println("Database has 2 profiles: ");//ref
        int rank = 1;
        System.out.println(" " + rank + ":" + " " + userName + ", " + age);
        rank++;
        System.out.println(" " + rank + ":" + " " + userName + ", " + age);
      }
    }
  }
      

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
