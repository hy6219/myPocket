package com.wallet.myPocket.entity.api.data.exercise;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.wallet.myPocket.config.TestConfig;
import com.wallet.myPocket.repository.api.data.exercise.EquipmentRepository;
import com.wallet.myPocket.repository.api.data.exercise.ExerciseRepository;
import com.wallet.myPocket.repository.api.data.exercise.InstructionsRepository;
import com.wallet.myPocket.repository.api.data.exercise.MuscleRepository;

@Import(TestConfig.class)
@Transactional//실제 db에 반영하지 않기 위함
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ExerciseEntityTest {
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	private MuscleRepository muscleRepository;
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private InstructionsRepository instructionsRepository;
	
	@DisplayName(value = "롬복, 연관관계 확인 테스트")
	@Test
	public void exerciseEntityLombokTest() {
		//롬복 정상작동 확인을 위한 테스트
		
		Muscle me1 = Muscle.builder()
				.abbr("abs")
				.build();
		
		muscleRepository.save(me1);
		
		Equipment eq1 = Equipment.builder()
				.name("body weight")//맨몸운동
				.build();
		
		equipmentRepository.save(eq1);
		
		List<Instructions> insts = new ArrayList<>();
		
		insts.add(
				Instructions.builder()
				.description( "Lie flat on your back with your knees bent and feet flat on the ground.")
				.build()
		);
		
		insts.add(
				Instructions.builder()
				.description("Place your hands behind your head with your elbows pointing outwards.")
				.build()
				);
		instructionsRepository.saveAll(insts);
		
		Set<Muscle> set = new LinkedHashSet<>();
		set.add(me1);
		
		Exercise e = Exercise.builder()
				.name("3/4 sit-up")
				.classification("waist")
				.gif("https://www.naver.com")
				.muscles(set)
				.equipment(eq1)
				.insts(insts)
				.build();
		
		
		me1.setExercise(e);
		eq1.setExercise(e);
		insts.forEach(inst-> inst.setExerciseInst(e));
		
		exerciseRepository.save(e);
		
		Assertions.assertThat(exerciseRepository.findByMuscleAbbr("abs").size() > 0);
		Assertions.assertThat(!instructionsRepository.findInstructionsByExerciseName("3/4 sit-up").isEmpty());
		Assertions.assertThat(equipmentRepository.countDistinctByName() > 0);
	}
}
