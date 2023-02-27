package jpabasic.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class jpaMain {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin(); // 트랜잭션 시작


        try{

            Member member1 = new Member();
            member1.setUserName("LIM");
            entityManager.persist(member1);


            Member member2 = new Member();
            member2.setUserName("LEE");
            entityManager.persist(member2);// member1 객체 영속성 컨텍스트에 저장

            Team team1 = new Team();
            team1.setTeamName("TEAM_A");
            entityManager.persist(team1);

            Team team2 = new Team();
            team2.setTeamName("TEAM_B");
            entityManager.persist(team2);


            member1.setTeam(team1);
            member2.setTeam(team2);

            entityManager.flush();
            entityManager.clear();

            System.out.println("-----------------LAZY LOADING START----------------------");

            List<Member> members = entityManager.createQuery("SELECT m FROM Member m join fetch m.team", Member.class)
                            .getResultList(); // Member List 불러오는 JPQL


            for (Member member : members) {
                System.out.println("member : "+ member.getTeam().getTeamName());
            }
                
            System.out.println("-----------------LAZY LOADING FIN----------------------");





            entityTransaction.commit(); // 트랜잭션 커밋


        }catch (Exception e){

            entityTransaction.rollback(); // 트랜잭션 롤백

        }finally {

            entityManager.close();
            entityManagerFactory.close();
        }







    }

}
