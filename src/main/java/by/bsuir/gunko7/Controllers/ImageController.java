package by.bsuir.gunko7.Controllers;

import by.bsuir.gunko7.Services.InfoService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;

@Controller
@RequestMapping
public class ImageController {

    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "/tours/tourInfo/infoImage/{id}")
    public void getInfoImage(HttpServletResponse response, @PathVariable("id") String id) throws Exception {
        response.setContentType("image/jpeg");

        Blob picture = infoService.getById(id).getPicture();

        byte[] bytes = picture.getBytes(1, (int) picture.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
}
