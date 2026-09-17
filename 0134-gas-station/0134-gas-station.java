class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            totalGas += gas[i];     //tg+0
            totalCost += cost[i];    //tg+0

            tank += gas[i] - cost[i]; //0+1-3=-2

            // Current starting point cannot work
            if (tank < 0) {
                start = i + 1;  
                tank = 0;
            }
        }

        // Check whether completing the circuit is possible
        if (totalGas < totalCost) {
            return -1;
        }

        return start;
    }
}