public class SmallestNumberOfItems {


    private int fillBagRecursively(int capacity, int[] weights, int filled) {
        // Base case: If capacity is zero or less, return the number of items used
        if (capacity <= 0) {
            return filled;
        }

        // Try to fit the heaviest possible item
        for (int weight : weights) {
            if (weight <= capacity) {
                return fillBagRecursively(capacity - weight, weights, filled + 1);
            }
        }

        // If no item fits, the bag cannot be filled further
        System.out.println("Bag has space, but no item fits");
        return filled;
    }


    public String fillBag(int capacity, int[] weights) {
        sortArrayDescending(weights); // Sort the weights in descending order
        int result = fillBagRecursively(capacity, weights, 0);
        return "Items gathered: " + result;
    }


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

    public static void main(String[] args) {
        int[] weights = {1, 3, 5};
        int bagCapacity = 24;

        SmallestNumberOfItems bagFiller = new SmallestNumberOfItems();
        System.out.println(bagFiller.fillBag(bagCapacity, weights));
    }
}
