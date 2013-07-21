package org.celllife.idart.application.organisation

import org.celllife.idart.domain.organisation.LegalOrganisation
import org.celllife.idart.domain.organisation.LegalOrganisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h33
 */
@Service
@Mixin(LegalOrganisationApplicationServiceMixin)
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LegalOrganisationApplicationServiceImpl implements LegalOrganisationApplicationService, LegalOrganisationResourceService {

    @Autowired LegalOrganisationService legalOrganisationService

    LegalOrganisation save(LegalOrganisation legalOrganisation) {
        legalOrganisationService.save(legalOrganisation)
    }

    LegalOrganisation findByIdentifier(String identifier) {
        legalOrganisationService.findByIdentifier(identifier)
    }

    Iterable<LegalOrganisation> findAll() {
        legalOrganisationService.findAll()
    }

}