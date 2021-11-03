package com.xm.model.data;

import com.xm.model.Coordinates;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public abstract class Piece<T extends Piece<T>> implements Data<T> {

    protected final Coordinates coordinates;

}
