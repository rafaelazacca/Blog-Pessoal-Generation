package com.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioModelTest {

	public Usuario usuario;

	@Autowired
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@BeforeEach
	public void start() {
		usuario = new Usuario("Rafaela", "rafaelazaccaris@gmail.com", "rafaela10");
	}

	@Test
	public void testValidationAtributos() {
		
		  usuario.setNome("João"); 
		  usuario.setUsuario("joão@hotmail.com");
		  usuario.setSenha("123456");
		 
		
		//Armazena a lista de mensagens de erro
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
		
		//Exibe mensagem de erro
		System.out.println(violations.toString());
		
		//O teste só passa se a lista de erros estiver vazia
		assertTrue(violations.isEmpty());

	}

}
