package hell.rides;

import hell.states.*;

public interface Interactable {
    public boolean canBeInteractedWith();
    public Result interactionResult();
}