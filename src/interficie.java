import java.util.List;

public interface interficie {
	
	/**
	 * Aquest metode ens permet poder sumar un array de numeros
	 * @param arreglo
	 * @return
	 */
	public abstract void sumarArray(int[] arreglo);
	
	/**
	 * Aquest metode ens permet fer l'arrel quadrada d'un numero 
	 * @param n
	 * @return
	 */
	public void raizCuadrada(double n);
	
	/**
	 * Aquest metode ens ordenara una llista de Strings que tinguem
	 * @param lista
	 * @return
	 */
	public abstract List<String> ordenarLlista(List<String> lista);

	/**
	 * Aquest metode podem veure la data i la hora actual
	 * @return
	 */
	public void obtenirDataHora();
	
	/**
	 * Aquest metode ens dira, de dos valora, quin es el numero mes gran
	 * @param a
	 * @param b
	 * @return
	 */
	public abstract int maxim(int primer, int segon);
	
	/**
	 * Aquest metode ens dira, de dos valora, quin es el numero mes petit
	 * @param a
	 * @param b
	 * @return
	 */
	public abstract int minim(int primer, int segon);
	
	/**
	 * Aquest metode ens generarà un numero aleatori entre els dos valors que li passem per parametre
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	public abstract int generarNumeroRandom(int minimo, int maximo);
	
	/**
	 * Aquest metode ens passa d'un numero dacimal a fracció
	 * @param decimal
	 * @return
	 */
	public abstract void decimalAFraccion(double decimal);
	
	/**
	 * Aquest metode ens demana una cadena i ens la retorna al revés
	 * @param cadena
	 * @return
	 */
	public abstract void invertirText(String cadena);
	
	/**
	 * Aquest metode ens permet eliminar els elements duplicats d'una llista
	 * @param <T>
	 * @param lista
	 * @return
	 */
	public abstract <T> List<T> eliminarElementosDuplicados(List<T> lista);
}
