# Restaurant Order System - Taller 6 ADS
Este proyecto implementa un sistema de gestión de pedidos para un restaurante, aplicando una arquitectura por capas y principios SOLID, junto con patrones de diseño.

## Arquitectura del Proyecto

El sistema está estructurado en **tres capas principales**:

---

### 1. **Dominio (`domain`)**
Contiene las entidades centrales del sistema y sus comportamientos. Es completamente independiente de cualquier tecnología externa.

- **Clases clave:**
  - `Customer`: representa un cliente del restaurante.
  - `MenuItem`: representa un ítem del menú (nombre, tipo, precio, etc.).
  - `Order`: representa un pedido realizado.
  - `Discount` / `PercentDiscount`: modelo de descuentos aplicables.

---

### 2. **Aplicación (`application`)**
Incluye la lógica de negocio y servicios que orquestan operaciones sobre el dominio.

- **Servicios clave:**
  - `MenuService`: permite operaciones CRUD sobre los ítems del menú.
  - `OrderService`: administra pedidos (creación, estado, cancelación).
  - `ReportService`: genera reportes de ingresos y ventas.
  - `PricingService`: calcula el total de un pedido, aplicando descuentos e impuestos.

---

### 3. **Infraestructura (`infrastructure`)**
Implementa el almacenamiento en memoria y mecanismos auxiliares.

- **Repositorios en memoria:**
  - `InMemoryMenuRepository`
  - `InMemoryOrderRepository`
  - `InMemoryCustomerRepository`

---

## 🧪 Pruebas

El proyecto incluye pruebas unitarias para validar:

- Operaciones CRUD en el menú (`MenuServiceTest`)
- Cálculo de totales con descuentos e impuestos (`PricingServiceTest`)
- Flujo de estados de un pedido (`OrderStateTest`)

---

## ✅ Patrones de Diseño Utilizados

- **Repository**: separación entre lógica de acceso a datos y lógica de negocio.
- **Strategy**: implementación flexible de descuentos.
- **Service**: encapsulación de lógica de aplicación.

---


## 👨‍💻 Autores

Juan David Ortiz - Juan Camilo Moreno

