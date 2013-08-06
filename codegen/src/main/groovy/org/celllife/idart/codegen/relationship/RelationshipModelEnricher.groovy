package org.celllife.idart.codegen.relationship

import java.util.regex.Pattern

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class RelationshipModelEnricher {

    static enrichRelationshipModel(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * From Entity
             */

            if (from == null) {
                throw new RuntimeException()
            }

            from.with() {

                if (name == null) {
                    throw new RuntimeException()
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
                        className = toCamelCase(model.from.name)
                    }

                    if (packageName == null) {
                        packageName = "${basePackageName}.domain.${model.from.packageName}"
                    }

                    if (fieldName == null) {
                        fieldName = toFieldName(model.from.name)
                    }

                    if (collectionFieldName == null) {
                        collectionFieldName = toFieldName(model.from.namePlural)
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
                            name = "Identifier"
                        }

                        if (className == null) {
                            className = model.from.entity.className + name
                        }

                        if (fieldName == null) {
                            fieldName = toFieldName(name)
                        }
                    }
                }
            }

            /*
             * To Entity
             */

            if (to == null) {
                throw new RuntimeException()
            }

            to.with() {


                if (name == null) {
                    throw new RuntimeException()
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
                        className = toCamelCase(model.to.name)
                    }

                    if (packageName == null) {
                        packageName = "${basePackageName}.domain.${model.to.packageName}"
                    }

                    if (fieldName == null) {
                        fieldName = toFieldName(model.to.name)
                    }

                    if (collectionFieldName == null) {
                        collectionFieldName = toFieldName(model.to.namePlural)
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
                            name = "Identifier"
                        }

                        if (className == null) {
                            className = model.to.entity.className + name
                        }

                        if (fieldName == null) {
                            fieldName = toFieldName(name)
                        }
                    }
                }
            }

            if (name == null) {
                throw new RuntimeException()
            }

            if (fullName == null) {
                fullName = from.name + " " + name + " " + to.name
            }

            if (className == null) {
                className = toCamelCase(fullName)
            }

            if (packageName == null) {
                packageName = from.packageName + to.packageName
            }

            if (resourcePath == null) {
                resourcePath = toFieldName(model.name) + toCamelCase(model.to.namePlural)
            }

            /*
             * Repository Interface
             */

            if (repository == null) {
                repository = [:]
            }

            repository.with {

                if (className == null) {
                    className = "${model.className}Repository"
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
                    className = "SpringData${model.className}Repository"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.infrastructure.springdata.${model.packageName}"
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
                    className = "${model.className}Service"
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
                    className = "${model.className}ApplicationService"
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
                    className = "${model.className}ResourceController"
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
