package algorithmsmax;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer trainerWithMaxAge(List<Trainer> trainers) {
        Trainer maxAgeTrainer = trainers.get(0);
        for (Trainer trainer : trainers) {
            if (trainer.getAge() > maxAgeTrainer.getAge()) {
                maxAgeTrainer = trainer;
            }
        }
        return maxAgeTrainer;
    }
}
