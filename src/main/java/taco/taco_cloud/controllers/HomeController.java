package taco.taco_cloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import taco.taco_cloud.persistance.JDBCExample;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
