package org.celllife.idart.application.unitofmeasuretype

import org.celllife.idart.application.unitofmeasuretype.dto.UnitOfMeasureTypeDto
import org.celllife.idart.common.UnitOfMeasureTypeCode
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeNotFoundException
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeService

import static org.celllife.idart.application.unitofmeasuretype.dto.UnitOfMeasureTypeDtoAssembler.toUnitOfMeasureType
import static org.celllife.idart.application.unitofmeasuretype.dto.UnitOfMeasureTypeDtoAssembler.toUnitOfMeasureTypeDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.UnitOfMeasureTypeCode.unitOfMeasureTypeCode
import static org.celllife.idart.domain.identifiable.IdentifiableType.UNIT_OF_MEASURE_TYPE
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureTypeApplicationServiceImpl implements UnitOfMeasureTypeApplicationService {

    @Inject UnitOfMeasureTypeService unitOfMeasureTypeService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(UnitOfMeasureTypeCode unitOfMeasureTypeCode) {
        unitOfMeasureTypeService.exists(unitOfMeasureTypeCode)
    }

    UnitOfMeasureTypeCode save(UnitOfMeasureTypeDto unitOfMeasureTypeDto) {

        def unitOfMeasureType = toUnitOfMeasureType(unitOfMeasureTypeDto)

        def identifiable = identifiableService.findByIdentifiers(UNIT_OF_MEASURE_TYPE, unitOfMeasureTypeDto.identifiers)
        if (identifiable == null) {

            unitOfMeasureType = unitOfMeasureTypeService.save(unitOfMeasureType)

            identifiable = new Identifiable(type: UNIT_OF_MEASURE_TYPE, identifiers: unitOfMeasureTypeDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, unitOfMeasureType.id.value))
            identifiableService.save(identifiable)

        } else {

            unitOfMeasureType.id = unitOfMeasureTypeCode(identifiable.getIdentifier(IDART).value)
            unitOfMeasureTypeService.save(unitOfMeasureType)

        }

        unitOfMeasureType.id
    }

    @Override
    UnitOfMeasureTypeDto findByUnitOfMeasureTypeCode(UnitOfMeasureTypeCode unitOfMeasureTypeCode) {
        def identifier = newIdentifier(IDART, unitOfMeasureTypeCode.value)
        findByIdentifier(identifier)
    }

    @Override
    UnitOfMeasureTypeDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(UNIT_OF_MEASURE_TYPE, [identifier] as Set)

        if (identifiable == null) {
            throw new UnitOfMeasureTypeNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def unitOfMeasureTypeCode = unitOfMeasureTypeCode(identifiable.getIdentifier(IDART).value)

        def unitOfMeasureType = unitOfMeasureTypeService.findByUnitOfMeasureTypeCode(unitOfMeasureTypeCode)

        def unitOfMeasureTypeDto = toUnitOfMeasureTypeDto(unitOfMeasureType)
        unitOfMeasureTypeDto.identifiers = identifiable.identifiers

        unitOfMeasureTypeDto
    }
}
