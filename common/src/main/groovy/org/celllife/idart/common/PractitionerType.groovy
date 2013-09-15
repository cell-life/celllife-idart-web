package org.celllife.idart.common

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-04
 * Time: 13h02
 */
public enum PractitionerType {

    ADMINISTRATION_ASISTANT("Administration Asistant"),
    AGENCY_DOCTORS("Agency Doctors"),
    AGENCY_NURSES("Agency Nurses"),
    AGENCY_PHARMACIST("Agency Pharmacist"),
    AGENCY_STUDENT_NURSES("Agency Student Nurses"),
    CHIEF_PROFESSIONAL_NURSE("Chief Professional Nurse"),
    CLINICAL_MEDICAL_OFFICER("Clinical Medical Officer"),
    CLINICAL_NURSE_PRACTITIONER("Clinical Nurse Practitioner"),
    CLINICAL_NURSING_ASSISTANT("Clinical Nursing Assistant"),
    CLINIC_ASSISTANT("Clinic Assistant"),
    CLINIC_MANAGER("Clinic Manager"),
    COMMUNITY_IMCI_MA_AFRIKA_TIKKUN("Community IMCI,Ma-AfrikaTikkun"),
    COMMUNITY_SERVICE_PSYCHIATRIST("Community Service Psychiatrist"),
    COUNSELLOR("Counsellor"),
    DENTIST("Dentist"),
    DIAGNOSTIC_RADIOGRAPHER("Diagnostic Radiographer"),
    DIETICIAN("Dietician"),
    ENROLLED_NURSE("Enrolled Nurse"),
    ENROLLED_NURSING_ASSISTANT("Enrolled Nursing Assistant"),
    HIV_TB_COUNSELOR("HIV/TB Counselor"),
    MEDICAL_OFFICER("Medical Officer"),
    MIDWIFE("Midwife"),
    NGO("NGO"),
    NUTRITIONIST("Nutritionist"),
    OCCUPATIONAL__THERAPIST("Occupational  Therapist"),
    ORTHOPEADIC("Orthopeadic"),
    PHARMACIST_ASSISTANT("Pharmacist Assistant"),
    PHARMACIST("Pharmacist"),
    POST_BASIC_PHARMACIST_ASSISTANT_PBPA("Post Basic Pharmacist Assistant (PBPA)"),
    PROFESSIONAL_NURSE("Professional Nurse"),
    PSYCHOLOGIST("Psychologist"),
    RECEPTIONIST_DARKROOM_ASST("Receptionist/ Darkroom Asst"),
    SENIOR_CLINIC_ASSISTANT("Senior Clinic Assistant"),
    SENIOR_ENROLLED_NURSE("Senior Enrolled Nurse"),
    SENIOR_ENROLLED_NURSING_ASSIST("Senior Enrolled Nursing Assist"),
    SENIOR_NURSING_ASSISTANT("Senior Nursing Assistant"),
    SENIOR_PROFESSIONAL_NURSE("Senior Professional Nurse"),
    SENIOR_STAFF_NURSE("Senior Staff Nurse"),
    SENIOR_THERAPIST("Senior Therapist"),
    SOCIAL_WORKER("Social Worker"),
    STAFF_NURSE("Staff Nurse"),
    STUDENT_NURSE("Student Nurse"),
    SUBSTANCE_ABUSE_SCREENING_CLERK("Substance Abuse Screening Clerk"),
    SUPP_DIAGNOSTIC_RADIOGRAPHER("Supp Diagnostic Radiographer"),
    THERAPIST_SUPERVISOR("Therapist Supervisor"),
    THERAPIST("Therapist"),
    TREATMENT_SUPPORTER_TB_CARE("Treatment Supporter - TB Care"),
    UNASSIGNED("Unassigned"),
    UNKNOWN("Unknown");

    final String description

    PractitionerType(String description) {
        this.description = description
    }

    String getDescription() {
        return description
    }

}