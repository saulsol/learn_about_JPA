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
            Team team = new Team();
            team.setTeamName("TEAM_A");
            entityManager.persist(team); // List<Member> members 도 저장

            Member member = new Member();
            member.setUserName("LIM");
            entityManager.persist(member); // 1차 캐시


            team.addMember(member); // 연관관계 편의 메소드

            System.out.println("--------------------");
            entityManager.flush(); // DB 와 영속성 컨텍스트 동기화
            entityManager.clear(); // 영속성 컨텍스트 클리어. DB로 부터 새로운 값 갖고온다(SELECT 쿼리 발송)
            System.out.println("--------------------");

            Team findTeam = entityManager.find(Team.class, team.getId()); // 1차 캐시
            List<Member> members = findTeam.getMembers();

            System.out.println("======================================");
            for (Member m : members) {
                System.out.println("m = " + m.getUserName());
            }
            System.out.println("======================================");

            entityTransaction.commit(); // 트랜잭션 커밋


        }catch (Exception e){

            entityTransaction.rollback(); // 트랜잭션 롤백

        }finally {

            entityManager.close();
            entityManagerFactory.close();
        }







    }

}
