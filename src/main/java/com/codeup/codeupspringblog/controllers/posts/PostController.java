package com.codeup.codeupspringblog.controllers.posts;

import com.codeup.codeupspringblog.models.posts.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class PostController {

    // DEPENDENCY INJECTION //

    private PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    // END DEPENDENCY INJECTION //

    @GetMapping("/posts/{id}")
    public String postById(@PathVariable long id, Model model) {
        Optional<Post> post = postsDao.findById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());

        }
        return "posts/show";
    }

    @PostMapping("/create/post")
    @ResponseBody
    public String createPost() {
        Post post = new Post("this is a created post", "This is a post that was created using the create");
        postsDao.save(post);
        return "redirect:/posts";
    }

}
