import java.util.Set;

public class Dictionary {
    Set<String> terminals = Set.of("will", "have", "been"
            , "I", "he", "she", "it", "we", "you", "they"
            , "reading", "crying", "of", "looking", "at", "making", "kicking"
            , "book", "homework", "work", "program", "dreams"
            , "book,", "homework,", "work,", "program,", "dreams,", "and"
            , "6", "pm", "By", "monday", "17th", "December", "next", "month"
            , "In", "3", "seconds", "20", "12", "2", "days"
            , "for", "4", "minutes", "hours", "weeks", "years", "", ".", "respectively.", "-", ",");
    Set<String> not_terminals = Set.of("Sentence", "Statement", "FPC", "Pronoun", "Verb", "Noun", "Noun,", "T", "H", "G", "Y", "U", "M", "Four", "ME");

    Integer GetLookUpTableNumber(String current_in_stack, String current_in_text) {
        switch (current_in_stack) {
            case ("Sentence"): {
                switch (current_in_text) {
                    case ("By"):
                    case ("In"):
                        return 1;
                    default:
                        return -1;
                }
            }
            case ("Statement"): {
                switch (current_in_text) {
                    case ("By"):
                    case ("In"):
                        return 3;
                    default:
                        return -1;
                }
            }
            case ("FPC"): {
                switch (current_in_text) {
                    case ("I"):
                    case ("he"):
                    case ("she"):
                    case ("it"):
                    case ("we"):
                    case ("you"):
                    case ("they"):
                        return 4;
                    default:
                        return -1;
                }
            }
            case ("Pronoun"): {
                switch (current_in_text) {
                    case ("I"):
                        return 5;
                    case ("he"):
                        return 6;
                    case ("she"):
                        return 7;
                    case ("it"):
                        return 8;
                    case ("we"):
                        return 9;
                    case ("you"):
                        return 10;
                    case ("they"):
                        return 11;
                    default:
                        return -1;
                }
            }
            case ("Verb"): {
                switch (current_in_text) {
                    case ("reading"):
                        return 12;
                    case ("crying"):
                        return 13;
                    case ("looking"):
                        return 14;
                    case ("making"):
                        return 15;
                    case ("kicking"):
                        return 16;
                    default:
                        return -1;
                }
            }
            case ("Noun"): {
                switch (current_in_text) {
                    case ("book"):
                        return 17;
                    case ("homework"):
                        return 18;
                    case ("work"):
                        return 19;
                    case ("program"):
                        return 20;
                    case ("dreams"):
                        return 21;
                    default:
                        return -1;
                }
            }
            case ("Noun,"): {
                switch (current_in_text) {
                    case ("book,"):
                        return 42;
                    case ("homework,"):
                        return 43;
                    case ("work,"):
                        return 44;
                    case ("program,"):
                        return 45;
                    case ("dreams,"):
                        return 46;
                    default:
                        return -1;
                }
            }
            case ("T"): {
                switch (current_in_text) {
                    case ("By"):
                        return 22;
                    case ("In"):
                        return 23;
                    default:
                        return -1;
                }
            }
            case ("H"): {
                switch (current_in_text) {
                    case ("6"):
                        return 24;
                    case ("monday"):
                        return 25;
                    case ("17th"):
                        return 26;
                    case ("next"):
                        return 27;
                    default:
                        return -1;
                }
            }
            case ("G"): {
                switch (current_in_text) {
                    case ("3"):
                        return 28;
                    case ("20"):
                        return 29;
                    case ("12"):
                        return 30;
                    case ("2"):
                        return 31;
                    default:
                        return -1;
                }
            }
            case ("Y"): {
                switch (current_in_text) {
                    case ("for"):
                        return 32;
                    default:
                        return -1;
                }
            }
            case ("U"): {
                if ("4".equals(current_in_text)) {
                    return 40;
                }
                return -1;
            }
            case ("M"): {
                switch (current_in_text) {
                    case ("book"):
                    case ("homework"):
                    case ("work"):
                    case ("program"):
                    case ("dreams"):
                        return 37;
                    default:
                        return -1;
                }
            }
            case ("ME"): {
                switch (current_in_text) {
                    case (","):
                        return 55;
                    case("and"):
                        return 56;
                    case("for"):
                        return 57;
                    default:
                        return -1;
                }
            }
            case ("Four"): {
                switch (current_in_text) {
                    case ("minutes"):
                        return 33;
                    case ("hours"):
                        return 34;
                    case ("weeks"):
                        return 35;
                    case ("years"):
                        return 36;
                    default:
                        return -1;
                }
            }
        }
        return 0;
    }

    String getProductionByNumber(Integer key) {
        switch (key) {
            case (1):
                return "Statement ";
            case (3):
                return "T FPC - respectively";
            case (4):
                return "Pronoun will have been Verb M";
            case (5):
                return "I";
            case (6):
                return "he";
            case (7):
                return "she";
            case (8):
                return "it";
            case (9):
                return "we";
            case (10):
                return "you";
            case (11):
                return "they";
            case (12):
                return "reading";
            case (13):
                return "crying of";
            case (14):
                return "looking at";
            case (15):
                return "making";
            case (16):
                return "kicking";
            case (17):
                return "book";
            case (18):
                return "homework";
            case (19):
                return "work";
            case (20):
                return "program";
            case (21):
                return "dreams";
            case (22):
                return "By H";
            case (23):
                return "In G";
            case (24):
                return "6 pm";
            case (25):
                return "monday";
            case (26):
                return "17th of December";
            case (27):
                return "next month";
            case (28):
                return "3 seconds";
            case (29):
                return "20 minutes";
            case (30):
                return "12 hours";
            case (31):
                return "2 days";
            case (32):
                return "for U";
            case (33):
                return "minutes";
            case (34):
                return "hours";
            case (35):
                return "weeks";
            case (36):
                return "years";
            case (37):
                return "Noun ME Y";
            case (38):
                return "Noun, M";
            case (39):
                return "Noun and M";
            case (40):
                return "4 Four";
            case (42):
                return "book,";
            case (43):
                return "homework,";
            case (44):
                return "work,";
            case (45):
                return "program,";
            case (46):
                return "dreams,";
            case (47):
                return "book and M";
            case (48):
                return "homework and M";
            case (49):
                return "work and M";
            case (50):
                return "program and M";
            case (51):
                return "dreams and M";
            case (52):
                return ".";
            case (53):
                return "also Statement";
            case(54):
                return "over U";
            case(55):
                return ", M";
            case(56):
                return "and M";
            case(57):
                return "";
            case (-1):
                return "DANGER";
        }
        return "";
    }

    Integer getNumberByProduction(String key) {
        switch (key) {
            case ("Statement ."):
                return 1;
            case ("T FPC - respectively"):
                return 3;
            case ("Pronoun will have been Verb M"):
                return 4;
            case ("I"):
                return 5;
            case ("he"):
                return 6;
            case ("she"):
                return 7;
            case ("it"):
                return 8;
            case ("we"):
                return 9;
            case ("you"):
                return 10;
            case ("they"):
                return 11;
            case ("reading"):
                return 12;
            case ("crying of"):
                return 13;
            case ("looking at"):
                return 14;
            case ("making"):
                return 15;
            case ("kicking"):
                return 16;
            case ("book"):
                return 17;
            case ("homework"):
                return 18;
            case ("work"):
                return 19;
            case ("program"):
                return 20;
            case ("dreams"):
                return 21;
            case ("By H"):
                return 22;
            case ("In G"):
                return 23;
            case ("6 pm"):
                return 24;
            case ("monday"):
                return 25;
            case ("17th of December"):
                return 26;
            case ("next month"):
                return 27;
            case ("3 seconds"):
                return 28;
            case ("20 minutes"):
                return 29;
            case ("12 hours"):
                return 30;
            case ("2 days"):
                return 31;
            case ("for U"):
                return 32;
            case ("minutes"):
                return 33;
            case ("hours"):
                return 34;
            case ("weeks"):
                return 35;
            case ("years"):
                return 36;
            case ("Noun"):
                return 37;
            case ("Noun, M"):
                return 38;
            case ("Noun and M"):
                return 39;
            case ("4 Four"):
                return 40;
            case ("book,"):
                return 42;
            case ("homework,"):
                return 43;
            case ("work,"):
                return 44;
            case ("program,"):
                return 45;
            case ("dreams,"):
                return 46;
            case ("book and M"):
                return 47;
            case ("homework and M"):
                return 48;
            case ("work and M"):
                return 49;
            case ("program and M"):
                return 50;
            case ("dreams and M"):
                return 51;
            case ("."):
                return 52;
            case ("also Statement"):
                return 53;
            case("over U"):
                return 54;
            case(", M"):
                return 55;
            case("and M"):
                return 56;
        }
        return -1;
    }

    Boolean isNoun(String n) {
        return n.equals("book") || n.equals("homework") || n.equals("work") || n.equals("program") || n.equals("dreams");
    }
//    String decompose(String not_term) {
//        String dec = "";
//        if (not_term.equals("Sentence")) {
//            dec = "Statement";
//        }
//        if (not_term.equals("Statement")) {
//            dec = "FPC";
//        }
//        if (not_term.equals("FPC")) {
//            dec = "Pronoun will have been Verb M";
//        }
//        if (not_term.equals("Pronoun")) {
//            dec = "I";
//        }
//        if (not_term.equals("Verb")) {
//            dec = "reading";
//        }
//        if (not_term.equals("M")) {
//            dec = "Noun";
//        }
//        if (not_term.equals("Noun")) {
//            dec = "book";
//        }
//        return dec;
//    }
//
//    Integer getProduction(String production) {
//
//        return 0;
//    }

    Boolean isTerminal(String current_in_text) {
        return terminals.contains(current_in_text);
    }

    Boolean isNotTerminal(String current_in_text) {
        return not_terminals.contains(current_in_text);
    }
}
