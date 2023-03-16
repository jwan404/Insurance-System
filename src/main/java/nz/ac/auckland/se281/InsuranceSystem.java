package nz.ac.auckland.se281;
import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private ArrayList<Profile> db = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    if (db.size() == 0) {
      System.out.println(MessageCli.PRINT_DB_POLICY_COUNT.getMessage("0", "s", "."));
      return;
    }

    if (db.size() == 1) {
      System.out.println( MessageCli.PRINT_DB_POLICY_COUNT.getMessage("1", "", ":"));
      System.out.println(" " + (1) + ":" + " " + db.get(1).getName() + ", " + db.get(1).getAge());  
      return;  
    }

    System.out.println( MessageCli.PRINT_DB_POLICY_COUNT.getMessage(String.format("%d", db.size()), "s", ":"));

    for (int i = 0; i < db.size(); i++) {
      
     
      System.out.println(" " + (i+1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge());    

    }
  }

  public void createNewProfile(String userName, String age) {
    userName = userName.substring(0,1).toUpperCase() + userName.substring(1, userName.length()).toLowerCase();
    int numAge = Integer.parseInt(age);
    
    if (userName.length() < 3) {
        System.out.println(MessageCli.INVALID_USERNAME_TOO_SHORT.getMessage(userName));
        return;
    }
    
     if (numAge < 0 ) {
      System.out.println(MessageCli.INVALID_AGE.getMessage(age, userName));
      return;
    }

    for (int i = 0; i < db.size(); i++) {
      if(db.get(i).getName() == userName){
        System.out.println(MessageCli.INVALID_USERNAME_NOT_UNIQUE);
        return;
      }
    }

      db.add(new Profile(userName, age));
      System.out.println("New profile created for " + userName + " " + "with age " + age + ".");

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
