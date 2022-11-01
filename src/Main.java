import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Player player = new Player(100, 50, 20);

        Raider raider1 = new Raider("Raider Scum", 4, 10, 10);
        Food cookedRadscorpion = new Food("Cooked Radscorpion", 40, 10, 15);
        Drink dirtyWater = new Drink("Dirty Water", 15, 5, 5);
        Medicine stimpack = new Medicine("Stimpack", 40, 0, 20);
        Place convinienceStore = new Place("Abandoned Convinience Store", raider1, cookedRadscorpion, dirtyWater, stimpack);
        Trader trader1 = new Trader(cookedRadscorpion, dirtyWater, stimpack);
        Mutant mutandDog = new Mutant("Mutant Cat", 5, 10);

        // player.Die();
        trader1.Interaction(player);
        player.TakeBreak();
        raider1.Interaction(player);
        player.TakeBreak();
        convinienceStore.Discover(player);
        player.TakeBreak();
        mutandDog.Interaction(player);
        player.TakeBreak();



    }
}
