package org.celllife.idart.application.part.dto

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 17h47
 */
class CompoundDto extends PartDto {

    @Override
    public String toString() {
        return "CompoundDto [identifiers=" + identifiers + ", label=" + label + ", quantity=" + quantity + ", form=" + form
                + ", classifications=" + classifications + "]";
    }
}
