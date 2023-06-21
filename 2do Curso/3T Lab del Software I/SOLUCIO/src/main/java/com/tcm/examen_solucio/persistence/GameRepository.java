package com.tcm.examen_solucio.persistence;

import com.tcm.examen_solucio.domain.Game;
import com.tcm.examen_solucio.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, String> {

    Iterable<Game> findAllByUser(User user);
}
