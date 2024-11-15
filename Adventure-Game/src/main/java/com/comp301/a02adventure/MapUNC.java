package com.comp301.a02adventure;

/**
 * The MapUNC class extends the MapImpl class and represents a map of Chapel Hill and UNC's campus.
 * NOTE: Leave this class commented out until you have finished the Jedi portion of the assignment.
 * Once you've gotten 100% on Gradescope, uncomment this code to play the game!
 */
public class MapUNC extends MapImpl {
  /**
   * Constructs a new MapUNC object with the specified dimensions and initializes the map locations.
   */
  public MapUNC() {
    super(10, 10, 10);

    // ********************************************************************************
    // SET MAP LOCATIONS

    initCell(5, 9);
    getCell(5, 9).setName("Timberlyne");
    getCell(5, 9)
        .setDescription(
            "Near the highway is the only proper Chick-Fil-A in town. This area is also home to a\n"
                + "drive-in movie theater and Queen of Pho, if you're looking for some quality Vietnamese food.");

    initCell(5, 8);
    getCell(5, 8).setName("Police Station");
    getCell(5, 8)
        .setDescription(
            "What can I say, it's a police station. Don't speed. There's also a YMCA here.");

    initCell(5, 7);
    getCell(5, 7).setName("Bottom of the Hill");
    getCell(5, 7)
        .setDescription(
            "Heading north out of Chapel Hill, Columbia St turns sharply downhill. At the bottom\n"
                + "is a gas station, Hunam for Chinese food, and Lucha Tigre Latin-Asian fusion.\n"
                + "Farther north is the police station. Back down south is Franklin Street.");

    initCell(3, 6);
    getCell(3, 6).setName("Rosemary Street");
    getCell(3, 6)
        .setDescription(
            "You're at the edge of Rosemary Street! Directly to the north of Franklin, this east-west\n"
                + "directional street has neat establishments like Pantina Bob's and La Residence.\n"
                + "There's also a hotel for when family or friends come to visit!\n"
                + "To the south is Church Street, which connects Rosemary St to Franklin St.");

    initCell(4, 6);
    getCell(4, 6).setName("Rosemary Street East");
    getCell(4, 6)
        .setDescription("There's not much on this strip of Rosemary St, running east-and-west.");

    initCell(5, 6);
    getCell(5, 6).setName("Columbia Street");
    getCell(5, 6)
        .setDescription(
            "Check out Buns for mouth-watering, fully-customizable burgers, or Kurama for\n"
                + "best-in-town conveyor belt sushi! Columbia St. goes north-south,\n"
                + "or you could go west on Rosemary St.");

    initCell(6, 6);
    getCell(6, 6).setName("Rosemary Parking Deck");
    getCell(6, 6)
        .setDescription("It's kind of dank in here, and that's not necessarily a good thing.");

    initCell(7, 6);
    getCell(7, 6).setName("Henderson Street");
    getCell(7, 6)
        .setDescription(
            "Two of the coolest eateries in Chapel Hill can be found on this small road off of Franklin St.\n"
                + "TRU Deli lets you build and order your own sandwiches using your phone, and "
                + "Imbibe/Zog's\nhas the best Cajun food around.\nGo south to return to Franklin Street.");

    initCell(0, 5);
    getCell(0, 5).setName("Carrboro West");
    getCell(0, 5)
        .setDescription(
            "You're at the west edge of Carrboro. Head back east to see what Chapel Hill has to offer!");

    initCell(1, 5);
    getCell(1, 5).setName("Downtown Carrboro");
    getCell(1, 5)
        .setDescription(
            "This is the center of Carrboro! Visit Amante for some affordable and delicious pizza,\n"
                + "or Rise for that Southern taste of chicken 'n' biscuits.");

    initCell(2, 5);
    getCell(2, 5).setName("Carrboro East");
    getCell(2, 5)
        .setDescription(
            "You're at the east edge of Carrboro. There are some cool restaurants here, like Al's Burger Shack\n"
                + "and Carolina Brewery. The small college town of Chapel Hill is to the east.");

    initCell(3, 5);
    getCell(3, 5).setName("Church Street");
    getCell(3, 5)
        .setDescription(
            "Need some groceries? There's a Target to the south. You could head east to go downtown,\n"
                + "north to check out Rosemary Street, or west to see the quaint town of Carrboro.\n"
                + "Or you could stay here and try Might as Well, a student favorite restaurant\n"
                + "that turns into a dance club at night.");

    initCell(4, 5);
    getCell(4, 5).setName("Franklin Street West");
    getCell(4, 5)
        .setDescription(
            "You're down the hill from the center of town, but there's still a lot of activity!\n"
                + "There's a small yogurt shop and a Ben & Jerry's for your dessert needs, a local\n"
                + "favorite bar called He's Not Here, a Vietnamese Pho restaurant, and a sushi restaurant.");

    initCell(5, 5);
    getCell(5, 5).setName("Franklin Street Center");
    getCell(5, 5)
        .setDescription(
            "You're in the center of town. Looking around, you see a church, a busy Starbucks,\n"
                + "a rooftop bar, and a UNC-themed fast food joint called Sup Dogs.\n"
                + "From here, you can go in any direction.");

    initCell(6, 5);
    getCell(6, 5).setName("Franklin Street");
    getCell(6, 5)
        .setDescription(
            "This is the most iconic strip of Franklin St, full of shops, restaurants, bars, and clubs.\n"
                + "A few highlights: Hibachi & Co, Sutton's Drugstore, Epilogue Books, the Varsity Theater,\n"
                + "Cosmic Cantina, and Carolina Coffee Shop. Head west to the center of town,\n"
                + "or east to continue down Franklin Street.");

    initCell(7, 5);
    getCell(7, 5).setName("Franklin Street East");
    getCell(7, 5)
        .setDescription(
            "On the east side of Chapel Hill's historic downtown district is a large, old post office.\n"
                + "On the corner is Time Out next to Linda's, a grad student favorite bar.\n"
                + "To the north is a small street with more bars; to the south is an expansive\n"
                + "park that marks the beginning of UNC campus.");

    initCell(8, 5);
    getCell(8, 5).setName("Sorority Row");
    getCell(8, 5)
        .setDescription(
            "As Franklin Street curves out of town to the east, keep an eye out for the\n"
                + "massive sorority houses on either side of the street.");

    initCell(3, 4);
    getCell(3, 4).setName("Target");
    getCell(3, 4)
        .setDescription(
            "This small, floor-plan neighborhood Target has the groceries and items you need for your dorm life.");

    initCell(4, 4);
    getCell(4, 4).setName("Fraternity Court");
    getCell(4, 4)
        .setDescription(
            "The small ring of fraternity houses here always smells a bit funny, but it provides\n"
                + "a convenient shortcut to Target.");

    initCell(5, 4);
    getCell(5, 4).setName("Columbia Street South");
    getCell(5, 4)
        .setDescription(
            "You see an art museum with a few select exhibits on display outside. To the west is\n"
                + "Fraternity Court; Franklin St is northwards, and the UNC campus is just to the south.");

    initCell(6, 4);
    getCell(6, 4).setName("The Spider");
    getCell(6, 4).setDescription("An unnerving statue of a giant spider lies in wait.");

    initCell(7, 4);
    getCell(7, 4).setName("McCorkle Place");
    getCell(7, 4)
        .setDescription(
            "McCorkle Place is a majestic, historic park marking the oldest part of UNC campus.\n"
                + "Check out the Davie Poplar, a legendary old poplar tree, or the Old Well, an\n"
                + "iconic, picturesque location on campus.");

    initCell(8, 4);
    getCell(8, 4).setName("Morehead Planetarium");
    getCell(8, 4)
        .setDescription(
            "A massive sundial marks the entrance to Morehead Planetarium, on the east side of Chapel Hill.");

    initCell(9, 4);
    getCell(9, 4).setName("Arboretum");
    getCell(9, 4)
        .setDescription(
            "One of the most beautiful places on campus, the arboretum consists of a wide variety\n"
                + "of plantings including flowering trees and shrubs as well as bulb and perennial displays.");

    initCell(5, 3);
    getCell(5, 3).setName("Sitterson Hall");
    getCell(5, 3)
        .setDescription(
            "You found the Computer Science building! Normally, you can find students in here working on\n"
                + "independent projects, checking out organization booths, or finding help in office hours.");

    initCell(6, 3);
    getCell(6, 3).setName("Memorial Hall");
    getCell(6, 3)
        .setDescription(
            "Right along the road is Memorial Hall. This grand performance space hosts several events a year,\n"
                + "which UNC students can attend for a discount!");

    initCell(7, 3);
    getCell(7, 3).setName("Polk Place");
    getCell(7, 3)
        .setDescription(
            "A beautiful park surrounded by college buildings and an old library.\n"
                + "This is the heart of UNC's campus.");

    initCell(8, 3);
    getCell(8, 3).setName("Lenoir");
    getCell(8, 3)
        .setDescription(
            "Lenoir is the dining hall on North Campus. The bottom floor has food-court style vendors,\n"
                + "while the top floor consists of various buffet stations.");

    initCell(9, 3);
    getCell(9, 3).setName("Davis Library");
    getCell(9, 3)
        .setDescription(
            "This library contains several floors of study rooms, dusty bookshelves, and napping spots.");

    initCell(5, 2);
    getCell(5, 2).setName("Health Sciences Library");
    getCell(5, 2)
        .setDescription(
            "Home to the Friends Cafe and countless STEM resources. If you're also a Health Science student,\n"
                + "check out the Blue Room on the second floor; it's open 24/7 and perfect for studying.");

    initCell(6, 2);
    getCell(6, 2).setName("Quad");
    getCell(6, 2)
        .setDescription(
            "You're now a central hub of UNC North Campus! On each side, you'll find\n"
                + "different classrooms and administrative buildings.");

    initCell(7, 2);
    getCell(7, 2).setName("Undergraduate Library");
    getCell(7, 2)
        .setDescription(
            "The UG library has the look and feel of modernist architecture,\n"
                + "in stark contrast to its parents, Wilson and Davis. Even though it's smaller,\n"
                + "it hosts a broad collection of DVDs you can borrow, down in the Media & Design Center.");

    initCell(8, 2);
    getCell(8, 2).setName("Pit");
    getCell(8, 2)
        .setDescription(
            "On any given day, you might find Gary the Preacher here,\n"
                + "giving sermons on... no one really knows.");

    initCell(9, 2);
    getCell(9, 2).setName("Student Union");
    getCell(9, 2)
        .setDescription(
            "In here, you'll find everything you need to thrive at UNC:\n"
                + "Event Services, Student Life & Leadership, and Alpine Bagels.");

    initCell(6, 1);
    getCell(6, 1).setName("Wilson Library");
    getCell(6, 1)
        .setDescription(
            "You can catch lots of students posing for photos on the steps of Wilson Library,\n"
                + "but do you ever see any of them head inside?");

    initCell(8, 1);
    getCell(8, 1).setName("Student Bookstore");
    getCell(8, 1)
        .setDescription(
            "Need textbooks and scantrons? What about coffee, or a quick bite to eat? The Student Bookstore\n"
                + "has all those things, including a neat escalator that takes you from the Pit to South Road.");

    initCell(8, 0);
    getCell(8, 0).setName("Bell Tower");
    getCell(8, 0)
        .setDescription(
            "Right across from the Student Bookstore, the Bell Tower is one of UNC's well-known landmarks.\n"
                + "Feel free to guess what's up at the top of the tower, because I don't know either.");

    // ********************************************************************************
    // SET TREASURE CHESTS

    Inventory chest;

    // Timberlyne
    chest = new InventoryImpl();
    chest.addItem(new ItemImpl("movie ticket"));
    chest.addItem(new ItemImpl("popcorn"));
    getCell(5, 9).setChest(chest);

    // Student Bookstore
    chest = new InventoryImpl();
    chest.addItem(new ItemImpl("pens"));
    getCell(8, 1).setChest(chest);

    // Franklin Street
    chest = new InventoryImpl();
    chest.addItem(new ItemImpl("sandwich"));
    chest.addItem(new ItemImpl("UNC mug"));
    chest.addItem(new ItemImpl("Carolina shirt"));
    getCell(6, 5).setChest(chest);

    // Sitterson Hall
    chest = new InventoryImpl();
    chest.addItem(new ItemImpl("laptop"));
    getCell(5, 3).setChest(chest);

    // Lenoir
    chest = new InventoryImpl();
    chest.addItem(new ItemImpl("coffee"));
    getCell(8, 3).setChest(chest);

    // Wilson Library
    chest = new InventoryImpl();
    chest.addItem(new ItemImpl("library book"));
    getCell(6, 1).setChest(chest);

    // Target
    chest = new InventoryImpl();
    chest.addItem(new ItemImpl("desk lamp"));
    getCell(3, 4).setChest(chest);

    // ********************************************************************************
    // SET EMPTY CHESTS

    // Bottom of the Hill
    getCell(5, 7).setChest(new InventoryImpl());

    // Downtown Carrboro
    getCell(1, 5).setChest(new InventoryImpl());

    // Henderson Street
    getCell(7, 6).setChest(new InventoryImpl());

    // Fraternity Court
    getCell(5, 7).setChest(new InventoryImpl());

    // Arboretum
    getCell(9, 4).setChest(new InventoryImpl());
  }
}
