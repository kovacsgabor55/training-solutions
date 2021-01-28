package algorithmsmax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {
    @Test
    public void testCreateTrainer() {
        Trainer trainer = new Trainer("Chuck", 42);

        assertEquals(42, trainer.getAge());
    }

}