package simulator;

public class ThreadSimulate extends Thread {
	
	Simulator sim;
	int steps;
	Controller controller;
	int count;
	public ThreadSimulate(Simulator sim, int steps, Controller controller){
		this.sim = sim;
		this.steps = steps;
		this.controller = controller;
	}
	
	
	
	
	public void run(){
		count = 0;
		try{
			for(int i=0; i<steps;i++){
				count += 1;
				System.out.println("Count: "+count);
				
				sim.simulateOneStep();
			}
		} catch (Exception e){
			System.out.println("Exception "+e+" opgevangen!");
		}
		controller.setButtonAvailable(true);
	}
}
