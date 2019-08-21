package agent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;


public class AgentWithState extends Agent implements IAgentWithState{

	private IAgentState actual;
	private Map<String,IAgentState> estados = new HashMap<>();
	
	/**
	 * el constructor de agentes con estados
	 * @param estados un array de Strings. El primero sera el nombre del agente, el resto seran sus estados
	 */
	public AgentWithState(String... estados) {
		super(estados[0]);
		for(int i = 1; i < estados.length; i++){
			this.estados.put(estados[i], new State(estados[i]));
		}
		for(IAgentState st :this.estados.values()){
			st.setOwner(this);
		}
		if(estados.length > 1)
			this.actual = this.estados.get(estados[1]);
	}

	/* (non-Javadoc)
	 * @see agent.IAgentWithState#state(java.lang.String)
	 */
	@Override
	public IAgentState state(String name) {
		return this.estados.get(name);
	}

	/* (non-Javadoc)
	 * @see agent.IAgentWithState#addBehaviour(java.lang.String, java.util.function.Predicate, java.util.function.Function)
	 */
	@Override
	public IAgentWithState addBehaviour(String state, Predicate<IAgent> trigger,
			Function<IAgent, Boolean> behaviour) {
		IAgentState aux;
		aux = this.state(state);
		if(aux != null){
			aux.addBehaviour(trigger,behaviour);
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see agent.IAgentWithState#addBehaviour(java.lang.String, java.util.function.Function)
	 */
	@Override
	public IAgentWithState addBehaviour(String state, Function<IAgent, Boolean> behaviour) {
		IAgentState aux;
		aux = this.state(state);
		if(aux != null){
			aux.addBehaviour(behaviour);
		}
		return this;
	}
	
	/* (non-Javadoc)
	 * @see agent.Agent#copy()
	 */
	@Override
	public IAgent copy() {
		AgentWithState clone;
		IAgentState state;
		clone = new AgentWithState(this.getNombre());
		for(IAgentState st : this.estados.values()){
			state = st.copy();
			state.setOwner(clone);
			clone.estados.put(state.name(), state);
		}
		clone.actual = (IAgentState) clone.estados.values().toArray()[0] ;
		this.getCell().add(clone);
		clone.setCell(this.getCell());
		return clone;
	}
	
	
	/* (non-Javadoc)
	 * @see agent.Agent#exec()
	 */
	@Override
	public void exec() {
		this.actual.changeState();
		for (IAgentState estado : this.estados.values()) {
			estado.exec();
		}
	}


}
