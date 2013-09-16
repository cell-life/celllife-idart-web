package org.celllife.idart.application.unitofmeasure

import org.celllife.idart.application.unitofmeasure.dto.UnitOfMeasureDto
import org.celllife.idart.application.unitofmeasure.dto.UnitOfMeasureDtoAssembler
import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureNotFoundException
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService

import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.UnitOfMeasureCode.unitOfMeasureCode
import static org.celllife.idart.common.IdentifiableType.UNIT_OF_MEASURE
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureApplicationServiceImpl implements UnitOfMeasureApplicationService {

    @Inject UnitOfMeasureService unitOfMeasureService   

    @Inject UnitOfMeasureDtoAssembler unitOfMeasureDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(UnitOfMeasureCode unitOfMeasureCode) {
        unitOfMeasureService.exists(unitOfMeasureCode)
    }

    @Override
    UnitOfMeasureCode save(UnitOfMeasureDto unitOfMeasureDto) {

        def identifiable = identifiableService.resolveIdentifiable(UNIT_OF_MEASURE, unitOfMeasureDto.identifiers)

        def unitOfMeasureCode = unitOfMeasureCode(identifiable.getIdentifierValue(IDART))

        def unitOfMeasure = unitOfMeasureDtoAssembler.toUnitOfMeasure(unitOfMeasureDto)
        unitOfMeasure.id = unitOfMeasureCode

        unitOfMeasureService.save(unitOfMeasure)

        unitOfMeasure.id
    }

    @Override
    UnitOfMeasureDto findByUnitOfMeasureCode(UnitOfMeasureCode unitOfMeasureCode) {
        def identifier = newIdentifier(IDART, unitOfMeasureCode.value)
        findByIdentifier(identifier)
    }

    @Override
    UnitOfMeasureDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(UNIT_OF_MEASURE, [identifier] as Set)

        if (identifiable == null) {
            throw new UnitOfMeasureNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def unitOfMeasureCode = unitOfMeasureCode(identifiable.getIdentifierValue(IDART))

        def unitOfMeasure = unitOfMeasureService.findByUnitOfMeasureCode(unitOfMeasureCode)

        def unitOfMeasureDto = unitOfMeasureDtoAssembler.toUnitOfMeasureDto(unitOfMeasure)
        unitOfMeasureDto.identifiers = identifiable.identifiers

        unitOfMeasureDto
    }

    @Override
    UnitOfMeasureCode findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(UNIT_OF_MEASURE, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART)

        unitOfMeasureCode(idartIdentifierValue)
    }
}
