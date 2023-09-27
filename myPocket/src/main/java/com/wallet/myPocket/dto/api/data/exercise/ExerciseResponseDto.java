package com.wallet.myPocket.dto.api.data.exercise;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

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
	
	
	
	public ExerciseResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ExerciseResponseDto(String bodyPart, String equipment, String gifUrl, String id, String name, String target,
			List<String> secondaryMuscles, List<String> instructions) {
		super();
		this.bodyPart = bodyPart;
		this.equipment = equipment;
		this.gifUrl = gifUrl;
		this.id = id;
		this.name = name;
		this.target = target;
		this.secondaryMuscles = secondaryMuscles;
		this.instructions = instructions;
	}
	public String getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getGifUrl() {
		return gifUrl;
	}
	public void setGifUrl(String gifUrl) {
		this.gifUrl = gifUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public List<String> getSecondaryMuscles() {
		return secondaryMuscles;
	}
	public void setSecondaryMuscles(List<String> secondaryMuscles) {
		this.secondaryMuscles = secondaryMuscles;
	}
	public List<String> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
	@Override
	public String toString() {
		return "ExerciseResponseDto [bodyPart=" + bodyPart + ", equipment=" + equipment + ", gifUrl=" + gifUrl + ", id="
				+ id + ", name=" + name + ", target=" + target + ", secondaryMuscles=" + secondaryMuscles
				+ ", instructions=" + instructions + "]";
	}


	
}
