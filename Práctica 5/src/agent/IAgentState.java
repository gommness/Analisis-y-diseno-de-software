package agent;

import java.util.function.*;

public interface IAgentState {
	 /**
	 * @return el nombre del estado
	 */
	String name();
	 /**
	 * asigna una condicion de cambio de estado, para ir al estado target
	 * @param target el estado al que cambiar
	 * @param trigger la condicion de cambio
	 */
	void toState(String target, Predicate<IAgent> trigger);
	 /**
	  * cambia su estado en funcion de si se cumple la condicion requerida
	 * @return a si mismo
	 */
	IAgentState changeState();
	 /**
	  * añade un comportamiento al estado
	 * @param trigger la condicion de ejecutar el comportamiento
	 * @param behaviour el comportamiento en cuestion
	 * @return el agente que realiza el comportamiento
	 */
	IAgentWithState addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour);
	 /**
	  * añade un comportamiento al estado
	 * @param behaviour el comportamiento en cuesiton
	 * @return el agente que realiza el comportamiento
	 */
	IAgentWithState addBehaviour(Function<IAgent, Boolean> behaviour);
	 /**
	 * ejecuta los comportamientos del estado
	 */
	void exec();
	 /**
	 * @param aws el owner a asignar
	 */
	void setOwner(IAgentWithState aws);
	 /**
	 * @return una copia del estado
	 */
	IAgentState copy();
	}