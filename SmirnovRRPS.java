/*
 * Cool program that allows a user to play rock paper scissors against a number generator in case they don't have friends
 * @author Rachel Smirnov
 * @date April 5, 2024
 * @version 1.0
 */

package helloWorld;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.EventObject;

public class SmirnovRRPS {

	private JFrame frame;
	private JButton btnRock, btnPaper, btnScissors;
	private int move,compWins,humanWins,ties;
	private int rounds=0;
	private String compMove, winner;
		private JLabel lblCompWins, lblHumanWins, lblTieCount, lblTies, lblRightWins, lblLeftWins, lblRoundNum, lblHumanSelect, lblCompSelect ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmirnovRRPS window = new SmirnovRRPS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SmirnovRRPS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
						
		
		frame = new JFrame();
		frame.setBounds(100,100,1200,669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JPanel panelHuman = new JPanel() {
			public void paintComponent (Graphics x) {
				//gets path to image in src file (resources) -> draws image to the panel of the rectangle calculator
				URL url = SmirnovRRPS.class.getResource("/humanPanel.jpg"); 
				ImageIcon im = new ImageIcon(url);
				Image i = im.getImage();
				x.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this); //allign image with panel
				}
		};
		
		panelHuman.setBounds(1, 1, 420, 632);
		frame.getContentPane().add(panelHuman);
		panelHuman.setLayout(null);	
			
		
		JPanel panelComp = new JPanel() {
			public void paintComponent (Graphics x) {
				
				URL url = SmirnovRRPS.class.getResource("/humanPanel.jpg"); 
				ImageIcon im = new ImageIcon(url);
				Image i = im.getImage();
				x.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this); 
				}
		};
			panelComp.setBounds(764,0,422,632);
		frame.getContentPane().add(panelComp);
		panelComp.setLayout(null);
		
		
		
		JPanel panelScore = new JPanel() {
			public void paintComponent (Graphics x) {
				
				URL url = SmirnovRRPS.class.getResource("/scorePanel.jpg"); 
				ImageIcon im = new ImageIcon(url);
				Image i = im.getImage();
				x.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this); 
				}
		};
		panelScore.setBounds(420,0,344,632);
		frame.getContentPane().add(panelScore);
		panelScore.setLayout(null);
			frame.getContentPane().setLayout(null);
		
		
		JButton btnRestart = new JButton("Restart Match"); //restart button
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if  (JOptionPane.showConfirmDialog(frame, "Do you want to restart?", "Restart!",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					//will revert all settings as they were at the beginning of the game if user clicks 'yes'
					
					humanWins=0;
					compWins=0;
					ties=0;
					rounds=0;
					lblTieCount.setText("");
					lblCompWins.setText("");
					lblHumanWins.setText("");
					lblRoundNum.setText("<html><center>Press <br> rock, paper, or scissors to play</html>");
					lblCompSelect.setVisible(false);
					lblHumanSelect.setVisible(false);

			}
		}
		});
		btnRestart.setFont(new Font("Sitka Display", Font.BOLD, 15));
		btnRestart.setBounds(110, 521, 140, 49);
		panelScore.add(btnRestart);
		
		ActionListener moveButtons = new ActionListener() { //a function that works for all 3 button options on the human panel. 
			@Override
				public void actionPerformed(ActionEvent event) {
				move = (int) (1+Math.random()*3); //generates random num between from 1 to 3
				rounds+=1; //increments the round everytime the user clicks a button
				
				
				lblCompSelect.setVisible(true);//sets the selected item to visible, however the image is only added once it is determined what button they clicked
				lblHumanSelect.setVisible(true);
				if (rounds<=5) { //will only run the scoring up to 5th round
					
				lblRoundNum.setText(String.format("Round %d",rounds)); //instead of instructions, display round count during scoring 
				
				switch(move) { //switch cases for 3 numbers randomly generated, each representing a move in RPS
							
				case 1: //assign a case to rock, paper, or scissors
					
					if (event.getSource() == btnRock) { //get the variable of the button that triggered the event listener
						lblHumanSelect.setIcon(new ImageIcon(getClass().getResource("/rockAns.jpg")));	//set images according to the case as well as the button clicked
						lblCompSelect.setIcon(new ImageIcon(getClass().getResource("/paperAns.jpg")));	
						humanWins+=1; //in each case, add a point to coresponding winner
						lblHumanWins.setText(Integer.toString(humanWins)); //set the changing score count
					};
					
					if (event.getSource() == btnPaper) {
				          ties+=1;
				          lblTieCount.setText(Integer.toString(ties));
				          lblHumanSelect.setIcon(new ImageIcon(getClass().getResource("/paperAns.jpg")));	
				          lblCompSelect.setIcon(new ImageIcon(getClass().getResource("/paperAns.jpg")));	
					}
					if (event.getSource() == btnScissors) {
				          compWins+=1;
				          lblCompWins.setText(Integer.toString(compWins));
				          lblHumanSelect.setIcon(new ImageIcon(getClass().getResource("/scissorsAns.jpg")));
				          lblCompSelect.setIcon(new ImageIcon(getClass().getResource("/paperAns.jpg")));	
				      }
					
					break;
						
					
				case 2:
					
					if (event.getSource() == btnPaper) {
				          humanWins+=1;
				          lblHumanWins.setText(Integer.toString(humanWins));
				          lblHumanSelect.setIcon(new ImageIcon(getClass().getResource("/paperAns.jpg")));	
							lblCompSelect.setIcon(new ImageIcon(getClass().getResource("/rockAns.jpg")));	
				      }
					if (event.getSource() == btnRock) {
				          ties+=1;
				          lblTieCount.setText(Integer.toString(ties));
				          lblHumanSelect.setIcon(new ImageIcon(getClass().getResource("/rockAns.jpg")));	
							lblCompSelect.setIcon(new ImageIcon(getClass().getResource("/rockAns.jpg")));	
				      }
					if (event.getSource() == btnScissors) {
				          compWins+=1;
				          lblCompWins.setText(Integer.toString(compWins));
				          lblHumanSelect.setIcon(new ImageIcon(getClass().getResource("/scissorsAns.jpg")));	
							lblCompSelect.setIcon(new ImageIcon(getClass().getResource("/rockAns.jpg")));	
				      }
					
					System.out.println(compMove);
					break;
					
					
				case 3:
								
					if (event.getSource() == btnRock) {
				          humanWins+=1;
				          lblHumanWins.setText(Integer.toString(humanWins));
				          lblHumanSelect.setIcon(new ImageIcon(getClass().getResource("/rockAns.jpg")));	
				          lblCompSelect.setIcon(new ImageIcon(getClass().getResource("/scissorsAns.jpg")));	
				      }
					if (event.getSource() == btnScissors) {
				          ties+=1;
				          lblTieCount.setText(Integer.toString(ties));
				          lblHumanSelect.setIcon(new ImageIcon(getClass().getResource("/scissorsAns.jpg")));	
				          lblCompSelect.setIcon(new ImageIcon(getClass().getResource("/scissorsAns.jpg")));	
				      }
					if (event.getSource() == btnPaper) {
				          compWins+=1;
				          lblCompWins.setText(Integer.toString(compWins));
				          lblHumanSelect.setIcon(new ImageIcon(getClass().getResource("/paperAns.jpg")));	
				          lblCompSelect.setIcon(new ImageIcon(getClass().getResource("/scissorsAns.jpg")));	
				      }
					
					break;
				}				
			}
				else { //if the round is over 5 
					
					if(compWins > humanWins && compWins > ties) { // checks if computer wins
					winner = ("computer");
					}
					else if(humanWins>ties){ //checks if user won
					winner = ("you");
					}
					else {
					winner = ("tie"); 
					}
					
					if (winner=="you"||winner=="computer") { //has a specified option dialogue if there is a winner
					if  (JOptionPane.showConfirmDialog(frame, "Game over, "+winner+ " won! Do you want to restart?", "Game Over!", 
							JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
						//if user inpum    t == yes, (exit) 
						System.exit(0);
					}
				}
					else {
						if (JOptionPane.showConfirmDialog(frame, "Game over, "+winner+ "! Do you want to restart?", "Game Over!", 
							JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
							System.exit(0);
						}
					}
					rounds=0;
					humanWins=0;
					compWins=0;
					ties=0;
					rounds=0;
					lblTieCount.setText("");
					lblCompWins.setText("");
					lblHumanWins.setText("");
					lblRoundNum.setText("<html><center>Press <br> rock, paper, or scissors to play</html>");
					lblCompSelect.setVisible(false);
					lblHumanSelect.setVisible(false);
					//reset once over 5 rounds
					
				}
			
			}
			};
			
			
		JLabel lblHuman = new JLabel("PLAY!!!!");
		lblHuman.setForeground(new Color(255, 255, 255));
		lblHuman.setFont(new Font("Sitka Display", Font.BOLD, 34));
		lblHuman.setBounds(0, 0, 420, 39);
		panelHuman.add(lblHuman);
	
		JLabel lblComp = new JLabel("<html>THE COMPUTER <br>HAS CHOSEN:</html>");
		lblComp.setForeground(new Color(255, 255, 255));
		lblComp.setFont(new Font("Sitka Display", Font.BOLD, 34));
		lblComp.setBounds(7, 0, 422, 75);
		panelComp.add(lblComp);
					
		btnRock = new JButton("ROCK");
		btnRock.setBounds(8, 53, 131, 117);
		panelHuman.add(btnRock);
		btnRock.addActionListener(moveButtons);
		btnRock.setIcon(new ImageIcon(getClass().getResource("/rock.jpg")));
		
		btnScissors = new JButton("SCISSORS");
		btnScissors.setBounds(278, 53, 132, 117);
		panelHuman.add(btnScissors);
		btnScissors.addActionListener(moveButtons);
		btnScissors.setIcon(new ImageIcon(getClass().getResource("/scissors.png")));
		
		btnPaper = new JButton("PAPER");
		btnPaper.setBounds(143, 53, 125, 117);
		panelHuman.add(btnPaper);
		btnPaper.addActionListener(moveButtons);
		btnPaper.setIcon(new ImageIcon(getClass().getResource("/paper.jpg")));
		
		
		lblHumanWins = new JLabel("");
		lblHumanWins.setHorizontalAlignment(SwingConstants.CENTER);
		lblHumanWins.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblHumanWins.setBounds(26, 85, 70, 87);
		panelScore.add(lblHumanWins);
		
		lblTieCount = new JLabel("");
		lblTieCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieCount.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblTieCount.setBounds(139, 88, 70, 84);
		panelScore.add(lblTieCount);
		
		lblCompWins = new JLabel("");
		lblCompWins.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompWins.setFont(new Font("Sitka Display", Font.BOLD, 30));
		lblCompWins.setBounds(249, 86, 63, 84);
		panelScore.add(lblCompWins);
		
		lblHumanSelect = new JLabel("");
		lblHumanSelect.setBounds(116, 232, 192, 279);
		panelHuman.add(lblHumanSelect);
		
		lblCompSelect = new JLabel("");
		lblCompSelect.setBounds(121, 229, 192, 279);
		panelComp.add(lblCompSelect);
			
		lblLeftWins = new JLabel("WINS");
		lblLeftWins.setFont(new Font("Courier New", Font.BOLD, 31));
		lblLeftWins.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeftWins.setVerticalAlignment(SwingConstants.TOP);
		lblLeftWins.setBounds(16, 39, 96, 36);
		panelScore.add(lblLeftWins);
		
		lblTies = new JLabel("TIES");
		lblTies.setForeground(new Color(255, 255, 255));
		lblTies.setFont(new Font("Courier New", Font.BOLD, 31));
		lblTies.setHorizontalAlignment(SwingConstants.CENTER);
		lblTies.setVerticalAlignment(SwingConstants.TOP);
		lblTies.setBounds(125, 39, 89, 36);
		panelScore.add(lblTies);
		
		lblRightWins = new JLabel("WINS");
		lblRightWins.setFont(new Font("Courier New", Font.BOLD, 31));
		lblRightWins.setHorizontalAlignment(SwingConstants.CENTER);
		lblRightWins.setVerticalAlignment(SwingConstants.TOP);
		lblRightWins.setBounds(231, 39, 96, 36);
		panelScore.add(lblRightWins);
		
		lblRoundNum = new JLabel("<html><center>Press <br> the rock, paper, or scissors to play. <br> First to 5 wins.</html>");
		lblRoundNum.setFont(new Font("Sitka Display", Font.BOLD, 29));
		lblRoundNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoundNum.setBounds(16, 335, 311, 161);
		panelScore.add(lblRoundNum);
		

	}
}

