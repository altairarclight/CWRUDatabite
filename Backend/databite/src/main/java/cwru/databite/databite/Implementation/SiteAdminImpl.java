package cwru.databite.databite.Implementation;

import cwru.databite.databite.Tables.User;
import cwru.databite.databite.Tables.UserRepository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
@RequestMapping(path = "siteadmin")
public class SiteAdminImpl extends UserImpl {

    private UserRepository userRepo;

    public SiteAdminImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepo = userRepository;
    }

    @PostMapping(path = "/createuser")
    public boolean createUser(User user) {
        if (userRepo.save(user) != null) {
            // return true; If operation successful
            return true;
        }
        // else return false
        return false;
    }

    @DeleteMapping(path = "/deleteuser")
    public boolean deleteUser(User user, int companyID) {
        userRepo.delete(user);

        return true;
    }

    @PostMapping(path = "/addtodatabase")
    public boolean addUserToCompanyDatabase(User user, int companyID) {
        // TODO: Figure out how to do this
        return true;
    }
}
