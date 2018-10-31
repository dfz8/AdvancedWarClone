package utils;

/**
 * This interface defines what methods are necessary for parts of the game that can be controlled by state values.
 * @param <E> The class of the object that can be defined by a state.
 */
public interface Stateful<E> {
  String serialize();

  E deserialize(StringInputTokenizer tokenizer) throws Exception;

  E clone();
}
