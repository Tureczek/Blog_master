package blog.blog.Test;

import blog.blog.Services.UserPostServiceImpl;
import blog.blog.Services.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
            UserPostServiceImpl ups = new UserPostServiceImpl();

            UserServiceImpl us = new UserServiceImpl();

            //System.out.println( us.authenticateUser("Nicholas", "test1234").toString());
            System.out.println(us.findUserById(2));

    }
}
