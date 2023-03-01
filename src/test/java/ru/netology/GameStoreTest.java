package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Баттл", "Шутер");

        assertTrue(store.containsGame(game2));
    }

    @Test
    public void MustAddApPlayingTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Vasiliy", 23);
        store.addPlayTime("Dima", 60);
        store.addPlayTime("Anna", 2);

        int expected = 85;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }

    @Test
    public void ShouldFindPlayerWithLongestPlayedTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Vasiliy", 23);
        store.addPlayTime("Dima", 60);
        store.addPlayTime("Anna", 2);

        String expected = "Dima";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);

    }

    @Test
    public void MustRegisterPlayingTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Vasiliy", 23);
        store.addPlayTime("Vasiliy", 60);
        store.addPlayTime("Vasiliy", 2);


        int expected = 85;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);


    }


}
