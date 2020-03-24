# Modo de Juego e Instrucciones :video_game:

Connect 4 es un juego el cual consiste en colocar en forma horizontal, vertical o diagonal 4 fichas 
del mismo tipo, comúnmente identificadas por color, en un tablero de forma rectangular. El tamaño 
del tablero base es de 6 filas y 7 columnas para 2 jugadores. 
El tamaño variara según la cantidad de participantes en el juego:
  - 2 jugadores -> 6 filas y 7 columnas, cada jugador tiene 21 fichas
  - 3 jugadores -> 7 filas y 8 columnas, cada jugador tiene 19 fichas
  - 4 jugadores -> 8 filas y 9 columnas, cada jugador tiene 18 fichas

## Previo del juego :black_nib: :information_desk_person:
Para decidir el turno de los jugadores, la computadora generara N números aleatorios (uno para 
cada concursante) el jugador con el numero mas alto será quien empiece y así de manera 
descendente en caso de ser mas de 2 jugadores. Después de que cada uno de los jugadores 
tenga su turno asignado se comenzara a desarrollar el juego.

## Durante el juego :anger: :family_man_woman_boy_boy:
Cada jugador dispone de 21 fichas de color (para el modo consola serán signos representativos 
escogidos por el usuario) Por turnos, los jugadores deben introducir una ficha en la columna que 
prefieran (siempre que no esté completa) y ésta caerá a la posición más baja. 

Los jugadores tendran un limite de tiempo de 30 segundos, de lo contrario perdera su turno.

## Finalización del juego  :crossed_fingers: :smile::angry:
Gana la partida el primero que consiga alinear cuatro fichas consecutivas de un mismo color en 
horizontal, vertical o diagonal. 

Si todas las columnas están llenas pero nadie ha hecho una fila válida, es decir, introducir en fila 
de 4 de manera horizontal, vertical o vertical hay un empate.

![Connect4](https://www.switchedonkids.com.au/wp-content/uploads/2017/07/4-in-a-row-M-size-four-in-a-row-line-connecting-bingo-board-game-interactive-1.jpg)
