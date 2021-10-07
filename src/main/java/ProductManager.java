import java.util.List;

public interface ProductManager {
    List<Product> getProductsByPrice();
    void doOrder(Order order);
    Order serveOrder();
    List<Order> getOrdersByUser(String user);
    List<Product> getProductsBySales();
    public void addProduct(Product product);

    int getNumProducts();
}
