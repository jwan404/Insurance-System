package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
   
  }

  public void printDatabase() {
    System.out.println("Database has 0 profiles.");
    //make a reference point 
    
  }

  public void createNewProfile(String userName, String age) {
    int size = userName.length();
    int nProfile = 0;

    if (size >= 3) {
      nProfile++;
       if (nProfile == 1) {
        System.out.println("Database has 1 profile: ");
        System.out.println("New profile created for " + userName + " " + "with age " + age + ".");
        System.out.println(" " + "1" + ":" + " " + userName + ", " + age);
      }
      else {
        int rank = 1;
        System.out.println("Database has 2 profiles: ");
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
