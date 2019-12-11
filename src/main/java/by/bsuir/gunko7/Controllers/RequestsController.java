package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Entities.Flight;
import by.bsuir.gunko7.Entities.Tour;
import by.bsuir.gunko7.Services.FlightService;
import by.bsuir.gunko7.Services.TourService;
import by.bsuir.gunko7.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/addRequest/{id}")
    public String addTransport(Model model, @PathVariable String id) {
        model.addAttribute("isLogin", userService.isLogin());
        Tour tour = tourService.findById(id);
        List<Flight> flightList = flightService.findForTour(tour);
        model.addAttribute("tour", tourService.findById(id));
        model.addAttribute("flightList", flightList);

        return "requests/newRequest";
    }

    /*@PostMapping("/addRequest")
    public String addTransportData(@RequestParam String weight,
                                   @RequestParam String id,
                                   @RequestParam String type,
                                   Model model) {
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("isLogin", userService.isLogin());

        Tour tour = wayService.getById(id);
        User user = userService.getCurrentUser();
        Double cost = Double.valueOf(weight);
        switch (type) {
            case "dangerous": cost *= wayService.getDangerous(tour); break;
            case "fragile": cost *= wayService.getFragile(tour); break;
            case "perishable": cost *= wayService.getPerishable(tour); break;
            case "normal": cost *= wayService.getCost(tour); break;
        }
        Request request = new Request(tour, user, Double.valueOf(weight), cost);
        request.setComplete(false);
        requestService.addRequest(request);

        model.addAttribute("requestList", requestService.getRequestList(userService.getCurrentUser()));
        return "redirect:/requests";
    }

    @GetMapping("/push")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String pushChoice(Model model) {
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("wayList", wayService.getWayList());
        model.addAttribute("requests", requestService.getWaitingRequestList());
        model.addAttribute("wayService", wayService);

        return "push";
    }

    @GetMapping("/pushing")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String pushComplete(Model model,
                               @RequestParam String get) {
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("isLogin", userService.isLogin());

        for(String id : get.split(",")) {
            requestService.complete(id);
        }
        return "redirect:/requests";
    }*/
}
