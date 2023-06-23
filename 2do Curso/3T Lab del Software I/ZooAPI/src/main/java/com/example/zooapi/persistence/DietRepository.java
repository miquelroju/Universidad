package com.example.zooapi.persistence;

import com.example.zooapi.domain.animals.AbsAnimal;
import com.example.zooapi.domain.nutrition.AbsDiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DietRepository extends JpaRepository<AbsDiet, String> {

    public Optional<AbsDiet> findByTypeEquals(String type);
}
