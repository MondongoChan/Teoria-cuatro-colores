import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //llenar matriz
        JOptionPane.showMessageDialog(null, "Hola, este es un programa para pintar un mapa con solo 4 colores");
        int paises = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de paises"));
        int[][] matriz = new int[paises][paises];
        for (int i = 0; i < paises; i++) {
            for (int j = 0; j < paises; j++) {
                if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si el pais " + (i + 1) + " es adyacente al pais " + (j + 1) + " de lo contrario ingrese 0"));
                }
            }
        }
        //imprimir matriz
        JOptionPane.showMessageDialog(null, "La matriz de adyacencia es:");
        for (int i = 0; i < paises; i++) {
            for (int j = 0; j < paises; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");

        //asignar adyacencia
        for (int i = 0; i < paises; i++) {
            for (int j = 0; j < paises; j++) {
                if (matriz[i][j] == 1) {
                    System.out.println("El pais " + (i + 1) + " es adyacente al pais " + (j + 1));
                }
            }
            System.out.println();
        }

        //asignar colores
        String colores[] = {"Rojo", "Azul", "Verde", "Amarillo"};

        int[] pais = new int[paises];
        for (int i = 0; i < paises; i++) {
            pais[i] = i + 1;
        }

        //asignar un color diferente si es adyacente
        for (int i = 0; i < paises; i++) {
            for (int j = 0; j < paises; j++) {
                if (matriz[i][j] == 1) {
                    System.out.println("El pais " + (i+1)+ " debe ser de color diferente al pais " + (j+1));
                }
            }
            System.out.println();
        }


        //asignaremos colores, usando el teorema de los 4 colores
        int[] color = new int[paises];
        for (int i = 0; i < paises; i++) {
            color[i] = 0;
        }
        int k = 0;
            for (int i = 0; i < paises; i++) {
            k = color[i] + 1;
            color[i] = k;
            for (int j = 0; j < paises; j++) {
                if (matriz[i][j] == 1 && color[j] == k) {
                    k = k + 1;
                    color[i] = k;
                    j = -1;
                }
            }
        }
        //imprimir colores los colores asignados
        for (int i = 0; i < paises; i++) {
            System.out.println("El pais " + (i + 1) + " es de color " + colores[color[i] - 1]);
        }



    }
}