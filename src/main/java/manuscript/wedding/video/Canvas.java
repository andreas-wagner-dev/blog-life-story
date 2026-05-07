package manuscript.wedding.video;

import java.math.BigDecimal;
import java.time.LocalDate;

import manuscript.Media;

/** Lädt das Video in den Arbeitsspeicher. */
public class Canvas implements Media {

	@Override
	public Media with(String name, String value) {
		System.out.println("Leinwand bereit...");
		return this;
	}

	@Override
	public Media with(String name, BigDecimal value) {
		return this;
	}

	@Override
	public Media with(String name, LocalDate value) {
		return this;
	}

	@Override
	public Media with(String name, boolean value) {
		return this;
	}

}