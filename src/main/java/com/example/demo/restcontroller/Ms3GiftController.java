package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Ms3GiftService;
import com.example.demo.service.dto.FirmaGiftCardDto;

//PRODUCTOR
@RestController
public class Ms3GiftController {
	
	@Autowired
	private Ms3GiftService ms3GiftService;
	
	@PostMapping("restTemplate")
	public Boolean firmarGiftCard(@RequestBody FirmaGiftCardDto firma) {
	return ms3GiftService.firmarGiftCard(firma);
	}
}
