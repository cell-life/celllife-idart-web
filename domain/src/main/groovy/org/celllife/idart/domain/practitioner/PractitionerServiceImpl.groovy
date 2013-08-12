package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.PractitionerIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PractitionerServiceImpl implements PractitionerService {

    @Autowired PractitionerRepository practitionerRepository

    @Autowired PractitionerValidator practitionerValidator

    @Autowired PractitionerEventPublisher practitionerEventPublisher

    @Override
    Practitioner save(Practitioner practitioner) throws PractitionerValidationException {

        practitionerValidator.validate(practitioner)

        practitionerEventPublisher.practitionerSaved(practitioner)

        practitionerRepository.save(practitioner)
    }

    @Override
    Practitioner findByPractitionerIdentifier(PractitionerIdentifier practitionerIdentifier) throws PractitionerNotFoundException {

        def practitioner = practitionerRepository.findOne(practitionerIdentifier)

        if (practitioner == null) {
            throw new PractitionerNotFoundException("Could not find Practitioner with Practitioner Identifier [${ practitionerIdentifier}]")
        }

        practitioner
    }
}