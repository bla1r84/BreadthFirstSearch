package com.xm.model.data;

import com.xm.model.Coordinates;
import lombok.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class Piece implements Data {

    private final Coordinates coordinates;

    public static Piece createPieceFromCoordinates(Coordinates coordinates) {
        return new Piece(coordinates);
    }

}
