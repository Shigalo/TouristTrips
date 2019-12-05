/*
package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Entities.*;
import by.bsuir.gunko7.Repositories.UserRepository;
import by.bsuir.gunko7.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/requests")
public class RequestsController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
    @Autowired
    RequestService requestService;
    @Autowired
    TransportService transportService;
    @Autowired
    PointService pointService;
    @Autowired
    WayService wayService;

    @GetMapping
    public String setForm2(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        if(userService.isAdmin()) { model.addAttribute("requestList", requestService.getRequestList()); }
        else { model.addAttribute("requestList", requestService.getRequestList(userService.getCurrentUser())); }
        return "requests";
    }

    @GetMapping("/addRequest")
    public String addTransport(Model model) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("transportList", transportService.getTransportList());


        List<Tour> tourList = wayService.getWayList();
        model.addAttribute("wayList", tourList);
        model.addAttribute("wayService", wayService);

        return "addRequest";
    }

    @PostMapping("/addRequest")
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
    }
}
*/
