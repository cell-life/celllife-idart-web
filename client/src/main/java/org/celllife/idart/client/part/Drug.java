package org.celllife.idart.client.part;

import java.util.HashSet;
import java.util.Set;

/**
 * Drugs are one Part of the Medication given to a Patient. It is a medicine that can be given in many forms 
 * (e.g. Syrup or Capsules).
 */
public class Drug extends Part {

    private static final long serialVersionUID = 868835687772404489L;

    /**
     * Describes the contents/chemical makeup of the drug
     */
    public Set<PartBillOfMaterialsItem> billOfMaterials = new HashSet<PartBillOfMaterialsItem>();
    
    public Drug() {
        
    }
}