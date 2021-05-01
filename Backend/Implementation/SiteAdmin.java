package Implementation;

public class SiteAdmin extends User {
    String username;
    String password;
    String companyId;

    public SiteAdmin(String uname, String pswrd, String compId) {
        this.username = uname;
        password = pswrd;
        companyId = compId;
    }

    public boolean createUser(User user) {
        return user.userRegistration();
    }

    public boolean deleteUser(User user, String companyID) {
        Table table = new Table();

        return table.delete(user.getUsername(), companyID);
    }

    public boolean addUserToCompanyDatabase(User user, String companyID) {
        Table compDBTable = new Table();

        return compDBTable.insert(user);
    }
}
