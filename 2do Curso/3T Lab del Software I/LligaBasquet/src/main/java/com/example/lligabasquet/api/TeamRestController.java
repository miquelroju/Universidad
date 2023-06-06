package com.example.lligabasquet.api;

import com.example.lligabasquet.application.dto.PlayerDTO;
import com.example.lligabasquet.application.dto.TeamDTO;
import com.example.lligabasquet.application.TeamController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TeamRestController {
    @PostMapping("/teams")
    public TeamDTO createTeam(@RequestBody TeamDTO team) throws Exception {
        return new TeamController().createTeam(team.getName(), team.getColor(), team.getPlayers());
    }

    @PostMapping("/teams/players")
    public PlayerDTO createPlayer(@RequestBody TeamDTO team, @RequestBody PlayerDTO player) throws Exception {
        return new TeamController().createPlayer(team, player);
    }

    @GetMapping("/teams")
    public List<TeamDTO> getAllTeams() {
        return new TeamController().getAllTeams();
    }

    @GetMapping("/teams/{id}")
    public TeamDTO getTeam(@RequestParam String id) throws Exception {
        return new TeamController().getTeam(id);
    }

    @GetMapping("/teams/{id}/players")
    public List<PlayerDTO> getAllPlayers(@RequestParam String id) throws Exception {
        return new TeamController().getAllPlayersTeam(id);
    }

    @GetMapping("/teams/{teamID}/players/{playerID}")
    public PlayerDTO getPlayer(@RequestParam String teamID, @RequestParam String playerID) throws Exception {
        return new TeamController().getPlayerTeam(teamID, playerID);
    }

    @DeleteMapping("/teams")
    public void deleteAllTeams() {
        new TeamController().removeTeams();
    }

    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@RequestParam String id) {
        new TeamController().removeTeam(id);
    }

    @DeleteMapping("/teams/{id}/players")
    public void deleteAllPlayers(@RequestParam String id) throws Exception {
        new TeamController().removePlayers(id);
    }

    @DeleteMapping("/teams/{teamID}/players/{playerID}")
    public void deletePlayer(@RequestParam String teamID, @RequestParam String playerID) throws Exception {
        new TeamController().removePlayer(teamID, playerID);
    }
}