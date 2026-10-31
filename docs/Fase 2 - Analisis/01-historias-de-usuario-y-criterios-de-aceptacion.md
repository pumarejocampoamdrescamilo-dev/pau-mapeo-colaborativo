## 2.1 Historias de usuario y criterios de aceptación

Cada historia corresponde a un método público del diagrama de clases de la . El rol de cada historia es un actor concreto (Administrador del Sistema, Gestor Comunitario o PCD), el origen cita un hallazgo de la sección 1.7.3 o una norma del marco teórico, y cada una tiene al menos un criterio de rechazo. Las bajas se redactan como inactivación: no se elimina ningún registro. Hay 34 historias vigentes (HU-01 a HU-36); HU-22 y HU-27 se retiraron porque corresponden a métodos internos.

Tabla  
*Ficha de la HU-01: Crear rol*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-01</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Crear rol</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Administrador del Sistema, quiero crear un nuevo rol con nombre y descripción, para asignar permisos diferenciados a los distintos tipos de usuarios de la plataforma.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Administrador del Sistema "Laura Gómez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Creación exitosa de un rol</strong></p>
<blockquote>
<p><em># crearRol() · RN-01 (UNIQUE nombre)</em></p>
<p>Cuando Laura crea el rol "Gestor Comunitario" con descripción "Verifica barreras y gestiona reportes en terreno"</p>
<p>Entonces el rol "Gestor Comunitario" queda registrado</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por nombre de rol duplicado</strong></p>
<blockquote>
<p>Dado que ya existe el rol "PCD"</p>
<p>Cuando Laura intenta crear otro rol llamado "PCD"</p>
<p>Entonces el sistema no crea el rol</p>
<p>Y muestra "Ya existe un rol con ese nombre."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgos H2 y H4 (sección 1.7.3): la participación de la comunidad y la verificación de la información exigen diferenciar los roles PCD, Gestor Comunitario y Administrador del Sistema.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-01 (crear rol)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-02: Consultar rol*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-02</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar rol</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Administrador del Sistema, quiero consultar los datos de un rol por su identificador, para verificar su nombre y descripción antes de asignarlo a un usuario.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Administrador del Sistema "Laura Gómez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta de un rol existente</strong></p>
<blockquote>
<p>Dado que existe el rol "PCD" con descripción "Persona con discapacidad física, usa el mapeo y la planificación de rutas"</p>
<p>Cuando Laura consulta el rol "PCD"</p>
<p>Entonces el sistema muestra su nombre y descripción</p>
</blockquote>
<p><strong>Escenario: CA-2 Consulta de un rol inexistente</strong></p>
<blockquote>
<p>Dado que no existe ningún rol con identificador "9"</p>
<p>Cuando Laura consulta el rol "9"</p>
<p>Entonces el sistema muestra "No se encontró ningún rol con ese identificador."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgos H2 y H4 (sección 1.7.3): se necesita consultar los roles definidos antes de asignarlos a quienes colaboran.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-02 (consultar rol)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-03: Actualizar rol*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-03</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Actualizar rol</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Administrador del Sistema, quiero actualizar el nombre o la descripción de un rol existente, para ajustar los permisos que agrupa sin crear uno nuevo.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Administrador del Sistema "Laura Gómez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Actualización exitosa de la descripción de un rol</strong></p>
<blockquote>
<p>Dado que existe el rol "Gestor Comunitario"</p>
<p>Cuando Laura actualiza su descripción a "Verifica barreras, gestiona reportes y asocia equipos afectados"</p>
<p>Entonces el rol "Gestor Comunitario" queda con la nueva descripción</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por nombre duplicado con otro rol</strong></p>
<blockquote>
<p><em># RN-01</em></p>
<p>Dado que existen los roles "PCD" y "Gestor Comunitario"</p>
<p>Cuando Laura intenta renombrar "Gestor Comunitario" a "PCD"</p>
<p>Entonces el sistema no aplica el cambio</p>
<p>Y muestra "Ya existe un rol con ese nombre."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgos H2 y H4 (sección 1.7.3): los permisos de cada rol deben poder ajustarse a medida que cambia la colaboración.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-03 (actualizar rol)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Baja</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-04: Registrar usuario*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-04</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Registrar usuario</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero registrarme en la plataforma con nombre, correo y contraseña, para acceder al mapeo colaborativo y a la planificación de rutas.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el rol "PCD" existe en el catálogo de roles</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Registro exitoso</strong></p>
<blockquote>
<p><em># registrarUsuario() · RN-02 (UNIQUE correo)</em></p>
<p>Cuando una persona se registra como "Marcela Vélez", correo "marcela.velez@mail.com" y una contraseña, con rol "PCD"</p>
<p>Entonces la cuenta queda creada en estado "ACTIVO"</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por correo ya registrado</strong></p>
<blockquote>
<p>Dado que ya existe una cuenta con correo "marcela.velez@mail.com"</p>
<p>Cuando alguien intenta registrarse con ese mismo correo</p>
<p>Entonces el sistema no crea la cuenta</p>
<p>Y muestra "Ese correo ya está registrado."</p>
</blockquote>
<p><strong>Escenario: CA-3 Rechazo por rol inactivo</strong></p>
<blockquote>
<p><em># RN-15 (un rol inactivo no se asigna a usuarios nuevos)</em></p>
</blockquote>
<p>Dado que el rol "PCD" está INACTIVO</p>
<blockquote>
<p>Cuando una persona intenta registrarse con ese rol</p>
<p>Entonces el sistema no crea la cuenta</p>
<p>Y muestra "El rol solicitado no está disponible."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H4 (existe disposición a colaborar), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-04 (registrar usuario)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-05: Consultar usuario*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-05</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar usuario</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Administrador del Sistema, quiero consultar los datos de un usuario por su identificador, para verificar su información y estado antes de gestionar su cuenta.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Administrador del Sistema "Laura Gómez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta de un usuario existente</strong></p>
<blockquote>
<p>Dado que existe el usuario "Marcela Vélez", estado "ACTIVO"</p>
<p>Cuando Laura consulta ese usuario por su identificador</p>
<p>Entonces el sistema muestra nombre, correo y estado</p>
</blockquote>
<p><strong>Escenario: CA-2 Consulta de un usuario inexistente</strong></p>
<blockquote>
<p>Cuando Laura consulta un identificador que no existe</p>
<p>Entonces el sistema muestra "No se encontró ningún usuario con ese identificador."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H4 (sección 1.7.3): 23 de 38 personas (60,5 %) valoran la participación ciudadana, lo que exige usuarios registrados cuyos datos puedan consultarse.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-05 (consultar usuario)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-06: Actualizar datos personales*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-06</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Actualizar datos personales</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero actualizar mis datos personales (nombre, correo), para mantener vigente mi información de contacto.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Actualización exitosa de datos personales</strong></p>
<blockquote>
<p>Cuando Marcela actualiza su correo a "marcela.v@mail.com"</p>
<p>Entonces sus datos quedan actualizados con el nuevo correo</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por correo ya usado por otra cuenta</strong></p>
<blockquote>
<p><em># RN-02</em></p>
</blockquote>
<p>Dado que el correo "daniel.restrepo@mail.com" ya pertenece a otra cuenta</p>
<blockquote>
<p>Cuando Marcela intenta cambiar su correo a "daniel.restrepo@mail.com"</p>
<p>Entonces el sistema no aplica el cambio</p>
<p>Y muestra "Ese correo ya está en uso por otra cuenta."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H4 (sección 1.7.3): quien colabora debe mantener vigentes sus datos de contacto.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-06 (actualizar datos personales)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-07: Iniciar sesión*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-07</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Iniciar sesión</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero iniciar sesión con correo y contraseña, para acceder de forma segura a mi perfil y a las funciones de la plataforma.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><blockquote>
<p>Dado que existe la cuenta de "Marcela Vélez", correo "marcela.v@mail.com"</p>
</blockquote>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Inicio de sesión exitoso</strong></p>
<blockquote>
<p><em># autenticar() · exige estado ACTIVO (RN-03)</em></p>
</blockquote>
<p>Dado que la cuenta está en estado "ACTIVO"</p>
<blockquote>
<p>Cuando Marcela inicia sesión con su correo y su contraseña correcta</p>
<p>Entonces el sistema concede acceso a su perfil</p>
<p>Esquema del escenario: CA-2 Rechazo de inicio de sesión</p>
</blockquote>
<p>Dado que la cuenta está en estado &lt;estado&gt;</p>
<blockquote>
<p>Cuando Marcela intenta iniciar sesión con &lt;credencial&gt;</p>
<p>Entonces el sistema rechaza el acceso</p>
<p>Y muestra "&lt;mensaje&gt;"</p>
<p>Ejemplos:</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Alcance del sistema, sección 1.2 (Registro e inicio de sesión)</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-07 (autenticar usuario)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-08: Cambiar estado de una cuenta*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-08</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Cambiar estado de una cuenta</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Administrador del Sistema, quiero cambiar el estado de una cuenta (Activo, Inactivo, Suspendido), para controlar el acceso de usuarios que incumplan las condiciones de uso.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Administrador del Sistema "Laura Gómez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Suspensión de una cuenta</strong></p>
<p>Dado que el usuario "Carlos Ruiz" está "ACTIVO"</p>
<blockquote>
<p>Cuando Laura cambia su estado a "SUSPENDIDO"</p>
<p>Entonces el usuario "Carlos Ruiz" queda "SUSPENDIDO" y no puede iniciar sesión (ver HU-07)</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por estado igual al actual</strong></p>
<blockquote>
<p>Cuando Laura intenta cambiar el estado de "Carlos Ruiz" a "SUSPENDIDO" nuevamente</p>
<p>Entonces el sistema no aplica el cambio</p>
<p>Y muestra "El usuario ya se encuentra en ese estado."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H2 (sección 1.7.3): 20 de 39 personas (51,3 %) tienen confianza media en los datos de otros usuarios, por lo que hay que poder suspender o inactivar cuentas que incumplan las condiciones de uso.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-08 (cambiar estado de cuenta)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-09: Registrar perfil de movilidad*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-09</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Registrar perfil de movilidad</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero registrar mi perfil de movilidad (tipo/grado de discapacidad, equipo de asistencia, tolerancia a escalones, distancia máxima a pie), para recibir rutas ajustadas a mi condición real.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Registro exitoso del perfil de movilidad</strong></p>
<blockquote>
<p><em># registrarPerfil() · RN-04 (relación 1:1 con usuario, FK UNIQUE); datos sensibles bajo Ley 1581 de 2012</em></p>
<p>Cuando Marcela registra su perfil con tipo de discapacidad "MOTRIZ", grado "MODERADO", condición "USUARIO_SILLA_RUEDAS_TOTAL" y equipo "SILLA_MANUAL"</p>
<p>Entonces el perfil queda registrado asociado únicamente a Marcela</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por perfil ya existente</strong></p>
<blockquote>
<p>Dado que Marcela ya tiene un perfil de movilidad registrado</p>
<p>Cuando Marcela intenta registrar un segundo perfil</p>
<p>Entonces el sistema no crea el nuevo perfil</p>
<p>Y muestra "Ya tienes un perfil de movilidad registrado."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H3 (se necesita planificar rutas accesibles adaptadas a cada persona), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-09 (registrar perfil de movilidad)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-10: Consultar perfil de movilidad*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-10</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar perfil de movilidad</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero consultar mi perfil de movilidad registrado, para verificar los datos que el sistema usará al calcular mis rutas.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión y tiene un perfil de movilidad registrado</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta exitosa del propio perfil</strong></p>
<blockquote>
<p><em># consultarPerfil() · dispara internamente AuditoriaAccesoPerfilMovilidad.registrarAcceso() (método interno; HU-27 retirada)</em></p>
<p>Cuando Marcela consulta su perfil de movilidad</p>
<p>Entonces el sistema muestra todos los datos de su perfil</p>
<p>Y queda registrado un acceso tipo "CONSULTA", resultado "AUTORIZADO" (RN-05)</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Normativa — Ley 1581 de 2012, protección de datos sensibles (marco teórico, sección 1.6)</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-10 (consultar perfil de movilidad); RF-12 (registrar acceso a perfil de movilidad — método interno)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-11: Actualizar perfil de movilidad*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-11</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Actualizar perfil de movilidad</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero actualizar mi perfil de movilidad cuando mi condición cambie, para que las rutas calculadas sigan siendo seguras y realistas.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión y tiene un perfil de movilidad registrado</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Actualización exitosa del perfil</strong></p>
<blockquote>
<p><em># actualizarPerfil() · dispara internamente AuditoriaAccesoPerfilMovilidad.registrarAcceso() (método interno; HU-27 retirada)</em></p>
<p>Cuando Marcela actualiza su distancia máxima a pie a "150" metros</p>
<p>Entonces el perfil queda con el nuevo valor</p>
<p>Y queda registrado un acceso tipo "MODIFICACION", resultado "AUTORIZADO" (RN-05)</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Normativa — Ley 1581 de 2012, protección de datos sensibles (marco teórico, sección 1.6)</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-11 (actualizar perfil de movilidad); RF-12 (registrar acceso a perfil de movilidad — método interno)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-12: Registrar barrera*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-12</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Registrar barrera</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero registrar una barrera de accesibilidad con su tipo, gravedad y ubicación, para dejar constancia oficial de un obstáculo detectado en la ciudad.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Registro exitoso de una barrera</strong></p>
<blockquote>
<p><em># registrarBarrera() · RN-06 (campos obligatorios del diccionario)</em></p>
<p>Cuando Daniel registra una barrera con tipo "ESCALERA_SIN_RAMPA", gravedad "MEDIA", latitud "6.253" y longitud "-75.588"</p>
<p>Entonces la barrera queda registrada en estado "REPORTADA"</p>
<p>Y el sistema asigna la fecha de registro automáticamente</p>
</blockquote>
<p><strong>Escenario: CA-2 Registro con equipo de asistencia principal indicado</strong></p>
<blockquote>
<p>Cuando Daniel registra una barrera indicando además equipo afectado principal "SILLA_MANUAL"</p>
<p>Entonces la barrera queda registrada con ese equipo como principal</p>
<p>Esquema del escenario: CA-3 Rechazo por campo obligatorio faltante</p>
<p><em># RN-06 · tipo, gravedad, latitud y longitud son NOT NULL en el diccionario</em></p>
<p>Cuando Daniel intenta registrar una barrera sin indicar &lt;campo&gt;</p>
<p>Entonces el sistema no registra la barrera</p>
<p>Y muestra "&lt;mensaje&gt;"</p>
<p>Ejemplos:</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H1 (los obstáculos físicos condicionan el desplazamiento), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-13 (registrar barrera)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-13: Consultar barrera*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-13</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar barrera</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero consultar el detalle de una barrera reportada, para decidir si debo evitar esa zona al planificar mi ruta.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta de una barrera existente</strong></p>
<blockquote>
<p><em># consultarBarrera(idBarrera)</em></p>
<p>Dado que existe la barrera "B-104", tipo "ESCALERA_SIN_RAMPA", gravedad "MEDIA", estado "VERIFICADA"</p>
<p>Cuando Marcela consulta la barrera "B-104"</p>
<p>Entonces el sistema muestra tipo, gravedad, estado y ubicación de "B-104"</p>
</blockquote>
<p><strong>Escenario: CA-2 Consulta de una barrera inexistente</strong></p>
<blockquote>
<p>Dado que no existe ninguna barrera con identificador "B-999"</p>
<p>Cuando Marcela consulta la barrera "B-999"</p>
<p>Entonces el sistema muestra "No se encontró ninguna barrera con ese identificador."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H2 (se necesita información verificada y actualizada), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-14 (consultar barrera)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-14: Actualizar estado de la barrera*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-14</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Actualizar estado de la barrera</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero cambiar el estado de una barrera (Reportada, Verificada, Resuelta, Inactiva), para reflejar su situación real tras una revisión en terreno.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Cambio directo de estado tras revisión en terreno</strong></p>
<blockquote>
<p><em># cambiarEstado() invocado directamente por el Gestor Comunitario (padre: HU-14)</em></p>
</blockquote>
<p>Dado que la barrera "B-104" está en estado "REPORTADA"</p>
<blockquote>
<p>Cuando Daniel, tras verificarla en terreno, cambia su estado a "VERIFICADA"</p>
<p>Entonces la barrera "B-104" queda en estado "VERIFICADA"</p>
</blockquote>
<p><strong>Escenario: CA-2 Cambio automático propagado desde un reporte</strong></p>
<blockquote>
<p><em># cambiarEstado() invocado internamente por Reporte.cambiarEstado() (padre compartido: HU-20); RN-09</em></p>
</blockquote>
<p>Dado que la barrera "B-150" está en estado "REPORTADA"</p>
<blockquote>
<p>Cuando Daniel confirma el reporte "RE-310" asociado a "B-150" (HU-20)</p>
<p>Entonces la barrera "B-150" cambia automáticamente a estado "VERIFICADA" sin que Daniel la edite directamente</p>
<p>Esquema del escenario: CA-3 Rechazo por estado inválido</p>
<p>Cuando Daniel intenta cambiar el estado de "B-104" a &lt;estado&gt;</p>
<p>Entonces el sistema no aplica el cambio</p>
<p>Y muestra "&lt;mensaje&gt;"</p>
<p>Ejemplos:</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H2 (sección 1.7.3); regla de propagación de estado entre reporte y barrera (RN-09).</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-15 (cambiar estado de la barrera; comparte trazabilidad con RF-21)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-15: Asociar equipo afectado a una barrera*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-15</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Asociar equipo afectado a una barrera</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero asociar a una barrera los equipos de asistencia que afecta, para que el sistema alerte con precisión a quienes usan ese equipo.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Asociación exitosa de un equipo afectado</strong></p>
<blockquote>
<p><em># asociarEquipoAfectado() · RN-07</em></p>
</blockquote>
<p>Dado que la barrera "B-104" no tiene asociado el equipo "SILLA_ELECTRICA"</p>
<blockquote>
<p>Cuando Daniel asocia a "B-104" el equipo afectado "SILLA_ELECTRICA"</p>
<p>Entonces la barrera "B-104" queda registrada como afectando también a "SILLA_ELECTRICA"</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por equipo ya asociado a la misma barrera</strong></p>
<blockquote>
<p><em># RN-07 (UNIQUE id_barrera, equipo_afectado del diccionario)</em></p>
</blockquote>
<p>Dado que la barrera "B-104" ya tiene asociado el equipo "SILLA_MANUAL"</p>
<blockquote>
<p>Cuando Daniel intenta asociar nuevamente a "B-104" el equipo "SILLA_MANUAL"</p>
<p>Entonces el sistema no duplica la asociación</p>
<p>Y muestra "Ese equipo ya está asociado a esta barrera."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H3 (sección 1.7.3): 26 de 39 personas (66,7 %) piden rutas adaptadas a su condición, y para eso cada barrera debe indicar qué equipos de asistencia afecta.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-16 (asociar equipo afectado)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-16: Consultar equipos afectados por una barrera*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-16</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar equipos afectados por una barrera</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero ver qué equipos de asistencia afecta una barrera, para saber si me afecta según mi perfil de movilidad.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta de los equipos afectados por una barrera</strong></p>
<blockquote>
<p><em># consultarEquiposAfectados(idBarrera)</em></p>
</blockquote>
<p>Dado que la barrera "B-104" afecta a "SILLA_MANUAL" y "SILLA_ELECTRICA"</p>
<blockquote>
<p>Cuando Marcela consulta los equipos afectados por "B-104"</p>
<p>Entonces el sistema muestra "SILLA_MANUAL" y "SILLA_ELECTRICA"</p>
</blockquote>
<p><strong>Escenario: CA-2 Barrera sin equipos asociados</strong></p>
<p>Dado que la barrera "B-220" no tiene equipos afectados asociados</p>
<blockquote>
<p>Cuando Marcela consulta los equipos afectados por "B-220"</p>
<p>Entonces el sistema muestra "Esta barrera no tiene equipos de asistencia asociados."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H2 (se necesita información verificada y actualizada), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-17 (consultar equipos afectados)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-17: Inactivar asociación de equipo afectado*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-17</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Inactivar asociación de equipo afectado</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero inactivar una asociación de equipo afectado registrada por error, para que deje de mostrarse a los usuarios sin perder su historial.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Inactivación exitosa de una asociación errónea</strong></p>
<blockquote>
<p><em># inactivarAsociacion(idBarreraEquipo)</em></p>
</blockquote>
<p>Dado que la barrera "B-104" tiene asociado por error el equipo "MULETAS_BASTON" con estado ACTIVA</p>
<blockquote>
<p>Cuando Daniel inactiva esa asociación</p>
<p>Entonces su estado pasa a INACTIVA</p>
<p>Y la barrera "B-104" deja de mostrar "MULETAS_BASTON" entre sus equipos afectados</p>
<p>Y la asociación se conserva en el historial</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por asociación inexistente</strong></p>
<blockquote>
<p>Dado que no existe ninguna asociación con identificador "BE-999"</p>
<p>Cuando Daniel intenta inactivar la asociación "BE-999"</p>
<p>Entonces el sistema muestra "No se encontró esa asociación."</p>
</blockquote>
<p><strong>Escenario: CA-3 Rechazo por asociación ya inactiva</strong></p>
<blockquote>
<p><em># RN-16 (las bajas son inactivación)</em></p>
</blockquote>
<p>Dado que la asociación "BE-104" ya está INACTIVA</p>
<blockquote>
<p>Cuando Daniel intenta inactivarla de nuevo</p>
<p>Entonces el sistema no cambia nada</p>
<p>Y muestra "La asociación ya está inactiva."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H2 (sección 1.7.3): la información debe estar verificada y actualizada; una asociación errónea se inactiva sin borrar su historial.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-18 (inactivar asociación de equipo afectado)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Baja</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-18: Crear reporte*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-18</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Crear reporte</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero crear un reporte sobre una barrera nueva o sobre el estado de una existente, indicando su origen y una observación, para alertar a la comunidad y al Gestor Comunitario.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<blockquote>
<p><em># Se cumple antes de CADA escenario de esta historia</em></p>
</blockquote>
<p><strong>Escenario: CA-1 Reporte de una barrera nueva (sin barrera asociada)</strong></p>
<blockquote>
<p><em># crearReporte() · origenReporte = NUEVA_BARRERA</em></p>
<p>Dado que Marcela está en un punto sin ninguna barrera registrada en el sistema</p>
<p>Cuando Marcela crea un reporte con origen "NUEVA_BARRERA" y observación "Escalera sin rampa en la Carrera 70 con Calle 44"</p>
<p>Entonces el reporte queda registrado en estado "PENDIENTE", sin barrera asociada</p>
<p>Y el sistema muestra "Reporte registrado correctamente."</p>
</blockquote>
<p><strong>Escenario: CA-2 Reporte de actualización sobre una barrera existente</strong></p>
<blockquote>
<p><em># crearReporte() · origenReporte = ACTUALIZACION_ESTADO, exige barreraAsociada</em></p>
<p>Dado que existe la barrera "B-104, Escalera sin rampa, Carrera 70 con Calle 44"</p>
<p>Cuando Marcela crea un reporte con origen "ACTUALIZACION_ESTADO", barrera asociada "B-104" y observación "Ya instalaron la rampa"</p>
<p>Entonces el reporte queda registrado en estado "PENDIENTE", asociado a "B-104"</p>
<p>Esquema del escenario: CA-3 Rechazo por barrera asociada faltante</p>
<p><em># RN-08 (CHECK del diccionario: id_barrera obligatorio salvo NUEVA_BARRERA)</em></p>
<p>Cuando Marcela intenta crear un reporte con origen &lt;origen&gt; y sin barrera asociada</p>
<p>Entonces el sistema no registra el reporte</p>
<p>Y muestra "&lt;mensaje&gt;"</p>
<p>Ejemplos:</p>
</blockquote>
<p><strong>Escenario: CA-4 Rechazo por dato obligatorio faltante (origen)</strong></p>
<blockquote>
<p><em># Restricción NOT NULL del diccionario (observación es opcional)</em></p>
<p>Cuando Marcela intenta crear un reporte sin indicar el origen</p>
<p>Entonces el sistema no registra el reporte</p>
<p>Y señala "Debe seleccionar el origen del reporte."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgos H1 y H4 (sección 1.7.3).</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-19 (crear reporte)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-19: Consultar reporte*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-19</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar reporte</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero consultar el detalle de un reporte, para decidir si amerita verificación en terreno.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta de un reporte existente</strong></p>
<blockquote>
<p><em># consultarReporte(idReporte) · muestra TODOS los datos del registro</em></p>
<p>Dado que existe el reporte "RE-205" con origen "ALERTA_TEMPORAL", estado "PENDIENTE" y nivel de confianza "3.00"</p>
<p>Cuando Daniel consulta el reporte "RE-205"</p>
<p>Entonces el sistema muestra origen, estado, nivel de confianza, observación, autor y fecha del reporte "RE-205"</p>
</blockquote>
<p><strong>Escenario: CA-2 Consulta de un reporte inexistente</strong></p>
<blockquote>
<p>Dado que no existe ningún reporte con identificador "RE-999"</p>
<p>Cuando Daniel consulta el reporte "RE-999"</p>
<p>Entonces el sistema muestra "No se encontró ningún reporte con ese identificador."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H2 (se necesita información verificada y actualizada), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-20 (consultar reporte)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-20: Cambiar estado del reporte*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-20</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Cambiar estado del reporte</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero cambiar el estado de un reporte (Pendiente, Confirmado, Rechazado, Resuelto), para reflejar el resultado de su revisión y mantener actualizado el estado real de la barrera.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Confirmar un reporte verifica la barrera</strong></p>
<blockquote>
<p><em># cambiarEstado() · RN-09, primera fila de la correspondencia</em></p>
</blockquote>
<p>Dado que el reporte "RE-205" está "PENDIENTE" y asociado a la barrera "B-104" en estado "REPORTADA"</p>
<blockquote>
<p>Cuando Daniel cambia el estado del reporte "RE-205" a "CONFIRMADO"</p>
<p>Entonces el reporte "RE-205" queda en estado "CONFIRMADO"</p>
<p>Y la barrera "B-104" pasa automáticamente a estado "VERIFICADA"</p>
</blockquote>
<p><strong>Escenario: CA-2 Resolver un reporte resuelve la barrera</strong></p>
<blockquote>
<p><em># cambiarEstado() · RN-09, segunda fila de la correspondencia</em></p>
</blockquote>
<p>Dado que el reporte "RE-205" está "CONFIRMADO" y la barrera "B-104" está "VERIFICADA"</p>
<blockquote>
<p>Cuando Daniel cambia el estado del reporte "RE-205" a "RESUELTO"</p>
<p>Entonces la barrera "B-104" pasa automáticamente a estado "RESUELTA"</p>
</blockquote>
<p><strong>Escenario: CA-3 Rechazar el único reporte de una barrera la regresa a Reportada</strong></p>
<blockquote>
<p><em># cambiarEstado() · RN-09, tercera fila: RECHAZADO sin otra evidencia</em></p>
</blockquote>
<p>Dado que el reporte "RE-310" es el único reporte de la barrera "B-150", ambos en estado "PENDIENTE" / "REPORTADA"</p>
<blockquote>
<p>Cuando Daniel cambia el estado del reporte "RE-310" a "RECHAZADO"</p>
<p>Entonces la barrera "B-150" permanece en "REPORTADA"</p>
</blockquote>
<p><strong>Escenario: CA-4 Prevalece el estado más avanzado entre varios reportes</strong></p>
<blockquote>
<p><em># cambiarEstado() · RN-09, regla de prevalencia (RESUELTO &gt; CONFIRMADO &gt; PENDIENTE &gt; RECHAZADO)</em></p>
</blockquote>
<p>Dado que la barrera "B-200" tiene dos reportes: "RE-401" "CONFIRMADO" y "RE-402" "PENDIENTE", y la barrera está "VERIFICADA"</p>
<blockquote>
<p>Cuando Daniel cambia el estado del reporte "RE-402" a "RECHAZADO"</p>
<p>Entonces la barrera "B-200" permanece en "VERIFICADA"</p>
<p>Y el sistema explica "El estado de la barrera no cambia: prevalece el reporte RE-401, CONFIRMADO."</p>
<p>Esquema del escenario: CA-5 Rechazo por estado inválido o sin cambio</p>
<p>Cuando Daniel intenta cambiar el estado del reporte "RE-205" a &lt;estado&gt;</p>
<p>Entonces el sistema no aplica el cambio</p>
<p>Y muestra "&lt;mensaje&gt;"</p>
<p>Ejemplos:</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H2 (sección 1.7.3); regla de negocio §2 del diccionario de datos.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-21 (cambiar estado del reporte)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-21: Asociar barrera a un reporte*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-21</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Asociar barrera a un reporte</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero asociar un reporte a la barrera que describe, para cerrar el ciclo de un reporte que inicialmente notificó una barrera nueva aún no registrada formalmente.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Asociación exitosa de un reporte de barrera nueva</strong></p>
<blockquote>
<p><em># asociarBarrera() · cierra el ciclo de un reporte NUEVA_BARRERA una vez la barrera queda formalmente registrada (HU-12)</em></p>
</blockquote>
<p>Dado que el reporte "RE-205" tiene origen "NUEVA_BARRERA" y no tiene barrera asociada</p>
<blockquote>
<p>Y que Daniel acaba de registrar la barrera "B-104" a partir de ese reporte</p>
<p>Cuando Daniel asocia el reporte "RE-205" a la barrera "B-104"</p>
<p>Entonces el reporte "RE-205" queda vinculado a "B-104"</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por reporte ya asociado a otra barrera</strong></p>
<blockquote>
<p><em># RN-10 (un reporte no se reasigna a una barrera distinta)</em></p>
</blockquote>
<p>Dado que el reporte "RE-205" ya está asociado a la barrera "B-104"</p>
<blockquote>
<p>Cuando Daniel intenta asociar el reporte "RE-205" a la barrera "B-220"</p>
<p>Entonces el sistema no cambia la asociación</p>
<p>Y muestra "El reporte RE-205 ya está asociado a la barrera B-104."</p>
</blockquote>
<p><strong>Escenario: CA-3 Rechazo por barrera inexistente</strong></p>
<blockquote>
<p>Dado que no existe ninguna barrera con identificador "B-999"</p>
<p>Cuando Daniel intenta asociar el reporte "RE-205" a la barrera "B-999"</p>
<p>Entonces el sistema no realiza la asociación</p>
<p>Y muestra "La barrera indicada no existe."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Regla del diagrama de clases (relación 0..1 barreraAsociada); documento del negocio, sección 1.2</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-22 (asociar barrera a un reporte)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

HU-22 (retirada). El método Reporte.recalcularConfianza() es un método interno: no lo solicita una persona, lo dispara ValidacionReporte.registrarVoto() (HU-23) cada vez que se registra un voto. Protege la regla de recálculo RN-11. La numeración de las demás historias no se modifica para conservar la trazabilidad (CRF-11).

Tabla  
*Ficha de la HU-23: Registrar voto de validación*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-23</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Registrar voto de validación</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero votar si un reporte es válido o no, con un comentario opcional, para ayudar a la comunidad a confirmar la veracidad de los reportes.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Carlos Ruiz" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Voto confirmando un reporte</strong></p>
<blockquote>
<p><em># registrarVoto() · dispara internamente recalcularConfianza() (método interno, ver nota bajo HU-22)</em></p>
</blockquote>
<p>Dado que el reporte "RE-205" tiene nivel de confianza "3.00"</p>
<blockquote>
<p>Cuando Carlos vota el reporte "RE-205" como válido, con el comentario "Confirmo, pasé por ahí hoy"</p>
<p>Entonces el voto queda registrado para Carlos sobre "RE-205"</p>
<p>Y el nivel de confianza de "RE-205" se recalcula automáticamente (recalcularConfianza())</p>
</blockquote>
<p><strong>Escenario: CA-2 Voto rechazando un reporte, sin comentario</strong></p>
<blockquote>
<p>Cuando Carlos vota el reporte "RE-310" como no válido, sin comentario</p>
<p>Entonces el voto queda registrado como "no válido" para Carlos sobre "RE-310"</p>
</blockquote>
<p><strong>Escenario: CA-3 Rechazo por segundo voto del mismo usuario sobre el mismo reporte</strong></p>
<blockquote>
<p><em># RN-11 (UNIQUE id_reporte, id_usuario — Corrección 3 del diccionario de datos); protege nivel_confianza de manipulación</em></p>
<p>Dado que Carlos ya votó el reporte "RE-205" anteriormente</p>
<p>Cuando Carlos intenta votar nuevamente el reporte "RE-205"</p>
<p>Entonces el sistema no registra el segundo voto</p>
<p>Y muestra "Ya registraste tu validación para este reporte."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H4 (existe disposición a colaborar), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-23 (recalcular confianza del reporte — método interno); RF-24 (registrar voto de validación)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-24: Consultar votos de un reporte*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-24</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar votos de un reporte</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero consultar todos los votos registrados sobre un reporte, para revisar los comentarios de la comunidad antes de cambiar su estado.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta de los votos de un reporte con comentarios</strong></p>
<blockquote>
<p><em># consultarVotos(idReporte)</em></p>
</blockquote>
<p>Dado que el reporte "RE-205" tiene dos votos registrados: uno válido de "Carlos Ruiz" con comentario y uno no válido de "Marcela Vélez" sin comentario</p>
<blockquote>
<p>Cuando Daniel consulta los votos del reporte "RE-205"</p>
<p>Entonces el sistema muestra ambos votos, cada uno con su autor, su valor (válido/no válido) y su comentario cuando exista</p>
</blockquote>
<p><strong>Escenario: CA-2 Reporte sin votos registrados</strong></p>
<p>Dado que el reporte "RE-401" no tiene ningún voto registrado</p>
<blockquote>
<p>Cuando Daniel consulta los votos del reporte "RE-401"</p>
<p>Entonces el sistema muestra "Este reporte aún no tiene validaciones de la comunidad."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H2 (se necesita información verificada y actualizada), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-25 (consultar votos de un reporte)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-25: Subir evidencia fotográfica*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-25</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Subir evidencia fotográfica</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero subir una foto como evidencia de un reporte, para respaldar visualmente la barrera u obstáculo que estoy denunciando.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Subida exitosa de una evidencia fotográfica</strong></p>
<blockquote>
<p><em># subirEvidencia() · url_foto y fecha_subida son NOT NULL en el diccionario</em></p>
<p>Dado que existe el reporte "RE-205"</p>
<p>Cuando Marcela sube una foto con URL "https://cdn.pau.co/evid/205-1.jpg" asociada al reporte "RE-205"</p>
<p>Entonces la evidencia queda asociada al reporte "RE-205" con su URL y fecha de subida</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por reporte inexistente</strong></p>
<blockquote>
<p>Dado que no existe ningún reporte con identificador "RE-999"</p>
<p>Cuando Marcela intenta subir una foto asociada al reporte "RE-999"</p>
<p>Entonces el sistema no registra la evidencia</p>
<p>Y muestra "El reporte indicado no existe."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H1 (los obstáculos físicos condicionan el desplazamiento), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-26 (subir evidencia fotográfica)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-26: Consultar evidencias de un reporte*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-26</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar evidencias de un reporte</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero ver todas las fotos asociadas a un reporte, para verificar visualmente la barrera antes de confirmar su estado.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta de evidencias de un reporte con fotos</strong></p>
<blockquote>
<p><em># consultarEvidencias(idReporte)</em></p>
</blockquote>
<p>Dado que el reporte "RE-205" tiene dos fotos de evidencia registradas</p>
<blockquote>
<p>Cuando Daniel consulta las evidencias del reporte "RE-205"</p>
<p>Entonces el sistema muestra las dos fotos con su fecha de subida</p>
</blockquote>
<p><strong>Escenario: CA-2 Reporte sin evidencias</strong></p>
<p>Dado que el reporte "RE-401" no tiene ninguna foto asociada</p>
<blockquote>
<p>Cuando Daniel consulta las evidencias del reporte "RE-401"</p>
<p>Entonces el sistema muestra "Este reporte no tiene evidencia fotográfica asociada."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H2 (se necesita información verificada y actualizada), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-27 (consultar evidencias de un reporte)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

HU-27 (retirada). El método AuditoriaAccesoPerfilMovilidad.registrarAcceso() es un método interno: lo disparan PerfilMovilidad.consultarPerfil() (HU-10) y PerfilMovilidad.actualizarPerfil() (HU-11). Protege la regla RN-05: todo acceso, autorizado o denegado, a un perfil de movilidad debe quedar registrado (Ley 1581 de 2012).

Tabla  
*Ficha de la HU-28: Consultar historial de accesos a un perfil de movilidad*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-28</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar historial de accesos a un perfil de movilidad</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Administrador del Sistema, quiero consultar el historial de accesos a un perfil de movilidad, para auditar quién ha consultado o modificado esos datos sensibles y cuándo.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Administrador del Sistema "Laura Gómez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta del historial con accesos autorizados y denegados</strong></p>
<blockquote>
<p><em># consultarHistorialAccesos(idPerfil)</em></p>
</blockquote>
<p>Dado que el perfil de movilidad "PM-30" registra un acceso "CONSULTA" "AUTORIZADO" y un acceso "MODIFICACION" "DENEGADO"</p>
<blockquote>
<p>Cuando Laura consulta el historial de accesos de "PM-30"</p>
<p>Entonces el sistema muestra ambos registros con fecha, acción y resultado</p>
</blockquote>
<p><strong>Escenario: CA-2 Perfil sin accesos registrados</strong></p>
<p>Dado que el perfil de movilidad "PM-55" no tiene accesos registrados</p>
<blockquote>
<p>Cuando Laura consulta el historial de accesos de "PM-55"</p>
<p>Entonces el sistema muestra "Este perfil no registra accesos."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Normativa — Ley 1581 de 2012, protección de datos sensibles (marco teórico, sección 1.6)</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-28 (consultar historial de accesos)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-29: Calcular ruta accesible*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-29</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Calcular ruta accesible</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero calcular una ruta accesible entre un origen y un destino que considere mi perfil de movilidad, para desplazarme evitando las barreras que no puedo sortear.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión y tiene un perfil de movilidad registrado</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Cálculo exitoso de una ruta accesible</strong></p>
<blockquote>
<p><em># calcularRuta() · RN-12 (nivel_accesibilidad y barreras_esquivadas se calculan una sola vez, instantánea histórica — Corrección 8 del diccionario)</em></p>
<p>Cuando Marcela solicita una ruta desde "Carrera 70 #45-10" hasta "Estadio Atanasio Girardot"</p>
<p>Entonces el sistema registra la ruta con distancia, duración, nivel de accesibilidad y barreras esquivadas calculados en ese momento</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por falta de conexión entre origen y destino</strong></p>
<blockquote>
<p>Dado que no existe ningún segmento registrado que conecte el origen con el destino solicitado</p>
<p>Cuando Marcela solicita esa ruta</p>
<p>Entonces el sistema no calcula la ruta</p>
<p>Y muestra "No se encontró un recorrido disponible entre ese origen y ese destino."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H3 (se necesita planificar rutas accesibles adaptadas a cada persona), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-29 (calcular ruta accesible)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-30: Consultar ruta calculada*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-30</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar ruta calculada</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero consultar una ruta que calculé antes, para revisar su recorrido, distancia y nivel de accesibilidad antes de salir.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta de una ruta ya calculada</strong></p>
<blockquote>
<p><em># consultarRuta(idRuta) · retorna el valor guardado, NO recalcula (Corrección 8)</em></p>
<p>Dado que existe la ruta "RT-12" calculada previamente con nivel de accesibilidad "ACCESIBLE_CON_PRECAUCION"</p>
<p>Cuando Marcela consulta la ruta "RT-12"</p>
<p>Entonces el sistema muestra los mismos datos con los que quedó calculada, sin recalcularlos</p>
</blockquote>
<p><strong>Escenario: CA-2 Consulta de una ruta inexistente</strong></p>
<blockquote>
<p>Dado que no existe ninguna ruta con identificador "RT-999"</p>
<p>Cuando Marcela consulta la ruta "RT-999"</p>
<p>Entonces el sistema muestra "No se encontró ninguna ruta con ese identificador."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H3 (se necesita planificar rutas accesibles adaptadas a cada persona), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-30 (consultar ruta calculada)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-31: Consultar segmentos de una ruta*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-31</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar segmentos de una ruta</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero ver el detalle de cada tramo de mi ruta (pendiente, superficie, si tiene rampa), para anticipar las condiciones físicas del camino.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta de los tramos de una ruta en orden</strong></p>
<blockquote>
<p><em># consultarSegmentos(idRuta) · RN-13 (UNIQUE id_ruta, orden_segmento)</em></p>
</blockquote>
<p>Dado que la ruta "RT-12" tiene tres segmentos con ordenSegmento 1, 2 y 3</p>
<blockquote>
<p>Cuando Marcela consulta el detalle de la ruta "RT-12"</p>
<p>Entonces el sistema muestra los tres segmentos en ese orden, cada uno con su pendiente, superficie y si tiene rampa</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por orden de segmento duplicado al construir la ruta</strong></p>
<blockquote>
<p><em># RN-13 (UNIQUE id_ruta, orden_segmento — Corrección 4 del diccionario)</em></p>
</blockquote>
<p>Dado que la ruta "RT-12" ya tiene un segmento con ordenSegmento "2"</p>
<blockquote>
<p>Cuando el sistema intenta agregar otro segmento con ordenSegmento "2" a la misma ruta</p>
<p>Entonces el sistema no registra el segmento duplicado</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H3 (se necesita planificar rutas accesibles adaptadas a cada persona), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-31 (consultar segmentos de una ruta)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-32: Registrar punto accesible*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-32</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Registrar punto accesible</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero registrar un punto accesible (rampa, ascensor, baño adaptado, vado peatonal, paso nivelado, semáforo sonoro) con su ubicación, para que la comunidad sepa dónde encontrar infraestructura inclusiva.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Registro exitoso de un punto accesible</strong></p>
<blockquote>
<p><em># registrarPuntoAccesible() · RN-14 (campos obligatorios del diccionario)</em></p>
<p>Cuando Daniel registra un punto accesible tipo "RAMPA_ACCESIBLE" en latitud "6.251", longitud "-75.590"</p>
<p>Entonces el punto queda registrado en estado "OPERATIVO"</p>
<p>Esquema del escenario: CA-2 Rechazo por campo obligatorio faltante</p>
<p>Cuando Daniel intenta registrar un punto accesible sin indicar &lt;campo&gt;</p>
<p>Entonces el sistema no registra el punto</p>
<p>Y muestra "&lt;mensaje&gt;"</p>
<p>Ejemplos:</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgos H1 y H3 (sección 1.7.3).</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-32 (registrar punto accesible)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Alta</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-33: Consultar punto accesible*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-33</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Consultar punto accesible</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como PCD, quiero consultar el detalle de un punto accesible (tipo, nivel de accesibilidad, estado), para decidir si puedo apoyarme en él durante mi recorrido.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el PCD "Marcela Vélez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Consulta de un punto accesible existente</strong></p>
<blockquote>
<p>Dado que existe el punto accesible "PA-7", tipo "ASCENSOR_URBANO", estado "OPERATIVO"</p>
<p>Cuando Marcela consulta el punto accesible "PA-7"</p>
<p>Entonces el sistema muestra tipo, nivel de accesibilidad y estado</p>
</blockquote>
<p><strong>Escenario: CA-2 Consulta de un punto accesible inexistente</strong></p>
<blockquote>
<p>Dado que no existe ningún punto accesible con identificador "PA-999"</p>
<p>Cuando Marcela consulta el punto accesible "PA-999"</p>
<p>Entonces el sistema muestra "No se encontró ningún punto accesible con ese identificador."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgo H2 (se necesita información verificada y actualizada), sección 1.7.3.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-33 (consultar punto accesible)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-34: Actualizar punto accesible*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-34</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Actualizar punto accesible</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero actualizar los datos de un punto accesible (nivel de accesibilidad, descripción), para mantener la información alineada con su condición real.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Actualización exitosa de un punto accesible</strong></p>
<blockquote>
<p>Dado que existe el punto accesible "PA-7" con nivel de accesibilidad "BUENA"</p>
<p>Cuando Daniel actualiza su nivel de accesibilidad a "EXCELENTE"</p>
<p>Entonces el punto "PA-7" queda con el nuevo nivel</p>
<p>Y el sistema registra la fecha de la actualización</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por punto inexistente</strong></p>
<blockquote>
<p>Dado que no existe ningún punto accesible con identificador "PA-999"</p>
<p>Cuando Daniel intenta actualizar el punto "PA-999"</p>
<p>Entonces el sistema muestra "No se encontró ningún punto accesible con ese identificador."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgos H1 y H2 (sección 1.7.3): la infraestructura registrada debe mantenerse actualizada para que la información sea confiable.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-34 (actualizar punto accesible)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Baja</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-35: Cambiar estado de un punto accesible*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-35</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Cambiar estado de un punto accesible</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Gestor Comunitario, quiero cambiar el estado de un punto accesible (Operativo, En Mantenimiento, Fuera de Servicio), para advertir cuando ese recurso no esté disponible.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Gestor Comunitario "Daniel Restrepo" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Marcar un punto accesible en mantenimiento</strong></p>
<p>Dado que el punto accesible "PA-7" está "OPERATIVO"</p>
<blockquote>
<p>Cuando Daniel cambia su estado a "EN_MANTENIMIENTO"</p>
<p>Entonces el punto "PA-7" queda en estado "EN_MANTENIMIENTO"</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por estado igual al actual</strong></p>
<blockquote>
<p>Cuando Daniel intenta cambiar el estado de "PA-7" a "EN_MANTENIMIENTO" nuevamente</p>
<p>Entonces el sistema no aplica el cambio</p>
<p>Y muestra "El punto accesible ya se encuentra en ese estado."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgos H1 y H2 (sección 1.7.3): hay que advertir cuando un punto accesible deja de estar disponible.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-35 (cambiar estado de punto accesible)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Media</td>
</tr>
</tbody>
</table>

Tabla  
*Ficha de la HU-36: Cambiar estado de un rol*

<table>
<colgroup>
<col style="width: 22%" />
<col style="width: 77%" />
</colgroup>
<tbody>
<tr class="odd">
<td><strong>Código</strong></td>
<td>HU-36</td>
</tr>
<tr class="even">
<td><strong>Título corto</strong></td>
<td>Cambiar estado de un rol</td>
</tr>
<tr class="odd">
<td><strong>Historia</strong></td>
<td>Como Administrador del Sistema, quiero cambiar el estado de un rol (Activo, Inactivo), para dejar de asignar un rol que ya no se usa sin perder el historial de los usuarios que lo tienen.</td>
</tr>
<tr class="even">
<td><strong>Criterios de aceptación</strong></td>
<td><p>Dado que el Administrador del Sistema "Laura Gómez" ha iniciado sesión</p>
<p><em>Antecedentes</em></p>
<p><strong>Escenario: CA-1 Inactivación exitosa de un rol</strong></p>
<blockquote>
<p><em># RN-15 · RN-16</em></p>
<p><em># Rol.cambiarEstado(nuevoEstado)</em></p>
</blockquote>
<p>Dado que el rol "Gestor Comunitario" está ACTIVO</p>
<blockquote>
<p>Cuando Laura lo inactiva</p>
<p>Entonces su estado pasa a INACTIVO</p>
<p>Y el rol ya no puede asignarse a usuarios nuevos</p>
<p>Y los usuarios que ya lo tienen lo conservan</p>
</blockquote>
<p><strong>Escenario: CA-2 Rechazo por rol inexistente</strong></p>
<blockquote>
<p>Dado que no existe ningún rol con identificador "9"</p>
<p>Cuando Laura intenta cambiar su estado</p>
<p>Entonces el sistema muestra "No se encontró ningún rol con ese identificador."</p>
</blockquote>
<p><strong>Escenario: CA-3 Rechazo por rol ya inactivo</strong></p>
<blockquote>
<p><em># RN-15 · RN-16</em></p>
</blockquote>
<p>Dado que el rol "PCD" ya está INACTIVO</p>
<blockquote>
<p>Cuando Laura intenta inactivarlo de nuevo</p>
<p>Entonces el sistema no cambia nada</p>
<p>Y muestra "El rol ya está inactivo."</p>
</blockquote></td>
</tr>
<tr class="odd">
<td><strong>Origen de la necesidad</strong></td>
<td>Hallazgos H2 y H4 (sección 1.7.3): el catálogo de roles debe poder cerrarse sin borrarse.</td>
</tr>
<tr class="even">
<td><strong>RF derivados</strong></td>
<td>RF-36 (cambiar estado de un rol)</td>
</tr>
<tr class="odd">
<td><strong>Prioridad</strong></td>
<td>Baja</td>
</tr>
</tbody>
</table>

