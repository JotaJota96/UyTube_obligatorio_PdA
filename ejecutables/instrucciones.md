# Puesta en produccion de UyTube

## Introducción
Istrucciones para realizar la puesta en produccion de los servidores de UyTube.
Nota: Se asume que Apache Tomcat y Java JRE se encuentran instalados y funcionando correctamente.

## Descripción de los archivos
- **servidor-edt.jar**: Estación de trabajo, utilizada por el administrador y mediante la cual se publica el Web Service
- **uytube.war**: Servidor de páginas web, atiende a los dispositivos de escritorio
- **uytube-mobile.war**: Servidor de páginas web, atiende a los dispositivos móvileso

## Instalacion
### servidor-edt.jar
1. Colocar el archivo donde se desea que se ejecute la aplicación.
2. Ejecutar la aplicación.
3. En la ubicacion del ejecutable se creará un archivo `configuracion.properties` mediante el cual se podrá modificar la URL donde se publicará el Web Service que será consumido por los servidores de paginas web

### uytube.war y uytube-mobile.war
1. Para configurar las rutas de `WSDL` y `Enlace para compartir` será necesario abrir (con WinRar, WinZip, 7zip o àplicaciones similares) los archivos `uytube.war` y `uytube-mobile.war`
2. Dentro del archivo, editar el archivo WEB-INF/web.xml
3. Las variables que se pueden editar son:
	- **rutaPublicacionWebService**: URL donde se encuentra publicado el WSDL del Web Service
	- **urlDeEsteServidor**: Patron  de URL mediante el cual se accede al servidor
	- **urlDelOtroServidor**: Patron  de URL mediante el cual se accede al otro servidor
	- **patronURLFiltroVideo**: Patron  de URL mediante el cual se filtran los enlaces acortados para acceder a un video
	- **urlAcortadaVideo**: URL a la cual se le concatenará el ID del video a compartir
4. Luego de modificar, guardar los cambios y cerrar.
5. Abrir en el navegador el Tomcat Manager
6. Importar los archivos `uytube.war` y `uytube-mobile.war` uno por uno
7. ´Los servidores deberían estar listos para ser usados
Nota: Tener en cuenta que primero se debe ejecutar el `servidor-edt.jar` ya que sin el Web Service disponible, el sitio web no funciona
