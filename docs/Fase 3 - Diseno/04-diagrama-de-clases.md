## 3.4 Diagrama de clases

La presenta el diagrama de clases en UML, con doce clases de dominio y veinte enumeraciones. Los atributos son privados y los métodos públicos; los atributos derivados (nivelConfianza, nivelAccesibilidad y barrerasEsquivadas) llevan el prefijo «/». Las llaves foráneas del modelo relacional aparecen como asociaciones con su multiplicidad, no como atributos. Las 36 operaciones de las clases son las que la sección 2.1 convierte en historias de usuario (cada ficha cita la clase y el método, por ejemplo Usuario.registrarUsuario()): 34 tienen historia propia, y recalcularConfianza() y registrarAcceso() son métodos internos que dispara otro método, por lo que no tienen historia propia.

Figura  
*Diagrama de clases del sistema PAU*

<img src="../Imagenes/media/2aabbc32e7860d65aad43cef3ed0e185b7aaaad6.png" title="Diagrama de clases del sistema PAU" style="width:6.94792in;height:4.89583in" alt="Diagrama de clases UML con doce clases de dominio, sus métodos y veinte enumeraciones." />

*Nota.* Elaboración propia a partir del diccionario de datos y del MER.

