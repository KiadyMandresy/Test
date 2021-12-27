create database rojoFinal;
use rojoFinal;
create table Admin(
    id int primary key not null AUTO_INCREMENT,
    nom varchar(50),
    mdp varchar(255),
    mail varchar(100)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
insert into Admin values(null,'soa','1234','soa@gmail.com');
insert into Admin values(null,'nick','1234','nick@gmail.com');
insert into Admin values(null,'kiady','1234','kiady@gmail.com');
create table Utilisateur(
     id int primary key not null AUTO_INCREMENT,
     nom varchar(50),
    mdp varchar(255),
    mail varchar(100)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
insert into Utilisateur values(null,'soa','12345','soa@gmail.com');
insert into Utilisateur values(null,'nick','12345','nick@gmail.com');
insert into Utilisateur values(null,'kiady','12345','kiady@gmail.com');
create table Region(
     id int primary key not null AUTO_INCREMENT,
     nom varchar(50)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
insert into Region values (null,'R1');
insert into Region values (null,'R2');
create table ChefRegion(
    id int primary key not null AUTO_INCREMENT,
    nom varchar(50),
    mdp varchar(255),
    mail varchar(100),
    idReg int,
    FOREIGN key (idReg) references Region(id)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
insert into ChefRegion values(null,'Chef Soa','1234','soa@gmail.com',1);
insert into ChefRegion values(null,'Chef nick','1234','nick@gmail.com',2);
insert into ChefRegion values(null,'Chef kiady','1234','kiady@gmail.com',2);
create table TypeSignalement(
    id int primary key not null AUTO_INCREMENT,
    nom varchar(50)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;



create table Signalement(
     id int primary key not null AUTO_INCREMENT,
     idType int,
     commentaire text,
     dateS DATETIME,
     x float,
     y float,
     idUtilisateur int,
     FOREIGN KEY (idType) REFERENCES TypeSignalement(id),
     FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(id)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;



create table DetailSignalement(
     id int primary key not null AUTO_INCREMENT,
     idSign int,
     photos varchar(255),
      FOREIGN KEY (idSign) REFERENCES Signalement(id)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

create table SignalementCorbeille(
     id int primary key not null AUTO_INCREMENT,
     idSign int,
     dateS DATETIME,
      FOREIGN KEY (idSign) REFERENCES Signalement(id)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
create table SignalementValide(
     id int primary key not null AUTO_INCREMENT,
     idSign int,
     idReg int,
      FOREIGN KEY (idSign) REFERENCES Signalement(id),
       FOREIGN KEY (idReg) REFERENCES Region(id)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
create table SignalementTermine(
         id int primary key not null AUTO_INCREMENT,
         idSignV int,
         dateS DATETIME,
         budget float,
      FOREIGN KEY (idSignV) REFERENCES SignalementValide(id)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
create table Notification(
     id int primary key not null AUTO_INCREMENT,
     idSignTermine int,
      FOREIGN KEY (idSignTermine) REFERENCES SignalementTermine(id)
)ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

/*--------------VIEW------------------------*/
/**/

