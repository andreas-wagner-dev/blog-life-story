package manuscript;

/**
 * Abstract outfit to decorate an actor.
 */
public abstract class Outfit implements Actor {
    
    protected final Actor decoratedActor;
    
    protected Outfit(Actor actor) {
        this.decoratedActor = actor;
    }
    
    @Override
    public Name name() {
        return decoratedActor.name();
    }
    
    @Override
    public void perform() {
        decoratedActor.perform();
    }
}