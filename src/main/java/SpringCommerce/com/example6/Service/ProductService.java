package SpringCommerce.com.example6.Service;

import SpringCommerce.com.example6.Model.*;
import SpringCommerce.com.example6.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public Product getProductById(long id)
    {
        return productRepository.findById(id).get();
    }

    public Product saveProduct(String name, float price, String illustration, String description)
    {
        Product product = new Product();
        product.setDescription(description);
        product.setName(name);
        product.setPrice(price);
        product.setIllustration(illustration);
        product.setDescription(description);
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(long id, String name, float price, String illustration, String description)
    {
        Product product = getProductById(id);
        product.setDescription(description);
        product.setName(name);
        product.setPrice(price);
        product.setIllustration(illustration);
        product.setDescription(description);
        productRepository.save(product);
        return product;
    }
    public void deleteProduct(long id)
    {
        productRepository.deleteById(id);
    }


}
