### Summary

The application uses the Breadth First Search algorithm in order to find the shortest path from the designated start
position to the designated target position. In order to set these positions, you can use the file
**application.properties**. From here you can also set the chess board dimensions and the maximum allowed moves.

The **AdjacentNodesFinder** interface is what defines how the edges of a vertex are found. For example, for a Knight the
**vertex** would be its current position on the board and the **edges** are all the squares it can move to using its
L-shaped movement. This is implemented by the **KnightAdjacentNodesFinder** class. There are two more implementations:
one for a Rook and one for the **MyInteger** class which contains just an Integer and an arbitrary set of edges it can
move to. You can run the **BreadFirstSearchTest.testBFSForMyInteger** test to see this in action.
