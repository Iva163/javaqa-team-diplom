package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test // проверяет наличие игр в каталоге
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Баттл", "Шутер");

        assertTrue(store.containsGame(game2));
    }

    @Test // регистрирует количество времени сыгранное в одном каталоге
    public void MustAddApPlayingTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Vasiliy", 23);
        store.addPlayTime("Dima", 60);
        store.addPlayTime("Anna", 2);

        int expected = 85;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }

    @Test // выбирает игрока с наибольшим временем наигранных часов
    public void ShouldFindPlayerWithLongestPlayedTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Vasiliy", 23);
        store.addPlayTime("Dima", 60);
        store.addPlayTime("Anna", 2);

        String expected = "Dima";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);

    }


    @Test //регистрирует количество времени сыгранное в одном каталоге
    public void MustRegisterPlayingTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Vasiliy", 23);
        store.addPlayTime("Vasiliy", 60);
        store.addPlayTime("Vasiliy", 2);


        int expected = 85;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);


    }
    @Test
    public void shouldGetTitle() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        String expected = "Нетология Баттл Онлайн";
        String actual = game.getTitle();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldAddGameNotExist() {

        GameStore store = new GameStore();
        Game game1 = null;
        Game game2 = store.publishGame("Баттл", "Шутер");

        assertFalse(store.containsGame(game1));
    }
    @Test
    public void shouldEqualsGame() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Баттл", "Шутер");
        Game game2 = store.publishGame("Баттл", "Шутер");

        assertEquals(game1, game2);
    }

}
