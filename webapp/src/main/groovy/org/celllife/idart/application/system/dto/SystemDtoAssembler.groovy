package org.celllife.idart.application.system.dto

import org.celllife.idart.domain.system.System

import javax.inject.Named

/**
 */
@Named class SystemDtoAssembler {

    System toSystem(SystemDto systemDto) {

        def system = new System()
        system.with {
           applicationKey = systemDto.applicationKey
        }

        system
    }

    SystemDto toSystemDto(System system) {

        def systemDto = new SystemDto()
        systemDto.with {
            applicationKey = system.applicationKey
        }

        systemDto
    }
}
