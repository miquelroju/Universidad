package com.example.lligabasquet.persistence;

import com.example.lligabasquet.application.dto.PlayerDTO;
import com.example.lligabasquet.domain.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerRepository {
    private static Set<PlayerDTO> players = new HashSet<PlayerDTO>();

    public PlayerDTO getPlayer(String id) throws  Exception{
        if (players==null) throw new Exception();
        return players.stream().filter(x -> x.getId().equals(id)).findAny().get();
    }

    public void savePlayer(PlayerDTO player) throws Exception {
        if (player == null) throw new Exception();
        PlayerRepository.players.add(player);
    }

    public List<PlayerDTO> getAllPlayers() {
        return new ArrayList<PlayerDTO>(players);
    }

    public void removePlayers() {
        players.clear();
    }
}
