package web.controller;

import org.springframework.web.bind.annotation.*;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping(value = "/users")
    public String usersPage(Model model){
        model.addAttribute("usersList", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping(value = "/users/new")
    public String inputForm(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping(value = "users/{id}/edit")
    public String editForm(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.showUserById(id));
        return "edit";
    }

    @PatchMapping(value = "users/{id}/edit")
    public String editUser(@PathVariable("id") long id, @ModelAttribute("user") User user){
        userService.editUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/users/{id}/delete")
    public String deleteUser(@PathVariable("id") long id){
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/{id}")
    public String showUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.showUserById(id));
        return "showUser";
    }

    @PostMapping(value = "/users")
    public String createUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}
