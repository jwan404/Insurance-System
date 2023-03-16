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

    for (int i = 0; i < db.size(); i++) {
      if (db.size() == 1) {
        System.out.println( MessageCli.PRINT_DB_POLICY_COUNT.getMessage("1", "", ":"));
        System.out.println(" " + (i+1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge());    
      }
      else {
        System.out.println( MessageCli.PRINT_DB_POLICY_COUNT.getMessage(String.format("%d", i), "s", ":"));
        System.out.println(" " + (i+1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge());    
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    int numAge = Integer.parseInt(age);
    
    if (userName.length() < 3) {
        MessageCli.INVALID_USERNAME_TOO_SHORT.getMessage(userName);
        return;
    }
    
     if (numAge < 0 ) {
      MessageCli.INVALID_AGE.getMessage(age, userName);
      return;
    }

    for (int i = 0; i < db.size(); i++) {
      if(db.get(i).getName() == userName){
        // Message
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
