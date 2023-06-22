package com.tecnocampus.blackjack.persistence;

import com.tecnocampus.blackjack.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
