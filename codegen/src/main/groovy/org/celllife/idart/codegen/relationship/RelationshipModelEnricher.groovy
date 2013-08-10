package org.celllife.idart.codegen.relationship

import org.celllife.idart.codegen.entity.EntityModelEnricher

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

            EntityModelEnricher.enrichAggregateRoot(baseNamespace, from)

            /*
             * To Entity
             */

            EntityModelEnricher.enrichAggregateRoot(baseNamespace, to)

            relationships.each {relationship ->

                relationship.with {

                    if (name == null) {
                        throw new RuntimeException()
                    }

                    if (constantName == null) {
                        constantName = toSnakeCase(name).toUpperCase()
                    }

                    if (resourcePath == null) {
                        resourcePath = toFieldName(model.to.namePlural + name)
                    }
                }
            }

            if (name == null) {
                name = from.name + to.name
            }

            if (className == null) {
                className = toCamelCase(name)
            }

            if (packageName == null) {
                packageName = from.packageName + to.packageName
            }

            if (resourcePath == null) {
                resourcePath = toFieldName(model.name) + toCamelCase(model.to.namePlural)
            }
            
            /*
             * Relationship Enumeration
             */
            
            if (relationshipEnum == null) {
                relationshipEnum = [:]
            }
            
            relationshipEnum.with {
                
                if (className == null) {
                    className = model.className + "Relationship"
                }
                
                if (fieldName == null) {
                    fieldName = "relationship"
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
