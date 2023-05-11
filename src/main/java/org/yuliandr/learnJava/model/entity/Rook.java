package org.yuliandr.learnJava.model.entity;

import org.yuliandr.learnJava.model.entity.abstraction.Piece;

public class Rook extends Piece {

    public static final String NAME = "Rook";

    public Rook(Spot spot, String id, boolean white) {
        super(NAME, spot, id, white);
    }
}
