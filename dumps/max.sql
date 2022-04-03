SELECT * FROM DBsquadre.v_squadra_giocatore
where punti= (select max(punti) from t_squadre);