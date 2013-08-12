package org.celllife.idart.application.graph
/**
 * User: Kevin W. Sewell
 * Date: 2013-08-05
 * Time: 19h39
 */
public interface GraphDomainEventConsumer {

    void systemEvent(String message)

    void userEvent(String message)

    void userSystemEvent(String message)
}