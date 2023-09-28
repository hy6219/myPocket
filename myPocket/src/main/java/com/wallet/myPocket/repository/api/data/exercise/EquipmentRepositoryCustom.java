package com.wallet.myPocket.repository.api.data.exercise;

public interface EquipmentRepositoryCustom {
	//맨몸운동 등 분류 갯수 세기
	long countDistinctByName();
}
