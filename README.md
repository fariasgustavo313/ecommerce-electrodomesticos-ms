# 🛒 Tienda de Electrodomésticos - Sistema de Microservicios

## Descripción

Este proyecto es un ejemplo de arquitectura de microservicios para la gestión de una **tienda de electrodomésticos online**, desarrollado en Java con tecnologías de Spring Cloud, Eureka, Docker y más. Cada funcionalidad principal está desacoplada en un microservicio individual, permitiendo escalabilidad y mantenimiento sencillo. 

Pensado para prácticas académicas, portfolio o como base para sistemas distribuidos reales.

---

## Microservicios incluidos

- **eureka-server**: Registro y descubrimiento de servicios (Service Registry).
- **api-gateway**: Punto de entrada unificado, balanceo y ruteo a microservicios.
- **ms-usuarios**: Administración y CRUD de usuarios.
- **ms-productos**: Administración y CRUD de productos del catálogo.
- **ms-inventario**: Gestión del stock de productos.
- **ms-carrito**: Carritos de compra por usuario, agrega/quita productos.
- **ms-ventas**: Registro de ventas asociando usuarios, carritos y ajustando inventario.
- **ms-auditoria**: Registro de eventos/auditoría desde acciones de otros servicios.

---

## Tecnologías principales

- **Java 17**, **Spring Boot 3.x**
- **Spring Cloud 2022.x**
- **Spring Cloud Netflix Eureka** (Service Discovery)
- **Spring Cloud Gateway** (API Gateway/Reverse Proxy)
- **Spring Data JPA + H2 Database** (database en memoria para demos)
- **Spring Cloud OpenFeign** (comunicación declarativa entre MS)
- **Resilience4J** (Fault tolerance: Circuit Breaker/Retry)
- **Swagger/OpenAPI** (documentación de endpoints)
- **Docker & Docker Compose**

---

## Estructura del proyecto

```
microservicios/
│
├─ api-gateway/
├─ eureka-server/
├─ ms-auditoria/
├─ ms-carrito/
├─ ms-inventario/
├─ ms-productos/
├─ ms-usuarios/
├─ ms-ventas/
└─ docker-compose.yml
```
*Cada carpeta tiene su propio `Dockerfile`.*

---

## Ejecución (todos los servicios en Docker)

### 1. Compilación de servicios
En cada carpeta de microservicio, ejecuta:
```sh
mvn clean package -DskipTests
```
(Este comando genera el JAR necesario para el contenedor.)

### 2. Construcción y despliegue de contenedores
Colócate en la carpeta `/microservicios` y ejecuta:
```sh
docker-compose build
docker-compose up
```
Cuando todos los contenedores estén en funcionamiento verás los logs de Eureka y el registro de las instancias.

### 3. Acceso a los servicios principales
- **Eureka Dashboard:** [http://localhost:8761](http://localhost:8761)
- **API Gateway:** [https://localhost](https://localhost) (acepta el certificado)
- **Swagger UI de cada microservicio:**  
  - Ejemplo: `http://localhost:8081/swagger-ui.html` (ms-productos)
  - Reemplaza el puerto según el microservicio correspondiente
- **H2 Console:**  
  - Ejemplo: `http://localhost:8081/h2-console`
  - JDBC URL de ejemplo: `jdbc:h2:mem:productosdb`

---

## Ejemplos de flujo funcional

### 1. **Registro de usuario:**
```http
POST https://localhost/ms-usuarios/usuarios
{
  "nombre": "Ana Perez",
  "email": "ana@email.com",
  "direccion": "Calle Falsa 123"
}
```
### 2. **Registro de producto y su stock:**
```http
POST https://localhost/ms-productos/productos
{
  "codigo": "AA220",
  "nombre": "Microondas",
  "marca": "Philips",
  "precio": 65000
}
```
```http
POST https://localhost/ms-inventario/inventario
{
  "productoId": 1,
  "stock": 5
}
```
### 3. **Carrito: crear, agregar producto y recalcular total**
```http
POST https://localhost/ms-carrito/carrito
POST https://localhost/ms-carrito/carrito/{carritoId}/productos/{productoId}
PUT  https://localhost/ms-carrito/carrito/{carritoId}/recalcular-total
```

### 4. **Registrar venta**
```http
POST https://localhost/ms-ventas/ventas?carritoId={carritoId}&usuarioId={usuarioId}
```

### 5. **Auditoría: ver eventos**
```http
GET https://localhost/ms-auditoria/auditoria
```

---

## Detalles técnicos y mejores prácticas aplicadas

- Los servicios usan **Service Discovery** dinámico: se autodescubren por nombre mediante Eureka.
- Toda la comunicación REST entre microservicios se hace usando **OpenFeign** (por nombre de Eureka, nunca por IP directa).
- API Gateway enruta automáticamente a cada microservicio usando rutas del tipo `/ms-nombre/endpoint`.
- **Resilience4J** y **Spring Retry** implementan tolerancia a fallos y fallback en las comunicaciones Feign.
- Todos los microservicios están listos para balanceo de carga: si levantas varias instancias, las solicita alternadamente.
- **Variables de entorno** para URLs de Eureka y conexión, lo que facilita el despliegue en la nube o local.

---

## Notas y recomendaciones

- Al correr todo en Docker, la URL de Eureka es siempre `http://eureka-server:8761/eureka` dentro de cada contenedor.
- Puedes crear nuevos endpoints o ajustar los modelos **simplemente modificando los controladores y DTOs correspondientes**.
- La base H2 es temporal: para versiones productivas deberías apuntar a **MySQL/PostgreSQL** con perfil y variables.
- Swagger UI documenta todos los endpoints y permite hacer pruebas fácilmente.

---

## Endpoints de referencia (Gateway HTTPS)

| Microservicio      | Entity   | Path ejemplo                                |
|--------------------|----------|---------------------------------------------|
| ms-usuarios        | Usuario  | https://localhost/ms-usuarios/usuarios      |
| ms-productos       | Producto | https://localhost/ms-productos/productos    |
| ms-carrito         | Carrito  | https://localhost/ms-carrito/carrito        |
| ms-inventario      | Stock    | https://localhost/ms-inventario/inventario  |
| ms-ventas          | Venta    | https://localhost/ms-ventas/ventas          |
| ms-auditoria       | Auditoria| https://localhost/ms-auditoria/auditoria    |
| eureka-server      | -        | http://localhost:8761                       |
| api-gateway        | -        | https://localhost                           |

---

## Autor

**Gustavo Farias**  
<small>[LinkedIn](https://linkedin.com/in/gustavoef)</small>
