package com.marcio.myapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcio.myapp.dominio.Usuario;
import com.marcio.myapp.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/lista")
    public ResponseEntity<List<Usuario>> findAllFile() {
    	List<Usuario> list = usuarioService.findAll();
    	return ResponseEntity.ok().body(list);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findUser(@PathVariable Integer id){
		Usuario obj = this.usuarioService.findUsuario(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUser(@PathVariable Integer id, @RequestBody Usuario obj){
		Usuario newobj = usuarioService.updateUsuario(id, obj);
		return ResponseEntity.ok().body(newobj);
	}
	
	@PostMapping("/inserir")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario obj){
		Usuario newObj = usuarioService.addUsuario(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id){
		usuarioService.removeUsuario(id);
		return ResponseEntity.noContent().build();
	}
	

}
