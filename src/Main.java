import java.util.Random;

public class Main {
    public static void main(String[] args){

        Random rand = new Random();
        Enemy[] enemies = 
        {
            new Raider("Raider Scum", 5, 20, 5),
            new Raider("Kellog", 25, 50, 50),
            new Raider("Lunatic", 2, 10, 3),
            new Raider("Raider Psycho", 10, 15, 7),
            new Raider("Cannibal", 17, 20, 14),
            new Raider("Raider Survivalist", 7, 34, 10),
            new Raider("Berserk Raider", 20, 34, 30),


            new Mutant("Feral Ghoul", 5, 20),
            new Mutant("Feral Ghoul Roamer", 7, 22),
            new Mutant("Feral Ghoul Stalker", 10, 25),
            new Mutant("Glowing Ghoul", 25, 40),
            new Mutant("Deathclaw", 30, 50),
            new Mutant("Radscorpion", 6, 21)
        };
        Consumable[] consumables =
        {
            new Food("Deathclaw Meat", 50, -50, 50),
            new Food("Sugar Bombs", 10, 5, 15),
            new Food("Iguana on a stick", 15, 5, 20),
            new Food("Potato Crisps", 7, 3, 6),
            new Food("Vegetable Soup", 25, 10, 30),

            new Drink("Dirty Water", 15, 5, 10),
            new Drink("Purified Water", 20, 0, 20),
            new Drink("Nuka Cola", 16, 9, 15),
            new Drink("Sunset Sarsaparilla", 18, 7, 18),
            new Drink("Nuka Cherry", 30, 10, 20),

            new Medicine("Stimpack", 30, 0, 40),
            new Medicine("RadAway", 0, -25, 30),
            new Medicine("Doctor's Bag", 30, -30, 60),
            new Medicine("Med-X", 15, 0, 20),
            new Medicine("Rad-X", 0, -10, 15)
        };
        Place[] places = 
        {
            new Place("Abandoned Convenience Store", enemies[rand.nextInt(enemies.length)], consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Place("Abandoned Metro Station",enemies[rand.nextInt(enemies.length)], consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Place("Abandoned Factory", enemies[rand.nextInt(enemies.length)], consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Place("Abandoned House", enemies[rand.nextInt(enemies.length)], consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Place("Abandoned University", enemies[rand.nextInt(enemies.length)], consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Place("Abandoned Museum", enemies[rand.nextInt(enemies.length)], consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Place("Abandoned Library", enemies[rand.nextInt(enemies.length)], consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Place("Abandoned Radio Station", enemies[rand.nextInt(enemies.length)], consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),

        };
        Trader[] traders =
        {
            new Trader("Trashcan Carla", consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Trader("Cricket", consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Trader("Lucas Miller", consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Trader("Doc Weathers", consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),
            new Trader("Crow", consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)],consumables[rand.nextInt(consumables.length)]),

        };
        Weapon[] weapons = 
        {
            new Weapon("10mm Pistol", 10, 20),
            new Weapon("Revolver", 16, 30),
            new Weapon("Hunting Rifle", 20, 50),
            new Weapon("Shotgun", 30, 100),
            new Weapon("Missle Launcher", 50, 500),

        };
        Armor[] armors = 
        {
            new Armor("Leather Armor", 20, 100),
            new Armor("Metal Armor", 40, 165),
            new Armor("Combat Armor", 60, 200),
            new Armor("Power Armor", 90, 1234)
        };

        Explorer explorer = new Explorer();
        Sponsor sponsor = new Sponsor(consumables, armors, weapons);
        Game game = new Game(explorer, enemies, traders, places, sponsor);

        //Gameplay Loop
        while(game.won == false){
            game.Setup();
            game.Prepare();
            // enemies[0].Interaction(explorer);
            while(explorer.died == false){
                game.Next();
                
            }
        }

        
    }
}
