package jpabasic.hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private long id;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL) // -> 영속성 전이 활성화
    private List<Member> members = new ArrayList<Member>();

    public Team(){

    }

    public long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }



    // 연관관계 편의 메서드
    public void addMember(Member member){
        members.add(member); // 리스트에 저장
        member.setTeam(this); //
    }

}
