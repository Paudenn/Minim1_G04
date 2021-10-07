
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

    }

    @After
    public void tearDown() {


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
        Order order = null;
        order.setUser("Gilbert");
        order.addLP(2,"donuts");
        order.addLP(1,"cafè");
        order.addLP(1,"bocata  llom");
        scenario.doOrder(order);
    }

}