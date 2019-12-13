package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Entities.Flight;
import by.bsuir.gunko7.Entities.Request;
import by.bsuir.gunko7.Entities.Tour;
import by.bsuir.gunko7.Services.FlightService;
import by.bsuir.gunko7.Services.RequestService;
import by.bsuir.gunko7.Services.TourService;
import by.bsuir.gunko7.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/requests")
public class RequestsController {

    @Autowired
    UserService userService;

    @Autowired
    TourService tourService;
    @Autowired
    FlightService flightService;
    @Autowired
    RequestService requestService;

    @GetMapping("/addRequest/{id}")
    public String addTransport(Model model, @PathVariable String id) {
        model.addAttribute("isLogin", userService.isLogin());
        Tour tour = tourService.findById(id);
        List<Flight> flightList = flightService.findByTour(tour);
        model.addAttribute("tour", tourService.findById(id));
        model.addAttribute("flightList", flightList);
        model.addAttribute("flightService", flightService);

        return "requests/newRequest";
    }

    @PostMapping("/addRequest/{id}")
    public String addTransportData(@RequestParam Integer places,
                                   @RequestParam String questions,
                                   @RequestParam String flightId,
                                   @RequestParam String cost,
                                   Model model, @PathVariable String id) {
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("isLogin", userService.isLogin());

        requestService.addRequest(places, questions, flightId, Double.valueOf(cost), id);
        return "redirect:/";
//        return "redirect:/requests/userList";
    }
}
