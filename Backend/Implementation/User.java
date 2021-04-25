package Implementation;

import Interface.IUser;

public class User implements IUser {
    @Override
    public boolean userRegistration(String username, String password, String companyId) {
        // Save username, password, companyId to user table in DB by calling Table class
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
