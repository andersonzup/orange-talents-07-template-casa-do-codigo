package br.com.zup.casadocodigo.cadastroestadopais;

import br.com.zup.casadocodigo.cadastroestadopais.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
