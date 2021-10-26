package com.xm.model.piece;

import com.xm.model.Coordinates;
import com.xm.model.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public abstract class Piece implements Data {

    protected final Coordinates coordinates;

}
