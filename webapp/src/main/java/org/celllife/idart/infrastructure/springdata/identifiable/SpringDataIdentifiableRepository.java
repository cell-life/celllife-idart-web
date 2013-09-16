package org.celllife.idart.infrastructure.springdata.identifiable;

import org.celllife.idart.common.IdentifiableType;
import org.celllife.idart.common.SystemId;
import org.celllife.idart.domain.identifiable.Identifiable;
import org.celllife.idart.domain.identifiable.IdentifiableRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 15h59
 */
public interface SpringDataIdentifiableRepository extends IdentifiableRepository, CrudRepository<Identifiable, Long> {

    @Query("select identifiable " +
            "   from Identifiable identifiable" +
            "   join identifiable.identifiers identifier" +
            "   where identifiable.type = :type " +
            "   and identifier.system = :system " +
            "   and identifier.value = :value")
    Identifiable findByTypeAndSystemAndValue(@Param("type") IdentifiableType type,
                                             @Param("system") SystemId system,
                                             @Param("value") String value);

}
