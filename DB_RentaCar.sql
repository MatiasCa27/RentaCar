DROP DATABASE IF EXISTS RentaCar;
CREATE DATABASE RentaCar;
USE RentaCar;

-- ==========================================================
-- 1. MS-UBICACIONES
-- ==========================================================

CREATE TABLE Region (
    id_region BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_region VARCHAR(50) NOT NULL
);

CREATE TABLE Comuna (
    id_comuna BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_comuna VARCHAR(50) NOT NULL,
    id_region BIGINT NOT NULL,
    CONSTRAINT fk_comuna_region
        FOREIGN KEY (id_region) REFERENCES Region(id_region)
);

-- ==========================================================
-- 2. MS-CATALOGO
-- ==========================================================

CREATE TABLE Marca (
    id_marca INT AUTO_INCREMENT PRIMARY KEY,
    nombre_marca VARCHAR(50) NOT NULL
);

CREATE TABLE Auto (
    p_auto VARCHAR(6) PRIMARY KEY,
    modelo_auto VARCHAR(50) NOT NULL,
    valor_diario DECIMAL(12,2),
    id_marca INT NOT NULL,
    CONSTRAINT fk_auto_marca
        FOREIGN KEY (id_marca) REFERENCES Marca(id_marca)
);

-- ==========================================================
-- 3. MS-CLIENTES
-- ==========================================================

CREATE TABLE Clientes (
    id_cliente BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    rut VARCHAR(12) UNIQUE NOT NULL,
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

-- ==========================================================
-- 4. MS-EMPLEADOS
-- ==========================================================

CREATE TABLE EstadoCivil (
    id_estado_civil BIGINT AUTO_INCREMENT PRIMARY KEY,
    desc_estado_civil VARCHAR(50) NOT NULL
);

CREATE TABLE Sucursal (
    id_sucursal BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_sucursal VARCHAR(100) NOT NULL,
    id_comuna_ref BIGINT
);

CREATE TABLE Empleado (
    numrun_emp BIGINT PRIMARY KEY,
    dvrun_emp VARCHAR(1),
    nombre_emp VARCHAR(100) NOT NULL,
    appaterno_emp VARCHAR(100),
    sueldo_base DECIMAL(12,2),
    id_estado_civil BIGINT NOT NULL,
    id_sucursal BIGINT NOT NULL,
    CONSTRAINT fk_empleado_estado_civil
        FOREIGN KEY (id_estado_civil) REFERENCES EstadoCivil(id_estado_civil),
    CONSTRAINT fk_empleado_sucursal
        FOREIGN KEY (id_sucursal) REFERENCES Sucursal(id_sucursal)
);

-- ==========================================================
-- 5. MS-RENTA
-- ==========================================================

CREATE TABLE RentaAuto (
    id_renta BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_inicio DATE NOT NULL,
    dias_renta INT NOT NULL,
    monto_total DECIMAL(12,2) NOT NULL,
    rut_cliente_ref BIGINT NOT NULL,
    patente_auto_ref VARCHAR(6) NOT NULL
);

-- ==========================================================
-- 6. MS-PAGOS
-- ==========================================================

CREATE TABLE Pago (
    id_pago BIGINT AUTO_INCREMENT PRIMARY KEY,
    monto DECIMAL(12,2) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    id_renta_ref BIGINT NOT NULL
);

-- ==========================================================
-- 7. MS-INSPECCION
-- ==========================================================

CREATE TABLE Inspeccion (
    id_inspeccion BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_inspeccion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_inspeccion VARCHAR(20) NOT NULL,
    kilometraje INT,
    nivel_combustible VARCHAR(20),
    observaciones_danos VARCHAR(500),
    id_renta_ref BIGINT NOT NULL
);

-- ==========================================================
-- 8. MS-MANTENIMIENTO
-- ==========================================================

CREATE TABLE Mantenimiento (
    id_mantenimiento BIGINT AUTO_INCREMENT PRIMARY KEY,
    motivo VARCHAR(200) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    fecha_salida DATE,
    costo_reparacion DECIMAL(12,2),
    patente_auto_ref VARCHAR(6) NOT NULL
);

-- ==========================================================
-- 9. MS-TARIFAS
-- ==========================================================

CREATE TABLE Tarifa (
    id_tarifa BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL,
    valor_por_dia DECIMAL(12,2) NOT NULL,
    id_tipo_auto_ref BIGINT
);