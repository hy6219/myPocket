package com.wallet.myPocket.repository.api.data.exercise;

import java.util.List;

import com.wallet.myPocket.dto.api.data.exercise.InstructionsDto;

public interface InstructionsRepositoryCustom {
	List<InstructionsDto> findInstructionsByExerciseName(String name);
}
