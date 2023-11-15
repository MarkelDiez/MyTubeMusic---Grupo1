# MyTubeMusic---Grupo1

<h1>MyTubeMusic</h1>
<p>Esta aplicacion es para guardar en favoritos las canciones favoritas de cada usuario, con un login y registro,
muestra una lista de cancion con las posibilidades que tienes para añadir a favoritos, y buscar por titulo y autor</p>
<p> Es un servidor con SpringBoot y app de Android</p>

<p>Link : Servidor https://github.com/MarkelDiez/MyTubeMusic---Grupo1.git </p>
<p>Link : Aplicacion https://github.com/OierGago/MusicAppGP1.git</p>
<p>Link : Base de datos  https://drive.google.com/file/d/1IC3Wp54-bMxbgSSmjwtK04GoO9Zf8V8N/view </p>

<h1>Descipcion</h1>

<p>En esta aplicacion las posibilidades del usuario son:</p>
<p>- Login/registro</p>
<p>- Visualizar las canciones</p>
<p>- Filtrar las caciones por titulo o autor</p>
<p>- Visualizar las canciones favoritas</p>

<h1>Instalacion del servidor</h1>

<p>Para instalar el servidor se requiere de : </p>
                            <p>- Mysql </p>
                            <p>- Eclipse </p>
<p>Para Mysql se usa un archivo de base de datos, la siguiente: https://drive.google.com/file/d/1IC3Wp54-bMxbgSSmjwtK04GoO9Zf8V8N/view</p>

<p>Para eclipse, creamos una carpeta nueva en el workspace y mediante gitBash clona el repositorio </p>

<p>"git clone https://github.com/MarkelDiez/MyTubeMusic---Grupo1.git"</p>

<p>Y una vez clonado, en eclipse hay que abrir el workspace con la carpeta, se descargaran los datos con el archivo pom y sera usable. </p>

<p>Atencion!! Comprobar las ip Para su respectivo uso:</p>
 <p> - Comprobar el application.properties</p>
        <p>- Estableciendo la ruta de la base de datos del servidor Mysql</p>
        <p>- El usuario y contraseña del servidor de la base de datos</p>
        <p>- El puerto de acceso del servidor SpringBoot</p>

<h1>Usage(uso)</h1>

<p>Para usar la aplicacion una vez clonado los 2 repositorio y haber comprobado en el servidor las direcciones de enrutamiento, haremos el run en eclipse y en la consola observaremos que arranca de manera correcta.</p>
<p>Para la aplicacion lo que deberemos de hacer es una vez clonada en el fichero de retrofit añadiremos nuestra ip del servidor/Local y en el xml de network_segurity_config.xml añadiremos la direccion ip de nuestro servidor para que se accepte el enviar peticiones http</p>

<p>Comprobar Swagger: http://localhost:8081/swagger-ui/index.html#/</p>
