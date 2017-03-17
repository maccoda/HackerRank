import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Poles {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("src/main/weekOfCode30/poles_input.txt"));
            int n = in.nextInt();
            int k = in.nextInt();
            List<Pole> poles = new ArrayList<>();
            for (int a0 = 0; a0 < n; a0++) {
                int x_i = in.nextInt();
                int w_i = in.nextInt();
                poles.add(new Pole(w_i, x_i));
            }

            System.out.println(lowestCost(n, k, poles));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file");
        }
    }

    static class Pair<A, B> {
        A first;
        B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + "," + second + ")";
        }

    }

    static class Pole {
        int weight;
        int altitude;
        private Map<Integer, Integer> costs;
        Pair<Integer, Integer> maxCost;

        public Pole(int weight, int altitude) {
            this.weight = weight;
            this.altitude = altitude;
            costs = new HashMap<>();
            maxCost = new Pair<>(altitude, 0);
        }

        void putCost(int altitudeTo, int cost) {
            if (cost > maxCost.second) {
                maxCost.first = altitudeTo;
                maxCost.second = cost;
            }
            costs.put(altitudeTo, cost);
        }

        @Override
        public boolean equals(Object that) {
            if (that == this) {
                return true;
            }
            if (that == null) {
                return false;
            }
            if (getClass() != that.getClass()) {
                return false;
            }
            Pole pThat = (Pole) that;
            return pThat.altitude == this.altitude;
        }
    }

    public static int lowestCost(int numPoles, int numStacks, List<Pole> poles) {
        // Here need to calculate all possible variations
        // Rules:
        // (1) Poles can only be moved from higher altitude to lower altitude
        // (2) Stacks can only be formed at the initial pole altitudes
        // (3) A stack can consist of at least one pole

        // Construct all possible moves for each pole
        // TODO Need to sort the list first
        // poles.sort();
        for (int i = 0; i < poles.size(); i++) {
            if (i == poles.size() - 1) {
                continue;
            }
            Pole current = poles.get(i);
            for (int j = i + 1; j < poles.size(); j++) {
                if (i == 0 && j == poles.size() - 1) {
                    continue;
                }
                Pole comp = poles.get(j);
                int cost = calculateCost(current, comp.altitude);
                System.out.println(current.altitude + " -> " + comp.altitude + " = " + cost);
                current.putCost(comp.altitude, cost);
            }
            System.out.println(current.costs);
        }

        // Find the hardest pole to move
        // HACK Remove this, just here for prints
        System.out.println("Max costs");
        for (Pole pole : poles) {
            System.out.println(pole.maxCost);
        }
        // TODO Make this work for more than 1
        Pair<Pole, Integer> maxPoleCosts = poles.stream().map(x -> new Pair<Pole, Integer>(x, x.maxCost.second))
                .reduce((a, b) -> a.second > b.second ? a : b).get();
        System.out.println("Stack at " + maxPoleCosts.first.altitude);
        // Want the stacks in the same order as the poles
        // HACK just put the one hardest to move pole and the last pole
        List<Pole> stacks = Arrays.asList(maxPoleCosts.first, poles.get(poles.size() - 1));

        // For each of the stacks calculate the costs of moving the ones above it
        int totalCost = 0;
        int stackIndex = 0;
        for (Pole pole : poles) {
            Pole currentStack = stacks.get(stackIndex);
            if (currentStack.equals(pole)) {
                stackIndex++;
                continue;
            }
            totalCost += pole.costs.get(currentStack.altitude);
        }

        return totalCost;
    }

    static int calculateCost(Pole pole, int nextAltitude) {
        return pole.weight * (pole.altitude - nextAltitude);
    }
}