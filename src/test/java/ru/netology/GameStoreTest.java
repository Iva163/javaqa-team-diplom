package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void MustAddApPlayingTime() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
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
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
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
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Vasiliy", 23);
        store.addPlayTime("Vasiliy", 60);
        store.addPlayTime("Vasiliy", 2);


        assertEquals(85, 85);


    }


}
