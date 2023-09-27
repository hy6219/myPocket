package com.wallet.myPocket.service.api.data.exercise;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.wallet.myPocket.config.ExercisedbConfig;
import com.wallet.myPocket.dto.api.data.exercise.ExerciseResponse;
import com.wallet.myPocket.dto.api.data.exercise.ExerciseResponseDto;

@Service
public class ExerciseServiceImpl implements ExerciseService{
	
	@Autowired
	private ExercisedbConfig exercisedbConfig;
	
	private final String exerciseDbUrl = "https://exercisedb.p.rapidapi.com/exercises";

	@Override
	public ExerciseResponse getExerciseLists() {
		// TODO Auto-generated method stub
		URI uri = UriComponentsBuilder.fromUriString(exerciseDbUrl)
							.queryParam("limit", "1300")
							 .build()
							 .toUri();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-RapidAPI-Key", exercisedbConfig.getApiKey());
		headers.add("X-RapidAPI-Host", exercisedbConfig.getHost());
		
		
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<List<ExerciseResponseDto>> response = template.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<ExerciseResponseDto>>() {});
		
		List<ExerciseResponseDto> dtos = response.getBody();
		ExerciseResponse body = new ExerciseResponse(dtos);
		
		System.out.println("body: "+body);
		System.out.println("items: "+dtos.size());
		
		return body;
	}

}
