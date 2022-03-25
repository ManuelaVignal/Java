-- prende tutto l'anno perfetto del 2022 fino al 31/12/2022 alle ore 23:59
-- where datainizio >='2022-01-01' and datainizio < '2023-01-01';

SELECT * FROM DBScuola.t_corsi
where (titolocorso like "%java%") or (titolocorso like "html_");
