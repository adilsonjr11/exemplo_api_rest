package com.consumer.controller;

import java.io.IOException;
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
	
	@PostMapping(path = "/create/{id}/{name}")
	public ResponseEntity<Response<Consumer>> cadastrar(
			@PathVariable("id") String id, 
			@PathVariable("name") String name) {
		
		Response<Consumer> response = new Response<Consumer>();

		this.services.salvarNome(id, name);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Consumer>> buscar(
			@PathVariable("id") String id) 
		throws JsonParseException, JsonMappingException, IOException {
		
		Consumer consumer = services.buscarPorConsumer(id);
		Response<Consumer> response = new Response<Consumer>();
		response.setData(consumer);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping()
	public ResponseEntity<Response<Consumer>> update(
			@Valid @RequestBody ConsumerDto consumerDto) {
		Response<Consumer> response = new Response<Consumer>();

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
		
		List<Consumer> listConsumer = services.buscarPorConversationId(id);
		Response<Consumer> response = new Response<Consumer>();
		response.setDatas(listConsumer);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
