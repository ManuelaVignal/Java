
set @idp = 1;
set @bestid = (SELECT id_offer FROM ebay.t_offerta where
id_product = @idp order by offerta desc limit 1);
set @maxprice = (select offerta from t_offerta
where id_product=@idp and id_offerta != @bestid
order by offerta desc limit 1);