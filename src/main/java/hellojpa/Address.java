package hellojpa;

import javax.persistence.Embeddable;
import java.util.Objects;


@Embeddable
public class Address {

    private String city;
    private String street;



    private String zipcode;


    public Address() {
    }
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }



    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override //값타입 비교 함수
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(zipcode, address.zipcode);
    }

    @Override //비교시 해시맵 같은 곳에서 필요함 없으면 안됨
    public int hashCode(){
        return Objects.hash(city,street,zipcode);
    }





}
