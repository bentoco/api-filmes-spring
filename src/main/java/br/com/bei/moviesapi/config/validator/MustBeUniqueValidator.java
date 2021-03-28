package br.com.bei.moviesapi.config.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class MustBeUniqueValidator implements ConstraintValidator<MustBeUnique, Object> {

    @PersistenceContext
    private EntityManager manager;

    private String column;
    private Class<?> target;

    @Override public void initialize ( MustBeUnique params ) {
        this.column = params.column();
        this.target = params.target();
    }

    @Override public boolean isValid ( Object value , ConstraintValidatorContext context ) {
        String s = String.format("SELECT 1 FROM %s WHERE %s=:value", target.getName(), column);
        Query query = manager.createQuery(s);
        query.setParameter("value", value);
        List<?> result = query.getResultList();
        return result.isEmpty();
    }
}
