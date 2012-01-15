package com.jaws;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
public class BookClubController {
    private final static String URL_GB_INDEX = "/";
    private final static String URL_GB_CREATE = "/gb/new";

    @Autowired
    private BookClubService bookService;

    private UserService userService;

    @RequestMapping(URL_GB_INDEX)
    public String index(Model model) {
     
    	userService = UserServiceFactory.getUserService();
    		
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("loginHref", userService.createLoginURL(URL_GB_INDEX));
        model.addAttribute("logoutHref", userService.createLogoutURL(URL_GB_INDEX));
        
        model.addAttribute("rowCount",this.bookService.findAllPosts().size());
        model.addAttribute("posts", this.bookService.findPostPage("0"));

        return "bclub";
    }
    
    @RequestMapping(value = "/gb/list/{start}", method = RequestMethod.GET)
    public String pagerPost(@PathVariable String start,Model model) {
    
  
    	userService = UserServiceFactory.getUserService();
    		
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("loginHref", userService.createLoginURL(URL_GB_INDEX));
        model.addAttribute("logoutHref", userService.createLogoutURL(URL_GB_INDEX));
        model.addAttribute("rowCount",this.bookService.findAllPosts().size());
        model.addAttribute("start",start);
        model.addAttribute("posts", this.bookService.findPostPage(start));

        return "bclub";
    }

    

    
    @RequestMapping(value=URL_GB_CREATE, method=RequestMethod.POST)
    public String create(@RequestParam("postDesc") String postDesc, Model model) {

    	userService = UserServiceFactory.getUserService();
    		
        User user = userService.getCurrentUser();
        Date date = new Date();
        Comments post = new Comments(postDesc,user, date);
        bookService.addPost(post);

        return index(model);

    }
}