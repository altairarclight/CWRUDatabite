package cwru.databite.databite.Implementation;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cwru.databite.databite.Interface.IUser;
import cwru.databite.databite.Tables.DataSet;
import cwru.databite.databite.Tables.DataSetRepository;
import cwru.databite.databite.Tables.User;
import cwru.databite.databite.Tables.UserDataSets;
import cwru.databite.databite.Tables.UserDataSetsRepository;
import cwru.databite.databite.Tables.UserRepository;

@Controller
@RequestMapping(path = "user")
public class UserImpl implements IUser {

    private UserRepository userRepo;
    private UserDataSetsRepository userDataSetRepo;
    private DataSetRepository datasetRepo;

    public UserImpl(UserRepository userRepository, UserDataSetsRepository userDataSetRepository,
            DataSetRepository datasetRepository) {
        this.userRepo = userRepository;
        this.userDataSetRepo = userDataSetRepository;
        this.datasetRepo = datasetRepository;
    }

    @PostMapping(path = "/registration")
    @Override
    public boolean userRegistration(String email, String password) {

        User newUser = new User();

        newUser.setPassword(password);
        newUser.setUsername(email);

        if (userRepo.save(newUser) != null) {
            // return true; If operation successful
            return true;
        }
        // else return false
        return false;
    }

    @GetMapping(path = "/login")
    @Override
    public boolean userLogin(String email, String password) {
        User user = userRepo.findByUsername(email).stream().findFirst().get();

        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @DeleteMapping(path = "/delete")
    @Override
    public boolean userDelete(String username) {
        userRepo.delete(userRepo.findByUsername(username).stream().findFirst().get());

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
        try {
            return userRepo.findByUsername(username).stream().findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }

    }

    @PutMapping(path = "/updatepassword")
    @Override
    public boolean updatePassword(String username, String password) {
        User user = userRepo.findByUsername(username).stream().findFirst().get();

        user.setPassword(password);

        if (userRepo.save(user) != null) {
            return true;
        }
        return false;
    }

    @PutMapping(path = "/updatedatasetpermission")
    public boolean updateDataSetPermission(String username, int datasetID, boolean canEdit) {
        UserDataSets userDs = new UserDataSets();
        DataSet ds = new DataSet();

        ds = datasetRepo.findByDatasetID(datasetID).stream().findFirst().get();

        userDs.setCanEdit(canEdit);
        userDs.setDataSet(ds);
        userDs.setUser(userRepo.findByUsername(username).stream().findFirst().get());

        if (userDataSetRepo.save(userDs) != null) {
            return true;
        }
        return false;
    }
}
