

import java.util.*;
import java.util.logging.Logger;


public class ProductManagerImpl implements ProductManager {
    List<Product> productsList = new ArrayList<>();
    Queue<Order> ordersList = new LinkedList<>();
    HashMap<String,User> users = new HashMap<String,User>();

    final static Logger logger = Logger.getLogger(String.valueOf(ProductManagerImpl.class));

    private static ProductManagerImpl instance;
    public static ProductManagerImpl getInstance() {
        if(instance == null)
            instance = new ProductManagerImpl();

        return instance;
    }

    @Override
    public List<Product> getProductsByPrice() {
        logger.info("Products before: " + productsList.toString());
        Collections.sort(productsList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int)o1.getPrice() - (int)o2.getPrice();
            }
        });
        logger.info("Products after: " + productsList.toString());
        return productsList;
    }
    @Override
    public void doOrder(Order order) {
        ordersList.add(order);
        User client = order.getUser();
        client.getOrderList().add(order);
    }
    public void addUser(User user) {

        this.users.put(user.getName(),user);

    }

    public HashMap<String, User> getUser()
    {
        return this.users;
    }

    public List<Product> getProductsList(){
        return productsList;
    }
    public Queue<Order> getOrdersList() {
        return this.ordersList;
    }

    @Override
    public Order serveOrder() {
        return null;
    }

    @Override
    public List<Order> getOrdersByUser(String user) {
        return null;
    }

    @Override
    public List<Product> getProductsBySales() {
        return null;
    }

    public void addProduct(Product product) {
        this.productsList.add(product);
    }

    public int getOrderAmount(){ return this.ordersList.size(); }

    @Override
    public int getNumProducts() {
        return this.productsList.size();
    }

}
