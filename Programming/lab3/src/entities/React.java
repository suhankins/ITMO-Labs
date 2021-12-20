package planeflight.entities;

import planeflight.environment.*;

public interface React {
    /**
     * Used by plane to make entities inside react to the environment
     * @param location Location entity is reacting to
     */
    public void react(Location location);
}