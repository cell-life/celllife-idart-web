package org.celllife.idart.domain.organisation

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class LegalOrganisationServiceImpl implements LegalOrganisationService {

    @Autowired LegalOrganisationRepository legalOrganisationRepository

    @Override
    LegalOrganisation save(LegalOrganisation legalOrganisation) {

        LegalOrganisation existingLegalOrganisation = findByIdentifiers(legalOrganisation.identifiers)
        if (existingLegalOrganisation == null) {
            existingLegalOrganisation = legalOrganisation.class.newInstance()
        }

        existingLegalOrganisation.merge(legalOrganisation)

        legalOrganisationRepository.save(existingLegalOrganisation)
    }


    @Override
    Iterable<LegalOrganisation> findAll() {
        legalOrganisationRepository.findAll()
    }

    @Override
    LegalOrganisation findByIdentifier(String identifier) {
        null
    }

    @Override
    LegalOrganisation findByIdentifiers(Iterable<Identifier> identifiers) {

        if (identifiers == null) {
            return null
        }

        for (Identifier identifier: identifiers) {
            LegalOrganisation legalOrganisation = legalOrganisationRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (legalOrganisation != null) {
                return legalOrganisation
            }
        }

        null
    }
}