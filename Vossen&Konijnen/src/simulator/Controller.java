package simulator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private Simulator sim;
	private boolean buttonAvailable = true;
	
	
	public Controller(Simulator sim) {
		this.sim = sim;
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(buttonAvailable){
			setButtonAvailable(false);
			switch(e.getActionCommand()){
				case "1 Step": System.out.println("You pressed '1 Step'.");
				Thread t1 = new ThreadSimulate(sim,1, this);
				t1.start();
				break;
				case "100 Steps": System.out.println("You pressed '100 Steps'.");
				Thread t100 = new ThreadSimulate(sim,100, this);
				t100.start();
				break;
			}
		} else {
			
			System.out.println("Er is al een simulatie geactiveerd.");
		}
	}

	
	public void setButtonAvailable(boolean available){
		buttonAvailable = available;
	}

	
	
}
