---question 1--
CREATE or replace FUNCTION v_tva (montant float) RETURNS float AS $$
DECLARE
val_tva float;
taux_tva float := 0.196 ;
BEGIN
val_tva = montant * 0.196;

RETURN val_tva;
END

$$ LANGUAGE 'plpgsql'


select v_tva (pro_prix)  --pour exécuter la fonction v_tva--
from produit


--question2--
 create or replace function month_sse() 
	returns table (
		ncmd character varying (6),
        month_cmd double precision,
		cmd_date  date	) 
	language plpgsql
as $$
begin
	return query 
		select commande.ncmd, 
        extract (month from (commande.cmd_date)) as montha_cmd,
        commande.cmd_date 
        from commande where 
 extract (month from (commande.cmd_date))=  extract (month from (current_date));
		
END
$$;

select * from month_sse () --pour executer la fonction month_sse

--question 3---
create or replace function sse_ville (ville1 character varying) returns text
language plpgsql 
as  $$

declare
ville2 text;

begin 

	select vil_nom into ville2 from ville  where vil_nom = ville1 ;
	
    IF NOT FOUND THEN  RAISE NOTICE 'not found';
    end if;
    return  ville2;
