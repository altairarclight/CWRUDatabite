package cwru.databite.databite.Interface;

import cwru.databite.databite.Tables.User;

public interface IUser {
    public boolean userRegistration(String email, String password);

    public boolean userLogin(String email, String password);

    public boolean userDelete(String username);

    public boolean userModify(User user);

    public User userGet(String username);

    public boolean updatePassword(String username, String password);
}
