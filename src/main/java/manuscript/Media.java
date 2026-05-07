package manuscript;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Media {

    Media with(String name, String value);
    Media with(String name, BigDecimal value);
    Media with(String name, LocalDate value);
    Media with(String name, boolean value);

 // optional extension
 // Media with(String name, String [] strings);  // ← list
 // Media with(String name, Media media);       // ← nested
 // Media with(String name, Media[] medias);   // ← nested list
}