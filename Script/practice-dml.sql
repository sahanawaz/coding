-- GROUP THE EMPLOYEES BY DEPARTMENT
SELECT 
    d.id,
    d."name",
    d.code,
    COALESCE(
        JSONB_AGG(
            jsonb_build_object(
                'id', e.id,
                'name', e."name",
                'email', e.email,
                'code', e.code,
                'salary', e.salary
            )
            ORDER BY e.id
        ) FILTER (WHERE e.id IS NOT NULL)
    , '[]'::JSONB) employees
FROM public.employee e
INNER JOIN department d ON d.id = e.department_id
GROUP BY d.id
ORDER BY d.id

-- GROUP EMPLOYEES BY EMAIL DOMAIN
SELECT 
    split_part(LOWER(e.email), '@', 2) domain,
    jsonb_agg(
        jsonb_build_object(
            'id', e.id,
            'name', e."name",
            'email', e.email,
            'salary', e.salary
        )
    ) employees
FROM employee e
WHERE position('@' IN e.email) > 1
GROUP BY "domain"
ORDER BY "domain"
