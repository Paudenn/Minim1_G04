import java.util.ArrayList;
import java.util.List;

public class Order {

    String user;
    List<Product> productList;

    public Order(String user, List<Product> productList) {
        this.user = user;
        this.productList = productList;
    }
    public Order(String user) {
        this.user = user;
        this.productList = new ArrayList<>();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


}
