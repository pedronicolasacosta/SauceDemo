# Challenge Automation - Pedro Nicolás Acosta

## Herramintas Utilizadas

* Eclipse IDE for Java Developers - Version: 2019-09 R (4.13.0)
* Git Bash

## Implementación

* Proyecto Maven
  * Instalación de Librerías y Plugins
    * selenium-java
    * junit
    * maven-compiler-plugin
    * maven-site-plugin
    * maven-surefire-plugin
    * maven-surefire-report-plugin
    
* Proyecto subido a Github con Git Bash

* Instalacion y ejecución
  * Descargar proyecto de Github
  * Importar proyecto en Eclipse
  * Ejecución por consola Maven: mvn clean install test site
    * Otra opción de ejecución: 
      * Run as -> Run Configurations... -> Maven build -> new configuration -> Setear Base directory -> Goals: clean install test site -> Run
    
  * Finalizada la ejecución, abrir el reporte que se encuentra en la ruta "Path_local_ubicacion_proyecto/SauceDemo/target/site/surefire-report.html"
  para verificar resultados de los Test Case.
  * Si hay test con fallos, se crean los screenshot (.PNG) en la ubicacion "Path_local_ubicacion_proyecto/SauceDemo/target/surefire-reports/"
