package org.celllife.idart.udm.partclassification;

import org.celllife.idart.udm.partclassification.atc.DefinedDailyDose;

import javax.persistence.*;
import java.util.Set;

/**
 * Anatomical Therapeutic Chemical Classification
 * <p/>
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 13h23
 */
@Entity
public final class AtcClassification extends PartClassification {

    @JoinColumn(name = "AtcClassification")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<DefinedDailyDose> definedDailyDoses;

    public AtcClassification() {
    }

    public Set<DefinedDailyDose> getDefinedDailyDoses() {
        return definedDailyDoses;
    }

    public void setDefinedDailyDoses(Set<DefinedDailyDose> definedDailyDoses) {
        this.definedDailyDoses = definedDailyDoses;
    }
}
