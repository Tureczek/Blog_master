package blog.blog.Services;

import blog.blog.Models.User;

import java.util.List;

public interface UserService {

     List<User> fetchAllUsers();

    User authenticateUser(String username, String password);

}
