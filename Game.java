/*
 * Bahy Huynh
 * DarkIgnister
 * TextGame Version 1.0.0
 */
import java.util.*;
import java.util.Date; 
public class Game {
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
			hp = 5 + rand.nextInt(25-5+1);
		}
		else if(floor>=21 && floor<=30) {
			hp = 5 + rand.nextInt(35-5+1);
		}
		else if(floor>=31 && floor<=40) {
			hp = 10 + rand.nextInt(40-10+1);
		}
		else if(floor>=41 && floor<=50) {
			hp = 10 + rand.nextInt(50-10+1);
		}
		else if(floor>=51 && floor<=60) {
			hp = 15 + rand.nextInt(60-15+1);
		}
		else if(floor>=61 && floor<=70) {
			hp = 20 + rand.nextInt(60-20+1);
		}
		else if(floor>=71 && floor<=80) {
			hp = 15 + rand.nextInt(65-15+1);
		}
		else if(floor>=81 && floor<=90) {
			hp = 20 + rand.nextInt(70-20+1);
		}
		else if(floor>=91 && floor<=99) {
			hp = 20 + rand.nextInt(80-20+1);
		}
		else {
			hp = 50 + rand.nextInt(100-50+1);
		}
		return hp;
	}
	
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			Random rand = new Random();
			//Game Variables
			String[] enemies= {"Skeleton","Zombie","Lizard","Witch"};
			int floor = 1;
			
			//Player Variables
			int health = 100;
			int atkdmg = 50;
			int numpot = 3;
			
			boolean running = true;
			
			GAME:
			while(running) {
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
				while (enemyhealth>0) {
					System.out.println("---------------------------------------------");
					System.out.println("\tInfo: ");
					System.out.println("\tYour HP: " + health);
					System.out.println("\t"+enemy+"'s HP: " + enemyhealth);
					Thread.sleep(100);
					System.out.println("------------------Choices------------------");
					System.out.println("\t1: Attack");
					System.out.println("\t2: Drink Potion");
					System.out.println("\t3: Run");
					System.out.print("Choice: ");
					String input = in.nextLine();
					if(input.equals("1")) {
						int dealt = damage(floor);
						int recieved = damage(floor);
						for(int i=0;i<2;i++) {
							int crit = 1 + rand.nextInt(20-1+1);
							if(crit==20) {
								if(i==0) {
									dealt = dealt * 2;
									System.out.println("\tPlayer's attack is a critcal!!!");
								}
								else {
									recieved = recieved * 2;
									System.out.println("\t"+enemy+"'s attack is a critical!!!");
								}
							}
						}
						if(floor==2001) {
							dealt = 0;
						}
						System.out.println("\tYou dealt "+dealt+" to the " + enemy);
						System.out.println("\t"+ enemy +" dealt " + recieved + " to you");
						Thread.sleep(100);
						enemyhealth -= dealt;
						health -= recieved;
						if(health<=0) {
							System.out.println("\tYou died");
							break;
						}
					}
					else if(input.equals("2")) {
						if(numpot>0) {
							int heal = rand.nextInt(75-25+1);
							health += heal;
							numpot--;
							System.out.println("\tYou drank a potion");
							System.out.println("\tYou recovered " + heal + " HP");
							System.out.println("\tYour HP: " + health);
							System.out.println("\tYou have "+ numpot+ " left");
							Thread.sleep(100);
							int recieved = damage(floor);
							int crit = 1 + rand.nextInt(20-1+1);
							if(crit==20) {
								recieved = recieved * 2;
								System.out.println("\t"+enemy+"'s attack is a critical!!!");
							}
							System.out.println("\t"+ enemy +" dealt " + recieved + " to you");
							health -= recieved;
							Thread.sleep(100);
							if(health<=0) {
								System.out.println("\tYou died");
								Thread.sleep(100);
								break;
							}
						}
						else {
							System.out.println("\tNo Potions Left");
						}
					}
					else if(input.equals("3")) {
						int chance = 1 + rand.nextInt(100-1+1);
						if(chance>=75) {
							System.out.println("\tYou have successfully escaped from " + enemy);
							Thread.sleep(1000);
							continue GAME;
						}
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
				if(health<=0) {
					System.out.println("Git Good");
					break;
				}
				floor++;
				if(floor==101) {
					System.out.println("Congrats You have beaten the random text game");
					Thread.sleep(100);
					System.out.println("Next time enter the input: '03232001' in the floor choices");
					Thread.sleep(100);
					System.out.println("To fight a secret boss");
					break;
				}
				System.out.println("---------------------------------------------");
				System.out.println("\t"+enemy+" has been defeated");
				System.out.println("\tYour HP: " + health);
				if(rand.nextInt(100)>50) {
					 numpot++;
					System.out.println("\tYou obtained a potion");
					System.out.println("\tYou have "+ numpot+ " left");
				}
				System.out.println("-----------------Choices-----------------");
				System.out.println("\tFloor: " + floor);
				System.out.println("1: Advance to Next Floor?");
				System.out.println("2: Drink a Potion");
				System.out.println("3: Leave the Tower");
				System.out.print("Choice: ");
				String input = in.nextLine();
				while(!input.equals("1") && !input.equals("3") && !input.equals("03232001")) {
					if(input.equals("2")) {
						if(numpot>0) {
							int heal = rand.nextInt(75-25+1);
							health += heal;
							numpot--;
							System.out.println("You drank a potion");
							System.out.println("You recovered " + heal + " HP");
							System.out.println("You have "+ numpot+ " left");
							Thread.sleep(100);
							}
						else {
							System.out.println("No Potions Left");
							Thread.sleep(100);
						}
					}
					else {
					System.out.println("Invalid Input");
					}
					System.out.print("Choice: ");
					input = in.nextLine();
				}
				if(input.equals("1")) {
					System.out.println("You advanced to the next floor");
				}
				else if(input.equals("3")) {
					System.out.println("You tried to leave the tower");
					Thread.sleep(2000);
					System.out.println("But you were shanked by the christmas elf");
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
					break;
				}
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
				}
			}
			System.out.println("Thanks for playing the random game!!!");
			in.close();
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
