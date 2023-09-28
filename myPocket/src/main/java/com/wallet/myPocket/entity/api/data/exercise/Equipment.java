package com.wallet.myPocket.entity.api.data.exercise;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SequenceGenerator(name = "EQUIPMENT_SEQ_GEN", initialValue = 1, allocationSize = 100)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = {"exercise"})
@Entity(name = "EQUIPMENT")
public class Equipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EQUIPMENT_SEQ_GEN")
	@Column(name = "EQUIPMENT_ID")
	private int equipmentId;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "EXERCISE_ID")
	@Setter
	private Exercise exercise;
}
