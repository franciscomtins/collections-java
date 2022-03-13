// Criar lista de contatos com id, contato e numero e atender as demandas propostas
package collection.list;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;

public class ExercMapAgenda {
    public static void main(String[] args) {
        System.out.println("-- Exibir os contatos na ordem aleatória: ");
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1, new Contato("João",1111));
            put(2, new Contato("Manézin",4444));
            put(3, new Contato("Filomena",7777));
        }};
        // System.out.println(agenda);
        for(Map.Entry<Integer, Contato> entry : agenda.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("-- Exibir contatos por ordem de inserção: ");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(){{
           put(1, new Contato("João",1111));
           put(3, new Contato("Manézin",4444));
           put(2, new Contato("Filomena",7777));
        }};
        for (Map.Entry<Integer, Contato> entry : agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("-- Exibir contatos pela ordem de Id: ");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        for(Map.Entry<Integer, Contato> entry : agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("-- Exibir contatos pela ordem do telefone: ");
        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
            }
        });*/

        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));*/

        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumero()));

        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome());
        }

        System.out.println("-- Exiba pela ordem do contato: ");
        //Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(new ComparadorOrdemContato());

        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumero()));

        set1.addAll(agenda.entrySet());
        for(Map.Entry<Integer, Contato> entry : set1){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

    }

}


class Contato {
    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && numero.equals(contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}
/*
class ComparadorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return Integer.compare(c1.getValue().getNumero(),c2.getValue().getNumero());
    }
}
*/

class ComparadorOrdemContato implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
    }
}