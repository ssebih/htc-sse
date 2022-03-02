--Question 1
select detail.ncmd, cli_societe, pro_libelle,sum(pro_prix*qtite) as prix_commande 
from client
inner join commande on client.ncli = commande.ncli
inner join detail on commande.ncmd = detail.ncmd
inner join produit on produit.nprod = detail.nprod
group by detail.ncmd, cli_societe,produit.pro_libelle


--Question 2 
select rep_nom, bureau.nbur, bur_adresse, vil_nom
from representant
inner join bureau on representant.nbur= bureau.nbur 
inner join ville on bureau.cp = ville.cp


--Question 3
select bureau.nbur, sum(pro_prix*qtite) as CA_bureau
from bureau
inner join representant on bureau.nbur = representant.nbur
inner join  origine on representant.nrep = origine.nrep
inner join  detail on origine.ncmd = detail.ncmd
inner join produit on detail.nprod= detail.nprod
group by bureau.nbur

--Question 4
select detail.ncmd, representant.rep_nom, vil_nom, sum(pro_prix*qtite) as montant
from ville
inner join bureau on bureau.cp = ville.cp
inner join representant on bureau.nbur = representant.nbur
inner join origine on representant.nrep = origine.nrep 
inner join detail on detail.ncmd= origine.ncmd
inner join produit on detail.nprod= produit.nprod
group by representant.rep_nom, detail.ncmd, vil_nom

--Question 5
select distinct  bur_adresse, vil_nom, rep_nom, cli_societe 
from ville
inner join bureau on bureau.cp = ville.cp 
inner join representant on bureau.nbur = representant.nbur
inner join origine on representant.nrep = origine.nrep
inner join commande on origine.ncmd = commande.ncmd
inner join client on commande.ncli = client.ncli
where cli_societe = 'ACE INTERNATIONAL.' 

--question 6 
select cli_societe, pro_libelle
from client
inner join commande on client.ncli = client.ncli
inner join detail on detail.ncmd = commande.ncmd
inner join produit on detail.nprod= produit.nprod
group by cli_societe, pro_libelle
order by cli_societe

--Question 7
select   commande.ncmd, pro_libelle, pro_prix*qtite montant, 
cli_societe, vil_nom 
from ville
inner join bureau on bureau.cp = ville.cp 
inner join representant on bureau.nbur = representant.nbur
inner join origine on representant.nrep = origine.nrep
inner join commande on origine.ncmd = commande.ncmd
inner join client on commande.ncli = client.ncli
inner join detail on commande.ncmd = detail.ncmd
inner join produit on detail.nprod= produit.nprod

Question8---
select rep_nom ||' '|| rep_prenom As Représentant, che_nom ||' '|| che_prenom as chef
from chef
inner join representant on chef.nchef = representant.nchef

Question9---
select client.cli_societe, che_nom ||' '||che_prenom as chef, vil_nom
	from ville 
		inner join bureau 
		on ville.cp = bureau.cp
		inner join representant
		on bureau.nbur = representant.nbur
		inner join chef 
		on representant.nchef = chef.nchef 
		inner join origine
		on representant.nrep = origine.nrep
		inner join commande
		on origine.ncmd = commande.ncmd
		inner join client
		on commande.ncli = client.ncli
where vil_nom = 'NEW YORK'

Question11---
select distinct rep_nom ||' '|| rep_prenom as nom_du_epesentant 
	from representant 
		inner join origine on representant.nrep = origine.nrep
		inner join commande on origine.ncmd = commande.ncmd
		inner join client on commande.ncli = client.ncli
	where cli_societe like 'FIRST CORP%'
	
Question12
	SELECT   COUNT(*) AS nbr_doublon, pro_libelle    --(le lien : https://sql.sh/55-requete-trouver-doublon)--
FROM     detail
inner join  produit on detail.nprod = produit.nprod
GROUP BY pro_libelle
HAVING   COUNT(*) > 1