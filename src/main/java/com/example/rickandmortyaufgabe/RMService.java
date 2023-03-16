package com.example.rickandmortyaufgabe;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service

public class RMService {

    private final WebClient client = WebClient.create("https://rickandmortyapi.com/api");
    public CharacterResponse findAllCharacters() {
       ResponseEntity<CharacterResponse> responseEntity = client
                .get()
                .uri("/character")
                .retrieve()
                .toEntity(CharacterResponse.class)
                .block();
        return Objects.requireNonNull(responseEntity).getBody();
    }





    public Character getRandomCharacter() {
        ResponseEntity<Character> responseEntity = client
                .get()
                .uri("/character/%d".formatted((int) (Math.random()*826)))
                .retrieve()
                .toEntity(Character.class)
                .block();
        return Objects.requireNonNull(responseEntity).getBody();
    }


}
