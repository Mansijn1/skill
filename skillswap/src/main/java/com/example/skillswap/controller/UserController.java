
package com.example.skillswap.controller;
import com.example.skillswap.service.UserService;
import com.example.skillswap.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//
//    @GetMapping("/signup")
//    public String signupForm(Model model) {
//        model.addAttribute("user", new User());
//        return "signup";
//    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {
        userService.registerUser(user.getUsername(), user.getPassword());
        return "redirect:/login";
    }

//
//    @GetMapping("/login")
//    public String loginForm() {
//        return "login";
//    }

//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        Model model) {
//        User user = userService.login(username, password); // use username
//        if (user != null) {
//            model.addAttribute("username", user.getUsername());
//            return "index"; // redirect to home page
//        }
//        model.addAttribute("error", "Invalid username or password");
//        return "login";
//    }

}
