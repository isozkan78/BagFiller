
// Fill the bag with the minimum number of objects possible.


public class SmallestNumberOfItems {
    private int filled = 0; // Total number of object gathered
    private int filledInKg = 0; // Current weight in the bag


    public void sortArrayDescending(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        // Bubble Sort used
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


    public String fillBag(int capacity, int[] weights) {
        sortArrayDescending(weights); // Sorting

        while (filledInKg < capacity) {
            int remainingCapacity = capacity - filledInKg;

            // Appropriate object select and fill by checking the remaining capacity
            boolean itemAdded = false;
            for (int weight : weights) {
                if (weight <= remainingCapacity) {
                    filled++;
                    filledInKg += weight;
                    itemAdded = true;
                    break;
                }
            }

            // If no item added but we have space in the bag
            if (!itemAdded) {
                System.out.println("Bag has space, but no item fits");
                return "Items gathered: " + filled;
            }
        }
        return "Items gathered: " + filled;   // If no item added and no space left
    }

    public static void main(String[] args) {
        int[] weights = {14, 13, 35};
        int bagCapacity = 120;

        SmallestNumberOfItems bagFiller = new SmallestNumberOfItems();
        System.out.println(bagFiller.fillBag(bagCapacity, weights));
    }
}
