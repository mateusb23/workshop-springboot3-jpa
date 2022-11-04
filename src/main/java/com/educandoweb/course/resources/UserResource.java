package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

// DAS LINHAS 11 a 21 TEMOS O NOSSO CONTROLADOR REST QUE RESPONDE NO CAMINHO /users
@RestController
@RequestMapping(value = "/users")
public class UserResource { // PRA GENTE INFORMAR QUE ESSA CLASSE É UM RECURSO WEB, QUE É IMPLEMENTADO POR UM CONTROLADOR REST, A GENTE VAI COLOCAR UMA ANNOTATION @RestController EM CIMA DO NOME DA CLASSE.

	@GetMapping		// PARA INDICAR QUE ESSE MÉTODO VAI SER UM MÉTODO QUE RESPONDE À REQUISIÇÃO DO TIPO get DO http, COLOCAMOS UM ANNOTATION @GetMapping
	public ResponseEntity<User>	findAll() { // O TIPO DE RETORNO DESSE MÉTODO SERÁ ResponseEntity, QUE É UM TIPO ESPECÍFICO DO PRÓPRIO SPRING QUE SERVE PARA RETORNAR RESPOSTAS DE REQUISIÇÕES WEB
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);  // ok() SERVE PARA RETONRAR A RESPOSTA COM SUCESSO NO http. E O .body() PARA RETORNAR O CORPO DA RESPOSTA RELAÇÃO AO USUÁRIO u, NESTE CASO.
	}
	
}
