# Control de versiones del documento

Tabla  
*Control de versiones del documento*

| **Versión** | **Fecha**  | **Autor(es)**                                          | **Descripción del cambio**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | **CRF / LB** |
|-------------|------------|--------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------|
| 1.0         | 22/09/2026 | Juan Pablo Mejía Urango, Andrés Camilo Pumarejo Campo  | Versión inicial — Fase 0: Concepción                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | LB-0         |
| 1.5         | 23/09/2026 | Andrés Camilo Pumarejo Campo                           | Corrección del diccionario de datos (3FN) y del diagrama de clases UML según las 8 observaciones de la docente                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               | CRF-01       |
| 2.0         | 27/09/2026 | Andrés Camilo Pumarejo Campo                           | Ajuste del cronograma (sección 1.8): renumeración según la Ruta Oficial del Curso (Pasos 1 a 15, 7b y 12b), incorporación de dedicación semanal (2h/día, L-S) y estado de avance por actividad                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               | CRF-02       |
| 2.5         | 29/09/2026 | Juan Pablo Mejía Urango y Andrés Camilo Pumarejo Campo | Fase 2: Análisis — incorporación de la sección 2.1 con 35 Historias de Usuario (una por cada método de las 12 clases del diagrama) y sus criterios de aceptación, con trazabilidad al origen (encuesta, documento del negocio o normativa)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | CRF-03       |
| 3.0         | 06/10/2026 | Andrés Camilo Pumarejo Campo                           | La sección 2.1 pasa a 35 fichas individuales (Código, Título corto, Historia, Criterios de aceptación, Origen de la necesidad, RF derivados, Prioridad), siguiendo la plantilla oficial del curso. Origen de HU-27/HU-28 corregido a Ley 1581 de 2012 (antes citaba Ley 1618/Decreto 2011).                                                                                                                                                                                                                                                                                                                                                                                                                                  | CRF-04       |
| 3.5         | 06/10/2026 | Andrés Camilo Pumarejo Campo                           | Consolidación del catálogo único de Reglas de Negocio (RN-01 a RN-14) y Requisitos Funcionales (RF-01 a RF-35), reemplazando los códigos provisionales por entidad usados durante la revisión de las 12 clases. Se agrega la sección 2.2 con ambos catálogos y su trazabilidad HU↔RN↔RF.                                                                                                                                                                                                                                                                                                                                                                                                                                     | CRF-05       |
| 4.0         | 06/10/2026 | Andrés Camilo Pumarejo Campo                           | Se agrega la sección 2.3 con 10 Requisitos No Funcionales (RNF-01 a RNF-10), cada uno con categoría, enunciado con medida verificable y origen de la necesidad, en fichas individuales con bordes. Se decide no renumerar las HU tras retirar HU-22 y HU-27 (quedan marcadas como retiradas/reclasificadas para preservar la trazabilidad del proceso de corrección                                                                                                                                                                                                                                                                                                                                                          | CRF-06       |
| 4.5         | 06/10/2026 | Andrés Camilo Pumarejo Campo                           | Se agrega la sección 2.4 Casos de Uso: 2.4.1 tabla general por clase (Caso de uso/Nombre/CRUD/Nace de/Implementa, incluyendo las 2 filas ‘(incluido)’ de los métodos internos) y 2.4.2 las 33 fichas de CU documentados (Actor/Precondición/Flujo básico/Flujos alternativos/Poscondición) con columna de Procedencia, siguiendo la plantilla oficial del ejemplo guiado Parte 2.                                                                                                                                                                                                                                                                                                                                            | CRF-07       |
| 5.0         | 07/10/2026 | Andrés Camilo Pumarejo Campo                           | Se agrega la sección 2.5 Mockups: 2.5.1 20 fichas de pantalla (Código/Pantalla/Atiende/Campos ↔ Diccionario/Botones ↔ Eventos/RN visibles) cubriendo las 33 HU vivas y los 2 métodos internos, y 2.5.2 la tabla de Cobertura CRUD con los 35 métodos del diagrama de clases verificados contra su pantalla o su declaración de método interno, siguiendo la plantilla oficial del ejemplo guiado Parte 2.                                                                                                                                                                                                                                                                                                                    | CRF-08       |
| 6.0         | 26/10/2026 | Juan Pablo Mejía Urango y Andrés Camilo Pumarejo Campo | Correcciones de la retroalimentación de la entrega parcial (C1 a C6): alcance con las entidades del modelo, metodología (1.7.4) y hallazgos de la encuesta (1.7.3), cronograma de 16 semanas con 192 h y ajuste del modelo de datos de la Fase 2 (sección 3): diccionario con inactivación de rol y de asociación barrera–equipo, MER, modelo relacional y diagrama de clases (nuevo método Rol.cambiarEstado()); historias de usuario con origen en la sección 1.7.3, HU-17 redactada como inactivación y nueva HU-36; códigos finales de RN y RF en las historias, RF-18 como inactivar, nuevos RF-36, RN-15 y RN-16; diagrama de casos de uso rehecho, con selección y justificación de seis casos críticos documentados. | CRF-09       |
| 7.0         | 27/10/2026 | Juan Pablo Mejía Urango y Andrés Camilo Pumarejo Campo | Cierre de la Fase 2 y Fase 3: matriz de trazabilidad (3.11), lectura cruzada y compuerta M2 (3.12), script SQL (4.1), repositorio Git con un commit por requisito (4.2) y código MVC del módulo de roles con su evidencia (4.3). Con esta versión y el repositorio se crea la línea base LB-1.                                                                                                                                                                                                                                                                                                                                                                                                                               | LB-1         |
| 7.1         | 30/10/2026 | Juan Pablo Mejía Urango y Andrés Camilo Pumarejo Campo | Ajuste por indicación de la docente en la asesoría: el diagrama general de casos de uso se reemplaza por cuatro diagramas, uno por caso (CU-20 y CU-23 críticos; CU-01 y CU-36 no críticos), y los documentos del repositorio se organizan por fases.                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | CRF-11       |

*Nota.* Elaboración propia. CRF: solicitud de cambio; LB: línea base.

Tabla de contenido

Control de versiones del documento 2

1\. Concepción: conocer el sistema antes de construirlo 13

1.1 Descripción del problema 13

1.2 Alcance 15

Entidades principales del modelo de datos 16

1.3 Objetivo General 17

1.4 Objetivos Específicos 17

1.5 Estado del arte 17

1.6 Marco teórico 19

1.7 Recolección de la información y metodología de trabajo 20

1.7.1 Instrumento de encuesta 21

1.7.2 Síntesis de las respuestas 21

1.7.3 Análisis de la encuesta 22

1.7.4 Metodología de trabajo 23

1.8 Cronograma de trabajo del semestre 24

2\. Fase de Análisis 27

2.1 Historias de usuario y criterios de aceptación 27

2.2 Reglas de negocio y requisitos funcionales 48

2.2.1 Reglas de negocio 48

2.2.2 Requisitos funcionales 52

2.3 Requisitos no funcionales 64

2.4 Casos de uso 67

2.4.1 Diagramas de casos de uso 67

2.4.2 Selección de los casos críticos 69

2.4.3 Fichas de los casos de uso 70

2.5 Mockups 86

2.5.1 Fichas de mockups 87

2.5.2 Pantallas 93

2.5.3 Cobertura CRUD: la trazabilidad desde el diagrama de clases 114

2.6 La cadena completa: una fila por historia 115

3\. Fase de Diseño 117

3.1 Diccionario de datos 117

3.1.1 Restricciones adicionales 127

3.1.2 Reglas de negocio del diccionario 127

3.2 Modelo entidad-relación 129

3.3 Modelo relacional 131

3.4 Diagrama de clases 133

3.5 Cardinalidad de las relaciones 135

3.6 Auditoría cruzada 135

3.7 Diagrama de actividades 137

3.7.1 Procesos críticos (tablas transaccionales) 137

3.7.2 Procesos no críticos (tabla maestra) 139

3.8 Documento de diseño arquitectónico (DDA) 141

3.9 Diagramas de secuencia 144

3.10 Diagrama de estados 150

3.11 Matriz de trazabilidad 155

3.12 Lectura cruzada entre equipos 157

3.12.1 Compuerta M2 158

4\. Fase de Construcción 159

4.1 Script SQL 159

4.2 Repositorio Git 165

4.3 Código MVC 168

Referencias 172

Anexos 178

Anexo A. Preguntas de la encuesta 178

Lista de tablas

Tabla 1. Control de versiones del documento 2

Tabla 2. Módulos del alcance y entidades del modelo que los soportan 16

Tabla 3. Referentes nacionales e internacionales sobre accesibilidad urbana 17

Tabla 4. Hallazgos de la encuesta y elementos del proyecto que originan 23

Tabla 5. Cronograma semanal de trabajo, con carga horaria por integrante 25

Tabla 6. Ficha de la HU-01: Crear rol 27

Tabla 7. Ficha de la HU-02: Consultar rol 28

Tabla 8. Ficha de la HU-03: Actualizar rol 28

Tabla 9. Ficha de la HU-04: Registrar usuario 29

Tabla 10. Ficha de la HU-05: Consultar usuario 29

Tabla 11. Ficha de la HU-06: Actualizar datos personales 30

Tabla 12. Ficha de la HU-07: Iniciar sesión 30

Tabla 13. Ficha de la HU-08: Cambiar estado de una cuenta 31

Tabla 14. Ficha de la HU-09: Registrar perfil de movilidad 31

Tabla 15. Ficha de la HU-10: Consultar perfil de movilidad 32

Tabla 16. Ficha de la HU-11: Actualizar perfil de movilidad 33

Tabla 17. Ficha de la HU-12: Registrar barrera 33

Tabla 18. Ficha de la HU-13: Consultar barrera 34

Tabla 19. Ficha de la HU-14: Actualizar estado de la barrera 34

Tabla 20. Ficha de la HU-15: Asociar equipo afectado a una barrera 35

Tabla 21. Ficha de la HU-16: Consultar equipos afectados por una barrera 36

Tabla 22. Ficha de la HU-17: Inactivar asociación de equipo afectado 36

Tabla 23. Ficha de la HU-18: Crear reporte 37

Tabla 24. Ficha de la HU-19: Consultar reporte 38

Tabla 25. Ficha de la HU-20: Cambiar estado del reporte 38

Tabla 26. Ficha de la HU-21: Asociar barrera a un reporte 39

Tabla 27. Ficha de la HU-23: Registrar voto de validación 40

Tabla 28. Ficha de la HU-24: Consultar votos de un reporte 41

Tabla 29. Ficha de la HU-25: Subir evidencia fotográfica 41

Tabla 30. Ficha de la HU-26: Consultar evidencias de un reporte 42

Tabla 31. Ficha de la HU-28: Consultar historial de accesos a un perfil de movilidad 42

Tabla 32. Ficha de la HU-29: Calcular ruta accesible 43

Tabla 33. Ficha de la HU-30: Consultar ruta calculada 44

Tabla 34. Ficha de la HU-31: Consultar segmentos de una ruta 44

Tabla 35. Ficha de la HU-32: Registrar punto accesible 45

Tabla 36. Ficha de la HU-33: Consultar punto accesible 45

Tabla 37. Ficha de la HU-34: Actualizar punto accesible 46

Tabla 38. Ficha de la HU-35: Cambiar estado de un punto accesible 46

Tabla 39. Ficha de la HU-36: Cambiar estado de un rol 47

Tabla 40. Ficha de la RN-01 48

Tabla 41. Ficha de la RN-02 48

Tabla 42. Ficha de la RN-03 48

Tabla 43. Ficha de la RN-04 49

Tabla 44. Ficha de la RN-05 49

Tabla 45. Ficha de la RN-06 49

Tabla 46. Ficha de la RN-07 49

Tabla 47. Ficha de la RN-08 50

Tabla 48. Ficha de la RN-09 50

Tabla 49. Ficha de la RN-10 50

Tabla 50. Ficha de la RN-11 50

Tabla 51. Ficha de la RN-12 51

Tabla 52. Ficha de la RN-13 51

Tabla 53. Ficha de la RN-14 51

Tabla 54. Ficha de la RN-15 51

Tabla 55. Ficha de la RN-16 52

Tabla 56. Ficha del RF-01: Crear rol 52

Tabla 57. Ficha del RF-02: Consultar rol 53

Tabla 58. Ficha del RF-03: Actualizar rol 53

Tabla 59. Ficha del RF-04: Registrar usuario 53

Tabla 60. Ficha del RF-05: Consultar usuario 54

Tabla 61. Ficha del RF-06: Actualizar datos personales 54

Tabla 62. Ficha del RF-07: Autenticar usuario 54

Tabla 63. Ficha del RF-08: Cambiar estado de cuenta 55

Tabla 64. Ficha del RF-09: Registrar perfil de movilidad 55

Tabla 65. Ficha del RF-10: Consultar perfil de movilidad 55

Tabla 66. Ficha del RF-11: Actualizar perfil de movilidad 56

Tabla 67. Ficha del RF-12: Registrar acceso a perfil de movilidad (interno) 56

Tabla 68. Ficha del RF-13: Registrar barrera 56

Tabla 69. Ficha del RF-14: Consultar barrera 57

Tabla 70. Ficha del RF-15: Cambiar estado de la barrera 57

Tabla 71. Ficha del RF-16: Asociar equipo afectado 57

Tabla 72. Ficha del RF-17: Consultar equipos afectados 58

Tabla 73. Ficha del RF-18: Inactivar asociación de equipo afectado 58

Tabla 74. Ficha del RF-19: Crear reporte 58

Tabla 75. Ficha del RF-20: Consultar reporte 59

Tabla 76. Ficha del RF-21: Cambiar estado del reporte 59

Tabla 77. Ficha del RF-22: Asociar barrera a un reporte 59

Tabla 78. Ficha del RF-23: Recalcular confianza del reporte (interno) 60

Tabla 79. Ficha del RF-24: Registrar voto de validación 60

Tabla 80. Ficha del RF-25: Consultar votos de un reporte 60

Tabla 81. Ficha del RF-26: Subir evidencia fotográfica 61

Tabla 82. Ficha del RF-27: Consultar evidencias de un reporte 61

Tabla 83. Ficha del RF-28: Consultar historial de accesos 61

Tabla 84. Ficha del RF-29: Calcular ruta accesible 62

Tabla 85. Ficha del RF-30: Consultar ruta calculada 62

Tabla 86. Ficha del RF-31: Consultar segmentos de una ruta 62

Tabla 87. Ficha del RF-32: Registrar punto accesible 63

Tabla 88. Ficha del RF-33: Consultar punto accesible 63

Tabla 89. Ficha del RF-34: Actualizar punto accesible 63

Tabla 90. Ficha del RF-35: Cambiar estado de punto accesible 64

Tabla 91. Ficha del RF-36: Cambiar estado de un rol 64

Tabla 92. Ficha del RNF-01: Rendimiento 64

Tabla 93. Ficha del RNF-02: Rendimiento 65

Tabla 94. Ficha del RNF-03: Seguridad 65

Tabla 95. Ficha del RNF-04: Seguridad / Protección de datos sensibles 65

Tabla 96. Ficha del RNF-05: Seguridad / Control de acceso 65

Tabla 97. Ficha del RNF-06: Usabilidad / Accesibilidad 66

Tabla 98. Ficha del RNF-07: Disponibilidad 66

Tabla 99. Ficha del RNF-08: Escalabilidad 66

Tabla 100. Ficha del RNF-09: Compatibilidad 66

Tabla 101. Ficha del RNF-10: Auditoría / Trazabilidad 67

Tabla 102. Casos de uso críticos y razón de su selección 70

Tabla 103. Ficha del CU-01: Crear rol 71

Tabla 104. Ficha del CU-02: Consultar rol 71

Tabla 105. Ficha del CU-03: Actualizar rol 71

Tabla 106. Ficha del CU-04: Registrar usuario 72

Tabla 107. Ficha del CU-05: Consultar usuario 72

Tabla 108. Ficha del CU-06: Actualizar datos personales 73

Tabla 109. Ficha del CU-07: Iniciar sesión 73

Tabla 110. Ficha del CU-08: Cambiar estado de una cuenta 74

Tabla 111. Ficha del CU-09: Registrar perfil de movilidad 74

Tabla 112. Ficha del CU-10: Consultar perfil de movilidad 75

Tabla 113. Ficha del CU-11: Actualizar perfil de movilidad 75

Tabla 114. Ficha del CU-12: Registrar barrera 76

Tabla 115. Ficha del CU-13: Consultar barrera 76

Tabla 116. Ficha del CU-14: Actualizar estado de la barrera 77

Tabla 117. Ficha del CU-15: Asociar equipo afectado a una barrera 77

Tabla 118. Ficha del CU-16: Consultar equipos afectados por una barrera 78

Tabla 119. Ficha del CU-17: Inactivar asociación de equipo afectado 78

Tabla 120. Ficha del CU-18: Crear reporte 79

Tabla 121. Ficha del CU-19: Consultar reporte 79

Tabla 122. Ficha del CU-20: Cambiar estado del reporte 80

Tabla 123. Ficha del CU-21: Asociar barrera a un reporte 80

Tabla 124. Ficha del CU-23: Registrar voto de validación 81

Tabla 125. Ficha del CU-24: Consultar votos de un reporte 81

Tabla 126. Ficha del CU-25: Subir evidencia fotográfica 82

Tabla 127. Ficha del CU-26: Consultar evidencias de un reporte 82

Tabla 128. Ficha del CU-28: Consultar historial de accesos a un perfil de movilidad 82

Tabla 129. Ficha del CU-29: Calcular ruta accesible 83

Tabla 130. Ficha del CU-30: Consultar ruta calculada 83

Tabla 131. Ficha del CU-31: Consultar segmentos de una ruta 84

Tabla 132. Ficha del CU-32: Registrar punto accesible 84

Tabla 133. Ficha del CU-33: Consultar punto accesible 84

Tabla 134. Ficha del CU-34: Actualizar punto accesible 85

Tabla 135. Ficha del CU-35: Cambiar estado de un punto accesible 85

Tabla 136. Ficha del CU-36: Cambiar estado de un rol 86

Tabla 137. Ficha del MK-01: Catálogo de roles — Listado, búsqueda y cambio de estado 87

Tabla 138. Ficha del MK-02: Registrar / Actualizar rol 87

Tabla 139. Ficha del MK-03: Registro de usuario 87

Tabla 140. Ficha del MK-04: Iniciar sesión 88

Tabla 141. Ficha del MK-05: Mis datos personales 88

Tabla 142. Ficha del MK-06: Administración de usuarios — Listado y cambio de estado 88

Tabla 143. Ficha del MK-07: Mi perfil de movilidad 89

Tabla 144. Ficha del MK-08: Historial de accesos a un perfil de movilidad 89

Tabla 145. Ficha del MK-09: Mapa y listado de barreras 89

Tabla 146. Ficha del MK-10: Registrar barrera 90

Tabla 147. Ficha del MK-11: Cambiar estado de la barrera 90

Tabla 148. Ficha del MK-12: Equipos afectados de una barrera 90

Tabla 149. Ficha del MK-13: Crear reporte 91

Tabla 150. Ficha del MK-14: Listado y detalle de reportes 91

Tabla 151. Ficha del MK-15: Votar validación de un reporte 91

Tabla 152. Ficha del MK-16: Evidencias fotográficas de un reporte 92

Tabla 153. Ficha del MK-17: Calcular y consultar ruta accesible 92

Tabla 154. Ficha del MK-18: Mapa y listado de puntos accesibles 92

Tabla 155. Ficha del MK-19: Registrar / Actualizar punto accesible 93

Tabla 156. Ficha del MK-20: Cambiar estado de un punto accesible 93

Tabla 157. Cobertura de los métodos del diagrama de clases 114

Tabla 158. Cadena de trazabilidad por historia de usuario 115

Tabla 159. Tablas del diccionario de datos 117

Tabla 160. Campos de la tabla usuario 118

Tabla 161. Campos de la tabla rol 119

Tabla 162. Campos de la tabla perfil_movilidad 119

Tabla 163. Campos de la tabla barrera 120

Tabla 164. Campos de la tabla barrera_equipo_afectado (nueva, Corrección 2) 121

Tabla 165. Campos de la tabla ruta 122

Tabla 166. Campos de la tabla segmento_ruta 123

Tabla 167. Campos de la tabla reporte 123

Tabla 168. Campos de la tabla validacion_reporte 124

Tabla 169. Campos de la tabla evidencia_fotografica 125

Tabla 170. Campos de la tabla punto_accesible 125

Tabla 171. Campos de la tabla auditoria_acceso_perfil_movilidad (nueva, Corrección 6) 126

Tabla 172. Cardinalidad de las relaciones del modelo 135

Tabla 173. Auditoría cruzada entre diccionario de datos, MER y diagrama de clases 136

Tabla 174. Procesos seleccionados para el diagrama de actividades 137

Tabla 175. Mensajes a las clases del dominio y su método en el diagrama de clases 145

Tabla 176. Transiciones de estado y su gestor 150

Tabla 177. Matriz de trazabilidad: historia de usuario, requisito, entidad, clase, caso de uso, secuencia y pantalla 155

Tabla 178. Las ocho preguntas de la lectura cruzada aplicadas al documento PAU 157

Tabla 179. Constancia de lectura cruzada (Paso 12b) 158

Tabla 180. Condiciones de la compuerta M2 158

Tabla 181. Reglas de negocio y su restricción en la base de datos 159

Tabla 182. Estructura del repositorio y su origen en el DDA 166

Tabla 183. Elementos excluidos del repositorio con .gitignore 166

Tabla 184. Requisitos del módulo de roles y su implementación 169

Lista de figuras

Figura 1. Diagrama de casos de uso crítico: cambiar estado del reporte (CU-20) 68

Figura 2. Diagrama de casos de uso crítico: registrar voto de validación (CU-23) 68

Figura 3. Diagrama de casos de uso no crítico: crear rol (CU-01) 69

Figura 4. Diagrama de casos de uso no crítico: cambiar estado de un rol (CU-36) 69

Figura 5. Mockup MK-01: Catálogo de roles — Listado, búsqueda y cambio de estado 94

Figura 6. Mockup MK-02: Registrar / Actualizar rol 95

Figura 7. Mockup MK-03: Registro de usuario 96

Figura 8. Mockup MK-04: Iniciar sesión 97

Figura 9. Mockup MK-05: Mis datos personales 98

Figura 10. Mockup MK-06: Administración de usuarios — Listado y cambio de estado 99

Figura 11. Mockup MK-07: Mi perfil de movilidad 100

Figura 12. Mockup MK-08: Historial de accesos a un perfil de movilidad 101

Figura 13. Mockup MK-09: Mapa y listado de barreras 102

Figura 14. Mockup MK-10: Registrar barrera 103

Figura 15. Mockup MK-11: Cambiar estado de la barrera 104

Figura 16. Mockup MK-12: Equipos afectados de una barrera 105

Figura 17. Mockup MK-13: Crear reporte 106

Figura 18. Mockup MK-14: Listado y detalle de reportes 107

Figura 19. Mockup MK-15: Votar validación de un reporte 108

Figura 20. Mockup MK-16: Evidencias fotográficas de un reporte 109

Figura 21. Mockup MK-17: Calcular y consultar ruta accesible 110

Figura 22. Mockup MK-18: Mapa y listado de puntos accesibles 111

Figura 23. Mockup MK-19: Registrar / Actualizar punto accesible 112

Figura 24. Mockup MK-20: Cambiar estado de un punto accesible 113

Figura 25. Modelo entidad-relación del sistema PAU 130

Figura 26. Modelo relacional del sistema PAU 132

Figura 27. Diagrama de clases del sistema PAU 134

Figura 28. Diagrama de actividades del proceso crítico: cambiar estado del reporte (CU-20) 138

Figura 29. Diagrama de actividades del proceso crítico: registrar voto de validación (CU-23) 139

Figura 30. Diagrama de actividades del proceso no crítico: crear rol (CU-01) 140

Figura 31. Diagrama de actividades del proceso no crítico: cambiar estado de un rol (CU-36) 141

Figura 32. Arquitectura MVC y distribución de paquetes del sistema PAU 143

Figura 33. Diagrama de secuencia del proceso crítico: cambiar estado del reporte (CU-20) 146

Figura 34. Diagrama de secuencia del proceso crítico: registrar voto de validación (CU-23) 147

Figura 35. Diagrama de secuencia del proceso no crítico: crear rol (CU-01) 148

Figura 36. Diagrama de secuencia del proceso no crítico: cambiar estado de un rol (CU-36) 149

Figura 37. Diagrama de estados del reporte (EstadoReporte) 151

Figura 38. Diagrama de estados de la barrera (EstadoBarrera) 152

Figura 39. Diagrama de estados del rol (EstadoRol) 153

Figura 40. Diagrama de estados de la asociación barrera–equipo afectado (EstadoAsociacion) 154

Figura 41. Script SQL de la base de datos PAU (db/script_bd_pau.sql) 160

Figura 42. Tablas creadas en la base de datos pau 165

Figura 43. Verificación de las restricciones de la base de datos 165

Figura 44. Estructura del repositorio en GitHub 167

Figura 45. Historial de commits del repositorio 168

Figura 46. Catálogo de roles con el mensaje de actualización 170

Figura 47. Formulario en modo Editar rol 171

Figura 48. Contenido de la tabla rol en la base de datos 171

