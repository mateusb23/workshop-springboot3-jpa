package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

// ESSA É UMA CLASSE DE CONFIGURAÇÃO -> ELA NÃO É REST CONTROLLER, NEM SERVICE E NEM REPOSITORY, ELA SERÁ UMA CLASSE AUXILIAR QUE VAI FAZER ALGUMAS CONFIGURAÇÕES EM NOSSA APLICAÇÃO 
// OPTAMOS POR ESCOLHER O NOME TesteConfig POR SER UMA CLASSE DE CONFIGURAÇÃO ESPECÍFICA PARA O PERFIL DE TESTE
// PARA SALVAR OS DADOS NO BANCO DE DADOS, A CLASSE QUE REALIZA ISSO É O UserRepository, COM ISSO, A CLASSE ATUAL VAI PRECISAR TER UMA DEPENDÊNCIA DA UserRepository

@Configuration		// PARA FALARMOS AO SPRING QUE ESTA É UMA CLASSE ESPECÍFICA DE CONGFIGURAÇÃO
@Profile("test")	// PARA FALARMOS AO SPRING QUE ESTA É UMA CLASSE DE CONFIGURAÇÃO ESPECÍFICA PARA O PERFIL DE TESTE. OBD: DENTRO DOS PARÊNTESES COLOCAMOS EXATAMENTE O MESMO PERFIL QUE COLOCAMOS NO ARQUIVO application.properties NA LINHA spring.profiles.active=test 
public class TestConfig implements CommandLineRunner {	/* FAZEMOS ISSO PARA EXECUTAR ISSO, ASSIM QUE O PROGRAMA FOI INICIADO. EXISTEM ALGUMAS FORMAS DE FAZER ISSO, NESSE CASO,
								PREFERIMOS FAZER A NOSSA CLASSE IMPLEMENTANDO A INTERFACE CHAMADA CommandLineRunner */

	@Autowired  // SERVE PARA QUE O SPRING CONSIGA RESOLVER ESSA INJEÇÃO DE DEPENDÊNCIA E ASSOCIE UMA INSTÂNCIA DO userRepository EM NOSSA CLASSE TesteConfig
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {	// TUDO AQUILO QUE COLOCARMOS DENTRO DESSE MÉTODO run SERÁ EXECUTADO QUANDO A APLICAÇÃO FOR INICIADA
		
		User u1 = new User(null, "Bruna Walkyria", "bruna@gmail.com", "988888888", "123454");
		User u2 = new User(null, "Mateus Santos Bispo", "mateus@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Gabriel do Janga", "gabriel@gmail.com", "928384885", "123455");
		User u4 = new User(null, "Fiódor Dostoiévski", "fiodor@gmail.com", "912088300", "789436");
		User u5 = new User(null, "Safira Gordinha", "safira@gmail.com", "8758808133", "578637");
		User u6 = new User(null, "Mel Velhinha", "mel@gmail.com", "948446655", "300988");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5)); 	// saveAll -> PASSAMOS UMA LISTA DE OBJETOS E O saveAll A SALVA NO BANCO DE DADOS
	}
	
}

	
