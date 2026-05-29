-- 1. Crear la Base de Datos (si no la creaste manualmente)
CREATE DATABASE IF NOT EXISTS RentaCar;
USE RentaCar;

-- ==========================================================
-- 1. MS-UBICACIONES
-- ==========================================================
CREATE TABLE REGION (
    ID_REGION INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE_REGION VARCHAR(50) NOT NULL
);

CREATE TABLE COMUNA (
    ID_COMUNA INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE_COMUNA VARCHAR(50) NOT NULL,
    ID_REGION INT NOT NULL,
    CONSTRAINT FK_COMUNA_REGION FOREIGN KEY (ID_REGION) REFERENCES REGION(ID_REGION)
);

-- ==========================================================
-- 2. MS-CATALOGO
-- ==========================================================
CREATE TABLE MARCA (
    ID_MARCA INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE_MARCA VARCHAR(50) NOT NULL
);

CREATE TABLE AUTO (
    PATENTE VARCHAR(10) PRIMARY KEY,
    MODELO VARCHAR(50) NOT NULL,
    VALOR_RENTA_DIA DECIMAL(12,2),
    ID_MARCA INT NOT NULL,
    CONSTRAINT FK_AUTO_MARCA FOREIGN KEY (ID_MARCA) REFERENCES MARCA(ID_MARCA)
);

-- ==========================================================
-- 3. MS-CLIENTES
-- ==========================================================
CREATE TABLE CLIENTE (
    ID_CLIENTE INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(100) NOT NULL,
    RUT VARCHAR(12) UNIQUE NOT NULL
);

-- ==========================================================
-- 4. MS-EMPLEADOS
-- ==========================================================
CREATE TABLE ESTADO_CIVIL (
    ID_ESTADO_CIVIL INT AUTO_INCREMENT PRIMARY KEY,
    DESC_ESTADO_CIVIL VARCHAR(50) NOT NULL
);

CREATE TABLE SUCURSAL (
    ID_SUCURSAL INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE_SUCURSAL VARCHAR(100) NOT NULL,
    ID_COMUNA_REF INT 
);

CREATE TABLE EMPLEADO (
    NUMRUN_EMP INT PRIMARY KEY,
    DVRUN_EMP VARCHAR(1),
    NOMBRE_EMP VARCHAR(100) NOT NULL,
    APPATERNO_EMP VARCHAR(100),
    SUELDO_BASE DECIMAL(12,2),
    ID_ESTADO_CIVIL INT,
    ID_SUCURSAL INT,
    CONSTRAINT FK_EMP_ESTADO FOREIGN KEY (ID_ESTADO_CIVIL) REFERENCES ESTADO_CIVIL(ID_ESTADO_CIVIL),
    CONSTRAINT FK_EMP_SUCURSAL FOREIGN KEY (ID_SUCURSAL) REFERENCES SUCURSAL(ID_SUCURSAL)
);

-- ==========================================================
-- 5. MS-RENTA
-- ==========================================================
CREATE TABLE RENTA (
    ID_RENTA INT AUTO_INCREMENT PRIMARY KEY,
    FECHA_INICIO DATETIME DEFAULT CURRENT_TIMESTAMP,
    DIAS_RENTA INT NOT NULL,
    MONTO_TOTAL DECIMAL(12,2),
    RUT_CLIENTE_REF INT,
    PATENTE_AUTO_REF VARCHAR(10)
);

-- ==========================================================
-- 6. MS-PAGOS
-- ==========================================================
CREATE TABLE PAGO (
    ID_PAGO INT AUTO_INCREMENT PRIMARY KEY,
    MONTO DECIMAL(12,2) NOT NULL,
    ESTADO VARCHAR(20), -- PENDIENTE, PAGADO
    ID_RENTA_REF INT
);

-- ==========================================================
-- 7. MS-INSPECCION
-- ==========================================================
CREATE TABLE INSPECCION (
    ID_INSPECCION INT AUTO_INCREMENT PRIMARY KEY,
    FECHA_INSPECCION TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    TIPO_INSPECCION VARCHAR(20),
    KILOMETRAJE INT,
    NIVEL_COMBUSTIBLE VARCHAR(20),
    OBSERVACIONES_DANOS VARCHAR(500),
    ID_RENTA_REF INT
);

-- ==========================================================
-- 8. MS-MANTENIMIENTO
-- ==========================================================
CREATE TABLE MANTENIMIENTO (
    ID_MANTENIMIENTO INT AUTO_INCREMENT PRIMARY KEY,
    MOTIVO VARCHAR(200) NOT NULL,
    FECHA_INGRESO DATE,
    FECHA_SALIDA DATE,
    COSTO_REPARACION DECIMAL(12,2),
    PATENTE_AUTO_REF VARCHAR(10)
);

-- ==========================================================
-- 9. MS-TARIFAS
-- ==========================================================
CREATE TABLE TARIFA (
    ID_TARIFA INT AUTO_INCREMENT PRIMARY KEY,
    DESCRIPCION VARCHAR(100),
    VALOR_POR_DIA DECIMAL(12,2) NOT NULL,
    ID_TIPO_AUTO_REF INT
);