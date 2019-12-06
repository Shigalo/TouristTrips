package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Entities.Flight;
import by.bsuir.gunko7.Entities.Request;
import by.bsuir.gunko7.Entities.User;
import by.bsuir.gunko7.Entities.Tour;
import by.bsuir.gunko7.Repositories.FlightRepository;
import by.bsuir.gunko7.Repositories.RequestRepository;
import by.bsuir.gunko7.Repositories.UserRepository;
import by.bsuir.gunko7.Repositories.TourRepository;
import by.bsuir.gunko7.Services.FlightService;
import by.bsuir.gunko7.Services.RequestService;
import by.bsuir.gunko7.Services.TourService;
import by.bsuir.gunko7.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    TourService tourService;
    @Autowired
    RequestService requestService;
    @Autowired
    FlightService flightService;

    @GetMapping("/")
    public String home(Model model) {
        List<User> userList = userService.findAll();
        List<Tour> tourList = tourService.findAll();
        List<Request> requestList = requestService.findAll();
        List<Flight> flightList = flightService.findAll();

        model.addAttribute("requestList", requestList.size());
        model.addAttribute("userList", userList.size());
        model.addAttribute("wayList", tourList.size());
        model.addAttribute("flightList", flightList.size());
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "homepage";
    }

   /* @GetMapping("/logout")
    public String logout(Model model) {
        return "redirect:/";
    }*/
}
