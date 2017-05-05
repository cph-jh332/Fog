package backend;

public class User {

    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String streetName;
    private String city;
    private int zipCode;
    private int phone;
    private boolean admin;

    public User(int id, String email, String firstName, String lastName, int phone, boolean admin, String streetName, String city, int zipCode) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.admin = admin;
        this.lastName = lastName;
        this.phone = phone;
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    public User(String email, String firstName, String lastName, int phone, String streetName, String city, int zipCode){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
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

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the zipCode
     */
    public int getZipCode() {
        return zipCode;
    }

}
