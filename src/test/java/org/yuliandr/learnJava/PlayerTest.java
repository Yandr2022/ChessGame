package org.yuliandr.learnJava;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.yuliandr.learnJava.model.entity.Player;
import org.yuliandr.learnJava.model.entity.Spot;
import org.yuliandr.learnJava.model.entity.abstraction.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class PlayerTest {
    private static ArrayList<Player> players;
    private static HashMap<String, Piece> pieces;

    @BeforeAll
    public static void setUp() {
        ChessMain main = new ChessMain();
        players = main.createPlayers();
        pieces = main.createPieces();
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("running before each");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("running after each");
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("running after all");
    }

    @Test
    public void playerCreationSuccesTest() {
        Player whitePlayer = new Player("Beth Harmon", "bethHarmon@gmail.com", true, 2000, 20);
        Assertions.assertEquals("Beth Harmon", whitePlayer.getName());
        Assertions.assertEquals("bethHarmon@gmail.com", whitePlayer.getEmail());
        Assertions.assertEquals(true, whitePlayer.isWhite());
        Assertions.assertEquals(2000, whitePlayer.getRank());
        Assertions.assertEquals(20, whitePlayer.getAge());
    }

    @ParameterizedTest
    @MethodSource("getNameError")
    public void playerCreationIncorrectNameTest(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           Player player = new Player(name, "bethHarmon@gmail.com", true, 2000, 20);
        });
    }

    static Stream<String> getNameError() {
        return Stream.of(null, "", "   ");
    }

    @ParameterizedTest
    @MethodSource("getEmailError")
    public void playerCreationIncorrectEmailTest(String email) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           Player player = new Player("Beth Harmon", email, true, 2000, 20);
        });
    }

    static Stream<String> getEmailError() {
        return Stream.of(null, "", "   ", "aaaaa.bb", "aaaaa@bb","abcdef");
    }

    @ParameterizedTest
    @ValueSource(strings = {"S", "r", "q", "t"})
    //don't work with symbols '*','$' etc & nums
    public void invalidMoveXValuesTest(String x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            players.get(0).movePieces(pieces.get("w_k")
                    , new Spot(x, 8));
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -2, 15, 9})
    public void invalidMoveYValuesTest(int y) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            players.get(0).movePieces(pieces.get("w_k")
                    , new Spot("f", y));
        });
    }


    @Test
    public void invalidMoveWhiteFigure() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            players.get(1).movePieces(pieces.get("w_k")
                    , new Spot("f", 7));
        });
    }

    @Test
    public void invalidMoveBlackFigure() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            players.get(0).movePieces(pieces.get("b_kn")
                    , new Spot("f", 7));
        });
    }

}
