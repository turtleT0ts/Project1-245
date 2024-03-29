package sortingABC;

public class ABCPartition {

    /**
     * Suppose some city has n people, and these people need to vote to select a mayor of the city. There are three candidates for a mayor: "A",  "B" and "C".
     * We are given an array of n Strings where each element represents a vote for either candidate "A" or candidate "B", or candidate "C". For the purpose of this problem, let's assume there is a clear winner (so one candidate has more votes than the other two),
     * and each candidate has at least one vote for them.
     * Design and implement (in Java) an in-place algorithm for (1) sorting this array and (2) determining who wins the election, "A", "B" or "C".
     * The algorithm must satisfy the following requirements:
     * - Use the variation of the partition method of quicksort)
     * - Should run in linear time
     * - Use no extra memory (except for three integer indices and a tmp variable for swapping).
     * - Run in two passes
     * Important: Do NOT just iterate over the array and count the number of "A"s, "B"s and "C"s  - such solutions will get 0 points.
     * Do NOT use counting sort.
     * Example: if we are given the following array that represents votes of 11 people:
     * *             ["A", "B", "A", "C", "A", "A", "A", "B", "C", "A", "B"],
     * *     your method should return "A" and change the array so that it is sorted while satisfying other requirements listed above:
     * *             ["A", "A", "A", "A", "A", "A", "B", "B", "B",  "C", "C"]
     *
     * @param votes input array of votes
     * @return winner
     */


    public String sortAndFindWinner(String[] votes) {
        // FILL IN CODE
        // Hint: first partition the array into As and non-As
        int index = 0;

        String temp = null;
        //sorts the array into a's on the left side while pushing the rest to the right//
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] == "A") {
                //swaps A and whatever value is at votes[index]//
                temp = votes[i];
                votes[i] = votes[index];
                votes[index] = temp;
                index++;
            }
        }
        int first = index -1;
        // Then run another pass for the subarray of non-As, partitioning it into Bs and Cs.//
        //will not work if B is not in votes//
        // Once the array is sorted, figure out how to find the winner
        for (int j = 0; j < votes.length; j++) {
            if (votes[j] == "B") {
                //swaps B and whatever value is at votes[index]//
                temp = votes[j];
                votes[j] = votes[index];
                votes[index] = temp;
                index++;
            }
        }
            if (first < (index - first) && ( (index - first ) > (index - votes.length))) {
                return "B";
            } else if (first -1 > index - votes.length) {
                return "A";
            } else {
                return "C";
            }// changed to return the winner
        }
    }