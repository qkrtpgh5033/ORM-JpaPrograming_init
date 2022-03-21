package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Entity를 무조건 넣어야됨
 * -> 로딩할 때, JPA를 사용하는 애라고 인식하여 관리하기 시작
 */
@Entity
@Getter
@Setter
public class Member {
    /**
     * @Id -> PK
     */
    @Id
    private long id;

    private String name;
}
