-- ======================================================================
-- Proyecto : PAU - Mapeo Colaborativo de Rutas Accesibles - IS2
-- Archivo  : db/script_bd_pau.sql
-- Historial: v1.0 2026-10-26 (creacion)   -- cabecera de historial (GCS)
-- Nace de  : Modelo Relacional <- Diccionario de datos (3.1)
-- Motor    : MySQL 8 o MariaDB 10.4+ (XAMPP); InnoDB, utf8mb4. Nunca contiene DELETE.
-- ======================================================================
CREATE DATABASE IF NOT EXISTS pau CHARACTER SET utf8mb4;
USE pau;

CREATE TABLE rol (                               -- entidad MAESTRA
  id_rol                     INT AUTO_INCREMENT PRIMARY KEY,
  nombre                     VARCHAR(50) NOT NULL,  -- RN-01
  descripcion                VARCHAR(255) NULL,
  -- RN-15, RN-16 (baja por inactivacion)
  estado                     ENUM('ACTIVO','INACTIVO') NOT NULL DEFAULT 'ACTIVO',
  CONSTRAINT uq_rol_nombre UNIQUE (nombre)  -- RN-01
) ENGINE=InnoDB;

CREATE TABLE usuario (                           -- entidad MAESTRA
  id_usuario                 INT AUTO_INCREMENT PRIMARY KEY,
  id_rol                     INT NOT NULL,
  nombre_completo            VARCHAR(100) NOT NULL,
  correo                     VARCHAR(150) NOT NULL,  -- RN-02
  contrasena_hash            VARCHAR(255) NOT NULL,
  estado                     ENUM('ACTIVO','INACTIVO','SUSPENDIDO') NOT NULL DEFAULT 'ACTIVO',  -- RN-03
  fecha_registro             DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_usuario_correo UNIQUE (correo),  -- RN-02
  CONSTRAINT fk_usuario_rol FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
) ENGINE=InnoDB;

CREATE TABLE perfil_movilidad (                  -- entidad MAESTRA
  id_perfil                  INT AUTO_INCREMENT PRIMARY KEY,
  id_usuario                 INT NOT NULL,  -- RN-04 (1:1)
  tipo_discapacidad          ENUM('MOTRIZ','VISUAL','AUDITIVA','COGNITIVA','MULTIPLE') NOT NULL,
  grado_discapacidad         ENUM('LEVE','MODERADO','SEVERO','TOTAL') NOT NULL,
  condicion_movilidad        ENUM('USUARIO_SILLA_RUEDAS_TOTAL',
                                  'MOVILIDAD_REDUCIDA_PUESTA_EN_PIE',
                                  'AMBULANTE_CON_SOPORTE','MOVILIDAD_REDUCIDA_SIN_EQUIPO') NOT NULL,
  equipo_asistencia          ENUM('SILLA_MANUAL','SILLA_ELECTRICA','MULETAS','BASTON',
                                  'ANDADOR','NINGUNO') NOT NULL,
  requiere_asistente         BOOLEAN NOT NULL,
  pendiente_maxima           DECIMAL(5,2) NOT NULL,
  distancia_maxima_pie       INT NULL,
  tolerancia_escalones       INT NOT NULL,
  evita_escaleras            BOOLEAN NOT NULL,
  priorizar_rampas           BOOLEAN NOT NULL,
  priorizar_ascensores       BOOLEAN NOT NULL,
  CONSTRAINT uq_perfil_usuario UNIQUE (id_usuario),  -- RN-04
  CONSTRAINT fk_perfil_movilidad_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB;

CREATE TABLE barrera (                           -- entidad MAESTRA
  id_barrera                 INT AUTO_INCREMENT PRIMARY KEY,
  tipo_barrera               ENUM('ESCALERA_SIN_RAMPA','ANDEN_ROTO','HUECO',
                                  'SEMAFORO_SIN_SONIDO','OBSTACULO_EN_ANDEN',
                                  'PENDIENTE_EXCESIVA') NOT NULL,  -- RN-06
  nivel_gravedad             ENUM('BAJA','MEDIA','CRITICA_BLOQUEO_TOTAL') NOT NULL DEFAULT 'MEDIA',  -- RN-06
  equipo_afectado_principal  ENUM('SILLA_MANUAL','SILLA_ELECTRICA','MULETAS_BASTON',
                                  'TODOS') NULL,
  latitud                    DECIMAL(10,6) NOT NULL,  -- RN-06
  longitud                   DECIMAL(10,6) NOT NULL,  -- RN-06
  descripcion                TEXT NULL,
  estado                     ENUM('REPORTADA','VERIFICADA','RESUELTA','INACTIVA') NOT NULL,
  fecha_registro             DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

CREATE TABLE barrera_equipo_afectado (           -- entidad MAESTRA
  id_barrera_equipo          INT AUTO_INCREMENT PRIMARY KEY,
  id_barrera                 INT NOT NULL,
  equipo_afectado            ENUM('SILLA_MANUAL','SILLA_ELECTRICA','MULETAS_BASTON',
                                  'TODOS') NOT NULL,
  -- RN-16 (baja por inactivacion)
  estado                     ENUM('ACTIVA','INACTIVA') NOT NULL DEFAULT 'ACTIVA',
  fecha_registro             DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_barrera_equipo UNIQUE (id_barrera, equipo_afectado),  -- RN-07
  CONSTRAINT fk_barrera_equipo_afectado_barrera FOREIGN KEY (id_barrera) REFERENCES barrera(id_barrera)
) ENGINE=InnoDB;

CREATE TABLE ruta (                              -- entidad TRANSACCIONAL
  id_ruta                    INT AUTO_INCREMENT PRIMARY KEY,
  id_usuario                 INT NOT NULL,
  origen_direccion           VARCHAR(255) NOT NULL,
  origen_latitud             DECIMAL(10,6) NOT NULL,
  origen_longitud            DECIMAL(10,6) NOT NULL,
  destino_direccion          VARCHAR(255) NOT NULL,
  destino_latitud            DECIMAL(10,6) NOT NULL,
  destino_longitud           DECIMAL(10,6) NOT NULL,
  distancia_total_m          DECIMAL(10,2) NOT NULL,
  duracion_estimada_min      INT NOT NULL,
  nivel_accesibilidad        ENUM('ALTA_ACCESIBILIDAD','ACCESIBLE_CON_PRECAUCION',
                                  'ACCESIBILIDAD_LIMITADA') NOT NULL,  -- RN-12 (se calcula una vez)
  barreras_esquivadas        INT NOT NULL,  -- RN-12 (se calcula una vez)
  fecha_creacion             DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_ruta_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB;

CREATE TABLE segmento_ruta (                     -- entidad TRANSACCIONAL
  id_segmento                INT AUTO_INCREMENT PRIMARY KEY,
  id_ruta                    INT NOT NULL,
  orden_segmento             INT NOT NULL,  -- RN-13
  lat_inicio                 DECIMAL(10,6) NOT NULL,
  lon_inicio                 DECIMAL(10,6) NOT NULL,
  lat_fin                    DECIMAL(10,6) NOT NULL,
  lon_fin                    DECIMAL(10,6) NOT NULL,
  distancia_tramo_m          DECIMAL(8,2) NOT NULL,
  pendiente_porcentaje       DECIMAL(5,2) NOT NULL,
  tiene_rampa                BOOLEAN NOT NULL,
  tipo_superficie            ENUM('PAVIMENTO_LISO','ADOQUIN','TIERRA','GRANITO_RUGOSO') NOT NULL,
  CONSTRAINT uq_segmento_ruta_orden UNIQUE (id_ruta, orden_segmento),  -- RN-13
  CONSTRAINT fk_segmento_ruta_ruta FOREIGN KEY (id_ruta) REFERENCES ruta(id_ruta)
) ENGINE=InnoDB;

CREATE TABLE reporte (                           -- entidad TRANSACCIONAL
  id_reporte                 INT AUTO_INCREMENT PRIMARY KEY,
  id_usuario                 INT NOT NULL,
  id_barrera                 INT NULL,  -- RN-08
  origen_reporte             ENUM('NUEVA_BARRERA','ACTUALIZACION_ESTADO','ALERTA_TEMPORAL') NOT NULL,
  estado_reporte             ENUM('PENDIENTE','CONFIRMADO','RECHAZADO','RESUELTO') NOT NULL DEFAULT 'PENDIENTE',  -- RN-09
  nivel_confianza            DECIMAL(5,2) NOT NULL,  -- RN-11
  observacion_usuario        TEXT NULL,
  fecha_reporte              DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_reporte_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
  CONSTRAINT fk_reporte_barrera FOREIGN KEY (id_barrera) REFERENCES barrera(id_barrera),
  CONSTRAINT ck_reporte_barrera CHECK (origen_reporte = 'NUEVA_BARRERA' OR id_barrera IS NOT NULL),  -- RN-08
  CONSTRAINT ck_reporte_confianza CHECK (nivel_confianza BETWEEN 1.00 AND 5.00)  -- RN-11
) ENGINE=InnoDB;

CREATE TABLE validacion_reporte (                -- entidad TRANSACCIONAL
  id_validacion              INT AUTO_INCREMENT PRIMARY KEY,
  id_reporte                 INT NOT NULL,
  id_usuario                 INT NOT NULL,
  es_valido                  BOOLEAN NOT NULL,  -- RN-11
  comentario                 TEXT NULL,
  fecha_validacion           DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_validacion_reporte_usuario UNIQUE (id_reporte, id_usuario),  -- RN-11
  CONSTRAINT fk_validacion_reporte_reporte FOREIGN KEY (id_reporte) REFERENCES reporte(id_reporte),
  CONSTRAINT fk_validacion_reporte_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB;

CREATE TABLE evidencia_fotografica (             -- entidad TRANSACCIONAL
  id_evidencia               INT AUTO_INCREMENT PRIMARY KEY,
  id_reporte                 INT NOT NULL,
  url_foto                   VARCHAR(255) NOT NULL,
  fecha_subida               DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_evidencia_fotografica_reporte FOREIGN KEY (id_reporte) REFERENCES reporte(id_reporte)
) ENGINE=InnoDB;

CREATE TABLE punto_accesible (                   -- entidad MAESTRA
  id_punto_accesible         INT AUTO_INCREMENT PRIMARY KEY,
  id_usuario_registra        INT NOT NULL,
  tipo_elemento              ENUM('RAMPA_ACCESIBLE','ASCENSOR_URBANO','BANO_ADAPTADO',
                                  'VADO_PEATONAL','PASO_NIVELADO','SEMAFORO_SONORO') NOT NULL,  -- RN-14
  nivel_accesibilidad        ENUM('EXCELENTE','BUENA','REGULAR') NOT NULL DEFAULT 'BUENA',
  equipo_beneficiado_principal ENUM('SILLA_MANUAL','SILLA_ELECTRICA','MULETAS_BASTON',
                                    'TODOS') NULL,
  latitud                    DECIMAL(10,6) NOT NULL,  -- RN-14
  longitud                   DECIMAL(10,6) NOT NULL,  -- RN-14
  descripcion                TEXT NULL,
  estado                     ENUM('OPERATIVO','EN_MANTENIMIENTO','FUERA_DE_SERVICIO') NOT NULL DEFAULT 'OPERATIVO',
  fecha_registro             DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_punto_accesible_usuario_registra FOREIGN KEY (id_usuario_registra) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB;

CREATE TABLE auditoria_acceso_perfil_movilidad ( -- entidad TRANSACCIONAL (auditoría)
  id_auditoria               INT AUTO_INCREMENT PRIMARY KEY,
  id_perfil                  INT NOT NULL,
  id_usuario                 INT NOT NULL,
  accion                     ENUM('CONSULTA','MODIFICACION') NOT NULL,  -- RN-05
  resultado                  ENUM('AUTORIZADO','DENEGADO') NOT NULL,  -- RN-05
  fecha_acceso               DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_auditoria_acceso_perfil__perfil FOREIGN KEY (id_perfil) REFERENCES perfil_movilidad(id_perfil),
  CONSTRAINT fk_auditoria_acceso_perfil__usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB;


-- Reglas que no caben en DDL y se validan en la capa de servicio (seccion 3.8 y 4.3):
-- RN-03 (solo usuario ACTIVO inicia sesion), RN-05 (registro de cada acceso al perfil),
-- RN-09 (propagacion reporte -> barrera), RN-10 (reporte no reasignable), RN-12 (calculo unico)
-- y RN-15 (rol INACTIVO no se asigna a usuarios nuevos).

-- Datos semilla: los roles del sistema y un caso minimo para probar las restricciones
INSERT INTO rol (nombre, descripcion) VALUES
  ('PCD', 'Persona con discapacidad: reporta, valida y consulta rutas'),
  ('Gestor Comunitario', 'Gestiona barreras y cambia el estado de los reportes'),
  ('Administrador del Sistema', 'Administra roles, usuarios y puntos accesibles');
INSERT INTO usuario (id_rol, nombre_completo, correo, contrasena_hash) VALUES
  (1, 'Usuario PCD de prueba', 'pcd.prueba@pau.test', '$2a$10$HASH_DE_PRUEBA_NO_REAL_pcd'),
  (2, 'Gestor de prueba', 'gestor.prueba@pau.test', '$2a$10$HASH_DE_PRUEBA_NO_REAL_gestor'),
  (3, 'Administrador de prueba', 'admin.prueba@pau.test', '$2a$10$HASH_DE_PRUEBA_NO_REAL_admin');
INSERT INTO barrera (tipo_barrera, nivel_gravedad, equipo_afectado_principal, latitud, longitud, descripcion, estado) VALUES
  ('ANDEN_ROTO', 'MEDIA', 'SILLA_MANUAL', 6.244203, -75.581211, 'Anden roto frente a la estacion, Medellin', 'REPORTADA');
INSERT INTO reporte (id_usuario, id_barrera, origen_reporte, nivel_confianza, observacion_usuario) VALUES
  (1, 1, 'ACTUALIZACION_ESTADO', 1.00, 'El anden sigue en mal estado');
INSERT INTO validacion_reporte (id_reporte, id_usuario, es_valido, comentario) VALUES
  (1, 2, TRUE, 'Confirmado en terreno');

-- Verificaciones: cada INSERT siguiente debe fallar y demuestra que la restriccion protege su RN.
-- RN-01: rol con nombre repetido      -> Duplicate entry
-- INSERT INTO rol (nombre) VALUES ('PCD');
-- RN-08: reporte sin barrera y con origen distinto de NUEVA_BARRERA -> error de CHECK en ck_reporte_barrera
-- INSERT INTO reporte (id_usuario, id_barrera, origen_reporte, nivel_confianza) VALUES (1, NULL, 'ALERTA_TEMPORAL', 1.00);
-- RN-11: segundo voto del mismo usuario sobre el mismo reporte      -> Duplicate entry
-- INSERT INTO validacion_reporte (id_reporte, id_usuario, es_valido) VALUES (1, 2, FALSE);
