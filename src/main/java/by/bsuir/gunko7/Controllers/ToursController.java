package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Entities.Flight;
import by.bsuir.gunko7.Entities.Info;
import by.bsuir.gunko7.Entities.Tour;
import by.bsuir.gunko7.Services.InfoService;
import by.bsuir.gunko7.Services.TourService;
import by.bsuir.gunko7.Services.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/tours")
public class ToursController {

    @Autowired
    UserService userService;
    @Autowired
    TourService tourService;
    @Autowired
    InfoService infoService;

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
                         @RequestParam String date,
                         Model model) throws ParseException {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        Tour tour = new Tour(target, name, places, false,
                new Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date).getTime()));
        tourService.addTour(tour);
        return "redirect:/tours/tourInfo/" + tour.getId();
    }

    @GetMapping("/tourInfo/{id}")
    public String addInfo(Model model, @PathVariable String id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        Tour tour = tourService.findById(id);
        model.addAttribute("tour", tour);
        model.addAttribute("infoList", infoService.findByTour(tour));
        return "tours/tourInfo";
    }

    @PostMapping("/tourInfo/{id}")
    public String setInfo(Model model, @PathVariable String id,
                          @RequestParam("image") MultipartFile tourImage,
                          @RequestParam String tourName,
                          @RequestParam String tourText,
                          @RequestParam String tourTarget,
                          @RequestParam String[] about,
                          @RequestParam String[] header,
                          @RequestParam Integer[] sequence,
                          @RequestParam(value = "posting", required = false) String posting,
                          @RequestParam("image") MultipartFile[] image) throws SQLException, IOException {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());

        Tour tour = tourService.findById(id);
        List<Info> infos = infoService.findByTour(tour);
        infoService.clear(tour);
        Blob blob;
        if(about.length != 1) {
            for (int i = 1; i < about.length; i++) {
                blob = new SerialBlob(image[i].getBytes());
                if (blob.length() == 0) { for (Info info : infos) { if (sequence[i] == info.getSequence()) { blob = info.getPicture();break; } } }
                infoService.addInfo(new Info(tourService.findById(id), i, header[i], about[i], blob));
            }
        }
        tour.setPost(posting != null);
        blob = new SerialBlob(tourImage.getBytes());
        if (blob.length() != 0) tour.setPicture(blob);
        tour.setName(tourName);
        tour.setAbout(tourText);
        tour.setTarget(tourTarget);

        tourService.update(tour);
        return "redirect:/tours";
    }

    @GetMapping("getTour/{id}")
    public String getTour(Model model, @PathVariable String id) {
        model.addAttribute("isLogin", userService.isLogin());
        model.addAttribute("isAdmin", userService.isAdmin());
        Tour tour = tourService.findById(id);
        model.addAttribute("tour", tour);
        model.addAttribute("infoList", infoService.findByTour(tour));
        return "tours/getTour";
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
