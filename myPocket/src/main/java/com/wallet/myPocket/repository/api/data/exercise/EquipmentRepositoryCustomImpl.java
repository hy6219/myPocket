package com.wallet.myPocket.repository.api.data.exercise;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wallet.myPocket.entity.api.data.exercise.QEquipment;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EquipmentRepositoryCustomImpl implements EquipmentRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;
	private final QEquipment equipment = QEquipment.equipment;
	
	/**
	 * 맨몸운동 등 중복하지 않고 몇 종류가 되는지 확인
	 */
	@Override
	public long countDistinctByName() {
		// TODO Auto-generated method stub
		return jpaQueryFactory.select(equipment.name.countDistinct())
				.from(equipment)
				.fetchOne();
	}

}
