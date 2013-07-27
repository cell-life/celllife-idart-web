package org.celllife.idart.codegen
/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class RelationshipModelEnricher {

    static enrichRelationshipModel(basePackageName, model) {

        model.with {

            entities.each { entity ->
                entity.with {
                    if (className == null) {
                        className = toCamelCase(name)
                        className = className.subSequence(0, 1).toUpperCase() + className.substring(1)
                    }

                    if (classNamePlural == null) {
                        if (plural == null) {
                            classNamePlural = className + "s"
                        } else {
                            classNamePlural = toCamelCase(plural)
                            classNamePlural = classNamePlural.subSequence(0, 1).toUpperCase() + classNamePlural.substring(1)
                        }
                    }

                    if (propertyName == null) {
                        propertyName = className.subSequence(0, 1).toLowerCase() + className.substring(1)
                    }

                    if (propertyNamePlural == null) {
                        if (plural == null) {
                            propertyNamePlural = propertyName + "s"
                        } else {
                            propertyNamePlural = toCamelCase(plural)
                            propertyNamePlural = propertyNamePlural.subSequence(0, 1).toLowerCase() + propertyNamePlural.substring(1)
                        }
                    }

                    if (packageName == null) {
                        packageName = className.toLowerCase()
                    }
                    domainPackageName = basePackageName + ".domain." + packageName
                    applicationPackageName = basePackageName + ".application." + packageName
                }
            }

            className = entities[0].className + entities[1].className

            if (propertyName == null) {
                propertyName = className.subSequence(0, 1).toLowerCase() + className.substring(1)
            }

            if (packageName == null) {
                packageName = className.toLowerCase()
            }

            domainPackageName = basePackageName + ".domain." + packageName
            applicationPackageName = basePackageName + ".application." + packageName
            springDataPackageName = basePackageName + ".infrastructure.springdata." + packageName
        }
    }

    static String toCamelCase(text) {
        text.replaceAll("( )([A-Za-z0-9])", { Object[] it -> it[2].toUpperCase() })
    }
}
