package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long>, DistilleryRepositoryCustom {

    List<Distillery> findDistilleriesByRegion(String region);
    List<Distillery> findDistilleriesThatHaveWhiskiesAged(int age);
//    List <Distillery> findDistilleriesByWhisky(String)


}
