import java.util.*;

public class Recognizer {
    Map<String, Map<String, Integer>> lookup_table = Map.of(
            "Sentence",Map.of(
                    "I", 1,
                    "making", 1,
                    "program", 1),
            "Statement", Map.of(
                    "I", 3,
                    "making", 2,
                    "program", 2));
    Map<Integer, String> production_list = Map.of(
            1, "Statement",
            2, "FPC",
            3, "T FPC Y",
            4, "Pronoun will have been Verb M",
            5, "I",
            6, "He",
            7, "She",
            8, "It",
            9, "We",
            10, "You");

    Set<String> terminals = Set.of("I","He","She","It","We","You","They"
            ,"reading","crying of","looking at","making","kicking"
            ,"book","homework","work","program","dreams"
            ,"6 pm","Monday","17th of December","next month"
            ,"3 seconds","20 minutes","12 hours","2 days"
            ,"4 minutes","4 hours","4 weeks","4 years");
    Set<String> not_terminals = Set.of("Sentence","Statement","Epsilon","Dot","Hours","Minutes","Time","FPC","Noun","Pronoun","TM1","TM2","Verb","MPoS");
    //Set<String> dividers=Set.of(" ",".","?");

    int nextState(String symbolsLane) {
        int answer = 1;
        StringBuilder production_sequence=new StringBuilder();
        String[] words = symbolsLane.split("\\s");
        Stack<String> stack = new Stack<>();
        stack.push("Sentence");
        int current_in_text_number=0;
        while (current_in_text_number<words.length) {
            String current_in_text=words[current_in_text_number];
            if (!terminals.contains(current_in_text)) {
                return -1;
            }
            if (stack.isEmpty()) {
                answer = 0;
                break;
            }
            String current_in_stack = stack.pop();
            if (terminals.contains(current_in_stack)) {
                if (current_in_stack.equals(current_in_text)) {
                    current_in_text_number++;
                    continue;
                } else {
                    answer=0;
                    break;
                }
            }
            if (not_terminals.contains(current_in_stack)) {
                Integer production = lookup_table.get(current_in_stack).get(current_in_text);
                if (production == -1) {
                    answer=0;
                    break;
                }
                production_sequence.append(production);
                String line = production_list.get(production);
                stack.push(line);
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Semantic was: " + production_sequence);
            return 1;
        } else {
            return 0;
        }
    }

}