package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
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
            Member memberA = new Member();

//            memberA.setId(10L);
            memberA.setUsername("memberA");


            em.persist(memberA);

            transaction.commit();
        }catch (Exception e){
            System.out.println("오류 발생");
            System.out.println("오류 내용" + e);
//            Logger.getLogger(e+"");
            transaction.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
