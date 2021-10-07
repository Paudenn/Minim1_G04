import java.util.ArrayList;
import java.util.List;

public class User {

    String name;
    List<Order> orderList;

    public User(String name, List<Order> orderList) {
        this.name = name;
        this.orderList = orderList;
    }
    public User(String name) {
        this.name = name;
        orderList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
