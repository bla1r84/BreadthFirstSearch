package com.xm.model.data;

import com.xm.model.Coordinates;
import lombok.*;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public abstract class Piece<T> implements Data<T> {

    protected final Coordinates coordinates;

}
