package com.wallet.myPocket.repository.api.data.exercise;

import java.util.List;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wallet.myPocket.dto.api.data.exercise.InstructionsDto;
import com.wallet.myPocket.entity.api.data.exercise.QExercise;
import com.wallet.myPocket.entity.api.data.exercise.QInstructions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InstructionsRepositoryCustomImpl implements InstructionsRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;
	private final QInstructions instructions = QInstructions.instructions; 
	private final QExercise exercise = QExercise.exercise;
	
	/**
	 * Exercise이름값으로 해당하는 설명찾기
	 */
	@Override
	public List<InstructionsDto> findInstructionsByExerciseName(String name) {
		// TODO Auto-generated method stub
		return jpaQueryFactory.select(
							Projections.constructor(InstructionsDto.class, instructions.description)
						)
						.from(instructions)
						.join(instructions.exerciseInst,exercise)
						.where(exercise.name.eq(name))
						.fetch();
	}

}
