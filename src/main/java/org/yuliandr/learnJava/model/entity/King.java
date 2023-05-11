package org.yuliandr.learnJava.model.entity;

import org.yuliandr.learnJava.model.entity.abstraction.Piece;

public class King extends Piece {

    public static final String NAME = "King";
    public King(Spot spot, String id, boolean white) {
        super(NAME, spot, id, white);
    }
}
