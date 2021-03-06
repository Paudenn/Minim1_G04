
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class ProductManagerImplTest {
    ProductManager scenario;



    @Before
    public void setUp() {

        scenario = ProductManagerImpl.getInstance();
        scenario.addProduct(new Product("agua", 1, 10));
        scenario.addProduct(new Product("llet", 2, 5));
        scenario.addProduct(new Product("pa", 0.5, 15));
        scenario.addProduct(new Product("patata", 3, 8));
        scenario.addProduct(new Product("donut",2.2,20));
        scenario.addProduct(new Product("cafe",5.0,18));
        scenario.addProduct(new Product("bocata",6.4,13));

        scenario.addUser(new User("Pau","321"));
        Order fisrtOrder = new Order(scenario.getUser().get("Pau"));
        fisrtOrder.addLP(new Product("pa",0.5,4));
        scenario.doOrder(fisrtOrder);
    }

    @After
    public void tearDown() {
        scenario.getOrdersList().clear();
        scenario.getProductsList().clear();

    }



   @Test
    public void testShowProductsByPrice(){
       Assert.assertEquals(4,scenario.getNumProducts());
        scenario = ProductManagerImpl.getInstance();
        scenario.addProduct(new Product("agua", 1, 10));
        scenario.addProduct(new Product("llet", 2, 5));
        scenario.addProduct(new Product("pa", 0.5, 15));
        Assert.assertEquals(7,scenario.getNumProducts());
        List<Product> productList = scenario.getProductsByPrice();
        Assert.assertEquals(0.5,productList.get(0).getPrice(), 0.01);
        Assert.assertEquals(0.5,productList.get(1).getPrice(), 0.01);
        Assert.assertEquals(1,productList.get(2).getPrice(), 0.01);
        Assert.assertEquals(1,productList.get(3).getPrice(), 0.01);
    }
    @Test
    public void doOrder(){
        // Gilbert
        // 2 donuts
        // 1 cafè
        // 1 bocata llom
        Assert.assertEquals(1, scenario.getOrderAmount());

        scenario.addUser(new User("Gilbert","123"));
        Order order = new Order(scenario.getUser().get("Gilbert"));
        order.addLP(new Product("donut",2.2,2));
        order.addLP(new Product("cafe",5.0,1));
        order.addLP(new Product("bocata",6.4,1));
        scenario.doOrder(order);
        Assert.assertEquals(2, scenario.getOrderAmount());


    }
    @Test
    public void serveOrder()
    {
        Assert.assertEquals(1,scenario.getOrderAmount());
        scenario.serveOrder();
        Assert.assertEquals(0,scenario.getOrderAmount());
        Assert.assertEquals(4,scenario.getSellsnum());
    }
    @Test
    public  void getProductListByName()
    {
        scenario.getOrdersByUser(scenario.getUser().get("Pau"));
        Assert.assertEquals(1,scenario.getOrdersByUser(scenario.getUser().get("Pau")).size());
    }

}