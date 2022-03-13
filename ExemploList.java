
package collection.list;

import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.*;

//Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 8, 3.6] faça:
public class ExemploList {
    public static void main(String[] args) {
        System.out.println("Crie uma lista e adicione as sete notas: ");
        List<Double> notas = new ArrayList<Double>();
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(8.0);
        notas.add(3.6);
        System.out.println(notas.toString());

        System.out.println("Imprima a posição da nota 5.0: posição " + notas.indexOf(5d));

        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4,8.0);
        System.out.println(notas);

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5.0), 6.0);
        System.out.println(notas);

        System.out.println("Confira se a nota 5.0 esta na lista: ");

        if (notas.contains(5.0) == false){
            System.out.println("Verificando... Nota 5.0 NÃO está na lista.");
        }else{
            System.out.println("Verificando... Nota 5.0 está na lista");
        }

        System.out.println("Imprima todas as notas, uma abaixo da outra, na ordem que foram informadas");

        for (double nota : notas) {
            System.out.println(nota);
        }

        System.out.println("Exiba a terceira nota adicionada: a 3º nota é " + notas.get(2));

        System.out.println("Exiba a menor nota: a menor nota é " + Collections.min(notas));

        System.out.println("Exiba a maior nota: a maior nota é " + Collections.max(notas));

        System.out.print("Exiba a soma dos valores das notas: ");
        Iterator<Double> iterator = notas.iterator();  //atalho criar variável Ctrl + Alt + v
        double soma = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next(); //atalho criar variável Ctrl + Alt + v
            soma += next;
        }
        System.out.print(soma);
        System.out.println("");

        System.out.println("Exiba a média das notas: a média é " + soma/notas.size());

        System.out.println("Adicione a nota 0.0 na 6º posição: ");
        notas.add(5,0d);
        System.out.println(notas);

        System.out.println("Remova a nota 0");
        notas.remove(0d);   //se não indicar o tipo (d), vai considerar inteiro e vai remover a posição.
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7 e exiba a lista atualizada");
        Iterator<Double> iterator1 = notas.iterator();

        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if (next < 7){
                iterator1.remove();
            }
        }
        System.out.println(notas.toString());

        System.out.println("Apague toda a lista");
        notas.clear();
        System.out.println(notas);

        System.out.print("Verifique se a lista esta vazia: ");

        if (notas.isEmpty() == true) {
            System.out.print("Lista vazia");
        }else{
            System.out.print("Lista possui notas");
        }

    }
}
