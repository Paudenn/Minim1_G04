

import java.util.*;
import java.util.logging.Logger;


public class ProductManagerImpl implements ProductManager {
    List<Product> productsList = new ArrayList<>();
    Queue<Order> ordersList = new LinkedList<>();
    HashMap<String,User> users = new HashMap<String,User>();
    private int sellCount;

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
    public void serveOrder() {

        Order served = ordersList.poll();
        for(int i=0; i <served.getProductList().size(); i++ ) {
            int j = 0;
            Boolean found = false;
            while(!found && j < productsList.size()) {
                if(productsList.get(j).getName() == served.getProductList().get(i).getName()) {
                    found = true;
                    productsList.get(j).setAmount(productsList.get(j).getAmount() - served.getProductList().get(i).getAmount());
                    sellCount += served.getProductList().get(i).getAmount();
                }
                j++;
            }
        }
    }
    public int getSellsnum(){
        return sellCount;
    }

    @Override
    public List<Order> getOrdersByUser(User user) {
        List<Order> list = user.orderList;

        return list;
    }

    @Override
    public List<Product> getProductsBySales() {
        List<Product> list = this.productsList;
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                logger.info(String.valueOf(o1.getSells() - o2.getSells()));
                return o1.getSells() - o2.getSells();
            }
        });
        return list;
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
