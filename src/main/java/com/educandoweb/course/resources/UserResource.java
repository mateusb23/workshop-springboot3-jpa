package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.userService;

// DAS LINHAS 16 a 27 TEMOS O NOSSO CONTROLADOR REST QUE RESPONDE NO CAMINHO /users

@RestController
@RequestMapping(value = "/users")
public class UserResource { // PRA GENTE INFORMAR QUE ESSA CLASSE É UM RECURSO WEB, QUE É IMPLEMENTADO POR UM CONTROLADOR REST, A GENTE VAI COLOCAR UMA ANNOTATION @RestController EM CIMA DO NOME DA CLASSE.

	@Autowired
	private userService service;
	
	@GetMapping		// PARA INDICAR QUE ESSE MÉTODO VAI SER UM MÉTODO QUE RESPONDE À REQUISIÇÃO DO TIPO get DO http, COLOCAMOS UM ANNOTATION @GetMapping
	public ResponseEntity<List<User>> findAll() { // O TIPO DE RETORNO DESSE MÉTODO SERÁ ResponseEntity, QUE É UM TIPO ESPECÍFICO DO PRÓPRIO SPRING QUE SERVE PARA RETORNAR RESPOSTAS DE REQUISIÇÕES WEB
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);  // ok() SERVE PARA RETONRAR A RESPOSTA COM SUCESSO NO http. E O .body() PARA RETORNAR O CORPO DA RESPOSTA RELAÇÃO À LISTA NA REQUISIÇÃO, NESTE CASO.
	}
	
	@GetMapping(value = "/{id}")  	// PARA FALARMOS QUE NOSSA URL TERÁ UM PARÂMETRO id TAMBÉM
	public ResponseEntity<User> findById(@PathVariable Long id) {	// PARA O SPRING ACEITAR ESSE id E CONSIDERÁ-LO COMO PARÂMETRO QUE VAI CHEGAR ALI NA URL, TEMOS QUE ESCREVER O ANNOTATION @PathVariable
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	/*
	 *  QUANDO TEMOS UM OBJETO QUE VAI PODER SER INJETADO PELO MECANISMO DE INJEÇÃO
	 *  DE DEPENDÊNCIA DO SPRING, A CLASSE DESSE SEU OBJETO PRECISA ESTAR REGISTRADA 
	 *  NO TAL MECANISMO DE INJEÇÃO DE DEPENDÊNCIA. ISSO FUNCIONA EM TODOS OS FRAMEWORKS
	 */
	
}

