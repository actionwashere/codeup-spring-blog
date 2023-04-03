package com.codeup.codeupspringblog.controllers.posts;

import com.codeup.codeupspringblog.models.posts.Post;
import com.codeup.codeupspringblog.models.posts.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        User newUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
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
//    public String login(@RequestParam(name="username") String username, @RequestParam(name="password") String password){
//       Optional<User> user = userDao.findByUsername(); //make a method, findByUsername //
//        if(user.isPresent() && (user.password == password)){
//            // add user attribute to cookie and input hidden id  //
//            // send to posts //
//            // change login to log out (needs to be done with if else in partial)//
//            // remove registration (needs to be done with if else in partial)//
//        }
//
//        return "posts/index";
//    }

}
