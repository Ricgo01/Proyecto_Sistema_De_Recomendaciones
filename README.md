# Proyecto de Adopción de Perros

## Introducción

Para esta última fase del proyecto, hemos completado el desarrollo de nuestro programa de un sistema de recomendaciones de adopciones de perros. Este programa busca como objetivo que los usuarios puedan encontrar a su perro ideal gracias a sus preferencias, estos en una checkbox irán marcando cuáles son las preferencias que buscan en su mascota. Además de poder compartir con nuestros usuarios nuestro producto final y saber sobre sus opiniones y algunos cambios que podríamos hacer para que sea la mejor recomendación canina.

## Explicación del Programa

### Lenguaje y Plataforma
El lenguaje de programación elegido para este proyecto fue Java, basándonos en los principios de la programación orientada a objetos para aprovechar al máximo el uso de clases y métodos.

Utilizamos la plataforma Apache NetBeans, que nos ofreció herramientas útiles para la creación de nuestra interfaz gráfica, además de facilitar una conexión sencilla con nuestra base de datos.

### Algoritmo
El algoritmo utilizado para la recomendación de perros en este proyecto se inspira en el concepto del algoritmo de Dijkstra, que es conocido por encontrar el camino más corto en un grafo. En nuestro contexto, el "camino más corto" se refiere a encontrar los perros que tienen la mayor cantidad de coincidencias de atributos con las preferencias del usuario, lo que en términos de grafos se podría considerar como la "ruta más corta" hacia el perro ideal basado en una menor "distancia" o "costo".

La "distancia" o "costo" en nuestro algoritmo es calculado mediante una consulta Cypher que evalúa cada perro basándose en la presencia o ausencia de atributos especificados por el usuario. Cada atributo que coincide exactamente con la preferencia del usuario añade un "costo" de 0, mientras que cada discrepancia añade un "costo" de 1. De esta forma, los perros con el menor "costo" total son los que tienen más atributos en común con las preferencias del usuario, emulando la idea de Dijkstra de minimizar el costo para alcanzar un destino.

Finalmente, el sistema clasifica a los perros según su "costo" acumulado y recomienda los tres perros con el menor "costo". Esto se hace para asegurar que los perros sugeridos son aquellos que más se alinean con las preferencias del usuario, facilitando una recomendación precisa y personalizada. Este enfoque no solo es eficiente, sino que también es intuitivo, ya que permite a los usuarios entender cómo se derivan las recomendaciones basadas en sus propias entradas de preferencias.

## Funcionalidades

### Iniciar Sesión
Esta página sirve para que el usuario pueda tener acceso al programa, el usuario puede tener toda su información guardada al iniciar sesión, si todavía no tiene cuenta, se le da una opción al usuario para que cree un usuario en la página de crear cuenta.
Figura 1. Inicio de sesión

### Crear Cuenta
En esta página se le pide al usuario un nombre, su correo y una contraseña, con estos tres caracteres se crea un usuario con el que podrá iniciar sesión en la página de iniciar sesión. El usuario creado irá a un csv para poder guardar todos sus datos.
Figura 2. Crear Cuenta

### Elegir características del perro
Esta página es la esencial para que el usuario sea vinculado con el perro que más se adecue a sus preferencias, es esta pagina podemos encontrar varias características como lo son: tamaño, color, pelo, personalidad y tolerancia al calor. Después de escoger las características que más le gusten en un perro y presionar buscar e ir a la página de Adoptar un perro de los recomendados. En esta página también se puede regresar a la página anterior e ingresar con otro usuario.
Figura 3. Recomendaciones de perros

### Adopción de un perro
Después de seleccionar las características que más le gusten al usuario, será mandado a esta página en donde se mostrarán tres perros con características similares a las seleccionadas anteriormente, en la parte inferior se puede observar las características similares por las cuales se recomendó ese perro, el usuario puede escoger alguno de estos perros y adoptarlos borrándose de la base de datos.
Figura 4. Resultados y adopción

## Base de datos
La base de datos utilizada fue Neo4j aura, que nos proporcionó una visualización gráfica de nuestros nodos de perros y sus características. Para conectar nuestra base de datos con Apache NetBeans, optamos por iniciar sesión mediante el uso de un nombre de usuario y una contraseña la cual siempre nos brindaría una conexión mientras el programa se esté corriendo. Además, para realizar acciones como la inserción y eliminación de datos, utilizamos Cypher, que facilita la traducción de comandos a un lenguaje comprensible para Neo4j, permitiendo así que nuestro proyecto en Java pudiera comunicarse eficazmente con la base de datos.
Figura 5. Base de datos final

### Explicación
El diagrama final es una representación visual de un sistema que busca identificar la similitud entre diferentes perros basándose en diversas características. Cada perro se representa como un nodo en el diagrama, y estas características se entrelazan entre sí para determinar qué mascotas son más similares en base a las preferencias del usuario.


## Documentación para el uso del programa

### Java
Tener instalada la versión de Java 11 o superior.

### Entorno de Desarrollo (IDE)
Contar con un IDE compatible con interfaces gráficas (GUI). Se recomiendan los siguientes IDEs:
- **NetBeans**
- **IntelliJ**
- **Eclipse**

### Abrir el Proyecto en el IDE
- Clona o descarga el repositorio del proyecto.
- Abre el proyecto en tu IDE de preferencia.

### Compilar y Ejecutar
- Compila el proyecto para asegurarte de que no haya errores.
- Ejecuta el programa desde el IDE desde la clase **Login**

## Integrantes del Equipo
- **Jorge Luis Felipe Aguilar Portillo - 23195**
- **Ricardo Arturo Godinez Sanchéz - 23247**
- **Vianka Vanessa Castro Ordoñez - 23201**

