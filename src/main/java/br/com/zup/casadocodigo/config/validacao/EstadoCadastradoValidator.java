package br.com.zup.casadocodigo.config.validacao;

import br.com.zup.casadocodigo.cadastrocliente.RequestClientDto;
import br.com.zup.casadocodigo.cadastroestadopais.EstadoRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EstadoCadastradoValidator implements Validator {

    private EstadoRepository estadoRepository;
    public EstadoCadastradoValidator(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RequestClientDto.class.isAssignableFrom(aClass);
    }
    //se o país tiver estados, um estado precisa ser selecionado
    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            System.out.println("Tem outro erro");
            return;
        }
        RequestClientDto request = (RequestClientDto) target;
        boolean exist = estadoRepository.existsByPais_Id(request.getIdPais());
        boolean isAssociado = estadoRepository.existsByIdAndPais_Id(request.getIdEstado(), request.getIdPais());
        if (!isAssociado && request.getIdEstado() != 0){
           errors.rejectValue("idEstado", null, "Esse estado não pertence a esse país se o não houver estados cadastrados o valor do campo deve ser 0");
        }
        if(exist && request.getIdEstado() < 1){
            errors.rejectValue("idEstado", null, "Existe estados neste país, escolha um");
        }
    }
}
