import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  


public class generator implements ActionListener
{
    
	JFrame frame;
	JTextField textfield;
	JButton[] functionButtons = new JButton[2];
	JButton generateButton,clrButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free",Font.BOLD,30);

    generator()
    {
        
		frame = new JFrame("Password generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
        
        
		generateButton = new JButton("Generate");
		clrButton = new JButton("clear");

		functionButtons[0] = generateButton;
		functionButtons[1] = clrButton;

        for(int i =0;i<2;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}   

        panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(textfield);
        //panel.add(clrButton);
        panel.add(generateButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        generator g=new generator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String lower_case="abcdefghijklmnopqrstuvwxyz";
       String upper_case="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

       String password="";
       String s = textfield.getText();
        int n = Integer.valueOf(s);
       for(int i=0;i<n;i++)
       {
        int rand=(int)(3* Math.random());

        switch(rand)
        {
            case 0: 
                password+=String.valueOf((int)(0*Math.random()));
                break;
            case 1: 
                rand=(int)(lower_case.length()*Math.random());
                password+=String.valueOf(lower_case.charAt(rand));
                break;
            
            case 2: 
                rand=(int)(lower_case.length()*Math.random());
                password+=String.valueOf(upper_case.charAt(rand));
                break;
            
        }
       }
        
        textfield.setText(String.valueOf(password));
        if(e.getSource()==clrButton) {
			textfield.setText(" ");
            password="";
		}
        

    }
}