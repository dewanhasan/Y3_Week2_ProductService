package ie.atu.week2.productservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private List<ProductDetails> productDetailsList = new ArrayList<>();

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

    @GetMapping("/product")
    public List<ProductDetails> getProductDetailsList()
    {
        return productDetailsList;
    }



    @PostMapping("/product")
    public ProductDetails addProduct(@RequestBody ProductDetails productDetails)
    {
        productDetailsList.add(productDetails);
        return productDetails;
    }
}
