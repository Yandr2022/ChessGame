package org.yuliandr.learnJava;

import org.yuliandr.learnJava.model.entity.*;
import org.yuliandr.learnJava.model.entity.abstraction.Piece;

import java.util.ArrayList;
import java.util.HashMap;

public class ChessMain {
    public static void main(String[] args) {

        ChessMain main = new ChessMain();

        ArrayList<Player> players = main.createPlayers();
        for (Player player : players) {
            System.out.println(player);
        }
        HashMap<String, Piece> pieces = main.createPieces();
            System.out.println(pieces);
        System.out.println("\n");
        main.play(players,pieces);



    }

    public ArrayList<Player> createPlayers(){

        Player whitePlayer = new Player("Beth Harmon", "bethHarmon@gmail.com", true, 2000, 20);
        Player blackPlayer = new Player("Vasiliy Borgov", "borgovVasya@mail.ru", false, 2500, 45);
        ArrayList<Player> players= new ArrayList<>();
        players.add(whitePlayer);
        players.add(blackPlayer);
        return players;

    }

    public HashMap<String, Piece> createPieces() {

        Piece whiteKing = new King(new Spot("h", 7), "w_k", true);
        Piece blackKing = new King(new Spot("d", 8), "b_k", false);
        Piece whiteRook1 = new Rook(new Spot("g", 7), "w_r1", true);
        Piece whiteRook2 = new Rook(new Spot("a", 7), "w_r2", true);
        Piece blackKnight = new Knight(new Spot("a", 6), "b_kn", false);
        HashMap<String, Piece> pieces = new HashMap<>();
        pieces.put(whiteKing.getId(), whiteKing);
        pieces.put(blackKing.getId(), blackKing);
        pieces.put(whiteRook1.getId(), whiteRook1);
        pieces.put(whiteRook2.getId(), whiteRook2);
        pieces.put(blackKnight.getId(), blackKnight);
        return pieces;
    }

    public void play(ArrayList<Player> players, HashMap<String,Piece> pieceHashMap){
        //first move
       try {
           players.get(0).movePieces(pieceHashMap.get("w_r1"),new Spot("a",8));
       }catch (IllegalArgumentException e){
           System.out.println("The move is incorrect, please try again");
           //retry logic
       }
        players.get(1).movePieces(pieceHashMap.get("b_kn"),new Spot("c",8));
    }
}
