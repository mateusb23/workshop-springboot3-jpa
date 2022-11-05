package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

/* // FARERMOS DUAS OPERAÇÕES: UMA QUE VAI BUSCAR TODOS OS USUÁRIOS E 
 * OUTRA QUE VAI BUSCAR USUÁRIOS DE ACORDO COM O ID INFORMADO. POR ISSO 
 * IREMOS COLOCAR LOGO UMA DEPENDÊNCIA PARA A CLASSE UserRepository
 */

/* LINHA 20 -> A ANNOTATION @Component JÁ RESGISTRA A CLASSE COMO COMPONENTE DO SPRING, E COM ISSO ELE JÁ VAI PODER SER INJETADO AUTOMATICAMENTE COM O @Autowired 
 * PORÉM, COMO QUEREMOS REGISTRAR UM SERVIÇO EM UMA CAMADA DE SERVIÇO, É MAIS ORAGNIZADO E INDICADO UTILILZARMOS A ANNOTATION @Service 
 */

@Service
public class userService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}
