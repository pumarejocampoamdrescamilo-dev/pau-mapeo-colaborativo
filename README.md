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
├── lib/         librerías .jar (conector MySQL y JSTL); no se suben a Git
├── build.ps1    script de compilación para Windows
└── src/main/
    ├── java/co/edu/remington/pau/
    │   ├── modelo/        clases del dominio y DAO (JDBC)
    │   ├── servicio/      reglas de negocio (las RN se validan aquí, no en la vista)
    │   └── controlador/   Servlets
    └── webapp/            vistas JSP, CSS, JavaScript y mapas Leaflet
```

## Requisitos

- JDK 21 o superior
- Apache Tomcat 10.1 (usa `jakarta.servlet`, no `javax.servlet`)
- MySQL o MariaDB (por ejemplo, el que trae XAMPP)
- Git

## Cómo ejecutar (Windows)

1. **Base de datos.** Iniciar MySQL en XAMPP e importar `db/script_bd_pau.sql` desde phpMyAdmin (o con el cliente `mysql`).
2. **Librerías.** Poner en la carpeta `lib/` el conector JDBC de MySQL y las librerías JSTL (API e implementación de Jakarta). `build.ps1` las copia a `WEB-INF/lib`.
3. **Variables de entorno de la conexión.** La clave nunca se escribe en el código:
   - `PAU_DB_URL` (por defecto `jdbc:mysql://localhost:3306/pau?useUnicode=true&characterEncoding=UTF-8`)
   - `PAU_DB_USER` (por defecto `root`)
   - `PAU_DB_PASSWORD` (por defecto vacía)
4. **Compilar.** En PowerShell, desde la raíz del repositorio:
   ```powershell
   $env:CATALINA_HOME = "C:\tomcat"
   Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
   .\build.ps1
   ```
   El resultado queda en `build\pau` (carpeta ignorada por Git).
5. **Desplegar.** Crear el archivo `C:\tomcat\conf\Catalina\localhost\pau.xml` apuntando a la carpeta compilada:
   ```xml
   <Context docBase="C:\ruta\al\repositorio\build\pau" reloadable="true" />
   ```
6. **Iniciar Tomcat:** `C:\tomcat\bin\startup.bat` y abrir <http://localhost:8080/pau/roles>.

## Módulos implementados

| Módulo | Requisitos | Pantallas |
|---|---|---|
| Roles | RF-01 crear, RF-02 consultar, RF-03 actualizar, RF-36 cambiar estado | MK-01 catálogo, MK-02 formulario |

## Control de versiones

- Un commit por requisito funcional, en el orden de la matriz de trazabilidad.
- Mensaje: `tipo(código): descripción`, por ejemplo `feat(RF-01): crear rol`.
- El tag `LB-1` congela la línea base; todo cambio posterior entra por CRF (`docs/REGISTRO_CRF.md`).
- Las credenciales no se suben al repositorio (variables de entorno y `.gitignore`).
