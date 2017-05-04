package backend;

public class User {

    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private int phone;
    private boolean admin;

    public User(int id, String email, String firstName, String lastName, int phone, boolean admin) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.admin = admin;
        this.lastName = lastName;
        this.phone = phone;
    }
    
    public User(String email, String firstName, String lastName, int phone){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

}
