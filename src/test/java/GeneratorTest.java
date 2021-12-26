import org.junit.Assert;
import org.junit.Test;

public class GeneratorTest {
    @Test
    public void GenTest() {
        int start=5;
        int finish=6;
        int iterations=1000;
        for(int j=0;j<iterations;j++) {
            for (int i = start; i < finish; i++) {
                Generator generator = new Generator();
                String sequence = generator.generate();
                Recognizer recognizer = new Recognizer();
                System.out.println(sequence);
                int got_state = recognizer.nextState(sequence);
                Assert.assertEquals("SMTH WENT WRONG: " + sequence + " got state: " + got_state, 1, got_state);
            }
        }
    }
    @Test
    public void UncontrolledGenTest() {
        int iterations=100;
        for(int j=0;j<iterations;j++) {
            for (int i = 2; i < 100; i++) {
                Generator generator = new Generator();
                String sequence = generator.generate();
                Assert.assertEquals("Created sequence has wrong length, got sequence: " + sequence, sequence.length(), i);
            }
        }
    }
}
