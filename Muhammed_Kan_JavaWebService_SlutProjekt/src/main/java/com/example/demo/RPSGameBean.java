package com.example.demo;

import java.util.Random;

public class RPSGameBean {	

private RPSGameBean human = new RPSGameBean();
private RPSGameBean computer = new RPSGameBean();
private int totalGamesPlayed;

public RPSGameBean() {
}

public int getPlayerWins() {
	return human.getWins();
}

private int getWins() {
	// TODO Auto-generated method stub
	return 0;
}

public int getComputerWins() {
	return computer.getWins();
}

public int getPlayerLosses() {
	return human.getLosses();
}

private int getLosses() {
	// TODO Auto-generated method stub
	return 0;
}

public int getComputerLosses() {
	return computer.getLosses();
}

public int getPlayerTies() {
	return human.getTies();
}

private int getTies() {
	// TODO Auto-generated method stub
	return 0;
}

public int getComputerTies() {
	return computer.getTies();
}

public int getGamesPlayed() {
	return this.totalGamesPlayed;
}

public void setPlayerMove(String humanMove) {
	this.human.setMove(humanMove);
}

private void setMove(String humanMove) {
	// TODO Auto-generated method stub
	
}

public String getPlayerMove() {
	return human.getMove();
}

private String getMove() {
	// TODO Auto-generated method stub
	return null;
}

public String getComputerMove() {
	return computer.getMove();
}

public String getRandomRPS() {
	String computerMove;
	String[] listOfRPS = new String[] { "rock", "paper", "scissors" }; 
																			
	int randomGenerator = new Random().nextInt(3); 
	computerMove = listOfRPS[randomGenerator]; 

	return computerMove;
}

public String compareChoises() {
	this.computer.setMove(getRandomRPS());
	String Computer = getComputerMove();
	String player = getPlayerMove();
	String winner = "";


	//SPELAREN
	switch (player) {
	case "rock": // 

		switch (Computer) {
		case "rock":
			this.human.addTies();
			this.computer.addTies();
			this.totalGamesPlayed += 1;
			winner = "tie";
			break;
		case "scissors":
			this.human.addWins();
			this.computer.addLosses();
			this.totalGamesPlayed += 1;
			winner = "Player";
			break;
		case "paper":
			this.computer.addWins();
			this.human.addLosses();
			this.totalGamesPlayed += 1;
			winner = "Computer";
			break;
		}

		break;

		//SPELAREN
	case "scissors": 

		switch (Computer) {
		case "rock":
			this.computer.addWins();
			this.human.addLosses();
			this.totalGamesPlayed += 1;
			winner = "Computer";
			break;
		case "scissors":
			this.human.addTies();
			this.computer.addTies();
			this.totalGamesPlayed += 1;
			winner = "tie";
			break;
		case "paper":
			this.human.addWins();
			this.computer.addLosses();
			this.totalGamesPlayed += 1;
			winner = "Player";
			break;
		}
		break;

		//SPELAREN
	case "paper": 
		switch (Computer) {
		case "rock":
			this.human.addWins();
			this.computer.addLosses();
			this.totalGamesPlayed += 1;
			winner = "Player";
			break;
		case "scissors":
			this.computer.addWins();
			this.human.addLosses();
			this.totalGamesPlayed += 1;
			winner = "Computer";
			break;
		case "paper":
			this.human.addTies();
			this.computer.addTies();
			this.totalGamesPlayed += 1;
			winner = "tie";
			break;
		}
		break;

	}

	return winner;
}

private void addLosses() {
	// TODO Auto-generated method stub
	
}

private void addWins() {
	// TODO Auto-generated method stub
	
}

private void addTies() {
	// TODO Auto-generated method stub
	
}

}