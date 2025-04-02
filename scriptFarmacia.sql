create database bd_farmacia;
use bd_farmacia;

create table proveedores(
	idProveedor INT AUTO_INCREMENT PRIMARY KEY, 
    NombreProveedor VARCHAR(100) NOT NULL,
    numProveedor varchar(10) not null,
    correo varchar (50),
    Encargado varchar (100) not null,
    pais varchar(30) not null,
    imagenes varchar(100)
);
INSERT INTO proveedores (NombreProveedor, numProveedor, correo, Encargado, pais, imagenes) VALUES
('Farmacéuticos del Sur', 'PS-001', 'contacto@farmaceuticosdelsur.com', 'Juan Pérez', 'México','proveedor1.jpg'),
('Distribuidora Medilife', 'ML-002', 'info@medilife.com', 'María González', 'Colombia','proveedores2.png'),
('Salud Integral S.A.', 'SI-003', 'ventas@saludintegral.com', 'Carlos Ramírez', 'Argentina','proveedores3.png'),
('Droguería Central', 'DC-004', 'drogueria@central.com', 'Ana López', 'Chile','proveedores4.png'),
('Vital Pharma Solutions', 'VPS-005', 'vitalpharma@soluciones.com', 'Luis Fernández', 'Perú','proveedores5.png'),
('RedMed Proveedores', 'RMP-006', 'contacto@redmed.com', 'Sofía Martínez', 'Ecuador','proveedores6.png'),
('Suministros de Salud Global', 'SSG-007', 'suministros@saludglobal.com', 'José Rodríguez', 'España','proveedor7.jpg');

CREATE TABLE Categorias (
    idCategoria INT AUTO_INCREMENT PRIMARY KEY,
    nombreCategoria VARCHAR(50) NOT NULL
);

insert into categorias (nombreCategoria) values
('Medicamentos'),
('Vitaminas'),
('Ampoyas'),
('Cuidado Personal');


create table producto(
    codigoProducto INT AUTO_INCREMENT PRIMARY KEY, 
    nombreProducto VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),                    -- Descripción del producto
    precio DECIMAL(5, 2),                       -- Precio del producto
    cantidadStock INT,                           -- Cantidad en stock
    cantidadMinima INT,                          -- Cantidad mínima en stock
    idCategoria INT,
    marca VARCHAR(100),                          -- Marca del producto
    idProveedor int,                      
    fechaIngreso DATE,                           -- Fecha de ingreso al inventario
    fechaVencimiento DATE,                       -- Fecha de vencimiento (si aplica)
    descuento DECIMAL(5, 2),
    imagen VARCHAR(200),
	constraint fkProveedor foreign key(idProveedor) references proveedores(idProveedor),
    constraint fkcategoria foreign key(idCategoria) references Categorias(idCategoria)
);
INSERT INTO producto (nombreProducto, descripcion, precio, cantidadStock, cantidadMinima, idCategoria, marca, idProveedor, fechaIngreso, fechaVencimiento, descuento, imagen) 
VALUES
( 'Paracetamol 500mg', 'Alivia el dolor y reduce la fiebre', 3.50, 100, 10, 1, 'Genfar', 1, '2024-01-01', '2025-01-01', 10.00, 'Paracetamol500.jpeg'),
( 'Vitamina C 1000mg', 'Refuerza el sistema inmunológico', 15.00, 50, 5, 2, 'Pharmaton', 3, '2024-02-01', '2026-02-01', 5.00, 'vitaminaC.jpeg'),
( 'Ampicilina 500mg', 'Antibiótico de amplio espectro', 20.00, 30, 5, 3, 'Lafrancol', 2, '2024-03-01', '2025-03-01', 15.00, 'ampicilina500.jpeg'),
( 'Crema Humectante', 'Cuidado de la piel seca', 25.00, 20, 2, 4, 'Nivea', 5, '2024-04-01', '2025-04-01', 8.00, 'cremaHumectante.jpg'),
('Ibuprofeno 200mg', 'Antiinflamatorio y analgésico', 8.00, 120, 10, 1, 'Bayer', 4, '2024-05-01', '2025-05-01', 12.00, 'ibuprofeno200.jpeg'),
( 'Vitamina D3 400UI', 'Favorece la absorción de calcio', 18.00, 40, 5, 2, 'Centrum', 6, '2024-06-01', '2026-06-01', 10.00, 'vitaminaD3.jpeg'),
('Diclofenaco 50mg', 'Reduce inflamaciones y dolores', 5.00, 70, 10, 1, 'Sandoz', 3, '2024-07-01', '2025-07-01', 5.00, 'diclofenaco.jpg'),
('Ampolla de Vitamina B12', 'Suplemento para el sistema nervioso', 30.00, 25, 5, 3, 'Pfizer', 7, '2024-08-01', '2025-08-01', 20.00, 'AmpollaVitaminaB12.jpg'),
( 'Shampoo Anticaspa', 'Previene la caspa y cuida el cabello', 22.00, 15, 3, 4, 'Head & Shoulders', 2, '2024-09-01', '2025-06-01', 10.00, 'medicasp.jpg'),
('Amoxicilina 500mg', 'Antibiótico para infecciones bacterianas', 12.00, 90, 10, 3, 'MK', 1, '2024-10-01', '2025-10-01', 5.00, 'amocixilina50.jpg'),
( 'Protector Solar FPS 50', 'Protección contra rayos UV', 45.00, 10, 2, 4, 'La Roche-Posay', 5, '2024-11-01', '2026-07-06', 15.00, 'protectorSolar.jpg'),
( 'Antihistamínico Loratadina', 'Alivia alergias y rinitis', 7.00, 80, 10, 1, 'Sanofi', 3 , '2024-12-01', '2025-12-01', 8.00, 'AntihistamínicoLoratadina.jpg'),
( 'Calcio + Vitamina D', 'Fortalece los huesos y dientes', 28.00, 35, 5, 2, 'GNC', 5, '2024-01-15', '2026-01-15', 10.00, 'calcioVitaminaD.jpg'),
( 'Ampolla de Hierro', 'Previene la anemia por deficiencia de hierro', 35.00, 20, 5, 3, 'Abbott', 2, '2024-02-15', '2025-02-15', 18.00, 'AmpolladeHierro.jpg'),
( 'Crema Facial Antiedad', 'Reduce arrugas y líneas de expresión', 60.00, 10, 2, 4, 'Olay', 3, '2024-03-15', '2026-04-01', 20.00, 'antiedad.jpg');

select * from producto;


create table venta(
	codVenta INT AUTO_INCREMENT PRIMARY KEY,
    codUsuario int,
    fecha date,
    constraint fk_usuario foreign key (codUsuario) references users(id)
);

create table detalleVenta(
	idDetVenta int auto_increment primary key,
	codVenta int not null,
    codProducto int not null,
    nombreProducto VARCHAR(100) not null, 
    cantidad int not null ,
    precio DECIMAL(5, 2) not null,
    descuento DECIMAL(5, 2),
    importe decimal(10,2) not null,
    constraint fk_venta foreign key (codVenta) references venta(codVenta),
    constraint fk_producto foreign key (codProducto) references producto(codigoProducto)
);




create table carritoCompra(
	idCarrito int auto_increment primary key,
    idUsuario int not null,
    codProducto int not null,
    nombreProducto VARCHAR(100) not null, 
    cantidad int not null ,
    precio DECIMAL(5, 2) not null,
    descuento DECIMAL(5, 2),
    marca varchar(100) not null,
    fechaVencimiento DATE not null, 
    imagen VARCHAR(200) not null
);
select * from carritoCompra;

-- PROCESOS ALMACENADOS
DELIMITER //
create procedure sp_listadoProductos(in p_idCategoria int)
begin
 
select T1.codigoProducto,T1.nombreProducto,T1.descripcion, T1.precio, T1.cantidadStock,
 T1.cantidadMinima, T1.idCategoria,T2.nombreCategoria, T1.marca, T1.idProveedor,T3.NombreProveedor,
 T1.fechaIngreso, T1.fechaVencimiento, T1.descuento, T1.imagen
 
from producto T1
 
inner join categorias T2 on T1.idCategoria = T2.idCategoria
inner join proveedores T3 on t1.idProveedor = T3.idProveedor
 
where T1.idCategoria = p_idCategoria;
end//
DELIMITER ;

DELIMITER //
create procedure sp_listadoProductosGeneral()
begin
 
select T1.codigoProducto,T1.nombreProducto,T1.descripcion, T1.precio, T1.cantidadStock,
 T1.cantidadMinima, T1.idCategoria,T2.nombreCategoria, T1.marca, T1.idProveedor,T3.NombreProveedor,
 T1.fechaIngreso, T1.fechaVencimiento, T1.descuento, T1.imagen
 
from producto T1
 
inner join categorias T2 on T1.idCategoria = T2.idCategoria
 inner join proveedores T3 on t1.idProveedor = T3.idProveedor;
end//
DELIMITER ;
call sp_listadoProductosGeneral();

DELIMITER //
create procedure sp_obtenerProductos(in p_codProducto int)
begin
 
select T1.codigoProducto,T1.nombreProducto,T1.descripcion, T1.precio, T1.cantidadStock,
 T1.cantidadMinima, T1.idCategoria,T2.nombreCategoria, T1.marca, T1.idProveedor,T3.NombreProveedor,
 T1.fechaIngreso, T1.fechaVencimiento, T1.descuento, T1.imagen
from producto T1
inner join categorias T2 on T1.idCategoria = T2.idCategoria
 inner join proveedores T3 on T1.idProveedor = T3.idProveedor
where T1.codigoProducto = p_codProducto;
end//
DELIMITER ;


-- procedimiento para eliminar producto
DELIMITER //
create procedure sp_eliminarProducto(in sp_codProducto int)
begin
delete from producto 
where codigoProducto = sp_codProducto;
end//
DELIMITER ;



DELIMITER //
create procedure sp_modificarProducto(in sp_codProducto int,
in nom  VARCHAR(100),
in descrip VARCHAR(255),
in precio DECIMAL(5, 2), 
in stock INT,
in min INT,
in idcate INT,
in marca VARCHAR(100),
in prov INT,
in fingreso DATE,
in fvenci DATE,
in descu DECIMAL(5, 2),
in imagen varchar(200))
begin
UPDATE PRODUCTO SET nombreProducto =nom,
					descripcion = descrip,
					precio = precio,
					cantidadStock  = stock,
					cantidadMinima = min,
					idCategoria = idcate,
					marca = marca,
					idProveedor =prov,
					fechaIngreso = fingreso,
					fechaVencimiento = fvenci,
					descuento = descu,
					imagen = imagen
WHERE codigoProducto = sp_codProducto;
end//
DELIMITER;

DELIMITER //
create procedure sp_listadoProducDscto(in p_dscto DECIMAL(5, 2))
begin
 
select T1.codigoProducto,T1.nombreProducto,T1.descripcion, T1.precio, T1.cantidadStock,
 T1.cantidadMinima, T1.idCategoria,T2.nombreCategoria, T1.marca, T1.idProveedor,T3.idProveedor,
 T1.fechaIngreso, T1.fechaVencimiento, T1.descuento, T1.imagen
 
from producto T1
 
inner join categorias T2 on T1.idCategoria = T2.idCategoria
 inner join proveedores T3 on T1.idProveedor = T3.idProveedor
where T1.descuento > p_dscto;
end//
DELIMITER ;


-- procedimiento para eliminar producto del carrito
DELIMITER //
create procedure sp_eliminarProducCarrito(in sp_codcarrito int)
begin
delete from carritocompra 
where idCarrito = sp_codcarrito;
end//
DELIMITER ;



-- inicio
DELIMITER //
CREATE PROCEDURE sp_ActualizarStockCompra(in sp_codPro int,in sp_cantidad int)
begin
	  UPDATE Producto T1
    SET T1.cantidadstock = T1.cantidadstock - sp_cantidad
    WHERE T1.codigoProducto = sp_codPro;
end//
DELIMITER ;
call sp_ActualizarStockCompra(13,3);
select * from producto;
select * from detalleventa;
-- fin

-- listado carrito por cliente
DELIMITER //
create procedure sp_listadoCarritoCliente(in sp_cliente int)
begin
 
select idCarrito,idUsuario,codProducto ,nombreProducto ,
 cantidad , precio,descuento, marca, fechaVencimiento,  imagen 
 
from carritocompra 
where idUsuario = sp_cliente;
end//
DELIMITER ;
call sp_listadoCarritoCliente(1);

DELIMITER //
create procedure sp_EliminarCarritoCliente(in sp_cliente int)
begin
SET SQL_SAFE_UPDATES= 0;
delete from carritocompra 
where idUsuario = sp_cliente;
 SET SQL_SAFE_UPDATES= 1;
end//
DELIMITER ;
call sp_EliminarCarritoCliente(2);

DELIMITER //
CREATE PROCEDURE sp_MantenimientoStock(in sp_codPro int,in sp_cantidad int)
begin
	  UPDATE Producto T1
    SET T1.cantidadstock = T1.cantidadstock + sp_cantidad
    WHERE T1.codigoProducto = sp_codPro;
end//
DELIMITER ;

-- REPORTES
CREATE TABLE Reporte (
    idReporte INT AUTO_INCREMENT PRIMARY KEY,
    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
    totalVentas DECIMAL(10, 2),
    cantidadVentas INT,
    productosVendidos INT
);

DELIMITER //
CREATE PROCEDURE sp_generarReporteYGuardar(
    IN p_fechaInicio DATE,
    IN p_fechaFin DATE
)
BEGIN
    -- Calcular los datos del reporte
    INSERT INTO Reporte (fechaInicio, fechaFin, totalVentas, cantidadVentas, productosVendidos)
    SELECT 
        p_fechaInicio AS fechaInicio,
        p_fechaFin AS fechaFin,
        SUM(dv.importe) AS totalVentas, -- Total de ingresos
        COUNT(DISTINCT v.codVenta) AS cantidadVentas, -- Número de ventas
        SUM(dv.cantidad) AS productosVendidos         -- Cantidad de productos vendidos
    FROM venta v
    INNER JOIN detalleVenta dv ON v.codVenta = dv.codVenta
    WHERE v.fecha BETWEEN p_fechaInicio AND p_fechaFin; -- Filtrar por fechas
END //
DELIMITER ;


CALL sp_generarReporteYGuardar('2024-12-01', '2024-12-31');
SELECT * FROM Reporte; 


CREATE TABLE ReporteMayVentas (
    idReporte INT AUTO_INCREMENT PRIMARY KEY,
    idProducto INT NOT NULL,
    nombreProducto VARCHAR(100) NOT NULL,
    cantidadVendida INT NOT NULL,
    totalGenerado DECIMAL(10,2) NOT NULL
);

DELIMITER //
CREATE PROCEDURE sp_generarReporteProductosMasVendidos(
    IN p_fechaInicio DATE,
    IN p_fechaFin DATE
)
BEGIN
    -- Insertar los productos vendidos entre las fechas especificadas
    INSERT INTO ReporteMayVentas (idProducto, nombreProducto, cantidadVendida, totalGenerado)
    SELECT 
        p.codigoProducto AS idProducto,
        p.nombreProducto,
        SUM(dv.cantidad) AS cantidadVendida,
        SUM(dv.precio * dv.cantidad) AS totalGenerado
    FROM detalleVenta dv
    INNER JOIN producto p ON dv.codProducto = p.codigoProducto
    INNER JOIN venta v ON dv.codVenta = v.codVenta
    WHERE v.fecha BETWEEN p_fechaInicio AND p_fechaFin
    GROUP BY p.codigoProducto, p.nombreProducto
    ORDER BY cantidadVendida DESC;
END //
DELIMITER ;

CALL sp_generarReporteProductosMasVendidos('2024-12-01', '2024-12-31');
SELECT * FROM ReporteMayVentas;





CREATE PROCEDURE sp_obtenerReporteDinamico(
    IN p_fechaInicio DATE,
    IN p_fechaFin DATE
)
BEGIN
    -- Generar el reporte dinámicamente sin insertar en la tabla
    SELECT 
        p_fechaInicio AS fechaInicio,
        p_fechaFin AS fechaFin,
        SUM(dv.cantidad * dv.precio) AS totalVentas, -- Total de ingresos
        COUNT(DISTINCT v.codVenta) AS cantidadVentas, -- Número de ventas
        SUM(dv.cantidad) AS productosVendidos         -- Cantidad de productos vendidos
    FROM venta v
    INNER JOIN detalleVenta dv ON v.codVenta = dv.codVenta
    WHERE v.fecha BETWEEN p_fechaInicio AND p_fechaFin -- Filtrar por fechas
END //

DELIMITER ;



 SELECT SUM(dv.cantidad * dv.precio) AS totalVentas, COUNT(DISTINCT v.codVenta) AS cantidadVentas, SUM(dv.cantidad) AS productosVendidos  FROM venta as v INNER JOIN detalleVenta dv ON v.codVenta = dv.codVenta  WHERE v.fecha BETWEEN '2024-11-01' AND '2024-11-19';



-- CRUD PROVEEDORES
DELIMITER //
create procedure sp_eliminarProveedores(in sp_codProv int)
begin
delete from proveedores 
where idProveedor = sp_codProv;
end//
DELIMITER ;


DELIMITER //

CREATE PROCEDURE sp_modificarProveedor(
    IN sp_idProv INT,
    IN nom VARCHAR(100),
    IN numero VARCHAR(10),
    IN hotmail VARCHAR(50),
    IN encargado VARCHAR(100),
    IN pais VARCHAR(30),
    IN imagen VARCHAR(100)
)
BEGIN
    UPDATE proveedores 
    SET NombreProveedor = nom,
        numProveedor = numero,
        correo = hotmail,
        encargado = encargado,
        pais = pais,
        imagenes = imagen
    WHERE idProveedor = sp_idProv;
END//

DELIMITER ;
call sp_modificarProveedor(1,'Farmacéuticos del norte','96851452','farma@hotmail.com','Juan Delgado','Peru','proveedor1.jpg');
select * from Proveedores;

DELIMITER //
create procedure sp_obtenerProveedores(in p_codProv int)
begin
 
select *
from proveedores
where idProveedor = p_codProv;
end//
DELIMITER ;
call sp_obtenerProveedores(1);


-- usuario
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role ENUM('user', 'admin') NOT NULL
);

-- Insertar algunos usuarios con rol 'user' y solo un administrador
INSERT INTO users (name, email, password, role) VALUES
('Carlos', 'carlos@example.com', 'password456', 'user'),
('Pedro', 'pedro@example.com', 'password321', 'user'),
('Sofia', 'sofia@example.com', 'password987', 'user'),
('Andrés', 'andres@example.com', 'password654', 'user'),
('Lucía', 'lucia@example.com', 'password852', 'user'),
('David', 'david@example.com', 'password159', 'user'),
('Eva', 'eva@example.com', 'password753', 'user'),
('Juan', 'juan@example.com', 'password951', 'user');


INSERT INTO users (name, email, password, role)
SELECT 'Admin', 'admin@example.com', 'adminpass', 'admin'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE role = 'admin');


SELECT * FROM users;

-- CRUD CLIENTES
DELIMITER //
create procedure sp_listadoCliente(in sp_rol varchar(10))
begin
select * from users 
where role = sp_rol;
end//
DELIMITER ;
call sp_listadoCliente("user");

-- modificarr
DELIMITER //

CREATE PROCEDURE sp_modificarCliente(
    IN sp_id INT,
    IN name VARCHAR(50),
    IN hotmail VARCHAR(50),
    IN pasword VARCHAR(100)
)
BEGIN
    UPDATE users 
    SET name = name,
        email = hotmail,
        password = pasword
    WHERE id = sp_id;
END//

DELIMITER ;

DELIMITER //
create procedure sp_obtenerClientes(in p_idCliente int)
begin
select *
from users
where id = p_idCliente;
end//
DELIMITER ;
CALL sp_obtenerClientes(2);


DELIMITER //
create PROCEDURE sp_obtenerReporte(IN p_fechaIncio date, IN p_fechaFin date)
BEGIN
	SELECT 
        p.codigoProducto AS idProducto,
        p.nombreProducto,
        SUM(dv.cantidad) AS cantidadVendida,
        SUM(dv.precio * dv.cantidad) AS totalGenerado
    FROM detalleVenta dv
    INNER JOIN producto p ON dv.codProducto = p.codigoProducto
    INNER JOIN venta v ON dv.codVenta = v.codVenta
    WHERE v.fecha between p_fechaIncio and p_fechaFin
    GROUP BY p.codigoProducto, p.nombreProducto
    ORDER BY cantidadVendida DESC;
    END//
    DELIMITER ;
    
    CALL sp_obtenerReporte('2024-12-01', '2024-12-31');