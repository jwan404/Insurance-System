package nz.ac.auckland.se281;

public class Profile {
   /* private String userName;
    private String age;
    private String rank;
*/ 

    /*public Profile (String userName, String age) {
        this.userName = userName;
        this.age = age;*/


    public void zeroProfiles(){
        MessageCli.PRINT_DB_POLICY_COUNT.getMessage("0", "s", "."); 
    }

    public void oneProfile(){
        MessageCli.PRINT_DB_POLICY_COUNT.getMessage("1", "", ":"); 
    }

    public void twoProfiles(){
        MessageCli.PRINT_DB_POLICY_COUNT.getMessage("2", "s", ":"); 

    }
}