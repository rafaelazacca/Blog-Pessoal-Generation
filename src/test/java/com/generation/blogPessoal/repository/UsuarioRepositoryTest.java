package com.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Optional;
import com.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	public void start() {
		usuarioRepository.deleteAll();
		
		Usuario usuario = new Usuario("Gustavo Novaes", "gustavo.novaes@hotmail.com","gustavo20");
		
		if(usuarioRepository.findByUsuario("gustavo.novaes@hotmail.com").isEmpty()) {
			usuarioRepository.save(usuario);
		}
		
		usuario = new Usuario("Gustavo Lima", "gustavo.lima@hotmail.com","gustavoli");
		if(usuarioRepository.findByUsuario("gustavo.lima@hotmail.com").isEmpty()) {
			usuarioRepository.save(usuario);
		}
		
		usuario = new Usuario("Gustavo Borges", "gustavo.borges@hotmail.com","gustavoborges");
		if(usuarioRepository.findByUsuario("gustavo.borges@hotmail.com").isEmpty()) {
			usuarioRepository.save(usuario);
		}
		
		usuario = new Usuario("Jorge Lima", "jorge.lima@hotmail.com","jorginho");
		if(usuarioRepository.findByUsuario("gustavo.lima@hotmail.com").isEmpty()) {
			usuarioRepository.save(usuario);
		}
		
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void testFindByUsuario() throws Exception {
		Optional<Usuario> usuario;
		
		usuario = usuarioRepository.findByUsuario("rafaelazaccarias@gmail.com");
		
		assertTrue(usuario.get().getUsuario().equals("rafaelazaccarias@gmail.com"));
	}
	
	@Test
	public void testFindAllIgnoringCase() throws Exception {
		List<Usuario> usuario = usuarioRepository.findAllByNomeContainingIgnoreCase("Rafaela");
		
		assertEquals(3, usuario.size());
		
	}
	
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();

	}
}
