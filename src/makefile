#
# A simple makefile for compiling three java classes
#

# define a makefile variable for the java compiler
#
JCC = javac

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#
default: Main.class Object.class Game.class Weapon.class Armor.class Food.class Creature.class Consumable.class Enemy.class Drink.class Medicine.class Enemy.class Raider.class Mutant.class Sponsor.class Place.class Trader.class
	

# this target entry builds the Average class
# the Average.class file is dependent on the Average.java file
# and the rule associated with this entry gives the command to create it

Main.class: Main.java
	$(JCC) $(JFLAGS) Main.java

Object.class: Object.java
	$(JCC) $(JFLAGS) Object.java	

Game.class: Game.java
	$(JCC) $(JFLAGS) Game.java

Weapon.class: Weapon.java
	$(JCC) $(JFLAGS) Weapon.java

Armor.class: Armor.java
	$(JCC) $(JFLAGS) Armor.java

Food.class: Food.java
	$(JCC) $(JFLAGS) Food.java

Creature.class: Creature.java
	$(JCC) $(JFLAGS) Creature.java	

Consumable.class: Consumable.java
	$(JCC) $(JFLAGS) Consumable.java	

Enemy.class: Enemy.java
	$(JCC) $(JFLAGS) Enemy.java

Drink.class: Drink.java
	$(JCC) $(JFLAGS) Drink.java

Medicine.class: Medicine.java
	$(JCC) $(JFLAGS) Medicine.java
	
Enemy.class: Enemy.java
	$(JCC) $(JFLAGS) Enemy.java

Raider.class: Raider.java
	$(JCC) $(JFLAGS) Raider.java

Mutant.class: Mutant.java
	$(JCC) $(JFLAGS) Mutant.java	

Sponsor.class: Sponsor.java
	$(JCC) $(JFLAGS) Sponsor.java	

Place.class: Place.java
	$(JCC) $(JFLAGS) Place.java	
	
Trader.class: Trader.java
	$(JCC) $(JFLAGS) Trader.java	

# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
clean: 
	rm *.class