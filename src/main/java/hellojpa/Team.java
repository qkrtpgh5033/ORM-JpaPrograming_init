package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Team {


    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private long Id;
    private String name;



}
