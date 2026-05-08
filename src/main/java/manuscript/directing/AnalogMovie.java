package manuscript.directing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import manuscript.Movie;
import manuscript.Scene;
import manuscript.backstage.archive.DatabaseArchive;
import manuscript.backstage.email.EmailBox;
import manuscript.backstage.payment.StripeApi;
import manuscript.backstage.phone.Phone;
import manuscript.birth.BirthScene;
import manuscript.birth.Hospital;
import manuscript.character.Band;
import manuscript.character.Bride;
import manuscript.character.Groom;
import manuscript.character.Guest;
import manuscript.character.Guests;
import manuscript.character.Musician;
import manuscript.character.Newborn;
import manuscript.familylife.Bedtime;
import manuscript.familylife.MorningRoutine;
import manuscript.honeymoon.HotelCheckIn;
import manuscript.honeymoon.SunsetDinner;
import manuscript.outfit.BrideWithArchive;
import manuscript.outfit.BrideWithMailbox;
import manuscript.outfit.GroomWithCard;
import manuscript.outfit.GroomWithPhone;
import manuscript.stage.take.WeddingCloseUp;
import manuscript.wedding.CallTheBand;
import manuscript.wedding.InviteTheGuests;
import manuscript.wedding.LoveStoryFlashback;
import manuscript.wedding.PayTheBand;
import manuscript.wedding.RingExchange;
import manuscript.wedding.Video;
import manuscript.wedding.VideoCanvas;
import manuscript.wedding.WeddingCeremony;
import manuscript.wedding.video.LazyVideo;

/**
 * The Composition Root of the console application.
 */
public class AnalogMovie implements Movie {

	public static void main(String[] args) {
		Movie movie = new AnalogMovie();
		movie.start();
		movie.nextScene();
	}

	private final Queue<Scene> filmRoll = new LinkedList<>();

	@Override
	public void start() {

		// ============================================================
		// BACKSTAGE & MAKEUP (Preparation of the infrastructure)
		// ============================================================
		DatabaseArchive archive = new DatabaseArchive("jdbc:cinema://localhost/drehbuch");
		Phone phone = new Phone("0170.777.888");
		StripeApi stripe = new StripeApi();
		EmailBox mailBox = new EmailBox("0127.555.333");

		System.out.println("🎥 Quiet, please! Camera rolling, sound rolling...");
		System.out.println("🎬 Roll film: The screening begins!");

		// ============================================================
		// CASTING & MAKEUP (Preparation of the Performers)
		// ============================================================
		Groom romeo = new Groom("Romeo");
		Bride julia = new Bride("Julia");
		Newborn leon = new Newborn("Leon");

		Guests guests = new Guests(Arrays.asList(new Guest("Mary"), new Guest("John")));
		Band band = new Band("Happy Wedding", Arrays.asList(new Musician("Jenny"), new Musician("Ben")));

		GroomWithCard groomWithCard = new GroomWithCard(romeo, stripe);
		GroomWithPhone groomWithPhone = new GroomWithPhone(romeo, phone);

		BrideWithArchive brideWithArchive = new BrideWithArchive(julia, archive);
		BrideWithMailbox brideWithLetters = new BrideWithMailbox(julia, mailBox);

		// ============================================================
		// THE STAGING OF THE SCENES (The Film Reel Is Filled)
		// ============================================================

		// ACT 1: The Wedding
		// Call the Band
		filmRoll.add(new CallTheBand(groomWithPhone, "0170.777.888"));
		// Inviting Guests
		filmRoll.add(new InviteTheGuests(brideWithLetters, guests));
		// Ceremony with atomic scene (RingExchange)
		Scene ringtausch = new RingExchange(romeo, julia);
		filmRoll.add(new WeddingCeremony(romeo, brideWithArchive, guests, band, ringtausch));
		filmRoll.add(new PayTheBand(groomWithCard, band, 500.00));
		// Video Recap (with Proxy-Pattern)
		Video video = new LazyVideo("liebesgeschichte_hd.mp4");
		VideoCanvas screen = new VideoCanvas();
		filmRoll.add(new LoveStoryFlashback(video, screen));
		// Visual Close-up
		WeddingCloseUp visualTake = new WeddingCloseUp(romeo, julia);
		filmRoll.add(visualTake::render);

		// ACT 2: The Honeymoon
		filmRoll.add(new HotelCheckIn(romeo, julia));
		filmRoll.add(new SunsetDinner(romeo, julia));

		// ACT 3: The Birth
		Hospital hospital = new Hospital("St. Mary's Klinik");
		filmRoll.add(new BirthScene(julia, leon, hospital));

		// ACT 4: The Family Life
		filmRoll.add(new MorningRoutine(romeo, julia, leon));
		filmRoll.add(new Bedtime(romeo, leon));
	}

	@Override
	public void nextScene() {
		while (!filmRoll.isEmpty()) {
			Scene currentScene = filmRoll.poll();
			System.out.println("\n🎞️ Next scene playing...");
			currentScene.execute();
		}
		System.out.println("\n🎬 It's a wrap! Many thanks to everyone involved.");
	}
}