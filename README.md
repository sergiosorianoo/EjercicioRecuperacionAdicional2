# EjercicioRecuperacionAdicional2
Ejercicio Recuperación Adicional 2. Estructuras de Datos y Herencia. Serialización JSON

Nos piden realizar el siguiente prototipo:
- Clase SparePart: 
Atributos:  code (integer, clave única primaria), text (String, es una descripción), price (double)
Métodos: Constructor, getters and setters. toString para poder ver en pantalla los todos los datos.
Esta clase modela una pieza de repuesto. Sería una pieza en su conjunto, si tiene otras piezas que la conforman para nosotros en este nivel de abstracción, no nos importará. Por ejemplo, un motor es una SparePart. Pero una caja de cambios, que pertenece a un motor, TAMBIEN es una SparePart. La diferencia es que hay unos tipos especiales de SparePart, los Component, que SI se componen de piezas más pequeñas. Es decir, tanto el motor como la caja de cambios serán Component, y tendrán piezas más pequeñas en su "desglose". Ahora sí, un bloque indivisible, por ejemplo, el disco de freno delantero izquierdo, que es un bloque de metal, es una SparePart, pero NO es un Component (es decir, no se dividirá en piezas más pequeñas, es imposible).

- Clase Component: hereda de SparePart
Atributos: Colección de SparePart. Es decir, un Component es un conjunto de SparePart, almacenado como mapa con clave Integer y value SparePart.

Si queréis un ejemplo, podéis verlo aquí:

https://www.oscaro.es/kit-de-embrague-volante-motor-sachs-2290-602-002-9173223-10025-p#

Cómo podéis observar, en la tabla de "Saber todo de la pieza" os encontráis:
PIEZA TOTAL:
Kit de embrague + Volante motorSACHS - 2290 602 002 (code), con precio 496,22 €

Este sería un Component (que es también SparePart, pues Component hereda de SparePart)

Pero se compone de las siguientes SparePart:

- Plato de presión del embrague, Diámetro: 228 mm (no viene el code, pero en la caja debe de constar)
- Juego de tornillos, embrague - 1874 000 002 (este es el code), Medida de rosca: 6x M7x14
- Tornillo de volante motor - 1874 000 003 (este es el code) , Medida de rosca: 6x M10x1x22 Cantidad de tornillos: 6
- Disco de embrague Número de dientes: 28 (no viene el code, pero en la caja debe de constar)
- Desembrague central, embrague (no viene el code, pero en la caja debe de constar)
- Volante motor (no viene el code, pero en la caja debe de constar)

Los precios de las SparePart sencillas (las seis que aparecen en la lista) no están en la web, pero si se llama y pregunta seguramente se vendan por separado y tengan su precio. Si sólo van en un kit y no se venden por separado, irán con precio 0€.

Implementar las dos clases, y un main para dar de alta SpareParts y Components, buscar una pieza y mostrarla en pantalla (sea sencilla o compleja), generar JSON y grabarlo a fichero de texto, e importar una pieza (sencilla o compleja) desde JSON al sistema (para una posible tienda online futura de componentes mecánicos de coches)

