package cwru.databite.databite.Implementation;

public class SiteAdmin extends User {
    String username;
    String password;
    int companyId;

    public SiteAdmin(String uname, String pswrd, int compId) {
        super(uname, pswrd, compId);
    }

    public boolean createUser(User user) {
        return user.userRegistration();
    }

    public boolean deleteUser(User user, int companyID) {
        Table userTable = new Table();

        if (user.getCompanyId() == companyID) {
            return userTable.delete(user);
        }
        return false;
    }

    public boolean addUserToCompanyDatabase(User user, int companyID) {
        Table compDBTable = new Table();

        return compDBTable.insert(user);
    }
}
