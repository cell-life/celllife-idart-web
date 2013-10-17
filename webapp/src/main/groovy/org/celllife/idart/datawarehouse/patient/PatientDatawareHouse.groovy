package org.celllife.idart.datawarehouse.patient

import org.celllife.idart.common.Systems
import org.celllife.idart.common.OrganisationId
import org.celllife.idart.common.PatientId
import org.celllife.idart.relationship.patientorganisation.PatientOrganisation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

import java.sql.ResultSet
import java.sql.SQLException

import static org.celllife.idart.common.PatientId.patientId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 17h03
 */
@Component class PatientDataWarehouse {

    static final RowMapper<PatientId> PATIENT_ID_ROW_MAPPER = new RowMapper<PatientId>() {
        @Override
        PatientId mapRow(ResultSet rs, int rowNum) throws SQLException {
            patientId(rs.getString(1))
        }
    }

    @Autowired NamedParameterJdbcTemplate namedParameterJdbcTemplate

    List<PatientId> findByIdentifierAndOrganisation(final String patientIdentifier,
                                                    final PatientOrganisation.Relationship relationship,
                                                    final OrganisationId organisation) {

        String query = "SELECT " +
                "  patient.id " +
                "FROM patient patient, " +
                "  identifiable_identifiers patient_idart_id, " +
                "  identifiable_identifiers patient_external_id, " +
                "  identifiable_identifiers person_idart_id, " +
                "  identifiable_identifiers person_external_id, " +
                "  patient_organisation patient_organisation, " +
                "  organisation organisation " +
                "WHERE patient.id = patient_idart_id.value " +
                "      AND patient_external_id.identifiable = patient_idart_id.identifiable " +
                "      AND person_external_id.identifiable = person_idart_id.identifiable " +
                "      AND patient_organisation.patient = patient.id " +
                "      AND patient_idart_id.system = :idartSystem " +
                "      AND lower(patient_external_id.value) like :patientIdentifier  " +
                "      AND person_idart_id.system = :idartSystem " +
                "      AND lower(person_external_id.value) like :patientIdentifier  " +
                "      AND patient_organisation.organisation = :organisation" +
                "      AND patient_organisation.relationship = :relationship"

        def parameters = [
                patientIdentifier: patientIdentifier,
                organisation: organisation.value,
                relationship: relationship.toString(),
                idartSystem: Systems.IDART_WEB.id.value
        ]

        namedParameterJdbcTemplate.query(query, parameters, PATIENT_ID_ROW_MAPPER)
    }
}
