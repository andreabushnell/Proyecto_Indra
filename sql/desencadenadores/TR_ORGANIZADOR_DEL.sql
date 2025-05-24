use Eventos_Sostenibles
go 

create or alter trigger TR_Organizador_DEL
on ORGANIZADORES after delete
as 
    delete EVENTOS 
    where Organizador=(select Nombre from deleted)
go