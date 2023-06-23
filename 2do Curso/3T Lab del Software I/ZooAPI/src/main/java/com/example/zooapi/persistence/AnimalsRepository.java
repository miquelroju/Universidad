package com.example.zooapi.persistence;

import com.example.zooapi.domain.animals.AbsAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<AbsAnimal, String> {


}
