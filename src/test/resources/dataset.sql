insert into ciudad
values

--codigo,nombre

    (1, 'Bogotá'),
    (2, 'Medellín'),
    (3, 'Cali'),
    (4, 'Barranquilla'),
    (5, 'Cartagena');


INSERT INTO role
    values

        --codigo,nombre

    (1, 'Administrador'),
    (2, 'Vendedor'),
    (3, 'Comprador'),
    (4, 'Comprador'),
    (5, 'Comprador');





insert into licencia
values

--codigo,dias_activo_producto,nombre,prioridad

(1, 30, 'Licencia Básica', 3),
(2, 90, 'Licencia Estándar', 2),
(3, 365, 'Licencia Premium', 1),
(4, 7, 'Licencia de Prueba', 4),
(5, 180, 'Licencia Avanzada', 2);

insert into Usuario
values

--codigo,activo,cedula,direccion,email,fechanacimeinto,nombre,password,telefono,usen_name,ciudadCodigo,liencia_codigo,role_codigo


    (1, true, '1234567890', 'Calle 1 #123', 'usuario1@example.com', '1990-01-01', 'Usuario 1', 'password1', '1234567890', 'usuario1', 1, 1, 1),
    (2, true, '2345678901', 'Calle 2 #456', 'usuario2@example.com', '1995-02-15', 'Usuario 2', 'password2', '2345678901', 'usuario2', 2, 2, 2),
    (3, true, '3456789012', 'Calle 3 #789', 'usuario3@example.com', '1988-05-20', 'Usuario 3', 'password3', '3456789012', 'usuario3', 3, 3, 3),
    (4, true, '4567890123', 'Calle 4 #012', 'usuario4@example.com', '1992-11-11', 'Usuario 4', 'password4', '4567890123', 'usuario4', 4, 4, 4),
    (5, false, '5678901234', 'Calle 5 #345', 'usuario5@example.com', '2000-06-30', 'Usuario 5', 'password5', '5678901234', 'usuario5', 5, 5, 5);

