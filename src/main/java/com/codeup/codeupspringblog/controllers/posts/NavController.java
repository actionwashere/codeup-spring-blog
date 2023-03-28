package com.codeup.codeupspringblog.controllers.posts;

import com.codeup.codeupspringblog.models.posts.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class NavController {

    // DEPENDENCY INJECTION //

    private PostRepository postsDao;

    public NavController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    // END DEPENDENCY INJECTION //

    @GetMapping("/posts")
    public String postsIndex (Model model) {
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/create")
    public String showCreatePostForm () {
        return "posts/create";
    }

    @GetMapping("/profile")
    public String showProfile () {
        return "posts/profile";
    }

    @GetMapping("/log-in")
    public String showLogIn () {
        return"posts/log-in";
    }
}
