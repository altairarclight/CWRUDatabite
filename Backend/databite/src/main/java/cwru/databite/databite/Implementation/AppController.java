package cwru.databite.databite.Implementation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/")
    public String viewHomePage() {
        System.out.println("Here");
        return "index";
    }
}
