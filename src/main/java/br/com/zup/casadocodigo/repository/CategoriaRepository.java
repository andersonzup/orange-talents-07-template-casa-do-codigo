package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{
    boolean existsByNome(String value);
}
