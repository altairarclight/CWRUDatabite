package cwru.databite.databite.Implementation;

public class SiteAdminImpl extends UserImpl {
    String username;
    String password;
    int companyId;

    public SiteAdminImpl(String uname, String pswrd, int compId) {
        super(uname, pswrd, compId);
    }

    public boolean createUser(UserImpl user) {
        return user.userRegistration();
    }

    public boolean deleteUser(UserImpl user, int companyID) {
        TableImpl userTable = new TableImpl();

        if (user.getCompanyId() == companyID) {
            return userTable.delete(user);
        }
        return false;
    }

    public boolean addUserToCompanyDatabase(UserImpl user, int companyID) {
        TableImpl compDBTable = new TableImpl();

        return compDBTable.insert(user);
    }
}
