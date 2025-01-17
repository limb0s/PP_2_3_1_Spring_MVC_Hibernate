package org.limb0s.controllers;

import org.limb0s.models.User;
import org.limb0s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("userList",userService.getUsers());
        return "user/users";
    }

    @GetMapping("/addUser")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "user/newUser";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/update")
    public String update(Model model,@RequestParam("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "user/updateUser";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") int id,@ModelAttribute("user") User user) {
        userService.updateUser(id,user);
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }

}
