package hellojpa;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {


    @Id @GeneratedValue
    @Column(name = "ADDRESS_ENTITY_ID")
    private Long id;

    private Address address;

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }


    public AddressEntity(String city, String street,String zipcode){
        this.address = new Address(city, street,zipcode);
    }

    public AddressEntity() {

    }
}
