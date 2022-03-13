/*
Recebendo a temperatura de 6 meses, calculando a média, exibindo a média e os meses em que foi maior
 */

package collection.list;

import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercListaTemperatuaMedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> temperaduras = new ArrayList<Double>();
        double  somaTemperaturas = 0;

        for (int i = 0; i < 6; i++) {
            System.out.println("Digite a temperatura aferida: ");
            double temperatura = scan.nextDouble();
            somaTemperaturas += temperatura;
            temperaduras.add(temperatura);
        }
        System.out.println("------------------------------------------------");
        System.out.println("temperaturas armazenadas");

        System.out.println(temperaduras);
        System.out.println("------------------------------------------------");
        System.out.print("A média semestral das temperaturas foram: ");
        double media = (somaTemperaturas/6);
        System.out.println(media);
        System.out.println("------------------------------------------------");
        System.out.println("temperaturas estiveram acima da média no meses: ");
        Iterator<Double> iterator = temperaduras.iterator();

        int meses = 0;
        while (iterator.hasNext()){
            Double temp = iterator.next();
            if(temp > media){
                switch(meses) {
                    case(0):
                        System.out.println("1 - Janeiro: " + temp);
                        break;
                    case(1):
                        System.out.println("2 - Fevereiro: " + temp);
                        break;
                    case(2):
                        System.out.println("3 - Março: " + temp);
                        break;
                    case(3):
                        System.out.println("4 - Abril: " + temp);
                        break;
                    case(4):
                        System.out.println("5 - Maio: " + temp);
                        break;
                    case(5):
                        System.out.println("6 - Junho: " + temp);
                }
            }
            meses++;
        }




    }
}
