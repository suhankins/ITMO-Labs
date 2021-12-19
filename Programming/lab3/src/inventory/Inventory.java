package planeflight.inventory;

import planeflight.entities.*;

public interface Inventory {
    /*
    * Clears every time in the inventory
    */
    public void clearInventory();
    /*
    * Adds a specified entity to the inventory
    */
    public void addToInventory(Entity item);
    /*
    * Returns entity stored at a specified position in the inventory
    * @param itemPosition position of the required entity in the inventory
    * @return entity that is stored at the requested position
    * If provided position is higher, than the length of the inventory, last filled inventory slot will be returned
    */
    public Entity getFromInventory(int itemPosition);
    /*
    * Removes entity stored at a specified position in the inventory
    * @param itemPosition position of the required entity in the inventory.
    * If provided position is higher, than the length of the inventory, last filled inventory slot will be removed
    */
    public void removeFromInventory(int itemPosition);
    /*
    * Returns the whole inventory as an array
    * @return the whole inventory as an array
    */
    public Entity[] getInventory();
}