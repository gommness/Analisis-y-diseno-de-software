package agent;

import java.util.function.Function;
import java.util.function.Predicate;

import element.Cell;

public interface IAgent extends IBasicAgent{

/**
 * mueve el agente a una celda de destino
 * @param destination la celda de destino a la que se desea mover
 */
void moveTo(Cell destination); // Mover a una celda adyacente

/**
 * ejecuta el comportamiento del agente
 */
void exec(); // Ejecutar comportamiento del agente

/**
 * añade un comportamiento al agente
 * @param trigger la condicion para realizar el comportamiento
 * @param behaviour el comportamiento
 * @return se devuelve a si mismo
 */
IAgent addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour);

/**
 * añade un comportamiento al agente
 * @param behaviour el comportamiento a añadir
 * @return a si mismo
 */
IAgent addBehaviour(Function<IAgent, Boolean> behaviour);

IAgent copy(); // Realiza una copia del agente

}