## 2.3 Requisitos no funcionales

Las fichas de la a la presentan los diez requisitos no funcionales. Cada uno tiene categoría, un enunciado con una medida verificable (tiempo, porcentaje, algoritmo o periodo de retención) y su origen.

Tabla  
*Ficha del RNF-01: Rendimiento*

|                                        |                                                                                                                                                                   |
|----------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**                             | RNF-01                                                                                                                                                            |
| **Categoría**                          | Rendimiento                                                                                                                                                       |
| **Enunciado (con medida verificable)** | El cálculo de una ruta accesible (HU-29) debe completarse en menos de 3 segundos, con una base de al menos 10.000 barreras y 5.000 puntos accesibles registrados. |
| **Origen de la necesidad**             | Hallazgo H3 (sección 1.7.3): se necesita planificar rutas accesibles adaptadas a cada persona                                                                     |

Tabla  
*Ficha del RNF-02: Rendimiento*

|                                        |                                                                                                                                                         |
|----------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**                             | RNF-02                                                                                                                                                  |
| **Categoría**                          | Rendimiento                                                                                                                                             |
| **Enunciado (con medida verificable)** | Las consultas por identificador (barrera, reporte, punto accesible, perfil) deben responder en menos de 1 segundo con hasta 50.000 registros por tabla. |
| **Origen de la necesidad**             | Hallazgo H2 (sección 1.7.3): se necesita información verificada y actualizada                                                                           |

Tabla  
*Ficha del RNF-03: Seguridad*

|                                        |                                                                                                                                                                                                  |
|----------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**                             | RNF-03                                                                                                                                                                                           |
| **Categoría**                          | Seguridad                                                                                                                                                                                        |
| **Enunciado (con medida verificable)** | Las contraseñas de los usuarios deben almacenarse como hash (BCrypt o Argon2, factor de costo mínimo 10); el sistema no debe guardar ni transmitir contraseñas en texto plano en ningún momento. |
| **Origen de la necesidad**             | Diccionario de datos — campo contrasena_hash de la tabla usuario                                                                                                                                 |

Tabla  
*Ficha del RNF-04: Seguridad / Protección de datos sensibles*

|                                        |                                                                                                                                                                                                            |
|----------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**                             | RNF-04                                                                                                                                                                                                     |
| **Categoría**                          | Seguridad / Protección de datos sensibles                                                                                                                                                                  |
| **Enunciado (con medida verificable)** | Los campos tipo_discapacidad y grado_discapacidad del perfil de movilidad deben almacenarse cifrados en reposo con AES-256, y solo ser legibles por procesos autorizados para el cálculo de accesibilidad. |
| **Origen de la necesidad**             | Normativa — Ley 1581 de 2012 (marco teórico, sección 1.6); cláusula de protección de datos sensibles del diccionario de datos                                                                              |

Tabla  
*Ficha del RNF-05: Seguridad / Control de acceso*

|                                        |                                                                                                                                                                                                                                                                          |
|----------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**                             | RNF-05                                                                                                                                                                                                                                                                   |
| **Categoría**                          | Seguridad / Control de acceso                                                                                                                                                                                                                                            |
| **Enunciado (con medida verificable)** | El acceso de consulta o modificación a un perfil de movilidad debe quedar restringido por rol: solo el usuario titular y el Administrador del Sistema pueden acceder a sus datos sensibles; cualquier otro intento debe registrarse como DENEGADO en menos de 1 segundo. |
| **Origen de la necesidad**             | Normativa — Ley 1581 de 2012; RN-05 / RF-12 (auditoría de accesos)                                                                                                                                                                                                       |

Tabla  
*Ficha del RNF-06: Usabilidad / Accesibilidad*

|                                        |                                                                                                                                                                                                                     |
|----------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**                             | RNF-06                                                                                                                                                                                                              |
| **Categoría**                          | Usabilidad / Accesibilidad                                                                                                                                                                                          |
| **Enunciado (con medida verificable)** | La interfaz debe cumplir el nivel AA de las pautas WCAG 2.1: contraste mínimo de 4.5:1 entre texto y fondo, navegación completa por teclado y compatibilidad con al menos un lector de pantalla (NVDA o VoiceOver). |
| **Origen de la necesidad**             | Hallazgos H1 y H4 (sección 1.7.3); alcance del sistema (población objetivo con discapacidad física)                                                                                                                 |

Tabla  
*Ficha del RNF-07: Disponibilidad*

|                                        |                                                                                                                                                                             |
|----------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**                             | RNF-07                                                                                                                                                                      |
| **Categoría**                          | Disponibilidad                                                                                                                                                              |
| **Enunciado (con medida verificable)** | El sistema debe estar disponible al menos el 99% del tiempo en un mes calendario, excluyendo ventanas de mantenimiento programado notificadas con 24 horas de anticipación. |
| **Origen de la necesidad**             | Necesidad operativa — el sistema debe estar accesible para reportes y consulta de rutas en cualquier momento                                                                |

Tabla  
*Ficha del RNF-08: Escalabilidad*

|                                        |                                                                                                                                    |
|----------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| **Código**                             | RNF-08                                                                                                                             |
| **Categoría**                          | Escalabilidad                                                                                                                      |
| **Enunciado (con medida verificable)** | El sistema debe soportar al menos 500 usuarios concurrentes sin que el tiempo de respuesta de las consultas supere los 2 segundos. |
| **Origen de la necesidad**             | Proyección de crecimiento — estratos 1 a 4 de Medellín (alcance, sección 1.2)                                                      |

Tabla  
*Ficha del RNF-09: Compatibilidad*

|                                        |                                                                                                                                                                                    |
|----------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**                             | RNF-09                                                                                                                                                                             |
| **Categoría**                          | Compatibilidad                                                                                                                                                                     |
| **Enunciado (con medida verificable)** | El sistema debe funcionar correctamente en las dos últimas versiones mayores de Chrome, Firefox y Safari, y en dispositivos móviles con Android 10 o superior e iOS 14 o superior. |
| **Origen de la necesidad**             | Encuesta — instrumento distribuido vía Google Forms a personas con distintos dispositivos                                                                                          |

Tabla  
*Ficha del RNF-10: Auditoría / Trazabilidad*

|                                        |                                                                                                                                                                                          |
|----------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**                             | RNF-10                                                                                                                                                                                   |
| **Categoría**                          | Auditoría / Trazabilidad                                                                                                                                                                 |
| **Enunciado (con medida verificable)** | Los registros de auditoría de acceso a un perfil de movilidad (tabla auditoria_acceso_perfil_movilidad) deben conservarse sin posibilidad de edición ni borrado durante al menos 2 años. |
| **Origen de la necesidad**             | Normativa — Ley 1581 de 2012; diccionario de datos (Corrección 6)                                                                                                                        |

