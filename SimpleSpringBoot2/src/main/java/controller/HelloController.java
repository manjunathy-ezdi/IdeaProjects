package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by EZDI\manjunath.y on 5/2/16.
 */
@RestController
@RequestMapping(path="/")
public class HelloController {

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello from the other side!";
    }
}
