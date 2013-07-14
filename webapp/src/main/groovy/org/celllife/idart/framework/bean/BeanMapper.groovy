package org.celllife.idart.framework.bean

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-14
 * Time: 10h01
 */
class BeanMapper {

    static final Set<Class> primitiveWrapperTypes = []

    static {
        primitiveWrapperTypes.add(Boolean.class)
        primitiveWrapperTypes.add(Byte.class)
        primitiveWrapperTypes.add(Character.class)
        primitiveWrapperTypes.add(Double.class)
        primitiveWrapperTypes.add(Float.class)
        primitiveWrapperTypes.add(Integer.class)
        primitiveWrapperTypes.add(Long.class)
        primitiveWrapperTypes.add(Short.class)
    }

    static map(source, target) {

        switch (source) {
            case { isPrimitive(source) }:
                return handlePrimitive(source)
            case { isJavaClass(source) }:
                return handleJavaClass(source)
            case { isEnum(source) }:
                return handleEnumeration(source)
            case { isCollection(source) }:
                return handleCollection(source, target)
            default:
                return handleBean(source, target)
        }

    }

    static handleBean(source, target) {

        if (target == null) {
            target = source.metaClass.invokeConstructor()
        }

        source.properties.each { String propertyKey, sourcePropertyValue ->

            def targetPropertyBeanMeta = target.metaClass.hasProperty(target, propertyKey) as MetaBeanProperty

            if (isValidBeanProperty(targetPropertyBeanMeta)) {
                copyProperty(propertyKey, sourcePropertyValue, target)
            }

        }

        target
    }

    static isValidBeanProperty(MetaBeanProperty propertyBeanMeta) {
        propertyBeanMeta != null &&
                propertyBeanMeta.name != 'class' &&
                propertyBeanMeta.name != 'metaClass' &&
                isMutableProperty(propertyBeanMeta)
    }

    static copyProperty(propertyKey, sourcePropertyValue, target) {
        if (sourcePropertyValue != null) {
            def targetPropertyValue = map(sourcePropertyValue, target.getProperty(propertyKey))
            target.setProperty(propertyKey, targetPropertyValue)
        }
    }

    static isPrimitive(source) {
        primitiveWrapperTypes.contains(source.class) || source.class.primitive
    }

    static isEnum(source) {
        source.class.enum
    }

    static isJavaClass(source) {
        ! isCollection(source) && source.class.package.name.contains("java")
    }

    static isCollection(source) {
        (source in Collection)
    }

    static handleCollection(source, target) {

        if (target == null) {
            target = source.metaClass.invokeConstructor()
        }

        source.each { target << map(it, null) }

        target
    }


    static Object handleEnumeration(source) {
        source
    }

    static Object handleJavaClass(source) {
        source
    }

    static Object handlePrimitive(source) {
        source
    }

    static boolean isMutableProperty(MetaBeanProperty propertyBeanMeta) {
        propertyBeanMeta != null &&
                propertyBeanMeta.getter != null &&
                propertyBeanMeta.setter != null &&
                propertyBeanMeta.setter.public
    }

}
