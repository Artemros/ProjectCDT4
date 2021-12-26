import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RecognizerTest {
    @Test
    public void RecognizedSentences() {
        ArrayList<String> sequences = new ArrayList<>();
        sequences.add("I will have been crying of book");
        sequences.add("By monday I will have been kicking homework for 4 weeks");
        sequences.add("In 3 seconds I will have been kicking homework for 4 weeks");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence);
            Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, 1, got_state);
        }
    }

    @Test
    public void NotRecognizedSentencesCards() {
        ArrayList<String> sequences = new ArrayList<>();
        sequences.add("will I have been crying of book");
        sequences.add("By monday I will have been kicking homework for 4 I");
        sequences.add("I will have have been crying of book");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence);
            Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, 0, got_state);
        }
    }

    @Test
    public void NotRecognizedSentencesOutOfBounds() {
        ArrayList<String> sequences = new ArrayList<>();
        sequences.add("I will did have been crying of book");
        for (String sequence : sequences) {
            Recognizer recognizer = new Recognizer();
            int got_state = recognizer.nextState(sequence);
            Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, -1, got_state);
        }
    }


}
