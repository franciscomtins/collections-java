package collection.list;

import javax.annotation.processing.SupportedSourceVersion;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
        Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("-- Imprima todos os elementos dessa lista de String: ");
        numerosAleatorios.forEach(System.out::println);

        System.out.println("-- Insira os 5 primeiros números em um set: ");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("-- Transfome a lista de String em uma lista de números inteiros: ");
        List<Integer> collectList = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("-- Insera os números pares maiores que 2 em uma lista: ");
        List<Integer> listaParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 ==0 && i > 2)).collect(Collectors.toList());
        System.out.println(listaParesMaioresQue2);

        System.out.println("-- Mostra a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("-- Remova os valores impares: ");
        List<Integer> numerosAleatoriosImpares = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numerosAleatoriosImpares.removeIf(i -> (i % 2 !=0));
        System.out.println(numerosAleatoriosImpares);

    }
}
