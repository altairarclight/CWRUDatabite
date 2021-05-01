package cwru.databite.databite.Interface;

public interface IUser {
    public boolean userRegistration();

    public boolean userDelete();

    public boolean userModify(String uname, String pswrd, String compId);
}
