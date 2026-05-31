


public class astroid_prob {

        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            // Sort the array so we always tackle the smallest asteroids first
            Arrays.sort(asteroids);

            // Use a long to prevent integer overflow as the planet's mass grows
            long currentMass = mass;

            // Correct enhanced for-loop syntax
            for (int asteroid : asteroids) {
                if (currentMass >= asteroid) {
                    currentMass += asteroid;
                } else {
                    // If the planet cannot destroy this asteroid, it's game over
                    return false;
                }
            }

            // If we make it through the loop, all asteroids were destroyed
            return true;
        }

}
