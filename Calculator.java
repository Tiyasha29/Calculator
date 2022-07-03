import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//contains ActionListener interface
class Calculator implements ActionListener
{
    JFrame frame;
    JTextField textField;
    JButton numberButtons[]=new JButton[10];
    JButton operationButtons[]=new JButton[9];
    JButton addButton,subButton,mulButton,divButton,deciButton,equalButton,delButton,clrButton,negButton;
    JPanel panel;
    Font myFont=new Font("Verdana",Font.BOLD,30);
    double num1=0,num2=0,res=0;
    char operator;
    Calculator()
    {
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        
        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);
        
        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        deciButton=new JButton(".");
        equalButton=new JButton("=");
        delButton=new JButton("DEL");
        clrButton=new JButton("CLR");
        negButton=new JButton("(-)");
        
        operationButtons[0]=addButton;
        operationButtons[1]=subButton;
        operationButtons[2]=mulButton;
        operationButtons[3]=divButton;
        operationButtons[4]=deciButton;
        operationButtons[5]=equalButton;
        operationButtons[6]=delButton;
        operationButtons[7]=clrButton;
        operationButtons[8]=negButton;
        
        for(int i=0;i<9;i++)
        {
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFont(myFont);
            operationButtons[i].setFocusable(false);
        }
        for(int i=0;i<10;i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false); //doesn't display the border after being clicked
        }
        
        negButton.setBounds(50,430,100,50); //x,y,width,height
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        
        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        //panel.setBackground(Color.GRAY);
        
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);
        panel.add(deciButton);
        panel.add(numberButtons[0]);
        panel.add(deciButton);
        panel.add(equalButton);
        panel.add(divButton);
        
        
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==deciButton)
        {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==subButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==mulButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==divButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==equalButton)
        {
            num2=Double.parseDouble(textField.getText());
            switch(operator)
            {
                case '+': res=num1+num2;break;
                case '-': res=num1-num2;break;
                case '*': res=num1*num2;break;
                case '/': res=num1/num2;break;
            }
            textField.setText(String.valueOf(res));
            num1=res;
        }
        if(e.getSource()==clrButton)
        {
            textField.setText("");
        }
        if(e.getSource()==delButton)
        {
            String s=textField.getText();
            textField.setText(s.substring(0,s.length()-1));
        }
        if(e.getSource()==negButton)//type the number first and then click on negButton to make the number negative
        {
            double temp=Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
    public static void main(String args[])
    {
        Calculator calc=new Calculator();
    }
}