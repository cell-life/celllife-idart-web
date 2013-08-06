package org.celllife.idart.domain.encounter

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class EncounterServiceImpl implements EncounterService {

    @Autowired EncounterRepository encounterRepository

    @Autowired EncounterSequence encounterSequence

    @Autowired EncounterValidator encounterValidator

    @Override
    Encounter save(Encounter newEncounter) {

        encounterValidator.validate(newEncounter)

        def existingEncounter = findByIdentifiers(newEncounter.identifiers)

        if (requiresIdartIdentifier(newEncounter, existingEncounter)) {
            newEncounter.addIdentifier(Encounter.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingEncounter == null) {
            existingEncounter = new Encounter()
        }

        existingEncounter.merge(newEncounter)

        encounterRepository.save(existingEncounter)
    }

    @Override
    Encounter findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingEncounter = encounterRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingEncounter != null) {
                return existingEncounter
            }
        }

        null
    }

    @Override
    Encounter findByIdentifier(String identifier) {
        encounterRepository.findOneByIdentifier(Encounter.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<Encounter> findAll() {
        encounterRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", encounterSequence.nextValue())
    }

    static requiresIdartIdentifier(Encounter... encounters) {

        for (Encounter encounter in encounters) {
            if (encounter?.hasIdentifierForSystem(Encounter.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
