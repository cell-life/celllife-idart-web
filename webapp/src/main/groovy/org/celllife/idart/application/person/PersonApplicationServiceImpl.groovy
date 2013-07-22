package org.celllife.idart.application.person

import org.celllife.idart.domain.person.Height
import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.person.PersonService
import org.celllife.idart.domain.person.Weight
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 23h08
 */
@Service class PersonApplicationServiceImpl implements PersonApplicationService, PersonResourceService {

    @Autowired PersonService personService

    @Autowired UnitOfMeasureService unitOfMeasureService

    Person save(Person person) {

        person?.with {

            physicalCharacteristics.each { physicalCharacteristic ->
                switch(physicalCharacteristic) {
                    case Height:
                        ((Height) physicalCharacteristic)?.with {
                            value?.with {
                                unitOfMeasure = unitOfMeasureService.findByCodes(unitOfMeasure?.codes)
                            }
                        }
                        break;
                    case Weight:
                        ((Weight) physicalCharacteristic)?.with {
                            value?.with {
                                unitOfMeasure = unitOfMeasureService.findByCodes(unitOfMeasure?.codes)
                            }
                        }
                        break;
                }
            }
        }

        personService.save(person)
    }

    @Override
    Person findByIdentifier(String identifier) {
        personService.findByIdentifier(identifier)
    }

    @Override
    Iterable<Person> findAll() {
        personService.findAll()
    }

    @Override
    Person update(Person person, Long existingPersonPk) {
        personService.update(person, existingPersonPk)
    }
}
