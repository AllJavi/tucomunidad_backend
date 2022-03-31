package com.ISST18.tucomunidad.tucomunidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import com.ISST18.tucomunidad.tucomunidad.usuario.*;

@SpringBootApplication
@RestController
public class TuComunidadApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuComunidadApplication.class, args);
	}

	@GetMapping
	public ArrayList<Usuario> hello() {
		ArrayList<Usuario> test = new ArrayList<Usuario>();
		ArrayList<String> comunidades = new ArrayList<String>();
		String[] apellidos = {"me", "la"}; 
		test.add(new Usuario(0L, "isst", apellidos , "come@gmail.com", "sus", "muertos", Roles.VECINO, comunidades));
		return test;
	}

}
