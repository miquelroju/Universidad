package com.example.lligabasquet.application;

import com.example.lligabasquet.application.dto.PlayerDTO;
import com.example.lligabasquet.application.dto.TeamDTO;
import com.example.lligabasquet.domain.Team;
import com.example.lligabasquet.persistence.PlayerRepository;
import com.example.lligabasquet.persistence.TeamRepository;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TeamController {
    public TeamDTO createTeam(String name, String color, List<PlayerDTO> players) throws Exception {
        Team team = new Team(name, color, players);
        new TeamRepository().saveTeam(team);
        return new TeamDTO(team);
    }

    public PlayerDTO createPlayer(TeamDTO team, PlayerDTO player) throws Exception {
        new PlayerRepository().savePlayer(player);
        team.addPlayer(player);
        return new PlayerDTO(player);
    }

    public void addTeam(String id) {

    }

    public void addPlayer(String teamID, String playerID) throws Exception {
        TeamDTO team = new TeamRepository().getTeam(teamID);
        PlayerDTO player = new PlayerRepository().getPlayer(playerID);
        team.addPlayer(player);
    }

    public List<TeamDTO> getAllTeams() {
        List<TeamDTO> teams = new TeamRepository().getAllTeams();
        return teams.stream().map(x -> new TeamDTO(x)).collect(Collectors.toList());
    }



    public TeamDTO getTeam(String id) throws Exception {
        return new TeamRepository().getTeam(id);
    }

    public List<PlayerDTO> getAllPlayersTeam(String id) throws Exception {
        TeamDTO team = new TeamRepository().getTeam(id);
        return team.getPlayers();
    }

    public PlayerDTO getPlayerTeam(String teamID, String playerID) throws Exception {
        TeamDTO team = new TeamRepository().getTeam(teamID);
        Iterator<PlayerDTO> it = team.getPlayers().iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(playerID)) {
                return it.next();
            }
        }
        return null;
    }

    public void removeTeams() {
        new TeamRepository().removeTeams();
    }

    public void removeTeam(String id) {
        new TeamRepository().removeTeam(id);
    }

    public void removePlayers(String id) throws Exception {
        TeamDTO team = new TeamRepository().getTeam(id);
        team.removePlayers();
    }

    public void removePlayer(String teamID, String playerID) throws Exception {
        TeamDTO team = new TeamRepository().getTeam(teamID);
        team.removePlayer(playerID);
    }

}
