package br.com.zup.casadocodigo.cadastroestadopais;

import br.com.zup.casadocodigo.cadastroestadopais.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findByNome(String nome);
    Estado findByPaisId(Long idPais);

    List<Estado> findAllByPaisId(Long idPais);

    boolean existsByNomeAndPais_Id(String nome, Long idPais);
}
