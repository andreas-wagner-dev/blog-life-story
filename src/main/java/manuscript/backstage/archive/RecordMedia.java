package manuscript.backstage.archive;

import manuscript.Media;

/**
 * A medium for the archive to receive the actor's data.
 */
public class RecordMedia extends Media.Default {
    
    public String toDML() {
    	 // Simulate build DML statement
        return content.toString();
    }
}