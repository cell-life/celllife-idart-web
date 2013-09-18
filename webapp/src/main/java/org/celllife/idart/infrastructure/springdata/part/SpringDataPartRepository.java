package org.celllife.idart.infrastructure.springdata.part;

import org.celllife.idart.common.PartId;
import org.celllife.idart.domain.part.Part;
import org.celllife.idart.domain.part.PartRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 */
public interface SpringDataPartRepository extends PartRepository, PagingAndSortingRepository<Part, PartId> {

    @Query("select part.id from Part part where type(part) = :clazz")
    Collection<PartId> findByClass(@Param("clazz") Class<? extends Part> clazz);

    @Query("select part.id from Part part where lower(label.value) = lower(:labelValue)")
    PartId findByLabelValue(@Param("labelValue") String labelValue);

}
