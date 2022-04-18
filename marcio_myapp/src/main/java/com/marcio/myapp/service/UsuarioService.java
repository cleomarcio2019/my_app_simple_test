package com.marcio.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcio.myapp.dominio.Usuario;
import com.marcio.myapp.exceptions.ObjectNotFoundException;
import com.marcio.myapp.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findUsuario(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Informação não econtrada"));
	}

	public Usuario updateUsuario(Integer id, Usuario obj) {
		Usuario newobj = findUsuario(id);
		newobj.setNome(obj.getNome());
		newobj.setLogin(obj.getLogin());
		newobj.setSenha(obj.getSenha());
		return usuarioRepository.save(newobj);
		
	}

	public Usuario addUsuario(Usuario obj) {
		return usuarioRepository.save(obj);
	}
	
	public void removeUsuario(Integer id) {
		findUsuario(id);
		usuarioRepository.deleteById(id);
	}

}
