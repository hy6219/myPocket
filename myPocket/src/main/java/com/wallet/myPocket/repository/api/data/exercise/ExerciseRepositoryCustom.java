package com.wallet.myPocket.repository.api.data.exercise;

import java.util.List;

import com.wallet.myPocket.dto.api.data.exercise.ExerciseDto;

public interface ExerciseRepositoryCustom {
	List<ExerciseDto> findByMuscleAbbr(String name);
}
