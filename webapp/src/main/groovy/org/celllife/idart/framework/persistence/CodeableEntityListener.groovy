package org.celllife.idart.framework.persistence

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 14h52
 */
class CodeableEntityListener {

    public void setPk(Object object) {

        if (object.pk == null) {
            object.pk = object.defaultCodeValue
        }

        if (object.pk == null) {
            object.pk = object.idartCodeValue
        }
    }
}
