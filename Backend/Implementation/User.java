package Implementation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Interface.IUser;

public class User implements IUser {

    String username;
    String password;
    String companyId;

    public User(String uname, String pswrd, String compId) {
        this.username = uname;
        password = pswrd;
        companyId = compId;
    }

    @Override
    public boolean userRegistration() {
        // Save username, password, companyId to user table in DB by calling Table class
        Table userTable = new Table();

        // Might not need this here if its done outside of this method
        MessageDigest hasher;
        String passwordHash = "";
        try {
            hasher = MessageDigest.getInstance("MD5");
            hasher.update(password.getBytes());
            byte[] digest = hasher.digest();
            passwordHash = digest.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // return true; If operation successful
        return userTable.insertUser(username, passwordHash, companyId);
        ;
    }

    @Override
    public boolean userDelete() {
        // Delete user with username and company Id
        Table userTable = new Table();

        // return true; If successful
        return userTable.delete(username, companyId);
        ;
    }

    @Override
    public boolean userModify(String uname, String pswrd, String compId) {
        // Modify an existing user
        Table userTable = new Table();

        // return true; if successful
        return userTable.modify(username, companyId, uname, pswrd, compId);
        ;
    }

    public String getUsername() {
        return username;
    }

    public String getCompanyId() {
        return companyId;
    }

}
