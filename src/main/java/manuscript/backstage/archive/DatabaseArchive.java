package manuscript.backstage.archive;

import manuscript.backstage.Archive;

public class DatabaseArchive implements Archive {

	private final String connectionString;

	public DatabaseArchive(String connectionString) {
		this.connectionString = connectionString;
		System.out.println("🗄️ Database archive connected: " + this.connectionString);
	}

	public RecordMedia load(String name) {
		// simulate database loading
		System.out.println("📂 [DB] Load " + name + " from database...");
		// In a real implementation, a Record for an Actor would be returned here.
		return null;
	}

	@Override
	public void store(RecordMedia record) {
		// simulate database persistence
		System.out.println("⚙️ [BACKSTAGE] Archived: " + record.toString());
	}
}