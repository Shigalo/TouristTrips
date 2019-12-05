package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Entities.Request;
import by.bsuir.gunko7.Entities.User;
import by.bsuir.gunko7.Entities.Tour;
import by.bsuir.gunko7.Repositories.RequestRepository;
import by.bsuir.gunko7.Repositories.UserRepository;
import by.bsuir.gunko7.Repositories.TourRepository;
import by.bsuir.gunko7.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TourRepository tourRepository;
    @Autowired
    RequestRepository requestRepository;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        List<User> userList = userRepository.findAll();
        List<Tour> tourList = tourRepository.findAll();
        List<Request> requestList = requestRepository.findAll();

        model.addAttribute("requestList", requestList.size());
        model.addAttribute("userList", userList.size());
        model.addAttribute("wayList", tourList.size());
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "homepage";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        List<User> userList = userRepository.findAll();
        List<Tour> tourList = tourRepository.findAll();
        List<Request> requestList = requestRepository.findAll();

        model.addAttribute("requestList", requestList.size());
        model.addAttribute("userList", userList.size());
        model.addAttribute("wayList", tourList.size());
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "redirect:/";
    }
}
