package manuscript.backstage;

import manuscript.backstage.archive.RecordMedia;

/**
 * Storage data access. 
 */
public interface Archive {

	void store(RecordMedia record);

}
