Jframe frame = new JFrame("Main window")

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

frame.pack();

frame.setVisible(true);

JButton b= new jBontton("System Resources");
b.addActionListener(new ActionListener()

{

@Override
public void ActionPerformed(actionEvent e){

//this is what botton do
}


});