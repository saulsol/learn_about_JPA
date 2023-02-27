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

    @OneToMany(mappedBy = "team") // -> 연관관계 주인 지정, 실제 DB엔 없는 속성
    //@JoinColumn(name = "TEAM_ID")
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



}
