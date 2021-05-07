package cwru.databite.databite.Implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cwru.databite.databite.Tables.Company;
import cwru.databite.databite.Tables.CompanyRepository;
import cwru.databite.databite.Tables.DataSetRepository;
import cwru.databite.databite.Tables.User;
import cwru.databite.databite.Tables.UserDataSetsRepository;
import cwru.databite.databite.Tables.UserRepository;

@Controller
@RequestMapping(path = "companyadmin")
public class CompanyAdminImpl extends UserImpl {

    private UserRepository userRepo;
    private CompanyRepository companyRepository;

    public CompanyAdminImpl(UserRepository userRepository, UserDataSetsRepository userDataSetRepository,
            DataSetRepository datasetRepository) {
        super(userRepository, userDataSetRepository, datasetRepository);
        this.userRepo = userRepository;
    }

    @PostMapping(path = "/adminregistration")
    public boolean companyAdminRegistration(String email, String password, String companyName, int companyID) {

        User newUser = new User();
        Company newCompany = new Company();

        newCompany.setCompanyID(companyID);
        newCompany.setCompanyName(companyName);

        newUser.setPassword(password);
        newUser.setUsername(email);
        newUser.setCompany(newCompany);

        if (companyRepository.save(newCompany) != null && userRepo.save(newUser) != null) {
            // return true; If operation successful
            return true;
        }
        // else return false
        return false;
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

    @GetMapping(path = "/getcompanyusers")
    public List<String> getCompanyUsers(int companyID) {
        Iterator<User> usernames = userRepo.findCompanyUsers(companyID).iterator();
        List<String> usernameList = new ArrayList<String>();

        while (usernames.hasNext()) {
            String username = usernames.next().getUsername();
            usernameList.add(username);
        }
        return usernameList;
    }
}
