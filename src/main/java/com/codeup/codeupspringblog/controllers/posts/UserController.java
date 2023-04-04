package com.codeup.codeupspringblog.controllers.posts;

import com.codeup.codeupspringblog.models.posts.Post;
import com.codeup.codeupspringblog.models.posts.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userDao;

    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        User newUser = new User(user.getUsername(), user.getEmail(), hash);
        userDao.save(newUser);
        return "redirect:/log-in";
    }


    @GetMapping("/profile/{id}")
    public String userPosts(@PathVariable long id, Model model){
        User user = userDao.findById(id);
        model.addAttribute("user", user);
        return "posts/profile";
    }

//    @GetMapping("/log-in")
//    public String showLoginForm() {
//        return "posts/log-in";
//    }

}
