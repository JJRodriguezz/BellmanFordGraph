# Algoritmo de Bellman-Ford 
# REALIZADO POR ISABELLA IDARRAGA BOTERO Y JUAN JOSE RODRIGUEZ RESTREPO

Este proyecto implementa el algoritmo de Bellman-Ford para encontrar las distancias más cortas en un grafo ponderado, incluyendo la detección de ciclos negativos.

Además, usa la librería `JGraphX` para representar gráficamente el grafo.

## Estructura del Proyecto

- `src/`: Contiene los archivos fuente `.java` de tu proyecto.
- `bin/`: Contiene los archivos `.class` compilados.
- `libs/`: Contiene la librería `jgraphx.jar` necesaria para la representación gráfica.
- `.vscode/`: Configuración de Visual Studio Code.

## Dependencias

El proyecto requiere la librería `JGraphX`. Asegúrate de que el archivo `jgraphx.jar` esté en la carpeta `libs/`.

## Cómo compilar y ejecutar en Codespaces

1. **Compilar** el proyecto con la siguiente instrucción (desde el terminal de Visual Studio Code o GitHub Codespaces):

   javac -cp libs/jgraphx.jar src/*.java -d bin/
