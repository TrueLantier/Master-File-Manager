# Master File Manager

> Herramienta para automatizar las operaciones tediosas con archivos: listar, crear, eliminar y renombrar, uno por uno o en masa.

## Características

### Listar nombres de archivos
Selecciona un directorio y guarda en un documento los nombres de todos los archivos que contiene.

*Ejemplo:* tienes una carpeta con libros de programación y quieres que una IA los compare y te recomiende el mejor. En lugar de escribir los títulos a mano, generas la lista en un paso.

### Crear carpetas y archivos masivamente
Escribe los nombres y el programa los genera todos de una vez.

*Ejemplo:* necesitas 10 carpetas para guardar, por separado, los videos de tus 10 artistas favoritos. Escribes los 10 nombres y listo. Funciona igual con archivos.

### Eliminar archivos
Pasa los nombres de los archivos y se eliminan.

### Renombrar archivos en masa, con condiciones
Renombra varios archivos a la vez aplicando condiciones: <describe aquí cuáles: por extensión, prefijo, patrón, numeración...>.

```
Antes                     Despues
IMG_0001.jpg      ->      vacaciones_01.jpg
IMG_0002.jpg      ->      vacaciones_02.jpg
IMG_0003.jpg      ->      vacaciones_03.jpg
```


## Tecnologias

- Java <25>
- Java NIO.2 (`java.nio.file`)

## Roadmap

- [x] Listar nombres de archivos de un directorio
- [x] Crear carpetas y archivos masivamente
- [x] Eliminar archivos
- [x] Renombrado masivo con condiciones

## Autor

Angel Eduardo Pedraza Ordoñez