package controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by EZDI\manjunath.y on 5/2/16.
 */
@Controller
@ComponentScan
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello from the other side!";
    }
}
