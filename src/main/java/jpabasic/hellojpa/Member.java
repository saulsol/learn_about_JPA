package jpabasic.hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Member")
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;
    
    //Team 참조 변수 생성
    @ManyToOne(fetch = FetchType.LAZY) // 즉시 로딩
    @JoinColumn(name = "TEAM_ID")//조인 컬럼 설정 -> FK 관리
    private Team team;


    @OneToMany(mappedBy = "member")
    List<MemberProduct> memberProducts = new ArrayList<>();


    // 기본 생성자
    public Member() {
    }


    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Team getTeam() {
        return team;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<MemberProduct> getMemberProducts() {
        return memberProducts;
    }












}
