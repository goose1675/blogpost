package com.agam.pcc.blogpost.controller;

import com.agam.pcc.blogpost.model.Blog;
import com.agam.pcc.blogpost.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// This annotation indicates that this class is a REST controller, which handles HTTP requests and responses.
// It allows the class to handle requests at the specified URL path.
@RequestMapping("/blogs")
// This annotation specifies the base URL path for all methods in this controller.
// In this case, all blog-related endpoints will start with "/blogs".
public class BlogController {

    @Autowired
    // This annotation automatically injects an instance of BlogService into this controller.
    private BlogService blogService;

    // Add a new blog
    @PostMapping
    // This annotation maps HTTP POST requests to this method.
    // It indicates that this method will handle requests to create a new blog.
    public Blog addBlog(@RequestBody Blog blog) {
        return blogService.addBlog(blog);
    }

    // Delete a blog by ID
    @DeleteMapping("/{id}")
    // This method handles DELETE requests to remove a blog by its ID.
    // It uses the @PathVariable annotation to extract the blog ID from the URL.
    public void deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
    }

    // Update a blog
    @PutMapping("/{id}")
    // This method handles PUT requests to update an existing blog.
    // It uses the @PathVariable annotation to extract the blog ID from the URL and the
    public Blog updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        return blogService.updateBlog(id, blog);
    }

    // View all blogs
    @GetMapping
    // This method handles GET requests to retrieve all blogs.
    // It uses the BlogService to fetch the list of blogs and returns it.
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    // View blogs by user ID
    @GetMapping("/user/{userId}")
    // This method retrieves all blogs associated with a specific user ID.
    // It uses the @PathVariable annotation to extract the user ID from the URL.
    public List<Blog> getBlogsByUserId(@PathVariable Long userId) {
        return blogService.getBlogsByUserId(userId);
    }
}
