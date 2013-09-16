package org.celllife.idart.codegen.entity

import static org.celllife.idart.codegen.transform.ApplicationServiceModelEnricher.enrichModelWithApplicationService
import static org.celllife.idart.codegen.transform.CamelEventPublisherModelEnricher.enrichModelWithCamelEventPublisher
import static org.celllife.idart.codegen.transform.DomainEventModelEnricher.enrichModelWithDomainEvent
import static org.celllife.idart.codegen.transform.DomainServiceModelEnricher.enrichModelWithDomainService
import static org.celllife.idart.codegen.transform.DtoAssemblerModelEnricher.enrichModelWithDtoAssembler
import static org.celllife.idart.codegen.transform.DtoModelEnricher.enrichModelWithDto
import static org.celllife.idart.codegen.transform.EntityModelEnricher.enrichModelWithEntity
import static org.celllife.idart.codegen.transform.EventPublisherModelEnricher.enrichModelWithEventPublisher
import static org.celllife.idart.codegen.transform.IdModelEnricher.enrichModelWithId
import static org.celllife.idart.codegen.transform.IncludedFeatureModelEnricher.enrichModelWithIncludedFeatures
import static org.celllife.idart.codegen.transform.Jsr303ValidatorModelEnricher.enrichModelWithJsr303Validator
import static org.celllife.idart.codegen.transform.ModelEnricher.enrichModel
import static org.celllife.idart.codegen.transform.RepositoryModelEnricher.enrichModelWithRepository
import static org.celllife.idart.codegen.transform.ResourceControllerServiceModelEnricher.enrichModelWithResourceController
import static org.celllife.idart.codegen.transform.SecurityAdapterModelEnricher.enrichModelWithSecurityAdapter
import static org.celllife.idart.codegen.transform.SpringDataRepositoryModelEnricher.enrichModelWithSpringDataRepository
import static org.celllife.idart.codegen.transform.ValidatorModelEnricher.enrichModelWithValidator

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-12
 * Time: 13h54
 */
class EntityModelTransform {

    static transform(baseNamespace, model) {

        enrichModel(baseNamespace, model)

        enrichModelWithIncludedFeatures(baseNamespace, model)

        enrichModelWithEntity(baseNamespace, model)
        enrichModelWithId(baseNamespace, model)

        enrichModelWithRepository(baseNamespace, model)
        enrichModelWithSpringDataRepository(baseNamespace, model)

        enrichModelWithValidator(baseNamespace, model)
        enrichModelWithJsr303Validator(baseNamespace, model)

        enrichModelWithDomainService(baseNamespace, model)
        enrichModelWithApplicationService(baseNamespace, model)
        enrichModelWithDto(baseNamespace, model)
        enrichModelWithDtoAssembler(baseNamespace, model)

        enrichModelWithSecurityAdapter(baseNamespace, model)
        enrichModelWithResourceController(baseNamespace, model)

        enrichModelWithDomainEvent(baseNamespace, model)
        enrichModelWithEventPublisher(baseNamespace, model)
        enrichModelWithCamelEventPublisher(baseNamespace, model)
    }
}
