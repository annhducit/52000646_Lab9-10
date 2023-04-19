package SpringCommerce.com.example6.Service;

import SpringCommerce.com.example6.Model.Order;
import SpringCommerce.com.example6.Model.OrderProduct;
import SpringCommerce.com.example6.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order saveOrder(float selling, float price, float total, List<OrderProduct> orderProducts)
    {
        Order order = new Order();
        order.setSelling(selling);
        order.setTotal(total);
        order.setPrice(price);
        order.setSelling(selling);
        order.setOrderProducts(orderProducts);
        orderRepository.save(order);
        return order;
    }
    public ResponseEntity<Order> deleteOrderById(long id)
    {
        orderRepository.deleteById(id);
        return null;
    }
    public List<Order> readAllOrder()
    {
        return orderRepository.findAll();
    }
    public Order readOrderById(long id)
    {
        return orderRepository.findById(id).get();
    }
}
