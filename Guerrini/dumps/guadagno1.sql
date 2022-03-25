select productline,sum(guadagno) as guadagno, sum(numsold) as totpezzi
FROM v1_sintesi_prodotti 
group by productline
order by guadagno desc;