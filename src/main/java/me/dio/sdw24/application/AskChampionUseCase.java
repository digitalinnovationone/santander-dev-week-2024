package me.dio.sdw24.application;

import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import me.dio.sdw24.domain.model.Champion;
import me.dio.sdw24.domain.ports.ChampionsRepository;

public record AskChampionUseCase(ChampionsRepository repository) {

    public String askChampion(Long championId, String question) {

        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);

        // TODO: Evoluir a lógica de negócio para considerar a integração com IAs Generativas.

        return championContext;
    }
}
