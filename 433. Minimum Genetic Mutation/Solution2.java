import java.util.*;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank)); // Add all genes in the bank to a set for O(1) lookup
        if (!bankSet.contains(endGene))
            return -1; // If endGene is not in the bank, it's impossible to reach it

        char[] genes = { 'A', 'C', 'G', 'T' }; // Possible characters for mutation
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene))
                    return mutations;

                char[] geneArray = currentGene.toCharArray();

                // Try all possible mutations
                for (int j = 0; j < geneArray.length; j++) {
                    char originalChar = geneArray[j];
                    for (char g : genes) {
                        if (geneArray[j] == g)
                            continue; // Skip if it's the same character
                        geneArray[j] = g;
                        String newGene = new String(geneArray);

                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                            queue.offer(newGene);
                            visited.add(newGene);
                        }
                    }
                    geneArray[j] = originalChar; // Revert change
                }
            }
            mutations++; // Increment mutations (or levels in BFS)
        }

        return -1; // No valid path to endGene
    }
}
