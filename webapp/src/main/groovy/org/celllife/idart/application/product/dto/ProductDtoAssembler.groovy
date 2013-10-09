package org.celllife.idart.application.product.dto

import org.celllife.idart.application.part.PartApplicationService
import org.celllife.idart.domain.product.Medication
import org.celllife.idart.domain.product.Product

import javax.inject.Inject
import javax.inject.Named

/**
 */
@Named class ProductDtoAssembler {

    @Inject PartApplicationService partApplicationService

    Product toProduct(ProductDto productDto) {

        switch (productDto.class) {
            case MedicationDto:
                return toMedication(productDto as MedicationDto)
            default:
                throw new UnsupportedProductDtoType(productDto.class)
        }
    }

    Medication toMedication(MedicationDto medicationDto) {

        def medication = new Medication()
        medication.with {

            name = medicationDto.name

            if (medicationDto.drug != null && !medicationDto.drug.empty) {
                drug = partApplicationService.findByIdentifiers(medicationDto.drug)
            }
        }

        medication
    }

    ProductDto toProductDto(Product product) {

        switch (product.class) {
            case Medication:
                return toMedicationDto(product as Medication)
            default:
                throw new UnsupportedProductType(product.class)
        }
    }

    MedicationDto toMedicationDto(Medication medication) {

        def medicationDto = new MedicationDto()
        medicationDto.with {

            name = medication.name

            if (medicationDto.drug != null) {
                drug = partApplicationService.findByPartId(medication.drug)?.identifiers
            }
        }

        medicationDto
    }
}
