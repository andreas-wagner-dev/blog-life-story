package manuscript.backstage.archive;

import manuscript.backstage.Archive;

public class DatabaseArchive implements Archive {
    
    private final String connectionString;
    
    public DatabaseArchive(String connectionString) {
        this.connectionString = connectionString;
        System.out.println("💾 Connect database: " + this.connectionString);
    }
    
    @Override
    public void store(RecordMedia media) {
        // Simulate database manipulation operation
        System.out.println("💾 Storing in database: " + media.toDML());
    }
}