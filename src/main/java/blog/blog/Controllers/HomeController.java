package blog.blog.Controllers;

import blog.blog.Models.User;
import blog.blog.Models.UserPost;
import blog.blog.Services.UserPostService;
import blog.blog.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Autowired
    UserPostService userPostService;

    @GetMapping("/")
    public String loginForm(Model model){
        log.info("Getting mapping for loginform in: " + this.getClass());

        User user = new User();

        model.addAttribute("user", user);

        return "login";
    }


    @PostMapping("/")
    public String login(Model model, @ModelAttribute User user, String username, String password){

        log.info("getting post mapping for login in: " + this.getClass());
        User currentUser = userService.authenticateUser(username, password);

        if (currentUser != null){
            model.addAttribute("user", currentUser);
            return "redirect:/home/"+ currentUser.getUserId();
        } else {

        } return "login";

    }

    @GetMapping("/home/{userId}")
    public String Home(Model model, @PathVariable int userId) {

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        log.info("Home hentes i: " + this.getClass());
        List<UserPost> upList = userPostService.fetchAll();
        model.addAttribute("getAll", upList);

        return "home";

    }

    @GetMapping("home/userview/{userId}")
    public String Userview(Model model, @PathVariable int userId){
        log.info("Getting user list in: " +  this.getClass());

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        List<User> userList = userService.fetchAllUsers();
        model.addAttribute("findUser", userList);

        return "userview";
    }

}
