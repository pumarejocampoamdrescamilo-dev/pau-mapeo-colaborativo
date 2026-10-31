## 2.2 Reglas de negocio y requisitos funcionales

### 2.2.1 Reglas de negocio

Las fichas de la a la reúnen las dieciséis reglas de negocio. Cada una está redactada en presente como política del negocio, cita el criterio de aceptación de una historia de usuario del que nace (casi siempre un caso de rechazo) y nombra los requisitos funcionales que la vigilan. Las reglas RN-15 y RN-16 son nuevas y establecen la inactivación como forma de baja.

Tabla  
*Ficha de la RN-01*

|                       |                                                                                                             |
|-----------------------|-------------------------------------------------------------------------------------------------------------|
| **Código**            | RN-01                                                                                                       |
| **Enunciado**         | El nombre de un rol en el catálogo debe ser único (no pueden existir dos filas de rol con el mismo nombre). |
| **Origen**            | Criterios de rechazo HU-01 CA-2 y HU-03 CA-2                                                                |
| **RF que la vigilan** | RF-01, RF-03                                                                                                |

Tabla  
*Ficha de la RN-02*

|                       |                                                               |
|-----------------------|---------------------------------------------------------------|
| **Código**            | RN-02                                                         |
| **Enunciado**         | El correo de un usuario debe ser único en toda la plataforma. |
| **Origen**            | Criterios de rechazo HU-04 CA-2 y HU-06 CA-2                  |
| **RF que la vigilan** | RF-04, RF-06                                                  |

Tabla  
*Ficha de la RN-03*

|                       |                                                        |
|-----------------------|--------------------------------------------------------|
| **Código**            | RN-03                                                  |
| **Enunciado**         | Solo un usuario en estado ACTIVO puede iniciar sesión. |
| **Origen**            | Criterio de rechazo HU-07 CA-2                         |
| **RF que la vigilan** | RF-07                                                  |

Tabla  
*Ficha de la RN-04*

|                       |                                                                    |
|-----------------------|--------------------------------------------------------------------|
| **Código**            | RN-04                                                              |
| **Enunciado**         | Un usuario solo puede tener un perfil de movilidad (relación 1:1). |
| **Origen**            | Criterio de rechazo HU-09 CA-2                                     |
| **RF que la vigilan** | RF-09                                                              |

Tabla  
*Ficha de la RN-05*

|                       |                                                                                                                                                                                            |
|-----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**            | RN-05                                                                                                                                                                                      |
| **Enunciado**         | Todo acceso (consulta o modificación), autorizado o denegado, a un perfil de movilidad debe quedar registrado — exigencia derivada de la Ley 1581 de 2012 (protección de datos sensibles). |
| **Origen**            | Criterio de aceptación de HU-10 CA-1 y HU-11 CA-1 (antes HU-27, retirada y reclasificada como método interno)                                                                              |
| **RF que la vigilan** | RF-12                                                                                                                                                                                      |

Tabla  
*Ficha de la RN-06*

|                       |                                                                                                                                                                              |
|-----------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**            | RN-06                                                                                                                                                                        |
| **Enunciado**         | Toda barrera debe registrarse con tipo, gravedad, latitud y longitud (campos obligatorios del diccionario de datos); equipo afectado principal y descripción son opcionales. |
| **Origen**            | Criterio de rechazo HU-12 CA-3                                                                                                                                               |
| **RF que la vigilan** | RF-13                                                                                                                                                                        |

Tabla  
*Ficha de la RN-07*

|                       |                                                                                    |
|-----------------------|------------------------------------------------------------------------------------|
| **Código**            | RN-07                                                                              |
| **Enunciado**         | No se puede duplicar el mismo equipo de asistencia afectado para la misma barrera. |
| **Origen**            | Criterio de rechazo HU-15 CA-2                                                     |
| **RF que la vigilan** | RF-16                                                                              |

Tabla  
*Ficha de la RN-08*

|                       |                                                                                  |
|-----------------------|----------------------------------------------------------------------------------|
| **Código**            | RN-08                                                                            |
| **Enunciado**         | Un reporte debe tener barrera asociada salvo cuando su origen sea NUEVA_BARRERA. |
| **Origen**            | Criterio de rechazo HU-18 CA-3; diccionario de datos (CHECK origen_reporte)      |
| **RF que la vigilan** | RF-19                                                                            |

Tabla  
*Ficha de la RN-09*

|                       |                                                                                                                                                                                                                                                                                                                                            |
|-----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**            | RN-09                                                                                                                                                                                                                                                                                                                                      |
| **Enunciado**         | Al cambiar el estado de un reporte, el estado de la barrera asociada se actualiza así: CONFIRMADO → VERIFICADA; RESUELTO → RESUELTA; RECHAZADO → sin cambio (o vuelve a REPORTADA si era la única evidencia). Si la barrera tiene varios reportes, prevalece el más avanzado del ciclo (RESUELTO \> CONFIRMADO \> PENDIENTE \> RECHAZADO). |
| **Origen**            | Criterios HU-20 CA-1 a CA-4; diccionario de datos (Regla de negocio §2)                                                                                                                                                                                                                                                                    |
| **RF que la vigilan** | RF-21, RF-15                                                                                                                                                                                                                                                                                                                               |

Tabla  
*Ficha de la RN-10*

|                       |                                                                                   |
|-----------------------|-----------------------------------------------------------------------------------|
| **Código**            | RN-10                                                                             |
| **Enunciado**         | Un reporte ya asociado a una barrera no puede reasignarse a una barrera distinta. |
| **Origen**            | Criterio de rechazo HU-21 CA-2                                                    |
| **RF que la vigilan** | RF-22                                                                             |

Tabla  
*Ficha de la RN-11*

|                       |                                                                                                                                                                                                                             |
|-----------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**            | RN-11                                                                                                                                                                                                                       |
| **Enunciado**         | El nivel de confianza de un reporte se recalcula únicamente a partir de los votos de validación registrados para ese reporte, contando un único voto por usuario (UNIQUE id_reporte, id_usuario), en escala de 1.00 a 5.00. |
| **Origen**            | Criterio de rechazo HU-23 CA-3; diccionario de datos (Corrección 3)                                                                                                                                                         |
| **RF que la vigilan** | RF-23                                                                                                                                                                                                                       |

Tabla  
*Ficha de la RN-12*

|                       |                                                                                                                                                                                     |
|-----------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**            | RN-12                                                                                                                                                                               |
| **Enunciado**         | El nivel de accesibilidad y las barreras esquivadas de una ruta se calculan una sola vez, al crearla (instantánea histórica); no se recalculan después aunque cambien las barreras. |
| **Origen**            | Criterio HU-29 CA-1 y HU-30 CA-1; diccionario de datos (Corrección 8)                                                                                                               |
| **RF que la vigilan** | RF-29, RF-30                                                                                                                                                                        |

Tabla  
*Ficha de la RN-13*

|                       |                                                                                                                                             |
|-----------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**            | RN-13                                                                                                                                       |
| **Enunciado**         | El orden de un segmento dentro de una misma ruta debe ser único (no puede haber dos segmentos con el mismo ordenSegmento en la misma ruta). |
| **Origen**            | Criterio de rechazo HU-31 CA-2; diccionario de datos (Corrección 4)                                                                         |
| **RF que la vigilan** | RF-31                                                                                                                                       |

Tabla  
*Ficha de la RN-14*

|                       |                                                                                                                        |
|-----------------------|------------------------------------------------------------------------------------------------------------------------|
| **Código**            | RN-14                                                                                                                  |
| **Enunciado**         | Todo punto accesible debe registrarse con tipo de elemento y ubicación (campos obligatorios del diccionario de datos). |
| **Origen**            | Criterio de rechazo HU-32 CA-2                                                                                         |
| **RF que la vigilan** | RF-32                                                                                                                  |

Tabla  
*Ficha de la RN-15*

|                       |                                                                                                             |
|-----------------------|-------------------------------------------------------------------------------------------------------------|
| **Código**            | RN-15                                                                                                       |
| **Enunciado**         | Un rol en estado INACTIVO no puede asignarse a usuarios nuevos; los usuarios que ya lo tienen lo conservan. |
| **Origen**            | Criterios de rechazo HU-04 CA-3; criterio HU-36 CA-1                                                        |
| **RF que la vigilan** | RF-04, RF-36                                                                                                |

Tabla  
*Ficha de la RN-16*

|                       |                                                                                                                                                                                                                                  |
|-----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**            | RN-16                                                                                                                                                                                                                            |
| **Enunciado**         | Las bajas se registran como inactivación: un rol o una asociación entre barrera y equipo afectado no se elimina, pasa a estado inactivo y conserva su historial; un registro que ya está inactivo no puede inactivarse de nuevo. |
| **Origen**            | Criterios HU-17 CA-1 y CA-3; criterios HU-36 CA-1 y CA-3; diccionario de datos (Regla de negocio §3)                                                                                                                             |
| **RF que la vigilan** | RF-18, RF-36                                                                                                                                                                                                                     |

### 2.2.2 Requisitos funcionales

Las fichas de la a la presentan los treinta y seis requisitos funcionales. Todos empiezan con «El sistema debe», no mencionan pantallas ni tecnología, citan la historia de usuario de la que derivan (los dos métodos internos citan las historias que los disparan) y la regla de negocio que hacen cumplir. Ningún requisito elimina información: RF-18 y RF-36 inactivan.

Tabla  
*Ficha del RF-01: Crear rol*

|                         |                                                                                                          |
|-------------------------|----------------------------------------------------------------------------------------------------------|
| **Código**              | RF-01                                                                                                    |
| **Nombre corto**        | Crear rol                                                                                                |
| **Descripción**         | El sistema debe crear un rol con un nombre único y una descripción, dejándolo disponible en el catálogo. |
| **HU de origen**        | HU-01                                                                                                    |
| **RN que hace cumplir** | RN-01 (nombre de rol único)                                                                              |
| **Prioridad**           | Alta                                                                                                     |

Tabla  
*Ficha del RF-02: Consultar rol*

|                         |                                                                                                    |
|-------------------------|----------------------------------------------------------------------------------------------------|
| **Código**              | RF-02                                                                                              |
| **Nombre corto**        | Consultar rol                                                                                      |
| **Descripción**         | El sistema debe permitir consultar un rol por su identificador, mostrando su nombre y descripción. |
| **HU de origen**        | HU-02                                                                                              |
| **RN que hace cumplir** | Ninguna                                                                                            |
| **Prioridad**           | Media                                                                                              |

Tabla  
*Ficha del RF-03: Actualizar rol*

|                         |                                                                                                                                          |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-03                                                                                                                                    |
| **Nombre corto**        | Actualizar rol                                                                                                                           |
| **Descripción**         | El sistema debe actualizar el nombre o la descripción de un rol existente, sin permitir que el nuevo nombre coincida con el de otro rol. |
| **HU de origen**        | HU-03                                                                                                                                    |
| **RN que hace cumplir** | RN-01 (nombre de rol único)                                                                                                              |
| **Prioridad**           | Baja                                                                                                                                     |

Tabla  
*Ficha del RF-04: Registrar usuario*

|                         |                                                                                                                                                                                           |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-04                                                                                                                                                                                     |
| **Nombre corto**        | Registrar usuario                                                                                                                                                                         |
| **Descripción**         | El sistema debe registrar un usuario con nombre completo, correo, contraseña y rol, dejándolo en estado activo, verificando que el correo no esté ya registrado y que el rol esté activo. |
| **HU de origen**        | HU-04                                                                                                                                                                                     |
| **RN que hace cumplir** | RN-02 (correo único); RN-15 (rol activo)                                                                                                                                                  |
| **Prioridad**           | Alta                                                                                                                                                                                      |

Tabla  
*Ficha del RF-05: Consultar usuario*

|                         |                                                                                                            |
|-------------------------|------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-05                                                                                                      |
| **Nombre corto**        | Consultar usuario                                                                                          |
| **Descripción**         | El sistema debe permitir consultar los datos de un usuario (nombre, correo y estado) por su identificador. |
| **HU de origen**        | HU-05                                                                                                      |
| **RN que hace cumplir** | Ninguna                                                                                                    |
| **Prioridad**           | Media                                                                                                      |

Tabla  
*Ficha del RF-06: Actualizar datos personales*

|                         |                                                                                                                              |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-06                                                                                                                        |
| **Nombre corto**        | Actualizar datos personales                                                                                                  |
| **Descripción**         | El sistema debe actualizar el nombre o el correo de un usuario, verificando que el nuevo correo no pertenezca a otra cuenta. |
| **HU de origen**        | HU-06                                                                                                                        |
| **RN que hace cumplir** | RN-02 (correo único)                                                                                                         |
| **Prioridad**           | Media                                                                                                                        |

Tabla  
*Ficha del RF-07: Autenticar usuario*

|                         |                                                                                                                            |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-07                                                                                                                      |
| **Nombre corto**        | Autenticar usuario                                                                                                         |
| **Descripción**         | El sistema debe autenticar a un usuario con su correo y contraseña, concediendo acceso solamente si la cuenta está activa. |
| **HU de origen**        | HU-07                                                                                                                      |
| **RN que hace cumplir** | RN-03 (solo cuentas activas inician sesión)                                                                                |
| **Prioridad**           | Alta                                                                                                                       |

Tabla  
*Ficha del RF-08: Cambiar estado de cuenta*

|                         |                                                                                                       |
|-------------------------|-------------------------------------------------------------------------------------------------------|
| **Código**              | RF-08                                                                                                 |
| **Nombre corto**        | Cambiar estado de cuenta                                                                              |
| **Descripción**         | El sistema debe permitir cambiar el estado de la cuenta de un usuario (Activo, Inactivo, Suspendido). |
| **HU de origen**        | HU-08                                                                                                 |
| **RN que hace cumplir** | Ninguna                                                                                               |
| **Prioridad**           | Media                                                                                                 |

Tabla  
*Ficha del RF-09: Registrar perfil de movilidad*

|                         |                                                                                                                                                                                                                     |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-09                                                                                                                                                                                                               |
| **Nombre corto**        | Registrar perfil de movilidad                                                                                                                                                                                       |
| **Descripción**         | El sistema debe registrar el perfil de movilidad de un usuario (tipo y grado de discapacidad, condición de movilidad, equipo de asistencia y parámetros de ruta), verificando que no tenga ya un perfil registrado. |
| **HU de origen**        | HU-09                                                                                                                                                                                                               |
| **RN que hace cumplir** | RN-04 (un perfil por usuario)                                                                                                                                                                                       |
| **Prioridad**           | Alta                                                                                                                                                                                                                |

Tabla  
*Ficha del RF-10: Consultar perfil de movilidad*

|                         |                                                                                                                    |
|-------------------------|--------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-10                                                                                                              |
| **Nombre corto**        | Consultar perfil de movilidad                                                                                      |
| **Descripción**         | El sistema debe permitir consultar el perfil de movilidad propio, registrando automáticamente el acceso realizado. |
| **HU de origen**        | HU-10                                                                                                              |
| **RN que hace cumplir** | RN-05 (registro de acceso, vía RF-12)                                                                              |
| **Prioridad**           | Media                                                                                                              |

Tabla  
*Ficha del RF-11: Actualizar perfil de movilidad*

|                         |                                                                                                                     |
|-------------------------|---------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-11                                                                                                               |
| **Nombre corto**        | Actualizar perfil de movilidad                                                                                      |
| **Descripción**         | El sistema debe permitir actualizar el perfil de movilidad propio, registrando automáticamente el acceso realizado. |
| **HU de origen**        | HU-11                                                                                                               |
| **RN que hace cumplir** | RN-05 (registro de acceso, vía RF-12)                                                                               |
| **Prioridad**           | Media                                                                                                               |

Tabla  
*Ficha del RF-12: Registrar acceso a perfil de movilidad (interno)*

|                         |                                                                                                                                                                         |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-12                                                                                                                                                                   |
| **Nombre corto**        | Registrar acceso a perfil de movilidad (interno)                                                                                                                        |
| **Descripción**         | El sistema debe registrar automáticamente cada acceso (consulta o modificación) a un perfil de movilidad, indicando la acción realizada y si fue autorizado o denegado. |
| **HU de origen**        | HU-10, HU-11 (método interno, sin HU propia)                                                                                                                            |
| **RN que hace cumplir** | RN-05 (registro obligatorio de todo acceso — Ley 1581 de 2012)                                                                                                          |
| **Prioridad**           | Alta                                                                                                                                                                    |

Tabla  
*Ficha del RF-13: Registrar barrera*

|                         |                                                                                                                                                                                                        |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-13                                                                                                                                                                                                  |
| **Nombre corto**        | Registrar barrera                                                                                                                                                                                      |
| **Descripción**         | El sistema debe registrar una barrera con tipo, nivel de gravedad y ubicación (latitud y longitud), admitiendo opcionalmente equipo afectado principal y descripción, y dejándola en estado Reportada. |
| **HU de origen**        | HU-12                                                                                                                                                                                                  |
| **RN que hace cumplir** | RN-06 (campos obligatorios de la barrera)                                                                                                                                                              |
| **Prioridad**           | Alta                                                                                                                                                                                                   |

Tabla  
*Ficha del RF-14: Consultar barrera*

|                         |                                                                                                                    |
|-------------------------|--------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-14                                                                                                              |
| **Nombre corto**        | Consultar barrera                                                                                                  |
| **Descripción**         | El sistema debe permitir consultar una barrera por su identificador, mostrando tipo, gravedad, estado y ubicación. |
| **HU de origen**        | HU-13                                                                                                              |
| **RN que hace cumplir** | Ninguna                                                                                                            |
| **Prioridad**           | Alta                                                                                                               |

Tabla  
*Ficha del RF-15: Cambiar estado de la barrera*

|                         |                                                                                                                                                                                                           |
|-------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-15                                                                                                                                                                                                     |
| **Nombre corto**        | Cambiar estado de la barrera                                                                                                                                                                              |
| **Descripción**         | El sistema debe permitir cambiar el estado de una barrera (Reportada, Verificada, Resuelta, Inactiva), ya sea directamente o por propagación automática desde el cambio de estado de un reporte asociado. |
| **HU de origen**        | HU-14                                                                                                                                                                                                     |
| **RN que hace cumplir** | RN-09 (propagación de estado desde el reporte)                                                                                                                                                            |
| **Prioridad**           | Alta                                                                                                                                                                                                      |

Tabla  
*Ficha del RF-16: Asociar equipo afectado*

|                         |                                                                                                                                                   |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-16                                                                                                                                             |
| **Nombre corto**        | Asociar equipo afectado                                                                                                                           |
| **Descripción**         | El sistema debe permitir asociar a una barrera los equipos de asistencia que afecta, sin permitir duplicar el mismo equipo para la misma barrera. |
| **HU de origen**        | HU-15                                                                                                                                             |
| **RN que hace cumplir** | RN-07 (no duplicar equipo afectado)                                                                                                               |
| **Prioridad**           | Media                                                                                                                                             |

Tabla  
*Ficha del RF-17: Consultar equipos afectados*

|                         |                                                                                         |
|-------------------------|-----------------------------------------------------------------------------------------|
| **Código**              | RF-17                                                                                   |
| **Nombre corto**        | Consultar equipos afectados                                                             |
| **Descripción**         | El sistema debe permitir consultar los equipos de asistencia afectados por una barrera. |
| **HU de origen**        | HU-16                                                                                   |
| **RN que hace cumplir** | Ninguna                                                                                 |
| **Prioridad**           | Media                                                                                   |

Tabla  
*Ficha del RF-18: Inactivar asociación de equipo afectado*

|                         |                                                                                                                                                                                            |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-18                                                                                                                                                                                      |
| **Nombre corto**        | Inactivar asociación de equipo afectado                                                                                                                                                    |
| **Descripción**         | El sistema debe permitir inactivar una asociación de equipo afectado registrada por error, conservándola en el historial y dejando de mostrarla entre los equipos afectados de la barrera. |
| **HU de origen**        | HU-17                                                                                                                                                                                      |
| **RN que hace cumplir** | RN-16 (las bajas son inactivación)                                                                                                                                                         |
| **Prioridad**           | Baja                                                                                                                                                                                       |

Tabla  
*Ficha del RF-19: Crear reporte*

|                         |                                                                                                                                             |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-19                                                                                                                                       |
| **Nombre corto**        | Crear reporte                                                                                                                               |
| **Descripción**         | El sistema debe registrar un reporte con su origen y una observación, exigiendo una barrera asociada cuando el origen no sea Nueva Barrera. |
| **HU de origen**        | HU-18                                                                                                                                       |
| **RN que hace cumplir** | RN-08 (barrera asociada obligatoria)                                                                                                        |
| **Prioridad**           | Alta                                                                                                                                        |

Tabla  
*Ficha del RF-20: Consultar reporte*

|                         |                                                                                                                                               |
|-------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-20                                                                                                                                         |
| **Nombre corto**        | Consultar reporte                                                                                                                             |
| **Descripción**         | El sistema debe permitir consultar un reporte por su identificador, mostrando origen, estado, nivel de confianza, observación, autor y fecha. |
| **HU de origen**        | HU-19                                                                                                                                         |
| **RN que hace cumplir** | Ninguna                                                                                                                                       |
| **Prioridad**           | Media                                                                                                                                         |

Tabla  
*Ficha del RF-21: Cambiar estado del reporte*

|                         |                                                                                                                                                                                                              |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-21                                                                                                                                                                                                        |
| **Nombre corto**        | Cambiar estado del reporte                                                                                                                                                                                   |
| **Descripción**         | El sistema debe permitir cambiar el estado de un reporte (Pendiente, Confirmado, Rechazado, Resuelto), propagando automáticamente ese cambio al estado de la barrera asociada según la regla de prevalencia. |
| **HU de origen**        | HU-20                                                                                                                                                                                                        |
| **RN que hace cumplir** | RN-09 (propagación de estado a la barrera)                                                                                                                                                                   |
| **Prioridad**           | Alta                                                                                                                                                                                                         |

Tabla  
*Ficha del RF-22: Asociar barrera a un reporte*

|                         |                                                                                                                                                              |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-22                                                                                                                                                        |
| **Nombre corto**        | Asociar barrera a un reporte                                                                                                                                 |
| **Descripción**         | El sistema debe permitir asociar un reporte sin barrera a una barrera ya registrada, impidiendo reasignarlo a una barrera distinta si ya tiene una asociada. |
| **HU de origen**        | HU-21                                                                                                                                                        |
| **RN que hace cumplir** | RN-10 (no reasignar a otra barrera)                                                                                                                          |
| **Prioridad**           | Media                                                                                                                                                        |

Tabla  
*Ficha del RF-23: Recalcular confianza del reporte (interno)*

|                         |                                                                                                                                               |
|-------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-23                                                                                                                                         |
| **Nombre corto**        | Recalcular confianza del reporte (interno)                                                                                                    |
| **Descripción**         | El sistema debe recalcular automáticamente el nivel de confianza de un reporte cada vez que se registre un nuevo voto de validación sobre él. |
| **HU de origen**        | HU-23 (método interno, sin HU propia)                                                                                                         |
| **RN que hace cumplir** | RN-11 (recálculo a partir de votos únicos)                                                                                                    |
| **Prioridad**           | Alta                                                                                                                                          |

Tabla  
*Ficha del RF-24: Registrar voto de validación*

|                         |                                                                                                                                                                                |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-24                                                                                                                                                                          |
| **Nombre corto**        | Registrar voto de validación                                                                                                                                                   |
| **Descripción**         | El sistema debe registrar el voto de validación (válido o no válido, con comentario opcional) de un usuario sobre un reporte, permitiendo un único voto por usuario y reporte. |
| **HU de origen**        | HU-23                                                                                                                                                                          |
| **RN que hace cumplir** | RN-11 (un voto por usuario y reporte)                                                                                                                                          |
| **Prioridad**           | Alta                                                                                                                                                                           |

Tabla  
*Ficha del RF-25: Consultar votos de un reporte*

|                         |                                                                                                                                  |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-25                                                                                                                            |
| **Nombre corto**        | Consultar votos de un reporte                                                                                                    |
| **Descripción**         | El sistema debe permitir consultar todos los votos de validación registrados sobre un reporte, con su autor, valor y comentario. |
| **HU de origen**        | HU-24                                                                                                                            |
| **RN que hace cumplir** | Ninguna                                                                                                                          |
| **Prioridad**           | Media                                                                                                                            |

Tabla  
*Ficha del RF-26: Subir evidencia fotográfica*

|                         |                                                                                                                             |
|-------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-26                                                                                                                       |
| **Nombre corto**        | Subir evidencia fotográfica                                                                                                 |
| **Descripción**         | El sistema debe permitir subir una fotografía como evidencia de un reporte existente, registrando su URL y fecha de subida. |
| **HU de origen**        | HU-25                                                                                                                       |
| **RN que hace cumplir** | Ninguna                                                                                                                     |
| **Prioridad**           | Media                                                                                                                       |

Tabla  
*Ficha del RF-27: Consultar evidencias de un reporte*

|                         |                                                                                        |
|-------------------------|----------------------------------------------------------------------------------------|
| **Código**              | RF-27                                                                                  |
| **Nombre corto**        | Consultar evidencias de un reporte                                                     |
| **Descripción**         | El sistema debe permitir consultar las evidencias fotográficas asociadas a un reporte. |
| **HU de origen**        | HU-26                                                                                  |
| **RN que hace cumplir** | Ninguna                                                                                |
| **Prioridad**           | Media                                                                                  |

Tabla  
*Ficha del RF-28: Consultar historial de accesos*

|                         |                                                                                                                                                     |
|-------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-28                                                                                                                                               |
| **Nombre corto**        | Consultar historial de accesos                                                                                                                      |
| **Descripción**         | El sistema debe permitir consultar el historial de accesos (consulta o modificación, autorizado o denegado) registrado para un perfil de movilidad. |
| **HU de origen**        | HU-28                                                                                                                                               |
| **RN que hace cumplir** | Ninguna                                                                                                                                             |
| **Prioridad**           | Alta                                                                                                                                                |

Tabla  
*Ficha del RF-29: Calcular ruta accesible*

|                         |                                                                                                                                                                              |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-29                                                                                                                                                                        |
| **Nombre corto**        | Calcular ruta accesible                                                                                                                                                      |
| **Descripción**         | El sistema debe calcular una ruta entre un origen y un destino, determinando su distancia, duración, nivel de accesibilidad y barreras esquivadas en el momento del cálculo. |
| **HU de origen**        | HU-29                                                                                                                                                                        |
| **RN que hace cumplir** | RN-12 (cálculo único de accesibilidad)                                                                                                                                       |
| **Prioridad**           | Alta                                                                                                                                                                         |

Tabla  
*Ficha del RF-30: Consultar ruta calculada*

|                         |                                                                                                                                        |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-30                                                                                                                                  |
| **Nombre corto**        | Consultar ruta calculada                                                                                                               |
| **Descripción**         | El sistema debe permitir consultar una ruta calculada previamente, mostrando los datos con los que quedó registrada sin recalcularlos. |
| **HU de origen**        | HU-30                                                                                                                                  |
| **RN que hace cumplir** | RN-12 (no se recalcula después de creada)                                                                                              |
| **Prioridad**           | Media                                                                                                                                  |

Tabla  
*Ficha del RF-31: Consultar segmentos de una ruta*

|                         |                                                                                                                                                            |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-31                                                                                                                                                      |
| **Nombre corto**        | Consultar segmentos de una ruta                                                                                                                            |
| **Descripción**         | El sistema debe permitir consultar los segmentos de una ruta ordenados según su secuencia, sin permitir dos segmentos con el mismo orden en la misma ruta. |
| **HU de origen**        | HU-31                                                                                                                                                      |
| **RN que hace cumplir** | RN-13 (orden de segmento único por ruta)                                                                                                                   |
| **Prioridad**           | Media                                                                                                                                                      |

Tabla  
*Ficha del RF-32: Registrar punto accesible*

|                         |                                                                                                                  |
|-------------------------|------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-32                                                                                                            |
| **Nombre corto**        | Registrar punto accesible                                                                                        |
| **Descripción**         | El sistema debe registrar un punto accesible con su tipo de elemento y ubicación, dejándolo en estado Operativo. |
| **HU de origen**        | HU-32                                                                                                            |
| **RN que hace cumplir** | RN-14 (campos obligatorios del punto accesible)                                                                  |
| **Prioridad**           | Alta                                                                                                             |

Tabla  
*Ficha del RF-33: Consultar punto accesible*

|                         |                                                                                                                              |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-33                                                                                                                        |
| **Nombre corto**        | Consultar punto accesible                                                                                                    |
| **Descripción**         | El sistema debe permitir consultar un punto accesible por su identificador, mostrando tipo, nivel de accesibilidad y estado. |
| **HU de origen**        | HU-33                                                                                                                        |
| **RN que hace cumplir** | Ninguna                                                                                                                      |
| **Prioridad**           | Media                                                                                                                        |

Tabla  
*Ficha del RF-34: Actualizar punto accesible*

|                         |                                                                                                                       |
|-------------------------|-----------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-34                                                                                                                 |
| **Nombre corto**        | Actualizar punto accesible                                                                                            |
| **Descripción**         | El sistema debe permitir actualizar los datos de un punto accesible existente (nivel de accesibilidad y descripción). |
| **HU de origen**        | HU-34                                                                                                                 |
| **RN que hace cumplir** | Ninguna                                                                                                               |
| **Prioridad**           | Baja                                                                                                                  |

Tabla  
*Ficha del RF-35: Cambiar estado de punto accesible*

|                         |                                                                                                                    |
|-------------------------|--------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-35                                                                                                              |
| **Nombre corto**        | Cambiar estado de punto accesible                                                                                  |
| **Descripción**         | El sistema debe permitir cambiar el estado de un punto accesible (Operativo, En Mantenimiento, Fuera de Servicio). |
| **HU de origen**        | HU-35                                                                                                              |
| **RN que hace cumplir** | Ninguna                                                                                                            |
| **Prioridad**           | Media                                                                                                              |

Tabla  
*Ficha del RF-36: Cambiar estado de un rol*

|                         |                                                                                                                                                                                              |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**              | RF-36                                                                                                                                                                                        |
| **Nombre corto**        | Cambiar estado de un rol                                                                                                                                                                     |
| **Descripción**         | El sistema debe permitir cambiar el estado de un rol (Activo, Inactivo) sin eliminarlo, de modo que un rol inactivo deje de asignarse a usuarios nuevos y lo conserven quienes ya lo tienen. |
| **HU de origen**        | HU-36                                                                                                                                                                                        |
| **RN que hace cumplir** | RN-15 (rol inactivo no asignable); RN-16 (las bajas son inactivación)                                                                                                                        |
| **Prioridad**           | Baja                                                                                                                                                                                         |

