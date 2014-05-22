package org.celllife.idart.domain.part

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 18h40
 */
class Compound extends Part {

    @Override
    public String toString() {
        return "Compound [id=" + id + ", label=" + label + ", quantity=" + quantity + ", form=" + form
        + ", classifications=" + classifications + "]";
    }

}
