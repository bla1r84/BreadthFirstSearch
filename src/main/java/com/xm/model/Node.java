package com.xm.model;

import lombok.*;

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