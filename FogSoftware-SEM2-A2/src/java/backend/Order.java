package backend;

public class Order {

    private int user_id = 0;
    private String order_title = "";

    public Order(int userID, String orderTitle) {
        this.user_id = userID;
        this.order_title = orderTitle;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOrder_title() {
        return order_title;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
    }

}
