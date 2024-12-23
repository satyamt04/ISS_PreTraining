import java.util.logging.Logger;

public class LoopControl {
    private static final Logger logger = Logger.getLogger(LoopControl.class.getName());

    public static void main(String[] args) {
        int[] scores = {85, 92, 76, 58, 95, 63}; // Array of scores

        logger.info("Processing grades:");

        // for loop to iterate over scores
        for (int score : scores) {
            // Decision making using if-else
            if (score >= 90) {
                logger.info(score + ": Grade A");
            } else if (score >= 80) {
                logger.info(score + ": Grade B");
            } else if (score >= 70) {
                logger.info(score + ": Grade C");
            } else if (score >= 60) {
                logger.info(score + ": Grade D");
            } else {
                logger.info(score + ": Grade F");
            }
        }

        logger.info("\nSpecial Conditions Check:");

        // while loop to find the first failing score
        int index = 0;
        while (index < scores.length) {
            if (scores[index] < 60) {
                logger.info("First failing score: " + scores[index]);
                break; // exit the loop early
            }
            index++;
        }

        // do-while to display scores below a threshold
        int threshold = 75;
        index = 0;
        logger.info("\nScores below threshold:");
        do {
            if (scores[index] < threshold) {
                logger.info("Score: " + scores[index]);
            }
            index++;
        } while (index < scores.length);

        // Switch for performance review
        logger.info("\nPerformance Review:");
        int topScore = 95;
        switch (topScore / 10) {
            case 10:
            case 9:
                logger.info("Excellent performance!");
                break;
            case 8:
                logger.info("Great job!");
                break;
            case 7:
                logger.info("Good effort!");
                break;
            default:
                logger.info("Needs improvement.");
        }

        // Ternary operator for quick decision
        String summary = (scores.length > 5) ? "Large class size" : "Small class size";
        logger.info("\nClass Summary: " + summary);
    }
}
