package hellojpa;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;


    //기간

    @Embedded
    private Address homeAddress;




    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressEntities;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }


    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();


    /**
     * 옳지 않은 방법
     */
    /*@ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();*/


    /**
     * 옳은 방법
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressEntities = new ArrayList<>();


   /* @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city",
            column = @Column(name = "CITY_WORK"))
            , @AttributeOverride(name = "street",
            column = @Column(name = "STREET_WORK"))
            , @AttributeOverride(name = "zipcode",
            column = @Column(name = "ZIPCODE_WORK"))
    })
    private Address workAddress;*/

    public Member() {
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }



    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }
}