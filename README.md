
# Spring Facturas 

## Aplicación

La aplicación forma parte de un ejercicio de nivel en el que se ha diseñado y programado una herramientad sencilla de gestión de facturas utilizando la tecnología [Spring Boot](https://spring.io/guides/gs/spring-boot).
## Ejecutar el programa en local
Para el desarrollo se ha susado [Maven](https://spring.io/guides/gs/maven/) y la versión Java 8. Para compilar el programa en el equipo se debe hacer uso del siguiente comando:

```
git clone https://github.com/adricanovas/Spring-Facturas.git
cd Spring-Facturas
./mvnw package
java -jar target/*.jar
```

Este proyecto se ha desarrollado en IntelliJ IDEA 2021.2.3 y la compilación se ha realizado configurando un template de Spring Boot disponible en el IDE.

Una vez ejecutado se puede acceder a la aplicación mediante la URL: http://localhost:8080/


> NOTA: La práctica se ha desarrollado integramente en el entorno Windows por lo que se pueden llegar a encontrar errores e incompatibilidades si no se ejecuta en un entorno Windows.

## Configurar el entorno de desarrollo

### Prerequisitos
Para ejecutar, compilar y editar el codigo fuente se necesitan tener instalados los siguientes programas.
* Java 11 o más actual (JDK completo).
* git command line tool (https://help.github.com/articles/set-up-git)
* El IDE que prefieras
    * IntelliJ IDEA
    * Eclipse Spring Boot
    * [VS Code](https://code.visualstudio.com)

### Pasos para configurarlo:

1) Clonamos el repositorio mediante la línea de comandos
    ```
    git clone https://github.com/adricanovas/Spring-Facturas.git
    ```
2) En Eclipse
    ```
    File -> Import -> Maven -> Existing Maven project
    ```
3) En IntelliJ
     ```
     File -> Open -> Open File or Project
     ```

4) Tras cargar el proyecto en IntelliJ IDEA

   ```
    Run -> Edit Configurations...
   ```
   A continuación seleccionamos la pestaña ```+``` y buscamos _Spring Boot_. Esto carga un compilador configurado para detectar y compilar las dependencias del programa.
  
5) Como ultimo paso le daremos a compilar ``run application``

   Vista [http://localhost:8080](http://localhost:8080) para ver el programa compilado.


## Pila tecnológica utilizada

|Tecnología |
|--------------------------|
| Java |
| Spring |
| JPA |
| Thymeleaft |
| HTML/CSS |

## Vista Principal

La vista principal consta de una lista de facturas almacenadas en la base de datos. Estas facturas tienen dos estados principales: Consolidada y No Consolidada. Este estado implica la imposibilidad de editar las facturas.

![01](https://user-images.githubusercontent.com/29437851/164353321-8649b215-159d-4d68-9648-87bf58a3601f.png)

