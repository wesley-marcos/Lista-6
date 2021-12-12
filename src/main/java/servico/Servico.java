package servico;

import modelo.Company;
import modelo.Game;
import modelo.Platform;

import java.util.ArrayList;
import java.util.List;

public class Servico {

    public static List<Game> gamesByPlatform(List<Game> games, Platform plataforma){

        List<Game> jogos_plataforma = new ArrayList<>();

        games.stream().filter((game ->
                game.getPlatform().equals(plataforma.name()))).
                forEach(game -> jogos_plataforma.add(game));

        return jogos_plataforma;
    }

    public static List<Game> gamesByCompany(List<Game> games, Company company){

        List<Game> jogos_companies = new ArrayList<>();

        games.stream().filter((game ->
                game.getCompany().replaceAll("\\s+", "").equals(company.name()))).
                forEach(game -> jogos_companies.add(game));

        return jogos_companies;
    }


}
