package org.celllife.idart.domain.counter;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-26
 * Time: 15h59
 */
public interface CounterRepository {

    Counter findOneByName(String name);

}
