package planeflight.entities;

import planeflight.inventory.*;

/**
* Everything that has an inventory
*/
public abstract class EntityWithInventory extends Entity implements Inventory {
    private Entity[] inventory;

    public EntityWithInventory(int inventorySize) {
        inventory = new Entity[inventorySize];
    }

    public void clearInventory() {
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = null;
        }
    }

    public void addToInventory(Entity item) throws inventoryInvalidItemException {
        if (item.getName().equals("News") | item.getName().equals("Plane")) {
            throw new inventoryInvalidItemException("Entity types 'News' and 'Plane' cannot be stored in an inventory!");
        }
        for (int i = 0; i < inventory.length; i++) {
            //The position is empty, we can put our new item there
            if (inventory[i] == null) {
                inventory[i] = item;
                return;
            }
        }
        throw new inventoryFullException("Inventory is full, can't add more items!");
    }

    public Entity getFromInventory(int itemPosition) {
        if (itemPosition >= inventory.length) {
            for (int i = inventory.length - 1; i >= 0; i--) {
                if (inventory[i] != null) {
                    return inventory[i];
                }
            }
            return null;
        } else {
            return inventory[itemPosition];
        }
    }

    public void removeFromInventory(int itemPosition) {
        int removedItemLocation = itemPosition;
        if (itemPosition >= inventory.length) {
            for (int i = inventory.length - 1; i >= 0; i--) {
                if (inventory[i] != null) {
                    removedItemLocation = i;
                    break;
                }
            }
            //Nothing to remove
            return;
        }
        inventory[removedItemLocation] = null;

        //Moving everything higher than the removed item position lower.
        //i.e.
        // Before                         | After
        //                                |
        // Item0 <--- this one is removed | Item1
        // Item1                          | Item2
        // Item2                          | null

        for (int i = removedItemLocation + 1; i < inventory.length; i++) {
            inventory[i - 1] = inventory[i];
            inventory[i] = null;
        }
    }

    public Entity[] getInventory() {
        return inventory;
    }

    public int hasItem(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                if (inventory[i].getName().equals(name)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return getName() + ", carries: " + inventory.toString();
    }

    @Override
    public int hashCode() {
        return 1 + getName().hashCode() + inventory.hashCode();
     }
}