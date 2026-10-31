## 3.5 Cardinalidad de las relaciones

La lista las trece relaciones del modelo, con la llave foránea que las materializa en el modelo relacional.

Tabla  
*Cardinalidad de las relaciones del modelo*

| **Relación**  | **Entidad padre** | **Entidad hija**                  | **Cardinalidad**                                                      | **Llave foránea**                            |
|---------------|-------------------|-----------------------------------|-----------------------------------------------------------------------|----------------------------------------------|
| tiene         | rol               | usuario                           | 1:N                                                                   | usuario.id_rol                               |
| posee         | usuario           | perfil_movilidad                  | 1:1 (el perfil es opcional)                                           | perfil_movilidad.id_usuario (única)          |
| es_auditado   | perfil_movilidad  | auditoria_acceso_perfil_movilidad | 1:N                                                                   | auditoria_acceso_perfil_movilidad.id_perfil  |
| audita        | usuario           | auditoria_acceso_perfil_movilidad | 1:N                                                                   | auditoria_acceso_perfil_movilidad.id_usuario |
| solicita      | usuario           | ruta                              | 1:N                                                                   | ruta.id_usuario                              |
| compuesto_por | ruta              | segmento_ruta                     | 1:N (mínimo un segmento)                                              | segmento_ruta.id_ruta                        |
| registra      | usuario           | punto_accesible                   | 1:N                                                                   | punto_accesible.id_usuario_registra          |
| realiza       | usuario           | reporte                           | 1:N                                                                   | reporte.id_usuario                           |
| valida        | usuario           | validacion_reporte                | 1:N                                                                   | validacion_reporte.id_usuario                |
| evalua        | reporte           | validacion_reporte                | 1:N                                                                   | validacion_reporte.id_reporte                |
| contiene      | reporte           | evidencia_fotografica             | 1:N                                                                   | evidencia_fotografica.id_reporte             |
| documenta     | barrera           | reporte                           | 1:N (el reporte puede no tener barrera si su origen es NUEVA_BARRERA) | reporte.id_barrera (admite NULL)             |
| afecta_a      | barrera           | barrera_equipo_afectado           | 1:N                                                                   | barrera_equipo_afectado.id_barrera           |

*Nota.* Elaboración propia.

