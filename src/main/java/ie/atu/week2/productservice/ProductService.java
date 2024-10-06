package ie.atu.week2.productservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<ProductDetails> productDetailsList = new ArrayList<>();

    public List<ProductDetails> getProductDetailsList() {
        return productDetailsList;
    }
    public ProductDetails addProduct(ProductDetails productDetails) {
        productDetailsList.add(productDetails);
        return productDetails;
    }


    public  ProductDetails findById(Long id) {
        return productDetailsList.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public ProductDetails updateProduct(Long id, ProductDetails updatedProduct) {
        ProductDetails productDetails = findById(id);

        productDetails.setName(updatedProduct.getName());
        productDetails.setPrice(updatedProduct.getPrice());
        return productDetails;
    }

    public ProductDetails deleteProduct(ProductDetails productDetails) {
        productDetailsList.remove(productDetails);
        return productDetails;
    }
}
