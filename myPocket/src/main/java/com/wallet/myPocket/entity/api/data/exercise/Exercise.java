package com.wallet.myPocket.entity.api.data.exercise;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SequenceGenerator(name = "EXERCISE_SEQ_GEN", initialValue = 1, allocationSize = 100)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity(name="EXERCISE")
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXERCISE_SEQ_GEN")
	@Column(name = "EXERCISE_ID")
	private int exerciseId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CLASSIFICATION")
	private String classification;
	
	@Column(name = "GIF")
	private String gif;
	
	@OneToMany(mappedBy="muscleId")
	private Set<Muscle> muscles = new LinkedHashSet<>();//중복x, 순서대로 넣기
	
	@OneToOne(mappedBy = "exercise")
	@Setter
	private Equipment equipment;
	
	@OneToMany(mappedBy = "exerciseInst")
	@Setter
	private List<Instructions> insts = new ArrayList<>();
}
