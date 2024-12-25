public class SmallestNumberOfItems {


    public void sortArrayDescending(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    public String fillBagIteratively(int capacity, int[] weights) {
        sortArrayDescending(weights); // Sort the weights in descending order

        int filled = 0;
        int filledInKg = 0;

        while (filledInKg < capacity) {
            int remainingCapacity = capacity - filledInKg; // Calculate remaining capacity
            boolean itemAdded = false;

            for (int weight : weights) {
                if (weight <= remainingCapacity) {
                    filled++;
                    filledInKg += weight;
                    itemAdded = true;
                    break;
                }
            }

            if (!itemAdded) {
                System.out.println("Bag has space, but no item fits");
                return "Items gathered: " + filled;
            }
        }

        return "Items gathered: " + filled;
    }


    private int fillBagRecursively(int capacity, int[] weights, int filled) {
        if (capacity <= 0) {
            return filled;
        }

        for (int weight : weights) {
            if (weight <= capacity) {
                return fillBagRecursively(capacity - weight, weights, filled + 1);
            }
        }

        System.out.println("Bag has space, but no item fits");
        return filled;
    }


    public String fillBagUsingRecursion(int capacity, int[] weights) {
        sortArrayDescending(weights); // Sort the weights in descending order
        int result = fillBagRecursively(capacity, weights, 0);
        return "Items gathered: " + result;
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 5};
        int bagCapacity = 24;

        SmallestNumberOfItems bagFiller = new SmallestNumberOfItems();

        // Iterative approach
        System.out.println("Using Iterative Approach:");
        System.out.println(bagFiller.fillBagIteratively(bagCapacity, weights));

        // Recursive approach
        System.out.println("\nUsing Recursive Approach:");
        System.out.println(bagFiller.fillBagUsingRecursion(bagCapacity, weights));
    }
}
