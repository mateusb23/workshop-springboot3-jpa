package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

// O UserRepository SERÁ O Repository RESPONSÁVEL POR FAZER OPERAÇÕES COM A ENTIDADE USER
// COM ISSO, PARA QUE A GENTE CONSIGA CRIAR UM UserRepository REUTILIZANDO O JpaRepository, BASTA FAZERMOS QUE COM ELE EXTENDA O JpaRepository<O TIPO DA ENTIDADE QUE IREMOS ACESSAR, O TIPO DA CHAVE DESSA ENTIDADE>
// PARA SALVAR OS DADOS NO BANCO DE DADOS, A CLASSE QUE REALIZA ISSO É O UserRepository

public interface UserRepository extends JpaRepository<User, Long> {	
	
}
