package blog.blog.Controllers;

import blog.blog.Models.Post;
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

@Controller
public class PostController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserPostService userPostService;

    @Autowired
    UserService userService;

    @GetMapping("home/edit/{id}/{userId}")
    public String updateForm(@PathVariable("id") int id, Model model, @PathVariable int userId) {
        log.info("Loding updateform in: " + this.getClass());

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        UserPost userPost = userPostService.findById(id);
        model.addAttribute("post", userPost);

        return "edit";
    }

    @PostMapping("/edit/{userId}")
    public String Update(Model model, @ModelAttribute Post post, @PathVariable int userId) {

        log.info("post edited in: " + this.getClass());

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        userPostService.update(post);

        return "redirect:/home/{userId}";
    }

    @GetMapping("home/create/{userId}")
    public String create(Model model, @PathVariable int userId) {

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        model.addAttribute("post", new Post());

        return "create";

        }
    @PostMapping("/create/{userId}")
    public String create(Model model, @ModelAttribute Post post, @PathVariable int userId){

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        userPostService.create(post);

        return "redirect:/home/{userId}";
    }

    @GetMapping("home/delete/{id}/{userId}")
    public String deleteForm(@PathVariable("id") int id, Model model, @PathVariable int userId){

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        model.addAttribute("delete", userPostService.findById(id));

        return "delete";
    }

    @PostMapping("/delete/{userId}")
    public String delete(@ModelAttribute Post post, Model model, @PathVariable int userId){

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        userPostService.delete(post.getPostId());

        return "redirect:/home/{userId}";
    }

}
