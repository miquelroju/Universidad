
--INSERTS PORT
insert into port(codi,nomciutat,categoria) values (001,'Barcelona','A');
insert into port(codi,nomciutat,categoria) values (002,'Rotterdam','A');
insert into port(codi,nomciutat,categoria) values (003,'Singapur','B');
insert into port(codi,nomciutat,categoria) values (004,'Amberes','B');
insert into port(codi,nomciutat,categoria) values (005,'València','C');
insert into port(codi,nomciutat,categoria) values (006,'Bremen','C');

--INSERTS CREUER

insert into creuer values (100,'meravelles dels Mars del Sud','luxe','S');
insert into creuer values (101,'Somnis del Carib','estandàrd','S');
insert into creuer values (102,'llums de la Mediterrània','luxe','S');
insert into creuer values (103,'Vision of the sea','semiluxe','S');
insert into creuer values (104,'Viking Sky','luxe','S');
insert into creuer values (105,'Costa Firenze','semiluxe','N');
insert into creuer values (106,'Seven Seas','estandàrd','S');
insert into creuer values (107,'Celebrity Session','luxe','S');
insert into creuer values (108,'Marbella discovery','semiluxe','N');
insert into creuer values (109,'Seven Seas 2','estandàrd','S');
insert into creuer values (110,'Wonder of the sea','estandàrd','S');


--INSERTS VAIXELL

insert into vaixell values (500,'Ciutat de Samarkanda',2015,30,2,'Àsia');
insert into vaixell values (501,'Queen of Luxury',2015,25,2.5,'França');
insert into vaixell values (502,'Dolphin of the Seven Seas',2010,20,2.5,'Itàlia');
insert into vaixell values (503,'Bahamas Celebration ',2015,15,2.5,'Bahamas');
insert into vaixell values (504,'Celebrity Xpedition ',2000,16,1.5,'Ecuador');
insert into vaixell values (505,'Costa Fascinosa ',2015,30,4.5,'Itàlia');
insert into vaixell values (506,'Queen Mary 2',2015,25,2.5,'Bernmuda');
insert into vaixell values (507,'Europa ',2013,10,2.85,'Itàlia');
insert into vaixell values (508,'Crystal Symphony',2020,18,2.5,'Bahamas');
insert into vaixell values (509,' MSC Armonia',2000,16,1.5,'Panamà');
insert into vaixell values (510,' Aurora',2015,30,4.5,'Bermuda');


---INSERT INTO CABINA

insert into cabina values ('C01',4,500);
insert into cabina values ('C02',6,500);
insert into cabina values ('A01',2,500);
insert into cabina values ('A02',4,500);
insert into cabina values ('B01',2,500);
insert into cabina values ('B02',2,500);

insert into cabina values ('C01',4,501);
insert into cabina values ('C02',4,501);
insert into cabina values ('A01',6,501);
insert into cabina values ('A02',8,501);
insert into cabina values ('B01',2,501);
insert into cabina values ('B02',2,501);

insert into cabina values ('C01',2,502);
insert into cabina values ('C02',6,502);
insert into cabina values ('A01',2,502);
insert into cabina values ('A02',8,502);
insert into cabina values ('B01',2,502);

insert into cabina values ('C01',4,503);
insert into cabina values ('C02',6,503);
insert into cabina values ('A01',2,503);
insert into cabina values ('A02',4,503);
insert into cabina values ('B01',8,503);
insert into cabina values ('B02',10,503);

insert into cabina values ('C01',4,504);
insert into cabina values ('C02',6,504);
insert into cabina values ('A01',2,504);
insert into cabina values ('A02',4,504);
insert into cabina values ('B01',8,504);
insert into cabina values ('B02',10,504);

insert into cabina values ('C01',4,505);
insert into cabina values ('C02',6,505);
insert into cabina values ('A01',2,505);
insert into cabina values ('A02',4,505);
insert into cabina values ('B01',8,505);
insert into cabina values ('B02',10,505);

insert into cabina values ('C01',4,506);
insert into cabina values ('C02',6,506);
insert into cabina values ('A01',2,506);
insert into cabina values ('A02',4,506);
insert into cabina values ('B01',8,506);
insert into cabina values ('B02',10,506);

insert into cabina values ('C01',4,507);
insert into cabina values ('C02',6,507);
insert into cabina values ('A01',2,507);
insert into cabina values ('A02',4,507);
insert into cabina values ('B01',8,507);
insert into cabina values ('B02',10,507);

insert into cabina values ('C01',4,508);
insert into cabina values ('C02',6,508);
insert into cabina values ('A01',2,508);
insert into cabina values ('A02',4,508);
insert into cabina values ('B01',8,508);
insert into cabina values ('B02',5,508);

insert into cabina values ('C01',4,509);
insert into cabina values ('C02',5,509);
insert into cabina values ('A01',2,509);
insert into cabina values ('A02',4,509);
insert into cabina values ('B01',4,509);
insert into cabina values ('B02',1,509);

insert into cabina values ('C01',4,510);
insert into cabina values ('C02',6,510);
insert into cabina values ('A01',2,510);
insert into cabina values ('A02',4,510);
insert into cabina values ('B01',6,510);
insert into cabina values ('B02',2,510);


--INSERTS PASSATGER

insert into passatger values('77684985L','Arnau','Sanz','','Joanot Martorell 5 Barcelona'); 
insert into passatger values('34565534A','Maria','Sorribes','Suria','Pujades 25 Barcelona');
insert into passatger values('87654478F','Teresa','Pons','Mauri','Isern 22 Banyoles');
insert into passatger values('23456788J','Sònia','Rives','','Argentona 3 Baix2 Premià de Mar');
insert into passatger values('55667878A','Jordi','Creu','','Diagonal 105 1r 1a Barcelona');
insert into passatger values('78665573C','David','Busquets','Ramiz','Parra 5 Argentona');
insert into passatger values('12456678L','Sònia','Rodriguez','Sems','Joanot Martorell 5 Barcelona');
insert into passatger values('23678988S','Jan','Sanz','Rodriguez','Joanot Martorell 5 Barcelona');
insert into passatger values('23456667J','Pere','Busquets','','Argentona 3 Baix2 Premià de Mar');
insert into passatger values('55664788J','Marta','Busquets','','Argentona 3 Baix2 Premià de Mar');

--INSERTS ESCALA

insert into escala values(30,1,2.5,100,001);
insert into escala values(31,2,1.5,100,003);
insert into escala values(32,3,1,100,002);
insert into escala values(33,4,2.5,100,004);
insert into escala values(34,5,3.5,100,005);

insert into escala values(35,1,2.5,101,001);
insert into escala values(36,2,1.5,101,003);
insert into escala values(37,3,1,101,002);
insert into escala values(38,4,2.5,101,004);
insert into escala values(39,5,3.5,101,005);
insert into escala values(40,6,1.5,101,006);


insert into escala values(41,1,2.5,102,002);
insert into escala values(42,2,1.5,102,006);
insert into escala values(43,3,1,102,004);
insert into escala values(44,4,2.5,102,003);
insert into escala values(45,5,3.5,102,005);
insert into escala values(46,6,1.1,103,006);
insert into escala values(47,2,1.5,103,005);
insert into escala values(48,3,1.5,103,002);
insert into escala values(49,4,3.5,103,004);


--INSERTS SORTIDA
insert into sortida values ('20/07/2022',100,500);
insert into sortida values ('25/07/2022',102,501);
insert into sortida values ('28/07/2022',105,502);
insert into sortida values ('02/07/2022',104,505);
insert into sortida values ('02/05/2022',103,505);
insert into sortida values ('15/06/2022',106,505);
insert into sortida values ('17/07/2021',100,506);
insert into sortida values ('02/05/2021',102,503);
insert into sortida values ('02/04/2021',101,507);
insert into sortida values ('15/06/2021',105,504);
insert into sortida values ('25/07/2021',103,502);
insert into sortida values ('02/08/2021',104,500);

--INSERTS RESERVA

insert into reserva values ('J01','20/05/2021','S',103,'25/07/2021',502,'A01');
insert into reserva values ('J02','20/03/2021','S',101,'02/04/2021',507,'B01');
insert into reserva values ('J03','20/03/2021','S',101,'02/04/2021',507,'B01');
insert into reserva values ('X01','20/03/2021','S',101,'02/04/2021',507,'B01');
insert into reserva values ('S01','20/05/2021','S',106,'15/06/2022',505,'C01');
insert into reserva values ('S02','02/05/2022','S',104,'02/07/2022',505,'C02');
insert into reserva values ('S03','25/01/2022','S',102,'25/07/2022',501,'A01');
insert into reserva values ('S04','25/01/2022','S',102,'25/07/2022',501,'A01');


--INSERTS DEMANAR

insert into demanar values('J01','77684985L');
insert into demanar values('J02','87654478F');
insert into demanar values('J03','87654478F');
insert into demanar values('X01','23456788J');
insert into demanar values('S01','55667878A');

commit;