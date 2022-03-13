package collection.list;

import java.sql.SQLOutput;
import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        System.out.println("Crie um conjunto e adicione notas:" );
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString());

        System.out.print("Confira se a nota 5.0 esta no conjunto: ");

        if (notas.contains(5d) == true){
            System.out.println("Sim, o conjunto possui a nota ");
        }else {
            System.out.println("Não, a nota não está no conjunto");
        }

        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.println("Exiba a maior nota: " + Collections.max(notas));
        System.out.print("Soma dos valores: ");

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println(soma);

        System.out.print("Exiba a média das notas: ");
        Double media = soma/notas.size();
        System.out.println(media);

        System.out.println("Remova a nota O");
        notas.remove(0d);
        System.out.println(notas);

        Iterator<Double> iterator1 = notas.iterator();

        System.out.println("Remova as notas menor que 7");

        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7){
                iterator1.remove();
            }
        };
        System.out.println(notas);

        System.out.print("Exiba todas as notas na ordem que foram informada: ");
        // método HashSet não faz, precisa usar o linkedHashSet
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.print("Exiba todos as notas em ordem crescente: ");
        //método TreeSet já exibe assim, então recriar nela
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.print("Apague todo o conjunto: ");
        notas.clear();
        System.out.println("apagado (" + notas.isEmpty() + ")");
    }
}
