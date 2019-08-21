import java.util.List;

public class FindDuplicateInArray {
    /*
    Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time
    using less than O(n) space and traversing the stream sequentially O(1) times.

    Sample Input:
    [3 4 1 4 1]

    Sample Output:
    1
    If there are multiple possible answers ( like in the sample case above ), output any one.
    If there is no duplicate, output -1
     */

    public int repeatedNumberByCycle(final List<Integer> a) {
        int slow = 0, fast = 0;
        do {
            slow = a.get(slow);
            fast = a.get(a.get(fast));
        } while (slow != fast);
        // They meet somewhere in the loop
        slow = 0;
        while (slow != fast) {
            slow = a.get(slow);
            fast = a.get(fast);
        }
        return slow;
    }

    public int repeatedNumber(final List<Integer> a) {
        boolean[] hash = new boolean[a.size()];

        for (Integer num : a) {
            if (hash[num]) {
                return num;
            }
            hash[num] = true;
        }
        return -1;
    }
}

/* explanation of repeatedNumberByCycle
First figure out why there will be a cycle when traversing the way we are.
Also, why will the duplicate element be at the start of the cycle?
slow moves 1 step at a time, while fast moves two steps at a time.
Variables:
x is the distance from the start of list to the start of cycle.
y is the distance from the start of cycle to where the slow and fast meet.
z is the disctance from the meeting point to the start of the cycle.
distance travelled by fast = x + n(y + z) + y  (n is an integer >= 1)
Also, distance travelled by fast = 2 * distance travelled by slow.
Distance travelled by slow = x + y
2(x + y) = x + n(y + z) + y
x + y = n(y + z)
x = (n - 1)(y + z) + z
Now when we reset slow to 0 and make it travel x distance, fast will travel
(n - 1) times around the circle + the distance z. Since fast was already at distance y
when we started moving them again it will now reach the start of the cycle.
*/
