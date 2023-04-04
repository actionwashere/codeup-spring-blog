package com.codeup.codeupspringblog.controllers.posts;

import com.codeup.codeupspringblog.models.posts.Post;
import com.codeup.codeupspringblog.models.posts.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class NavController {

    // DEPENDENCY INJECTION //

    private PostRepository postsDao;
    private UserRepository userDao;

    public NavController(PostRepository postsDao, UserRepository userDao) {
        this.postsDao = postsDao;
        this.userDao = userDao;
    }

    // END DEPENDENCY INJECTION //

    @GetMapping("/posts")
    public String postsIndex (Model model) {
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/create")
    public String showCreatePostForm (Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @GetMapping("/profile")
    public String showProfile () {
        return "posts/profile";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "posts/register";
    }

    @GetMapping("/show/{id}")
    public String showSinglePostView (@PathVariable(name="id") long id, Model model){
       Post post = postsDao.findById(id);
       model.addAttribute("post", post);
       return "posts/show";
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable(name="id") long id, Model model) {
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }
}
