package com.consumer.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.dto.ConsumerDto;
import com.consumer.entities.Consumer;
import com.consumer.responses.Response;
import com.consumer.services.ConsumerServices;
import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
@RequestMapping("/bots")

public class ConsumerController {

	@Autowired
	private ConsumerServices services;
	
	@PostMapping(path = "/{id}/{name}")
	public ResponseEntity<Response<Consumer>> 
		cadastrar(@PathVariable("id") String id, 
				  @PathVariable("name") String name) {
		
		Response<Consumer> response = new Response<Consumer>();
		
		id = "36b9f842-ee97-11e8-9443-0242ac120002";
		name = "Aureo";
		
		this.services.salvarNome(id, name);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Consumer>> buscar(@PathVariable("id") String id) 
		throws JsonParseException, JsonMappingException, IOException {
		
		id = "36b9f842-ee97-11e8-9443-0242ac120002";
		
		Consumer consumer = services.buscarPorConsumer(id);
		Response<Consumer> response = new Response<Consumer>();
		response.setData(consumer);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping(path = "/mensagens")
	public ResponseEntity<Response<Consumer>> update(
			@Valid @RequestBody ConsumerDto consumerDto) {
		Response<Consumer> response = new Response<Consumer>();
		
		consumerDto.setConversationId("7665ada8-3448-4acd-a1b7-d688e68fe9a1");
		consumerDto.setTimestamp(new Timestamp(convertDate().getDate()));
		consumerDto.setFrom("36b9f842-ee97-11e8-9443-0242ac120002");
		consumerDto.setTo("16edd3b3-3f75-40df-af07-2a3813a79ce9");
		consumerDto.setText("\"Oi! Como posso te ajudar?");
		
		this.services.update(consumerDto);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(path = "/mensagem/{id}")
	public ResponseEntity<Response<Consumer>> buscarById(
			@PathVariable("id") String id) 
		throws JsonParseException, JsonMappingException, IOException {
		
		Consumer consumer = services.buscarPorConsumer(id);
		
		
		Response<Consumer> response = new Response<Consumer>();
		response.setData(consumer);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(path = "/mensagem/{conversationId}")
	public ResponseEntity<Response<Consumer>> buscarByConversationId(
			@PathVariable("conversationId") String id) 
		throws JsonParseException, JsonMappingException, IOException {
		
		id = "36b9f842-ee97-11e8-9443-0242ac120002";
		
		Consumer consumer = services.buscarPorConsumer(id);
		
		Response<Consumer> response = new Response<Consumer>();
		response.setData(consumer);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(path = "/mensagem/{conversationId}")
	public ResponseEntity<Response<Consumer>> buscarAllConversationById(
			@PathVariable("conversationId") String conversationId) 
		throws JsonParseException, JsonMappingException, IOException {
		
		conversationId = "7665ada8-3448-4acd-a1b7-d688e68fe9a1";
		
		Consumer consumer = services.buscarPorConsumer(conversationId);
		
		Response<Consumer> response = new Response<Consumer>();
		response.setData(consumer);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	public Date convertDate() {
		String dateStr = "2018-11-16T23:30:52.6917722Z";
		DateFormat df = new SimpleDateFormat("YY MM DD HH:mm:ss zzz");
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		};
		return date;	
	}
	
}
