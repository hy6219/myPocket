package com.wallet.myPocket.dto.api.data.exercise;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wallet.myPocket.entity.api.data.exercise.Equipment;
import com.wallet.myPocket.entity.api.data.exercise.Exercise;
import com.wallet.myPocket.entity.api.data.exercise.Instructions;
import com.wallet.myPocket.entity.api.data.exercise.Muscle;

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
public class ExerciseResponseDto {
	@JsonProperty(value = "bodyPart")
	private String bodyPart;
	@JsonProperty(value = "equipment")
	private String equipment;
	@JsonProperty(value="gifUrl")
	private String gifUrl;
	@JsonProperty(value = "id")
	private String id;
	@JsonProperty(value = "name")
	private String name;
	@JsonProperty(value = "target")
	private String target;
	@JsonProperty(value = "secondaryMuscles")
	private List<String> secondaryMuscles = new ArrayList<>();
	@JsonProperty(value = "instructions")
	private List<String> instructions = new ArrayList<>();
	
	public static Exercise toEntity(ExerciseResponseDto dto, String local) {
		
		return Exercise.builder()
				.name(dto.getName())
				.classification(dto.getBodyPart())
				.gif(local)//로컬저장주소
				.build();
	}
	
	public static Equipment toEquipment(ExerciseResponseDto dto) {
		return Equipment.builder()
				.name(dto.getEquipment())
				.build();
	}
	
	public static Set<Muscle> toMuscle(ExerciseResponseDto dto) {
		Set<Muscle> muscles = new LinkedHashSet<>();
		List<String> secondary = dto.getSecondaryMuscles();
		
		for(int i = 0; i < secondary.size(); i++) {
			Muscle m = Muscle.builder()
					.abbr(secondary.get(i))
					.build();
			muscles.add(m);
		}
		return muscles;
	}
	
	public static List<Instructions> toInstruction(ExerciseResponseDto dto){
		List<Instructions> inst = new ArrayList<>();
		List<String> origin = dto.getInstructions();
		
		for(int i = 0; i < origin.size(); i++) {
			Instructions ins = Instructions.builder()
					.description(origin.get(i))
					.build();
			inst.add(ins);
		}
		return inst;
	}
}
