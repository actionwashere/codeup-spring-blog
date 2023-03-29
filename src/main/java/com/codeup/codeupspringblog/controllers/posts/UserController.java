package com.codeup.codeupspringblog.controllers.posts;

import com.codeup.codeupspringblog.models.posts.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }


    @PostMapping("/register")
    public String registerUser(@RequestParam(name="username") String username, @RequestParam(name="email") String email, @RequestParam(name="password") String password){
        User user = new User(username, email, password);
        userDao.save(user);
        return "redirect:/ads";
    }

}
