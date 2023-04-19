package SpringCommerce.com.example6.Controller;

import SpringCommerce.com.example6.Model.*;
import SpringCommerce.com.example6.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;


    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET)
    public Product findProduct(@PathVariable("id") long id) {
        Product product = productService.getProductById(id);
        if(product == null) {
            ResponseEntity.notFound().build();
        }
        return product;
    }

    @RequestMapping(value = "/api/products", method = RequestMethod.GET)
    public ResponseEntity<Product> getAllProduct() {
        List<Product> productLists = productService.getAllProducts();
        if(productLists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Product>((Product) productLists, HttpStatus.OK);
    }

    @RequestMapping( value = "/api/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "id") int id) {
        Product product = productService.getProductById(id);
        if(product == null) {
            return ResponseEntity.notFound().build();
        }
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/api/product", method = RequestMethod.POST)
    public Product saveProduct(@RequestParam("name") String name,
                                @RequestParam("price") float price,
                                @RequestParam("illustration")String illustration,
                                @RequestParam("description") String description
                                )
    {
        return productService.saveProduct(name, price, illustration, description);

    }
    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable("id") long id,
                                @RequestParam("name") String name,
                                @RequestParam("price") float price,
                                @RequestParam("illustration")String illustration,
                                @RequestParam("description") String description)
    {
        return productService.updateProduct(id, name, price, illustration, description);
    }

}