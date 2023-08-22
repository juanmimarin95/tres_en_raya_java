package tresEnRaya;

import java.util.Scanner;

public class Main {

	public static void imprimirTablero(String[][] tablero) {

		System.out.print("Este es el estado actual del tablero");

		for (int i = 0; i < 3; i++) {

			System.out.println();

			for (int j = 0; j < 3; j++) {
				System.out.print(tablero[i][j] + " ");
			}
		}
	}

	public static boolean modificaTablero(String[][] tablero, String movimiento, boolean turnoJugador) {

		boolean movimientoEscrito = false;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (tablero[i][j].equals(movimiento)) {
					if (turnoJugador) {
						tablero[i][j] = "O";
					} else {
						tablero[i][j] = "X";
					}

					movimientoEscrito = true;
				}
			}
		}

		return movimientoEscrito;
	}

	public static boolean turno(Scanner teclado, String[][] tablero, boolean turnoJugador, boolean gameover) {

		if (turnoJugador) {
			System.out.println("Turno del Jugador");

			imprimirTablero(tablero);

			System.out.println();
			System.out.println("Pulsa el numero de la casilla que quieras escribir");
			int movimiento = teclado.nextInt();

			while (!modificaTablero(tablero, String.valueOf(movimiento), turnoJugador)) {
				System.out.println("CASILLA OCUPADA. Pulsa el numero de la casilla que quieras escribir");
				movimiento = teclado.nextInt();
			}
		} else {
			System.out.println("Turno de la maquina");
			int eleccionIA = (int) Math.round(Math.random() * 10);

			imprimirTablero(tablero);

			System.out.println("La eleccion de la maquina es: " + eleccionIA);

			while (!modificaTablero(tablero, String.valueOf(eleccionIA), turnoJugador)) {
				modificaTablero(tablero, String.valueOf(eleccionIA), turnoJugador);
			}
		}

		gameover = comprobadorVictoria(tablero, gameover);

		return gameover;

	}

	public static boolean comprobadorVictoria(String[][] tablero, boolean gameover) {

		// Primera fila
		if ((tablero[0][0] == "O" && tablero[0][1] == "O" && tablero[0][2] == "O")
				|| (tablero[0][0] == "X" && tablero[0][1] == "X" && tablero[0][2] == "X")) {
			gameover = true;
		}

		// Segunda fila
		if ((tablero[1][0] == "O" && tablero[1][1] == "O" && tablero[1][2] == "O")
				|| (tablero[1][0] == "X" && tablero[1][1] == "X" && tablero[1][2] == "X")) {
			gameover = true;
		}

		// Tercera fila
		if ((tablero[2][0] == "O" && tablero[2][1] == "O" && tablero[2][2] == "O")
				|| (tablero[2][0] == "X" && tablero[2][1] == "X" && tablero[2][2] == "X")) {
			gameover = true;
		}

		// Primera columna
		if ((tablero[0][0] == "O" && tablero[1][0] == "O" && tablero[2][0] == "O")
				|| (tablero[0][0] == "X" && tablero[1][0] == "X" && tablero[2][0] == "X")) {
			gameover = true;
		}

		// Segunda columna
		if ((tablero[0][1] == "O" && tablero[1][1] == "O" && tablero[2][1] == "O")
				|| (tablero[0][1] == "X" && tablero[1][1] == "X" && tablero[2][1] == "X")) {
			gameover = true;
		}

		// Tercera columna
		if ((tablero[0][2] == "O" && tablero[1][2] == "O" && tablero[2][2] == "O")
				|| (tablero[0][2] == "X" && tablero[1][2] == "X" && tablero[2][2] == "X")) {
			gameover = true;
		}

		// Cruz 1
		if ((tablero[0][0] == "O" && tablero[1][1] == "O" && tablero[2][2] == "O")
				|| (tablero[0][0] == "X" && tablero[1][1] == "X" && tablero[2][2] == "X")) {
			gameover = true;
		}

		// Cruz 2
		if ((tablero[0][2] == "O" && tablero[1][1] == "O" && tablero[2][0] == "O")
				|| (tablero[0][2] == "X" && tablero[1][1] == "X" && tablero[2][0] == "X")) {
			gameover = true;
		}

		if (gameover) {
			System.out.println("Enhorabuena has derrotado a esta sencilla maquina aleatoria!!");
		}

		return gameover;

	}

	public static void main(String[] args) {

		String[][] tablero = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
		boolean turnoJugador = true;

		boolean gameover = false;

		Scanner teclado = new Scanner(System.in);

		while (!gameover) {
			gameover = turno(teclado, tablero, turnoJugador, gameover);

			turnoJugador = !turnoJugador;
		}

	}

}
