import java.util.*;

class BracketChecker {

    private String brackets;

    private static final Character[] OPENERS = {'(','[','{'};
    private static final Character[] CLOSERS = {')',']','}'};

    BracketChecker(String brackets) {
        this.brackets = brackets;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {

        Map<Character, Character> bracketPairs = new HashMap<>();
        for (int i = 0; i < OPENERS.length; i++) {
            bracketPairs.put(OPENERS[i], CLOSERS[i]);
        }

        List<Character> stack = new LinkedList<>();
        for (int i = 0; i < brackets.length(); i++) {

            char c = brackets.charAt(i);
            if (bracketPairs.containsKey(c)) {
                ((LinkedList<Character>) stack).push(c);
            }
            else if (bracketPairs.containsValue(c) && !stack.isEmpty()) {

                char popVal = ((LinkedList<Character>) stack).pop();
                if (c != bracketPairs.get(popVal)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
