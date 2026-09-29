package CricBuzz;

import CricBuzz.Match.*;
import CricBuzz.Match.MatchType.MatchType;
import CricBuzz.Match.MatchType.T20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo {

    public static void main(String[] args) {

        Demo demoObj = new Demo();

        Team teamA = demoObj.addTeam("India");
        Team teamB = demoObj.addTeam("SriLanka");

        MatchType matchType = new T20();
        Match match = new Match(teamA, teamB, null, "SMS STADIUM", matchType);
        match.startMatch();

    }


    private Team addTeam(String name) {

        Queue<PlayerDetails> playerDetails = new LinkedList<>();

        PlayerDetails p1 = addPlayer(name + "1", Role.ALLROUNDER);
        PlayerDetails p2 = addPlayer(name + "2", Role.ALLROUNDER);
        PlayerDetails p3 = addPlayer(name + "3", Role.ALLROUNDER);
        PlayerDetails p4 = addPlayer(name + "4", Role.ALLROUNDER);
        PlayerDetails p5 = addPlayer(name + "5", Role.ALLROUNDER);
        PlayerDetails p6 = addPlayer(name + "6", Role.ALLROUNDER);
        PlayerDetails p7 = addPlayer(name + "7", Role.ALLROUNDER);
        PlayerDetails p8 = addPlayer(name + "8", Role.ALLROUNDER);
        PlayerDetails p9 = addPlayer(name + "9", Role.ALLROUNDER);
        PlayerDetails p10 = addPlayer(name + "10", Role.ALLROUNDER);
        PlayerDetails p11 = addPlayer(name + "11", Role.ALLROUNDER);

        playerDetails.add(p1);
        playerDetails.add(p2);
        playerDetails.add(p3);
        playerDetails.add(p4);
        playerDetails.add(p5);
        playerDetails.add(p6);
        playerDetails.add(p7);
        playerDetails.add(p8);
        playerDetails.add(p9);
        playerDetails.add(p10);
        playerDetails.add(p11);

        List<PlayerDetails> bowlers = new ArrayList<>();
        bowlers.add(p8);
        bowlers.add(p9);
        bowlers.add(p10);
        bowlers.add(p11);

        Team team = new Team(name, playerDetails, new ArrayList<>(), bowlers);
        return team;

    }

    private PlayerDetails addPlayer(String name, Role playerType) {

        Player person = new Player();
        person.setName(name);
        PlayerDetails playerDetails = new PlayerDetails(person, playerType);
        return playerDetails;
    }
}
