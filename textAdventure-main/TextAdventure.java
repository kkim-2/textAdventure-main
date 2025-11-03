import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;
  int rand;
  boolean died = false;


  public TextAdventure()
  {
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    ourHero = new Player("Bob", 100, 0);
    

  }

  public void play()
  {
    String input;
    // start of adventure. You can change this if you like
    console.setImage("distantcity.jpg");

    // ask the user for their name.
    System.out.print("What is your name? \n");
    input = inScanner.nextLine();
    System.out.println("----------------------------------------------------------------------------------");

    // Change ourHero's name
    // ADD CODE HERE
    ourHero.changeName(input);
    
    // describe the starting situation. Feel free to change this
    System.out.println("You wake up to find yourself on the edge of a shadowy forest with the sun nearly set. \nYou see what looks like a city in the distance. \nWhat would you like to do? \ncity: go towards the city\nforest: turn around and re-enter the forest\nnap: go back to sleep\n" + ourHero.getName() + ": ");

    // get user input and go to the appropriate zone based on their input
    // ADD CODE HERE
    input = inScanner.nextLine();
    if(input.equalsIgnoreCase("Forest") ){
      enterZone1();
    }
    else if(input.equalsIgnoreCase("city") ){
      enterZone2();
    }
    else if(input.equalsIgnoreCase("nap")){
      System.out.println("Have a nice rest");
      gameEnd();
    }


  }

  private void enterZone1()
  {
    String input;
    // change image
    // ADD CODE HERE
    console.setImage("forest.jpg");

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("As you enter the forest you are greeted with monsters.\n What would you like to do?\nFight: fight the monsters with the risk of losing health\nMountains: flee to the mountains\nAccept: accept your fate of being killed by monsters\n"+ ourHero.getName() + ": ");

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    input = inScanner.nextLine();
    
    if(input.equalsIgnoreCase("fight")){
      rand = (int)(Math.random()*100);
  
      if(rand>75){
        
        ourHero.defeatMonster(); 
        System.out.println("Congrats! You defeated the monsters");
        enterZone4();
      }
      else{
        
        ourHero.setHealth(ourHero.getHealth() - 20);
        System.out.println("You didn't beat the monsterss\nCurrent Health: "+ourHero.getHealth());
        enterZone4();
      }
      
    }
    else if(input.equalsIgnoreCase("Mountains")){
      enterZone3();
    }
    else if(input.equalsIgnoreCase("Accept")){
      System.out.println("----------------------------------------------------------------------------------");
      System.out.println("You died :(");
      died = true;
      gameEnd();
    }
  }

  private void enterZone2()
  {
    String input;
    // change image
    // ADD CODE HERE
    console.setImage("graveyard.jpg");

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("As you get closer to what looks like a city, it turns out it's not\nYou stumble upon a graveyard\nIn the graveyard you find a treasure chest\nWhat would you like to do?\nOpen:open the chest\nIgnore: continue on to pumpkinville\nExplore: look around\n"+ ourHero.getName() + ": ");
    input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if(input.equalsIgnoreCase("Open")){
      if(rand>90){
        System.out.println("----------------------------------------------------------------------------------");
        ourHero.setGold(ourHero.getGold()+20);
        System.out.println("You hit gold!\n Gold: "+ourHero.getGold());
        enterZone4();
      }
      else{
        System.out.println("----------------------------------------------------------------------------------");
        ourHero.setGold(ourHero.getGold()-20);
        System.out.println("A goblin tricked you and stole your gold :(\nGold: "+ourHero.getGold());
        enterZone3();
       }
     
    }
    else if(input.equalsIgnoreCase("Ignore")){
      enterZone6();
    }
    else if(input.equalsIgnoreCase("Explore")){
      System.out.println("----------------------------------------------------------------------------------");
      System.out.println("You look around, however you were in the graveyard for too long\nIt gives enough time for an evil spirit to curse you\nYou die :(");
      died = true;
    }

    
  }

  private void enterZone3()
  {
    String input;
    // change image
    // ADD CODE HERE
    console.setImage("mountains.png");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("You enter the eerie mountains\n as you enter you stumble across a cave\nEnter it?\n"+ ourHero.getName() + ": ");
    input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if(input.equalsIgnoreCase("yes")){
      System.out.println("----------------------------------------------------------------------------------");
      System.out.println("It turns out its a dragon cave!\nThere is gold everywhere\n The dragon is asleep however\nWhat would you like to do?\nFight: fight the dragon\nSteal: steal the dragon's gold\nEscape: escape the cave\n"+ ourHero.getName() + ": ");
      input = inScanner.nextLine();
      if(input.equalsIgnoreCase("Fight")){
        if(rand>95){
          System.out.println("----------------------------------------------------------------------------------");
          ourHero.setGold(ourHero.getGold()+100);
          ourHero.defeatMonster();
          System.out.println("You quickly jump on top of the dragon and stab its head, without giving it a chance to awake from its slumber.\nYour dexterous sword skills come in handy!\nYou gain glory and gold!\n Gold: "+ourHero.getGold());
          enterZone5();
        }
        else{
          System.out.println("----------------------------------------------------------------------------------");
          System.out.println("Your footsteps are too loud and they awaken the dragon\nThe dragon opens its mouth and releases his fiery breath\nEvery inch of you screams out in pain, a pain that tells you that you are the dragon's next meal\nYou get eaten by Dragon and die :(");
          died = true;
          gameEnd();
        }
       
      }
      else if(input.equalsIgnoreCase("steal")){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("You should know not to mess with the dragon\nYou die :(");
        died =true;
        gameEnd();
        }
        else if (input.equalsIgnoreCase("escape")){
          System.out.println("----------------------------------------------------------------------------------");
          System.out.println("you accidentally fall off the cliff and die");
          died = true;
          gameEnd();
        }
      
    }
     else if (!input.equalsIgnoreCase("yes")){
      System.out.println("----------------------------------------------------------------------------------");
      System.out.println("Your footsteps awaken the dragons\nYou die :(");
      died = true;
      gameEnd();
    }
   
  }

  private void enterZone4()
  {
    String input;
    // change image
    // ADD CODE HERE
    console.setImage("ocean.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("You arrive at the ocean and there are a bunch of ports.\n You ask someone if you can aboard a ship with them and they agree\n On the ship it is peaceful until a storm comes forth\nWhat would you like to do?\nSafety:Go into the ship's cabins\nLookout: keep an eye on the storm to see if it escalates\nSwim: attempt to swim to shore to keep away from the storm\n"+ ourHero.getName() + ": ");
    input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if(input.equalsIgnoreCase("Safety")){
      System.out.println("----------------------------------------------------------------------------------");
      System.out.println("The storm rages on and takes out a few ship members on deck\nHowever you are safe\nAfter the ship journey you continue to the Animalia kingdom");
      enterZone5();
    }
    else if(input.equalsIgnoreCase("Lookout")){
      System.out.println("There is a sea monster that comes with the storm\nIt's tentacles wrap the ship and takes some crew members with it\nFight it?\n"+ ourHero.getName() + ": ");
      input = inScanner.nextLine();
      if(input.equalsIgnoreCase("yes")){
        if (rand>60){
          ourHero.defeatMonster();
          ourHero.setGold(ourHero.getGold()+50);
          System.out.println("----------------------------------------------------------------------------------");
          System.out.println("You remember in folk tale your mother told you that the sea monsters recoil at the sight of short people!\nYou sacrfice a few short people on the crew and they are thrown into the ocean\nThe sea monster faints at the sight of this and allows you a chance to strike!\n You are successful!\nThe captain gives you gold for you're bravery and valor! (Don't worry the short people lived)\nGold: "+ourHero.getGold());
          enterZone5();
        }
        else{
          ourHero.setHealth(ourHero.getHealth()-50);
          System.out.println("----------------------------------------------------------------------------------");
          System.out.println("Unfourtunately, you become too scared and faint\nAs you wake up you realize that there is a gash in your leg and you lose health\nHealth: "+ourHero.getHealth());
          System.out.println("After the voyage, you enter animalia kingdom");
          enterZone5();
        }
      }
      

    }
    else if(input.equalsIgnoreCase("Swim")){
      System.out.println("----------------------------------------------------------------------------------");
        System.out.println("You jump into the ocean\nThe second you do, you totally forgot you can't swim!\nYou flail your arms and cry for help but nobody cares\n You die :(");
        died = true;
        gameEnd();
      }
    
  }

  private void enterZone5()
  {
    String input;
    // change image
    // ADD CODE HERE
    console.setImage("animals.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("Welcome to Animalia Kingdom!\nYou see animals of all kinds communicating with each other whilst wearing human clothes\nIt was quite the sight to see!\nYou approach a capybara merchant who seems to have an abundant of items\nWhat would you like to choose?\nMedecine: Heals 20 of your health\nMysterious Sock: It contains a certain aura\nSteal: Steal the most valuable items of the poor merchant\n"+ ourHero.getName() + ": ");
    input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if(input.equalsIgnoreCase("Medecine")){
      System.out.println("----------------------------------------------------------------------------------");
      ourHero.setHealth(ourHero.getHealth()+20);
      System.out.println("Health: "+ ourHero.getHealth());
      enterZone6();
    }
    else if(input.equalsIgnoreCase("mysterious sock")){
      System.out.println("----------------------------------------------------------------------------------");
      ourHero.setGold(ourHero.getGold()+1000);
      System.out.println("You take the sock and turns out someone had left 1000 gold!\nYou become rich!\nGold: "+ourHero.getGold());
      enterZone6();
    }
    else if(input.equalsIgnoreCase("steal")){
      if(rand>50){
        System.out.println("----------------------------------------------------------------------------------");
        ourHero.setGold(ourHero.getGold()+100);
        System.out.println("You were able to slip away with 100 gold worth of items!\nGold: "+ourHero.getGold());
        enterZone6();
      }
      else{
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Stealing is bad >:(\n You were caught by the capybara merchant and turns out he was a powerful wizard\nYou get striked by his powerful lighting spell and die :(");
        died = true;
        gameEnd();

      }

    }
    
  }

  private void enterZone6()
  {
    String input;
    // change image
    // ADD CODE HERE
    console.setImage("pumpkintrio.png");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("----------------------------------------------------------------------------------");
    System.out.println("Pumpkinville!\n A place where pumpkins are never to be discriminated\nnever to hide nor be ashamed of one's orange self!\nHowever as you enter Pumpkinville, the villagers give you side glances\nYou realize it is because you are not a pumpkin\nYou suddenly become concious of your very un-pumpkinlike self\n What would you like to do?\nHavoc: Cause destruction and havoc and attempt to conquer Pumpkinville and make it into your own dictatorship\nSettle: settle down in pumpkin ville and become friends with the pumpkins\nLeave: leave pumpkinville, because you feel so out of place\n"+ ourHero.getName() + ": ");
    input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if(input.equalsIgnoreCase("Havoc")){
      if(rand>80){
        System.out.println("----------------------------------------------------------------------------------");
        ourHero.defeatMonster();
        ourHero.setGold(ourHero.getGold()+100);
        System.out.println("You are successful in your conquers!\nYou murder the Pumpkinville mayor and become the dictator\nPumpkins of Pumpkinville bow down to you and respect you!\n You are now the sole ruler of pumpkinville\nGold: "+ourHero.getGold()+"\nMonsters: "+ourHero.getMonstersDefeated());
        gameEnd();
      }
      else{
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("You get captured by the pumpkins because they are a lot stronger than they appear\nYou get publicly executed as an example as to those who rebel\nYou died :(");
        died = true;
        gameEnd();

      }
    }
    else if(input.equalsIgnoreCase("Settle")){
      System.out.println("----------------------------------------------------------------------------------");
      System.out.println("The people of Pumpkinville accept you as that is their kind nature\nAlthough you are still discriminated for being so un-pumpkinlike you are still accepted by most\n you make friends and live happily ever after :)");
      gameEnd();
    }
    else if(input.equalsIgnoreCase("Leave")){
      System.out.println("----------------------------------------------------------------------------------");
      System.out.println("Unfourtunately, as you attempt to leave, you take the wrong route and eneter the forest of death\nWithin the forest you encounter pumpkin carnivores\nYou get eaten by pumpkins and not the other way around\nYou died :(");
      died = true;
      gameEnd();
    }
    
  }

  private void gameEnd()
  {
    // ADD CODE HERE
    if(died == true){
      System.out.println("Stats ------------------------------------------------------------------------\nGold: "+ourHero.getGold()+"\nMonsters: "+ ourHero.getMonstersDefeated());
    }
    else{
      if(ourHero.getHealth()>50&&ourHero.getGold()>100){
        System.out.println("You exceeeded expectations fellow hero\nYou are the top tier hero and won the game!");
        System.out.println("Stats ------------------------------------------------------------------------\nGold: "+ourHero.getGold()+"\nMonsters: "+ ourHero.getMonstersDefeated()+ "\nHealth: "+ourHero.getHealth());
      }
      else{
        System.out.println("You didn't really do that well\nYou are a mid hero");
         System.out.println("Stats ------------------------------------------------------------------------\nGold: "+ourHero.getGold()+"\nMonsters: "+ ourHero.getMonstersDefeated()+ "\nHealth: "+ourHero.getHealth());
      }
    }

    inScanner.close();
  }
}