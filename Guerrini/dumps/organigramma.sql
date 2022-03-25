create  view v_organigramma as 
SELECT e.lastName,e.firstName,e.employeeNumber,e.jobTitle
,c.lastName as chief1,c.jobTitle as job1
,c2.lastName as chief2,c2.jobTitle as job2
,c3.lastName as chief3,c3.jobTitle as job3

FROM 
  employees e
 
 left join employees c on e.reportsTo=c.employeeNumber
 left join employees c2 on c.reportsTo=c2.employeeNumber
 left join employees c3  on c2.reportsTo=c3.employeeNumber 

order by job1,job2,job3,e.lastName,e.firstName;