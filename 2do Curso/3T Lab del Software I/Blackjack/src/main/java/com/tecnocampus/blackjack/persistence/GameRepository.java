package com.tecnocampus.blackjack.persistence;


import com.tecnocampus.blackjack.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {

}
