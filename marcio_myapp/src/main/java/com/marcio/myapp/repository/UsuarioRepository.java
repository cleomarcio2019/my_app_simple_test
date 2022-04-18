package com.marcio.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.marcio.myapp.dominio.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
