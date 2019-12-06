package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Services.TourService;
import by.bsuir.gunko7.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tours")
public class ToursController {

    @Autowired
    UserService userService;
    @Autowired
    TourService tourService;

    @GetMapping
    public String getToursList(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        model.addAttribute("tourList", tourService.findAll());
        return "tours";
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
