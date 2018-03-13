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

\begin{figure}[H]
    \includegraphics[scale=0.4]{VISTA-LOGICA.png}
    \caption{Vista lógica del diseño arquitectónico}
\end{figure}

\newpage

##### VISTA DE DESARROLLO DEL DISEÑO

\begin{figure}[H]
    \includegraphics[scale=0.43]{VISTA-DESARROLLO.png}
    \caption{Vista del desarrollo (módulos) del diseño arquitectónico}
\end{figure}

\newpage

##### VISTA DE PROCESOS DEL DISEÑO

\begin{figure}[H]
    \includegraphics[scale=0.43]{VISTA-PROCESOS.png}
    \caption{Vista de los procesos del diseño arquitectónico}
\end{figure}