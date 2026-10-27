# Archivo : build.ps1
# Compila el proyecto y lo deja en build\pau, la carpeta que Tomcat sirve (ver README).
# v1.0 2026-10-27  creacion (chore build)
param([string]$Tomcat = "C:\tomcat")
$ErrorActionPreference = "Stop"
$raiz = $PSScriptRoot
$salida = Join-Path $raiz "build\pau"
$clases = Join-Path $salida "WEB-INF\classes"
$libs = Join-Path $salida "WEB-INF\lib"
New-Item -ItemType Directory -Force -Path $clases, $libs | Out-Null

# 1) Vistas, CSS, JavaScript y WEB-INF
Copy-Item -Path (Join-Path $raiz "src\main\webapp\*") -Destination $salida -Recurse -Force

# 2) Conectores JDBC y JSTL (solo si faltan: Tomcat mantiene abiertos los que ya cargo)
Get-ChildItem (Join-Path $raiz "lib") -Filter *.jar | ForEach-Object {
    $destino = Join-Path $libs $_.Name
    if (-not (Test-Path $destino)) { Copy-Item $_.FullName $destino }
}

# 3) Compilar las clases Java
$fuentes = Get-ChildItem (Join-Path $raiz "src\main\java") -Recurse -Filter *.java | ForEach-Object { $_.FullName }
$cp = (Join-Path $Tomcat "lib\servlet-api.jar") + ";" + (Join-Path $raiz "lib\*")
& javac -encoding UTF-8 -d $clases -cp $cp @fuentes
if ($LASTEXITCODE -ne 0) { throw "La compilacion fallo." }
Write-Host "Listo: $salida"
