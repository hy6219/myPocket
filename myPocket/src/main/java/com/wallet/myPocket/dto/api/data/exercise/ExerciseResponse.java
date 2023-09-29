package com.wallet.myPocket.dto.api.data.exercise;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ExerciseResponse {
	private List<ExerciseResponseDto> dtos = new ArrayList<>();
	
}
