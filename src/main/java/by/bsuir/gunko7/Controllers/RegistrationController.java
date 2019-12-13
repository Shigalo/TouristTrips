package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Entities.Role;
import by.bsuir.gunko7.Entities.User;
import by.bsuir.gunko7.Repositories.UserRepository;
import by.bsuir.gunko7.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping
    public String setForm(Model  model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "accountWork/registration";
    }

    @PostMapping
    public String getForm(@RequestParam String username,
                          @RequestParam String surname,
                          @RequestParam String phone,
                          @RequestParam String password,
                          @RequestParam String passwordConfirm,
                          Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        if(!password.equals(passwordConfirm)) {
            model.addAttribute("massage", "Пароли не совпадают!");
            return "accountWork/registration";
        }
        if(userRepository.findByName(username) != null) {
            model.addAttribute("massage", "Имя пользователя уже используется!");
            return "accountWork/registration";
        }
        User user = new User(username, password, true, surname, phone);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
