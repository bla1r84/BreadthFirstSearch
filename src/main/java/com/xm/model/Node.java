package com.xm.model;

import com.xm.model.data.Data;
import lombok.*;

/**
 * <p>
 * Generic class that can store various types of Data, not just chess pieces.
 *
 * <p>
 * <b>previous</b> holds the previous Node (where we came from to reach the current Node)
 *
 * <p>
 * <b>depth</b> is the number of steps we had to make in order to reach this Node
 * @param <T> the type of Data the Nodes of the Graph contain
 */
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Node<T extends Data> {

    @EqualsAndHashCode.Include
    private final T data;

    private Node<T> previous;
    private int depth;

}