package com.example.demo.service;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.service.dto.FirmaGiftCardDto;

@Service
public class Ms3GiftService {
	RestTemplate restTemplate=new RestTemplate();
	
	public Boolean firmarGiftCard(FirmaGiftCardDto firma) {
		//End Point a integrar: 
		URI uri=  UriComponentsBuilder.fromHttpUrl("http://localhost:8081").
										path("/ms3/gift/firmarGiftCard").
										build(true).
										toUri();
		
		//Hacemos una solicitud Http
		RequestEntity<FirmaGiftCardDto> request=RequestEntity
			     .post(uri)//Asignamos la URI al método del protocolo http
			     .accept(MediaType.APPLICATION_JSON)
			     .contentType(MediaType.APPLICATION_JSON)
			     .body(firma);//asignamos el cuerpo de la solicitud http
		
		//Obtenemos la respuesta de la solicitud http anterior y el tipo de dato que nos retorna
		ResponseEntity<Boolean> response= restTemplate.exchange(request, Boolean.class);
		
		 return response.getBody();
	}
}
