package ie.atu.week2.productservice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;
    private InventoryServiceClient inventoryServiceClient;
    @Autowired
    public ProductController(ProductService productService, InventoryServiceClient inventoryServiceClient) {
        this.productService = productService;
        this.inventoryServiceClient = inventoryServiceClient;
    }

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
        return productService.getProductDetailsList();
    }



    @PostMapping("/product")
    public ProductDetails addProduct(@Valid @RequestBody ProductDetails productDetails)
    {
        return productService.addProduct(productDetails);
    }

    @PutMapping("/product/update/{id}")
    public ProductDetails updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDetails updatedProduct)
    {
        return productService.updateProduct(id, updatedProduct);
    }

    @PostMapping("/product/delete")
    public ProductDetails deleteProduct(@Valid @RequestBody ProductDetails productDetails)
    {
        return productService.deleteProduct(productDetails);

    }

    @PostMapping("/product-and-inventory")
    public String productAndInventory(@RequestBody ProductDetails productDetails){
        String product = inventoryServiceClient.somedetails(productDetails);
        String response = product + "" + productService.addProduct(productDetails);
        return response;
    }



}
