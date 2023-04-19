package SpringCommerce.com.example6.Model;

import SpringCommerce.com.example6.User.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private float selling;
    @Column
    private float price;
    @Column
    private float total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderProduct> orderProducts;

    public Order(float selling, float price, float total, List<OrderProduct> orderProducts) {
        this.selling = selling;
        this.price = price;
        this.total = total;
        this.orderProducts = orderProducts;
    }
}
