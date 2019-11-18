package blog.blog.Controllers;

import blog.blog.Models.Post;
import blog.blog.Models.UserPost;
import blog.blog.Services.UserPostService;
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

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {

        log.info("Loding updateform in: " + this.getClass());

        UserPost userPost = userPostService.findById(id);
        model.addAttribute("post", userPost);

        return "edit";
    }

    @PostMapping("/edit")
    public String Update(@ModelAttribute Post post) {

        userPostService.update(post);

        return "redirect:/home";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("post", new Post());

        return "create";

        }
    @PostMapping("/create")
    public String create(Model model, @ModelAttribute Post post){

        userPostService.create(post);

        return "redirect:/home/";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") int id,Model model){

        model.addAttribute("delete", userPostService.findById(id));

        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Post post, Model model){

        userPostService.delete(post.getPostId());

        return "redirect:/home";
    }

}
