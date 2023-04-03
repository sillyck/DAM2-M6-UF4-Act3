import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQResultSequence;

public interface interficie {

	/**
	 * Aquest metode llegeix un fitxer XQY
	 * @param fitxer
	 * @return
	 * @throws XQException
	 * @throws IOException
	 */
	public abstract XQResultSequence llegirXqy(String fitxer) throws XQException, IOException;
	
	/**
	 * Aquest metode genera un Html
	 * @param result
	 * @return
	 * @throws XQException
	 * @throws FileNotFoundException
	 */
	public abstract PrintWriter generarHtml(XQResultSequence result) throws XQException, FileNotFoundException;
	
	/**
	 * Aquest metode llegeix un fitxer XML
	 * @param fitxer
	 * @param element
	 * @param node
	 * @throws FileNotFoundException
	 */
	public abstract void llegirXml(String fitxer, String element, String node) throws FileNotFoundException;
	
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
	public String obtenirDataHora();
	
	/**
	 * Aquest metode ens dira, de dos valora, quin es el numero mes gran
	 * @param a
	 * @param b
	 * @return
	 */
	public abstract int maxim(int primer, int segon);
	
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
	public abstract String decimalAFraccion(double decimal);
	
	/**
	 * Aquest metode ens demana una cadena i ens la retorna al revés
	 * @param cadena
	 * @return
	 */
	public abstract String invertirText(String cadena);
	
	/**
	 * Aquest metode ens permet eliminar els elements duplicats d'una llista
	 * @param <T>
	 * @param lista
	 * @return
	 */
	public abstract <T> List<T> eliminarElementosDuplicados(List<T> lista);
}
