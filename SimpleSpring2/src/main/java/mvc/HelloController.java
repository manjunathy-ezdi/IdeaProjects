package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by EZDI\manjunath.y on 2/2/16.
 */
@Controller("/")
public class HelloController {

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "y0zi!";
    }
}
