package com.xm;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.Iterator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class PathLogger {

    public static void logPath(Deque<Square> path) {
        log.info("Minimum jumps required: {}", path.getFirst().getDepth());
        log.info("Shortest path: {}", generatePathString(path));
    }

    private static String generatePathString(Deque<Square> path) {
        StringBuilder stringBuilder = new StringBuilder();

        Iterator<Square> iterator = path.descendingIterator();

        while (iterator.hasNext()) {
            Square square = iterator.next();
            stringBuilder.append("(");
            stringBuilder.append(square.getX());
            stringBuilder.append(" ");
            stringBuilder.append(square.getY());
            stringBuilder.append(")");
            if (iterator.hasNext()) {
                stringBuilder.append(" -> ");
            }
        }

        return stringBuilder.toString();
    }

}
