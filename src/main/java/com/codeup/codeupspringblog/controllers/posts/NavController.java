package com.codeup.codeupspringblog.controllers.posts;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class NavController {
    @GetMapping("/posts")
    public String postsIndex (Model model) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post("Index Post Test 1", "This is the first of three index post tests. It should be displayed with three other posts"),
                new Post ("Index Post Test 2", "This is the second of three index post tests. It should be displayed with three other posts."),
                new Post ("Index Post Test 3", "This is the third of three index post tests. It should be displayed with three other posts.")
        ));
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
