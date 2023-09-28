package com.wallet.myPocket.repository.api.data.exercise;

import java.util.List;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wallet.myPocket.dto.api.data.exercise.ExerciseDto;
import com.wallet.myPocket.entity.api.data.exercise.QExercise;
import com.wallet.myPocket.entity.api.data.exercise.QMuscle;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExerciseRepositoryCustomImpl implements ExerciseRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;
	private final QExercise exercise = QExercise.exercise;
	private final QMuscle muscle= QMuscle.muscle;
	
	@Override
	public List<ExerciseDto> findByMuscleAbbr(String name) {
		// TODO Auto-generated method stub
		
		return jpaQueryFactory.select(
				Projections.constructor(ExerciseDto.class, exercise.name, exercise.classification, exercise.gif)
		)
		.from(exercise)
		.innerJoin(exercise.muscles, muscle)
		.where(muscle.abbr.eq(name))
		.fetch();
	}

}
