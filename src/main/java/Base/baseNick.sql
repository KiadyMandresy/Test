create database rojoFinal;
use rojoFinal;
create table Admin(
    id serial primary key,
    nom varchar(50),
    mdp varchar(255),
    mail varchar(100)
);
insert into Admin(nom,mdp,mail) values('soa','1234','soa@gmail.com');
insert into Admin(nom,mdp,mail) values('nick','1234','nick@gmail.com');
insert into Admin(nom,mdp,mail) values('kiady','1234','kiady@gmail.com');

create table Utilisateur(
     id serial primary key,
     nom varchar(50),
    mdp varchar(255),
    mail varchar(100)
);

insert into Utilisateur(nom,mdp,mail) values('soa','12345','soa@gmail.com');
insert into Utilisateur(nom,mdp,mail) values('nick','12345','nick@gmail.com');
insert into Utilisateur(nom,mdp,mail) values('kiady','12345','kiady@gmail.com');
create table Region(
     id serial primary key,
     nom varchar(50)
);
insert into Region(nom) values ('Region 1');
insert into Region(nom) values ('Region 2');

create table ChefRegion(
    id serial primary key,
    nom varchar(50),
    mdp varchar(255),
    mail varchar(100),
    idReg int,
    FOREIGN key (idReg) references Region(id)
);
insert into ChefRegion(nom,mdp,mail,idReg) values('Chef Soa','1234','soa@gmail.com',1);
insert into ChefRegion(nom,mdp,mail,idReg) values('Chef nick','1234','nick@gmail.com',2);
insert into ChefRegion(nom,mdp,mail,idReg) values('Chef kiady','1234','kiady@gmail.com',2);

create table TypeSignalement(
    id serial primary key,
    nom varchar(50)
);
insert into TypeSignalement(nom) values('Destruction');

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

insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'commentaire 1','2021-11-10'::timestamp,4500.0,1500.0,2);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'commentaire 2','2021-10-05'::timestamp,4500.0,1500.0,2);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'commentaire 1','2021-11-10'::timestamp,4500.0,1500.0,1);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'commentaire 2','2021-10-05'::timestamp,4500.0,1500.0,1);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'commentaire 1','2021-11-10'::timestamp,4500.0,1500.0,2);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'commentaire 2','2021-10-05'::timestamp,4500.0,1500.0,1);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'commentaire 1','2021-11-10'::timestamp,4500.0,1500.0,2);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'commentaire 2','2021-10-05'::timestamp,4500.0,1500.0,2);
insert into Signalement(idType,commentaire,dateS,x,y,idUtilisateur) values(1,'Misy lalana simba eny Iavloha','2021-05-05'::timestamp,4500.0,1500.0,2);

create table DetailSignalement(
     id serial primary key,
     idSign int,
     photos varchar(255),
      FOREIGN KEY (idSign) REFERENCES Signalement(id)
);

insert into DetailSignalement(idSign,photos) values(5,'src/pgoto.jpeg');
insert into DetailSignalement(idSign,photos) values(6,'src/pg.jpeg');
insert into DetailSignalement(idSign,photos) values(7,'src/pgoto.jpeg');
insert into DetailSignalement(idSign,photos) values(8,'src/pg.jpeg');
insert into DetailSignalement(idSign,photos) values(1,'src/pgoto.jpeg');
insert into DetailSignalement(idSign,photos) values(2,'src/pg.jpeg');
insert into DetailSignalement(idSign,photos) values(9,'src/pg.jpeg');
create table SignalementCorbeille(
     id serial primary key,
     idSign int,
     dateS TimeStamp,
      FOREIGN KEY (idSign) REFERENCES Signalement(id)
);
insert into SignalementCorbeille(idSign,dateS) values(9,'2021-12-07'::timestamp);
create table SignalementValide(
     id serial primary key,
     idSign int,
     idReg int,
      FOREIGN KEY (idSign) REFERENCES Signalement(id),
       FOREIGN KEY (idReg) REFERENCES Region(id)
);
insert into SignalementValide(idSign,idReg) values(1,1);
insert into SignalementValide(idSign,idReg) values(2,1);
insert into SignalementValide(idSign,idReg) values(3,1);
insert into SignalementValide(idSign,idReg) values(4,2);
insert into SignalementValide(idSign,idReg) values(5,2);
insert into SignalementValide(idSign,idReg) values(6,2);
insert into SignalementValide(idSign,idReg) values(7,2);
insert into SignalementValide(idSign,idReg) values(8,2);
insert into SignalementValide(idSign,idReg) values(9,2);
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
      FOREIGN KEY (idSignTermine) REFERENCES SignalementTermine(id)
);

/*--------------VIEW------------------------*/
/**/
/*Liste globales des signalements*/
create view signalementGlobal as select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s
join TypeSignalement as st
on st.id=s.idType
join DetailSignalement as dt
on dt.idSign=s.id
join Utilisateur as u
on u.id=s.idUtilisateur


select count(s.id),r.nom from Signalement as s join SignalementValide as sv on sv.idSign=s.id join Region as r on r.id=sv.idReg
where s.dateS>'2021-05-10' and s.dateS<'2021-11-01'
group by r.id


select s.id,s.commentaire,s.dates,s.x,s.y,u.nom as utilisateur,u.mail,r.nom from SignalementValide as sv 
join Signalement as s 
on sv.idSign=s.id
join Region as r 
on r.id=sv.idReg 
join Utilisateur as u 
on u.id=s.idUtilisateur
