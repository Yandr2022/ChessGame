package org.yuliandr.learnJava.model.entity;

import org.yuliandr.learnJava.model.entity.abstraction.Piece;

public class Knight extends Piece {

    public static final String NAME = "Knight";
    public Knight(Spot spot, String id, boolean white) {
        super(NAME, spot, id, white);
    }
}
