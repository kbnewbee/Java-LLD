package main.java.inventory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory {
    private Map<Integer, Product> aisleToProductMap;
    private Map<Integer, Integer> productIdToCountMap;
    private Queue<Integer> aisleAvailable;

    public Inventory(int aisleCount) {
        // maintain fixed aisle counts or capacity of the vending machine
        aisleAvailable = new LinkedList<>();
        for (int aisleNo = 1; aisleNo <= aisleCount; aisleNo++) {
            aisleAvailable.add(aisleNo);
        }

        aisleToProductMap = new HashMap<>();
        productIdToCountMap = new HashMap<>();
    }

    /*
        This method adds a product to an aisle - job of the admin

        If there is no product existing
        - either there is no aisle available for the product
        - or the product count is simply 0

        Increase the count of the product after addition to the aisle
     */
    public void addProduct(Product product) {
        int productId = product.getId();
        int curProductCount = productIdToCountMap.getOrDefault(productId, 0);
        if (curProductCount == 0) {
            if (aisleAvailable.isEmpty())
                throw new IllegalStateException("There is no space available in the aisle to add a product");

            aisleToProductMap.put(aisleAvailable.poll(), product);
        }
        productIdToCountMap.put(productId, curProductCount + 1);
    }

    /*
        This method removes a product from the inventory - job of the admin
        - removes the product from the aisle-to-product map
        - adds the newly free aisle to the available aisle list
        - also removes the product from the product count map

     */
    public void removeProduct(int aisleNumber) {
        Product product = aisleToProductMap.get(aisleNumber);
        productIdToCountMap.remove(product.getId());
        aisleToProductMap.remove(aisleNumber);
        aisleAvailable.add(aisleNumber);
    }

    public Product getProduct(int aisleNumber) {
        Product product = aisleToProductMap.get(aisleNumber);
        return product;
    }

    public boolean checkProductAvailability(int productId) {
        int curProductCount = productIdToCountMap.get(productId);
        return curProductCount > 0;
    }


    public void decrementProductCount(int aisleNumber) {
        int productId = aisleToProductMap.get(aisleNumber).getId();
        int curProductCount = productIdToCountMap.get(productId);
        productIdToCountMap.put(productId, curProductCount - 1);
    }

}
