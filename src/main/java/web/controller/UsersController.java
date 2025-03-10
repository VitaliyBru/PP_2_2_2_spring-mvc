package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.services.UserServiceImp;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserServiceImp userService;

    @Autowired
    public UsersController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/users";
    }

    @GetMapping("/user")
    public String showUser(@RequestParam(value = "id", required = false) Integer id, Model model) {
        model.addAttribute("user", userService.findOneById(id));
        return "users/person";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/new";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam(value = "id", required = false) Integer id, Model model) {
        User user = userService.findOneById(id);
        if (user == null) {
            return "redirect:/users";
        }
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult result,
                             @RequestParam(value = "id") Integer id) {
        if (result.hasErrors()) {
            return "users/edit";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
