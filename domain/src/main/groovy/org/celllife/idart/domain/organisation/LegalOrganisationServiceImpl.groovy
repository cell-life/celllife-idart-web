package org.celllife.idart.domain.organisation

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class LegalOrganisationServiceImpl implements LegalOrganisationService {

    @Autowired LegalOrganisationRepository legalOrganisationRepository

    @Autowired LegalOrganisationSequence legalOrganisationSequence

    @Autowired LegalOrganisationValidator legalOrganisationValidator

    @Override
    LegalOrganisation save(LegalOrganisation newLegalOrganisation) {

        legalOrganisationValidator.validate(newLegalOrganisation)

        def existingLegalOrganisation = findByIdentifiers(newLegalOrganisation.identifiers)

        if (requiresIdartIdentifier(newLegalOrganisation, existingLegalOrganisation)) {
            newLegalOrganisation.addIdentifier(LegalOrganisation.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingLegalOrganisation == null) {
            existingLegalOrganisation = new LegalOrganisation()
        }

        existingLegalOrganisation.merge(newLegalOrganisation)

        legalOrganisationRepository.save(existingLegalOrganisation)
    }

    @Override
    LegalOrganisation findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingLegalOrganisation = legalOrganisationRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingLegalOrganisation != null) {
                return existingLegalOrganisation
            }
        }

        null
    }

    @Override
    LegalOrganisation findByIdentifier(String identifier) {
        legalOrganisationRepository.findOneByIdentifier(LegalOrganisation.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<LegalOrganisation> findAll() {
        legalOrganisationRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", legalOrganisationSequence.nextValue())
    }

    static requiresIdartIdentifier(LegalOrganisation... legalOrganisations) {

        for (LegalOrganisation legalOrganisation in legalOrganisations) {
            if (legalOrganisation?.hasIdentifierForSystem(LegalOrganisation.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
