package org.yuliandr.learnJava.model.entity;

import org.yuliandr.learnJava.model.entity.abstraction.Piece;

public class Pawn extends Piece {

    public static final String NAME = "Pawn";
    public Pawn(Spot spot, String id, boolean white) {
        super(NAME, spot, id, white);
    }
}
