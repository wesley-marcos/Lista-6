import modelo.Company;
import modelo.Game;
import modelo.Platform;
import other.CsvUtils;
import servico.Servico;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        Path caminho = null;

        try{

            caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        }

        catch(Exception e){
            e.printStackTrace();
        }

        List<Game> lista_jogos = CsvUtils.readGameCsv(caminho);

        int num_linhas = lista_jogos.size();

        System.out.println("O número de linhas é " + num_linhas);

        List<Game> jogos_PS4 = Servico.gamesByPlatform(lista_jogos, Platform.PS4);

        System.out.println("Numero de jogos de ps4: " + jogos_PS4.size());
        jogos_PS4.forEach(e -> System.out.println(e.getName()));//imprimindo o nome dos jogos de ps4
        System.out.println("");
        List<Game> activisionGames = Servico.gamesByCompany(lista_jogos, Company.Activision);
        System.out.println("Numero de jogos da activision: " + activisionGames.size());
        activisionGames.forEach(e -> System.out.println(e.getName()));//imprimindo o nome dos jogos da activison
    }



}
