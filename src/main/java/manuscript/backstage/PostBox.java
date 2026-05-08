package manuscript.backstage;

/**
 * Access to mail system.
 * 
 * @param <T> type of transfer data object
 */
public interface PostBox<T> {
	void put(T content);
}
