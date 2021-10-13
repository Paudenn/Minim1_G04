import java.util.ArrayList;
import java.util.List;

public class Order {

    User user;
    List<Product> productList;


    public Order(User user) {
        this.user = user;
        this.productList = new ArrayList<Product>();
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


    public void addLP(Product product) {

        productList.add(product);
    }


}
