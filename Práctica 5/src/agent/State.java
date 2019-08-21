package agent;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import element.Pair;

public class State implements IAgentState {

	private String nombre;
	private IAgentWithState owner;
	private List<Pair<String, Predicate<IAgent>>> connections;
	private List<Pair<Predicate<IAgent>, Function<IAgent, Boolean>>> behaviours;

	/**
	 * constructor de estados
	 * @param name el nombre del estado a crear
	 */
	public State(String name) {
		this.nombre = name;
		this.connections = new LinkedList<>();
		this.behaviours = new LinkedList<>();
	}
	
	/* (non-Javadoc)
	 * @see agent.IAgentState#name()
	 */
	@Override
	public String name() {
		return this.nombre;
	}

	/* (non-Javadoc)
	 * @see agent.IAgentState#toState(java.lang.String, java.util.function.Predicate)
	 */
	@Override
	public void toState(String target, Predicate<IAgent> trigger) {
		this.connections.add(new Pair<>(target, trigger));
	}

	/* (non-Javadoc)
	 * @see agent.IAgentState#changeState()
	 */
	@Override
	public IAgentState changeState() {
		if (this.owner != null) {
			for (Pair<String, Predicate<IAgent>> par : this.connections) {
				if (par.second.test(this.owner) == true) {
					this.nombre = par.first;
					return this;
				}
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see agent.IAgentState#addBehaviour(java.util.function.Predicate, java.util.function.Function)
	 */
	@Override
	public IAgentWithState addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
		this.behaviours.add(new Pair<>(trigger, behaviour));
		return this.owner;
	}

	/* (non-Javadoc)
	 * @see agent.IAgentState#addBehaviour(java.util.function.Function)
	 */
	@Override
	public IAgentWithState addBehaviour(Function<IAgent, Boolean> behaviour) {
		this.behaviours.add(new Pair<>(agent -> true, behaviour));
		return this.owner;
	}

	/* (non-Javadoc)
	 * @see agent.IAgentState#exec()
	 */
	@Override
	public void exec() {
		boolean flag;
		if (this.owner != null) {
			for (Pair<Predicate<IAgent>, Function<IAgent, Boolean>> par : this.behaviours) {
				flag = false;
				if (par.first.test(this.owner) == true) {
					flag = par.second.apply(this.owner);
				}
				if (flag == false)
					break;
			}
		}
	}

	/* (non-Javadoc)
	 * @see agent.IAgentState#setOwner(agent.IAgentWithState)
	 */
	@Override
	public void setOwner(IAgentWithState aws) {
		this.owner = aws;
	}

	/* (non-Javadoc)
	 * @see agent.IAgentState#copy()
	 */
	@Override
	public IAgentState copy() {
		State other = new State(this.nombre);
		other.behaviours = this.behaviours;
		other.connections = this.connections;
		return other;
	}

}
