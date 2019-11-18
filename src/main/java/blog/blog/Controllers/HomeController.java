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
    public String loginForm(Model model, String username, String password){
        log.info("Getting mapping for loginform in: " + this.getClass());


        model.addAttribute("user", userService.authenticateUser(username, password));

        return "login";
    }


    @PostMapping("/")
    public String login(Model model, @ModelAttribute User user){

        log.info("getting post mapping for login in: " + this.getClass());
        User currentUser = userService.authenticateUser(user.getUsername(), user.getPassword());

        if (currentUser.getUsername() == user.getUsername() && currentUser.getPassword() == user.getPassword()){
            model.addAttribute("current", currentUser);
            return "redirect:/home";
        } else {

        } return "login";

    }

    @GetMapping("/home")
    public String Home(Model model) {
        log.info("Home hentes i: " + this.getClass());
        List<UserPost> upList = userPostService.fetchAll();
        model.addAttribute("getAll", upList);

        return "home";

    }

}
