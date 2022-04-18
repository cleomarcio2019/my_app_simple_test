package com.marcio.myapp;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.marcio.myapp.dominio.Usuario;
import com.marcio.myapp.repository.UsuarioRepository;


@SpringBootApplication
public class MarcioMyappApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(MarcioMyappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Cleomarcio Celestino", "Marcio", "138678");
		Usuario u2 = new Usuario(null, "Ana Maria Moreira", "Aninha", "031925");
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		
	}

}
