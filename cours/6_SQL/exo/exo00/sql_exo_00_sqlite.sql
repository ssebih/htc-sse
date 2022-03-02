PRAGMA foreign_keys = ON; 

/*------------------------------------------------------------
#        Script SQLite  
#------------------------------------------------------------*/


/*
drop table vendre;
drop table produits;
drop table types;
drop table date;
*/


/*------------------------------------------------------------
# Table: types
#------------------------------------------------------------*/
CREATE TABLE types(
	CodeType     INTEGER NOT NULL ,
	Designation  TEXT ,
	PRIMARY KEY (CodeType)
);





/*------------------------------------------------------------
# Table: Produits
#------------------------------------------------------------*/
CREATE TABLE Produits(
	CodeProduit   INTEGER NOT NULL ,
	Designation   TEXT ,
	prix_au_kilo  DECIMAL(3,2) ,
	CodeType      INTEGER ,
	PRIMARY KEY (CodeProduit) ,
	
	FOREIGN KEY (CodeType) REFERENCES types(CodeType)
);


/*------------------------------------------------------------
# Table: Date
#------------------------------------------------------------*/
CREATE TABLE Date(
	date_de_vente  NUMERIC NOT NULL ,
	PRIMARY KEY (date_de_vente)
);


/*------------------------------------------------------------
# Table: vendre
#------------------------------------------------------------*/
CREATE TABLE vendre(
	poids           DECIMAL(3,2) ,
	CodeProduit    INTEGER NOT NULL ,
	date_de_vente  NUMERIC NOT NULL ,
	PRIMARY KEY (CodeProduit,date_de_vente) ,
	
	FOREIGN KEY (CodeProduit) REFERENCES Produits(CodeProduit),
	FOREIGN KEY (date_de_vente) REFERENCES Date(date_de_vente)
);




/* insertion table [TYPES]*/
INSERT INTO TYPES (codeType, Designation)
 VALUES  (1, 'Animaux');
INSERT INTO TYPES (codeType, Designation)
 VALUES  (2, 'Legumes') ;
INSERT INTO TYPES (codeType, Designation)
 VALUES  (3, 'Fruits') ;




/* insertion table [PRODUITS]*/

INSERT INTO produits (CodeProduit, Designation, prix_au_kilo, CodeType)
 VALUES (1, 'Lapin', 12, 1);
INSERT INTO produits (CodeProduit, Designation, prix_au_kilo, CodeType)
 VALUES (2, 'Banane', 5, 3);
INSERT INTO produits (CodeProduit, Designation, prix_au_kilo, CodeType)
 VALUES (3, 'Poule', 17, 1);
INSERT INTO produits (CodeProduit, Designation, prix_au_kilo, CodeType)
 VALUES (4, 'Pomme', 3, 3);
INSERT INTO produits (CodeProduit, Designation, prix_au_kilo, CodeType)
 VALUES (5, 'Fraise', 9, 3);
INSERT INTO produits (CodeProduit, Designation, prix_au_kilo, CodeType)
 VALUES (6, 'Choux', 4, 2);
INSERT INTO produits (CodeProduit, Designation, prix_au_kilo, CodeType)
 VALUES (7, 'Carotte', 2, 2);


/* Table DATE */
INSERT INTO date (date_de_vente) values('11/12/2016');
INSERT INTO date (date_de_vente) values('27/01/2016');
INSERT INTO date (date_de_vente) values('09/07/2016');
INSERT INTO date (date_de_vente) values('22/08/2016');
INSERT INTO date (date_de_vente) values('29/10/2016');
INSERT INTO date (date_de_vente) values('06/10/2016');
INSERT INTO date (date_de_vente) values('08/11/2016');
INSERT INTO date (date_de_vente) values('02/08/2016');
INSERT INTO date (date_de_vente) values('13/11/2016');
INSERT INTO date (date_de_vente) values('22/10/2016');
INSERT INTO date (date_de_vente) values('15/11/2016');
INSERT INTO date (date_de_vente) values('13/10/2016');
INSERT INTO date (date_de_vente) values('24/10/2016');
INSERT INTO date (date_de_vente) values('14/07/2016');
INSERT INTO date (date_de_vente) values('27/05/2016');
INSERT INTO date (date_de_vente) values('19/08/2016');
INSERT INTO date (date_de_vente) values('23/09/2016');
INSERT INTO date (date_de_vente) values('23/04/2016');
INSERT INTO date (date_de_vente) values('14/04/2016');
INSERT INTO date (date_de_vente) values('17/05/2016');
INSERT INTO date (date_de_vente) values('20/10/2016');
INSERT INTO date (date_de_vente) values('23/02/2016');
INSERT INTO date (date_de_vente) values('08/09/2016');
INSERT INTO date (date_de_vente) values('25/05/2016');
INSERT INTO date (date_de_vente) values('13/02/2016');
INSERT INTO date (date_de_vente) values('15/05/2016');
INSERT INTO date (date_de_vente) values('22/09/2016');
INSERT INTO date (date_de_vente) values('15/09/2016');
INSERT INTO date (date_de_vente) values('19/02/2016');
INSERT INTO date (date_de_vente) values('12/03/2016');



/* Table VENDRE */
insert into vendre (poids,  CodeProduit,  date_de_vente) values (6, 5, '11/12/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (1, 3, '27/01/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (3, 3, '09/07/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (8, 2, '22/08/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (1, 3, '29/10/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (8, 2, '06/10/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (4, 1, '08/11/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (5, 1, '02/08/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (10, 2, '13/11/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (5, 5, '22/10/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (9, 4, '15/11/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (6, 2, '13/10/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (2, 5, '24/10/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (3, 3, '08/11/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (1, 3, '14/07/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (9, 5, '27/05/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (2, 3, '19/08/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (4, 5, '23/09/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (10, 4,'23/04/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (5, 1, '14/04/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (3, 5, '17/05/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (3, 3, '20/10/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (3, 5, '23/02/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (8, 5, '08/09/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (4, 2, '25/05/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (2, 3, '13/02/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (1, 2, '15/05/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (1, 5, '22/09/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (6, 2, '15/09/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (1, 3, '19/02/2016');
insert into vendre (poids,  CodeProduit,  date_de_vente) values (6, 5, '12/03/2016');
