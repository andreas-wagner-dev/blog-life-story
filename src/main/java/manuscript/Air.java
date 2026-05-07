package manuscript;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Air implements Media {
	
	  private final Map<String, Object> data = new HashMap<>(0);

	    @Override
	    public Media with(String name, String value) {
	        data.put(name, value);
	        return this;
	    }

	    // ... weitere with Methoden für BigDecimal, LocalDate etc.

	    public String getContent() {
	        return data.toString();
	    }

		@Override
		public Media with(String name, BigDecimal value) {
	        data.put(name, value);
	        return this;
		}

		@Override
		public Media with(String name, LocalDate value) {
	        data.put(name, value);
	        return this;
		}

		@Override
		public Media with(String name, boolean value) {
	        data.put(name, value);
	        return this;
		}

}
