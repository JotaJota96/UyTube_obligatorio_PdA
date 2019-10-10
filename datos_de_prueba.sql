-- Administradores
/*
INSERT INTO public.administrador (id,apellido,contrasenia,nombre) VALUES 
(0,'root','admin','administrador')
;
*/
-- Categorias
INSERT INTO public.categoria (nombre) VALUES 
('MUSICA')
,('DEPORTE')
,('GAMING')
--,('UNDEFINED')
;


-- Listas por defecto
INSERT INTO public.lista_por_defecto (nombre) VALUES 
('Ver mas tarde')
;

-- Canales
INSERT INTO public.canal (descripcion,eliminado,nombre,privacidad) VALUES 
('Covers en guitarra de rock uruguayo',false,'GuitarCovers','PUBLICO')
,('No se de que va a ser mi canal',false,'PricKG','PUBLICO')
,('Covers de lo mejor del futbool uruguayo',false,'BolsoCovers','PUBLICO')
,('Temones',false,'Rock ingles','PUBLICO')
,('El mejor canal para pasar el rato',false,'jarrieta31','PUBLICO')
,('Descubre la conspiracion mundial que los gobiernos ocultan',false,'terraplanista1','PUBLICO')
,('',false,'APMI','PUBLICO')
;

-- Usuarios
INSERT INTO public.usuario (id,apellido,contrasenia,correo,eliminado,fecha_eliminado,fecha_nacimiento,imagen,nombre,seguidores,id_canal) VALUES 
('JotaJota96','Alvarez','12345678','jjap96@gmail.com',false,NULL,'1996-10-09','imagenes\perfiles\JotaJota96.jpg','Juan',3,1)
,('LuC31G','Garrido','12345678','LuC31@gmail.com',false,NULL,'1998-12-31','imagenes\perfiles\LuC31G.jpg','Lucas',2,2)
,('MCBolso','Castro','12345678','mcbolso96@gmail.com',false,NULL,'1999-08-04','imagenes\perfiles\MCBolso.jpg','Mariano',0,3)
,('camilillo15','Camilo','12345678','facu_camilo2@hotmail.com',false,NULL,'1999-07-13','imagenes\perfiles\camilillo15.jpg','Facundo',1,4)
,('jarrieta31','Arrieta','jarrieta31','julioarrieta23@gmail.com',false,NULL,'1976-03-02','imagenes\perfiles\jarrieta31.jpg','Julio',4,5)
,('terraplanista1','Ibañez','terraplanista1','olivertierraplana@gmail.com',false,NULL,'2019-10-03','','Oliver',0,6)
,('apmi','Pastores','apmi','apmi@hotmail.com',false,NULL,'2019-10-03','','Alerta',1,7)
;

-- Usuarios seguidores
INSERT INTO public.usuarios_seguidores (nick_seguido,nick_seguidor) VALUES 
('JotaJota96','LuC31G')
,('JotaJota96','camilillo15')
,('JotaJota96','MCBolso')
,('LuC31G','JotaJota96')
,('LuC31G','jarrieta31')
,('jarrieta31','LuC31G')
,('jarrieta31','JotaJota96')
,('jarrieta31','MCBolso')
,('jarrieta31','camilillo15')
,('apmi','JotaJota96')
,('camilillo15','apmi')
;

-- Usuarios seguidos
INSERT INTO public.usuarios_seguidos (nick_seguidor,nick_seguido) VALUES 
('LuC31G','JotaJota96')
,('camilillo15','JotaJota96')
,('MCBolso','JotaJota96')
,('JotaJota96','LuC31G')
,('jarrieta31','LuC31G')
,('LuC31G','jarrieta31')
,('JotaJota96','jarrieta31')
,('MCBolso','jarrieta31')
,('camilillo15','jarrieta31')
,('JotaJota96','apmi')
,('apmi','camilillo15')
;

-- Videos
INSERT INTO public.video (cant_dislikes,cant_likes,categoria,descripcion,duracion,eliminado,fecha_publicacion,nombre,privacidad,url,id_canal) VALUES 
(1,1,'MUSICA','Cover de La casa de al lado Christian Cary','00:05:43',false,'2019-07-21','La casa de al lado Christian Cary (Cover en guitarra)','PUBLICO','https://www.youtube.com/watch?v=An0uvGCUB9k',1)
,(0,0,'MUSICA','Cover de Verde - La Triple Nelson','00:03:32',false,'2019-09-29','Verde - La Triple Nelson (Cover en guitarra)','PUBLICO','https://www.youtube.com/watch?v=ojYnrNRXOjk',1)
,(0,1,'MUSICA','Cover de Naufrago - 4 Pesos de Propina ','00:03:36',false,'2019-02-02','Naufrago - 4 Pesos de Propina (Cover en guitarra)','PUBLICO','https://www.youtube.com/watch?v=ksuDZQuJLSY',1)
,(0,0,'MUSICA','Cover de Como pasa el tiempo - Cuarteto de nos ','00:04:32',false,'2019-05-15','Como pasa el tiempo - Cuarteto de nos (Cover en guitarra)','PUBLICO','https://www.youtube.com/watch?v=n1AR_VSHPek',1)
,(2,1,'UNDEFINED','Hola Que hace xD xD xD','00:00:47',false,'2019-02-02','HolaQueHace','PUBLICO','https://www.youtube.com/watch?v=Nl-Sq5OXIWk',2)
,(1,0,'DEPORTE','Canta el bolso en la previa vs San Lorenzo','00:00:42',false,'2019-07-21','No se como voy, no se como vengo','PUBLICO','https://www.youtube.com/watch?v=S0_FBF8XaO0',3)
,(1,0,'DEPORTE','Por la del Bolso hay que matar o morir - La Banda Del Parque','00:02:11',false,'2019-05-15','C.N. de F. Tema Nuevo 2019','PUBLICO','https://www.youtube.com/watch?v=9L5qQ9iyhJk',3)
,(1,0,'MUSICA','de La Banda del Parque (CON LETRA) | Hinchada de Nacional 2019','00:09:26',false,'2019-09-29','Las mejores canciones de La Banda','PUBLICO','https://www.youtube.com/watch?v=ob0TPs5-Y5Y',3)
,(1,0,'UNDEFINED','Camila Guiribitey','10:10:43',false,'2019-02-02','NO CREERÁS LO QUE LLEVO EN MI BOLSO','PUBLICO','https://www.youtube.com/watch?v=7wCUuplgmQM',3)
,(0,1,'MUSICA','Album Favourite Worst Nightmare','00:04:09',false,'2019-02-02','505 - Arctic Monkeys','PUBLICO','https://www.youtube.com/watch?v=iV5VKdcQOJE',4)
,(0,3,'MUSICA','Ni idea como se llama el album','00:04:37',false,'2019-05-15','Wonderwall - Oasis','PUBLICO','https://www.youtube.com/watch?v=bx1Bh8ZvH84',4)
,(0,1,'UNDEFINED','Curso de android, tarea 4','00:04:02',false,'2019-10-30','Tutorial android 1','PUBLICO','https://www.youtube.com/watch?v=xCq7YXGXaLc&list=PL-6ex1wzFuEh9RUN-5nCOU13eYknEXl09',5)
,(0,0,'UNDEFINED','Curso de android, tarea 5','00:01:17',false,'2019-10-30','Tutorial android 2','PUBLICO','https://www.youtube.com/watch?v=i4W5LFeIdNU',5)
,(1,0,'UNDEFINED','Científicos descubren algo extraño en la cara oculta de la Luna.','00:10:02',false,'2019-10-03','Descubren algo EXTRAÑO en la cara OCULTA de la Luna','PRIVADO','https://www.youtube.com/watch?v=ObpYRHbwT9Y',6)
,(1,0,'UNDEFINED','El Segundo Libro de Enoc revela cómo fueron creados los cielos, la Tierra, el Domo, los seres visibles e invisibles y más misterios.','00:10:20',false,'2019-10-03','Los SECRETOS de la Creación revelados a Enoc','PRIVADO','https://www.youtube.com/watch?v=WuDyGe-Ir8A',6)
,(1,0,'UNDEFINED','Las antiguas civilizaciones, manuscritos antiguos y varios hechos sorprendentes apuntan a la existencia de un límite en el cielo y debajo de la Tierra.','00:10:00',false,'2019-10-03','Los limites del DOMO','PRIVADO','https://www.youtube.com/watch?v=a_qHPssKjCw',6)
,(0,1,'UNDEFINED','Foto del apolo 15 con la bandera.
https://www.flickr.com/photos/projectapolloarchive/21489361038/in/album-72157659044904175/','00:20:47',false,'2019-10-03','Analizando la Misteriosa Bandera ´´Flameante´´ del Apolo 15','PUBLICO','https://www.youtube.com/watch?v=I8AGvzp554c',7)
,(0,1,'UNDEFINED','Video donde respondo al video de alarma mundial sobre la cuestión de que no haya refutado sus hipótesis.','00:56:27',false,'2019-10-03','Sobre las Hipótesis Infalsables, Falsacionismo y Efecto Lupa terraplano','PUBLICO','https://www.youtube.com/watch?v=uvEyal8j0Uo',7)
,(0,1,'UNDEFINED','Comparando Saturno este año respecto del año anterior y observando el cambio de la inclinación de sus anillos a medida que el planeta se traslada alrededor del sol.','00:04:32',false,'2019-10-03','Comparación de Saturno en 2019 vs 2018','PUBLICO','https://www.youtube.com/watch?v=xta6f4CyoMk',7)
;


-- Listas de reproduccion
INSERT INTO public.lista_de_reproduccion (categoria,eliminado,nombre,privacidad,tipo,id_canal) VALUES 
('UNDEFINED',false,'Ver mas tarde','PRIVADO','POR_DEFECTO',1)
,('UNDEFINED',false,'Ver mas tarde','PRIVADO','POR_DEFECTO',2)
,('UNDEFINED',false,'Ver mas tarde','PRIVADO','POR_DEFECTO',3)
,('UNDEFINED',false,'Ver mas tarde','PRIVADO','POR_DEFECTO',4)
,('UNDEFINED',false,'Ver mas tarde','PRIVADO','POR_DEFECTO',5)
,('MUSICA',false,'Mis covers','PUBLICO','PARTICULAR',1)
,('GAMING',false,'Minecraft','PRIVADO','PARTICULAR',1)
,('UNDEFINED',false,'Pasar el rato','PRIVADO','PARTICULAR',2)
,('UNDEFINED',false,'Bolso siempre bolso naa','PUBLICO','PARTICULAR',3)
,('MUSICA',false,'Oasis','PUBLICO','PARTICULAR',4)
,('UNDEFINED',false,'Ver mas tarde','PRIVADO','POR_DEFECTO',6)
,('UNDEFINED',false,'Ver mas tarde','PRIVADO','POR_DEFECTO',7)
,('UNDEFINED',false,'videos de terraboludos','PRIVADO','PARTICULAR',7)
;

-- Comentarios
INSERT INTO public.comentario (fecha,nivel,texto,nick_usuario,id_com_padre,id_video) VALUES 
('2019-08-01',0,'Buenisimo!!','LuC31G',NULL,1)
,('2019-08-01',1,'Gracias!!!','JotaJota96',1,NULL)
,('2019-08-01',0,'Cuando sale algo de los Artic Monkeys?','camilillo15',NULL,1)
,('2019-08-01',1,'Solo sube covers de rock nacional','LuC31G',3,NULL)
,('2019-08-01',2,'siempre hay un boludo','MCBolso',4,NULL)
,('2019-08-01',1,'O de los Guns and Roses','jarrieta31',3,NULL)
,('2019-08-01',2,'otro mas...','MCBolso',6,NULL)
,('2019-08-01',3,'otro mas que?','jarrieta31',7,NULL)
,('2019-08-01',0,'¿Que usas para editar el video?','MCBolso',NULL,1)
,('2019-08-01',1,'Sony Vegas Pro en Windows 10','JotaJota96',9,NULL)
,('2019-08-01',2,'Tipico, nadie usa Linux.','MCBolso',10,NULL)
,('2019-08-01',3,'Boo, que paso con Linux? hee??','jarrieta31',11,NULL)
,('2019-08-01',2,'Yo que vos me compro una MAC...','camilillo15',10,NULL)
,('2019-10-03',0,'Me recuerda a Bulevard of broquen drims','LuC31G',NULL,11)
,('2019-10-03',1,'Si, pa mi que green day les copio...','MCBolso',14,NULL)
,('2019-10-03',2,'O ellos a green day','LuC31G',15,NULL)
,('2019-10-03',3,'nunca lo sabremos...','jarrieta31',16,NULL)
,('2019-10-03',1,'A mi me pasa al revez, esa me recuerda a esta','JotaJota96',14,NULL)
,('2019-10-03',0,'que al pedo que estas','camilillo15',NULL,5)
,('2019-10-03',0,'lo mejor que he visto!','jarrieta31',NULL,5)
,('2019-10-03',0,'¿Como se llama esa cancion?','MCBolso',NULL,5)
,('2019-10-03',0,'Cuando subis la parte 2?','JotaJota96',NULL,12)
,('2019-10-03',1,'Ya esta subida, buscala en mis videos','jarrieta31',22,NULL)
,('2019-10-03',0,'¿Algun tutorial de MAC que me recomiendes?','camilillo15',NULL,12)
,('2019-10-03',1,'Instalale windows!','MCBolso',24,NULL)
;

-- Valoraciones
INSERT INTO public.valoracion (val,nick_usuario,id_video) VALUES 
('LIKE','JotaJota96',19)
,('LIKE','JotaJota96',18)
,('LIKE','JotaJota96',17)
,('LIKE','JotaJota96',5)
,('LIKE','JotaJota96',12)
,('LIKE','LuC31G',1)
,('LIKE','LuC31G',3)
,('DISLIKE','camilillo15',1)
,('DISLIKE','apmi',16)
,('DISLIKE','apmi',15)
,('DISLIKE','apmi',14)
,('DISLIKE','camilillo15',8)
,('DISLIKE','camilillo15',7)
,('DISLIKE','camilillo15',9)
,('DISLIKE','camilillo15',6)
,('DISLIKE','camilillo15',5)
,('DISLIKE','MCBolso',5)
,('LIKE','JotaJota96',11)
,('LIKE','camilillo15',11)
,('LIKE','camilillo15',10)
,('LIKE','LuC31G',11)
;

-- Videos en listas
INSERT INTO public.videos_en_listas (id_lista,id_video) VALUES 
(13,16)
,(13,15)
,(13,14)
,(6,1)
,(8,5)
,(1,19)
,(1,16)
,(9,9)
,(9,6)
,(9,7)
,(9,8)
,(6,2)
,(6,3)
,(6,4)
,(10,10)
,(4,4)
,(3,14)
;
