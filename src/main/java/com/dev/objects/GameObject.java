package com.dev.objects;
import javax.persistence.*;

@Entity
@Table(name = "games")
public class GameObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;


    @JoinColumn (name = "team_name_1")
    private String team1;



    @JoinColumn (name = "team_id_2")

    private String team2;
//
//    @ManyToOne
//    @JoinColumn(name = "teamId")
//    @Column
//    private TeamObject team1;

//    @OneToMany
//    @
//    @Column
//    private TeamObject team2;

    @Column
    private int team1GoalsFor;
    @Column
    private int team1Against;
    @Column
    private int team2GoalsFor;
    @Column
    private int team2Against;
    @Column
    private boolean isLive;


    public GameObject( String team1, String team2, int team1GoalsFor, int team2GoalsFor, boolean isLive) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1GoalsFor = team1GoalsFor;
        this.team1Against = team2GoalsFor;
        this.team2GoalsFor = team2GoalsFor;
        this.team2Against = team1GoalsFor;
        this.isLive = isLive;
    }

    public GameObject() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }







    public int getTeam1GoalsFor() {
        return team1GoalsFor;
    }

    public void setTeam1GoalsFor(int team1GoalsFor) {
        this.team1GoalsFor = team1GoalsFor;
    }

    public int getTeam1Against() {
        return team1Against;
    }



    public int getTeam2GoalsFor() {
        return team2GoalsFor;
    }

    public void setTeam2GoalsFor(int team2GoalsFor) {
        this.team2GoalsFor = team2GoalsFor;
    }


    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }
}