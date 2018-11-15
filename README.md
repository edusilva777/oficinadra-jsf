# oficinadra-jsf

////////////////////    BANCO DE DADOS /////////////////

create database produtojsf;
use produtojsf;
create table categoria(catid int auto_increment , catdescricao varchar(60) not null, primary key(catid));
create table produto(proid int auto_increment, pronome varchar(60) not null, prodescricao varchar(120), propreco decimal (10,2) not null, procatid int,
primary key(proid), foreign key (procatid) references categoria (catid)
);




// LIB REPORT
https://bit.ly/2z7bCcW

// PLUGIN
https://bit.ly/2DgeiId

// PrimesFaces
versao 6.0
https://www.primefaces.org/downloads/


//FLICK
http://repository.primefaces.org/org/primefaces/themes/flick/1.0.10/flick-1.0.10.jar