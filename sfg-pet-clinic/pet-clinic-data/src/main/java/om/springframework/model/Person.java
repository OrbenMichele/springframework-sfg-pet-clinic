package om.springframework.model;


//@MappedSuperclass
public class Person{

    //@Column(name = "first_name")
    //@NotEmpty
    private String firstName;

    //@Column(name = "last_name")
    //@NotEmpty
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
