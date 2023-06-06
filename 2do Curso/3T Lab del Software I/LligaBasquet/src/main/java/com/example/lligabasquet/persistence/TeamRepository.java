package com.example.lligabasquet.persistence;

import com.example.lligabasquet.application.dto.TeamDTO;
import com.example.lligabasquet.domain.Team;

import java.util.*;

public class TeamRepository {
    private static Set<TeamDTO> teams = new HashSet<TeamDTO>();

    public TeamDTO getTeam(String id) throws Exception {
        if (teams == null) throw new Exception();
        return teams.stream().filter(x -> x.getId().equals(id)).findAny().get();
    }

    public void saveTeam(Team team) throws Exception {
        if (team == null) throw new Exception();
        TeamRepository.teams.add(team);
    }

    public List<TeamDTO> getAllTeams() {
        return new ArrayList<TeamDTO>(teams);
    }

    public void removeTeam(String id) {
        Iterator<TeamDTO> it = teams.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                teams.remove(it.next());
                break;
            }
        }
    }

    public void removeTeams() {
        teams.clear();
    }
}
