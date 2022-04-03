SELECT productLine,round(sum(quantityInStock*buyPrice)/1000) as giacenzak FROM products 
group by productLine