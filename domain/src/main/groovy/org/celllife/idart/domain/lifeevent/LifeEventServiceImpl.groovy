package org.celllife.idart.domain.lifeevent

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class LifeEventServiceImpl implements LifeEventService {

    @Autowired LifeEventRepository lifeEventRepository

    @Autowired LifeEventValidator lifeEventValidator

    @Override
    LifeEvent save(LifeEvent lifeEvent) throws LifeEventValidationException {

        lifeEventValidator.validate(lifeEvent)

        lifeEventRepository.save(lifeEvent)
    }

    @Override
    LifeEvent findByCode(LifeEventCode code) throws LifeEventNotFoundException {

        def lifeEvent = lifeEventRepository.findOne(code)

        if (lifeEvent == null) {
            throw new LifeEventNotFoundException("Could not find LifeEvent with Code [${ code}]")
        }

        lifeEvent
    }
}