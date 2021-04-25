package Interface;

public interface IUser {
    public boolean userRegistration(String username, String password, String companyId);

    public boolean userDelete(String username, String companyId);

    public boolean userModify(String username, String password, String companyId);
}
