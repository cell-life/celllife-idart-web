package org.celllife.idart.framework.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.celllife.idart.domain.common.Codeable;
import org.celllife.idart.domain.common.Persistable;
import org.celllife.idart.domain.concept.Code;
import org.celllife.idart.domain.concept.Codes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 10h15
 */
@Aspect
public final class InjectCodedAspect {

    private EntityManagerFactory entityManagerFactory;

    @Before(value = "@annotation(injectCoded)", argNames = "joinPoint, injectCoded")
    public void before(JoinPoint joinPoint, InjectCoded injectCoded) {

        if (joinPoint == null) {
            return;
        }

        Object target = joinPoint.getTarget();
        if (target == null) {
            return;
        }

        Signature signature = joinPoint.getSignature();
        if (signature == null) {
            return;
        }

        Object[] args = joinPoint.getArgs();
        if (args.length != 1) {
            return;
        }

        Object arg = args[0];
        if (arg == null) {
            return;
        }

        Class<?> argClass = arg.getClass();
        if (!Persistable.class.isAssignableFrom(argClass) || !Codeable.class.isAssignableFrom(argClass)) {
            return;
        }
        Class<? extends Codeable> codedClass = (Class<? extends Codeable>) arg.getClass();

        Codeable codeable = (Codeable) arg;

        if (((Persistable) codeable).getPk() != null) {
            return;
        }

        Set<String> codeSystems = codeable.getCodeSystems();
        for (String codeSystem : codeSystems) {

            if (codeSystem == null) {
                continue;
            }

            String codeValue = codeable.getCodeValue(codeSystem);
            if (codeValue == null) {
                continue;
            }

            EntityManager entityManager = entityManagerFactory.createEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<? extends Codeable> query = criteriaBuilder.createQuery(codedClass);
            Root<? extends Codeable> root = query.from(codedClass);
            Join<? extends Codeable, Codes> codes = root.join("codes");
            Join<? extends Codes, Code> codesCodes = codes.join("codes");

            query.where(
                    criteriaBuilder.equal(codesCodes.get("system"), codeSystem),
                    criteriaBuilder.equal(codesCodes.get("value"), codeValue)
            );

            List<? extends Codeable> results = entityManager.createQuery(query).getResultList();
            if (!results.isEmpty()) {
                ((Persistable) codeable).setPk(((Persistable) results.get(0)).getPk());
                return;
            }
        }
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}