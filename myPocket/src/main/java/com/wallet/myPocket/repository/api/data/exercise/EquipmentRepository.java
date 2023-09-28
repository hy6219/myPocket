package com.wallet.myPocket.repository.api.data.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.myPocket.entity.api.data.exercise.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>,EquipmentRepositoryCustom{

}
