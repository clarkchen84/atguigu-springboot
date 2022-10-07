package sizhe.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HelloController
 *
 * @Author chensizhe
 * @Date 2022/10/3 3:18 PM
 */
@Controller
@ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(){
        return "hello SpringBoot 2";
    }
}
