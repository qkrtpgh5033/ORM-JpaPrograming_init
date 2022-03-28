package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        /**
         * EntityManager : 고객의 요청에 따라 DB 작업을 할 때 필요
         */
        EntityManager em = emf.createEntityManager();
        /**
         * 모든 데이터 변경은 "트랜잭션이 필요"
         */
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //code
        try{

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("memberA");
            member.setTeam(team);
            em.persist(member);

//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> findTeamMembers = findTeam.getMembers();

            System.out.println("========================");
            for(Member m : findTeamMembers){
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("========================");

            transaction.commit();
        }catch (Exception e){
            System.out.println("오류 내용" + e);
            transaction.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
