package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 조인 전략
@DiscriminatorColumn // DTYPE 설정 -> 디폴트 값으로 엔티티 명이 들어감,
                    // DTYPE이 있어야 DB를 볼 때 파악하기 쉽기 때문에 대도록이면 넣는 걸 권장

@Getter
@Setter
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;


}
