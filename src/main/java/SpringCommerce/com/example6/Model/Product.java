package SpringCommerce.com.example6.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 20)
    private String name;
    @Column
    private float price;
    @Column
    private String illustration;
    @Column(length = 300)
    private String description;

    public Product(String name, float price, String illustration, String description) {
        this.name = name;
        this.price = price;
        this.illustration = illustration;
        this.description = description;
    }

}
