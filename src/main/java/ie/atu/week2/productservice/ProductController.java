package ie.atu.week2.productservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("hello")
    public String message(){
        return "Hello Broski";
    }
    @GetMapping("/hello/{name}")
    public String myName(@PathVariable String name)
    {
        return " Your name is :" + name;
    }
    @GetMapping("/search")
    public String search(@RequestParam String search1, @RequestParam(defaultValue = "") String search2){
        return search1 + " " + search2;
    }
}
