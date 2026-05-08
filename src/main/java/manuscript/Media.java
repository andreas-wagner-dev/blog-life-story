package manuscript;

import java.util.HashMap;
import java.util.Map;

/**
 * Any medium to represent as media.
 */
public interface Media {

	Media with(String name, String value);

	Media with(String name, boolean value);

	public String content(String name);
	// optional extension
	// Media with(String name, BigDecimal value);
	// Media with(String name, LocalDate value);
	// Media with(String name, boolean value);

	// Media with(String name, String [] strings); // ← list
	// Media with(String name, Media media); // ← nested
	// Media with(String name, Media[] medias); // ← nested list
	
	public abstract class Default implements Media {
		
		protected final Map<String, Object> content = new HashMap<>(0);

		@Override
		public Media with(String name, String value) {
			content.put(name, value);
			return this;
		}
		
		@Override
		public Media with(String name, boolean value) {
			content.put(name, value);
			return this;
		}
		
		public String content(String name) {
			return content.getOrDefault(name, "").toString();
		}
		
		@Override
		public String toString() {
			return content.toString();
		}
	}
	
	//
	public final class Air extends Media.Default {

	}
}