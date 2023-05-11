package org.yuliandr.learnJava.model.entity;

import org.yuliandr.learnJava.model.entity.abstraction.Piece;

public class Bishop extends Piece {

    public static final String NAME = "Bishop";
    public Bishop(Spot spot, String id, boolean white) {
        super(NAME, spot, id, white);
    }
}
