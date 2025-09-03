package works.lionel.practice.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import works.lionel.practice.product.ProductService;
import works.lionel.practice.product.ProductDTO;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDTO product) {
        productService.createProduct(product);
    }

    /**
     * Get all products.
     */
    @GetMapping()
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}
