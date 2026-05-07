package manuscript.directing;

import java.util.LinkedList;
import java.util.Queue;

import manuscript.Actor;
import manuscript.Movie;
import manuscript.Scene;
import manuscript.backstage.archive.DatabaseArchive;
import manuscript.backstage.payment.StripeApi;
import manuscript.backstage.payment.StripePayment;
import manuscript.birth.BirthScene;
import manuscript.birth.Hospital;
import manuscript.character.Bride;
// Charaktere
import manuscript.character.Groom;
import manuscript.character.Newborn;
import manuscript.familylife.Bedtime;
import manuscript.familylife.MorningRoutine;
import manuscript.honeymoon.HotelCheckIn;
import manuscript.honeymoon.SunsetDinner;
import manuscript.outfit.BrideWithArchive;
import manuscript.outfit.GroomWithCard;
import manuscript.outfit.PersistentActor;
// Outfits
import manuscript.outfit.SuitedActor;
import manuscript.stage.accessory.CinematicGrid;
import manuscript.stage.accessory.SpeechBubble;
// Stage
import manuscript.stage.take.WeddingCloseUp;
import manuscript.wedding.LoveStoryFlashback;
import manuscript.wedding.PayTheBand;
import manuscript.wedding.RingExchange;
import manuscript.wedding.Video;
// Akte
import manuscript.wedding.WeddingCeremony;
import manuscript.wedding.video.Canvas;
import manuscript.wedding.video.LazyVideo;

/**  
 * Der Composition Root der gesamten Anwendung.
 */  
public class InstalledMovie implements Movie {

    // 1. DIE BÜHNENTECHNIK (Backstage)  
    private final DatabaseArchive archive = new DatabaseArchive("jdbc:cinema://localhost/drehbuch");
    private final StripeApi stripe = new StripeApi();
      
    // Die Filmrolle  
    private final Queue<Scene> filmRoll = new LinkedList<>();

    public static void main(String[] args) {
        Movie movie = new InstalledMovie();
        movie.start();
        movie.nextScene();
    }

    @Override
    public void start() {
        System.out.println("🎥 Ruhe bitte! Kamera läuft, Ton läuft...");
        System.out.println("🎬 Film ab: Die Vorführung beginnt!");

        // ============================================================
        // DAS CASTING & DIE MASKE (Vorbereitung der Akteure)
        // ============================================================
        Groom romeo = new Groom("Romeo");
        Bride julia = new Bride("Julia");
        Newborn leon = new Newborn("Leon");

        GroomWithCard groomWithCard = new GroomWithCard(romeo, stripe);
        BrideWithArchive brideWithArchive = new BrideWithArchive(julia, archive);
        
       // Actor suitedGroom = new SuitedActor(romeo);
        //StripePayment groomWithCard = new StripePayment(suitedGroom, stripe);
       // PersistentActor persistentBride = new PersistentActor(julia, archive);

        // ============================================================
        // DIE INSZENIERUNG DER SZENEN (Die Filmrolle wird befüllt)
        // ============================================================

        // AKT 1: Die Hochzeit
        // Hier wird die atomare Szene (RingExchange) in die Rahmenszene injiziert
        Scene ringtausch = new RingExchange(romeo, julia);
        filmRoll.add(new WeddingCeremony(romeo, julia, ringtausch));
        filmRoll.add(new PayTheBand(groomWithCard, 500.00));
        
        // Video-Rückblick (mit Proxy-Pattern)
        Video lazyVideo = new LazyVideo("liebesgeschichte_hd.mp4");
        Canvas screen = new Canvas();
        filmRoll.add(new LoveStoryFlashback(lazyVideo, screen));

        // Visuelle Nahaufnahme
        WeddingCloseUp visualTake = new WeddingCloseUp(romeo, julia);
        filmRoll.add(visualTake::render);

        // AKT 2: Die Flitterwochen
        filmRoll.add(new HotelCheckIn(romeo, julia));
        filmRoll.add(new SunsetDinner(romeo, julia));

        // AKT 3: Die Geburt
        Hospital hospital = new Hospital("St. Mary's Klinik");
        filmRoll.add(new BirthScene(julia, leon, hospital));

        // AKT 4: Das Familienleben
        filmRoll.add(new MorningRoutine(romeo, julia, leon));
        filmRoll.add(new Bedtime(romeo, leon));
    }

    @Override
    public void nextScene() {
        while (!filmRoll.isEmpty()) {
            Scene currentScene = filmRoll.poll();
            System.out.println("\n🎞️ Nächste Szene wird abgespielt...");
            currentScene.execute();
        }
        System.out.println("\n🎬 Ende im Kasten! Vielen Dank an alle Beteiligten.");
    }
}