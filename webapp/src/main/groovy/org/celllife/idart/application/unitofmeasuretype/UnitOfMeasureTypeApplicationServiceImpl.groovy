package org.celllife.idart.application.unitofmeasuretype

import org.celllife.idart.application.unitofmeasuretype.dto.UnitOfMeasureTypeDto
import org.celllife.idart.application.unitofmeasuretype.dto.UnitOfMeasureTypeDtoAssembler
import org.celllife.idart.common.UnitOfMeasureTypeCode
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeNotFoundException
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeService

import static org.celllife.idart.common.UnitOfMeasureTypeCode.unitOfMeasureTypeCode
import static org.celllife.idart.common.IdentifiableType.UNIT_OF_MEASURE_TYPE
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.SystemId.IDART_WEB

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureTypeApplicationServiceImpl implements UnitOfMeasureTypeApplicationService {

    @Inject UnitOfMeasureTypeService unitOfMeasureTypeService   

    @Inject UnitOfMeasureTypeDtoAssembler unitOfMeasureTypeDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(UnitOfMeasureTypeCode unitOfMeasureTypeCode) {
        unitOfMeasureTypeService.exists(unitOfMeasureTypeCode)
    }

    @Override
    UnitOfMeasureTypeCode save(UnitOfMeasureTypeDto unitOfMeasureTypeDto) {

        def identifiable = identifiableService.resolveIdentifiable(UNIT_OF_MEASURE_TYPE, unitOfMeasureTypeDto.identifiers)
        unitOfMeasureTypeDto.identifiers = identifiable.identifiers

        def unitOfMeasureTypeCode = unitOfMeasureTypeCode(identifiable.getIdentifierValue(IDART_WEB))

        def unitOfMeasureType = unitOfMeasureTypeDtoAssembler.toUnitOfMeasureType(unitOfMeasureTypeDto)
        unitOfMeasureType.id = unitOfMeasureTypeCode

        unitOfMeasureTypeService.save(unitOfMeasureType)

        unitOfMeasureType.id
    }

    @Override
    UnitOfMeasureTypeDto findByUnitOfMeasureTypeCode(UnitOfMeasureTypeCode unitOfMeasureTypeCode) {
        def identifier = newIdentifier(IDART_WEB, unitOfMeasureTypeCode.value)
        findByIdentifier(identifier)
    }

    @Override
    UnitOfMeasureTypeDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(UNIT_OF_MEASURE_TYPE, [identifier] as Set)

        if (identifiable == null) {
            throw new UnitOfMeasureTypeNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def unitOfMeasureTypeCode = unitOfMeasureTypeCode(identifiable.getIdentifierValue(IDART_WEB))

        def unitOfMeasureType = unitOfMeasureTypeService.findByUnitOfMeasureTypeCode(unitOfMeasureTypeCode)

        def unitOfMeasureTypeDto = unitOfMeasureTypeDtoAssembler.toUnitOfMeasureTypeDto(unitOfMeasureType)
        unitOfMeasureTypeDto.identifiers = identifiable.identifiers

        unitOfMeasureTypeDto
    }

    @Override
    UnitOfMeasureTypeCode findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(UNIT_OF_MEASURE_TYPE, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB)

        unitOfMeasureTypeCode(idartIdentifierValue)
    }
}
