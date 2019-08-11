import java.util.ArrayList;
import java.util.Collections;

public class NQueens {
    /*
    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

    Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

    For example,
    There exist two distinct solutions to the 4-queens puzzle:

    [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
     */

    public static void main(String[] args) {
        NQueens queens = new NQueens();

        ArrayList<ArrayList<String>> result = queens.solveNQueens(4);

        System.out.println(result);
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> initCombination = new ArrayList<>();
        initCombination.add(new ArrayList<>(Collections.singletonList("")));
        return backtracking(initCombination, "", a);
    }

    private ArrayList<ArrayList<String>> backtracking(ArrayList<ArrayList<String>> validCombinations, String symbol, int a) {
        addSymbolToAllCombinations(validCombinations, symbol, a);

        filterValidCombinations(validCombinations, a);

        if (isCombinationsFull(validCombinations, a)) {
            return validCombinations;
        }

        ArrayList<ArrayList<String>> result1 = backtracking(copyNestedLists(validCombinations), "Q", a);
        ArrayList<ArrayList<String>> result2 = backtracking(copyNestedLists(validCombinations), ".", a);

        return mergeCombination(result1, result2);
    }

    private ArrayList<ArrayList<String>> copyNestedLists(ArrayList<ArrayList<String>> list) {
        ArrayList<ArrayList<String>> newList = new ArrayList<>();

        for (ArrayList<String> nestedList : list) {
            newList.add(new ArrayList<>(nestedList));
        }

        return newList;
    }

    private boolean isCombinationsFull(ArrayList<ArrayList<String>> validCombinations, int maxLength) {
        if (validCombinations.isEmpty()) {
            return true;
        }
        ArrayList<String> combination = validCombinations.get(0);
        return combination.size() == maxLength &&
                combination.get(maxLength - 1).length() == maxLength;
    }

    private void addSymbolToAllCombinations(ArrayList<ArrayList<String>> validCombinations, String newSymbol, int maxLength) {
        for (ArrayList<String> combination : validCombinations) {
            addSymbolToCombination(combination, newSymbol, maxLength);
        }
    }

    private void addSymbolToCombination(ArrayList<String> combination, String newSymbol, int maxLength) {
        int lastRowIndex = combination.size() - 1;
        String lastRow = combination.get(lastRowIndex);
        if (lastRow.length() == maxLength) {
            combination.add(newSymbol);
        } else {
            String newRow = lastRow + newSymbol;
            combination.remove(lastRowIndex);
            combination.add(newRow);
        }
    }

    private ArrayList<ArrayList<String>> filterValidCombinations(ArrayList<ArrayList<String>> combinations, int maxLength) {
        int i = 0;

        while (i < combinations.size()) {
            if (validateCombination(combinations.get(i), maxLength)) {
                i++;
            } else {
                combinations.remove(i);
            }
        }

        return combinations;
    }

    private boolean validateCombination(ArrayList<String> combination, int maxLength) {
        int qRow = combination.size() - 1;
        String lastRow = combination.get(qRow);
        int qColumn = lastRow.indexOf("Q");

        if (qColumn < 0 && lastRow.length() == maxLength) {
            return false;
        }

        return qColumn < 0 || (
                isRowValid(combination, qRow) &&
                        isColumnValid(combination, qRow, qColumn) &&
                        isLeftDiagonalValid(combination, qRow, qColumn) &&
                        isRightDiagonalValid(combination, qRow, qColumn));
    }

    private boolean isRowValid(ArrayList<String> combination, int qRow) {
        String lastRow = combination.get(qRow);

        return lastRow.indexOf("Q") == lastRow.lastIndexOf("Q");
    }

    private boolean isColumnValid(ArrayList<String> combination, int qRow, int qColumn) {
        for (int i = 0; i < qRow; i++) {
            String iRow = combination.get(i);
            if (iRow.charAt(qColumn) == 'Q') {
                return false;
            }
        }
        return true;
    }

    private boolean isLeftDiagonalValid(ArrayList<String> combination, int qRow, int qColumn) {
        int i = qRow - 1;
        int j = qColumn - 1;

        while (i >= 0 && j >= 0) {
            char diagonalChar = combination.get(i).charAt(j);

            if (diagonalChar == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }

    private boolean isRightDiagonalValid(ArrayList<String> combination, int qRow, int qColumn) {
        int i = qRow - 1;
        int j = qColumn + 1;

        int maxColumn = combination.get(0).length();
        while (i >= 0 && j < maxColumn) {
            char diagonalChar = combination.get(i).charAt(j);

            if (diagonalChar == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    private ArrayList<ArrayList<String>> mergeCombination(ArrayList<ArrayList<String>> result1, ArrayList<ArrayList<String>> result2) {
        ArrayList<ArrayList<String>> merge = new ArrayList<>();
        merge.addAll(result1);
        merge.addAll(result2);
        return merge;
    }
}
