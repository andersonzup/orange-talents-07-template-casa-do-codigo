package br.com.zup.casadocodigo.cadastrolivro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Livrorepository extends JpaRepository<Livro, Long> {
}
