package cwru.databite.databite.Implementation;

public class CompanyAdminImpl extends UserImpl {
    String username;
    String password;
    String companyId;

    public CompanyAdminImpl(String uname, String pswrd, int compId) {
        super(uname, pswrd, compId);
    }

    public boolean deleteCompanyUser(UserImpl user) {
        TableImpl table = new TableImpl();

        return table.delete(user);
    }

    public boolean addUserToCompanyDatabase(UserImpl user) {
        TableImpl compDBTable = new TableImpl();

        return compDBTable.insert(user);
    }
}
