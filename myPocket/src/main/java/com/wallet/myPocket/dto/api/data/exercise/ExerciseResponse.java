package com.wallet.myPocket.dto.api.data.exercise;

import java.util.ArrayList;
import java.util.List;

public class ExerciseResponse {
	private List<ExerciseResponseDto> dtos = new ArrayList<>();
	
	
	
	public ExerciseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ExerciseResponse(List<ExerciseResponseDto> dtos) {
		this.dtos = dtos;
	}
	
	

	public List<ExerciseResponseDto> getDtos() {
		return dtos;
	}



	public void setDtos(List<ExerciseResponseDto> dtos) {
		this.dtos = dtos;
	}



	@Override
	public String toString() {
		return "ExerciseResponse [dtos=" + dtos + "]";
	}
	
	
}
