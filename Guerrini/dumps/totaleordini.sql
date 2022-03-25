
v1_totaliordiniv1_totaliordiniSELECT 
c.customerName,c.country,c.salesRepEmployeeNumber
, o.orderNumber,orderDate,o.customerNumber

,sum(priceEach*quantityOrdered) as totordine

FROM orderdetails od
inner join orders  o on od.orderNumber=o.orderNumber
inner join customers c on c.customerNumber=o.customerNumber
group by c.customerName,o.orderNumber;


