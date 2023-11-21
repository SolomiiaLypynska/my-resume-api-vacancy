MERGE INTO VACANCY v
USING (
    SELECT 1 as VACANCY_ID, 3 as EMPLOYER_ID, 'Apple' as COMPANY_NAME, 'Java Developer' as POSITION_TITLE, 'Java, Spring' as REQUIREMENTS,
        null as DESCRIPTION, 1 as ACTIVE, TO_DATE('2023-08-13 10:12:09', 'YYYY-MM-DD HH:mm:ss') as CREATED_ON,
        TO_DATE('2023-08-15 10:12:09', 'YYYY-MM-DD HH:mm:ss') as UPDATED_ON, 'full' as EMPLOYMENT_TYPE,
        700 as SALARY, 'Middle' POSITION_LEVEL, 1.5 as WORK_EXPERIENCE, 'PRODUCT' as COMPANY_TYPE, 'PRE-INTERMEDIATE' as ENGLISH_LEVEL FROM dual
        UNION ALL
    SELECT 2 as VACANCY_ID, 3 as EMPLOYER_ID, 'Apple' as COMPANY_NAME, 'JS Developer' as POSITION_TITLE, 'JS, HTML, CSS' as REQUIREMENTS,
        null as DESCRIPTION, 0 as ACTIVE, TO_DATE('2023-08-23 10:12:09', 'YYYY-MM-DD HH:mm:ss') as CREATED_ON,
        TO_DATE('2023-08-15 10:12:09', 'YYYY-MM-DD HH:mm:ss') as UPDATED_ON, 'full' as EMPLOYMENT_TYPE,
        700 as SALARY, 'Middle' POSITION_LEVEL, 2 as WORK_EXPERIENCE, 'OUTSOURCE' as COMPANY_TYPE, 'PRE-INTERMEDIATE' as ENGLISH_LEVEL FROM dual
        UNION ALL
    SELECT 3 as VACANCY_ID, 2 as EMPLOYER_ID, 'Google' as COMPANY_NAME, 'Java Developer' as POSITION_TITLE, 'Java, Spring, SQL' as REQUIREMENTS,
        null as DESCRIPTION, 1 as ACTIVE, TO_DATE('2023-06-10 10:12:09', 'YYYY-MM-DD HH:mm:ss') as CREATED_ON,
        TO_DATE('2023-08-15 10:12:09 10:12:09', 'YYYY-MM-DD HH:mm:ss') as UPDATED_ON, 'full' as EMPLOYMENT_TYPE,
        700 as SALARY, 'Middle' POSITION_LEVEL, 3 as WORK_EXPERIENCE, 'OUTSOURCE' as COMPANY_TYPE, 'INTERMEDIATE' as ENGLISH_LEVEL FROM dual
        UNION ALL
    SELECT 4 as VACANCY_ID, 3 as EMPLOYER_ID, 'Apple' as COMPANY_NAME, 'React Developer' as POSITION_TITLE, 'React.js, JS' as REQUIREMENTS,
        null as DESCRIPTION, 1 as ACTIVE, TO_DATE('2023-07-09 10:12:09', 'YYYY-MM-DD HH:mm:ss') as CREATED_ON,
        TO_DATE('2023-08-15 10:12:09', 'YYYY-MM-DD HH:mm:ss') as UPDATED_ON, 'full' as EMPLOYMENT_TYPE,
        700 as SALARY, 'Middle' POSITION_LEVEL, 1.5 as WORK_EXPERIENCE, 'OUTSTAFF' as COMPANY_TYPE, 'BEGINNER/ELEMENTARY' as ENGLISH_LEVEL FROM dual
        UNION ALL
    SELECT 5 as VACANCY_ID, 3 as EMPLOYER_ID, 'Apple' as COMPANY_NAME, 'Devops' as POSITION_TITLE, 'Docker' as REQUIREMENTS,
        null as DESCRIPTION, 1 as ACTIVE, TO_DATE('2023-09-24 10:12:09', 'YYYY-MM-DD HH:mm:ss') as CREATED_ON,
        TO_DATE('2023-08-15 10:12:09', 'YYYY-MM-DD HH:mm:ss') as UPDATED_ON, 'full' as EMPLOYMENT_TYPE,
        700 as SALARY, 'Middle' POSITION_LEVEL, 4 as WORK_EXPERIENCE, 'OUTSTAFF' as COMPANY_TYPE, 'ADVANCED/FLUENT' as ENGLISH_LEVEL FROM dual
        UNION ALL
    SELECT 6 as VACANCY_ID, 2 as EMPLOYER_ID, 'Google' as COMPANY_NAME, 'Devops' as POSITION_TITLE, 'Docker' as REQUIREMENTS,
        null as DESCRIPTION, 1 as ACTIVE, TO_DATE('2023-10-18 10:12:09', 'YYYY-MM-DD HH:mm:ss') as CREATED_ON,
        TO_DATE('2023-08-15 10:12:09', 'YYYY-MM-DD HH:mm:ss') as UPDATED_ON, 'full' as EMPLOYMENT_TYPE,
        700 as SALARY, 'Middle' POSITION_LEVEL, 2 as WORK_EXPERIENCE, 'OUTSOURCE' as COMPANY_TYPE, 'UPPER-INTERMEDIATE' as ENGLISH_LEVEL FROM dual
) res
ON (v.VACANCY_ID = res.VACANCY_ID)
WHEN NOT MATCHED THEN
    INSERT (VACANCY_ID, EMPLOYER_ID, COMPANY_NAME, POSITION_TITLE, REQUIREMENTS, DESCRIPTION, ACTIVE, CREATED_ON, UPDATED_ON,
    EMPLOYMENT_TYPE, SALARY, POSITION_LEVEL, WORK_EXPERIENCE, COMPANY_TYPE, ENGLISH_LEVEL)
    VALUES (res.VACANCY_ID, res.EMPLOYER_ID, res.COMPANY_NAME, res.POSITION_TITLE, res.REQUIREMENTS, res.DESCRIPTION, res.ACTIVE,
        res.CREATED_ON, res.UPDATED_ON, res.EMPLOYMENT_TYPE, res.SALARY, res.POSITION_LEVEL, res.WORK_EXPERIENCE, res.COMPANY_TYPE,
        res.ENGLISH_LEVEL);