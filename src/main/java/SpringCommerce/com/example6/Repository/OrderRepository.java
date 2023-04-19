package SpringCommerce.com.example6.Repository;

import SpringCommerce.com.example6.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
