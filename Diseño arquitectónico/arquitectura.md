---
header-includes:
 - \usepackage{graphicx}
 - \usepackage{float}
---

# DISEÑO ARQUITECTÓNICO:
## **COMPUTERCOMPONENTSCOMPARATOR**

#### Luis Balderas Ruiz, Miguel Ángel Torres López

El diseño arquitectónico elegido ha sido el diseño por capas ya que intentamos asegurar en todo momento la independencia en diseño, implementación y funcionamiento de las distintos módulos lógicos, divididos en capa de presentación (contacto con el usuario), capa de aplicación (analizador y optimizador de consultas) y capa de acceso de datos (manejador y normalizador de los datos).  

Para ilustrar  el diseño, utilizamos el modelo de diagramas 4+1 teniendo en cuenta que, dado que vamos a utilizar Google App Engine, no controlamos a priori la distribución física de los distintos módulos. Por tanto, mostramos las tres siguientes vistas:  

##### VISTA LÓGICA DEL DISEÑO

Dividimos la vista lógica en tres capas. La capa de presentación, orientada a mantener sistema de interfaces de usuario que incluye el sistema. La capa de acceso de datos contiene todo lo relacionado con adquisición y tratamiento de datos del sistema. La capa de aplicación mantiene la relación entre las dos capas anteriores, creando el vínculo a traves de consultas.

\begin{figure}[H]
    \includegraphics[scale=0.4]{VISTA-LOGICA.png}
    \caption{Vista lógica del diseño arquitectónico}
\end{figure}

\newpage

##### VISTA DE DESARROLLO DEL DISEÑO

En la capa de presentación planeamos tener un único módulo orientado a contener el front-end del sistema que tendrá cada usuario. La capa de aplicación contendrá un módulo de consultas, dividida en dos submódulos especializados en analizar las consultas y verificar su consistencia, y optimizar la consulta para una búsqueda eficiente en tiempo. Por último la capa de acceso a datos contiene tres módulos. El primero es una fuente de datos genérica, destinada a recopilar datos de diferentes fuentes específicas. El segundo módulo es un administrador de la caché que almacena búsquedas ya realizadas con anterioridad. El último módulo se encarga de unir los dos anteriores. Contiene un submódulo para unificar los datos de las distintas fuentes y otro para gestionar el acceso y el uso del módulo de la caché.  

\begin{figure}[H]
    \includegraphics[scale=0.43]{VISTA-DESARROLLO.png}
    \caption{Vista del desarrollo (módulos) del diseño arquitectónico}
\end{figure}

\newpage

##### VISTA DE PROCESOS DEL DISEÑO

Tendremos tres procesos en el sistema funcionando simultaneamente. Un servicio encargado de atender a los clientes, la interfaz de usuario. Otro servicio para analizar y optimizar las consultas que vengan del proceso anterior. Y un proceso encargado de gestionar la adquisición de datos, bien desde una fuente externa o desde la caché.

\begin{figure}[H]
    \includegraphics[scale=0.43]{VISTA-PROCESOS.png}
    \caption{Vista de los procesos del diseño arquitectónico}
\end{figure}
