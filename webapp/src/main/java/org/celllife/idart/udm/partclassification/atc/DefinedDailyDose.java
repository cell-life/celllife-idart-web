package org.celllife.idart.udm.partclassification.atc;

import org.celllife.idart.udm.common.Quantity;
import org.celllife.idart.udm.common.BaseEntity;
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration;

import javax.persistence.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h23
 */
@Entity
public final class DefinedDailyDose extends BaseEntity {

    @AttributeOverride(name = "value", column = @Column(name = "quantity"))
    @AssociationOverride(name = "unitOfMeasure", joinColumns = @JoinColumn(name = "quantityUom"))
    private Quantity quantity;

    @ManyToOne
    private RouteOfAdministration routeOfAdministration;

    public DefinedDailyDose() {
    }

    public DefinedDailyDose(Quantity quantity, RouteOfAdministration routeOfAdministration) {
        this.quantity = quantity;
        this.routeOfAdministration = routeOfAdministration;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public RouteOfAdministration getRouteOfAdministration() {
        return routeOfAdministration;
    }

    public void setRouteOfAdministration(RouteOfAdministration routeOfAdministration) {
        this.routeOfAdministration = routeOfAdministration;
    }
}
