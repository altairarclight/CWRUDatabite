package cwru.databite.databite.Interface;

import cwru.databite.databite.Tables.User;

public interface IUser {
    public boolean userRegistration(User user);

    public boolean userDelete(User user);

    public boolean userModify(User user);

    public User userGet(String username);
}
