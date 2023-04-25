insert into ciudad
values

--codigo,nombre

(1, 'Bogota'),
(2, 'Medellin'),
(3, 'Cali'),
(4, 'Barranquilla'),
(5, 'Cartagena');





insert into licencia
values

--codigo,dias_activo_producto,nombre,prioridad

(1, 30, 'Licencia Básica', 5000.0, 3),
(2, 90, 'Licencia Estándar', 3080000.00, 3),
(3, 365, 'Licencia Premium', 200000.00, 10),
(4, 7, 'Licencia de Prueba', 0.0, 4),
(5, 180, 'Licencia Avanzada', 100000.00, 7);

insert into usuario
values

--codigo,activo,cedula,direccion,email,fechanacimeinto,nombre,password,telefono,usen_name,ciudadCodigo,liencia_codigo,role_codigo


(1, 1, '1234567890', 'Calle 1 #123', 'usuario1@example.com',"CLIENTE", '1990-01-01', 'Usuario 1', '$2a$10$oeyqNNdUQ/fzOjdPcHMSNODnhEzYRW84ZrMqulWxXRbgjxSFRgywq', '1234567890', 'usuario1', 1,  1),
(2, 1, '2345678901', 'Calle 2 #456','usuario2@example.com', "CLIENTE", '1995-02-15', 'Usuario 2', '$2a$10$oeyqNNdUQ/fzOjdPcHMSNODnhEzYRW84ZrMqulWxXRbgjxSFRgywq', '2345678901', 'usuario2', 2,  2),
(3, 1, '3456789012', 'Calle 3 #789', 'usuario3@example.com',"CLIENTE",  '1988-05-20', 'Usuario 3', '$2a$10$oeyqNNdUQ/fzOjdPcHMSNODnhEzYRW84ZrMqulWxXRbgjxSFRgywq', '3456789012', 'usuario3', 3,  3),
(4, 1, '4567890123', 'Calle 4 #012','usuario4@example.com', "MODERADOR", '1992-11-11', 'Usuario 4', '$2a$10$oeyqNNdUQ/fzOjdPcHMSNODnhEzYRW84ZrMqulWxXRbgjxSFRgywq', '4567890123', 'usuario4', 4,  4),
(5, 0, '5678901234', 'Calle 5 #345', 'usuario5@example.com',"MODERADOR", '2000-06-30', 'Usuario 5', '$2a$10$oeyqNNdUQ/fzOjdPcHMSNODnhEzYRW84ZrMqulWxXRbgjxSFRgywq', '5678901234', 'usuario5', 5, 5);








INSERT INTO tarjeta
VALUES

    --(codigo,cvv, dinero, estado, fecha, nombre, numero, tipo)



    (1,'123', 50000, 'INACTIVA', '2022-01-01', 'Juan Perez', '1234567812345678', 'DEBITO'),
    (2,'456', 100000, 'ACTIVA', '2022-02-01', 'Maria Rodriguez', '2345678923456789', 'CREDITO'),
    (3,'789', 75000, 'REPORTADO', '2022-03-01', 'Pedro Gomez', '3456789034567890', 'DEBITO'),
    (4,'012', 25000, 'ACTIVA', '2022-04-01', 'Laura Sanchez', '4567890145678901', 'CREDITO'),
    (5,'345', 60000, 'INACTIVA', '2022-05-01', 'Jorge Martinez', '5678901256789012', 'DEBITO');



INSERT INTO tarjeta_usuario
VALUES

    --tarjeta_codigo,usuario_codigo

    (1,2),
    (2,1),
    (3,1),
    (3,1),
    (1,1);


INSERT INTO venta
VALUES

    -- (codigo,estado, fecha_compra, metodo_pago, total_compra, tajeta_compra_codigo)
    (1,'CARRITO',   '2023-03-01', 'EFECTIVO',  50000, 1,1),
    (2,'ENTREGADO', '2023-03-02', 'DAVIPLATA', 75000, 2,2),
    (6,'CARRITO',   '2023-03-04', 'TARJETA', 125000,4,3),
    (4,'ENTREGADO',   '2023-03-04', 'TARJETA', 125000,3,4),
    (5,'CARRITO',     '2023-03-05', 'EFECTIVO',150000,5,1);





insert into producto
values
---------------------------------toca organizar la descripcion---------------------------------------------------
    -- codigo, descripcion,  disponibilidad,estado, fecha_limite,  nombre,   precio_unitario,  unidades,  usuario_propietario_codigo, venta_producto_codigo,

    (1, 'Televisor LED 55', true,          'ACTIVE', '2024-04-01', 'Televisor LG', 799.99, 9, 9, 1 ),
    (2, 'Auriculares inalámbricos', true, 'ACTIVE', '2024-04-01', 'Auriculares Sony', 149.99,3, 20, 2),
    (3, 'Mesa de comedor',      true,     'INACTIVE', '2023-12-31', 'Mesa de madera', 299.99, 9, 7, 3),
    (4,  'Libro de cocina',          true,  'ACTIVE', '2024-04-01', 'La cocina italiana', 29.99, 5, 5, 4),
    (5, 'Monitor de computadora',  true,  'ACTIVE', '2025-01-01', 'Monitor Samsung', 299.99, 7, 2, 1 ),
    (6, 'Smartphone samsung pro',  true,  'ACTIVE', '2025-01-01', 'Celular Samsung S22', 599.99, 2, 5, 1 );


INSERT INTO detalle_venta
    --(precio, unidades, venta_codigo, producto)
VALUES

    (1,799.99, 2, 1,1),
    (2,799.99, 1, 1,2),
    (3,149.99, 3, 2,6),
    (4,299.99, 1, 5,4),
    (5, 599.99, 2, 4,5);

insert into comentario
values

--codigo,comnetario,fecha,producto_codigo,usuario_codigo

(1, "Me encantó este producto, definitivamente lo recomiendo.", "2022-03-01", 1, 1),
(2, 'No me gustó la calidad de este producto, esperaba algo mejor.', '2022-03-05', 2, 2),
(3, 'Excelente servicio al cliente, me ayudaron con todas mis dudas.', '2022-03-10', 3, 3),
(4, 'El envío tardó más de lo esperado, pero el producto en sí es bueno.', '2022-03-15', 4, 4),
(5, 'Este producto superó mis expectativas, definitivamente lo volvería a comprar.', '2022-03-20', 5, 5);







INSERT INTO producto_imagenes
VALUES

-- (producto_codigo, imagenes, imagenes_key)
(1, 'https://example.com/image1.jpg', 'image1'),
(2, 'https://example.com/image2.jpg', 'image2'),
(3, 'https://example.com/image3.jpg', 'image3'),
(4, 'https://example.com/image4.jpg', 'image4'),
(5, 'https://example.com/image5.jpg', 'image5');




INSERT INTO producto_categorias
VALUES
    (1, 'ROPA'),
    (2, 'CALZADO'),
    (3, 'ELECTRODOMESTICO'),
    (4, 'ROPA'),
    (5, 'CALZADO');



INSERT INTO  usuario_producto_favoritos

VALUES

    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);
