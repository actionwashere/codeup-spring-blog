package com.codeup.codeupspringblog.controllers.posts;

import com.codeup.codeupspringblog.models.posts.Post;
import com.codeup.codeupspringblog.models.posts.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {

    // DEPENDENCY INJECTION //

    private final PostRepository postsDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postsDao, UserRepository userDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    // END DEPENDENCY INJECTION //

    @GetMapping("/posts/{id}")
    public String postById(@PathVariable long id, Model model) {
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @PostMapping("/create/post")
    public String createPost(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.findById(user.getId());
        Post newPost = new Post(post.getTitle(), post.getBody(), thisUser);
        emailService.prepareAndSendCreate(newPost);
        postsDao.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/delete")
    public String deletePostById(@RequestParam(name="id") long id) {

        Post post = postsDao.findById(id);
        postsDao.delete(post);
        emailService.prepareAndSendDelete(post);
        return "redirect:/posts";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable(name="id") long id, @RequestParam String title, @RequestParam String body, Model model){
        Post thisPost = postsDao.findById(id);
        Post updatedPost = new Post(title, body);
        System.out.println(updatedPost);
        postsDao.save(updatedPost);
        return "redirect:/posts";
    }
}
