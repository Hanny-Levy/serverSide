package com.dev.controllers;
import com.dev.objects.GameObject;
import com.dev.objects.TeamObject;
import com.dev.objects.UserObject;
import com.dev.responses.BasicResponse;
import com.dev.responses.SignInReponse;
import com.dev.utils.Persist;
import com.dev.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import java.util.List;


@RestController
public class TestController {


    @Autowired
    public Utils utils;

    @Autowired
    private Persist persist;

    @PostConstruct
    public void init() {
    }

    @RequestMapping(value = "/sign-in", method = {RequestMethod.POST})
    public BasicResponse signIn(String username, String password) {
        BasicResponse basicResponse = null;
        String token = persist.createHash(username, password);
        UserObject user = persist.isUserExist(username, token);
        if (user == null) {
            if (!persist.usernameExist(username)) {
                basicResponse = new BasicResponse(false, 1);
            } else {
                basicResponse = new BasicResponse(false, 2);
            }
        } else {
            basicResponse = new SignInReponse(true, null, user);
        }
        return basicResponse;
    }

    @RequestMapping(value = "/get-all-teams", method = RequestMethod.GET)
    public List<TeamObject> getAllTeams() {
        return persist.getTeams();
    }

    @RequestMapping(value = "/update-live-game", method = RequestMethod.POST)
    public BasicResponse updateGame(String team1, String team2, int team1GoalsFor, int team2GoalsFor) {
        return persist.updateLiveGame(team1, team2, team1GoalsFor, team2GoalsFor);
    }

    @RequestMapping(value = "/update-final-game", method = {RequestMethod.POST})
    public BasicResponse updateFinalGameResult(String team1, String team2, int team1GoalsFor, int team2GoalsFor) {
        return persist.updateFinalGameResult(team1, team2, team1GoalsFor, team2GoalsFor);
    }

    @RequestMapping(value = "/get-all-live-games", method = {RequestMethod.GET})
    public List<GameObject> getAllLiveGames() {
        return persist.getGamesByStatus(true);
    }

    @RequestMapping (value = "/delete-live-game", method = {RequestMethod.POST})
        public BasicResponse deleteLiveGame (String team1, String team2 ,int team1GoalsFor, int team2GoalsFor){
          return   persist.deleteGame(team1, team2 ,team1GoalsFor, team2GoalsFor);
        }

        //get all teams in games
    @RequestMapping (value = "/get-teams-in-games", method = {RequestMethod.GET})
    public List<TeamObject> getTeamsInGames(){
        return persist.getAllTeamsInLiveGames();
    }

    @RequestMapping (value = "/get-all-teams-in-lives-results", method = {RequestMethod.GET})
    public List<TeamObject> getLivesTeamsList(){
        return persist.getTeamsListWithLiveResult();
    }
}