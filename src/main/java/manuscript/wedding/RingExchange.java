package manuscript.wedding;

import manuscript.Media;
import manuscript.Scene;
import manuscript.character.Groom;
import manuscript.character.Bride;

public class RingExchange implements Scene {
    
    private final Groom groom;
    private final Bride bride;
    
    public RingExchange(Groom groom, Bride bride) {
        this.groom = groom;
        this.bride = bride;
    }
    
    @Override
    public void execute() {
        System.out.println("\n💍 === DER RINGTAUSCH ===");
        RingBasket ringBasket = new RingBasket();
        groom.giveRing(ringBasket);
        bride.receiveRing(ringBasket);
        bride.giveRing(ringBasket);
        groom.receiveRing(ringBasket);
        System.out.println("💍 === RINGE WURDEN GETAUSCHT ===\n");
    }
    
    public static class RingBasket extends Media.Default {

		private String value;
		
		public Media get(String name, String value) {
			this.value = value;
			return this;
		}
		
		@Override
		public Media with(String name, String value) {
			this.value = value;
			return this;
		}

		@Override
		public Media with(String name, boolean value) {
			return this;
		}
		
    	@Override
    	public String toString() {
    		return value;
    	}
    }
}