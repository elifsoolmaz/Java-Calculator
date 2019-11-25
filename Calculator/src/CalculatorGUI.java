
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI extends JFrame {
        private final int FRAME_WIDTH=300;
        private final int FRAME_HEIGHT=200;
        private final int FRAME_X=350;
        private final int FRAME_Y=300;

        private JPanel statusPanel=new JPanel(); //will be used to organize  output GUI components
        private JPanel inputPanel=new JPanel(); // will be used to organize  input GUI components
        private JPanel operatorsPanel= new JPanel(); // will be used to  organize operators (- + / * )

        private Container mainContainer;   //JFrame's content pane.  This will  be used to add subpanels

        private JButton addButton=new JButton("+");
        private JButton subButton=new JButton("-");
        private JButton multButton=new JButton("*");
        private JButton divButton=new JButton("/");

        JLabel input1Label=new JLabel("Input 1:");
        JLabel input2Label=new JLabel("Input 2:");
        JTextField inputField1=new JTextField("0",10);
        JTextField inputField2=new JTextField("0",10);

        JTextField outputText=new JTextField(15);
        public CalculatorGUI() {
                super("Simple Calculator");
                setSize(FRAME_WIDTH, FRAME_HEIGHT);
                setLocation(FRAME_X, FRAME_Y);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                mainContainer=this.getContentPane();
                FlowLayout flw=new FlowLayout();
                flw.setAlignment(FlowLayout.CENTER);
                mainContainer.setLayout(flw);
                prepareUI();

                setResizable(false);
                setVisible(true);
        }

        private void prepareUI() {
                //prepare panels
                //subpanel for inputs
                inputPanel.setLayout(new GridLayout(2, 2));
                inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Inputs"));


                inputPanel.add(input1Label);
                inputPanel.add(inputField1);

                inputPanel.add(input2Label);
                inputPanel.add(inputField2);

                mainContainer.add(inputPanel);
                mainContainer.add(inputPanel);




                //subpanel for operators
                operatorsPanel.setLayout(new FlowLayout());

                operatorsPanel.add(addButton);
                operatorsPanel.add(divButton);
                operatorsPanel.add(multButton);
                operatorsPanel.add(subButton);

                mainContainer.add(operatorsPanel);




                //subpanel for outputs
                statusPanel.setLayout(new FlowLayout());
                statusPanel.add(outputText);
                mainContainer.add(statusPanel);

                // register ActionListener to buttons

                EventHandler calcHandler=new EventHandler();

                addButton.addActionListener(calcHandler);
                divButton.addActionListener(calcHandler);
                subButton.addActionListener(calcHandler);
                multButton.addActionListener(calcHandler);


        }

        private class EventHandler implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {

                        if(e.getSource()==addButton){
                                double res = Double.parseDouble(inputField1.getText().toString()) + 
Double.parseDouble(inputField2.getText().toString());
                                outputText.setText(Double.toString(res));
                        }
                        else if(e.getSource()==subButton) {
                                double res = Double.parseDouble(inputField1.getText().toString()) - 
Double.parseDouble(inputField2.getText().toString());
                                outputText.setText(Double.toString(res));
                        }
                        else if(e.getSource()==multButton) {
                                double res = Double.parseDouble(inputField1.getText().toString()) * 
Double.parseDouble(inputField2.getText().toString());
                                outputText.setText(Double.toString(res));
                        }
                        else if(e.getSource()==divButton) {
                                double res = Double.parseDouble(inputField1.getText().toString()) / 
Double.parseDouble(inputField2.getText().toString());
                                outputText.setText(Double.toString(res));
                        }


                }

        }

        public static void main(String []args) {
                new CalculatorGUI();
        }

}