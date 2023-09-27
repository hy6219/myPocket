package com.wallet.myPocket.service.api.data.exercise;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.wallet.myPocket.dto.api.data.exercise.ExerciseResponse;
import com.wallet.myPocket.dto.api.data.exercise.ExerciseResponseDto;

@Service
public class ExerciseServiceImpl implements ExerciseService{
	
	@Value("${ex-api-key}")
	private String apiKey;
	@Value("${ex-host}")
	private String host;
	
	private final String exerciseDbUrl = "https://exercisedb.p.rapidapi.com/exercises";

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
		
		return body;
	}

}
