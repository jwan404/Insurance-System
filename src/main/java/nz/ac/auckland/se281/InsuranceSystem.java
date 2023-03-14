package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
   
  }

  public void printDatabase() {
    System.out.println("Database has 1 profile:");
     
    /*MessageCli.PRINT_DB_POLICY_COUNT.getMessage("1", "s", ":");
    System.out.println("Data has " + nProfiles + "profile" + sS + ending);
    System.out.println(" " + rank + ":" + " " + userName + ", " + age);*/
  }

  public void createNewProfile(String userName, String age) {
    int size = userName.length();
    int nProfile = 0;
    int rank = 0;

    /*if((size < 3 ) || (userName = database.userName) ) {
      if(userName = database.userName) {
        System.out.println("Usernames must be unique. No profile was created for " + userName);
      }
      else {
        System.out.println(userName + " " + "is an invalid username, it should be at least 3 characters long. No profile was created.");
      }
     }*/

    if(size >= 3 )  {
      nProfile++;
      rank++;
    }

    if (nProfile != 0) {
      System.out.println("Database has 1 profile: ");
      System.out.println(" " + rank + ":" + " " + userName + ", " + age);
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
