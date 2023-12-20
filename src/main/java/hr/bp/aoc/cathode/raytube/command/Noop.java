package hr.bp.aoc.cathode.raytube.command;

import hr.bp.aoc.cathode.raytube.Clock;

/**
 * <p>Noop class.</p>
 *
 * @author Marko Krišković
 */
public class Noop implements Command {

	private Clock clock;

	public Noop(Clock clock) {
		this.clock = clock;
	}

	@Override
	public void execute() {
		clock.tick();
	}

}