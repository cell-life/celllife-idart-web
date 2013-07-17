package org.celllife.idart.domain.part;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 21h34
 */
@RestResource(path = "subassemblies")
public interface SubassemblyRepository extends PagingAndSortingRepository<Subassembly, Long> {
}
