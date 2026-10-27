# PAU · Mapeo Colaborativo de Rutas Accesibles

Proyecto de Ingeniería de Software II, Corporación Universitaria Remington.

- **Equipo:** Pumarejo y Cía. (Juan Pablo Mejía Urango y Andrés Camilo Pumarejo Campo)
- **Docente:** Gloria Amparo Lora Patiño
- **Documento del proyecto:** [`docs/PAU_Mapeo_Colaborativo.pdf`](docs/PAU_Mapeo_Colaborativo.pdf)

## Tecnología

Patrón MVC sin framework. Java con Servlets y JSP (capa web) y JDBC (base de datos), MySQL (diccionario de datos en 3FN), HTML, CSS y JavaScript para las vistas, y Leaflet con OpenStreetMap para el mapa. Git y GitHub para el control de versiones.

## Estructura

```
├── db/          script_bd_pau.sql (imagen exacta del modelo relacional)
├── docs/        documento del proyecto, elementos de configuración y registro de CRF
└── src/main/
    ├── java/co/edu/remington/pau/
    │   ├── modelo/        clases del dominio y DAO (JDBC)
    │   ├── servicio/      reglas de negocio
    │   └── controlador/   Servlets
    └── webapp/            vistas JSP, CSS, JavaScript y mapas Leaflet
```

## Cómo ejecutar

1. Iniciar MySQL (XAMPP) e importar `db/script_bd_pau.sql` desde phpMyAdmin.
2. Definir las variables de entorno de la conexión: `PAU_DB_URL`, `PAU_DB_USER` y `PAU_DB_PASSWORD`. La clave nunca se escribe en el código.

## Control de versiones

- Un commit por requisito funcional, en el orden de la matriz de trazabilidad.
- Mensaje: `tipo(código): descripción`, por ejemplo `feat(RF-01): crear rol`.
- El tag `LB-1` congela la línea base; todo cambio posterior entra por CRF.