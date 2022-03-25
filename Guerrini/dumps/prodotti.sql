create view v1_elencoimpiegati as
SELECT e.jobTitle,territory,country,city,e.jobTitle,firstName,employeeNumber,o.officecode

-- da quali tabelle agganciate

FROM offices o
inner join employees e 
on o.officeCode = e.officeCode
inner join gerarchia g on left(e.jobTitle,8)=left(g.jobtitle,8)
-- filtri vari con WHERE
-- eventuali raggruppamenti 
-- GROUP BY
-- eventuali filtri su campi raggruppati con HAVING che avviene dopo il GROUP BY
-- qui posso fare ORDER BY
ORDER BY jobTitle,territory,country,city,lastName,firstName;
-- eventuali limit 100