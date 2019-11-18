package blog.blog.Services;

import blog.blog.Models.User;
import blog.blog.Repositories.ProjectVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     *  Getting all users in database
     * @return returning all users in the database
     */

    @Override
    public List<User> fetchAllUsers() {

        List<User> users = new ArrayList<>();

        try{
            Connection con = DriverManager.getConnection(ProjectVariable.getUrl(), ProjectVariable.getUsername(), ProjectVariable.getPassword());
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM blog.user_table");
            while (rs.next()){
                User user = new User();

                user.setUserId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPrivs(rs.getString(4));
                users.add(user);

            }

        } catch (SQLException e){
            log.info("Couldn't fetch all users in: "+ this.getClass());

        }

        return users;
    }


    /**
     *
     * @param username Getting username from database
     * @param password getting password from database
     * @return Returning the given user to work with in the program.
     */
    public User authenticateUser(String username, String password){


        try {
            Connection con = DriverManager.getConnection(ProjectVariable.getUrl(), ProjectVariable.getUsername(), ProjectVariable.getPassword());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM blog.user_table WHERE username = ? AND password = ?");



            pstmt.setString(1, username);
            pstmt.setString(2,password);
            log.info("Getting username and password in: " + this.getClass());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){
                User user = new User();

                user.setUserId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPrivs(rs.getString(4));

                log.info("Login succeeded in: " + this.getClass());


                return user;

            }else{

                log.info("Login failed in: " + this.getClass());
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
