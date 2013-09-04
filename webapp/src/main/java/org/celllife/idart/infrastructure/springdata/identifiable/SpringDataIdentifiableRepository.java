package org.celllife.idart.infrastructure.springdata.identifiable;

import org.celllife.idart.common.AuthorityId;
import org.celllife.idart.domain.identifiable.Identifiable;
import org.celllife.idart.domain.identifiable.IdentifiableRepository;
import org.celllife.idart.domain.identifiable.IdentifiableType;
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
            "   and identifier.authority = :authority " +
            "   and identifier.value = :value")
    Identifiable findByTypeAndAuthorityAndValue(@Param("type") IdentifiableType type,
                                                @Param("authority") AuthorityId authority,
                                                @Param("value") String value);

}
