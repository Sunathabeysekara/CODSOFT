import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Quize implements ActionListener{

	//questions creating sample 	questions
	String[] questions= {"What is the largest ocean ?.",
						"Who painted Monalisa ?.",
						"Which chess piece diagonaly move ?.",
						"What is national flower of india ?.",
						"Highest populated country ?."};
	
	//answers for each questions sample answers
	String[][] options = {{"Atlantic Ocean","Antarctic Ocean","Pacific Ocean","Indian Ocean"},
							{"Picasso","Salvador Dali","Mr.Bean","Leonardo Da Vinci"},
							{"King","Rook","Bishop","Knight"},
							{"Lotus","Sunflower","Rose","Daisey"},
							{"USA","India","China","Australia"},
						  };
	
	//answers from answers correct answer set
	char[] answers= {'C','D','C','A','C'};
	
	char guesses;
	char answer;
	int index;
	int number_of_correct=0;
	int total_qeusttions=questions.length;
	int result;
	int seconds=10;
	
	JFrame frame=new JFrame();
	JTextField textfield=new JTextField();
	JTextArea textarea=new JTextArea();
	JButton btnA=new JButton();
	JButton btnB=new JButton();
	JButton btnC=new JButton();
	JButton btnD=new JButton();
	JLabel andwer_labelA=new JLabel();
	JLabel andwer_labelB=new JLabel();
	JLabel andwer_labelC=new JLabel();
	JLabel andwer_labelD=new JLabel();
	JLabel time_label=new JLabel();
	JLabel seconds_left=new JLabel();
	
	
	Timer timer=new Timer(1000,new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
		}
		
	});	
	JTextField number_right=new JTextField();
	JTextField percentage=new JTextField();
	
	
	public Quize(){
		
		frame.setSize(615,615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(null);
	
	
		frame.getContentPane().setBackground(new Color(50,50,48));
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,22));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,0,650,50);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(0,255,0));
		textarea.setFont(new Font("Ink Free",Font.BOLD,22));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		btnA.setBounds(0,100,100,100);
		btnA.setFont(new Font("MV Boli",Font.BOLD,35));
		btnA.setFocusable(false);
		btnA.addActionListener(this);
		btnA.setText("A");
		
		btnB.setBounds(0,200,100,100);
		btnB.setFont(new Font("MV Boli",Font.BOLD,35));
		btnB.setFocusable(false);
		btnB.addActionListener(this);
		btnB.setText("B");
		
		btnC.setBounds(0,300,100,100);
		btnC.setFont(new Font("MV Boli",Font.BOLD,35));
		btnC.setFocusable(false);
		btnC.addActionListener(this);
		btnC.setText("C");
		
		btnD.setBounds(0,400,100,100);
		btnD.setFont(new Font("MV Boli",Font.BOLD,35));
		btnD.setFocusable(false);
		btnD.addActionListener(this);
		btnD.setText("D");
		
		andwer_labelA.setBounds(125,100,500,100);
		andwer_labelA.setBackground(new Color(50,50,50));
		andwer_labelA.setForeground(new Color(25,255,0));
		andwer_labelA.setFont(new Font("MV BLI",Font.PLAIN,35));
		
		andwer_labelB.setBounds(125,200,500,100);
		andwer_labelB.setBackground(new Color(50,50,50));
		andwer_labelB.setForeground(new Color(25,255,0));
		andwer_labelB.setFont(new Font("MV BLI",Font.PLAIN,35));
		
		andwer_labelC.setBounds(125,300,500,100);
		andwer_labelC.setBackground(new Color(50,50,50));
		andwer_labelC.setForeground(new Color(25,255,0));
		andwer_labelC.setFont(new Font("MV BLI",Font.PLAIN,35));
		
		andwer_labelD.setBounds(125,400,500,100);
		andwer_labelD.setBackground(new Color(50,50,50));
		andwer_labelD.setForeground(new Color(25,255,0));
		andwer_labelD.setFont(new Font("MV BLI",Font.PLAIN,35));
		
		
		seconds_left.setBounds(500,510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(225,0,0));
		seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		
		time_label.setBounds(535,475,10,25);
		time_label.setBackground(new Color(225,50,50));
		time_label.setForeground(new Color(225,0,0));
		time_label.setFont(new Font("Ink Free",Font.BOLD,16));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("timer >:D");
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,225,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		
		percentage.setBounds(200,205,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,225,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		
		
		//frame.add(number_right);
		//frame.add(percentage);
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(andwer_labelA);
		frame.add(andwer_labelB);
		frame.add(andwer_labelC);
		frame.add(andwer_labelD);
		frame.add(btnA);
		frame.add(btnB);
		frame.add(btnC);
		frame.add(btnD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		nextQuestion();
	}
	
	public void nextQuestion(){
		if(index>=total_qeusttions) {
			results();
		}else {
			textarea.setText(questions[index]);
			andwer_labelA.setText(options[index][0]);
			andwer_labelB.setText(options[index][1]);
			andwer_labelC.setText(options[index][2]);
			andwer_labelD.setText(options[index][3]);
			timer.start();
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btnA.setEnabled(false);
		btnB.setEnabled(false);
		btnC.setEnabled(false);
		btnD.setEnabled(false);
		
		if(e.getSource()==btnA) {
			answer='A';
			if(answer==answers[index]) {
				guesses++;
			}
		}
		if(e.getSource()==btnB) {
			answer='B';
			if(answer==answers[index]) {
				guesses++;
			}
		}
		if(e.getSource()==btnC) {
			answer='C';
			if(answer==answers[index]) {
				guesses++;
			}
		}
		if(e.getSource()==btnD) {
			answer='D';
			if(answer==answers[index]) {
				guesses++;
			}
		}
		displayAnswer();
		}
	public void displayAnswer() {
		
		timer.stop();
		btnA.setEnabled(false);
		btnB.setEnabled(false);
		btnC.setEnabled(false);
		btnD.setEnabled(false);
		
		if(answers[index]!='A') {
			andwer_labelA.setForeground(new Color(225,0,0));
		}
		if(answers[index]!='B') {
			andwer_labelB.setForeground(new Color(225,0,0));
		}
		if(answers[index]!='C') {
			andwer_labelC.setForeground(new Color(225,0,0));
		}
		if(answers[index]!='D') {
			andwer_labelD.setForeground(new Color(225,0,0));
		}
		Timer pause=new Timer(2000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				andwer_labelA.setForeground(new Color(25,225,0));
				andwer_labelB.setForeground(new Color(25,225,0));
				andwer_labelC.setForeground(new Color(25,225,0));
				andwer_labelD.setForeground(new Color(25,225,0));
				
				
				answer =' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				btnA.setEnabled(true);
				btnB.setEnabled(true);
				btnC.setEnabled(true);
				btnD.setEnabled(true);
				index++;
				nextQuestion();
			}
			
		});
		pause.setRepeats(false);
		pause.start();
	}

	public void results() {
		btnA.setEnabled(false);
		btnB.setEnabled(false);
		btnC.setEnabled(false);
		btnD.setEnabled(false);
		
		result=(int)((guesses/(double)total_qeusttions)*100);
		
		textfield.setText("Result");
		textarea.setText("");
		andwer_labelA.setText("");
		andwer_labelB.setText("");
		andwer_labelC.setText("");
		andwer_labelD.setText("");
		
		number_right.setText("("+guesses+"/"+total_qeusttions+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		
	}
}
