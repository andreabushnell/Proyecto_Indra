use Eventos_Sostenibles
go

create or alter trigger TR_Usuario_DEL
on USUARIOS after delete
as
    delete INSCRIPCIONES 
    where Usuario=(select Correo from Deleted)
go
