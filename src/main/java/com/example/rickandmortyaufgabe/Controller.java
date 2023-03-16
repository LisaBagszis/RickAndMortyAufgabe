package com.example.rickandmortyaufgabe;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class Controller {

    private final RMService service;

    @GetMapping("/characters")
    public CharacterResponse getAllCharacters() {
        return service.findAllCharacters();
    }
    @GetMapping("/characterss")
    public Character getRandomCharacter() {
        return service.getRandomCharacter();
    }
}
