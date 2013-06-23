package org.celllife.idart.domain.common;

import org.celllife.idart.domain.concept.Code;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 23h20
 */
public interface Codeable {

    Set<Code> getCodes();

    void setCodes(Set<Code> codes);

    void addCode(String system, String code);

    String getFirstSystem();

    String getCodeValue(String system);

    Set<String> getCodeSystems();

}
