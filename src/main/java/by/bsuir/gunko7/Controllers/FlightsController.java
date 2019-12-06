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

    @GetMapping
    public String viewFlights(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("flightList", flightService.findAll());
        return "flights";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("flightList", flightService.findAll());
        return "newFlight";
    }

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String create(@RequestParam String out,
                         @RequestParam String target,
                         @RequestParam String departure,
                         @RequestParam String arrival,
                         @RequestParam Integer places,
                             Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        Flight flight = new Flight();
        flight.setOutp(out);
        flight.setTarget(target);

        Date date = new Date();
        try { date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(departure); } catch (ParseException ignored) { }
        flight.setDeparture(new Timestamp(date.getTime()));
        try { date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(arrival); } catch (ParseException ignored) { }
        flight.setArrival(new Timestamp(date.getTime()));
        flight.setPlaces(places);
        flightService.addFlight(flight);

        return "redirect:/flights";
    }

    @GetMapping("/remove/{id}")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String editTransport(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        flightService.removeById(id);
        return "redirect:/flights";
    }

 /*   @PostMapping
    public String getForm(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "tours";
    }*/

   /* @GetMapping("/addWay")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addWay(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        return "addWay";
    }

    @PostMapping("/addWay")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addWayData(@RequestParam String startPoint,
                             @RequestParam String endPoint,
                             @RequestParam String nSubPoints,
                             Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("startPoint", startPoint);
        model.addAttribute("endPoint", endPoint);
        model.addAttribute("nSubPoints", nSubPoints);
        model.addAttribute("wayList", wayService.getWayList());
        return "redirect:/ways/subPoints";
    }*/
}
