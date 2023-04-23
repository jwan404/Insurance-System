package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  private ArrayList<Profile> db = new ArrayList<>();
  private Profile loadedProfile = null;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }
  // PRINT_DB_PROFILE_HEADER_LONG(" %s%s: %s, %s, %s polic%s for a total of $%s")
  public void printDatabase() {

    if (db.size() == 0) {
      System.out.println(MessageCli.PRINT_DB_POLICY_COUNT.getMessage("0", "s", "."));
      return;
    }
    for (int j = 0; j < db.size(); j++) {

      int discountedPremium1 = 0;
      int discountedPremium2 = 0;
      int discountedPremium3 = 0;
      int discountedPremium4 = 0;
      int discountedPremium5 = 0;
      int discountedPremium6 = 0;
      int totalPremium = 0;
      int total2 = 0;

      // When database is called, checks database for number of profiles and outputs messages
      // depending on the number of profiles.
      if (loadedProfile != null) {
        System.out.println(totalPremium);
        for (int i = 0; i < loadedProfile.getPolicyCount(); i++) {
          PolicyType policyType = loadedProfile.getPolicies().get(i).getType();
          if (policyType == PolicyType.HOME) {
            Home homePolicy = (Home) loadedProfile.getPolicies().get(i);
            if (loadedProfile.getPolicyCount() == 2) {
              discountedPremium1 = (int) (homePolicy.getBasePremium() * 0.9);
            }
            if (loadedProfile.getPolicyCount() >= 3) {
              discountedPremium1 = (int) (homePolicy.getBasePremium() * 0.8);
            }
            if (loadedProfile.getPolicyCount() == 1) {
              discountedPremium1 = homePolicy.getBasePremium();
            }
            // int policySize = loadedProfile.getPolicies().size();
            // ((Home) loadedProfile.getPolicies().get(policySize -
            // 1)).setDiscountPremium(discountedPremium);
            MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                homePolicy.getAddress(),
                Integer.toString(homePolicy.getSum()),
                Integer.toString(homePolicy.getBasePremium()),
                Integer.toString(discountedPremium1));

            totalPremium = totalPremium + discountedPremium1;
          }
          if (policyType == PolicyType.CAR) {
            Car carPolicy = (Car) loadedProfile.getPolicies().get(i);
            if (loadedProfile.getPolicyCount() == 2) {
              discountedPremium2 = (int) (carPolicy.getBasePremium(loadedProfile.getAge()) * 0.9);

            } else if (loadedProfile.getPolicyCount() >= 3) {
              discountedPremium2 = (int) (carPolicy.getBasePremium(loadedProfile.getAge()) * 0.8);

            } else {
              discountedPremium2 = (int) carPolicy.getBasePremium(loadedProfile.getAge());
            }
            // int policySize = loadedProfile.getPolicies().size();
            // ((Car) loadedProfile.getPolicies().get(policySize - 1))
            //    .setDiscountPremium(discountedPremium);
            MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                carPolicy.getMakeModel(),
                Integer.toString(carPolicy.getSum()),
                Integer.toString(carPolicy.getBasePremium(loadedProfile.getAge())),
                Integer.toString(discountedPremium2));

            totalPremium = totalPremium + discountedPremium2;
          }
          if (policyType == PolicyType.LIFE) {
            Life lifePolicy = (Life) loadedProfile.getPolicies().get(i);
            if (loadedProfile.getPolicyCount() == 2) {
              discountedPremium3 = (int) (lifePolicy.getBasePremium(loadedProfile.getAge()) * 0.9);

            } else if (loadedProfile.getPolicyCount() >= 3) {
              discountedPremium3 = (int) (lifePolicy.getBasePremium(loadedProfile.getAge()) * 0.8);

            } else {
              discountedPremium3 = (int) lifePolicy.getBasePremium(loadedProfile.getAge());
            }

            // int policySize = loadedProfile.getPolicies().size();
            // ((Life) loadedProfile.getPolicies().get(policySize - 1))
            //    .setDiscountPremium(discountedPremium);
            MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                Integer.toString(lifePolicy.getSum()),
                Integer.toString(lifePolicy.getBasePremium(loadedProfile.getAge())),
                Integer.toString(discountedPremium3));

            totalPremium = totalPremium + discountedPremium3;
          }
        }
      }
      if (loadedProfile == null) {
        for (int i = 0; i < db.get(j).getPolicyCount(); i++) {
          PolicyType pType = db.get(j).getPolicies().get(i).getType();
          if (pType == PolicyType.HOME) {
            Home homePolicy = (Home) db.get(j).getPolicies().get(i);
            if (db.get(j).getPolicyCount() == 2) {
              discountedPremium4 = (int) (homePolicy.getBasePremium() * 0.9);
            }
            if (db.get(j).getPolicyCount() >= 3) {
              discountedPremium4 = (int) (homePolicy.getBasePremium() * 0.8);
            }
            if (db.get(j).getPolicyCount() == 1) {
              discountedPremium4 = homePolicy.getBasePremium();
            }
            MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                homePolicy.getAddress(),
                Integer.toString(homePolicy.getSum()),
                Integer.toString(homePolicy.getBasePremium()),
                Integer.toString(discountedPremium4));
            // int policySize = loadedProfile.getPolicies().size();
            // ((Home) loadedProfile.getPolicies().get(policySize -
            // 1)).setDiscountPremium(discountedPremium);
            total2 = total2 + discountedPremium4;
          }
          if (pType == PolicyType.CAR) {
            Car carPolicy = (Car) db.get(j).getPolicies().get(i);
            if (db.get(j).getPolicyCount() == 2) {
              discountedPremium5 = (int) (carPolicy.getBasePremium(db.get(j).getAge()) * 0.9);

            } else if (db.get(j).getPolicyCount() >= 3) {
              discountedPremium5 = (int) (carPolicy.getBasePremium(db.get(j).getAge()) * 0.8);

            } else {
              discountedPremium5 = (int) carPolicy.getBasePremium(db.get(j).getAge());
            }
            MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                carPolicy.getMakeModel(),
                Integer.toString(carPolicy.getSum()),
                Integer.toString(carPolicy.getBasePremium(db.get(j).getAge())),
                Integer.toString(discountedPremium5));
            // int policySize = loadedProfile.getPolicies().size();
            // ((Car) loadedProfile.getPolicies().get(policySize - 1))
            //    .setDiscountPremium(discountedPremium);

            total2 = total2 + discountedPremium5;
          }
          if (pType == PolicyType.LIFE) {
            Life lifePolicy = (Life) db.get(j).getPolicies().get(i);
            if (db.get(j).getPolicyCount() == 2) {
              discountedPremium6 = (int) (lifePolicy.getBasePremium(db.get(j).getAge()) * 0.9);

            } else if (db.get(j).getPolicyCount() >= 3) {
              discountedPremium6 = (int) (lifePolicy.getBasePremium(db.get(j).getAge()) * 0.8);

            } else {
              discountedPremium6 = (int) lifePolicy.getBasePremium(db.get(j).getAge());
            }
            MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                Integer.toString(lifePolicy.getSum()),
                Integer.toString(lifePolicy.getBasePremium(db.get(j).getAge())),
                Integer.toString(discountedPremium6));

            // int policySize = loadedProfile.getPolicies().size();
            // ((Life) loadedProfile.getPolicies().get(policySize - 1))
            //    .setDiscountPremium(discountedPremium);
            total2 = total2 + discountedPremium6;
          }
        }
      }

      for (int i = 0; i < db.size(); i++) {
        if (db.size() == 1) {
          System.out.println(MessageCli.PRINT_DB_POLICY_COUNT.getMessage("1", "", ":"));
          System.out.println(
              " "
                  + (1)
                  + ":"
                  + " "
                  + db.get(0).getName()
                  + ", "
                  + db.get(0).getAge()
                  + ", "
                  + db.get(i).getPolicies().size()
                  + " "
                  + "policies for a total of $"
                  + total2);
          return;
        }
      }

      System.out.println(
          MessageCli.PRINT_DB_POLICY_COUNT.getMessage(String.format("%d", db.size()), "s", ":"));

      // for (int i = 0; i < db.size(); i++) { // prints out the profiles in the database
      if (loadedProfile == null) {
        if (db.get(j).getPolicyCount() == 1) {
          System.out.println(
              " "
                  + (j + 1)
                  + ":"
                  + " "
                  + db.get(j).getName()
                  + ", "
                  + db.get(j).getAge()
                  + ", "
                  + "1"
                  + " "
                  + "policy for a total of $"
                  + total2);
        } else {
          System.out.println(
              " "
                  + (j + 1)
                  + ":"
                  + " "
                  + db.get(j).getName()
                  + ", "
                  + db.get(j).getAge()
                  + ", "
                  + db.get(j).getPolicies().size()
                  + " "
                  + "policies for a total of $"
                  + total2);
        }

      } else {
        db.set(
            db.indexOf(loadedProfile),
            loadedProfile); // if the index the loaded profile is the same as the index of the
        // profile in the database, it will be marked with ***
        if (j == db.indexOf(loadedProfile)) {
          if (db.get(j).getPolicies().size() == 0) {
            System.out.println(
                "*** "
                    + (j + 1)
                    + ":"
                    + " "
                    + db.get(j).getName()
                    + ", "
                    + db.get(j).getAge()
                    + ", "
                    + "0"
                    + " "
                    + "policies for a total of $0");
          } else if (db.get(j).getPolicies().size() == 1) {
            System.out.println(
                "*** "
                    + (j + 1)
                    + ":"
                    + " "
                    + db.get(j).getName()
                    + ", "
                    + db.get(j).getAge()
                    + ", "
                    + "1"
                    + " "
                    + "policy for a total of $"
                    + totalPremium);
          } else {
            System.out.println(
                "*** "
                    + (j + 1)
                    + ":"
                    + " "
                    + db.get(j).getName()
                    + ", "
                    + db.get(j).getAge()
                    + ", "
                    + db.get(j).getPolicies().size()
                    + " "
                    + "policies for a total of $"
                    + totalPremium);
          }
        } else {
          System.out.println(
              " "
                  + (j + 1)
                  + ":"
                  + " "
                  + db.get(j).getName()
                  + ", "
                  + db.get(j).getAge()
                  + ", "
                  + db.get(j).getPolicies().size()
                  + " "
                  + "policies for a total of $"
                  + total2);
        }
      }
      // }
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
    for (int i = 0; i < db.size(); i++) { // works for first test
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

  public void unloadProfile() { // unloads profile
    for (int i = 0; i < db.size(); i++) {
      if (loadedProfile == null) {
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

    if (loadedProfile != null
        && loadedProfile.getName().equals(userName)) { // loadedProfile is the same as userName
      MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(userName);
      return;
    }
    for (int i = 0; i < db.size(); i++) {
      if (userName.equals(db.get(i).getName())) { // delete profile successfully
        db.remove(i);
        profileFound = true;
        MessageCli.PROFILE_DELETED.printMessage(userName);
      }
    }
    if (!profileFound) {
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
    }
  }

  public void createPolicy(PolicyType type, String[] options) {

    if (loadedProfile == null) { // if no profile is loaded, it will not create a policy
      System.out.println("Need to load a profile in order to create a policy.");
      return;
    }

    if (type == PolicyType.HOME) { // creates a new policy based on the type
      Home homePolicy = new Home(options[0], options[1], options[2]);
      loadedProfile.addPolicy(homePolicy);
      MessageCli.NEW_POLICY_CREATED.printMessage("home", loadedProfile.getName());
    }
    if (type == PolicyType.CAR) {
      Car carPolicy = new Car(options[0], options[1], options[2], options[3]);
      loadedProfile.addPolicy(carPolicy);
      MessageCli.NEW_POLICY_CREATED.printMessage("car", loadedProfile.getName());
    }
    if (type == PolicyType.LIFE) {
      // check arraylist if there is a life policy.
      // if there is, print message saying that the user already has a life policy
      // if there isn't, create a new life policy
      if (loadedProfile.getAge() > 100) {
        MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(loadedProfile.getName());
        return;
      }
      for (int i = 0; i < loadedProfile.getPolicyCount(); i++) {
        System.out.println(loadedProfile.getAge());
        if (loadedProfile.getPolicies().get(i).getType() == PolicyType.LIFE) {
          MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(loadedProfile.getName());
        } else {
          Life lifePolicy = new Life(options[0]);
          loadedProfile.addPolicy(lifePolicy);
          MessageCli.NEW_POLICY_CREATED.printMessage("life", loadedProfile.getName());
          return;
        }
      }
    }
  }
}
