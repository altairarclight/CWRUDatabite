package cwru.databite.databite.Implementation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cwru.databite.databite.Interface.IUser;
import cwru.databite.databite.Tables.UserRepository;

@Controller
@RequestMapping(path = "user")
public class UserImpl implements IUser {

    String username;
    String password;
    int companyId;

    private UserRepository userRepo;

    public UserImpl(String uname, String pswrd, int compId) {
        username = uname;
        password = pswrd;
        companyId = compId;
    }

    @PostMapping(path = "/registration")
    @Override
    public boolean userRegistration() {
        // Save username, password, companyId to user table in DB by calling Table class
        TableImpl userTable = new TableImpl();

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
        return userTable.insert(new UserImpl(username, passwordHash, companyId));
    }

    @Override
    public boolean userDelete() {
        // Delete user with username and company Id
        TableImpl userTable = new TableImpl();

        // return true; If successful
        return userTable.delete(new UserImpl(username, password, companyId));
    }

    @Override
    public boolean userModify(String uname, String pswrd, String compId) {
        // Modify an existing user
        TableImpl userTable = new TableImpl();

        // return true; if successful
        return userTable.modify(uname, pswrd, compId);
    }

    public String getUsername() {
        return username;
    }

    public int getCompanyId() {
        return companyId;
    }

}
