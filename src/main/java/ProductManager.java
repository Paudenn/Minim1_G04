import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public interface ProductManager {
    List<Product> getProductsByPrice();
    void doOrder(Order order);
    Order serveOrder();
    List<Order> getOrdersByUser(String user);
    List<Product> getProductsBySales();
    public void addProduct(Product product);

    int getNumProducts();
    void addUser(User user);
    HashMap <String,User> getUser();
    int getOrderAmount();
    List<Product> getProductsList();
    Queue<Order> getOrdersList();


}
