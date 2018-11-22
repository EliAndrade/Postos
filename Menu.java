package view;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;
import model.Posto;

/**
 *
 * @author 1171140948
 */
public class Menu {
    TreeMap<String, HashSet<Posto>> postosPorNome;
    TreeMap<String, HashSet<Posto>> postosPorEstado;
    Scanner scan = new Scanner(System.in);

    public Menu() {
        postosPorNome = new TreeMap<>();
        postosPorEstado = new TreeMap<>();
    }
    
    
    
    public void inserirPosto() {
        System.out.println("Insira o nome:");
        String nome = scan.nextLine();
        
        System.out.println("Digite o endereço:");
        String endereco = scan.nextLine();
        
        System.out.println("Insira a cidade");
        String cidade = scan.nextLine();
       
        System.out.println("Insira o estado");
        String estado = scan.nextLine();
      
        System.out.println("Digite a latitude e a longitude:");
        double latitude = Double.parseDouble(scan.nextLine());
        double longitude = Double.parseDouble(scan.nextLine());
        
        
        HashSet<Posto> postos = postosPorNome.get(nome);
        if (postos == null) {
            postos = new HashSet<>();   
        }
        postos.add(new Posto(nome, endereco, cidade, estado, latitude, longitude));
        postosPorNome.put(nome, postos);
        
        postos = postosPorEstado.get(estado);
        if (postos == null) {
            postos = new HashSet<>();   
        }
        postos.add(new Posto(nome, endereco, cidade, estado, latitude, longitude));
        postosPorEstado.put(estado, postos);
        System.out.println("Posto cadastrado!");
    }
    
    public Posto escolherPosto(HashSet<Posto> postos) {
        Object array[] = postos.toArray();
        
        if (array.length == 1) {
            return (Posto) array[0];
        }else  {
            for (int i = 0; i<array.length; i++) {
                System.out.println(((Posto) array[i]).getEndereco());
            }

            int i = -1;
            while (i < 0 || i >= array.length) {
                System.out.println("Escolha o número:");
                i = Integer.parseInt(scan.nextLine());
            }
            return (Posto) array[i];
        }
    }
    
    public void removerPosto() {
        System.out.println("Digite o nome:");
        String nome = scan.nextLine();
        HashSet<Posto> postos = postosPorNome.get(nome);
        
        if (postos != null) {
            Posto posto = escolherPosto(postos);
            postos.remove(posto);
            
            postos = postosPorEstado.get(posto.getEstado());
            postos.remove(posto);
            System.out.println("Removido.");
        }else {
            System.out.println("Não encontrado.");
        }
    }
    
    public void consultarPostoPorNome(){
        System.out.println("Insira o nome:");
        String nome = scan.nextLine();
        
        HashSet<Posto> postos = postosPorNome.get(nome);
        
        if (postos != null) {
            Posto posto = escolherPosto(postos);
            System.out.println("Endereço:"+posto.getEndereco());
        }
    }
    
    public void consultarPostoPorEstado() {
        System.out.println("Insira o estado:");
        String estado = scan.nextLine();
        
        HashSet<Posto> postos = postosPorEstado.get(estado);
        
        if (postos != null) {
            Object array[] = postos.toArray();
            
            //Por proximidade:
            TreeMap<Double, Posto> hash = new TreeMap<>();
            
            System.out.println("Insira Latitude:");
            double lt = Double.parseDouble(scan.nextLine());
            System.out.println("Insira Longitude:");
            double lg = Double.parseDouble(scan.nextLine());
            
            for (int i = 0; i<array.length; i++) {
                double distancia = Math.sqrt(
                            Math.pow(lg - ((Posto) array[i]).getLongitude(), 2) + 
                            Math.pow(lt - ((Posto) array[i]).getLatitude(), 2));
                
                if (hash.containsKey(distancia)) {
                    distancia += Double.MIN_VALUE;
                }
                hash.put(distancia, (Posto) array[i]);
            }
            
            
            Collection psts = hash.values();
            for (Object posto : psts) {
                Posto ps = (Posto) posto;
                System.out.println("Nome:"+ps.getNome());
                System.out.println("Endereço:"+ps.getEndereco());
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        while (true) {
            System.out.println("------------");
            
            int i = Integer.parseInt(scan.nextLine());
            switch (i) {
                case 1:
                    menu.inserirPosto();
                    break;
                case 2:
                    menu.consultarPostoPorEstado();
                    break;
                case 3:
                    menu.removerPosto();
                    break;
            }
        }
    }
}
