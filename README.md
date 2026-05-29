# RentaCar

## Descripción del proyecto

RentaCar es una aplicación orientada a la gestión y automatización de procesos para un negocio de arriendo de vehículos. Su objetivo principal es optimizar la administración de clientes, vehículos, pagos, rentas y demás operaciones asociadas al servicio.

---

## Versión del proyecto

* **Versión:** 1.0

---

## Equipo de desarrollo

* Matías Cabezas
* Cristóbal Montealegre
* José Valderrama

---

## Microservicios de negocio y rutas del Gateway

| Microservicio | Ruta                      |
| ------------- | ------------------------- |
| Catálogo      | `/api/v1/autos/`          |
| Clientes      | `/api/v1/clientes/`       |
| Empleados     | `/api/v1/empleados/`      |
| Inspección    | `/api/v1/inspecciones/`   |
| Mantenimiento | `/api/v1/mantenimientos/` |
| Pagos         | `/api/v1/pagos/`          |
| Renta         | `/api/v1/rentas/`         |
| Tarifas       | `/api/v1/tarifas/`        |
| Ubicaciones   | `/api/v1/ubicaciones/`    |

---

## Microservicios de infraestructura

* Gateway
* Eureka Server

---

# Instrucciones para ejecutar el proyecto

## 1. Ingresar a Eureka Server

Abrir el navegador y acceder a la siguiente URL:

```bash
http://localhost:8761
```

---

## 2. Levantar los microservicios

Ejecutar cada microservicio en el siguiente orden:

> **Nota:**
> Ejecutar la clase principal ubicada en:
>
> ```bash
> src/main/java/MS-ServerApplication.java
> ```

### Orden de ejecución

1. `ms-eureka-server`
2. `ms-gateway`
3. `ms-clientes`
4. `ms-catalogo`
5. `ms-tarifas`
6. `ms-empleados`
7. `ms-renta`
8. `ms-pagos`

---

## 3. Verificar el estado de los servicios

Comprobar en la interfaz de Eureka Server que todos los microservicios se encuentren en estado **UP**.

---

## 4. Probar la API con Postman

Realizar una solicitud GET de prueba:

```bash
http://localhost:8080/clientes/listar
```

---

## 5. Probar endpoints adicionales

Se pueden probar distintos métodos HTTP como:

* GET
* POST
* PUT
* DELETE

### Ejemplo:

```bash
GET http://localhost:8080/api/clientes
```

