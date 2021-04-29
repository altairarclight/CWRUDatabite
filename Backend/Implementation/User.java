package Implementation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Interface.IUser;

public class User implements IUser {

    @Override
    public boolean userRegistration(String username, String password, String companyId) {
        // Save username, password, companyId to user table in DB by calling Table class
        Table userTable = new Table();

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

        userTable.insertUser(username, passwordHash, companyId);
        // return true; If operation successful
        return false;
    }

    @Override
    public boolean userDelete(String username, String companyId) {
        // Delete user with username and company Id
        // return true; If successful
        return false;
    }

    @Override
    public boolean userModify(String username, String password, String companyId) {
        // Modify an existing user
        // return true; if successful
        return false;
    }

}
