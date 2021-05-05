package cwru.databite.databite.Implementation;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cwru.databite.databite.Tables.User;
import cwru.databite.databite.Tables.UserRepository;

@ControllerAdvice
@RequestMapping(path = "companyadmin")
public class CompanyAdminImpl extends UserImpl {

    private UserRepository userRepo;

    public CompanyAdminImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepo = userRepository;
    }

    @DeleteMapping(path = "/deleteuser")
    public boolean deleteCompanyUser(User user) {
        User currentUser = new User();
        if (user.getCompany().getCompanyID() == currentUser.getCompany().getCompanyID()) {
            userRepo.delete(user);
            return true;
        }
        return false;
    }

    @PostMapping(path = "/addtodatabase")
    public boolean addUserToCompanyDatabase(User user, int companyID) {
        // TODO: Figure out how to do this
        return true;
    }
}
