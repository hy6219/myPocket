package com.wallet.myPocket.service.api.data.exercise;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.wallet.myPocket.component.UrlImageDownloader;
import com.wallet.myPocket.dto.api.data.exercise.ExerciseResponse;
import com.wallet.myPocket.dto.api.data.exercise.ExerciseResponseDto;
import com.wallet.myPocket.entity.api.data.exercise.Equipment;
import com.wallet.myPocket.entity.api.data.exercise.Exercise;
import com.wallet.myPocket.entity.api.data.exercise.Instructions;
import com.wallet.myPocket.entity.api.data.exercise.Muscle;
import com.wallet.myPocket.repository.api.data.exercise.EquipmentRepository;
import com.wallet.myPocket.repository.api.data.exercise.ExerciseRepository;
import com.wallet.myPocket.repository.api.data.exercise.InstructionsRepository;
import com.wallet.myPocket.repository.api.data.exercise.MuscleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional//commit all or nothing
public class ExerciseServiceImpl implements ExerciseService{
	
	@Value("${ex-api-key}")
	private String apiKey;
	@Value("${ex-host}")
	private String host;
	@Value("${file.dir}")
	private String dir;
	
	private String exerciseDbUrl = "https://exercisedb.p.rapidapi.com/exercises";
	
	private final UrlImageDownloader downloader;
	private final ExerciseRepository exerciseRepository;
	private final MuscleRepository muscleRepository;
	private final InstructionsRepository instructionsRepository;
	private final EquipmentRepository equipmentRepository;

	@Override
	public ExerciseResponse getExerciseLists() {
		// TODO Auto-generated method stub
		System.out.println("apikey: "+apiKey);
		URI uri = UriComponentsBuilder.fromUriString(exerciseDbUrl)
							.queryParam("limit", "1300")
							 .build()
							 .toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-RapidAPI-Key", apiKey);
		headers.add("X-RapidAPI-Host", host);
		
		
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<List<ExerciseResponseDto>> response = template.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<ExerciseResponseDto>>() {});
		
		List<ExerciseResponseDto> dtos = response.getBody();
		ExerciseResponse body = new ExerciseResponse(dtos);
		
		System.out.println("body: "+body);
		System.out.println("items: "+dtos.size());
		
		//매번 gif 링크가 달라져서 처음부터 그냥 저장해둘 것
		List<Exercise> entities = new ArrayList<>();
		for(int i= 0; i < dtos.size(); i++) {
			ExerciseResponseDto dto = dtos.get(i);
			// "/"는 -로 변경
			String fileName = dto.getName().contains("/")? dto.getName().replace("/", "-"): dto.getName();
			String full = downloader.getFullPath(dir, fileName,"gif");//로컬에 저장할 위치
			Exercise e = ExerciseResponseDto.toEntity(dto, full);
			//이미지 저장
			downloader.downloadImageFromUrl(dto.getGifUrl(), dir, fileName, "gif");
			//엔티티 저장
			Set<Muscle> muscles = ExerciseResponseDto.toMuscle(dto);
			List<Instructions> insts = ExerciseResponseDto.toInstruction(dto);
			Equipment eq = ExerciseResponseDto.toEquipment(dto);
			muscleRepository.saveAll(muscles);
			instructionsRepository.saveAll(insts);
			equipmentRepository.save(eq);
			
			exerciseRepository.save(e);
			e.setEquipment(eq);
			e.setInsts(insts);
			e.setMuscles(muscles);
			
			muscles.forEach(m->m.setExercise(e));
			insts.forEach(ins-> ins.setExerciseInst(e));
			eq.setExercise(e);
			//entities.add(e);
		}
		
		//exerciseRepository.saveAll(entities);
		log.debug("엔티티 저장 완료");
		
		return body;
	}

}
