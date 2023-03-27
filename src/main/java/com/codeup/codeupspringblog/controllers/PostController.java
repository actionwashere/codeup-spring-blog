package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
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

    @GetMapping("/posts/{id}")
    public String postById (@PathVariable long id, Model model) {
        Post post = new Post("Single Test Post", "This is a test post, it is supposed to show an individual post.");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/create")
    public String showCreatePostForm () {
        return "posts/create";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost () {
        return "create a new post";
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
