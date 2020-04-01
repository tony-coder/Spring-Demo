package spittr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/", "/homepage"})  // 映射到"/"和"/homepage"
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        return "home";  // 视图名为home
    }
}
