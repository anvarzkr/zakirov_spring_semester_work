package ru.kpfu.pizza_market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Anvar on 08.05.16.
 */
@Controller
public class ImageController {

    @RequestMapping(value = "/pizza_image/{imageId}")
    @ResponseBody
    public byte[] getImage(@PathVariable long imageId, HttpServletRequest request)  {
//        String rpath=request.getRealPath("/");
        String rpath = request.getSession().getServletContext().getRealPath("/");

        rpath = rpath + "/resources/img/pizza/pizza_1" + imageId + ".png";
        Path path = Paths.get(rpath);
        byte[] data = new byte[0];
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
