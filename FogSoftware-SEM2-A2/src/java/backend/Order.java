package backend;


public class Order {
    
    private int order_id = 0;
    private int order_date = 0;
    private String order_title = "";
    
    public Order (int orderID, int orderDate, String orderTitle) {
        this.order_id = orderID;
        this.order_date = orderDate;
        this.order_title = orderTitle;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_date() {
        return order_date;
    }

    public void setOrder_date(int order_date) {
        this.order_date = order_date;
    }

    public String getOrder_title() {
        return order_title;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
    }
    
    
    
    
}
