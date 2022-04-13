package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;


//@SequenceGenerator(
//        name = "member_seq_generator",
//        sequenceName = "member_seq", initialValue = 1, allocationSize = 50)


/**
 * @Entity를 무조건 넣어야됨
 * -> 로딩할 때, JPA를 사용하는 애라고 인식하여 관리하기 시작
 */
@Entity
@Getter
@Setter
public class Member extends BaseEntity{
    /**
     * @Id -> PK
     */
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")

    private Long id;


    // 단방향 관계
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//지연로딩으로 설정하면 연관된걸 가져올 때 프록시 객체로 가져옴
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    @Column(name = "name")
    private String username;

    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    @OneToMany(mappedBy = "member")
    private List <MemberProduct> memberProducts = new ArrayList<>();

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
            @JoinColumn(name = "MEMBER_ID")
    )
//    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

}
