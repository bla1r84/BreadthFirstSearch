package com.xm.utils;

import com.xm.model.data.Piece;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.Iterator;
import java.util.Map;

/**
 * Utility class to output the path from start to target
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class CoordinatesPathLogger {

    public static <T extends Piece> void logPath(Deque<T> path) {
        log.info("Minimum jumps required: {}", path.size() - 1);
        log.info("Shortest path: {}", generatePathString(path));
    }

    private static <T extends Piece> String generatePathString(Deque<T> path) {
        Map<Integer, String> numberToLetterMap = NumberToLetterMapper.numberToLetterMap;

        StringBuilder stringBuilder = new StringBuilder();

        Iterator<T> iterator = path.iterator();

        while (iterator.hasNext()) {
            T piece = iterator.next();
            stringBuilder.append("(");

            stringBuilder.append(numberToLetterMap.getOrDefault(
                    piece.getCoordinates().x,
                    String.valueOf(piece.getCoordinates().x + 1)));

            stringBuilder.append(" ");
            stringBuilder.append(piece.getCoordinates().y + 1);
            stringBuilder.append(")");
            if (iterator.hasNext()) {
                stringBuilder.append(" -> ");
            }
        }

        return stringBuilder.toString();
    }

}
