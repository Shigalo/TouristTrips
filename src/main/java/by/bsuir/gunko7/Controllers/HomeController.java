package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Entities.Point;
import by.bsuir.gunko7.Entities.Transport;
import by.bsuir.gunko7.Entities.User;
import by.bsuir.gunko7.Entities.Way;
import by.bsuir.gunko7.Repositories.PointRepository;
import by.bsuir.gunko7.Repositories.TransportRepository;
import by.bsuir.gunko7.Repositories.UserRepository;
import by.bsuir.gunko7.Repositories.WayRepository;
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
    WayRepository wayRepository;
    @Autowired
    TransportRepository transportRepository;
    @Autowired
    PointRepository pointRepository;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        List<User> userList = userRepository.findAll();
        List<Way> wayList = wayRepository.findByTransportNull();
        List<Transport> transportList = transportRepository.findAll();
        List<Point> pointList = pointRepository.findByWayNull();

        model.addAttribute("userList", userList.size());
        model.addAttribute("wayList", wayList.size());
        model.addAttribute("transportList", transportList.size());
        model.addAttribute("pointList", pointList.size());
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        return "homepage";
    }
}
