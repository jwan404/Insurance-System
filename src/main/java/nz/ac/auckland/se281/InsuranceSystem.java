package nz.ac.auckland.se281;

import java.util.ArrayList;

import org.eclipse.jgit.transport.UserAgent;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private ArrayList<Profile> db = new ArrayList<>();
  private Profile loadedProfile = null;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    // When database is called, checks database for number of profiles and outputs messages
    // depending on the number of profiles.
    if (db.size() == 0) {
      System.out.println(MessageCli.PRINT_DB_POLICY_COUNT.getMessage("0", "s", "."));
      return;
    }

    if (db.size() == 1) {
      System.out.println(MessageCli.PRINT_DB_POLICY_COUNT.getMessage("1", "", ":"));
      System.out.println(" " + (1) + ":" + " " + db.get(0).getName() + ", " + db.get(0).getAge());
      return;
    }

    System.out.println(
        MessageCli.PRINT_DB_POLICY_COUNT.getMessage(String.format("%d", db.size()), "s", ":"));

    for (int i = 0; i < db.size(); i++) {
      if (loadedProfile == null){  
        System.out.println(
          " " + (i + 1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge());
      } else {
        db.set(db.indexOf(loadedProfile), loadedProfile);
          if (i == db.indexOf(loadedProfile)) {
            System.out.println("*** " + (i + 1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge());
          }
          else {
            System.out.println(
          " " + (i + 1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge());
          }
      }
    }
  }
    

  public void createNewProfile(String userName, String age) {
    // Creates the profile while ignoring the case. And checks whether the name is valid.
    userName =
        userName.substring(0, 1).toUpperCase()
            + userName.substring(1, userName.length()).toLowerCase();
    int numAge = Integer.parseInt(age); // new variable that converts string age to int age

    if (userName.length() < 3) { // Checks if name is long enough
      System.out.println(MessageCli.INVALID_USERNAME_TOO_SHORT.getMessage(userName));
      return;
    }

    if (numAge < 0) { // Checks if age is a positive integer
      System.out.println(MessageCli.INVALID_AGE.getMessage(age, userName));
      return;
    }

    for (int i = 0; i < db.size(); i++) { // checks if name is unique
      if (userName.equals(db.get(i).getName())) {
        System.out.println(MessageCli.INVALID_USERNAME_NOT_UNIQUE.getMessage(userName));
        return;
      }
    }

    if (loadedProfile == null) {
       db.add(new Profile(userName, age)); // adds profile to database
    System.out.println("New profile created for " + userName + " " + "with age " + age + ".");
    }/* else {
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(loadedProfile);
    } */
   
  }

  public void loadProfile(String userName) {
    userName =
    userName.substring(0, 1).toUpperCase()
        + userName.substring(1, userName.length()).toLowerCase();
    for (int i = 0; i < db.size(); i++) { //works for first test
      if (userName.equals(db.get(i).getName())) {
        System.out.println(MessageCli.PROFILE_LOADED.getMessage(userName));
        loadedProfile = db.get(i);
      return;
      }
   }
  if (loadedProfile == null) {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
  }
}

  public void unloadProfile() {
    for (int i = 0; i < db.size(); i++) {
      if(loadedProfile == null) {
        System.out.println(MessageCli.NO_PROFILE_LOADED);
        return;
      } else {
        MessageCli.PROFILE_UNLOADED.printMessage(db.get(db.indexOf(loadedProfile)).getName());
        loadedProfile = null;
      }
    } 
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
