package sorenrahimi.g1s2m2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sorenrahimi.g1s2m2.entities.BlogPost;
import sorenrahimi.g1s2m2.services.BlogPostsService;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {
    @Autowired
    private BlogPostsService blogPostsService;

    // 1. GET http://localhost:3001/blogPosts
    @GetMapping
    private List<BlogPost> getAllBlogPosts(){
        return this.blogPostsService.getBlogPostsList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost saveBlogPost(@RequestBody BlogPost body){
        return this.blogPostsService.saveBlogPost(body);
    }

    @GetMapping("/{blogPostId}")
    private BlogPost findUserById(@PathVariable int blogPostId){
        return this.blogPostsService.findById(blogPostId);
    }

    @PutMapping("/{blogPostId}")
    private BlogPost findUserByIdAndUpdate(@PathVariable int blogPostId, @RequestBody BlogPost body){
        return this.blogPostsService.findByIdAndUpdate(blogPostId, body);
    }

    // 5. DELETE http://localhost:3001/blogPosts/{userId}
    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findUserByIdAndDelete(@PathVariable int blogPostId){
        this.blogPostsService.findByIdAndDelete(blogPostId);
    }
}
