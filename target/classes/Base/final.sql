create table Admin(
    id serial primary key,
    nom varchar(50),
    mdp varchar(255),
    mail varchar(100)
);

insert into Admin(nom,mdp,mail) values('Jean Marc','marc1234','Marc@gmail.com');
insert into Admin(nom,mdp,mail) values('Galmar Steven','steven1234','Steven@gmail.com');
insert into Admin(nom,mdp,mail) values('Rosalinda Protsenko','rosalindac1234','Rosalinda@gmail.com');

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


create table TypeSignalement(
    id serial primary key,
    nom varchar(50)
)



insert into TypeSignalement(nom) values('Destruction routiere');
insert into TypeSignalement(nom) values('Eboulement');
insert into TypeSignalement(nom) values('menace pour l environnement');
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


create table SignalementCorbeille(
     id serial primary key,
     idSign int,
     dateS TimeStamp,
      FOREIGN KEY (idSign) REFERENCES Signalement(id)
);

create table SignalementValide(
    id serial primary key,
    idSign int,
    idReg int,
    FOREIGN KEY (idSign) REFERENCES Signalement(id),
    FOREIGN KEY (idReg) REFERENCES Region(id)
);

create table SignalementTermine(
         id serial primary key,
         idSignV int,
         dateS TimeStamp,
         budget float,
      FOREIGN KEY (idSignV) REFERENCES SignalementValide(id)
);
create table Notification(
     id serial primary key,
     idSignTermine int,
     statut int,
      FOREIGN KEY (idSignTermine) REFERENCES SignalementTermine(id)
);