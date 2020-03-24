# Modo de Juego e Instrucciones :video_game:

Connect 4 es un juego el cual consiste en colocar en forma horizontal, vertical o diagonal 4 fichas 
del mismo tipo, comúnmente identificadas por color, en un tablero de forma rectangular. El tamaño 
del tablero base es de 6 filas y 7 columnas para 2 jugadores. 
El tamaño variara según la cantidad de participantes en el juego:
  - 2 jugadores -> 6 filas y 7 columnas, cada jugador tiene 21 fichas
  - 3 jugadores -> 7 filas y 8 columnas, cada jugador tiene 19 fichas
  - 4 jugadores -> 8 filas y 9 columnas, cada jugador tiene 18 fichas

### Nota
La primera etapa del desarrollo del juego esta pensada para que diversas personas
juegen en la misma computadora, en la segunda etapa podremos encontrar un modo visual
del juego para computadora, en la tercera puedan ser partidas en computadora de manera online
para finalmente mudar el juego a smartphones con todas las caracteristicas integradas.

## Previo del juego :black_nib: :information_desk_person:
El jugador podra escoger si desea jugar en compañia de personas o contra la computadora.
Para decidir el turno de los jugadores, la computadora generara N números aleatorios (uno para 
cada concursante) el jugador con el numero mas alto será quien empiece y así de manera 
descendente en caso de ser mas de 2 jugadores. Después de que cada uno de los jugadores 
tenga su turno asignado se comenzara a desarrollar el juego.

## Durante el juego :anger: :family_man_woman_boy_boy:
Cada jugador dispone de 21, 19 o 18 fichas de color segun la cantidad de participantes (para el 
modo consola serán signos representativos escogidos por el usuario como asteriscos, letras, etc) Por turnos, los jugadores deben introducir una ficha en la columna que prefieran (siempre que no esté completa) y ésta caerá a la posición más baja. 

Los jugadores tendran un limite de tiempo de 30 segundos, de lo contrario perdera su turno.

## Finalización del juego  :crossed_fingers: :smile::angry:
Gana la partida el primero que consiga alinear cuatro fichas consecutivas de un mismo color en 
horizontal, vertical o diagonal. 

Si todas las columnas están llenas pero nadie ha hecho una fila válida, es decir, introducir en fila 
de 4 de manera horizontal, vertical o vertical hay un empate.

![Connect4](https://www.switchedonkids.com.au/wp-content/uploads/2017/07/4-in-a-row-M-size-four-in-a-row-line-connecting-bingo-board-game-interactive-1.jpg)

# Iniciar Sesion - Registrarse.

Al comenzar a ejecutar el juego, cada uno de los participantes podra iniciar sesion o registrarse 
para tener un registro de las estadisticas de sus partidas. Dentro de los datos que podra observar 
son la cantidad de victorias totales la cuales estaran divididas en victorias, empates y derrotas, 
ademas de las racha total de victorias. Y por ultimo la ultima conexion del jugador.

Al tener una cuenta en el juego, podran estar en la clasificacion mundial/regional del juego, en 
donde podran subir y escalar posiciones segun sus victorias, empates y derrotas. El orden de la 
posicion sera dado por los parametros mencionados teniendo como prioridad la cantidad de 
victorias (se tomara referencia cuantos jugadores participaron) los empates, mientras que las 
derrotas no influenciaran en la posicion final.

Si se desean registrar deberan proporcionar los siguientes datos:
- Nombre y Apellido
- Nickname (Unico)
- Pais
- Cumpleaños
- Email y contraseña de la cuenta (del juego)

Mientras que para poder iniciar sesion, solo necesitara su nickname/email
y la contraseña que proporciono al crear el juego
