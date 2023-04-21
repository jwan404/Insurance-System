package nz.ac.auckland.se281;

import java.util.ArrayList;

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
      System.out.println(" " + (1) + ":" + " " + db.get(0).getName() + ", " + db.get(0).getAge() + ", " + "1" + " " + "policy");
      return;
    }

    System.out.println(
        MessageCli.PRINT_DB_POLICY_COUNT.getMessage(String.format("%d", db.size()), "s", ":"));

    for (int i = 0; i < db.size(); i++) { // prints out the profiles in the database
      if (loadedProfile == null){  
        System.out.println(
          " " + (i + 1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge() + ", " + db.get(i).getPolicies().size() + " " + "policies");
      } else {
        db.set(db.indexOf(loadedProfile), loadedProfile); // if the index the loaded profile is the same as the index of the profile in the database, it will be marked with ***
          if (i == db.indexOf(loadedProfile)) {
            if (db.get(i).getPolicies().size() == 0) {
              System.out.println("*** " + (i + 1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge() + ", " + "0" + " " + "policies");
            } else if (db.get(i).getPolicies().size() == 1) {
              System.out.println("*** " + (i + 1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge() + ", " + "1" + " " + "policy");
            } else {
              System.out.println(
                "*** " + (i + 1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge() + ", " + db.get(i).getPolicies().size() + " " + "policies");
            }
          }
          else {
            System.out.println(
              " " + (i + 1) + ":" + " " + db.get(i).getName() + ", " + db.get(i).getAge() + ", " + db.get(i).getPolicies().size() + " " + "policies");
          }
      }
    }

   for (int i = 0; i < loadedProfile.getPolicyCount(); i++) {
      PolicyType pType = loadedProfile.getPolicies().get(i).getType();
      if (pType == PolicyType.HOME) {
        Home homePolicy = (Home) loadedProfile.getPolicies().get(i);
        MessageCli.PRINT_DB_HOME_POLICY.printMessage(homePolicy.getAddress(), Integer.toString(homePolicy.getSum()), Integer.toString(homePolicy.getBasePremium()), Integer.toString(homePolicy.getDiscountPremium()));
      } else if (pType == PolicyType.CAR) {
        Car carPolicy = (Car) loadedProfile.getPolicies().get(i);
        MessageCli.PRINT_DB_CAR_POLICY.printMessage(carPolicy.getMakeModel(), Integer.toString(carPolicy.getSum()), Integer.toString(carPolicy.getBasePremium(loadedProfile.getAge())), Integer.toString(carPolicy.getDiscountPremium()));
      } else if (pType == PolicyType.LIFE) {
        Life lifePolicy = (Life) loadedProfile.getPolicies().get(i);
        MessageCli.PRINT_DB_LIFE_POLICY.printMessage(Integer.toString(lifePolicy.getSum()), Integer.toString(lifePolicy.getBasePremium(loadedProfile.getName(), loadedProfile.getAge())), Integer.toString(lifePolicy.getDiscountPremium()));
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
    }
   
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
    
    userName =
    userName.substring(0, 1).toUpperCase()
        + userName.substring(1, userName.length()).toLowerCase();
    boolean profileFound = false;

    if (loadedProfile != null && loadedProfile.getName().equals(userName)) { //loadedProfile is the same as userName
      MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(userName);
      return;
    }
    for (int i = 0; i < db.size(); i++) { 
      if(userName.equals(db.get(i).getName())) { // delete profile successfully
        db.remove(i);
        profileFound = true;
        MessageCli.PROFILE_DELETED.printMessage(userName);
      } 
    }
    if (!profileFound){
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
    }
 }

  public void createPolicy(PolicyType type, String[] options) {

    if (loadedProfile == null) { // if no profile is loaded, it will not create a policy
      System.out.println("Need to load a profile in order to create a policy.");
      return;
    }
    
    int discountedPremium = 0;
    if (type == PolicyType.HOME) { // creates a new policy based on the type
      Home homePolicy = new Home(options[0], options[1], options[2]);
      loadedProfile.addPolicy(homePolicy);
      MessageCli.NEW_POLICY_CREATED.printMessage("home", loadedProfile.getName());

      if (loadedProfile.getPolicyCount() == 2) {
        discountedPremium = (int) (homePolicy.getBasePremium() * 0.9);
      }
      else if (loadedProfile.getPolicyCount() >= 3) {
        discountedPremium = (int) (homePolicy.getBasePremium() * 0.8);
      }
      else {
        discountedPremium = homePolicy.getBasePremium();
      }
      int policySize = loadedProfile.getPolicies().size();
      ((Home)loadedProfile.getPolicies().get(policySize)).setDiscountPremium(discountedPremium);

    }
    else if (type == PolicyType.CAR) {
      Car carPolicy = new Car(options[0], options[1], options[2], options[3]);
      loadedProfile.addPolicy(carPolicy);
      MessageCli.NEW_POLICY_CREATED.printMessage("car", loadedProfile.getName());

      if (loadedProfile.getPolicyCount() == 2) {
        discountedPremium = (int) (carPolicy.getBasePremium(loadedProfile.getAge()) * 0.9);
      }
      else if (loadedProfile.getPolicyCount() >= 3) {
        discountedPremium = (int) (carPolicy.getBasePremium(loadedProfile.getAge()) * 0.8);
      }
      else {
        discountedPremium = (int) carPolicy.getBasePremium(loadedProfile.getAge());
      }
      int policySize = loadedProfile.getPolicies().size();
      ((Car)loadedProfile.getPolicies().get(policySize)).setDiscountPremium(discountedPremium);
      }
    else if (type == PolicyType.LIFE) {
      // check arraylist if there is a life policy.
      // if there is, print message saying that the user already has a life policy
      // if there isn't, create a new life policy

      for (int i = 0; i < loadedProfile.getPolicyCount(); i++) {
        if (loadedProfile.getPolicies().get(i).getType() == PolicyType.LIFE) {
          MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(loadedProfile.getName());
        } else {
          Life lifePolicy = new Life(options[0]);
          loadedProfile.addPolicy(lifePolicy);
          MessageCli.NEW_POLICY_CREATED.printMessage("life", loadedProfile.getName());
          discountedPremium = (int) lifePolicy.getBasePremium(loadedProfile.getName(), loadedProfile.getAge());
          int policySize = loadedProfile.getPolicies().size();
          ((Life)loadedProfile.getPolicies().get(policySize)).setDiscountPremium(discountedPremium);
          return;
        } 
      }
    }     
    
  }
}
