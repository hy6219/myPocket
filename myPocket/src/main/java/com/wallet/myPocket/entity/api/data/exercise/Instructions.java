package com.wallet.myPocket.entity.api.data.exercise;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SequenceGenerator(name = "INST_SEQ_GEN", initialValue = 1, allocationSize = 100)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = {"exerciseInst"})
@Entity(name = "INSTRUCTIONS")
public class Instructions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INST_SEQ_GEN")
	@Column(name = "INSTRUCTION_ID")
	private int instructionId;
	
	@Column(name = "DESCRIPTION")
	@Lob
	private String description;
	
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EXERCISE_ID")
	private Exercise exerciseInst;
}
