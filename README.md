# 🎬 Software Code That Reads Like a Movie

> *"AI writes code in seconds today. But who will still understand it tomorrow?"*

A living reference implementation of the **Feature-Film Philosophy** - an object-oriented structure where code reads like a screenplay, not a technical manual.

Based on the article: [Software Code That Reads Like a Movie](https://medium.com/@andreas.wagner.info/software-code-that-reads-like-a-movie-cdf0d88d097d)

---

## The Core Idea

Computers process arbitrary data structures. Humans understand the world through stories. Our brains store information through cause, effect, and **emotion** - not through passive data containers and stateless service layers.

The Feature-Film Philosophy stages an object-oriented system as a **living ensemble of intelligent actors**. These actors appear in scenes, act across structured acts, and give the system a dramaturgy that is humanly tangible. The story is not merely executed - it is made emotionally experienceable through the behavior of the characters themselves.

This codebase tells the life story of Romeo and Julia: from their **wedding** through their **honeymoon**, the **birth** of their child Leon, to everyday **family life**.

---

## The Principles

### 1. Three Graphs as Blueprint

Every object-oriented system can be understood through three dimensions. The screenplay maps all three:

| Graph | Film Analogy | What It Describes |
|---|---|---|
| **Construction Graph** | Set Setup / Directing | Who instantiates whom? (Composition Root) |
| **Collaboration Graph** | The Ensemble | Who knows whom? (permanent object relationships) |
| **Invocation Graph** | The Plot | Who calls what at runtime? (dynamic interactions) |

### 2. Tell Don't Ask

An actor is never interrogated about its internal state so that external code can make decisions on its behalf. Instead, the actor is **told to act**. Behavior lives where it semantically belongs - inside the character itself.

```java
// ❌ Ask style - state leaks outward
if (groom.hasRing()) {
    Ring ring = groom.getRind();
    bride.setRind(ring);
}

// ✅ Tell style - behavior stays with the actor
RingBasket ringBasket = new RingBasket();
groom.giveRing(ringBasket);
bride.receiveRing(ringBasket);
```

### 3. Law of Demeter

Actors communicate only with their **immediate neighbors**: No reaching of internal state through chains of objects.    
This eliminates transitive coupling and keeps the staging semantically stable.
Method chains are legitimate: `order.customer().address().city();` as long each method return a new object, but not a delegation of internal fields. 

### 4. Domain-Centric Package Structure

* Packages should not reflect technical layers (`Service`, `Repository`, `Controller`).
* They reflect **domain concepts and events** (`wedding`, `honeymoon`, `birth`, `familylife`).
* A new developer - or even a domain expert - can read the table of contents of the project and immediately understand the story being told.

**Three rules for the package hierarchy:**
* Parent packages never depend on their subpackages
* Subpackages refine existing concepts - they do not introduce new ones
* All naming follows the Ubiquitous Language of the domain

### 5. Composition Root - One Director, One Control Center

Only the `directing` package knows the full object graph. It instantiates all actors, sets up infrastructure, assembles decorators, and fills the film roll with scenes. No other package may depend on `directing`. This isolates technical orchestration from the pure domain narrative.

---

## Project Structure

```
manuscript/
│
├─ directing/           ← DIRECTING  - Composition Root & entry point
│
├─ character/           ← ENSEMBLE   - Main cast & role profiles
├─ outfit/              ← MAKEUP     - Structural wrappers (Decorator Pattern)
│
├─ wedding/             ← ACT 1      - Domain process: the ceremony
├─ honeymoon/           ← ACT 2      - Domain process: transition
├─ birth/               ← ACT 3      - Domain process: new life
├─ familylife/          ← ACT 4      - Domain process: steady state
│
├─ backstage/           ← STAGE ENGINEERING - Databases, APIs, infrastructure
│  ├─ archive/
│  │  ├─ DatabaseArchive.java   ← Concrete Database Connection
│  │  └─ RecordMedia.java       ← Data Carrier for Database Entries
│  ├─ email/
│  │  ├─ Email.java             ← Email Data Object
│  │  └─ EmailBox.java          ← Email Dispatch Adapter
│  ├─ payment/
│  │  ├─ StripeApi.java         ← Adapter for the Stripe Payment API
│  │  └─ Transaction.java       ← Transaction Object for Payments
│  ├─ phone/
│  │  ├─ Phone.java             ← Phone Communication Adapter
│  │  └─ Headset.java           ← Interface for Message Recipients
│  ├─ Archive.java              ← Interface to the Archive (Database)
│  ├─ Channel.java              ← Communication Channel (Publish/Subscribe)
│  ├─ PostBox.java              ← Interface for Message Dispatch
│  └─ Payer.java                ← Interface for Payment Processing
│
├─ stage/               ← THE STAGE  - User interfaces & presentation
│  ├─ accessory/
│  │  ├─ Action.java             ← Interactive - Action
│  │  ├─ Button.java             ← Interactive - Button
│  │  ├─ CinematicGrid.java      ← Cinematic Grid - Layout
│  │  └─ SpeechBubble.java       ← Speech Bubble for Dialogues - TextInput
│  ├─ wedding/
│  │  └─ WeddingCloseUp.java     ← Close-up of the Wedding - Visual View 
│  ├─ Multimedia.java            ← Composite: Component with Sub-Components
│  └─ Take.java                  ← Interface for Visual Takes
│
├─ Actor.java           ← ACTOR      - Central interface for all characters
├─ Name.java            ← PROPS      - Precise domain value (Value Object)
├─ Outfit.java          ← COSTUME    - Abstract base decorator
├─ Scene.java           ← SCENE      - The interaction protocol (@FunctionalInterface)
├─ Media.java           ← MEDIUM     - The information carrier
└─ Movie.java           ← SCREENPLAY - Entry point interface
```

### Dependency Hierarchy

```
Domain (Level 0)          - autonomous, no external dependencies
    ↑
Backstage (Infrastructure) - serves the domain; depends only on domain
    ↑
Scenes / Acts (Details)    - fills domain concepts with concrete life
    ↑
Stage (UI / Presentation)  - makes everything visible to the audience
    ↑
Directing (Composition Root) - the only class that knows everything
```

---

## Key Design Patterns in Use

| Pattern | Film Analogy | Where Used |
|---|---|---|
| **Decorator** | Costume / Makeup | `Outfit`, `BrideWithArchive`, `GroomWithPhone` |
| **Composite** | Scene Assembly | `Multimedia`, `CinematicGrid` |
| **Proxy** | Lazy Prop Setup | `LazyVideo` / `RealVideo` |
| **Observer** | Phone Call | `Phone`, `Headset`, `Channel` |
| **Command** | Stage Direction | `Scene`, `Button`, `Action` |
| **Adapter** | Technical Bridge | `StripeApi`, `EmailBox`, `DatabaseArchive` |
| **Value Object** | Named Prop | `Name`, `RingBasket`, `RecordMedia` |
| **Composition Root** | The Director | `AnalogMovie` |

---

## How to Read This Code

### Start at the Screenplay

Open `directing/AnalogMovie.java`. This is the director's script. You will see:

1. **Backstage preparation** - infrastructure is initialized (database, phone, Stripe, mail server)
2. **Casting** - actors are created (`romeo`, `julia`, `leon`, guests, band)
3. **Makeup** - decorators wrap actors with additional capabilities
4. **Film roll** - scenes are assembled in narrative order
5. **Playback** - `play()` runs each scene sequentially

### Follow the Acts

Each act is its own package. Open any scene class and read it like a paragraph of a novel:

```java
// WeddingCeremony.execute() - self-explanatory choreography
groom.perform();
bride.perform();
ringExchange.execute();
band.forEach(musician -> musician.perform());
guests.forEach(guest -> guest.clap());
```

### Read the Stack Trace as a Drama

When something fails, the error message reads like a screenplay stage direction - not a cryptic framework dump:

```
Exception: Wedding ring is missing!
  at manuscript.character.Bride.receiveRing(Bride.java:45)
  at manuscript.stage.wedding.WeddingCloseUp.lambda$0(WeddingCloseUp.java:46)
  at manuscript.directing.AnalogMovie.play(AnalogMovie.java:127)
```

**Who?** The bride. **What?** She could not receive the ring. **Where in the story?** The close-up during the ceremony. No guessing, no framework noise - immediate dramatic clarity.

---

## How to Arrive at This Kind of Code

### Step 1 - Write the Story First

Before writing a single class, describe the domain as a narrative:  
*"Romeo calls the band, Julia invites the guests by email. During the ceremony, they exchange rings..."*

This narrative becomes your package structure, your class names, your method names.

### Step 2 - Define Your Actors as Interfaces

Each role in the story becomes an interface. Ask: *What can this character **do**?* Not: *What data does it hold?*

```java
public interface Actor {
    Name name();
    void perform();
    void speak(Media media);
}
```

### Step 3 - Make Props Precise (Value Objects)

Never use raw primitives for domain values. A `Name` is not a `String`. A `RingBasket` is not a `Map`. Encapsulate validation and identity at the point of creation.

### Step 4 - Add Costumes Through Decoration

When an actor needs new capabilities for a specific context (database storage, email, payment), wrap them with a decorator. The core character never changes - only the costume does.

```java
BrideWithArchive brideWithArchive = new BrideWithArchive(julia, archive);
GroomWithPhone groomWithPhone = new GroomWithPhone(romeo, phone);
```

### Step 5 - Write Scenes, Not Services

Every meaningful interaction becomes a `Scene` with an `execute()` method. Scenes are lean orchestrators - they delegate to actors, not the other way around. No business logic lives in a scene; it lives inside the actors.

### Step 6 - Hide the Backstage

Infrastructure (databases, APIs, email) lives in `backstage/`. It is always accessed through domain interfaces (`Archive`, `Payer`, `PostBox`). The domain never imports from backstage directly.

### Step 7 - Wire Everything in One Place

The Composition Root (`AnalogMovie`) is the only place that knows the full object graph. It assembles actors, costumes, scenes, and infrastructure - then steps back. No Spring, no DI framework required for the core story.

---

## Running the Application

**Prerequisites:** Java 8+, (optional) Maven 3.x

```bash
# Clone or extract the project
cd blog-life-story-main

# Build
mvn compile

# Run the screening
mvn exec:java -Dexec.mainClass="manuscript.directing.AnalogMovie"

# Run the test
mvn test
```

The console output narrates the entire life story from the wedding ceremony through the bedtime story - each scene framed with emoji stage directions that make the flow immediately readable.

---

## The Characters

| Character | Class | Role |
|---|---|---|
| Romeo | `Groom` | Central protagonist - groom |
| Julia | `Bride` | Central protagonist - bride |
| Leon | `Newborn` | New character introduced in Act 3 |
| Mary, John | `Guest` / `Guests` | Supporting ensemble |
| Jenny, Ben | `Musician` / `Band` ("Happy Wedding") | Musical accompaniment |

---

## Further Reading

- [Software Code That Reads Like a Movie](https://medium.com/@andreas.wagner.info/software-code-that-reads-like-a-movie-cdf0d88d097d) - the original article this project illustrates
- [Composition Root Pattern](https://blog.ploeh.dk/2011/07/28/CompositionRoot/) - Mark Seemann
- [Next Level Readability](https://www.informatik-aktuell.de/entwicklung/programmiersprachen/next-level-lesbarkeit.html) - Robert Bräutigam
- [Happy Packaging](https://javadevguy.wordpress.com/2017/12/18/happy-packaging/) - Robert Bräutigam
- [Tell Don't Ask](https://www.martinfowler.com/bliki/TellDontAsk.html) - Martin Fowler

---

> *"So let us become storytellers and create code that not only works, but brings its own meaning precisely onto the screen."*
>
> **Cut, and... action! 🎬**
