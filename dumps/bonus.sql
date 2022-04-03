SELECT *,(guadagno-minimo)/(massimo-minimo) as perc,
guadagnoanno*percentuale/100 as importoxbonus,
guadagnoanno*percentuale/100*((guadagno-minimo)/(massimo-minimo)) as bonus


FROM classicmodels.v2_guadagnosales g 
inner join v3_minmaxguaddagnoanno m on g.anno = m.anno
inner join bonusyear b on g.anno=b.anno

 