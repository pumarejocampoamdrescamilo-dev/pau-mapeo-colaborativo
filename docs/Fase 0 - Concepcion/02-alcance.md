## 1.2 Alcance

El sistema se enfocará en facilitar la movilidad urbana de personas con discapacidad física mediante un mapeo colaborativo y ruteo accesible en la ciudad de Medellín. A continuación se presentan los módulos principales del sistema.

**Módulos del sistema (dentro del alcance):**

- Registro e inicio de sesión

- Perfil de movilidad y auditoría de accesos

- Mapa colaborativo de accesibilidad

- Planificador de rutas accesibles

- Reportes ciudadanos

- Estado de solicitud (seguimiento del ciclo de vida de un reporte enviado —Pendiente, Confirmado, Rechazado, Resuelto— mediante el atributo estado de la clase Reporte)

- Subida de evidencia fotográfica

- Panel de gestión comunitaria (revisión y verificación de reportes y barreras por parte del Gestor Comunitario)

**Aspectos excluidos (fuera del alcance): el sistema NO contempla:**

- Integración con sistemas oficiales de transporte público (Metro, buses, etc.).

- Gestión de pagos electrónicos ni transacciones financieras.

- Exportación de datos en formatos como PDF o Excel.

- Estadísticas avanzadas ni analítica predictiva.

- Sistema de comentarios o interacción social entre usuarios, salvo el comentario opcional que acompaña al voto de validación de un reporte.

- Mecanismos avanzados de seguridad como autenticación biométrica.

- Gestión directa de servicios médicos, educativos o laborales.

- Reemplazo de sistemas gubernamentales oficiales de infraestructura urbana.

El sistema se centra exclusivamente en proporcionar información colaborativa sobre accesibilidad y apoyar la planificación de rutas seguras, promoviendo la inclusión social y la autonomía de las personas con discapacidad física de movilidad reducida.

### Entidades principales del modelo de datos

El modelo de datos del sistema PAU está compuesto por doce entidades: Rol, Usuario, PerfilMovilidad, AuditoriaAccesoPerfilMovilidad, Barrera, BarreraEquipoAfectado, PuntoAccesible, Ruta, SegmentoRuta, Reporte, ValidacionReporte y EvidenciaFotografica. Estas entidades permiten gestionar los usuarios y sus permisos, registrar sus perfiles de movilidad, almacenar información sobre barreras y puntos accesibles, planificar rutas, documentar reportes ciudadanos y sus validaciones, conservar evidencias fotográficas y llevar un registro de los accesos a información sensible. Su estructura y sus relaciones se presentan en el modelo entidad-relación y en el diagrama de clases del proyecto. La relaciona cada módulo del alcance con las entidades que lo soportan.

Tabla  
*Módulos del alcance y entidades del modelo que los soportan*

| **Módulo**                                 | **Entidades**                                   |
|--------------------------------------------|-------------------------------------------------|
| Registro e inicio de sesión                | Usuario, Rol                                    |
| Perfil de movilidad y auditoría de accesos | PerfilMovilidad, AuditoriaAccesoPerfilMovilidad |
| Mapa colaborativo de accesibilidad         | Barrera, BarreraEquipoAfectado, PuntoAccesible  |
| Planificador de rutas accesibles           | Ruta, SegmentoRuta, PerfilMovilidad             |
| Reportes ciudadanos y estado de solicitud  | Reporte, ValidacionReporte                      |
| Subida de evidencia fotográfica            | EvidenciaFotografica                            |
| Panel de gestión comunitaria               | Barrera, Reporte, PuntoAccesible                |

*Nota.* Elaboración propia.

