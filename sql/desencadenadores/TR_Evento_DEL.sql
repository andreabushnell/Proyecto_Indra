use Eventos_Sostenibles
go

create or alter trigger TR_Evento_DEL
on EVENTOS after delete
as
    delete INSCRIPCIONES 
    where Evento=(select Nombre from Deleted)
    delete TIENEN_LUGAR
    where Evento=(select Nombre from Deleted)
go