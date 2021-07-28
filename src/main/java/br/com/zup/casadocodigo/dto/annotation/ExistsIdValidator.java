package br.com.zup.casadocodigo.dto.annotation;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Long> {

    String fieldName;
    Class<?> dClass;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(ExistsId constraint) {
        fieldName = constraint.fieldName();
        dClass = constraint.domainClass();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select c from "+dClass.getName()+" c where c."+fieldName+"=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Não foi encontrado um "+fieldName+" para "+dClass);
        return !list.isEmpty();
    }
}
