package agent;

import java.util.function.Function;
import java.util.function.Predicate;

public interface IAgentWithState extends IAgent {
	/**
	 * @param name el nombre de un estado
	 * @return el estado cuyo nombre coincide con name
	 */
	IAgentState state(String name);

	/**
	 * añade un comportamiento a un estado
	 * @param state el nombre del estado al que añadir un comportamiento
	 * @param trigger la condicion para cumplir el comportamiento
	 * @param behaviour el comportamiento
	 * @return a si mismo
	 */
	IAgentWithState addBehaviour(String state, Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour);

	/**
	 * añade un comportamiento a un estado
	 * @param state el nombre del estado al que añadir un comportamiento
	 * @param behaviour el comportamiento
	 * @return a si mismo
	 */
	IAgentWithState addBehaviour(String state, Function<IAgent, Boolean> behaviour);
}
