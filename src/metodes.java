import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.saxonica.xqj.SaxonXQDataSource;

public class metodes implements interficie {

	public XQResultSequence llegirXqy(String fitxer) throws XQException, IOException {

		InputStream inputStream = Files.newInputStream(new File(fitxer).toPath());
		XQDataSource ds = new SaxonXQDataSource();
		XQConnection conn = ds.getConnection();
		XQPreparedExpression exp = conn.prepareExpression(inputStream);
		XQResultSequence result = exp.executeQuery();

		return result;

	}

	public PrintWriter generarHtml(XQResultSequence result) throws XQException, FileNotFoundException {
		String xquery = "";
		while (result.next()) {
			xquery = result.getItemAsString(null);
		}
		PrintWriter out = new PrintWriter("resultat.html");
		out.println(xquery);

		return out;
	}

	public void llegirXml(String fitxer, String element, String node) throws FileNotFoundException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(fitxer));
			document.getDocumentElement().normalize();

			System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());

			NodeList persones = document.getElementsByTagName(element);
			for (int i = 0; i < persones.getLength(); i++) {
				Node perso = persones.item(i);

				if (perso.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) perso;
					System.out
							.print("Del node (" + node + ") el valor número " + i + ", és: " + getNodo(node, elemento));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getNodo(String etiqueta, Element elem) {
		NodeList node = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valornodo = (Node) node.item(0);
		return valornodo.getNodeValue();
	}

	public List<String> ordenarLlista(List<String> lista) {
		Collections.sort(lista);
		return lista;
	}
	
	public String obtenirDataHora() {
	    return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}
	
	public int maxim(int a, int b) {
	    return Math.max(a, b);
	}
	  
    public int generarNumeroRandom(int minimo, int maximo) {
        Random rand = new Random();
        return rand.nextInt(maximo - minimo + 1) + minimo;
    }
    
    public String decimalAFraccion(double decimal) {
        int precision = 1000000;
        int numerador = (int) (decimal * precision);
        int denominador = precision;
        int gcd = BigInteger.valueOf(numerador).gcd(BigInteger.valueOf(denominador)).intValue();
        return numerador / gcd + "/" + denominador / gcd;
    }

    public String invertirText(String cadena) {
        StringBuilder builder = new StringBuilder(cadena);
        builder.reverse();
        return builder.toString();
    }
    
    public <T> List<T> eliminarElementosDuplicados(List<T> lista) {
        return lista.stream().distinct().collect(Collectors.toList());
    }


}
