package sorenrahimi.g1s2m2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sorenrahimi.g1s2m2.entities.Author;
import sorenrahimi.g1s2m2.entities.BlogPost;
import sorenrahimi.g1s2m2.services.AuthorsService;
import sorenrahimi.g1s2m2.services.BlogPostsService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    private AuthorsService authorsService;


    @GetMapping
    private List<Author> getAuthors(){
        return this.authorsService.getAuthorsList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Author saveAuthor(@RequestBody Author body){
        return this.authorsService.saveAuthor(body);
    }

    @GetMapping("/{authorId}")
    private Author findUserById(@PathVariable int authorId){
        return this.authorsService.findById(authorId);
    }

    @PutMapping("/{authorId}")
    private Author findUserByIdAndUpdate(@PathVariable int authorId, @RequestBody Author body){
        return this.authorsService.findByIdAndUpdate(authorId, body);
    }

    // 5. DELETE http://localhost:3001/blogPosts/{userId}
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findUserByIdAndDelete(@PathVariable int authorId){
        this.authorsService.findByIdAndDelete(authorId);
    }
}

