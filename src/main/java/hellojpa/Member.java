package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Entity를 무조건 넣어야됨
 * -> 로딩할 때, JPA를 사용하는 애라고 인식하여 관리하기 시작
 */
@Entity
@Getter
@Setter
//@SequenceGenerator(
//        name = "member_seq_generator",
//        sequenceName = "member_seq", initialValue = 1, allocationSize = 50)
public class Member {
    /**
     * @Id -> PK
     */
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
//    strategy = GenerationType.IDENTITY, generator = "member_seq_generator"
    private Long id;

    @ManyToOne // 단방향 관계
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    @Column(name = "name")
    private String username;


}
