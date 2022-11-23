insert into cliente values (1, "julian@gmail.com", 1, "ruta_foto","julian nuñez", "123");
insert into cliente values (2, "kph@gmail.com", 0, "ruta_foto","karina pulido", "1234");
insert into cliente values (3, "jacobo@gmail.com", 0, "ruta_foto","jacobo", "123");
insert into cliente values (4, "gabriela@gmail.com", 1, "ruta_foto","gabriela nuñez", "123");
insert into cliente values (5, "isabella@gmail.com", 1, "ruta_foto","isabella berjan", "123");

insert into cliente_telefono values(1, "casa", "3044883381")
insert into cliente_telefono values(1, "oficina", "3013066787")
insert into cliente_telefono values(2, "oficina", "3013066784")
insert into cliente_telefono values(3, "oficina", "3013066785");

insert into ciudad values (2,"Calarca");
insert into ciudad values (3,"Quimbaya");
insert into ciudad values (4,"Montenegro");
insert into ciudad values (5,"Pijao");
insert into ciudad values (6,"Buenavista");
insert into ciudad values (7,"Genova");
insert into ciudad values (8,"Salento");
insert into ciudad values (9,"Filandia");
insert into ciudad values (10,"Cordoba");
insert into ciudad values (11,"Circasia");
insert into ciudad values (12,"Tebaida");



insert into administrador_teatro values (1,"Isabela", "isabella@gmail.com");
insert into administrador_teatro values (2,"Julian", "julian@gmail.com");
insert into administrador_teatro values (3,"Esteban", "esteban@gmail.com");
insert into administrador_teatro values (4,"Nuñez", "nunez@gmail.com");
insert into administrador_teatro values (5,"Bejarano", "bejarano@gmail.com");

/**insert into pelicula values (1,1, "ACCION", "La vida es bella","reparto", "sinopsis","url_trailer");
insert into pelicula values (2, 1, "ACCION", "nombre","reparto", "sinopsis","url_trailer");
insert into pelicula values (3, 1, "ACCION", "Naruto Shipuden","reparto", "sinopsis","url_trailer");
insert into pelicula values (4, 0, "ACCION", "nombre","reparto", "sinopsis","url_trailer");
insert into pelicula values (5, 1, "ACCION", "nombre","reparto", "sinopsis","url_trailer");
 */

insert into teatro values (1, " Avenida Centenario No. 6 - 380 ", "7359489", 1, 1);
insert into teatro values (2, " Avenida Centenario No. 6 - 380 ", "7359489", 1, 2);
insert into teatro values (3, " Avenida Centenario No. 6 - 380 ", "7359489", 1, 4);
insert into teatro values (4, " Avenida Centenario No. 6 - 380 ", "7359489", 1, 1);
insert into teatro values (5, " Avenida Centenario No. 6 - 380 ", "7359489", 1, 5);

insert into distribucion_sillas values (1, 20,"esquema y", 20, 70 );
insert into distribucion_sillas values (2, 40,"esquema x", 20, 70 );
insert into distribucion_sillas values (3, 30,"esquema t", 20, 70 );
insert into distribucion_sillas values (4, 56,"esquema r", 20, 70 );
insert into distribucion_sillas values (5, 54,"esquema d", 20, 70 );

insert into sala values (1, "sala multiple", 2, 5);
insert into sala values (2, "sala simple", 3, 4);
insert into sala values (3, "sala 3d", 1, 2);
insert into sala values (4, "sala Mega", 4, 3);
insert into sala values (5, "sala doble", 2, 3);

insert into sala values (1, "sala multiple", 2, 5);
insert into sala values (2, "sala simple", 3, 4);
insert into sala values (3, "sala 3d", 1, 2);
insert into sala values (4, "sala Mega", 4, 3);
insert into sala values (5, "sala doble", 2, 3);

insert into cupon values (1, " el criterio es tal", "la descripcion es x", 0.8, '2022/06/19');
insert into cupon values (2, " el criterio es tal", "la descripcion es x", 0.9, '2022/01/19');
insert into cupon values (3, " el criterio es tal", "la descripcion es x", 0.2, '2022/05/19');
insert into cupon values (4, " el criterio es tal", "la descripcion es x", 0.5, '2022/12/19');
insert into cupon values (5, " el criterio es tal", "la descripcion es x", 0.4, '2022/05/26');

insert into horario values (1, '2022-11-09', '2001-12-25 00:00:00.000','2022-11-09', '2001-12-25 00:00:00.000');
insert into horario values (2, '2022-11-09', '2001-12-25 00:00:00.000','2022-11-09', '2001-12-25 00:00:00.000');
insert into horario values (3, '2022-11-09', '2001-12-25 00:00:00.000','2022-11-09', '2001-12-25 00:00:00.000');
insert into horario values (4, '2022-11-09', '2001-12-25 00:00:00.000','2022-11-09', '2001-12-25 00:00:00.000');
insert into horario values (5, '2022-11-09', '2001-12-25 00:00:00.000','2022-11-09', '2001-12-25 00:00:00.000');
/*
    Inserto funciones en el siguiente orden
    Codigo de funcion
    Precio de la funcion
    Horario codigo
    Pelicula codigo
    Sala código
 */

/*
insert into funcion values (1, 3400, 1, 3, 2);
insert into funcion values (2, 7400, 2, 2, 3);
insert into funcion values (3, 13400, 3, 1, 4);
insert into funcion values (4, 15400, 3, 4, 4);
insert into funcion values (5, 2500, 4, 5, 1);
*/

/*
    Inserto compras en el siguiente orden
    Codigo de compra
    Fecha de la compra
    Medio de pago
    Valor total de la compra
    Cédula del cliente
    Código de la función
 */
insert into funcion values (1, 3400, 1, 3, 2);
insert into funcion values (2, 7400, 2, 2, 3);
insert into funcion values (3, 13400, 3, 1, 4);
insert into funcion values (4, 15400, 3, 4, 4);
insert into funcion values (5, 2500, 4, 5, 1);

insert into confiteria values (1, "crispetas grandes", 32500, "url_imagen");
insert into confiteria values (2, "crispetas medianas", 25500, "url_imagen");
insert into confiteria values (3, "crispetas pequeñas", 12500, "url_imagen");
insert into confiteria values (4, "chocolatina pequeña", 3000, "url_imagen");
insert into confiteria values (5, "paquete de papas grande", 12500, "url_imagen");

