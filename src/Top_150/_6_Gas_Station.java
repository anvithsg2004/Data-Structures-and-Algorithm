package Top_150;

//🚗💨 The Problem in Simple Terms:
//Imagine you're driving a car around a circular route with gas stations.
//At each station i:
//You can fill gas[i] liters of fuel.
//To go from station i to the next one, it costs cost[i] liters.
//You start at some station with empty tank, and you want to go all the way around the circle once.

//📦 You are Given:
//Two arrays:
//gas[i] → how much gas you can fill at station i.
//cost[i] → how much gas you need to drive to the next station.

//You want to start somewhere and go in this order: 0 → 1 → 2 → 3 → 4 → back to 0.
//Let’s try starting at station 0:
//Fill 1 gas, need 3 to go to next → NOT enough → FAIL.
//Try station 1:
//Fill 2, need 4 → FAIL.
//Try station 3:
//Fill 4, need 1 → OK.
//At next station fill 5, need 2 → OK.
//Keep going…
//🎯 This works! So, answer = 3.

public class _6_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int start = 0, tank = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];

            tank = tank + gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;  // Try next station
                tank = 0;       // Reset tank
            }
        }

        return (totalGas < totalCost) ? -1 : start;
    }
}
