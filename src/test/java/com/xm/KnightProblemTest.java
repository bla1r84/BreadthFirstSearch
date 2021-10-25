package com.xm;

import org.junit.jupiter.api.Test;

class KnightProblemTest {

    @Test
    void testValidPositions() {
        /*KnightProblem knightProblem = new KnightProblem();
        Knight knight = new Knight(Pair.of(3, 4));
        List<Pair<Integer, Integer>> possiblePositions = knight.getPossiblePositions();
        assertThat(knightProblem.getValidPositions(possiblePositions, 6)).hasSameElementsAs(List.of(
                Pair.of(1, 3),
                Pair.of(1, 5),
                Pair.of(5, 3),
                Pair.of(5, 5),
                Pair.of(2, 2),
                Pair.of(4, 2)
        ));*/
    }

    @Test
    void testThatPositionIsValid() {
       /* PositionValidator positionValidator = new PositionValidator(6);
        List<Pair<Integer, Integer>> positions = List.of(
                Pair.of(5, 5),
                Pair.of(4, 6),
                Pair.of(2, 6),
                Pair.of(1, 5),
                Pair.of(1, 3),
                Pair.of(2, 2),
                Pair.of(4, 2),
                Pair.of(5, 3)
        );

        assertThat(positionValidator.isValid(positions.get(1))).isFalse();
        assertThat(positionValidator.isValid(positions.get(0))).isTrue();

        assertThat(positions.stream()
                .filter(positionValidator::isValid)
                .count())
                .isEqualTo(6);*/
    }

}
