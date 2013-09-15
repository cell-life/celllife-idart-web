package org.celllife.idart.application.product.dto

import org.celllife.idart.domain.product.Medication
import org.celllife.idart.domain.product.Product
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
class ProductDtoAssembler {

    static Product toProduct(ProductDto productDto) {

        switch (productDto.class) {
            case MedicationDto:
                return toMedication(productDto as MedicationDto)
            default:
                throw new UnsupportedProductDtoType(productDto.class)
        }
    }

    static Medication toMedication(MedicationDto medicationDto) {

        def medication = new Medication()
        medication.with {
            name = medicationDto.name
        }

        medication
    }

    static ProductDto toProductDto(Product product) {

        switch (product.class) {
            case MedicationDto:
                return toMedicationDto(product as Medication)
            default:
                throw new UnsupportedProductType(product.class)
        }
    }

    static MedicationDto toMedicationDto(Medication medication) {

        def medicationDto = new MedicationDto()
        medicationDto.with {
            name = medication.name
        }

        medicationDto
    }
}
