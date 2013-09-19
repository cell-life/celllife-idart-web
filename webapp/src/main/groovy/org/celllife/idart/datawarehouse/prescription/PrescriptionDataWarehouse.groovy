package org.celllife.idart.datawarehouse.prescription

import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.common.PrescriptionId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

import java.sql.ResultSet
import java.sql.SQLException

import static org.celllife.idart.common.PrescriptionId.prescriptionId

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-15
 * Time: 17h03
 */
@Component class PrescriptionDataWarehouse {

    static final RowMapper<PrescriptionId> PRESCRIPTION_ID_ROW_MAPPER = new RowMapper<PrescriptionId>() {
        @Override
        PrescriptionId mapRow(ResultSet rs, int rowNum) throws SQLException {
            prescriptionId(rs.getString(1))
        }
    }

    @Autowired NamedParameterJdbcTemplate namedParameterJdbcTemplate

    PrescriptionId findByPrescribedMedication(final PrescribedMedicationId prescribedMedication) {

        String query = "SELECT " +
                "  prescription.id " +
                "FROM prescription prescription, " +
                "  prescription_prescribed_medications prescribed_medication " +
                "WHERE prescription.id = prescribed_medication.prescription " +
                "      AND prescribed_medication.prescribed_medication = :prescribedMedication"

        def parameters = [prescribedMedication: prescribedMedication.value]

        def prescriptions = namedParameterJdbcTemplate.query(query, parameters, PRESCRIPTION_ID_ROW_MAPPER)

        if (prescriptions.size() == 0) {
            return null
        }

        return prescriptions[0]
    }
}
