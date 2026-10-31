## 3.6 Auditoría cruzada

La es el acta de la auditoría cruzada entre el diccionario, el MER y el diagrama de clases (Paso 7b). En cada verificación se contrastaron los elementos uno a uno por nombre, no solo su cantidad.

Tabla  
*Auditoría cruzada entre diccionario de datos, MER y diagrama de clases*

| **Verificación**         | **Diccionario**                             | **MER**                     | **Diagrama de clases**                                                   | **Resultado**                                                    |
|--------------------------|---------------------------------------------|-----------------------------|--------------------------------------------------------------------------|------------------------------------------------------------------|
| Entidades                | 12 tablas                                   | 12 entidades                | 12 clases                                                                | Coincide                                                         |
| Campos                   | 96 campos                                   | 96 atributos                | 83 atributos y 13 llaves foráneas (96)                                   | Coincide                                                         |
| Relaciones               | 13 llaves foráneas                          | 13 relaciones               | 13 asociaciones                                                          | Coincide                                                         |
| Restricciones compuestas | 4 (3 UNIQUE y 1 CHECK)                      | 4 notas                     | 4 notas                                                                  | Coincide                                                         |
| Valores de ENUM          | Valores listados por campo                  | Tipo ENUM                   | 20 enumeraciones                                                         | Todos los valores de las enumeraciones figuran en el diccionario |
| Participación opcional   | Campos que admiten NULL y llaves únicas     | Círculo en la pata de gallo | Multiplicidad 0..1                                                       | Coincide (usuario–perfil y barrera–reporte)                      |
| Baja por inactivación    | rol.estado y barrera_equipo_afectado.estado | Mismos campos               | EstadoRol, EstadoAsociacion, Rol.cambiarEstado() e inactivarAsociacion() | Coincide                                                         |

*Nota.* Elaboración propia. Conteos y nombres verificados entre los tres artefactos.

