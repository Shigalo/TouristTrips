package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Entities.Flight;
import by.bsuir.gunko7.Entities.Tour;
import by.bsuir.gunko7.Services.TourService;
import by.bsuir.gunko7.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/tours")
public class ToursController {

    @Autowired
    UserService userService;
    @Autowired
    TourService tourService;

    @GetMapping("")
    public String getToursList(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("tourList", tourService.findAll());
        return "tours/tours";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        return "tours/newTour";
    }

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String create(@RequestParam String target,
                         @RequestParam String name,
                         @RequestParam Integer places,
                         Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        Tour tour = new Tour(target, name, places);
        tourService.addTour(tour);
        return "redirect:/tours/tourInfo/" + tour.getId();
    }

    @GetMapping("/tourInfo/{id}")
    public String setInfo(Model model, @PathVariable String id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("tour", tourService.getById(id));
        return "tours/tourInfo";
    }

    @GetMapping("/remove/{id}")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String remove(Model model, @PathVariable Integer id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        tourService.removeById(id);
        return "redirect:/tours";
    }
}
