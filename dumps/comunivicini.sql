-- create table comunivicini as
select g1.comune as c1,g2.comune as c2,g1.istat as i1,g2.istat as i2, distanzakm(g1.lat, g1.lng, g2.lat, g2.lng) as dist 
from database_comuni.italy_geo g1, database_comuni.italy_geo g2
where g1.istat < 1050 and g2.istat < 1050 and g1.istat < g2.istat 
and distanzakm(g1.lat,g1.lng,g2.lat,g2.lng) < 20;