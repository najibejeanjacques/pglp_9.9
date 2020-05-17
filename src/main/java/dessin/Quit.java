package dessin;

public class Quit implements Command {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Commande Quit......");
		System.exit(0);
	}

}
