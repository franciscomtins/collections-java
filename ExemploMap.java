// data um Map de carro, atenda as instruções
package collection.list;

import javax.swing.*;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        System.out.println("-- Crie um dionário que relacione os modelos e seus respectivos consumos: ");

        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("-- Substitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("gol",15.2);
        System.out.println(carrosPopulares);

        System.out.println("-- Confira se o modelo tucson está no dicionário: ");
        if(carrosPopulares.containsKey("tucson") == false){ //inserida o modelo nesta linha
            System.out.println("Modelo não está no dicionario");
        }else {
            System.out.println("Modelo está no dicionário");
        };

        System.out.println("-- Exiba o consumo do uno: ");
        System.out.println(carrosPopulares.get("uno") + " km/l");

        System.out.println("-- Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("-- Exiba os consumos: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("-- Exiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();

        String modeloMaisEficiente = "";
        for (Map.Entry<String, Double> entry : entries) {
            if(entry.getValue().equals(consumoMaisEficiente)){
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
            }
        }

        System.out.println("-- Exiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());

        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry : entries) {
            if(entry.getValue().equals(consumoMenosEficiente)){
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }

        }

        System.out.println("-- Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;

        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("A soma dos consumos é: " + soma);

        System.out.println("-- Exiba a media dos consumos deste dicionário de carros");
        Double media = (soma/carrosPopulares.size());
        System.out.println("A média dos consumos é: " + media + " km/l");

        System.out.println("-- Remova os modelos com o consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();

        System.out.println("Antes da remoção: " + carrosPopulares);
        while (iterator1.hasNext()){
            if(iterator1.next().equals(15.6)){
                iterator1.remove();
            }
        }
        System.out.println("Após a remoção: " + carrosPopulares);

        // necessário recriar com linkedHashmap
        System.out.println("-- Exiba todos os carros na ordem que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};
        System.out.println(carrosPopulares1);

        // o treemap já ordena para key
        System.out.println("-- Exiba o dicionário ordenado pelo modelo");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

        System.out.println("-- Apague o dicionário de carros e confira se ele esta vazio: ");
        carrosPopulares.clear();

        if(carrosPopulares.isEmpty() == true) System.out.println("dicionário vazio");

    }
}
