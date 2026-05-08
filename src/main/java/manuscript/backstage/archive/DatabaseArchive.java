package manuscript.backstage.archive;

import manuscript.Actor;
import manuscript.backstage.Archive;

public class DatabaseArchive implements Archive {
    
    private final String connectionString;
    
    public DatabaseArchive(String connectionString) {
        this.connectionString = connectionString;
        System.out.println("🗄️ Datenbank-Archiv verbunden: " + this.connectionString);
    }
    
    public Actor load(String name) {
        // Simuliere Datenbank-Laden
        System.out.println("📂 [DB] Lade " + name + " aus der Datenbank...");
        return null; // In einer echten Implementierung würde hier ein Actor zurückgegeben
    }

    @Override
    public void store(RecordMedia  record) {
        // Simuliere Datenbank-Speicherung
        
        // Das Archiv speichert das Ergebnis
        System.out.println("⚙️ [BACKSTAGE] Archiviert: " + record.toString());
    }
}