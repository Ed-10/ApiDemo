/**
 Como primera parte de este proyecto, vamos a generar algunas constantes que nos ayudaran mas adelante, entre estas
 constantes esta una ruta generada localmente para el almacenamiento y carga de archivos pesados.
 Ademas de una constante de firma que mas adelante usaremos con JWT
 **/
package com.example.demoApi.utilidades;
public class Constantes {
    public static final String RUTA_UPLOAD="/var/www/html/upload/"; //Upload de archivos para imagenes, etc.
    public static final String FIRMA="123456"; //Cuando se contruye un JWT. Estos tiene que ir firmados
}
