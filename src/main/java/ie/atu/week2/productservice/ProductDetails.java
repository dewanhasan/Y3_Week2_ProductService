package ie.atu.week2.productservice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDetails {
    private Long id;

    @NotBlank(message = "name cannot null")
    private String name;
    @Positive(message = "price must be positive")
    private double price;

}
