#Livraria Saber

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int Nrandom = random.nextInt(100);
        int[] matriz = new int[Nrandom];
        int[] matriz2 = new int[matriz.length];
        int[] matriz3 = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                if (matriz[i] >= 2 && matriz2[j] >= 2) {
                    matriz3[i] = matriz[i] + matriz2[j - 1];
                    System.out.println(matriz3[i]);

                } else {

                    matriz[i] = matriz[i + 1];
                    matriz2[i] = matriz2[i + 1];

                }
            }
        }
    }
}



