/*
 * Bahy Huynh
 * DarkIgnister
 * TextGame Version 1.0.1
 */
import java.util.*;
import java.util.Date; 
public class Game {
	//Game Variable
	private static String[] enemies= {"Skeleton","Zombie","Lizard","Witch","Hobo","Big Spooder","Mage","That Man","That thing you found in the drawer"};
	private static int floor = 0;
	//Player Variables
	private static int health = 100;
	private static int numpot = 3;
	private static boolean running = true;
	private static boolean beginning = true;
	private static boolean SANSDEATH = false;
	private static int damage(int floor) {
		Random rand = new Random();
		int damage = 0;
		if(floor>=0 && floor<=10) {
			damage = 1 + rand.nextInt(10-1+1);
		}
		else if(floor>=11 && floor<=20) {
			damage = 5 + rand.nextInt(25-5+1);
		}
		else if(floor>=21 && floor<=30) {
			damage = 5 + rand.nextInt(35-5+1);
		}
		else if(floor>=31 && floor<=40) {
			damage = 10 + rand.nextInt(40-10+1);
		}
		else if(floor>=41 && floor<=50) {
			damage = 10 + rand.nextInt(50-10+1);
		}
		else if(floor>=51 && floor<=60) {
			damage = 15 + rand.nextInt(60-15+1);
		}
		else if(floor>=61 && floor<=70) {
			damage = 20 + rand.nextInt(60-20+1);
		}
		else if(floor>=71 && floor<=80) {
			damage = 15 + rand.nextInt(65-15+1);
		}
		else if(floor>=81 && floor<=90) {
			damage = 20 + rand.nextInt(70-20+1);
		}
		else if(floor>=91 && floor<=99) {
			damage = 20 + rand.nextInt(80-20+1);
		}
		else if(floor==2001) {
			damage = rand.nextInt() & Integer.MAX_VALUE;
		}
		else {
			damage = 50 + rand.nextInt(100-50+1);
		}
		return damage;
	}
	private static int ehp(int floor) {
		Random rand = new Random();
		int hp = 0;
		if(floor>=0 && floor<=10) {
			hp = 1 + rand.nextInt(10-1+1);
		}
		else if(floor>=11 && floor<=20) {
			hp = 20 + rand.nextInt(25-20+1);
		}
		else if(floor>=21 && floor<=30) {
			hp = 20 + rand.nextInt(35-20+1);
		}
		else if(floor>=31 && floor<=40) {
			hp = 30 + rand.nextInt(40-30+1);
		}
		else if(floor>=41 && floor<=50) {
			hp = 30 + rand.nextInt(50-30+1);
		}
		else if(floor>=51 && floor<=60) {
			hp = 50 + rand.nextInt(60-50+1);
		}
		else if(floor>=61 && floor<=70) {
			hp = 80 + rand.nextInt(100-80+1);
		}
		else if(floor>=71 && floor<=80) {
			hp = 80 + rand.nextInt(150-80+1);
		}
		else if(floor>=81 && floor<=90) {
			hp = 100 + rand.nextInt(150-100+1);
		}
		else if(floor>=91 && floor<=99) {
			hp = 150 + rand.nextInt(200-150+1);
		}
		else {
			hp = 500;
		}
		return hp;
	}
	//Game Start
	private static void menu(){
		try {
			Scanner in = new Scanner(System.in);
			Random rand = new Random();		
			System.out.println("-------------------Choices-------------------");
			System.out.println("\tFloor: " + floor);
			System.out.println("1: Advance to Next Floor?");
			System.out.println("2: Drink a Potion");
			System.out.println("3: Leave the Tower");
			System.out.print("Choice: ");
			String input = in.nextLine();
			while(!input.equals("1") && !input.equals("3") && !input.equals("03232001")) {
				//Heal
				if(input.equals("2")) {
					if(numpot>0) {
						int poison = 1 + rand.nextInt(100-1+1);
						//Death
						if(poison==1) {
							health = 0;
							System.out.println("\tThe potion you drank was actually bleach!!!");
							System.out.println("\tYour health is now at 0!!!");
							System.out.println("---------------------------------------------");
							System.out.println("You died on Floor: "+ floor);
							System.out.println("Thanks for playing the random game!!!");
							System.exit(-1);
						}
						//Heal
						else {
							int heal = 15 + rand.nextInt(50-15+1);
							health += heal;
							numpot--;
							System.out.println("\tYou drank a potion");
							System.out.println("\tYou recovered " + heal + " HP");
							System.out.println("\tYour HP: " + health);
							System.out.println("\tYou have "+ numpot+ " left");
						}
					}
					else {
						System.out.println("\tNo Potions Left");
					}
				}
				else {
				System.out.println("Invalid Input");
				}
				System.out.print("Choice: ");
				input = in.nextLine();
			}
			//To battle
			if(input.equals("1")) {
				System.out.println("You advanced to the next floor");
			}
			//Runs away from the tower
			else if(input.equals("3")) {
				if(floor==0){
					System.out.println("Wow");
					Thread.sleep(2000);
					System.out.println("What a bitch");
					Thread.sleep(2000);
					System.out.println("This is why your parents disowned you");
					System.exit(-1);
				}
				System.out.println("You tried to leave the tower");
				Thread.sleep(2000);
				System.out.println("But you were shanked by the theater kid");
				Thread.sleep(2000);
				System.out.println("This is what you get");
				Thread.sleep(3000);
				System.out.print(".");
				Thread.sleep(3000);
				System.out.print(".");
				Thread.sleep(3000);
				System.out.println(".");
				Thread.sleep(3000);
				System.out.println("Bitch");
				Thread.sleep(1000);
				System.exit(-1);
			}
			//Secret Boss
			else if(input.equals("03232001")) {
				System.out.println("Secret Code Found");
				Thread.sleep(1000);
				System.out.println("Hopefully you beat the game legit to get this code");
				Thread.sleep(1000);
				System.out.println("If so, Congrats!");
				Thread.sleep(1000);
				System.out.println("If not, fuck you");
				Thread.sleep(1000);
				System.out.println("Regardless, Your gonna have a fun time!!!");
				floor = 2001;
				SANSDEATH = true;
			}
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	private static String battle() {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();	
		System.out.println("---------------------------------------------");
		int enemyhealth = 0;
		String enemy = "PlaceHolder";
		if(floor==2001) {
			enemyhealth = 1;
			enemy = "Sans the Skeleton";
		}
		else if(floor!=100) {
			enemyhealth = ehp(floor);
			enemy = enemies[rand.nextInt(enemies.length)];
		}
		else if(floor==100){
			enemyhealth = 10000;
			enemy = "Dragon";
		}

		System.out.println("\t"+enemy+" has appeared!");
		while(enemyhealth>0) {
			System.out.println("---------------------------------------------");
			System.out.println("\tInfo: ");
			System.out.println("\tYour HP: " + health);
			System.out.println("\t"+enemy+"'s HP: " + enemyhealth);
			System.out.println("-------------------Choices-------------------");
			System.out.println("\t1: Attack");
			System.out.println("\t2: Drink Potion");
			System.out.println("\t3: Run");
			System.out.print("Choice: ");
			String input = in.nextLine();
			System.out.println("---------------------------------------------");
			//Fight
			if(input.equals("1")) {
				int dealt = damage(floor);
				int recieved = damage(floor);
				if(floor==2001) {
					dealt = 0;
				}
				//Player
				int miss = 1 + rand.nextInt(10-1+1);
				if(miss!=1) {
					int crit = 1 + rand.nextInt(20-1+1);
					if(crit==20) {
						dealt = dealt * 2;
						System.out.println("\tPlayer's attack is a critcal!!!");
					}
					System.out.println("\tYou dealt "+dealt+" to the " + enemy);
					enemyhealth -= dealt;
				}
				else {
					System.out.println("\t"+enemy+ " avoided Player's attack!!!");
				}
				//Enemy
				if(enemyhealth>0) {
					miss = 1 + rand.nextInt(10-1+1);
					if(miss!=1) {
						int crit = 1 + rand.nextInt(20-1+1);
						crit = 1 + rand.nextInt(20-1+1);
						if(crit==20) {
							recieved = recieved * 2;
							System.out.println("\t"+enemy+"'s attack is a critical!!!");
						}
						System.out.println("\t"+ enemy +" dealt " + recieved + " to you");
						health -= recieved;
					}
					else {
						System.out.println("\tPlayer avoided " + enemy+"'s attack!!!");
					}
				}
				//Check for death
				if(health<=0) {
					System.out.println("\tYou died");
					break;
				}
			}
			//Heal
			else if(input.equals("2")) {
				if(numpot>0) {
					int poison = 1 + rand.nextInt(100-1+1);
					if(poison==1) {
						health = 0;
						System.out.println("\tThe potion you drank was actually bleach!!!");
						System.out.println("\tYour health is now at 0!!!");
						System.out.println("\tYou rolled a nat 1");
					}
					else {
						int heal = 15 + rand.nextInt(50-15+1);
						health += heal;
						numpot--;
						System.out.println("\tYou drank a potion");
						System.out.println("\tYou recovered " + heal + " HP");
						System.out.println("\tYou have "+ numpot+ " left");
						//Enemy attacks
						int recieved = damage(floor);
						int crit = 1 + rand.nextInt(20-1+1);
						if(crit==20) {
							recieved = recieved * 2;
							System.out.println("\t"+enemy+"'s attack is a critical!!!");
						}
						System.out.println("\t"+ enemy +" dealt " + recieved + " to you");
						health -= recieved;
					}
					//Check for death
					if(health<=0) {
						System.out.println("\tYou died");
						break;
					}
				}
				else {
					System.out.println("\tNo Potions Left");
				}
			}
			//Run Away
			else if(input.equals("3")) {
				int chance = 1 + rand.nextInt(100-1+1);
				//Success
				if(chance>=70) {
					System.out.println("\tYou have successfully escaped from " + enemy);
					menu();
				}
				//Failed and Enemy attacks
				else {
					System.out.println("\tYou failed to escaped from " + enemy);
					int recieved = damage(floor);
					int crit = 1 + rand.nextInt(20-1+1);
					if(crit==20) {
						recieved = recieved * 2;
						System.out.println("\t"+enemy+"'s attack is a critical!!!");
					}
					System.out.println("\t"+ enemy +" dealt " + recieved + " to you");
					health -= recieved;
					//Check for death
					if(health<=0) {
						System.out.println("\tYou died");
						break;
					}
				}
			}
			else {
				System.out.println("\tInvalid Input");
			}
		}
		return enemy;
	}
	public static void main(String[] args) throws InterruptedException {
			Scanner in = new Scanner(System.in);
			Random rand = new Random();		
			String enemy = "placeholder";
			while(running) {
				//Story
				if(beginning==true) {
					System.out.println("You were wandering across the lands");
					Thread.sleep(2000);
					System.out.println("Traveling far and wide");
					Thread.sleep(2000);
					System.out.println("Why you were traveling?");
					Thread.sleep(2000);
					System.out.println("Because your parents disowned you and kicked you out of the house for majoring in Art");
					Thread.sleep(2000);
					System.out.println("You found a random tower in the middle of nowhere");
					Thread.sleep(2000);
					System.out.println("You entered the random tower because you were homeless");
					Thread.sleep(2000);
					System.out.println("Game Start");
					beginning = false;
					Thread.sleep(2000);
				}
				menu();
				enemy = battle();
				//Check if player is dead
				if(health<=0) {
					if(SANSDEATH == true) {
						System.out.println("You got dunked on!!!!!!!");
						System.out.println("Skill Issue");
					}
					else{
						System.out.println("You died on Floor: "+ floor);
					}
					break;
				}
				//Floor advancement
				floor++;
				if(floor==101) {
					System.out.println("Congrats You have beaten the random text game");
					System.out.println("Next time enter the input: 03232001 in the floor choices");
					System.out.println("To fight a secret boss");
					break;
				}
				//RNG for potion
				System.out.println("---------------------------------------------");
				System.out.println("\t" + enemy + " has been defeated");
				System.out.println("\tYour HP: " + health);
				if(rand.nextInt(100)>50) {
					 numpot++;
					System.out.println("\tYou obtained a potion");
					System.out.println("\tYou have "+ numpot+ " left");
				}
			}	
			System.out.println("Thanks for playing the random game!!!");
			in.close();
	}
}
