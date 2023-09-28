package com.wallet.myPocket.repository.api.data.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.myPocket.entity.api.data.exercise.Muscle;

@Repository
public interface MuscleRepository extends JpaRepository<Muscle, Integer>{

}
