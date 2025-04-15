package com.gustavo.gerenciamento_clinicas_medicas.repository;

import com.gustavo.gerenciamento_clinicas_medicas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.role = :role")
    List<Usuario> findByRole(@Param("role") Usuario.TipoUsuario role);

    @Query("SELECT u FROM Usuario u WHERE u.ativo = :ativo")
    List<Usuario> findByAtivo(@Param("ativo") boolean ativo);
}
