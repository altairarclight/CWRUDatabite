package Implementation;

public class CompanyAdmin extends User {
    String username;
    String password;
    String companyId;

    public CompanyAdmin(String uname, String pswrd, String compId) {
        this.username = uname;
        password = pswrd;
        companyId = compId;
    }

    public boolean deleteCompanyUser(User user) {
        Table table = new Table();

        return table.delete(user.getUsername(), companyId);
    }

    public boolean addUserToCompanyDatabase(User user) {
        Table compDBTable = new Table();

        return compDBTable.insert(user);
    }
}
