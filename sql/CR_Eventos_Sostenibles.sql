use master
go

if db_id('Eventos_Sostenibles') is not NULL
drop database Eventos_Sostenibles
GO
create database Eventos_Sostenibles
GO

use Eventos_Sostenibles
go


create table ORGANIZADORES
(
    Nombre varchar(50) primary key,
    Telefono TELEFONOS not null,
    Correo varchar(30) not null
)

create table USUARIOS
(
    Correo varchar(30) primary key,
    Nombre varchar(50) not null,
    Contraseña varchar (16) not null
)

create table UBICACIONES
(
    Direccion varchar(50) primary key,
    Modalidad varchar(20),
    constraint CK_UBICACIONES_Modalidad check (Modalidad in ('Online','Presencial'))
)

create table EVENTOS
(
    Nombre varchar(50) primary key,
    Duracion int not null,
    Categoria varchar(50) not null,
    Organizador varchar(50) not null,
    constraint FK_EVENTOS_Organizador foreign key (Organizador) references ORGANIZADORES(Nombre)
        on delete cascade
        on update cascade
)

create table TIENEN_LUGAR
(
    Evento varchar(50),
    Fecha date,
    Ubicacion varchar(50),
    constraint PK_TIENEN_LUGAR primary key (Evento, Fecha),
    constraint FK_TIENEN_LUGAR_Evento foreign key (Evento) references EVENTOS(nombre)
        on delete cascade
        on update cascade,
    constraint FK_TIENEN_LUGAR_Ubicacion foreign key (Ubicacion) references UBICACIONES(Direccion)
        on delete no action
        on update cascade
)

create table INSCRIPCIONES
(
    Usuario varchar(30),
    Evento varchar(50),
    constraint PK_INSCRIPCIONES primary key (Usuario, Evento),
    constraint FK_INSCRIPCIONES_Usuario foreign key (Usuario) references USUARIOS(Correo)
        on delete cascade
        on update cascade,
    constraint FK_INSCRIPCIONES_Evento foreign key (Evento) references EVENTOS(Nombre)
        on delete cascade
        on update cascade
) 

create domain TELEFONOS as char(9)
constraint CK_TELEOFONOScheck value like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'