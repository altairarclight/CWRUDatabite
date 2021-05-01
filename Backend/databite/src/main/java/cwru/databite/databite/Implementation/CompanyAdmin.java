package cwru.databite.databite.Implementation;

public class CompanyAdmin extends User {
    String username;
    String password;
    String companyId;

    public CompanyAdmin(String uname, String pswrd, int compId) {
        super(uname, pswrd, compId);
    }

    public boolean deleteCompanyUser(User user) {
        Table table = new Table();

        return table.delete(user);
    }

    public boolean addUserToCompanyDatabase(User user) {
        Table compDBTable = new Table();

        return compDBTable.insert(user);
    }
}
