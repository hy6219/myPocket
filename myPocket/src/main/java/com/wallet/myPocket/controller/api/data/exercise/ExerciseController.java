package com.wallet.myPocket.controller.api.data.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.myPocket.dto.api.data.exercise.ExerciseResponse;
import com.wallet.myPocket.service.api.data.exercise.ExerciseServiceImpl;

@RequestMapping("/myPocket/api/data/exercise")
@RestController
public class ExerciseController {
	
	@Autowired
	private ExerciseServiceImpl exerciseServiceImpl;
	
	@GetMapping("/list")
	public ExerciseResponse exerciseData() {
		return exerciseServiceImpl.getExerciseLists();
	}
}
