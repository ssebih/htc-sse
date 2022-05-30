------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------



------------------------------------------------------------
-- Table: BUREAU
------------------------------------------------------------
CREATE TABLE public.BUREAU(
	nbur        VARCHAR (5) NOT NULL ,
	bur_adresse VARCHAR (255)  ,
	cp          VARCHAR (5)  ,
	CONSTRAINT prk_constraint_BUREAU PRIMARY KEY (nbur)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: VILLE
------------------------------------------------------------
CREATE TABLE public.VILLE(
	cp      VARCHAR (5) NOT NULL ,
	vil_nom VARCHAR (25)  ,
	npays   VARCHAR (3)  ,
	CONSTRAINT prk_constraint_VILLE PRIMARY KEY (cp)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: REPRESENTANT
------------------------------------------------------------
CREATE TABLE public.REPRESENTANT(
	nrep       VARCHAR (4) NOT NULL ,
	rep_nom    VARCHAR (25)  ,
	rep_prenom VARCHAR (25)  ,
	nbur       VARCHAR (5)  ,
	nchef      VARCHAR (4)  ,
	CONSTRAINT prk_constraint_REPRESENTANT PRIMARY KEY (nrep)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: CHEF
------------------------------------------------------------
CREATE TABLE public.CHEF(
	nchef      VARCHAR (4) NOT NULL ,
	che_nom    VARCHAR (25)  ,
	che_prenom VARCHAR (25)  ,
	CONSTRAINT prk_constraint_CHEF PRIMARY KEY (nchef)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: COMMANDE
------------------------------------------------------------
CREATE TABLE public.COMMANDE(
	ncmd     VARCHAR (6) NOT NULL ,
	cmd_date DATE  NOT NULL ,
	ncli     VARCHAR (4)  ,
	CONSTRAINT prk_constraint_COMMANDE PRIMARY KEY (ncmd)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: CLIENT
------------------------------------------------------------
CREATE TABLE public.CLIENT(
	ncli        VARCHAR (4) NOT NULL ,
	cli_societe VARCHAR (25)  ,
	CONSTRAINT prk_constraint_CLIENT PRIMARY KEY (ncli)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: PRODUIT
------------------------------------------------------------
CREATE TABLE public.PRODUIT(
	nprod       VARCHAR (6) NOT NULL ,
	pro_libelle VARCHAR (25)  ,
	pro_prix    NUMERIC (25,0)   ,
	CONSTRAINT prk_constraint_PRODUIT PRIMARY KEY (nprod)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: PAYS
------------------------------------------------------------
CREATE TABLE public.PAYS(
	npays   VARCHAR (3) NOT NULL ,
	pay_nom VARCHAR (25)  ,
	CONSTRAINT prk_constraint_PAYS PRIMARY KEY (npays)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: DETAIL
------------------------------------------------------------
CREATE TABLE public.DETAIL(
	qtite INT   ,
	ncmd  VARCHAR (6) NOT NULL ,
	nprod VARCHAR (6) NOT NULL ,
	CONSTRAINT prk_constraint_DETAIL PRIMARY KEY (ncmd,nprod)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: ORIGINE
------------------------------------------------------------
CREATE TABLE public.ORIGINE(
	nrep VARCHAR (4) NOT NULL ,
	ncmd VARCHAR (6) NOT NULL ,
	CONSTRAINT prk_constraint_ORIGINE PRIMARY KEY (nrep,ncmd)
)WITHOUT OIDS;


CREATE INDEX COMMANDE_cmd_date_idx ON COMMANDE (cmd_date);

ALTER TABLE public.BUREAU ADD CONSTRAINT FK_BUREAU_cp FOREIGN KEY (cp) REFERENCES public.VILLE(cp);
ALTER TABLE public.VILLE ADD CONSTRAINT FK_VILLE_npays FOREIGN KEY (npays) REFERENCES public.PAYS(npays);
ALTER TABLE public.REPRESENTANT ADD CONSTRAINT FK_REPRESENTANT_nbur FOREIGN KEY (nbur) REFERENCES public.BUREAU(nbur);
ALTER TABLE public.REPRESENTANT ADD CONSTRAINT FK_REPRESENTANT_nchef FOREIGN KEY (nchef) REFERENCES public.CHEF(nchef);
ALTER TABLE public.COMMANDE ADD CONSTRAINT FK_COMMANDE_ncli FOREIGN KEY (ncli) REFERENCES public.CLIENT(ncli);
ALTER TABLE public.DETAIL ADD CONSTRAINT FK_DETAIL_ncmd FOREIGN KEY (ncmd) REFERENCES public.COMMANDE(ncmd);
ALTER TABLE public.DETAIL ADD CONSTRAINT FK_DETAIL_nprod FOREIGN KEY (nprod) REFERENCES public.PRODUIT(nprod);
ALTER TABLE public.ORIGINE ADD CONSTRAINT FK_ORIGINE_nrep FOREIGN KEY (nrep) REFERENCES public.REPRESENTANT(nrep);
ALTER TABLE public.ORIGINE ADD CONSTRAINT FK_ORIGINE_ncmd FOREIGN KEY (ncmd) REFERENCES public.COMMANDE(ncmd);











------------------------------------------------------------
-- insertion des données
------------------------------------------------------------


insert into produit values('P99012','LEFT HINGE',1458.00);
insert into produit values('P99013','HINGE PIN',1480.00);
insert into produit values('P99014','RIGHT HINGE',150.00);
insert into produit values('P99015','SIZE 4 WIDGET',2100.00);
insert into produit values('P99016','WIDGET ADJUSTER',600.00);
insert into produit values('P99017','WIDGET INSTALLER',22500.00);
insert into produit values('P99018','WIDGET REMOVER',702.00);

insert into client values('0001','ACE INTERNATIONAL.');
insert into client values('0002','ACME MFG.');
insert into client values('0003','CHEN ASSOCIATES');
insert into client values('0004','FIRST CORP.');
insert into client values('0005','J.P. SINCLAIR.');
insert into client values('0006','JCP INC.');
insert into client values('0007','ZETACORP.');

insert into chef values('C001','BOB','SMITHS ');
insert into chef values('C002','DAN','ROBERTS');
insert into chef values('C003','SAM','CLARK');
insert into chef values('C004','SUE','SMITH');

insert into pays values('001','ETATS UNIS');



insert into ville values('99000','ATLANTA','001');
insert into ville values('99012','CHICAGO','001');
insert into ville values('99033','NEW YORK','001');
insert into ville values('99021','LOS ANGELES','001');

insert into bureau values('B0012','33 RUE GUSTVE','99000');
insert into bureau values('B0013','128 RUE PRESIDENT WILSON','99012');

insert into representant values('R104','BILL','ADAMS','B0013','C003');
insert into representant values('R105','BOB','SMITHS','B0012','C002');
insert into representant values('R106','AN','ROBERTS','B0013','C001');
insert into representant values('R107','LARRY','FITCH','B0012','C002');
insert into representant values('R108','MARY','JONES','B0012','C001');
insert into representant values('R109','PAUL','CRUZ','B0013','C003');
insert into representant values('R110','SAM','CLARK','B0013','C001');



insert into commande values('112961','12/06/2006','0001');
insert into commande values('112963','24/04/2001','0002');
insert into commande values('112968','04/11/2001','0003');
insert into commande values('112975','02/08/2004','0004');
insert into commande values('112983','06/01/2002','0004');
insert into commande values('112987','09/04/2006','0006');
insert into commande values('112989','03/06/2005','0001');
insert into commande values('113003','15/06/2005','0005');
insert into commande values('113027','05/01/1999','0005');
insert into commande values('113042','15/10/2005','0006');
insert into commande values('113055','22/05/2006','0004');
insert into commande values('113057','03/02/2005','0001');
insert into commande values('113058','30/08/2004','0002');
insert into commande values('115055','20/08/2001','0004');


insert into origine values('R106','112961');
insert into origine values('R104','112963');
insert into origine values('R105','112968');
insert into origine values('R106','112975');
insert into origine values('R106','112983');
insert into origine values('R110','112987');
insert into origine values('R104','112989');
insert into origine values('R108','113003');
insert into origine values('R108','113027');
insert into origine values('R105','113042');
insert into origine values('R106','113055');
insert into origine values('R106','113057');
insert into origine values('R107','113058');
insert into origine values('R108','115055');

insert into detail values(76,'112961','P99012');
insert into detail values(15,'112961','P99013');
insert into detail values(25,'112961','P99014');
insert into detail values(16,'112961','P99015');
insert into detail values(7,'112961','P99016');
insert into detail values(78,'112963','P99017');
insert into detail values(74,'112963','P99018');
insert into detail values(92,'112968','P99012');
insert into detail values(21,'112968','P99014');
insert into detail values(51,'112968','P99017');
insert into detail values(61,'112975','P99018');
insert into detail values(8,'112983','P99012');
insert into detail values(80,'112983','P99015');
insert into detail values(36,'112983','P99017');
insert into detail values(77,'112987','P99013');
insert into detail values(78,'112987','P99018');
insert into detail values(26,'112989','P99014');
insert into detail values(73,'112989','P99018');
insert into detail values(59,'112989','P99015');
insert into detail values(34,'113003','P99018');
insert into detail values(16,'113027','P99012');
insert into detail values(43,'113027','P99013');
insert into detail values(60,'113042','P99012');
insert into detail values(53,'113042','P99013');
insert into detail values(45,'113042','P99017');
insert into detail values(5,'113042','P99018');
insert into detail values(80,'113055','P99016');
insert into detail values(88,'113055','P99015');
insert into detail values(79,'113057','P99018');
insert into detail values(23,'113057','P99013');
insert into detail values(80,'113057','P99015');
insert into detail values(99,'113058','P99016');
insert into detail values(57,'115055','P99016');
insert into detail values(68,'115055','P99017');

