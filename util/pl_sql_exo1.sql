Question1---
do $$ 
<<first_block>>
declare

begin
   raise notice 'hello world'; 
end  $$;


Question2--
do $$ 
declare
lib_salim varchar (20);
begin
select pro_libelle into lib_salim from produit where nprod = 'P99016';
   raise notice 'NOTICE: Libelle du produit %' , lib_salim; 
end  $$;

Question3--

do $$ 
declare
lib_salim varchar (20);
begin
select pro_libelle into lib_salim from produit where nprod = 'P99016';
if lib_salim = 'WIDGET ADJUSTER' 
    then raise notice 'Le produit WIDGET ADJUSTER est présent';
           else
           raise notice 'Le produit WIDGET ADJUSTER nest pas présent';
end if;
end $$;

Question4--