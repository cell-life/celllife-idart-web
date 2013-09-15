package org.celllife.idart.application.system.dto

import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
class SystemDtoAssembler {

    static System toSystem(SystemDto systemDto) {

        def system = new System()
        system.with {
           applicationKey = systemDto.applicationKey
        }

        system
    }

    static SystemDto toSystemDto(System system) {

        def systemDto = new SystemDto()
        systemDto.with {
            applicationKey = system.applicationKey
        }

        systemDto
    }
}
