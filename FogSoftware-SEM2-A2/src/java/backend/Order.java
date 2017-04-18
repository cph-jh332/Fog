package backend;

public class Order {
    
    private int order_id = 0;
    private int user_id = 0;
    private String order_date = "";
    private String order_title = "";
    
    // Create constructor
    public Order(int userID, String orderTitle) {
        this.user_id = userID;
        this.order_title = orderTitle;
    }
    
    // Retrieve from DB constructor
    public Order(int orderID, int userID, String orderDate, String orderTitle) {
        this.order_id = orderID;
        this.user_id = userID;
        this.order_date = orderDate;
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

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

}
