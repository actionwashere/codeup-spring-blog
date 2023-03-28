package com.codeup.codeupspringblog.controllers.posts;

import com.codeup.codeupspringblog.models.posts.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts/{id}")
    public String postById (@PathVariable long id, Model model) {
        Post post = new Post("Single Test Post", "This is a test post, it is supposed to show an individual post.");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost () {
        return "create a new post";
    }

}
