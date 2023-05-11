package org.yuliandr.learnJava.model.entity;

import org.yuliandr.learnJava.model.entity.abstraction.Piece;

public class Queen extends Piece {

    public static final String NAME = "Queen";
    public Queen(Spot spot, String id, boolean white) {
        super(NAME, spot, id, white);
    }
}
