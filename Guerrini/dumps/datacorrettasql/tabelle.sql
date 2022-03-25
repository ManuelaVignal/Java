-- prende tutto l'anno perfetto del 2022 fino al 31/12/2022 alle ore 23:59
-- where datainizio >='2022-01-01' and datainizio < '2023-01-01';
--  where (titolocorso like "%java%") or (titolocorso like "html_");
-- SELECT *, if(descrizionecorso is null, "------",upper(descrizionecorso)) as descrizione FROM DBScuola.t_corsi
-- where id_corso in(
-- SELECT id_corso FROM t_docenti where costoorario <200);

create view v_corsi_fasce as

select id_corso, 
case

when duratacorso<sogliacorto then "corto"
when duratacorso<sogliamedio then "medio"
when duratacorso<soglialungo then "lungo"
else "extra"

end as fasciacorso
from t_corsi,t_opzioni;