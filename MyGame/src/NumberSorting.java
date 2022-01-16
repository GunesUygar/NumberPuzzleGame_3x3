import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumberSorting extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JButton btnNewButton, btnNewButton_1, btnNewButton_2,btnNewButton_3, 
	btnNewButton_4, btnNewButton_5, btnNewButton_6, btnNewButton_7, btnNewButton_8,
	btnNewButton_9;
	
	private JLabel lblNewLabel;

	int zeroIndex=0, actionNum=0;
	char[][] Array=new char[3][3];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberSorting frame = new NumberSorting();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NumberSorting() 
	{
		
		setTitle("Number Sorting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ButtonListener());
		btnNewButton.setBounds(10, 11, 45, 30);
		btnNewButton.setActionCommand("Btn1");
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(67, 11, 45, 30);
		btnNewButton_1.addActionListener(new ButtonListener());
		btnNewButton_1.setActionCommand("Btn2");
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(122, 11, 45, 30);
		btnNewButton_2.addActionListener(new ButtonListener());
		btnNewButton_2.setActionCommand("Btn3");
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(10, 52, 45, 30);
		btnNewButton_3.addActionListener(new ButtonListener());
		btnNewButton_3.setActionCommand("Btn4");
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(67, 52, 45, 30);
		btnNewButton_4.addActionListener(new ButtonListener());
		btnNewButton_4.setActionCommand("Btn5");
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("");
		btnNewButton_5.setBounds(122, 52, 45, 30);
		btnNewButton_5.addActionListener(new ButtonListener());
		btnNewButton_5.setActionCommand("Btn6");
		contentPane.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("");
		btnNewButton_6.setBounds(10, 93, 45, 30);
		btnNewButton_6.addActionListener(new ButtonListener());
		btnNewButton_6.setActionCommand("Btn7");
		contentPane.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("");
		btnNewButton_7.setBounds(67, 93, 45, 30);
		btnNewButton_7.addActionListener(new ButtonListener());
		btnNewButton_7.setActionCommand("Btn8");
		contentPane.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("");
		btnNewButton_8.setBounds(122, 93, 45, 30);
		btnNewButton_8.addActionListener(new ButtonListener());
		btnNewButton_8.setActionCommand("Btn9");
		contentPane.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("Mixing");
		btnNewButton_9.setBounds(10, 134, 157, 23);
		btnNewButton_9.addActionListener(new ButtonListener());
		btnNewButton_9.setActionCommand("Mix");
		contentPane.add(btnNewButton_9);
		
		
		JTextArea txtrActionnNumber = new JTextArea();
		txtrActionnNumber.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrActionnNumber.setBackground(SystemColor.control);
		txtrActionnNumber.setText("Move\r\nNumber");
		txtrActionnNumber.setBounds(210, 35, 46, 38);
		txtrActionnNumber.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.add(txtrActionnNumber);
		
		lblNewLabel = new JLabel("00", SwingConstants.CENTER);
		lblNewLabel.setBounds(205, 80, 46, 14);
		contentPane.add(lblNewLabel);

		Initialization();
	}
	
	private void GameCheck()
	{
		int i=0;
		
		
		for(i=0;i<3;i++)
		{
			if(zeroIndex==9)
			{
				if(i==0) 
				{
					if(!btnNewButton.getText().equals("1") || !btnNewButton_1.getText().equals("2") || !btnNewButton_2.getText().equals("3") )
					{
						break;
					}
				}
				else if(i==1)
				{
					if(!btnNewButton_3.getText().equals("4") || !btnNewButton_4.getText().equals("5") || !btnNewButton_5.getText().equals("6") )
					{
						break;
					}
				}
				else
				{
					if(btnNewButton_6.getText().equals("7") || btnNewButton_7.getText().equals("8"))
					{
						JOptionPane.showMessageDialog(null, "Congratulation, \nYou finished the game with "+actionNum+" moves.");
					}
				}
			}
		}
	}
	
	private void Initialization()
	{
		CreateRandomNumbers();
		zeroIndex=zeroOrder();
		Array[(zeroIndex-1)/3][(zeroIndex-1)%3]=' ';
		NumberAssigment();
		actionNum=0;
	}
	
	private void CreateRandomNumbers()
	{
		Random rand = new Random();

		int i=0, j=0, upperBound=9, myNum, matchFlag=0;

		for(i=0;i<9;)
		{
			myNum=rand.nextInt(upperBound);
			for(j=0;j<i;j++)
			{
				if(Character.getNumericValue(Array[j/3][j%3])==myNum)
				{
					matchFlag=1;
					break;
				}
			}
			
			if(matchFlag!=1)
			{
				Array[i/3][i%3]=(char)(myNum+48);
				i++;
			}
		    matchFlag=0;
			//System.out.println("Current Num="+i);
		}
		
	}
	
	private void NumberAssigment() 
	{
		
		btnNewButton.setText(String.valueOf(Array[0][0]));
		btnNewButton_1.setText(String.valueOf(Array[0][1]));
		btnNewButton_2.setText(String.valueOf(Array[0][2]));
		btnNewButton_3.setText(String.valueOf(Array[1][0]));
		btnNewButton_4.setText(String.valueOf(Array[1][1]));
		btnNewButton_5.setText(String.valueOf(Array[1][2]));
		btnNewButton_6.setText(String.valueOf(Array[2][0]));
		btnNewButton_7.setText(String.valueOf(Array[2][1]));
		btnNewButton_8.setText(String.valueOf(Array[2][2]));
	}
	
	private int zeroOrder()
	{
		int i=0;
		
		for(i=0;i<9;i++)
		{
			if(Array[i/3][i%3]=='0')
			{
				break;
			}
		}
		return i+1;
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			String btnlabel= new String();
			
			if(command== "Btn1")
			{
				if(zeroIndex==4 || zeroIndex==2)
				{
					btnlabel=btnNewButton.getText();
					btnNewButton.setText(String.valueOf(" "));
					if(zeroIndex==4)
					{
						btnNewButton_3.setText(btnlabel);
					}
					else
					{
						btnNewButton_1.setText(btnlabel);
					}
					zeroIndex=1;
					actionNum++;
					lblNewLabel.setText(String.valueOf(actionNum));
					GameCheck();
				}
			}
			else if(command=="Btn2")
			{
				if(zeroIndex==1 || zeroIndex==3 || zeroIndex==5)
				{
					btnlabel=btnNewButton_1.getText();
					btnNewButton_1.setText(String.valueOf(" "));
					if(zeroIndex==1)
					{
						btnNewButton.setText(btnlabel);
					}
					else if(zeroIndex==3)
					{
						btnNewButton_2.setText(btnlabel);
					}
					else
					{
						btnNewButton_4.setText(btnlabel);
					}
					zeroIndex=2;
					actionNum++;
					lblNewLabel.setText(String.valueOf(actionNum));
					GameCheck();
				}
			}
			else if(command=="Btn3")
			{
				if(zeroIndex==2 || zeroIndex==6)
				{
					btnlabel=btnNewButton_2.getText();
					btnNewButton_2.setText(String.valueOf(" "));
					if(zeroIndex==2)
					{
						btnNewButton_1.setText(btnlabel);
					}
					else
					{
						btnNewButton_5.setText(btnlabel);
					}
					zeroIndex=3;
					actionNum++;
					lblNewLabel.setText(String.valueOf(actionNum));
					GameCheck();
				}
			}
			else if(command=="Btn4")
			{
				if(zeroIndex==1 || zeroIndex==7 || zeroIndex==5)
				{
					btnlabel=btnNewButton_3.getText();
					btnNewButton_3.setText(String.valueOf(" "));
					if(zeroIndex==1)
					{
						btnNewButton.setText(btnlabel);
					}
					else if(zeroIndex==5)
					{
						btnNewButton_4.setText(btnlabel);
					}
					else
					{
						btnNewButton_6.setText(btnlabel);
					}
					zeroIndex=4;
					actionNum++;
					lblNewLabel.setText(String.valueOf(actionNum));
					GameCheck();
				}
			}
			else if(command=="Btn5")
			{
				if(zeroIndex==2 || zeroIndex==4 || zeroIndex==6 || zeroIndex==8)
				{
					btnlabel=btnNewButton_4.getText();
					btnNewButton_4.setText(String.valueOf(" "));
					if(zeroIndex==2)
					{
						btnNewButton_1.setText(btnlabel);
					}
					else if(zeroIndex==4)
					{
						btnNewButton_3.setText(btnlabel);
					}
					else if(zeroIndex==6)
					{
						btnNewButton_5.setText(btnlabel);
					}
					else
					{
						btnNewButton_7.setText(btnlabel);
					}
					zeroIndex=5;
					actionNum++;
					lblNewLabel.setText(String.valueOf(actionNum));
					GameCheck();
				}
			}
			else if(command=="Btn6")
			{
				if(zeroIndex==3 || zeroIndex==5 || zeroIndex==9)
				{
					btnlabel=btnNewButton_5.getText();
					btnNewButton_5.setText(String.valueOf(" "));
					if(zeroIndex==3)
					{
						btnNewButton_2.setText(btnlabel);
					}
					else if(zeroIndex==5)
					{
						btnNewButton_4.setText(btnlabel);
					}
					else
					{
						btnNewButton_8.setText(btnlabel);
					}
					zeroIndex=6;
					actionNum++;
					lblNewLabel.setText(String.valueOf(actionNum));
					GameCheck();
				}
			}
			else if(command=="Btn7")
			{
				if(zeroIndex==4 || zeroIndex==8)
				{
					btnlabel=btnNewButton_6.getText();
					btnNewButton_6.setText(String.valueOf(" "));
					if(zeroIndex==4)
					{
						btnNewButton_3.setText(btnlabel);
					}
					else
					{
						btnNewButton_7.setText(btnlabel);
					}
					zeroIndex=7;
					actionNum++;
					lblNewLabel.setText(String.valueOf(actionNum));
					GameCheck();
				}
			}
			else if(command=="Btn8")
			{
				if(zeroIndex==5 || zeroIndex==7 || zeroIndex==9)
				{
					btnlabel=btnNewButton_7.getText();
					btnNewButton_7.setText(String.valueOf(" "));
					if(zeroIndex==5)
					{
						btnNewButton_4.setText(btnlabel);
					}
					else if(zeroIndex==7)
					{
						btnNewButton_6.setText(btnlabel);
					}
					else
					{
						btnNewButton_8.setText(btnlabel);
					}
					zeroIndex=8;
					actionNum++;
					lblNewLabel.setText(String.valueOf(actionNum));
					GameCheck();
				}
			}
			else if(command=="Btn9")
			{
				if(zeroIndex==6 || zeroIndex==8)
				{
					btnlabel=btnNewButton_8.getText();
					btnNewButton_8.setText(String.valueOf(" "));
					if(zeroIndex==6)
					{
						btnNewButton_5.setText(btnlabel);
					}
					else
					{
						btnNewButton_7.setText(btnlabel);
					}
					actionNum++;
					zeroIndex=9;
					lblNewLabel.setText(String.valueOf(actionNum));
					GameCheck();
				}
			}
			else if(command=="Mix")
			{
				Initialization();
				lblNewLabel.setText(String.valueOf(actionNum));
			}
		}
	}
}
