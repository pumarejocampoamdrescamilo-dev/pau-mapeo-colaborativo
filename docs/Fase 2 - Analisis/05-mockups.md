## 2.5 Mockups

Cada mockup lleva su código MK, declara qué historia y caso de uso atiende, usa los nombres y tipos del diccionario de datos, muestra el camino triste (los mensajes de rechazo de las reglas de negocio, tomados literalmente de los flujos alternos de la sección 2.4.3) y explica la consecuencia en los avisos. Las pantallas de detalle (reporte, barrera) alojan paneles de las clases hijas para no multiplicar pantallas por cada operación de apoyo. Las pantallas usan solo blanco, negro y gris, y las bajas se muestran como inactivación, nunca como eliminación. Las fichas se presentan en esta sección y las pantallas, desde la hasta la .

### 2.5.1 Fichas de mockups

Tabla  
*Ficha del MK-01: Catálogo de roles — Listado, búsqueda y cambio de estado*

|                          |                                                                                                                                                                                                                                                        |
|--------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-01                                                                                                                                                                                                                                                  |
| **Pantalla**             | Catálogo de roles — Listado, búsqueda y cambio de estado (R y U)                                                                                                                                                                                       |
| **Atiende (HU / CU)**    | HU-02 / CU-02 y HU-36 / CU-36 (y da entrada a CU-01 y CU-03)                                                                                                                                                                                           |
| **Campos ↔ Diccionario** | Columnas: id_rol, nombre, descripcion, estado (ACTIVO, INACTIVO) de la tabla rol                                                                                                                                                                       |
| **Botones ↔ Eventos**    | Buscar → consultarRol() (RF-02) · + Nuevo rol → abre MK-02 en modo crear (RF-01) · Editar → abre MK-02 con datos (RF-03) · Inactivar / Activar → cambiarEstado() (RF-36), con aviso que explica la consecuencia                                        |
| **RN visibles**          | RN-15 (aviso: el rol inactivo no se asigna a usuarios nuevos y quienes lo tienen lo conservan) · RN-16 (no hay Eliminar; mensaje “El rol ya está inactivo.”) · “No se encontró ningún rol con ese identificador.” es el CA-2 de la HU-02 y de la HU-36 |

Tabla  
*Ficha del MK-02: Registrar / Actualizar rol*

|                          |                                                                                                                                        |
|--------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-02                                                                                                                                  |
| **Pantalla**             | Registrar / Actualizar rol (C y U)                                                                                                     |
| **Atiende (HU / CU)**    | HU-01 / CU-01 (modo crear) y HU-03 / CU-03 (modo actualizar)                                                                           |
| **Campos ↔ Diccionario** | nombre (VARCHAR 50, UNIQUE), descripcion (VARCHAR 255, opcional); estado (solo lectura: un rol nuevo nace ACTIVO y cambia desde MK-01) |
| **Botones ↔ Eventos**    | Guardar → crearRol() (RF-01) o actualizarRol() (RF-03) · Cancelar → vuelve a MK-01                                                     |
| **RN visibles**          | RN-01 (mensaje “Ya existe un rol con ese nombre.”)                                                                                     |

Tabla  
*Ficha del MK-03: Registro de usuario*

|                          |                                                                                                                              |
|--------------------------|------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-03                                                                                                                        |
| **Pantalla**             | Registro de usuario (C)                                                                                                      |
| **Atiende (HU / CU)**    | HU-04 / CU-04                                                                                                                |
| **Campos ↔ Diccionario** | nombre_completo, correo (UNIQUE), contrasena_hash (campo de contraseña); id_rol fijo en “PCD” para el autorregistro          |
| **Botones ↔ Eventos**    | Registrarme → registrarUsuario() (RF-04)                                                                                     |
| **RN visibles**          | RN-02 (mensaje “Ese correo ya está registrado.”) · RN-15 (mensaje “El rol solicitado no está disponible.”, CA-3 de la HU-04) |

Tabla  
*Ficha del MK-04: Iniciar sesión*

|                          |                                                                                                                                                             |
|--------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-04                                                                                                                                                       |
| **Pantalla**             | Iniciar sesión (Auth)                                                                                                                                       |
| **Atiende (HU / CU)**    | HU-07 / CU-07                                                                                                                                               |
| **Campos ↔ Diccionario** | correo, contrasena_hash                                                                                                                                     |
| **Botones ↔ Eventos**    | Ingresar → autenticar() (RF-07)                                                                                                                             |
| **RN visibles**          | RN-03 (mensajes “Correo o contraseña incorrectos.” / “Esta cuenta está inactiva.” / “Esta cuenta está suspendida.”, Esquema del escenario CA-2 de la HU-07) |

Tabla  
*Ficha del MK-05: Mis datos personales*

|                          |                                                              |
|--------------------------|--------------------------------------------------------------|
| **Código**               | MK-05                                                        |
| **Pantalla**             | Mis datos personales (U)                                     |
| **Atiende (HU / CU)**    | HU-06 / CU-06                                                |
| **Campos ↔ Diccionario** | nombre_completo, correo; estado (solo lectura)               |
| **Botones ↔ Eventos**    | Guardar cambios → actualizarDatosPersonales() (RF-06)        |
| **RN visibles**          | RN-02 (mensaje “Ese correo ya está en uso por otra cuenta.”) |

Tabla  
*Ficha del MK-06: Administración de usuarios — Listado y cambio de estado*

|                          |                                                                                             |
|--------------------------|---------------------------------------------------------------------------------------------|
| **Código**               | MK-06                                                                                       |
| **Pantalla**             | Administración de usuarios — Listado y cambio de estado (R y U)                             |
| **Atiende (HU / CU)**    | HU-05 / CU-05 (consulta administrativa) y HU-08 / CU-08 (cambiar estado)                    |
| **Campos ↔ Diccionario** | Columnas: correo, nombre_completo, estado; filtro por estado (ACTIVO, INACTIVO, SUSPENDIDO) |
| **Botones ↔ Eventos**    | Cambiar estado → cambiarEstado() (RF-08)                                                    |
| **RN visibles**          | Ninguna directamente; “El usuario ya se encuentra en ese estado.” es el CA-2 de la HU-08    |

Tabla  
*Ficha del MK-07: Mi perfil de movilidad*

|                          |                                                                                                                                                                                                                                                                                                                                                   |
|--------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-07                                                                                                                                                                                                                                                                                                                                             |
| **Pantalla**             | Mi perfil de movilidad (C, R y U)                                                                                                                                                                                                                                                                                                                 |
| **Atiende (HU / CU)**    | HU-09 / CU-09 (registrar), HU-10 / CU-10 (consultar) y HU-11 / CU-11 (actualizar)                                                                                                                                                                                                                                                                 |
| **Campos ↔ Diccionario** | \[DATOS SENSIBLES, Ley 1581 de 2012\] tipo_discapacidad, grado_discapacidad (listas ENUM); condicion_movilidad y equipo_asistencia (listas ENUM); pendiente_maxima, distancia_maxima_pie y tolerancia_escalones (numéricos; tolerancia_escalones es INT); requiere_asistente, evita_escaleras, priorizar_rampas y priorizar_ascensores (casillas) |
| **Botones ↔ Eventos**    | Guardar → registrarPerfil() (RF-09) o actualizarPerfil() (RF-11), ambos disparando internamente AuditoriaAccesoPerfilMovilidad.registrarAcceso() («include», RF-12)                                                                                                                                                                               |
| **RN visibles**          | RN-04 (mensaje “Ya tienes un perfil de movilidad registrado.”) · RN-05 (el acceso queda registrado automáticamente; no es visible para el PCD, solo para auditoría en MK-08)                                                                                                                                                                      |

Tabla  
*Ficha del MK-08: Historial de accesos a un perfil de movilidad*

|                          |                                                                                                     |
|--------------------------|-----------------------------------------------------------------------------------------------------|
| **Código**               | MK-08                                                                                               |
| **Pantalla**             | Historial de accesos a un perfil de movilidad (R, solo Administrador)                               |
| **Atiende (HU / CU)**    | HU-28 / CU-28                                                                                       |
| **Campos ↔ Diccionario** | Columnas: accion (CONSULTA, MODIFICACION), resultado (AUTORIZADO, DENEGADO), fecha_acceso           |
| **Botones ↔ Eventos**    | Consultar → consultarHistorialAccesos() (RF-28)                                                     |
| **RN visibles**          | RN-05 (cada fila es la evidencia de cumplimiento; “Este perfil no registra accesos.” si está vacío) |

Tabla  
*Ficha del MK-09: Mapa y listado de barreras*

|                          |                                                                                                                  |
|--------------------------|------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-09                                                                                                            |
| **Pantalla**             | Mapa y listado de barreras (R)                                                                                   |
| **Atiende (HU / CU)**    | HU-13 / CU-13 (y da entrada a CU-12 y CU-14)                                                                     |
| **Campos ↔ Diccionario** | Pines en mapa (latitud, longitud); columnas tipo_barrera, nivel_gravedad, estado                                 |
| **Botones ↔ Eventos**    | \+ Nueva barrera → abre MK-10 (RF-13) · Cambiar estado → abre MK-11 (RF-15) · Ver equipos afectados → abre MK-12 |
| **RN visibles**          | Ninguna directamente; “No se encontró ninguna barrera con ese identificador.” es el CA de la HU-13               |

Tabla  
*Ficha del MK-10: Registrar barrera*

|                          |                                                                                                                                                                                                               |
|--------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-10                                                                                                                                                                                                         |
| **Pantalla**             | Registrar barrera (C)                                                                                                                                                                                         |
| **Atiende (HU / CU)**    | HU-12 / CU-12                                                                                                                                                                                                 |
| **Campos ↔ Diccionario** | tipo_barrera, nivel_gravedad, equipo_afectado_principal (opcional), latitud, longitud, descripcion (opcional)                                                                                                 |
| **Botones ↔ Eventos**    | Guardar → registrarBarrera() (RF-13)                                                                                                                                                                          |
| **RN visibles**          | RN-06 (mensajes de campo obligatorio: “Debe seleccionar el tipo de barrera.” / “Debe seleccionar el nivel de gravedad.” / “Debe indicar la ubicación de la barrera.”, Esquema del escenario CA-3 de la HU-12) |

Tabla  
*Ficha del MK-11: Cambiar estado de la barrera*

|                          |                                                                                                                                                                                                                                          |
|--------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-11                                                                                                                                                                                                                                    |
| **Pantalla**             | Cambiar estado de la barrera (U)                                                                                                                                                                                                         |
| **Atiende (HU / CU)**    | HU-14 / CU-14                                                                                                                                                                                                                            |
| **Campos ↔ Diccionario** | estado (REPORTADA, VERIFICADA, RESUELTA, INACTIVA)                                                                                                                                                                                       |
| **Botones ↔ Eventos**    | Guardar → cambiarEstado() (RF-15)                                                                                                                                                                                                        |
| **RN visibles**          | RN-09 (mensajes “La barrera ya se encuentra en ese estado.” / “Estado de barrera no válido.”; nota: este mismo método también se dispara automáticamente por propagación desde Reporte.cambiarEstado(), sin que el Gestor lo edite aquí) |

Tabla  
*Ficha del MK-12: Equipos afectados de una barrera*

|                          |                                                                                                                                            |
|--------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-12                                                                                                                                      |
| **Pantalla**             | Equipos afectados de una barrera (C, R e inactivación — panel dentro del detalle de la barrera)                                            |
| **Atiende (HU / CU)**    | HU-15 / CU-15, HU-16 / CU-16 y HU-17 / CU-17                                                                                               |
| **Campos ↔ Diccionario** | Lista de equipo_afectado con estado ACTIVA (chips); selector para agregar uno nuevo                                                        |
| **Botones ↔ Eventos**    | \+ Agregar equipo → asociarEquipoAfectado() (RF-16) · Inactivar → inactivarAsociacion() (RF-18), con aviso que explica la consecuencia     |
| **RN visibles**          | RN-07 (mensaje “Ese equipo ya está asociado a esta barrera.”) · RN-16 (la baja es inactivación; mensaje “La asociación ya está inactiva.”) |

Tabla  
*Ficha del MK-13: Crear reporte*

|                          |                                                                                                                                                                       |
|--------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-13                                                                                                                                                                 |
| **Pantalla**             | Crear reporte (C)                                                                                                                                                     |
| **Atiende (HU / CU)**    | HU-18 / CU-18                                                                                                                                                         |
| **Campos ↔ Diccionario** | origen_reporte (NUEVA_BARRERA, ACTUALIZACION_ESTADO, ALERTA_TEMPORAL), id_barrera (buscador; deshabilitado si origen = NUEVA_BARRERA), observacion_usuario (opcional) |
| **Botones ↔ Eventos**    | Enviar reporte → crearReporte() (RF-19)                                                                                                                               |
| **RN visibles**          | RN-08 (mensajes “Debe seleccionar el origen del reporte.” / “Debe indicar la barrera a la que se refiere esta actualización/alerta.”)                                 |

Tabla  
*Ficha del MK-14: Listado y detalle de reportes*

|                          |                                                                                                                                 |
|--------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-14                                                                                                                           |
| **Pantalla**             | Listado y detalle de reportes (R y U)                                                                                           |
| **Atiende (HU / CU)**    | HU-19 / CU-19 (y da entrada a CU-20 y CU-21), HU-20 / CU-20 y HU-21 / CU-21                                                     |
| **Campos ↔ Diccionario** | Columnas: estado_reporte, nivel_confianza, fecha_reporte; detalle con observacion_usuario                                       |
| **Botones ↔ Eventos**    | Cambiar estado → cambiarEstado() (RF-21, propaga a Barrera.cambiarEstado(), RN-09) · Asociar barrera → asociarBarrera() (RF-22) |
| **RN visibles**          | RN-09 (propagación del estado a la barrera) · RN-10 (mensaje “El reporte \[código\] ya está asociado a la barrera \[código\].”) |

Tabla  
*Ficha del MK-15: Votar validación de un reporte*

|                          |                                                                                                                          |
|--------------------------|--------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-15                                                                                                                    |
| **Pantalla**             | Votar validación de un reporte (C y R — panel dentro del detalle del reporte)                                            |
| **Atiende (HU / CU)**    | HU-23 / CU-23 (y da entrada a CU-24) y HU-24 / CU-24                                                                     |
| **Campos ↔ Diccionario** | es_valido (interruptor Sí/No), comentario (opcional); listado de votos existentes                                        |
| **Botones ↔ Eventos**    | Enviar voto → registrarVoto() (RF-24), que dispara internamente Reporte.recalcularConfianza() («include», RF-23)         |
| **RN visibles**          | RN-11 (mensaje “Ya registraste tu validación para este reporte.”; nivel_confianza se actualiza al instante tras el voto) |

Tabla  
*Ficha del MK-16: Evidencias fotográficas de un reporte*

|                          |                                                                                      |
|--------------------------|--------------------------------------------------------------------------------------|
| **Código**               | MK-16                                                                                |
| **Pantalla**             | Evidencias fotográficas de un reporte (C y R — panel dentro del detalle del reporte) |
| **Atiende (HU / CU)**    | HU-25 / CU-25 y HU-26 / CU-26                                                        |
| **Campos ↔ Diccionario** | Galería de url_foto con fecha_subida; selector de archivo para subir una nueva       |
| **Botones ↔ Eventos**    | Subir foto → subirEvidencia() (RF-26)                                                |
| **RN visibles**          | Ninguna directamente; “Este reporte no tiene evidencias.” es el CA de la HU-26       |

Tabla  
*Ficha del MK-17: Calcular y consultar ruta accesible*

|                          |                                                                                                                                                                                                                                           |
|--------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-17                                                                                                                                                                                                                                     |
| **Pantalla**             | Calcular y consultar ruta accesible (C y R)                                                                                                                                                                                               |
| **Atiende (HU / CU)**    | HU-29 / CU-29 (y da entrada a CU-30 y CU-31), HU-30 / CU-30 y HU-31 / CU-31                                                                                                                                                               |
| **Campos ↔ Diccionario** | origen_direccion, destino_direccion; resultado: distancia_total_m, duracion_estimada_min, nivel_accesibilidad, barreras_esquivadas; lista de tramos (segmento_ruta)                                                                       |
| **Botones ↔ Eventos**    | Calcular ruta → calcularRuta() (RF-29) · Ver ruta guardada → consultarRuta() (RF-30)                                                                                                                                                      |
| **RN visibles**          | RN-12 (nivel_accesibilidad y barreras_esquivadas son una instantánea histórica, no se recalculan; mensaje “No se encontró un recorrido disponible entre ese origen y ese destino.”) · RN-13 (orden de los tramos único dentro de la ruta) |

Tabla  
*Ficha del MK-18: Mapa y listado de puntos accesibles*

|                          |                                                                                                                                 |
|--------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-18                                                                                                                           |
| **Pantalla**             | Mapa y listado de puntos accesibles (R)                                                                                         |
| **Atiende (HU / CU)**    | HU-33 / CU-33 (y da entrada a CU-32, CU-34 y CU-35)                                                                             |
| **Campos ↔ Diccionario** | Pines en mapa; columnas tipo_elemento, nivel_accesibilidad, estado                                                              |
| **Botones ↔ Eventos**    | \+ Nuevo punto → abre MK-19 en modo crear (RF-32) · Editar → abre MK-19 con datos (RF-34) · Cambiar estado → abre MK-20 (RF-35) |
| **RN visibles**          | Ninguna directamente; “No se encontró ningún punto accesible con ese identificador.” es el CA de la HU-33/HU-34                 |

Tabla  
*Ficha del MK-19: Registrar / Actualizar punto accesible*

|                          |                                                                                                                        |
|--------------------------|------------------------------------------------------------------------------------------------------------------------|
| **Código**               | MK-19                                                                                                                  |
| **Pantalla**             | Registrar / Actualizar punto accesible (C y U)                                                                         |
| **Atiende (HU / CU)**    | HU-32 / CU-32 (modo crear) y HU-34 / CU-34 (modo actualizar)                                                           |
| **Campos ↔ Diccionario** | tipo_elemento, nivel_accesibilidad, equipo_beneficiado_principal (opcional), latitud, longitud, descripcion (opcional) |
| **Botones ↔ Eventos**    | Guardar → registrarPuntoAccesible() (RF-32) o actualizarPuntoAccesible() (RF-34)                                       |
| **RN visibles**          | RN-14 (mensajes “Debe seleccionar el tipo de elemento.” / “Debe indicar la ubicación del punto accesible.”)            |

Tabla  
*Ficha del MK-20: Cambiar estado de un punto accesible*

|                          |                                                                                    |
|--------------------------|------------------------------------------------------------------------------------|
| **Código**               | MK-20                                                                              |
| **Pantalla**             | Cambiar estado de un punto accesible (U)                                           |
| **Atiende (HU / CU)**    | HU-35 / CU-35                                                                      |
| **Campos ↔ Diccionario** | estado (OPERATIVO, EN_MANTENIMIENTO, FUERA_DE_SERVICIO)                            |
| **Botones ↔ Eventos**    | Guardar → cambiarEstado() (RF-35)                                                  |
| **RN visibles**          | Ninguna directamente; “El estado solicitado ya es el actual.” es el CA de la HU-35 |

### 2.5.2 Pantallas

Desde la hasta la , cada figura muestra una pantalla con sus indicaciones: a la izquierda, la pantalla; a la derecha, la explicación de cada elemento y el método, requisito o regla que lo respalda.

Figura  
*Mockup MK-01: Catálogo de roles — Listado, búsqueda y cambio de estado*

<img src="../Imagenes/media/8394bff110e276d1125f21920b0bc36447f6e98a.png" title="Mockup MK-01: Catálogo de roles — Listado, búsqueda y cambio de estado" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-01 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-02: Registrar / Actualizar rol*

<img src="../Imagenes/media/01de6da6ecda5cdf69ec092b00383027a1eed233.png" title="Mockup MK-02: Registrar / Actualizar rol" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-02 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-03: Registro de usuario*

<img src="../Imagenes/media/5e87f7691042aa4218487bfb6e7d6a46ed335e13.png" title="Mockup MK-03: Registro de usuario" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-03 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-04: Iniciar sesión*

<img src="../Imagenes/media/2b1face956dded0c89fc770b4761aaa9df64c318.png" title="Mockup MK-04: Iniciar sesión" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-04 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-05: Mis datos personales*

<img src="../Imagenes/media/91ed0dda9a05e9f3a56c76fcbd862cc89203e310.png" title="Mockup MK-05: Mis datos personales" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-05 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-06: Administración de usuarios — Listado y cambio de estado*

<img src="../Imagenes/media/759aa3ae7a767becc331781960a24f8a70a59ce4.png" title="Mockup MK-06: Administración de usuarios — Listado y cambio de estado" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-06 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-07: Mi perfil de movilidad*

<img src="../Imagenes/media/a88ab95ba58e334aafa4e99791bd3244589c438a.png" title="Mockup MK-07: Mi perfil de movilidad" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-07 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-08: Historial de accesos a un perfil de movilidad*

<img src="../Imagenes/media/9dff3d8d2c2b3d646355c035014b64a7a5a2217d.png" title="Mockup MK-08: Historial de accesos a un perfil de movilidad" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-08 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-09: Mapa y listado de barreras*

<img src="../Imagenes/media/deb3d3e99f2886089c657642cf8a84df7f9d4f5f.png" title="Mockup MK-09: Mapa y listado de barreras" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-09 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-10: Registrar barrera*

<img src="../Imagenes/media/b62922c88820dc81a90b31fb333d4b04bcba19ce.png" title="Mockup MK-10: Registrar barrera" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-10 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-11: Cambiar estado de la barrera*

<img src="../Imagenes/media/266752c7edbb3d26c1381dc0b6cb6003d6062a0d.png" title="Mockup MK-11: Cambiar estado de la barrera" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-11 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-12: Equipos afectados de una barrera*

<img src="../Imagenes/media/9a04765a17fad9cf7d3dcde28347afc43d7756c0.png" title="Mockup MK-12: Equipos afectados de una barrera" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-12 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-13: Crear reporte*

<img src="../Imagenes/media/dc321116e7c9c4c48768c03db086c33fb598224c.png" title="Mockup MK-13: Crear reporte" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-13 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-14: Listado y detalle de reportes*

<img src="../Imagenes/media/6198b448e635f3a74176376045ab5f20b60f80b7.png" title="Mockup MK-14: Listado y detalle de reportes" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-14 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-15: Votar validación de un reporte*

<img src="../Imagenes/media/45f7713f15c36e9b60099eced045bf2d1d5466b1.png" title="Mockup MK-15: Votar validación de un reporte" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-15 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-16: Evidencias fotográficas de un reporte*

<img src="../Imagenes/media/eaa759b0b02b6b4a55a9b7e8c4d7196bdd0d7be0.png" title="Mockup MK-16: Evidencias fotográficas de un reporte" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-16 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-17: Calcular y consultar ruta accesible*

<img src="../Imagenes/media/6233425a182db5f883747b7efcff7ecfe9f774c5.png" title="Mockup MK-17: Calcular y consultar ruta accesible" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-17 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-18: Mapa y listado de puntos accesibles*

<img src="../Imagenes/media/7ef4f6c73bdff3dde99a250f3fa12030c13216f0.png" title="Mockup MK-18: Mapa y listado de puntos accesibles" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-18 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-19: Registrar / Actualizar punto accesible*

<img src="../Imagenes/media/6b134e7c46290ffacb610cb687a8b47a2e0e50c6.png" title="Mockup MK-19: Registrar / Actualizar punto accesible" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-19 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

Figura  
*Mockup MK-20: Cambiar estado de un punto accesible*

<img src="../Imagenes/media/452f5fbc970441fefdb245d12dca4b4205d1a66e.png" title="Mockup MK-20: Cambiar estado de un punto accesible" style="width:9in;height:5.32292in" alt="Mockup en blanco, negro y gris de la pantalla MK-20 con siete indicaciones." />

*Nota.* Elaboración propia. Pantalla de ejemplo con indicaciones; la futura vista del MVC.

### 2.5.3 Cobertura CRUD: la trazabilidad desde el diagrama de clases

La verificación en reversa cruza cada método público del diagrama de clases con su historia y su requisito: cada uno de los 36 métodos de las 12 clases aterriza en un elemento de interfaz o queda declarado como interno. La lo muestra. Ningún método queda sin padre y ninguna pantalla queda sin método que la respalde.

Tabla  
*Cobertura de los métodos del diagrama de clases*

| **Método del diagrama de clases**                          | **Padre**           |
|------------------------------------------------------------|---------------------|
| Rol.crearRol()                                             | HU-01 / RF-01       |
| Rol.consultarRol()                                         | HU-02 / RF-02       |
| Rol.actualizarRol()                                        | HU-03 / RF-03       |
| Rol.cambiarEstado()                                        | HU-36 / RF-36       |
| Usuario.registrarUsuario()                                 | HU-04 / RF-04       |
| Usuario.consultarUsuario()                                 | HU-05 / RF-05       |
| Usuario.actualizarDatosPersonales()                        | HU-06 / RF-06       |
| Usuario.autenticar()                                       | HU-07 / RF-07       |
| Usuario.cambiarEstado()                                    | HU-08 / RF-08       |
| PerfilMovilidad.registrarPerfil()                          | HU-09 / RF-09       |
| PerfilMovilidad.consultarPerfil()                          | HU-10 / RF-10       |
| PerfilMovilidad.actualizarPerfil()                         | HU-11 / RF-11       |
| AuditoriaAccesoPerfilMovilidad.registrarAcceso()           | RF-12 (antes HU-27) |
| Barrera.registrarBarrera()                                 | HU-12 / RF-13       |
| Barrera.consultarBarrera()                                 | HU-13 / RF-14       |
| Barrera.cambiarEstado()                                    | HU-14 / RF-15       |
| BarreraEquipoAfectado.asociarEquipoAfectado()              | HU-15 / RF-16       |
| BarreraEquipoAfectado.consultarEquiposAfectados()          | HU-16 / RF-17       |
| BarreraEquipoAfectado.inactivarAsociacion()                | HU-17 / RF-18       |
| Reporte.crearReporte()                                     | HU-18 / RF-19       |
| Reporte.consultarReporte()                                 | HU-19 / RF-20       |
| Reporte.cambiarEstado()                                    | HU-20 / RF-21       |
| Reporte.asociarBarrera()                                   | HU-21 / RF-22       |
| Reporte.recalcularConfianza()                              | RF-23 (antes HU-22) |
| ValidacionReporte.registrarVoto()                          | HU-23 / RF-24       |
| ValidacionReporte.consultarVotos()                         | HU-24 / RF-25       |
| EvidenciaFotografica.subirEvidencia()                      | HU-25 / RF-26       |
| EvidenciaFotografica.consultarEvidencias()                 | HU-26 / RF-27       |
| AuditoriaAccesoPerfilMovilidad.consultarHistorialAccesos() | HU-28 / RF-28       |
| Ruta.calcularRuta()                                        | HU-29 / RF-29       |
| Ruta.consultarRuta()                                       | HU-30 / RF-30       |
| SegmentoRuta.consultarSegmentos()                          | HU-31 / RF-31       |
| PuntoAccesible.registrarPuntoAccesible()                   | HU-32 / RF-32       |
| PuntoAccesible.consultarPuntoAccesible()                   | HU-33 / RF-33       |
| PuntoAccesible.actualizarPuntoAccesible()                  | HU-34 / RF-34       |
| PuntoAccesible.cambiarEstado()                             | HU-35 / RF-35       |

*Nota.* Elaboración propia a partir del diagrama de clases (Figura 27).

