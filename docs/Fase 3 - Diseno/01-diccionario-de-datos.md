## 3.1 Diccionario de datos

El diccionario de datos describe las doce tablas del sistema. Para cada campo indica el tipo, el tamaño, si admite valores nulos, su papel como llave y la regla de negocio que lo afecta. La lo resume y, después de ella, se presenta completo. Las correcciones hechas a partir de la revisión de la docente quedan registradas en el propio diccionario como Correcciones 1 a 10. Dos de ellas responden a la regla de que las bajas se registran como inactivación: el rol (estado ACTIVO o INACTIVO) y la asociación entre una barrera y un equipo afectado (estado ACTIVA o INACTIVA) no se eliminan, como establece la regla de negocio §3 del diccionario.

Tabla  
*Tablas del diccionario de datos*

| **Tabla**                         | **Propósito**                                                                         | **Campos** |
|-----------------------------------|---------------------------------------------------------------------------------------|------------|
| rol                               | Catálogo de roles y niveles de permiso                                                | 4          |
| usuario                           | Identidad, credenciales y estado de acceso                                            | 7          |
| perfil_movilidad                  | Condición física y equipo de asistencia del usuario (dato sensible, Ley 1581 de 2012) | 13         |
| auditoria_acceso_perfil_movilidad | Registro de cada acceso al perfil de movilidad                                        | 6          |
| barrera                           | Obstáculos identificados en la vía pública                                            | 9          |
| barrera_equipo_afectado           | Equipos de asistencia que afecta cada barrera                                         | 5          |
| punto_accesible                   | Infraestructura accesible georreferenciada                                            | 10         |
| ruta                              | Cabecera del trayecto calculado para el usuario                                       | 13         |
| segmento_ruta                     | Tramos consecutivos que componen una ruta                                             | 11         |
| reporte                           | Notificaciones de los usuarios sobre barreras                                         | 8          |
| validacion_reporte                | Votos de la comunidad sobre un reporte                                                | 6          |
| evidencia_fotografica             | Fotografías que respaldan un reporte                                                  | 4          |
| **Total**                         |                                                                                       | **96**     |

*Nota.* Elaboración propia a partir del diccionario de datos.

A continuación se presenta el diccionario completo, una tabla por cada tabla del sistema. Cada una lista sus campos con el tipo, el tamaño y la admisión de nulos (Tam./Nulo), si el campo es autoincremental (AI), su papel como llave primaria (PK), llave foránea (FK) o atributo (Tipo Rel.), la tabla relacionada y la regla de negocio que lo afecta.

Tabla  
*Campos de la tabla usuario*

| **Campo**       | **Tipo** | **Tam./Nulo**  | **AI / Tipo Rel.**    | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                  |
|-----------------|----------|----------------|-----------------------|----------------|-----------------------------------------------------------------------------------------------------|
| id_usuario      | INT      | — / NOT NULL   | Sí / PK               | —              | Identificador único secuencial del usuario.                                                         |
| id_rol          | INT      | — / NOT NULL   | No / FK               | rol            | Relación obligatoria con el catálogo de roles (id_rol).                                             |
| nombre_completo | VARCHAR  | 100 / NOT NULL | No / Atributo         | —              | Nombre y apellidos del usuario.                                                                     |
| correo          | VARCHAR  | 150 / NOT NULL | No / Atributo, UNIQUE | —              | Correo electrónico principal.                                                                       |
| contrasena_hash | VARCHAR  | 255 / NOT NULL | No / Atributo         | —              | Hash cifrado de la contraseña (BCrypt o Argon2).                                                    |
| estado          | ENUM     | 20 / NOT NULL  | No / Atributo         | —              | Restringido a (ACTIVO, INACTIVO, SUSPENDIDO). Por defecto: ACTIVO.                                  |
| fecha_registro  | DATETIME | — / NOT NULL   | No / Atributo         | —              | Fecha y hora exacta de creación de la cuenta. Por defecto: fecha y hora actual (CURRENT_TIMESTAMP). |

*Nota.* Propósito: Almacenar la identidad, credenciales y estado de acceso de las personas que utilizan la plataforma.

Tabla  
*Campos de la tabla rol*

| **Campo**   | **Tipo** | **Tam./Nulo** | **AI / Tipo Rel.**    | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                                                                                                  |
|-------------|----------|---------------|-----------------------|----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| id_rol      | INT      | — / NOT NULL  | Sí / PK               | —              | Identificador único del rol.                                                                                                                                                        |
| nombre      | VARCHAR  | 50 / NOT NULL | No / Atributo, UNIQUE | —              | Nombre único del rol. Ej: PCD, Gestor Comunitario, Administrador del Sistema.                                                                                                       |
| descripcion | VARCHAR  | 255 / NULL    | No / Atributo         | —              | Explicación breve del alcance y permisos asociados al rol.                                                                                                                          |
| estado      | ENUM     | 20 / NOT NULL | No / Atributo         | —              | Restringido a (ACTIVO, INACTIVO). Por defecto: ACTIVO. Un rol no se elimina: al inactivarse deja de poder asignarse a usuarios nuevos y los usuarios que ya lo tienen lo conservan. |

*Nota.* Propósito: Definir los roles y niveles de permiso que pueden ser asignados a los usuarios del sistema PAU. Corrección 9: se agregó el campo estado para que los roles se den de baja por inactivación y no por eliminación.

Tabla  
*Campos de la tabla perfil_movilidad*

| **Campo**            | **Tipo** | **Tam./Nulo**  | **AI / Tipo Rel.** | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                                    |
|----------------------|----------|----------------|--------------------|----------------|-----------------------------------------------------------------------------------------------------------------------|
| id_perfil            | INT      | — / NOT NULL   | Sí / PK            | —              | Identificador único del perfil de movilidad.                                                                          |
| id_usuario           | INT      | — / NOT NULL   | No / FK, UNIQUE    | usuario        | Referencia al usuario titular. Relación 1:1 estricta.                                                                 |
| tipo_discapacidad    | ENUM     | 50 / NOT NULL  | No / Atributo      | —              | \[DATO SENSIBLE\] (MOTRIZ, VISUAL, AUDITIVA, COGNITIVA, MULTIPLE).                                                    |
| grado_discapacidad   | ENUM     | 30 / NOT NULL  | No / Atributo      | —              | \[DATO SENSIBLE\] (LEVE, MODERADO, SEVERO, TOTAL).                                                                    |
| condicion_movilidad  | ENUM     | 50 / NOT NULL  | No / Atributo      | —              | (USUARIO_SILLA_RUEDAS_TOTAL, MOVILIDAD_REDUCIDA_PUESTA_EN_PIE, AMBULANTE_CON_SOPORTE, MOVILIDAD_REDUCIDA_SIN_EQUIPO). |
| equipo_asistencia    | ENUM     | 50 / NOT NULL  | No / Atributo      | —              | (SILLA_MANUAL, SILLA_ELECTRICA, MULETAS, BASTON, ANDADOR, NINGUNO).                                                   |
| requiere_asistente   | BOOLEAN  | — / NOT NULL   | No / Atributo      | —              | Indica si va acompañado por un tercero o perro guía.                                                                  |
| pendiente_maxima     | DECIMAL  | 5,2 / NOT NULL | No / Atributo      | —              | Porcentaje máximo de inclinación permitido.                                                                           |
| distancia_maxima_pie | INT      | — / NULL       | No / Atributo      | —              | Metros máximos de caminata continua recomendados.                                                                     |
| tolerancia_escalones | INT      | — / NOT NULL   | No / Atributo      | —              | Número de escalones continuos tolerados.                                                                              |
| evita_escaleras      | BOOLEAN  | — / NOT NULL   | No / Atributo      | —              | Exclusión absoluta de escaleras en el trazado.                                                                        |
| priorizar_rampas     | BOOLEAN  | — / NOT NULL   | No / Atributo      | —              | Ponderación para exigir infraestructura de rampa.                                                                     |
| priorizar_ascensores | BOOLEAN  | — / NOT NULL   | No / Atributo      | —              | Priorización de conectores mecánicos/elevadores.                                                                      |

*Nota.* Propósito: Registrar la condición física y el equipamiento de asistencia del usuario para alimentar el motor de búsqueda de rutas. Cláusula de Protección de Datos Sensibles (Ley 1581 de 2012): tipo_discapacidad y grado_discapacidad son datos sensibles y exigen autorización explícita, cifrado en reposo (AES-256), acceso restringido por rol y uso exclusivo para el cálculo de accesibilidad.

Tabla  
*Campos de la tabla barrera*

| **Campo**                 | **Tipo** | **Tam./Nulo**   | **AI / Tipo Rel.** | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                                                                                                             |
|---------------------------|----------|-----------------|--------------------|----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| id_barrera                | INT      | — / NOT NULL    | Sí / PK            | —              | Identificador único de la barrera.                                                                                                                                                             |
| tipo_barrera              | ENUM     | 50 / NOT NULL   | No / Atributo      | —              | (ESCALERA_SIN_RAMPA, ANDEN_ROTO, HUECO, SEMAFORO_SIN_SONIDO, OBSTACULO_EN_ANDEN, PENDIENTE_EXCESIVA).                                                                                          |
| nivel_gravedad            | ENUM     | 30 / NOT NULL   | No / Atributo      | —              | (BAJA, MEDIA, CRITICA_BLOQUEO_TOTAL). Por defecto: MEDIA.                                                                                                                                      |
| equipo_afectado_principal | ENUM     | 50 / NULL       | No / Atributo      | —              | (SILLA_MANUAL, SILLA_ELECTRICA, MULETAS_BASTON, TODOS). Se conserva como equipo principal de referencia rápida mientras se migra el detalle completo a barrera_equipo_afectado (corrección 2). |
| latitud                   | DECIMAL  | 10,6 / NOT NULL | No / Atributo      | —              | Coordenada GPS latitud.                                                                                                                                                                        |
| longitud                  | DECIMAL  | 10,6 / NOT NULL | No / Atributo      | —              | Coordenada GPS longitud.                                                                                                                                                                       |
| descripcion               | TEXT     | — / NULL        | No / Atributo      | —              | Detalle explicativo de la barrera o referencia del lugar.                                                                                                                                      |
| estado                    | ENUM     | 20 / NOT NULL   | No / Atributo      | —              | (REPORTADA, VERIFICADA, RESUELTA, INACTIVA). Su transición es gobernada por la Regla de negocio §2 (propagación desde reporte.estado_reporte); ver sección Reglas de Negocio.                  |
| fecha_registro            | DATETIME | — / NOT NULL    | No / Atributo      | —              | Timestamp de creación en el sistema. Por defecto: fecha y hora actual (CURRENT_TIMESTAMP).                                                                                                     |

*Nota.* Propósito: Registrar y catalogar cada obstáculo físico o ambiental identificado en la vía pública. Corrección 2: se conserva equipo_afectado_principal (no se elimina) y se agrega la tabla puente barrera_equipo_afectado para representar que una barrera puede afectar a varios equipos. Corrección 5: el campo estado ahora referencia explícitamente la regla de negocio que define su relación con reporte.estado_reporte.

Tabla  
*Campos de la tabla barrera_equipo_afectado (nueva, Corrección 2)*

| **Campo**         | **Tipo** | **Tam./Nulo** | **AI / Tipo Rel.** | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                                     |
|-------------------|----------|---------------|--------------------|----------------|------------------------------------------------------------------------------------------------------------------------|
| id_barrera_equipo | INT      | — / NOT NULL  | Sí / PK            | —              | Identificador único de la relación barrera–equipo.                                                                     |
| id_barrera        | INT      | — / NOT NULL  | No / FK            | barrera        | Barrera afectada.                                                                                                      |
| equipo_afectado   | ENUM     | 50 / NOT NULL | No / Atributo      | —              | (SILLA_MANUAL, SILLA_ELECTRICA, MULETAS_BASTON, TODOS). Mismo dominio que equipo_afectado_principal.                   |
| estado            | ENUM     | 20 / NOT NULL | No / Atributo      | —              | Restringido a (ACTIVA, INACTIVA). Por defecto: ACTIVA. Una asociación registrada por error se inactiva, no se elimina. |
| fecha_registro    | DATETIME | — / NOT NULL  | No / Atributo      | —              | Timestamp de creación del registro. Por defecto: fecha y hora actual (CURRENT_TIMESTAMP).                              |

*Nota.* Propósito: Tabla puente que permite que una misma barrera afecte a varios equipos de asistencia, sin perder el campo equipo_afectado_principal ya existente en barrera. Restricción: UNIQUE (id_barrera, equipo_afectado) — evita duplicar el mismo equipo para la misma barrera, aunque la asociación esté inactiva. Si se vuelve a asociar un equipo cuya asociación está INACTIVA, esa fila se reactiva (estado = ACTIVA) en lugar de crear otra. Corrección 10: se agregó el campo estado para que las asociaciones se den de baja por inactivación y no por eliminación.

Tabla  
*Campos de la tabla ruta*

| **Campo**             | **Tipo** | **Tam./Nulo**   | **AI / Tipo Rel.**     | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                                                                                                                                                                                                                 |
|-----------------------|----------|-----------------|------------------------|----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| id_ruta               | INT      | — / NOT NULL    | Sí / PK                | —              | Identificador único de la ruta generada.                                                                                                                                                                                                                                                           |
| id_usuario            | INT      | — / NOT NULL    | No / FK                | usuario        | Usuario que solicitó el cálculo del trayecto.                                                                                                                                                                                                                                                      |
| origen_direccion      | VARCHAR  | 255 / NOT NULL  | No / Atributo          | —              | Dirección o lugar de partida.                                                                                                                                                                                                                                                                      |
| origen_latitud        | DECIMAL  | 10,6 / NOT NULL | No / Atributo          | —              | Coordenada GPS latitud del punto inicial.                                                                                                                                                                                                                                                          |
| origen_longitud       | DECIMAL  | 10,6 / NOT NULL | No / Atributo          | —              | Coordenada GPS longitud del punto inicial.                                                                                                                                                                                                                                                         |
| destino_direccion     | VARCHAR  | 255 / NOT NULL  | No / Atributo          | —              | Dirección o lugar de llegada.                                                                                                                                                                                                                                                                      |
| destino_latitud       | DECIMAL  | 10,6 / NOT NULL | No / Atributo          | —              | Coordenada GPS latitud del punto final.                                                                                                                                                                                                                                                            |
| destino_longitud      | DECIMAL  | 10,6 / NOT NULL | No / Atributo          | —              | Coordenada GPS longitud del punto final.                                                                                                                                                                                                                                                           |
| distancia_total_m     | DECIMAL  | 10,2 / NOT NULL | No / Atributo          | —              | Distancia total del recorrido en metros.                                                                                                                                                                                                                                                           |
| duracion_estimada_min | INT      | — / NOT NULL    | No / Atributo          | —              | Tiempo estimado de desplazamiento en minutos.                                                                                                                                                                                                                                                      |
| nivel_accesibilidad   | ENUM     | 30 / NOT NULL   | No / Atributo Derivado | —              | (ALTA_ACCESIBILIDAD, ACCESIBLE_CON_PRECAUCION, ACCESIBILIDAD_LIMITADA). Se calcula UNA sola vez, en el momento de creación de la ruta, evaluando pendientes y barreras del área. El valor guardado es una instantánea histórica y no se recalcula después, aunque cambien las barreras del sector. |
| barreras_esquivadas   | INT      | — / NOT NULL    | No / Atributo Derivado | —              | Contador de barreras desviadas al trazar la ruta. Igual que nivel_accesibilidad, se calcula una sola vez al crear la ruta y queda fijo como instantánea histórica.                                                                                                                                 |
| fecha_creacion        | DATETIME | — / NOT NULL    | No / Atributo          | —              | Fecha y hora en que se calculó la ruta. Por defecto: fecha y hora actual (CURRENT_TIMESTAMP).                                                                                                                                                                                                      |

*Nota.* Propósito: Almacenar la cabecera del trayecto calculado para el usuario. Corrección 8: se precisó cuándo se recalculan nivel_accesibilidad y barreras_esquivadas (al crear la ruta) y se dejó explícito que no se recalculan después: la ruta guardada es una instantánea histórica.

Tabla  
*Campos de la tabla segmento_ruta*

| **Campo**            | **Tipo** | **Tam./Nulo**   | **AI / Tipo Rel.**                  | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                                                                                          |
|----------------------|----------|-----------------|-------------------------------------|----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| id_segmento          | INT      | — / NOT NULL    | Sí / PK                             | —              | Identificador único del tramo.                                                                                                                                              |
| id_ruta              | INT      | — / NOT NULL    | No / FK                             | ruta           | Ruta padre a la que pertenece este tramo.                                                                                                                                   |
| orden_segmento       | INT      | — / NOT NULL    | No / Atributo, UNIQUE (con id_ruta) | —              | Secuencia numérica del tramo dentro del recorrido (1, 2, 3...). Restricción UNIQUE (id_ruta, orden_segmento): impide dos tramos con el mismo orden dentro de la misma ruta. |
| lat_inicio           | DECIMAL  | 10,6 / NOT NULL | No / Atributo                       | —              | Coordenada GPS latitud inicial del tramo.                                                                                                                                   |
| lon_inicio           | DECIMAL  | 10,6 / NOT NULL | No / Atributo                       | —              | Coordenada GPS longitud inicial del tramo.                                                                                                                                  |
| lat_fin              | DECIMAL  | 10,6 / NOT NULL | No / Atributo                       | —              | Coordenada GPS latitud final del tramo.                                                                                                                                     |
| lon_fin              | DECIMAL  | 10,6 / NOT NULL | No / Atributo                       | —              | Coordenada GPS longitud final del tramo.                                                                                                                                    |
| distancia_tramo_m    | DECIMAL  | 8,2 / NOT NULL  | No / Atributo                       | —              | Longitud del segmento en metros.                                                                                                                                            |
| pendiente_porcentaje | DECIMAL  | 5,2 / NOT NULL  | No / Atributo                       | —              | Grado de inclinación del tramo; se compara contra pendiente_maxima del perfil.                                                                                              |
| tiene_rampa          | BOOLEAN  | — / NOT NULL    | No / Atributo                       | —              | Indica si el tramo cuenta con rampa de acceso peatonal adecuada.                                                                                                            |
| tipo_superficie      | ENUM     | 50 / NOT NULL   | No / Atributo                       | —              | (PAVIMENTO_LISO, ADOQUIN, TIERRA, GRANITO_RUGOSO).                                                                                                                          |

*Nota.* Propósito: Almacenar la descomposición vectorial del trayecto en tramos consecutivos. Corrección 4: se agregó la restricción UNIQUE (id_ruta, orden_segmento).

Tabla  
*Campos de la tabla reporte*

| **Campo**           | **Tipo** | **Tam./Nulo**              | **AI / Tipo Rel.**     | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                                                                                                                                                      |
|---------------------|----------|----------------------------|------------------------|----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| id_reporte          | INT      | — / NOT NULL               | Sí / PK                | —              | Identificador único del reporte.                                                                                                                                                                                                        |
| id_usuario          | INT      | — / NOT NULL               | No / FK                | usuario        | Usuario que genera la alerta o reporte.                                                                                                                                                                                                 |
| id_barrera          | INT      | — / NULL permitido (CHECK) | No / FK                | barrera        | Obstáculo físico asociado al reporte. Puede ser NULL únicamente cuando origen_reporte = 'NUEVA_BARRERA', caso en el que la barrera aún no existe en el catálogo. CHECK: id_barrera NOT NULL cuando origen_reporte \<\> 'NUEVA_BARRERA'. |
| origen_reporte      | ENUM     | 30 / NOT NULL              | No / Atributo          | —              | (NUEVA_BARRERA, ACTUALIZACION_ESTADO, ALERTA_TEMPORAL).                                                                                                                                                                                 |
| estado_reporte      | ENUM     | 30 / NOT NULL              | No / Atributo          | —              | (PENDIENTE, CONFIRMADO, RECHAZADO, RESUELTO). Por defecto: PENDIENTE. Es la fuente de verdad del ciclo de validación comunitaria; ver Regla de negocio §2 sobre su propagación hacia barrera.estado.                                    |
| nivel_confianza     | DECIMAL  | 5,2 / NOT NULL             | No / Atributo Derivado | —              | (1.00 a 5.00). Se recalcula cada vez que se registra una nueva fila en validacion_reporte, contando únicamente un voto por usuario gracias a la restricción UNIQUE (id_reporte, id_usuario) de esa tabla (corrección 3).                |
| observacion_usuario | TEXT     | — / NULL                   | No / Atributo          | —              | Detalle o comentario breve del usuario sobre la afectación.                                                                                                                                                                             |
| fecha_reporte       | DATETIME | — / NOT NULL               | No / Atributo          | —              | Timestamp exacto de creación del reporte. Por defecto: fecha y hora actual (CURRENT_TIMESTAMP).                                                                                                                                         |

*Nota.* Propósito: Almacenar las notificaciones emitidas por los usuarios sobre barreras o contingencias en la vía pública. Corrección 1: id_barrera pasa a admitir NULL y se agrega el CHECK que lo exige NOT NULL salvo cuando origen_reporte = 'NUEVA_BARRERA'. No se creó ninguna tabla nueva para esto.

Tabla  
*Campos de la tabla validacion_reporte*

| **Campo**        | **Tipo** | **Tam./Nulo** | **AI / Tipo Rel.**               | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                                                             |
|------------------|----------|---------------|----------------------------------|----------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| id_validacion    | INT      | — / NOT NULL  | Sí / PK                          | —              | Identificador único de la validación.                                                                                                          |
| id_reporte       | INT      | — / NOT NULL  | No / FK, UNIQUE (con id_usuario) | reporte        | Reporte que se está validando. Restricción UNIQUE (id_reporte, id_usuario): un mismo usuario no puede validar el mismo reporte más de una vez. |
| id_usuario       | INT      | — / NOT NULL  | No / FK                          | usuario        | Usuario miembro de la comunidad que valida.                                                                                                    |
| es_valido        | BOOLEAN  | — / NOT NULL  | No / Atributo                    | —              | TRUE si confirma la barrera/evento, FALSE si la desmiente o ya no existe.                                                                      |
| comentario       | TEXT     | — / NULL      | No / Atributo                    | —              | Observación opcional sobre la verificación en terreno.                                                                                         |
| fecha_validacion | DATETIME | — / NOT NULL  | No / Atributo                    | —              | Timestamp exacto del voto de validación. Por defecto: fecha y hora actual (CURRENT_TIMESTAMP).                                                 |

*Nota.* Propósito: Registrar las confirmaciones, rechazos y comentarios de la comunidad sobre un reporte emitido. Corrección 3: se agregó la restricción UNIQUE (id_reporte, id_usuario), sin la cual nivel_confianza sería manipulable por votos repetidos del mismo usuario.

Tabla  
*Campos de la tabla evidencia_fotografica*

| **Campo**    | **Tipo** | **Tam./Nulo**  | **AI / Tipo Rel.** | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                       |
|--------------|----------|----------------|--------------------|----------------|----------------------------------------------------------------------------------------------------------|
| id_evidencia | INT      | — / NOT NULL   | Sí / PK            | —              | Identificador único de la evidencia fotográfica.                                                         |
| id_reporte   | INT      | — / NOT NULL   | No / FK            | reporte        | Reporte al que pertenece la fotografía.                                                                  |
| url_foto     | VARCHAR  | 255 / NOT NULL | No / Atributo      | —              | Enlace (URL) al almacenamiento en la nube (S3, Cloudinary, etc.).                                        |
| fecha_subida | DATETIME | — / NOT NULL   | No / Atributo      | —              | Timestamp exacto en el que se cargó la fotografía. Por defecto: fecha y hora actual (CURRENT_TIMESTAMP). |

*Nota.* Propósito: Almacenar las imágenes enviadas como evidencia en cada reporte (1FN).

Tabla  
*Campos de la tabla punto_accesible*

| **Campo**                    | **Tipo** | **Tam./Nulo**   | **AI / Tipo Rel.** | **Tabla Rel.** | **Descripción / Regla de Negocio**                                                                                                                                                                              |
|------------------------------|----------|-----------------|--------------------|----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| id_punto_accesible           | INT      | — / NOT NULL    | Sí / PK            | —              | Identificador único del punto de infraestructura accesible.                                                                                                                                                     |
| id_usuario_registra          | INT      | — / NOT NULL    | No / FK            | usuario        | Usuario que registró el punto accesible. Alinea la tabla con la asociación 'registra' que ya existe entre Usuario y PuntoAccesible en el diagrama de clases (antes la tabla no tenía ninguna FK hacia usuario). |
| tipo_elemento                | ENUM     | 50 / NOT NULL   | No / Atributo      | —              | (RAMPA_ACCESIBLE, ASCENSOR_URBANO, BANO_ADAPTADO, VADO_PEATONAL, PASO_NIVELADO, SEMAFORO_SONORO).                                                                                                               |
| nivel_accesibilidad          | ENUM     | 30 / NOT NULL   | No / Atributo      | —              | (EXCELENTE, BUENA, REGULAR). Por defecto: BUENA.                                                                                                                                                                |
| equipo_beneficiado_principal | ENUM     | 50 / NULL       | No / Atributo      | —              | (SILLA_MANUAL, SILLA_ELECTRICA, MULETAS_BASTON, TODOS).                                                                                                                                                         |
| latitud                      | DECIMAL  | 10,6 / NOT NULL | No / Atributo      | —              | Coordenada GPS latitud.                                                                                                                                                                                         |
| longitud                     | DECIMAL  | 10,6 / NOT NULL | No / Atributo      | —              | Coordenada GPS longitud.                                                                                                                                                                                        |
| descripcion                  | TEXT     | — / NULL        | No / Atributo      | —              | Detalle explicativo de la ubicación o características.                                                                                                                                                          |
| estado                       | ENUM     | 20 / NOT NULL   | No / Atributo      | —              | (OPERATIVO, EN_MANTENIMIENTO, FUERA_DE_SERVICIO). Por defecto: OPERATIVO.                                                                                                                                       |
| fecha_registro               | DATETIME | — / NOT NULL    | No / Atributo      | —              | Timestamp exacto de creación o registro del punto. Por defecto: fecha y hora actual (CURRENT_TIMESTAMP).                                                                                                        |

*Nota.* Propósito: Registrar, catalogar y georreferenciar los elementos de infraestructura urbana accesible. Corrección 7: se agregó id_usuario_registra (FK a usuario) en lugar de quitar la asociación del diagrama, ya que el diagrama ya representa correctamente la relación 'registra' entre Usuario y PuntoAccesible; el desalineamiento estaba solo en la tabla.

Tabla  
*Campos de la tabla auditoria_acceso_perfil_movilidad (nueva, Corrección 6)*

| **Campo**    | **Tipo** | **Tam./Nulo** | **AI / Tipo Rel.** | **Tabla Rel.**   | **Descripción / Regla de Negocio**                                                            |
|--------------|----------|---------------|--------------------|------------------|-----------------------------------------------------------------------------------------------|
| id_auditoria | INT      | — / NOT NULL  | Sí / PK            | —                | Identificador único del registro de auditoría.                                                |
| id_perfil    | INT      | — / NOT NULL  | No / FK            | perfil_movilidad | Perfil de movilidad consultado o modificado.                                                  |
| id_usuario   | INT      | — / NOT NULL  | No / FK            | usuario          | Usuario (por su id_rol) que realizó el acceso.                                                |
| accion       | ENUM     | 20 / NOT NULL | No / Atributo      | —                | Restringido a (CONSULTA, MODIFICACION).                                                       |
| resultado    | ENUM     | 20 / NOT NULL | No / Atributo      | —                | Restringido a (AUTORIZADO, DENEGADO).                                                         |
| fecha_acceso | DATETIME | — / NOT NULL  | No / Atributo      | —                | Timestamp exacto del intento de acceso. Por defecto: fecha y hora actual (CURRENT_TIMESTAMP). |

*Nota.* Propósito: Dejar trazabilidad independiente de cada acceso al dato sensible almacenado en perfil_movilidad, tal como lo exige la cláusula de protección de datos (Ley 1581 de 2012) ya redactada por el equipo en esa tabla. Esta tabla es independiente del resto del modelo: no modifica perfil_movilidad, solo registra quién accede y cuándo, cumpliendo el requisito de demostrar que el acceso restringido por rol (id_rol) efectivamente se aplica.

### 3.1.1 Restricciones adicionales

1\. reporte.id_barrera admite NULL; CHECK (origen_reporte = 'NUEVA_BARRERA' OR id_barrera IS NOT NULL). — Corrección 1.

2\. UNIQUE (id_barrera, equipo_afectado) en barrera_equipo_afectado. — Corrección 2.

3\. UNIQUE (id_reporte, id_usuario) en validacion_reporte. — Corrección 3.

4\. UNIQUE (id_ruta, orden_segmento) en segmento_ruta. — Corrección 4.

5\. Los campos estado de rol (ACTIVO, INACTIVO) y de barrera_equipo_afectado (ACTIVA, INACTIVA) implementan la baja por inactivación. — Correcciones 9 y 10.

6\. CHECK ck_reporte_confianza: reporte.nivel_confianza debe estar entre 1.00 y 5.00 (RN-11).

7\. Todas las tablas usan el motor InnoDB y el juego de caracteres utf8mb4, en la base de datos pau; cada UNIQUE, FOREIGN KEY y CHECK lleva nombre propio (uq\_, fk\_, ck\_) y cita su regla de negocio en el script de la sección 4.1.

### 3.1.2 Reglas de negocio del diccionario

**§1 — Recálculo de campos derivados (Corrección 8)**

nivel_accesibilidad y barreras_esquivadas (tabla ruta) se calculan una única vez, en el instante de creación de la ruta, a partir de las barreras y pendientes vigentes en ese momento. No se recalculan después: una ruta ya guardada es una instantánea histórica, aunque el estado de las barreras del sector cambie posteriormente. nivel_confianza (tabla reporte), en cambio, sí se recalcula de forma continua, cada vez que se inserta una nueva fila en validacion_reporte, respetando la restricción UNIQUE (id_reporte, id_usuario).

**§2 — Relación entre reporte.estado_reporte y barrera.estado (Corrección 5)**

No se elimina ninguno de los dos campos: representan ciclos de vida distintos y complementarios. reporte.estado_reporte es la fuente de verdad del proceso de validación comunitaria de UN reporte puntual (PENDIENTE → CONFIRMADO/RECHAZADO → RESUELTO). barrera.estado representa la condición vigente del obstáculo físico en la vía (REPORTADA, VERIFICADA, RESUELTA, INACTIVA) y se actualiza por propagación cuando el estado_reporte de alguno de sus reportes cambia, según esta correspondencia:

- reporte.estado_reporte = CONFIRMADO → barrera.estado pasa a VERIFICADA.

- reporte.estado_reporte = RESUELTO → barrera.estado pasa a RESUELTA.

- reporte.estado_reporte = RECHAZADO → barrera.estado permanece sin cambio (o vuelve a REPORTADA si era la única evidencia).

Si una barrera recibe varios reportes, su estado sigue el reporte de estado_reporte más avanzado en el ciclo (RESUELTO \> CONFIRMADO \> PENDIENTE \> RECHAZADO).

**§3 — Inactivación en lugar de eliminación (Correcciones 9 y 10)**

Los roles y las asociaciones barrera–equipo no se eliminan físicamente. Su baja se registra con el campo estado (rol: INACTIVO; barrera_equipo_afectado: INACTIVA), de modo que se conserve el historial. Un rol INACTIVO no puede asignarse a usuarios nuevos, y los usuarios que ya lo tienen lo conservan. Una asociación INACTIVA se reactiva cuando se vuelve a asociar el mismo equipo a la misma barrera.

