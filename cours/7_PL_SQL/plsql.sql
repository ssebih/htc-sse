EXERCICE1--
Question1-
do $$ 

declare
  
begin
   
   raise notice 'hello world';
end  $$;

QUESTION2-- ça affiche le nom du produit quand N° produit = 'P99016'
do $$ 
declare
  lib_salim varchar (20);
begin
    select pro_libelle into lib_salim from produit where nprod = 'P99016';
   raise notice 'le produit est %', lib_salim;
end  $$;



question3-- CA AFFICHE BON PRODUIT : ou mauvais produit quand le produit n'est pas widjet adjuster
do $$ 
declare
  lib_salim varchar (20);
begin
    select pro_libelle into lib_salim from produit where nprod = 'P99016';
		IF lib_salim = 'WIDGET ADJUSTER' 
           then raise notice 'le produit est bon ';
	       else raise notice 'le produit est mauvais';
	     end if;
end  $$;

