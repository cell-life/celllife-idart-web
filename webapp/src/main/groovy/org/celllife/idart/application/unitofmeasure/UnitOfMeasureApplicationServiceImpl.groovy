package org.celllife.idart.application.unitofmeasure

import org.celllife.idart.application.unitofmeasure.dto.UnitOfMeasureDto
import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureNotFoundException
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService

import static org.celllife.idart.application.unitofmeasure.dto.UnitOfMeasureDtoAssembler.toUnitOfMeasure
import static org.celllife.idart.application.unitofmeasure.dto.UnitOfMeasureDtoAssembler.toUnitOfMeasureDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.UnitOfMeasureCode.unitOfMeasureCode
import static org.celllife.idart.domain.identifiable.IdentifiableType.UNIT_OF_MEASURE
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureApplicationServiceImpl implements UnitOfMeasureApplicationService {

    @Inject UnitOfMeasureService unitOfMeasureService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(UnitOfMeasureCode unitOfMeasureCode) {
        unitOfMeasureService.exists(unitOfMeasureCode)
    }

    UnitOfMeasureCode save(UnitOfMeasureDto unitOfMeasureDto) {

        def unitOfMeasure = toUnitOfMeasure(unitOfMeasureDto)

        def identifiable = identifiableService.findByIdentifiers(UNIT_OF_MEASURE, unitOfMeasureDto.identifiers)
        if (identifiable == null) {

            unitOfMeasure = unitOfMeasureService.save(unitOfMeasure)

            identifiable = new Identifiable(type: UNIT_OF_MEASURE, identifiers: unitOfMeasureDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, unitOfMeasure.id.value))
            identifiableService.save(identifiable)

        } else {

            unitOfMeasure.id = unitOfMeasureCode(identifiable.getIdentifier(IDART).value)
            unitOfMeasureService.save(unitOfMeasure)

        }

        unitOfMeasure.id
    }

    @Override
    UnitOfMeasureDto findByUnitOfMeasureCode(UnitOfMeasureCode unitOfMeasureCode) {
        def identifier = newIdentifier(IDART, unitOfMeasureCode.value)
        findByIdentifier(identifier)
    }

    @Override
    UnitOfMeasureDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(UNIT_OF_MEASURE, [identifier] as Set)

        if (identifiable == null) {
            throw new UnitOfMeasureNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def unitOfMeasureCode = unitOfMeasureCode(identifiable.getIdentifier(IDART).value)

        def unitOfMeasure = unitOfMeasureService.findByUnitOfMeasureCode(unitOfMeasureCode)

        def unitOfMeasureDto = toUnitOfMeasureDto(unitOfMeasure)
        unitOfMeasureDto.identifiers = identifiable.identifiers

        unitOfMeasureDto
    }
}
