package org.celllife.idart.domain.routeofadministration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
@Service("routeOfAdministrationService")
public final class RouteOfAdministrationServiceImpl implements RouteOfAdministrationService {

    @Autowired
    private RouteOfAdministrationRespository routeOfAdministrationRespository;

    public void save(Iterable<RouteOfAdministration> routeOfAdministrations) {
        for (RouteOfAdministration routeOfAdministration : routeOfAdministrations) {
            save(routeOfAdministration);
        }
    }

    public void save(RouteOfAdministration routeOfAdministration) {

        String system = routeOfAdministration.getFirstSystem();
        String code = routeOfAdministration.getCodeValue(system);

        RouteOfAdministration savedRouteOfAdministration =
                routeOfAdministrationRespository.findOneBySystemAndCode(system, code);

        if (savedRouteOfAdministration != null) {
            savedRouteOfAdministration.mergeCodes(routeOfAdministration);
            routeOfAdministrationRespository.save(savedRouteOfAdministration);
        } else {
            routeOfAdministrationRespository.save(routeOfAdministration);
        }
    }
}
