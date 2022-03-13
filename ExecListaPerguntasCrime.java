/*
Faz perguntas e dependendo das respostas classica como suspeito(2S), cumplice(3/4S) ou assasino(5S)
 */

package collection.list;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExecListaPerguntasCrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> respostas = new ArrayList<String>();

        System.out.println("Telefonou para a vítima?");
        String resposta = scan.next();
        respostas.add(resposta);

        System.out.println("Esteve no local do Crime?");
        resposta = scan.next();
        respostas.add(resposta);

        System.out.println("Mora perto da vítima?");
        resposta = scan.next();
        respostas.add(resposta);

        System.out.println("Devia para a vítima?");
        resposta = scan.next();
        respostas.add(resposta);

        System.out.println("Já trabalhou com a vítima?");
        resposta = scan.next();
        respostas.add(resposta);

        Iterator<String> iterator = respostas.iterator();
        int respostaSim = 0;

        while (iterator.hasNext()) {
            String verificaResposta = iterator.next();
            if (verificaResposta.contains("S")) {
                respostaSim++;
            }
        }

        switch (respostaSim) {
            case (2):
                System.out.println("PESSOA SUSPEITA");
                break;
            case (3):
            case (4):
                System.out.println("PESSOA CUMPLICE");
                break;
            case (5):
                System.out.println("ASSASINA");
                break;
            default:
                System.out.println("PESSOA INOCENTE");
        }
    }
}
