## 1.7 Recolección de la información y metodología de trabajo

Para este proyecto, la técnica de elicitación aplicada fue la encuesta dirigida a potenciales usuarios —personas con discapacidad física y ciudadanos interesados en la accesibilidad urbana de Medellín—, en lugar de una entrevista individual. Por ello, las tres partes siguientes (instrumento, síntesis y análisis) se documentan sobre el instrumento de encuesta aplicado.

### 1.7.1 Instrumento de encuesta

Las preguntas aplicadas se presentan en el Anexo A.

Ficha del instrumento — Medio: Google Forms · Población: personas con discapacidad física y ciudadanía interesada en la accesibilidad urbana de Medellín · Período de aplicación: del 2 al 4 de octubre de 2025 (curso Ingeniería de Software I) · Respuestas obtenidas: 39 · Enlace de la encuesta:

### 1.7.2 Síntesis de las respuestas

La encuesta sobre accesibilidad urbana y movilidad en Medellín obtuvo un total de 39 respuestas. La edad de los participantes se concentró principalmente en el rango de 18 a 25 años, con 23 personas (59 %), seguido por menores de 18 años, con 7 participantes (17,9 %). Los rangos de 26 a 35 años y de 36 a 50 años registraron 4 respuestas cada uno (10,3 %), mientras que una persona tenía más de 50 años (2,6 %).

En relación con la autonomía y la participación social, 21 de las 38 personas que respondieron esta pregunta (55,3 %) estuvieron de acuerdo o totalmente de acuerdo con que la falta de rutas accesibles limita significativamente la autonomía y la participación social. Asimismo, 23 de 38 participantes (60,5 %) estuvieron de acuerdo o totalmente de acuerdo con la importancia de incluir la participación ciudadana en las soluciones tecnológicas de accesibilidad.

Respecto a las características de la solución propuesta, 24 de 39 participantes (61,5 %) estuvieron de acuerdo o totalmente de acuerdo con que las aplicaciones de accesibilidad deberían incluir mapas urbanos. Además, 22 de 38 personas (57,9 %) consideraron que es fundamental tener en cuenta obstáculos físicos como escaleras, pendientes y aceras deterioradas. Por otra parte, 26 de 39 participantes (66,7 %) estuvieron de acuerdo o totalmente de acuerdo con que las soluciones tecnológicas deben adaptarse a diferentes tipos de discapacidad.

Entre las funcionalidades deseadas, la planificación de rutas accesibles fue la opción más seleccionada, con 15 respuestas de 38 (39,5 %). Le siguieron las alertas de obstáculos en tiempo real, con 9 respuestas (23,7 %). En cuanto a la información que debería mostrar el mapa, las rutas accesibles y las zonas peligrosas para personas con movilidad reducida fueron las opciones más seleccionadas, con 13 respuestas cada una (33,3 % del total de 39 participantes).

Sobre la participación en el sistema colaborativo, 12 de las 36 personas que respondieron (33,3 %) prefirieron marcar rutas seguras en el mapa; 9 (25 %) eligieron subir fotografías y otras 9 (25 %) reportar obstáculos o barreras. Ninguna persona seleccionó la opción de no estar interesada en participar.

Finalmente, 16 de 39 participantes (41 %) manifestaron tener una confianza alta o muy alta en los datos aportados por otros usuarios. Sin embargo, 20 personas (51,3 %) indicaron una confianza media, lo que evidencia la importancia de incorporar mecanismos de verificación, actualización y moderación de los reportes ciudadanos.

En conjunto, los resultados respaldan la pertinencia de una plataforma colaborativa que permita consultar rutas accesibles, identificar obstáculos urbanos, personalizar la movilidad y aportar información ciudadana. Estos resultados corresponden a las personas encuestadas y no deben interpretarse como una representación estadística de toda la población de Medellín.

### 1.7.3 Análisis de la encuesta

A partir de la síntesis de la sección 1.7.2 se identificaron cuatro hallazgos, que dieron origen a los elementos del sistema que muestra la .

Tabla  
*Hallazgos de la encuesta y elementos del proyecto que originan*

| **Código** | **Hallazgo**                                                     | **Evidencia (sección 1.7.2)**                                                                                                                                                                                                           | **Elementos que origina**                                                                                                                 |
|------------|------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| H1         | Los obstáculos físicos condicionan el desplazamiento             | 22 de 38 (57,9 %) consideran fundamental tener en cuenta escaleras, pendientes y aceras deterioradas; 13 de 39 (33,3 %) quieren ver las zonas peligrosas en el mapa                                                                     | Barrera, PuntoAccesible, EvidenciaFotografica; HU-12, 18, 25, 32, 34, 35                                                                  |
| H2         | Se necesita información verificada y actualizada                 | 9 de 38 (23,7 %) eligieron alertas de obstáculos en tiempo real; 20 de 39 (51,3 %) tienen confianza media en los datos de otros usuarios                                                                                                | Estados de Barrera y Reporte, propagación de estado, ValidacionReporte; HU-01, 02, 03, 08, 13, 14, 16, 17, 19, 20, 24, 26, 33, 34, 35, 36 |
| H3         | Se necesita planificar rutas accesibles adaptadas a cada persona | 15 de 38 (39,5 %) escogieron la planificación de rutas como funcionalidad principal; 21 de 38 (55,3 %) dicen que la falta de rutas accesibles limita su autonomía; 26 de 39 (66,7 %) piden adaptación a distintos tipos de discapacidad | PerfilMovilidad, Ruta, SegmentoRuta; HU-09, 15, 29, 30, 31, 32                                                                            |
| H4         | Existe disposición a colaborar                                   | 23 de 38 (60,5 %) valoran la participación ciudadana; ninguna persona rechazó participar; 12 de 36 (33,3 %) marcarían rutas seguras, 9 (25 %) subirían fotos y 9 (25 %) reportarían obstáculos                                          | Registro de usuarios, Reporte, voto de validación; HU-01, 02, 03, 04, 05, 06, 18, 23, 36                                                  |

*Nota.* Elaboración propia a partir de los resultados de la encuesta (n = 39).

### 1.7.4 Metodología de trabajo

El desarrollo del proyecto se organiza mediante un enfoque secuencial basado en la metodología en cascada, siguiendo las etapas y los puntos de control establecidos en la Ruta Oficial del Curso. Este enfoque permite desarrollar y revisar los productos de cada etapa antes de avanzar a la siguiente, manteniendo la relación entre las necesidades identificadas, los requisitos y los elementos de diseño del sistema.

En la fase de concepción se identificó el problema de accesibilidad urbana en Medellín, se delimitó el alcance del sistema, se consultaron referentes relacionados con la temática y se aplicó una encuesta a potenciales usuarios. Los resultados obtenidos se utilizan como insumo para identificar necesidades y justificar las funcionalidades propuestas.

Posteriormente, las necesidades identificadas se relacionan con las historias de usuario y sus criterios de aceptación. A partir de estos elementos se documentan los requisitos funcionales, las reglas de negocio y los requisitos no funcionales. Luego, se elaboran los artefactos de diseño, entre ellos el diccionario de datos, el diagrama de clases, los casos de uso y los mockups de las interfaces.

Durante el proceso se mantiene la trazabilidad entre las necesidades, las historias de usuario, los requisitos y los artefactos de diseño. Asimismo, se aplica la Gestión de Configuración del Software (GCS) mediante el control de versiones, el establecimiento de líneas base y el registro de solicitudes de cambio (CRF), con el propósito de documentar las modificaciones y conservar la consistencia de los productos del proyecto.

El equipo realiza revisiones de los entregables en los puntos de control definidos en el cronograma, verifica las observaciones recibidas y efectúa las correcciones correspondientes antes de continuar con las siguientes actividades. De esta manera, se busca mantener la coherencia entre los requisitos, el modelo del sistema y las interfaces propuestas.

