package dessin;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;

@FunctionalInterface
public interface Command {

	public void execute();

}