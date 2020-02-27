//instantiates panel

package main;

import javax.swing.JFrame;

public class App extends JFrame{

	private static final long serialVersionUID = 1L;

	public App(String title) {
		super(title);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLocation(0, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel(this);
		this.add(p); 
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main (String[] args){
		new App("The Room");
		
	}
}
