SELECT
  doctor0_.pk         AS pk3_,
  doctor0_.active     AS active3_,
  doctor0_.first_name AS first3_3_,
  doctor0_.last_name  AS last4_3_
FROM doctor doctor0_ INNER JOIN doctor_identifiers identifier1_
    ON doctor0_.pk = identifier1_.doctor
WHERE identifier1_.value = '2000' AND identifier1_.system = 'http://prehmis.capetown.gov.za'
LIMIT 1
