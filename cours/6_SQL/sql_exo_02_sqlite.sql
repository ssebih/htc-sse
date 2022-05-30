--------------------------------------------------------------
--        Script SQLite  
--------------------------------------------------------------

/*
drop table bureau;
drop table ville;
drop table chef;
drop table commande;
drop table client;
drop table produit;
drop table pays;
drop table detail;
drop table origine;
drop table representant;
*/

--------------------------------------------------------------
-- Table: BUREAU
--------------------------------------------------------------
CREATE TABLE BUREAU(
	nbur         TEXT NOT NULL ,
	bur_adresse  TEXT ,
	cp           TEXT ,
	PRIMARY KEY (nbur) ,
	
	FOREIGN KEY (cp) REFERENCES VILLE(cp)
);


--------------------------------------------------------------
-- Table: VILLE
--------------------------------------------------------------
CREATE TABLE VILLE(
	cp       TEXT NOT NULL ,
	vil_nom  TEXT ,
	npays    TEXT ,
	PRIMARY KEY (cp) ,
	
	FOREIGN KEY (npays) REFERENCES PAYS(npays)
);


--------------------------------------------------------------
-- Table: REPRESENTANT
--------------------------------------------------------------
CREATE TABLE REPRESENTANT(
	nrep        TEXT NOT NULL ,
	rep_nom     TEXT ,
	rep_prenom  TEXT ,
	nbur        TEXT ,
	nchef       TEXT ,
	PRIMARY KEY (nrep) ,
	
	FOREIGN KEY (nbur) REFERENCES BUREAU(nbur),
	FOREIGN KEY (nchef) REFERENCES CHEF(nchef)
);


--------------------------------------------------------------
-- Table: CHEF
--------------------------------------------------------------
CREATE TABLE CHEF(
	nchef       TEXT NOT NULL ,
	che_nom     TEXT ,
	che_prenom  TEXT ,
	PRIMARY KEY (nchef)
);


--------------------------------------------------------------
-- Table: COMMANDE
--------------------------------------------------------------
CREATE TABLE COMMANDE(
	ncmd      TEXT NOT NULL ,
	cmd_date  NUMERIC NOT NULL ,
	ncli      TEXT ,
	PRIMARY KEY (ncmd) ,
	
	FOREIGN KEY (ncli) REFERENCES CLIENT(ncli)
);


--------------------------------------------------------------
-- Table: CLIENT
--------------------------------------------------------------
CREATE TABLE CLIENT(
	ncli         TEXT NOT NULL ,
	cli_societe  TEXT ,
	PRIMARY KEY (ncli)
);


--------------------------------------------------------------
-- Table: PRODUIT
--------------------------------------------------------------
CREATE TABLE PRODUIT(
	nprod        TEXT NOT NULL ,
	pro_libelle  TEXT ,
	pro_prix     NUMERIC ,
	PRIMARY KEY (nprod)
);


--------------------------------------------------------------
-- Table: PAYS
--------------------------------------------------------------
CREATE TABLE PAYS(
	npays    TEXT NOT NULL ,
	pay_nom  TEXT ,
	PRIMARY KEY (npays)
);


--------------------------------------------------------------
-- Table: DETAIL
--------------------------------------------------------------
CREATE TABLE DETAIL(
	qtite  INTEGER ,
	ncmd   TEXT NOT NULL ,
	nprod  TEXT NOT NULL ,
	PRIMARY KEY (ncmd,nprod) ,
	
	FOREIGN KEY (ncmd) REFERENCES COMMANDE(ncmd),
	FOREIGN KEY (nprod) REFERENCES PRODUIT(nprod)
);


--------------------------------------------------------------
-- Table: ORIGINE
--------------------------------------------------------------
CREATE TABLE ORIGINE(
	nrep  TEXT NOT NULL ,
	ncmd  TEXT NOT NULL ,
	PRIMARY KEY (nrep,ncmd) ,
	
	FOREIGN KEY (nrep) REFERENCES REPRESENTANT(nrep),
	FOREIGN KEY (ncmd) REFERENCES COMMANDE(ncmd)
);


CREATE INDEX COMMANDE_cmd_date_idx ON COMMANDE (cmd_date);



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

