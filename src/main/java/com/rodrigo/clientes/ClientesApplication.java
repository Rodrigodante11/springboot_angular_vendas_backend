package com.rodrigo.clientes;

import com.rodrigo.clientes.model.entity.Cliente;
import com.rodrigo.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run(@Autowired ClienteRepository repository){
//		return args -> {
//			Cliente cliente =  Cliente.builder()
//					.cpf("00000000000")
//					.nome("Fulano")
//					.build();
//			repository.save(cliente);
//		};
//	}

}
