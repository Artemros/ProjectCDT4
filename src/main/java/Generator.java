import java.util.Random;

public class Generator {
    String generate() {
        Dictionary dictionary = new Dictionary();
        Random random = new Random();
        String generatedLine = "Sentence ";
        Boolean flag = true;
        while (flag) {
            generatedLine = generatedLine.replaceAll("Sentence ", "Statement ");
            if (generatedLine.contains("Statement")) {
                if (random.nextInt(2) == 0) {
                    generatedLine = generatedLine.replaceAll("Statement ", "FPC ");
                } else {
                    generatedLine = generatedLine.replaceAll("Statement ", "T FPC Y ");
                }
            }
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
                        generatedLine = generatedLine.replaceAll("Pronoun ", "He ");
                    case (2):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "She ");
                    case (3):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "It ");
                    case (4):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "We ");
                    case (5):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "You ");
                    case (6):
                        generatedLine = generatedLine.replaceAll("Pronoun ", "They ");
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
            if (generatedLine.contains("M")) {
                int r = random.nextInt(3);
                switch (r) {
                    case (0):
                        generatedLine = generatedLine.replaceAll("M ", "Noun ");
                    case (1):
                        generatedLine = generatedLine.replaceAll("M ", "Noun, M ");
                    case (2):
                        generatedLine = generatedLine.replaceAll("M ", "Noun and M ");
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
            if (generatedLine.contains("Y")) {
                generatedLine = generatedLine.replaceAll("Y ", "for U ");
            }
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