package cwru.databite.databite.Implementation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cwru.databite.databite.Interface.IUser;
import cwru.databite.databite.Tables.User;
import cwru.databite.databite.Tables.UserRepository;

@Controller
@RequestMapping(path = "user")
public class UserImpl implements IUser {

    private UserRepository userRepo;

    public UserImpl(UserRepository userRepository) {
        this.userRepo = userRepository;
    }

    @PostMapping(path = "/registration")
    @Override
    public boolean userRegistration(User user) {

        // Might not need this here if its done outside of this method
        // MessageDigest hasher;
        // String passwordHash = "";
        // try {
        // hasher = MessageDigest.getInstance("MD5");
        // hasher.update(password.getBytes());
        // byte[] digest = hasher.digest();
        // passwordHash = digest.toString();
        // } catch (NoSuchAlgorithmException e) {
        // e.printStackTrace();
        // }
        if (userRepo.save(user) != null) {
            // return true; If operation successful
            return true;
        }
        // else return false
        return false;
    }

    @PostMapping(path = "/delete")
    @Override
    public boolean userDelete(User user) {
        userRepo.delete(user);

        // return true; If successful
        return true;
    }

    @PostMapping(path = "/modify")
    @Override
    public boolean userModify(User user) {
        if (userRepo.save(user) != null) {
            // return true; If operation successful
            return true;
        }
        // else return false
        return false;
    }

    @GetMapping(path = "/get")
    @Override
    public User userGet(String username) {
        return userRepo.findByUsername(username).stream().findFirst().get();
    }
}
