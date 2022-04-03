    SELECT 
        `p`.`productLine` AS `productline`,
        `p`.`productCode` AS `productCode`,
        AVG(`o`.`priceEach`) AS `avg(priceEach)`,
        `p`.`buyPrice` AS `buyPrice`,
        AVG(`o`.`priceEach`) / `p`.`buyPrice` AS `margine`,
        SUM(`o`.`quantityOrdered`) AS `numsold`,
        ROUND((AVG(`o`.`priceEach`) - `p`.`buyPrice`) * SUM(`o`.`quantityOrdered`),
                0) AS `guadagno`
    FROM
        (`products` `p`
        LEFT JOIN `orderdetails` `o` ON (`p`.`productCode` = `o`.`productCode`))
    GROUP BY `p`.`productCode`
    ORDER BY AVG(`o`.`priceEach`) / `p`.`buyPrice` DESC