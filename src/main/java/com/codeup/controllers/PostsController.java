package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.repositories.UserRepository;
import com.codeup.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by everardosifuentes on 6/19/17.
 */


@Controller
public class PostsController {


    private final PostSvc postSvc;
      //private PostRepository postDao;
    private final UserRepository userDao;



    @Autowired
    public PostsController(PostSvc postDao, UserRepository userDao) {
        this.postSvc = postDao;
        this.userDao = userDao;
    }


    // index page - all posts
    @GetMapping("/posts")
    public String viewAll(String name, Model model) {
       model.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }


    // individual post page
    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
       model.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }



    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body, Model model
    ) {
        Post post = new Post(title, body);

        postSvc.save(post);
        model.addAttribute("post", post);
        return "posts/create";
    }


    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts/" + post.getId();
    }


    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }


/*    @PostMapping("/posts/{id}/edit")
    public String editPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body, Model model,
            @PathVariable long id
    ) {
        postSvc.findOne(id);
        return "posts";
    }*/


    @PostMapping("/post/delete")
    public String deletePost(@ModelAttribute Post post, Model model){
        postSvc.deletePost(post.getId());
        model.addAttribute("msg", "your post was deleted correctly");
        return "retrun the view with success msg";
    }

}
