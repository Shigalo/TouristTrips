package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Entities.Flight;
import by.bsuir.gunko7.Services.FlightService;
import by.bsuir.gunko7.Services.TourService;
import by.bsuir.gunko7.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/flights")
public class FlightsController {

    @Autowired
    UserService userService;
    @Autowired
    FlightService flightService;

    @GetMapping("")
    public String viewFlights(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("flightList", flightService.findAll());
        return "flights/flights";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        return "flights/newFlight";
    }

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String create(@RequestParam String out,
                         @RequestParam String target,
                         @RequestParam String departure,
                         @RequestParam String arrival,
                         @RequestParam Double cost,
                         Model model) throws ParseException {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        Flight flight = new Flight(out, target, cost,
                new Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(departure).getTime()),
                new Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(arrival).getTime()));
        flightService.addFlight(flight);
        return "redirect:/flights";
    }

    @GetMapping("/remove/{id}")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String remove(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        flightService.removeById(id);
        return "redirect:/flights";
    }
}
