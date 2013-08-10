package org.celllife.idart.codegen.entity

import java.util.regex.Pattern

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class EntityModelEnricher {

    static enrichAggregateRoot(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            if (name == null) {
                throw new RuntimeException()
            }

            if (description == null) {
                description = null
            }

            if (namePlural == null) {
                namePlural = name + "s"
            }

            if (packageName == null) {
                packageName = name.replaceAll(/ /, '').toLowerCase()
            }

            if (resourcePath == null) {
                resourcePath = toFieldName(namePlural.replaceAll(/ /, ''))
            }

            if (namespace == null) {
                namespace = baseNamespace + "/" + resourcePath
            }

            /*
             * Entity
             */

            if (entity == null) {
                entity = [:]
            }

            entity.with() {

                if (className == null) {
                    className = toCamelCase(model.name)
                }

                if (collectionClassName == null) {
                    collectionClassName = toCamelCase(model.namePlural)
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.domain.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(model.name)
                }

                if (collectionFieldName == null) {
                    collectionFieldName = toFieldName(model.namePlural)
                }

                if (tableName == null) {
                    tableName = toSnakeCase(className)
                }

                /*
                 * Identifier
                 */

                if (identifier == null) {
                    identifier = [:]
                }

                identifier.with {

                    if (name == null) {
                        name = model.name + " Identifier"
                    }

                    if (className == null) {
                        className = toCamelCase(name)
                    }

                    if (fieldName == null) {
                        fieldName = toFieldName(name)
                    }

                    /*
                     * Identifier Properties
                     */

                    if (_properties == null) {
                        _properties = [[name: "Value"]]
                    }

                    _properties.each { property ->

                        /*
                         * Identifier Property
                         */

                        property.with {

                            if (property.name == null) {
                                throw new RuntimeException()
                            }

                            property.with {
                                if (type == null) {
                                    type = "String"
                                }
                                if (fieldName == null) {
                                    fieldName = toFieldName(property.name)
                                }
                                if (columnName == null) {
                                    columnName = toSnakeCase(fieldName)
                                }
                                if (columnType == null) {
                                    columnType = "varchar(31)"
                                }
                            }
                        }
                    }
                }

                /*
                 * Properties
                 */

                if (_properties == null) {
                    _properties = []
                }

                _properties.each { property ->

                    if (property.name == null) {
                        throw new RuntimeException()
                    }

                    property.with {
                        if (type == null) {
                            type = "String"
                        }
                        if (fieldName == null) {
                            fieldName = toFieldName(property.name)
                        }
                        if (unique == null) {
                            unique = false
                        }
                        if (indexed == null) {
                            indexed = false
                        }
                    }
                }
            }

            /*
             * Repository Interface
             */

            if (repository == null) {
                repository = [:]
            }

            repository.with {

                if (className == null) {
                    className = "${model.entity.className}Repository"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.domain.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }

            /*
             * Spring Data Repository Implementation
             */

            if (springDataRepository == null) {
                springDataRepository = [:]
            }

            springDataRepository.with {

                if (className == null) {
                    className = "SpringData${model.entity.className}Repository"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.infrastructure.springdata.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }

            /*
             * Event Publisher Interface
             */

            if (eventPublisher == null) {
                eventPublisher = [:]
            }

            eventPublisher.with {

                if (className == null) {
                    className = "${model.entity.className}EventPublisher"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.domain.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }

            /*
             * Validator Interface
             */

            if (validator == null) {
                validator = [:]
            }

            validator.with {

                if (className == null) {
                    className = "${model.entity.className}Validator"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.domain.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }

            /*
             * jsr303 Validator Implementation
             */

            if (jsr303Validator == null) {
                jsr303Validator = [:]
            }

            jsr303Validator.with {

                if (className == null) {
                    className = "Jsr303${model.entity.className}Validator"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.infrastructure.jsr303.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }

            /*
             * Domain Service Interface
             */

            if (domainService == null) {
                domainService = [:]
            }

            domainService.with {

                if (className == null) {
                    className = "${model.entity.className}Service"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.domain.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }

            /*
             * Application Service Interface
             */

            if (applicationService == null) {
                applicationService = [:]
            }

            applicationService.with {

                if (className == null) {
                    className = "${model.entity.className}ApplicationService"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.application.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }

            }

            /*
             * Controller
             */

            if (resourceController == null) {
                resourceController = [:]
            }

            resourceController.with {

                if (className == null) {
                    className = "${model.entity.className}ResourceController"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.interfaces.resource.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }
        }

        model
    }

    static def toPackage(String namespace) {
        def pattern = Pattern.compile(/^http:\/\/www\.([^\/]+)\/(.*)$/)
        def matcher = pattern.matcher(namespace)

        if (!matcher.matches()) {
            throw new RuntimeException()
        }

        def domain = matcher.group(1)
        def domainPackage = domain.split(/\./).reverse().join(".")

        (domainPackage + "." + matcher.group(2).replaceAll("/", ".")).replaceAll(/-/, '')
    }

    static toFieldName(name) {
        name = toCamelCase(name)

        name.substring(0, 1).toLowerCase() + name.substring(1)
    }

    static String toCamelCase(String text) {
        text.replaceAll(/([A-Z])([A-Z]*)[_| ]?([A-Z][a-z])/, { Object[] it -> "${it[1]}${it[2].toLowerCase()}${it[3]}" })
                .replaceAll("([_| ])([A-Za-z0-9])", { Object[] it -> it[2].toUpperCase() })
    }

    static String toSnakeCase(String text) {
        toCamelCase(text)
        // Handles: aB -> a_b
                .replaceAll(/([a-z])([A-Z])/, /$1_$2/)
        // Handles: ABCd -> ab_cd
                .replaceAll(/([A-Z])([A-Z]([a-z]))/, /$1_$2/)
                .toLowerCase()
                .replaceAll(/^_/, '')
    }
}
