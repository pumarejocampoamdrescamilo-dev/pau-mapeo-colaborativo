## 3.12 Lectura cruzada entre equipos

La lectura cruzada es la verificación final de la Fase 2: un equipo distinto al autor recibe el documento completo y responde ocho preguntas con evidencia, citando página y código. Es la gemela de la auditoría cruzada de la sección 3.6, pero sobre todos los artefactos. La aplica las ocho preguntas a nuestro documento; la columna de evidencia permite al equipo lector repetir cada comprobación.

Tabla  
*Las ocho preguntas de la lectura cruzada aplicadas al documento PAU*

| **N.º** | **Pregunta de la lectura**                                                                      | **Elemento tomado**               | **Evidencia en el documento**                                                                                                                              | **Resultado** |
|---------|-------------------------------------------------------------------------------------------------|-----------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------|
| 1       | Siga una HU en la matriz: ¿llega a una pantalla real y el método existe en la clase?            | HU-20                             | Fila HU-20 de la Tabla 177: RF-21, tabla reporte, Reporte.cambiarEstado(), CU-20, MK-14. El método está en la clase Reporte y MK-14 está en la sección 3.4 | Cumple        |
| 2       | Rombo de un diagrama de actividades: ¿cita una RN con RF y restricción en el diccionario?       | Rombo de estado válido, CU-20     | RN-09, con RF-21 y RF-15, origen en las reglas de negocio del diccionario (Figura 28)                                                                      | Cumple        |
| 3       | Mensaje de un diagrama de secuencia: ¿está en el diagrama de clases con ese nombre?             | ReporteServicio.cambiarEstado()   | Figura 33; el método Reporte.cambiarEstado() está en la Figura 27. Los métodos DAO son de acceso a datos y no van en el diagrama de clases                 | Cumple        |
| 4       | Transición de un diagrama de estados: ¿tiene gestor HU/RF y las automáticas están justificadas? | PENDIENTE → CONFIRMADO            | Tabla 176: gestor HU-20 y RF-21, manual; la propagación a la barrera es automática por RN-09                                                               | Cumple        |
| 5       | Botón de un mockup: ¿a qué CU pertenece y qué método llama?                                     | Acción de votar en MK-15          | CU-23, que llama a ValidacionReporte.registrarVoto() y a Reporte.recalcularConfianza() (RN-11)                                                             | Cumple        |
| 6       | Clase del DDA: ¿en qué paquete MVC vive y dónde se validan las RN?                              | ReporteServicio                   | Paquete servicio de la Figura 32; la regla RN-09 se valida allí y no en la vista JSP                                                                       | Cumple        |
| 7       | Busque 'eliminar' o 'borrar': ¿es eliminación lógica y el aviso explica la consecuencia?        | Baja de rol (CU-36)               | RN-16: no se elimina, pasa a INACTIVO y conserva su historial; RN-15 explica la consecuencia para nuevos usuarios                                          | Cumple        |
| 8       | Cuente métodos sin RF y pantallas sin CU                                                        | Los 36 métodos y las 20 pantallas | Los 36 métodos del diagrama de clases responden a los 36 RF, y las 20 pantallas MK-01 a MK-20 aparecen en la matriz con su CU. Huérfanos: 0. Fantasmas: 0  | Cumple        |

*Nota.* Elaboración propia. Resultado de la comprobación hecha por el equipo autor; el equipo lector la repitió y la firmó (Tabla 179).

La es la constancia que firma el equipo lector. La lectura la hizo el equipo Matute y Betancur el 27 de octubre de 2026 y no encontró aspectos por corregir.

Tabla  
*Constancia de lectura cruzada (Paso 12b)*

| **Dato de la constancia**   | **Registro**                                                            |
|-----------------------------|-------------------------------------------------------------------------|
| Documento leído             | PAU, secciones 2.1 a 3.11 (Fase 2 completa)                             |
| Equipo autor                | Pumarejo y Cía.: Juan Pablo Mejía Urango y Andrés Camilo Pumarejo Campo |
| Equipo lector               | Equipo Matute y Betancur                                                |
| Firma del equipo lector     | Matute y Betancur                                                       |
| Fecha de la lectura         | 27 de octubre de 2026                                                   |
| Hallazgos del equipo lector | Ninguno: el equipo lector no encontró aspectos por corregir             |

*Nota.* Elaboración propia a partir del modelo del Paso 12b.

### 3.12.1 Compuerta M2

La compuerta M2 solo se abre con la matriz cerrada y leída, y es la llave de la Fase 3: sin ella no hay código. La muestra el estado de cada condición.

Tabla  
*Condiciones de la compuerta M2*

| **Condición de entrada a la Fase 3**              | **Estado** | **Evidencia**                                                                                                        |
|---------------------------------------------------|------------|----------------------------------------------------------------------------------------------------------------------|
| Matriz de trazabilidad cerrada, sin celdas vacías | Cumple     | Tabla 177: 34 historias, 36 requisitos y 20 pantallas; la columna de secuencia usa "—" donde no se dibujó el proceso |
| Constancia 12b firmada por el equipo lector       | Cumple     | Tabla 179: lectura del equipo Matute y Betancur el 27 de octubre de 2026                                             |
| Hallazgos corregidos hacia atrás                  | Cumple     | El equipo lector no registró hallazgos; no hay correcciones por hacer                                                |

*Nota.* Elaboración propia.

