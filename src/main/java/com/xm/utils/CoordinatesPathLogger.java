package com.xm.utils;

import com.xm.model.Node;
import com.xm.model.data.Piece;
import com.xm.utils.mapper.NumberToLetterMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Utility class to output the path from start to target
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class CoordinatesPathLogger {

    public static <T extends Piece> void logPath(Deque<Node<T>> path) {
        log.info("Minimum jumps required: {}", path.size() - 1);
        log.info("Shortest path: {}", generatePathString(path));
    }

    private static <T extends Piece> String generatePathString(Deque<Node<T>> path) {
        Map<Integer, String> numberToLetterMap = NumberToLetterMapper.getNumberToLetterMap();

        StringBuilder stringBuilder = new StringBuilder();

        Deque<T> dataPath = getDataPathFromNodePath(path);

        Iterator<T> iterator = dataPath.iterator();

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

    private static <T extends Piece> Deque<T> getDataPathFromNodePath(Deque<Node<T>> path) {
        return path.stream()
                .map(Node::getData)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

}
