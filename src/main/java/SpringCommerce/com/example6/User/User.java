package SpringCommerce.com.example6.User;
import SpringCommerce.com.example6.Model.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String fistName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}