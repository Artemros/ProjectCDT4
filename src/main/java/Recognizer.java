import java.util.Map;
import java.util.Stack;

public class Recognizer {
    Dictionary dictionary = new Dictionary();

    int nextState(String symbolsLane) {
        int answer = 1;
        StringBuilder production_sequence = new StringBuilder();
        String[] words = symbolsLane.split("\\s");
        for (String word : words) {
            if (!dictionary.isTerminal(word)) {
                return -1;
            }
        }
        Stack<String> stack = new Stack<>();
        stack.push("Sentence");
        int current_in_text_number = 0;
        while (current_in_text_number < words.length) {
            String current_in_text = words[current_in_text_number];
            if (!dictionary.isTerminal(current_in_text)) {
                return -1;
            }
            if (stack.isEmpty()) {
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
                if(dictionary.isNoun(current_in_text) && current_in_text_number+1<words.length){
                    if(words[current_in_text_number+1].equals("and")){
                        switch (current_in_text){
                            case("book"):{
                                production=47;
                                break;
                            }
                            case("homework"):{
                                production=48;
                                break;
                            }
                            case("work"):{
                                production=49;
                                break;
                            }
                            case("program"):{
                                production=50;
                                break;
                            }
                            case("dreams"):{
                                production=51;
                                break;
                            }
                        }
                    }
                }
                if (production == -1) {
                    return 0;
                }
                production_sequence.append(production).append(" ");
                String line = dictionary.getProductionByNumber(production);
                String[] for_push = line.split("\\s");
                for(int q=for_push.length-1;q>=0;q--){
                    stack.push(for_push[q]);
                }
            }
        }
        if (stack.isEmpty()) {
            //System.out.println("Semantic was: " + production_sequence);
            return 1;
        } else {
            return 0;
        }
    }

}