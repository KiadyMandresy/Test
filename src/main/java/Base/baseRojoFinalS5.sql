create database final;
use final;
create table Admin(
    id serial primary key,
    nom varchar(50),
    mdp varchar(255),
    mail varchar(100)
);

insert into Admin(nom,mdp,mail) values('Jean Marc','marc1234','Marc@gmail.com');
insert into Admin(nom,mdp,mail) values('Galmar Steven','steven1234','Steven@gmail.com');
insert into Admin(nom,mdp,mail) values('Rosalinda Protsenko','rosalindac1234','Rosalinda@gmail.com');

/*--------------------------------------------------------------------------------*/

create table Utilisateur(
     id serial primary key,
     nom varchar(50),
    mdp varchar(255),
    mail varchar(100)
);

insert into Utilisateur(nom,mdp,mail) values('Rakotomananana Nick Mathieu','nick1234','Nick@gmail.com');
insert into Utilisateur(nom,mdp,mail) values('Randriamambola Soatoavina Koloina','soatoavina1234','Soatoavina@gmail.com');
insert into Utilisateur(nom,mdp,mail) values('Randria Kiady Mandresy','kiady1234','Kiady@gmail.com');

/*--------------------------------------------------------------------------------*/

create table Region(
     id serial primary key,
     nom varchar(50)
);

insert into Region(nom) values ('Dina');
insert into Region(nom) values ('Sava');
insert into Region(nom) values ('Itasy');
insert into Region(nom) values ('Analamanga');
insert into Region(nom) values ('Vakinakaratra');
insert into Region(nom) values ('Bongolava');
insert into Region(nom) values ('Sofia');
insert into Region(nom) values ('Boeny');
insert into Region(nom) values ('Betsiboka');
insert into Region(nom) values ('Melaky');
insert into Region(nom) values ('Alaotra-Mongoro');
insert into Region(nom) values ('Atsinanana');
insert into Region(nom) values ('Analanjirofo');
insert into Region(nom) values ('Amoron i Mania');
insert into Region(nom) values ('Haute Matsiatra');
insert into Region(nom) values ('Vatovavy Fitovinany');
insert into Region(nom) values ('Atsimo Atsinanana');
insert into Region(nom) values ('Ihorombe');
insert into Region(nom) values ('Menabe');
insert into Region(nom) values ('Atsimo Andrefana');
insert into Region(nom) values ('Androy');
insert into Region(nom) values ('Anosy');

/*--------------------------------------------------------------------------------*/

create table ChefRegion(
    id serial primary key,
    nom varchar(50),
    mdp varchar(255),
    mail varchar(100),
    idReg int,
    FOREIGN key (idReg) references Region(id)
);

insert into ChefRegion(nom,mdp,mail,idReg) values('Rabenarivo','1234','Rabenarivo@gmail.com',1);
insert into ChefRegion(nom,mdp,mail,idReg) values('Rakoto','1234','Rakoto@gmail.com',2);
insert into ChefRegion(nom,mdp,mail,idReg) values('Andrisoa','1234','Andrisoa@gmail.com',3);
insert into ChefRegion(nom,mdp,mail,idReg) values('Bokoto','1234','Bokoto@gmail.com',4);
insert into ChefRegion(nom,mdp,mail,idReg) values('Mamitina','1234','Mamitina@gmail.com',5);
insert into ChefRegion(nom,mdp,mail,idReg) values('Naivo','1234','Naivo@gmail.com',6);
insert into ChefRegion(nom,mdp,mail,idReg) values('Rabe','1234','Rabe@gmail.com',7);
insert into ChefRegion(nom,mdp,mail,idReg) values('Lioka','1234','Lioka@gmail.com',8);
insert into ChefRegion(nom,mdp,mail,idReg) values('Bevalana','1234','Bevalana@gmail.com',9);
insert into ChefRegion(nom,mdp,mail,idReg) values('Narisoa','1234','Narisoa@gmail.com',10);
insert into ChefRegion(nom,mdp,mail,idReg) values('Joseph','1234','Joseph@gmail.com',11);
insert into ChefRegion(nom,mdp,mail,idReg) values('Narindra','1234','Narindra@gmail.com',12);
insert into ChefRegion(nom,mdp,mail,idReg) values('Alex','1234','Alex@gmail.com',13);
insert into ChefRegion(nom,mdp,mail,idReg) values('Mamitina','1234','Mamitina@gmail.com',14);
insert into ChefRegion(nom,mdp,mail,idReg) values('Doara','1234','Doara@gmail.com',15);
insert into ChefRegion(nom,mdp,mail,idReg) values('Tiavina','1234','Tiavina@gmail.com',16);
insert into ChefRegion(nom,mdp,mail,idReg) values('Rojotina','1234','Rojotina@gmail.com',17);
insert into ChefRegion(nom,mdp,mail,idReg) values('Aina','1234','Aina@gmail.com',18);
insert into ChefRegion(nom,mdp,mail,idReg) values('Naeela','1234','Naeela@gmail.com',19);
insert into ChefRegion(nom,mdp,mail,idReg) values('Bemasy','1234','Bemasy@gmail.com',20);
insert into ChefRegion(nom,mdp,mail,idReg) values('Richard','1234','Richard@gmail.com',21);
insert into ChefRegion(nom,mdp,mail,idReg) values('Mandresy','1234','Mandresy@gmail.com',22);


/*--------------------------------------------------------------------------------*/

create table TypeSignalement(
    id serial primary key,
    nom varchar(50)
)
create table Type1(
    id serial primary key,
    nom text
)



insert into TypeSignalement(nom) values('Destruction routiere');
insert into TypeSignalement(nom) values('Eboulement');

/*--------------------------------------------------------------------------------*/

create table Signalement(
     id serial primary key,
     idType int,
     commentaire text,
     dateS TimeStamp,
     x float,
     y float,
     idUtilisateur int,
     FOREIGN KEY (idType) REFERENCES TypeSignalement(id),
     FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(id)
);

insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par la pluie','2021-10-10'::timestamp,-18.810950219529475,47.5442194451745,2);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par la pluie','2021-08-15'::timestamp,-18.909571444054112,47.53033742502648,2);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par causee par ecroulement','2021-08-20'::timestamp,-18.91338332499232,47.52887998779962,1);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par causee par ecroulement','2021-11-10'::timestamp,-18.899473594930384,47.52905145100277,1);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par la pluie','2021-02-20'::timestamp,-18.899838588044464,47.53745314795763,1);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par manque de construction','2021-02-14'::timestamp,-18.92275045046798,47.54053948561452,2);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par causee par ecroulement','2021-04-25'::timestamp,-18.897040287160458,47.50247465451294,2);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par manque de construction','2021-04-20'::timestamp,-18.924007470649357,47.50920458523698,3);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par causee par ecroulement','2021-10-08'::timestamp,-18.897040287160458,47.54053948561452,3);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par manque de construction','2021-07-19'::timestamp,-18.899473594930384,47.52442194451745,3);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par la pluie','2021-08-06'::timestamp,-18.924007470649357,47.53745314795763,2);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par la pluie','2021-06-29'::timestamp,-18.899473594930384,47.53033742502648,1);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par causee par ecroulement','2021-06-05'::timestamp,-18.91338332499232,47.53033742502648,1);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Destruction routiere par la pluie','2021-06-17'::timestamp,-18.944007470649357,47.52905145100277,1);

insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(2,'Ecroulement routiere','2021-11-10'::timestamp,-18.910950219529475,47.52442194451745,3);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(2,'Ecroulement routiere','2021-04-28'::timestamp,-18.909571444054112,47.53033742502648,3);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(2,'Ecroulement routiere','2021-09-18'::timestamp,-18.91338332499232,47.52887998779962,2);


/*--------------------------------------------------------------------------------*/

create table DetailSignalement(
     id serial primary key,
     idSign int,
     photos varchar(255),
      FOREIGN KEY (idSign) REFERENCES Signalement(id)
);

create table DetailSignalement1(
     id serial primary key,
     idSign int,
     photos text,
      FOREIGN KEY (idSign) REFERENCES Signalement(id)
);

insert into DetailSignalement(idSign,photos) values(1,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(1,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(1,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(2,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(2,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(3,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(4,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(5,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(5,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(6,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(6,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(7,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(7,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(8,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(8,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(9,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(9,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(10,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(10,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(11,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(11,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(11,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(12,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(13,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(13,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(14,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(14,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(15,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(16,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(16,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(16,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(17,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(17,'photos.jpeg');
insert into DetailSignalement(idSign,photos) values(17,'photos.jpeg');

/*--------------------------------------------------------------------------------*/

create table SignalementCorbeille(
     id serial primary key,
     idSign int,
     dateS TimeStamp,
      FOREIGN KEY (idSign) REFERENCES Signalement(id)
);

insert into SignalementCorbeille(idSign,dateS) values(12,'2021-12-07'::timestamp);


/*--------------------------------------------------------------------------------*/

create table SignalementValide(
    id serial primary key,
    idSign int,
    idReg int,
    FOREIGN KEY (idSign) REFERENCES Signalement(id),
    FOREIGN KEY (idReg) REFERENCES Region(id)
);

insert into SignalementValide(idSign,idReg) values(1,1);
insert into SignalementValide(idSign,idReg) values(14,6);
insert into SignalementValide(idSign,idReg) values(13,8);
insert into SignalementValide(idSign,idReg) values(11,8);
insert into SignalementValide(idSign,idReg) values(10,10);
insert into SignalementValide(idSign,idReg) values(9,10);
insert into SignalementValide(idSign,idReg) values(8,10);
insert into SignalementValide(idSign,idReg) values(7,17);
insert into SignalementValide(idSign,idReg) values(6,17);
insert into SignalementValide(idSign,idReg) values(5,17);



/*--------------------------------------------------------------------------------*/

create table SignalementTermine(
         id serial primary key,
         idSignV int,
         dateS TimeStamp,
         budget float,
      FOREIGN KEY (idSignV) REFERENCES SignalementValide(id)
);

insert into SignalementTermine(idSignV,dateS,budget) values(2,'2021-12-20'::timestamp,1800000.0);
insert into SignalementTermine(idSignV,dateS,budget) values(4,'2021-12-10'::timestamp,1000450.0);
insert into SignalementTermine(idSignV,dateS,budget) values(6,'2021-05-25'::timestamp,950000.0);
insert into SignalementTermine(idSignV,dateS,budget) values(8,'2021-10-20'::timestamp,2000000.0);
insert into SignalementTermine(idSignV,dateS,budget) values(10,'2021-10-14'::timestamp,5000000.0);



/*--------------------------------------------------------------------------------*/
create table Notification(
     id serial primary key,
     idSignTermine int,
     statut int,
      FOREIGN KEY (idSignTermine) REFERENCES SignalementTermine(id)
);


