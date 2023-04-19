package SpringCommerce.com.example6.Controller;

import SpringCommerce.com.example6.Model.Order;
import SpringCommerce.com.example6.Model.OrderProduct;
import SpringCommerce.com.example6.Service.OrderService;
import SpringCommerce.com.example6.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @PostMapping(value = "/api/product")
    public Order saveOrderToDB(@RequestParam("name") float selling,
                               @RequestParam("price") float price,
                               @RequestParam("total") float total,
                               @RequestParam("product")OrderProduct product)
    {
        ArrayList<OrderProduct> productArrayList = new ArrayList<>();
        productArrayList.add(product);
        return orderService.saveOrder(selling, price,  total, productArrayList);
    }

    @PutMapping(value = "/api/product")
    public ResponseEntity<Order> updateOrderToDB(@PathVariable("id") long id,
                                                  @RequestParam("name") float selling,
                                                  @RequestParam("price") float price,
                                                  @RequestParam("total") float total,
                                                  @RequestParam("product")OrderProduct product)
    {
        Order order = orderService.readOrderById(id);
        if(order == null) {
            return ResponseEntity.notFound().build();
        }
        ArrayList<OrderProduct> productArrayList = new ArrayList<>();
        productArrayList.add(product);
        Order updatedOrder = orderService.saveOrder(selling, price,  total, productArrayList);
        return ResponseEntity.ok(updatedOrder);
    }

    @RequestMapping(value = "/api/order", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> listAllOrder(){
        List<Order> listOrder= orderService.readAllOrder();
        if(listOrder.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Order>>(listOrder, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/order/{id}", method = RequestMethod.DELETE)
    public  ResponseEntity<Order> deleteOrder(@PathVariable(name = "id") int id) {
        Order order = orderService.readOrderById(id);
        if(order == null) {
            return ResponseEntity.notFound().build();
        }
        return orderService.deleteOrderById(id);

    }


    @RequestMapping(value = "/api/order/{id}", method = RequestMethod.GET)
    public Order orderDetails(@PathVariable(name = "id") int id) {
        Order order= orderService.readOrderById(id);
        if(order == null) {
            ResponseEntity.notFound().build();
        }
        return order;
    }
}
