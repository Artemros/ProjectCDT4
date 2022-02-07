import java.util.Random;

public class Generator {
    String generate() {
        Dictionary dictionary = new Dictionary();
        Random random = new Random();
        String generatedLine = "Sentence .";
        Boolean flag = true;
        while (flag) {
            generatedLine = generatedLine.replaceAll("Sentence ", "Statement ");
            generatedLine = generatedLine.replaceAll("Statement ", "T FPC - respectively");
            if (generatedLine.contains("T")) {
                if (random.nextInt(2) == 0) {
                    generatedLine = generatedLine.replaceAll("T ", "By H ");
                } else {
                    generatedLine = generatedLine.replaceAll("T ", "In G ");
                }
            }
            if (generatedLine.contains("H")) {
                int r = random.nextInt(4);
                switch (r) {
                    case (0):
                        generatedLine = generatedLine.replaceAll("H ", "6 pm ");
                    case (1):
                        generatedLine = generatedLine.replaceAll("H ", "monday ");
                    case (2):
                        generatedLine = generatedLine.replaceAll("H ", "17th of December ");
                    case (3):
                        generatedLine = generatedLine.replaceAll("H ", "next month ");
                }
            }
            if (generatedLine.contains("G")) {
                int r = random.nextInt(4);
                switch (r) {
                    case (0):
                        generatedLine = generatedLine.replaceAll("G ", "3 seconds ");
                    case (1):
                        generatedLine = generatedLine.replaceAll("G ", "20 minutes ");
                    case (2):
                        generatedLine = generatedLine.replaceAll("G ", "12 hours ");
                    case (3):
                        generatedLine = generatedLine.replaceAll("G ", "2 days ");
                }
            }
            if (generatedLine.contains("FPC")) {
                generatedLine = generatedLine.replaceAll("FPC ", "Pronoun will have been Verb M ");
            }
            if (generatedLine.contains("Pronoun")) {
                int r = random.nextInt(7);
                switch (r) {
                    case (0):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "I ");
                    case (1):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "he ");
                    case (2):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "she ");
                    case (3):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "it ");
                    case (4):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "we ");
                    case (5):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "you ");
                    case (6):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "they ");
                }
            }
            if (generatedLine.contains("Verb")) {
                int r = random.nextInt(5);
                switch (r) {
                    case (0):
                        generatedLine = generatedLine.replaceAll("Verb ", "reading ");
                    case (1):
                        generatedLine = generatedLine.replaceAll("Verb ", "crying of ");
                    case (2):
                        generatedLine = generatedLine.replaceAll("Verb ", "looking at ");
                    case (3):
                        generatedLine = generatedLine.replaceAll("Verb ", "making ");
                    case (4):
                        generatedLine = generatedLine.replaceAll("Verb ", "kicking ");
                }
            }
            generatedLine = generatedLine.replaceAll("M ", "Noun ME Y ");
            if (generatedLine.contains("ME")) {
                int r = random.nextInt(3);
                switch (r) {
                    case (0):
                        generatedLine = generatedLine.replaceAll("ME ", ", M ");
                    case (1):
                        generatedLine = generatedLine.replaceAll("ME ", "and M ");
                    case (2):
                        generatedLine = generatedLine.replaceAll("ME ", "");
                }
            }
            if (generatedLine.contains("Noun")) {
                int r = random.nextInt(5);
                switch (r) {
                    case (0):
                        generatedLine = generatedLine.replaceAll("Noun ", "book ");
                    case (1):
                        generatedLine = generatedLine.replaceAll("Noun ", "homework ");
                    case (2):
                        generatedLine = generatedLine.replaceAll("Noun ", "work ");
                    case (3):
                        generatedLine = generatedLine.replaceAll("Noun ", "program ");
                    case (4):
                        generatedLine = generatedLine.replaceAll("Noun ", "dreams ");
                }
            }
            if (generatedLine.contains("Noun,")) {
                int r = random.nextInt(5);
                switch (r) {
                    case (0):
                        generatedLine = generatedLine.replaceAll("Noun, ", "book, ");
                    case (1):
                        generatedLine = generatedLine.replaceAll("Noun, ", "homework, ");
                    case (2):
                        generatedLine = generatedLine.replaceAll("Noun, ", "work, ");
                    case (3):
                        generatedLine = generatedLine.replaceAll("Noun, ", "program, ");
                    case (4):
                        generatedLine = generatedLine.replaceAll("Noun, ", "dreams, ");
                }
            }
            generatedLine = generatedLine.replaceAll("Y ", "for U ");
            if (generatedLine.contains("U")) {
                generatedLine = generatedLine.replaceAll("U ", "4 Four ");
            }
            if (generatedLine.contains("Four")) {
                int r = random.nextInt(4);
                switch (r) {
                    case (0):
                        generatedLine = generatedLine.replaceAll("Four ", "minutes ");
                    case (1):
                        generatedLine = generatedLine.replaceAll("Four ", "hours ");
                    case (2):
                        generatedLine = generatedLine.replaceAll("Four ", "weeks ");
                    case (3):
                        generatedLine = generatedLine.replaceAll("Four ", "years ");
                }
            }
            String[] words = generatedLine.split("\\s");
            flag = false;
            for (String word : words) {
                if (dictionary.not_terminals.contains(word)) {
                    flag = true;
                    break;
                }
            }
        }
        return generatedLine;
    }
}