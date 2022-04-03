create view v_andamento_corsi as
SELECT c.id_corso,titolocorso, sum(costoorario*oredocenza) as costodocenza, sum(oredocenza) as totoredocenza
,sum(oredocenza) as totaleoredocenza
,count(*)as numdocenti
,duratacorso-sum(oredocenza) as oremancanti
,costocorso,sum(costoorario*oredocenza)/costocorso as numiscrittiminimo
FROM t_corsi c inner join t_docenti d 
on c.id_corso=d.id_corso
group by id_corso
;