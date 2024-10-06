package ie.atu.week2.productservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-service", url = "http://localhost:8082")
public interface InventoryServiceClient {
    @PostMapping("/product")
    String somedetails(@RequestBody ProductDetails productDetails);
}
