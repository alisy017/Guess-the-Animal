package syed.guessgame;

import java.util.List;

import javax.swing.JOptionPane;

public class Specifications implements Runnable {

	private Animals A = new Animals();

	String jtaTextTemp = "Animals list:\n\n";

	Object[]	howManyLegs	= { " 2 ", " 4 ", " 6 ", " 8 " };
	Object[]	tailWings	= { "yes", "no" };
	Object[]	size		= { "Insect Size", "Rodent - Cat Size", "Dog Size", "Cattle Size", "Bigger" };
	Object[]	sound		= { "Baa", "Moo", "Woof", "Croak", "None", "Oink", "Cluck", "Meow", "Squeak", "Twittwoo", "Cluck", "Buzz","Roar", "Trumpets",
			"Other / Multiple" };
	Object[]	fchain		= { "Middle", "Top" };

	Object[] color = { "Pink", "Brown", "Green", "White", "Black", "Yellow", "Grey","Other / Varies" };

	List<String>		animalNameList	= A.animalNameList;
	List<Base>	animalList		= A.animalList;
	

	int numOfAnimals;

	@Override
	public void run() {
		updateRemainingAnimals();
		howManyLegsAreThere();
	}

	/** Asks the player how many legs the chosen animal has */
	public void howManyLegsAreThere() {
		int question1 = JOptionPane.showOptionDialog(null, "How many legs does your animal have?", "Guess the Animal",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, howManyLegs, howManyLegs[0]);
		if (question1 == 0) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i).getNumOfLegs() != 2) {
					animalList.remove(i);
				}
			}
		}
		if (question1 == 1) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i).getNumOfLegs() != 4) {
					animalList.remove(i);
				}
			}
		}
		if (question1 == 2) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i).getNumOfLegs() != 6) {
					animalList.remove(i);
				}
			}
		}
		if (question1 == 3) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i).getNumOfLegs() != 8) {
					animalList.remove(i);
				}
			}
		}
		updateRemainingAnimals();
		if (animalList.size() > 1) {
			doesItHaveATail();
		}
	}

	/** Asks the player if the chosen animal has a tail */
	public void doesItHaveATail() {
		int question1 = JOptionPane.showOptionDialog(null, "Does your animal have a tail?", "Guess the Animal", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, tailWings, tailWings[0]);
		if (question1 == 0) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (!animalList.get(i).hasTail()) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).hasTail()) {
						animalList.remove(i);
					}
				}
			}
		}
		updateRemainingAnimals();

		if (numOfAnimals > 1) {
			canMakeMilkForHuman();
		}

	}

	/** Asks the player if the chosen animal can make milk that humans drink */
	public void canMakeMilkForHuman() {
		int question1 = JOptionPane.showOptionDialog(null, "Can Your animal make milk for human consumption?", "Guess the Animal",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tailWings, tailWings[0]);
		if (question1 == 0) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (!animalList.get(i).makesMilkForHumans()) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).makesMilkForHumans()) {
						animalList.remove(i);
					}
				}
			}
		}
		updateRemainingAnimals();

		if (numOfAnimals > 1) {
			howBigIsIt();
		}
	}

	/** Asks the player how big the chosen animal is */
	public void howBigIsIt() {
		int question1 = JOptionPane.showOptionDialog(null, "Which size fits best you animals description?", "Guess the Animal",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, size, size[0]);
		if (question1 == 0) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSize() != 0) {
						animalList.remove(i);
					}
				}
			}
		}
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i) != null) {
				if (animalList.get(i).getSize() != question1) {
					animalList.remove(i);
				}
			}
		}
		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			whatColorIsIt();
		}
	}

	/** Asks the player what colour the chosen animal is */
	public void whatColorIsIt() {
		int question1 = JOptionPane.showOptionDialog(null, "What color is your animal?", "Guess the Animal", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, color, color[0]);
		System.out.println(color[question1]);
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i) != null) {
				if (animalList.get(i).getColor() != (question1 + 1)) {
					animalList.remove(i);
				}
			}
		}
		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			whatSoundDoesItMake();
		}

	}

	public void whatSoundDoesItMake() {
		int question1 = JOptionPane.showOptionDialog(null, "What sound does your animal make?", "Guess the Animal",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, sound, sound[0]);
		if (question1 == 0) {// baa
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 1) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {// moo
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 2) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 2) {// woof
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 3) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 3) {// croak
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 4) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 4) {// none
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 5) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 5) {// oink
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 6) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 6) {// cluck
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 7) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 7) {// meow
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 8) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 8) {// squeak
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 9) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 9) {// twittwoo
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 10) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 10) {// click
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 11) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 11) {// buzz
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 12) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 12) {// roar
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 13) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 13) {// trumpets
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 14) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 14) {// other
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 15) {
						animalList.remove(i);
					}
				}
			}
		}
		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			doesItHaveWingsThatFly();
		}

	}

	public void doesItHaveWingsThatFly() {
		int question1 = JOptionPane.showOptionDialog(null, "Can your animal fly?", "Guess the Animal",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tailWings, tailWings[0]);
		if (question1 == 0) {// true
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).hasWings() != true) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {// false
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).hasWings() != false) {
						animalList.remove(i);
					}
				}
			}
		}

		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			canItHaveMoreThan1ColorOnItsBody();
		}
	}

	public void canItHaveMoreThan1ColorOnItsBody() {
		int question1 = JOptionPane.showOptionDialog(null,
				"Can your animal have more than 2 colors on its body" + MainClass.eol + "(more than 2 colors)", "Guess the Animal",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tailWings, tailWings[0]);
		if (question1 == 0) {// true
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).hasMoreThan1Color() != true) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {// false
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).hasMoreThan1Color() != false) {
						animalList.remove(i);
					}
				}
			}
		}

		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			whereIsItOnTheFoodChain();
		}
	}

	public void whereIsItOnTheFoodChain() {
		int question1 = JOptionPane.showOptionDialog(null, "What is level of your animal on the food chain?", "Guess the Animal",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, fchain, fchain[0]);
		if (question1 == 0) {// middle
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getFoodChainPlace() != 1) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {// top
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getFoodChainPlace() != 2) {
						animalList.remove(i);
					}
				}
			}
		}

		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			// System.exit(1);
			JOptionPane.showMessageDialog(null, "Sorry but I have thought of " + numOfAnimals + " animals like that.", "Guess the Animal", 2);
		}
	}

	public void updateRemainingAnimals() {
		jtaTextTemp = "Animals list:\n\n";
		numOfAnimals = 0;
		for (int i = 0; i < animalList.size(); i++) {
			try {
				jtaTextTemp += animalList.get(i).getName() + "\n";
				System.out.println(animalList.get(i).getName());
			} catch (Exception e) {
				System.err.println("<Intelligence> FAILED TO ADD '" + animalNameList.get(i) + "' TO LIST");
			}

			if (animalList.get(i) != null) {
				numOfAnimals += 1;
			}

		}
		MainClass.jta.setText(jtaTextTemp);

		if (numOfAnimals == 1) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					JOptionPane.showMessageDialog(null, "I have guessed your animal is a " + animalList.get(i).getName() + "",
							"Animal Guesser", 1);
				}
			}
		}
		if (numOfAnimals == 0) {
			JOptionPane.showMessageDialog(null, "I do not have any animals like that in my list!  Would you like to add your animal in the list?", "Guess the Animal", 1);
		}

	}

}
