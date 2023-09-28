package com.wallet.myPocket.entity.api.data.exercise;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SequenceGenerator(name = "MUSCLE_SEQ_GEN", initialValue = 1, allocationSize = 100)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude= {"exercise"})
@Entity(name = "MUSCLE")
public class Muscle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MUSCLE_SEQ_GEN")
	@Column(name = "MUSCLE_ID")
	private int muscleId;
	
	@Column(name = "MUSCLE_ABBR")
	private String abbr;
	
	@Setter
	@ManyToOne
	@JoinColumn(name = "EXERCISE_ID")
	private Exercise exercise;
}
