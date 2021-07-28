package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Livrorepository extends JpaRepository<Livro, Long> {
}
