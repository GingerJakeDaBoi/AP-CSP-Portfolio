Jframe frame = new JFrame("Main window")

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

frame.pack();

frame.setVisible(true);
