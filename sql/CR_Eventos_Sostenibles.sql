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
    Telefono char(9),
    Correo varchar(30)
)

create table USUARIOS
(
    Correo varchar(30) primary key,
    Nombre varchar(50),
    Contraseña varchar (20)
)

create table UBICACIONES
(
    Direccion varchar(50) primary key,
    Tipo varchar(20),
    constraint CK_UBICACIONES_Tipo check (Tipo in ('Online','Presencial'))
)

create table EVENTOS
(
    Nombre varchar(50) primary key,
    Duracion int not null,
    Categoria varchar(50) not null,
    Organizador varchar(50) not null,
    constraint FK_EVENTOS_Organizador foreign key (Organizador) references ORGANIZADORES(Nombre)
        --Puedo eliminar un organizador si tiene eventos relacionados? Si el evento no tiene organizador no puede llevarse a cabo (ej. cancelación de parte del organizador)
        --Puedo actualizar el nombre del organizador mientras tenga un evento asociado? Sí
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
        --Podemos eliminar un evento que esté programado? Sí, y se eliminará la entrada en esta tabla
        --Si cambiamos el nombre de un evento, se actualizará en esta tabla
        on delete cascade
        on update cascade,
    constraint FK_TIENEN_LUGAR_Ubicacion foreign key (Ubicacion) references UBICACIONES(Direccion)
        --No podemos eliminar una ubicacion que esté asociada a un evento
        --Si actualizamos una dirección el cambio se reflejará en esta tabla
        on delete no action
        on update cascade
)

create table INSCRIPCIONES
(
    Usuario varchar(30),
    Evento varchar(50),
    constraint PK_INSCRIPCIONES primary key (Usuario, Evento),
    constraint FK_INSCRIPCIONES_Usuario foreign key (Usuario) references USUARIOS(Correo)
        --Si se elimina un usuario, se deberá elimnar la inscripción asociada
        --Podemos actualizar un usuario mientras sea parte de una inscripción? Sí, y se actualizará en la inscripción (ej. el usuario cambia su correo)
        on delete cascade
        on update cascade,
    constraint FK_INSCRIPCIONES_Evento foreign key (Evento) references EVENTOS(Nombre)
        --Si se elimina un evento, se deberá eliminar la inscripción asociada
        --Podemos actualizar un evento mientras sea parte de una inscripción? Sí, y se actualizará en la inscripción (ej. cambia el nombre del evento)
        on delete cascade
        on update cascade
)

--Si una inscripción tiene algún valor nulo, deberá eliminarse de la tabla. No tiene sentido una inscripción sin usuario asociado, o sin evento asociado
--Si no hay organizador se eliminará el evento 