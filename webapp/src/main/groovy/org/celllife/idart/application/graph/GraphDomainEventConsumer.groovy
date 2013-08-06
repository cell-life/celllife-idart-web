package org.celllife.idart.application.graph
/**
 * User: Kevin W. Sewell
 * Date: 2013-08-05
 * Time: 19h39
 */
public interface GraphDomainEventConsumer {

    void systemSaved(String message)

    void userSaved(String message)

    void userSystemSaved(String message)
}