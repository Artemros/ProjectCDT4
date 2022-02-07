import java.util.Map;
import java.util.Stack;

public class Recognizer {
    Dictionary dictionary = new Dictionary();

    int nextState(String symbolsLane) {
        int answer = 1;
        StringBuilder production_sequence = new StringBuilder();
        String[] words = symbolsLane.split("\\s");
        for (String word : words) {
            if (!dictionary.isTerminal(word) && !word.equals("respectively")) {
//                if(word.equals("")){
//                    //return 0;
//                }
                return -1;
            }
        }
        Stack<String> stack = new Stack<>();
        stack.push("Sentence");
        int current_in_text_number = 0;
        while (current_in_text_number < words.length) {
            String current_in_text = words[current_in_text_number];
            if (!dictionary.isTerminal(current_in_text) && !current_in_text.equals("respectively")) {
                return -1;
            }
            if (stack.isEmpty()) {
                if(current_in_text.equals("respectively.")){
                    return 1;
                }
                if(current_in_text.equals("respectively"))
                {
                    return 0;
                }
                answer = 0;
                break;
            }
            String current_in_stack = stack.pop();
            if (dictionary.isTerminal(current_in_stack)) {
                if (current_in_stack.equals(current_in_text)) {
                    current_in_text_number++;
                    continue;
                } else {
                    return 0;
                }
            }
            if (dictionary.isNotTerminal(current_in_stack)) {
                Integer production = dictionary.GetLookUpTableNumber(current_in_stack, current_in_text);
                if (production == -1) {
                    return 0;
                }
                production_sequence.append(production).append(" ");
                String line = dictionary.getProductionByNumber(production);
                String[] for_push = line.split("\\s");
                for(int q=for_push.length-1;q>=0;q--){
                    if(for_push[q]!="") {
                        stack.push(for_push[q]);
                    }
                }
            }
        }
        if ((stack.isEmpty() && words.length==current_in_text_number) || (stack.size()==1 && stack.pop().equals("St"))) {
            //System.out.println("Semantic was: " + production_sequence);
            return 1;
        } else {
            return 0;
        }
    }

}