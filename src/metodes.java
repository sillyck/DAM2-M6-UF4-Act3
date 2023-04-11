import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class metodes implements interficie {

	public void sumarArray(int[] arreglo) {
	    int suma = 0;
	    for (int i = 0; i < arreglo.length; i++) {
	        suma += arreglo[i];
	    }
	    System.out.println(suma);
	}
	
	public void raizCuadrada(double n) {
	    System.out.println(Math.sqrt(n));
	}


	public List<String> ordenarLlista(List<String> lista) {
		Collections.sort(lista);
		return lista;
	}
	
	public void obtenirDataHora() {
	    System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}
	
	public int maxim(int a, int b) {
	    return Math.max(a, b);
	}
	
	public int minim(int a, int b) {
	    return Math.min(a, b);
	}
	  
    public int generarNumeroRandom(int minimo, int maximo) {
        Random rand = new Random();
        return rand.nextInt(maximo - minimo + 1) + minimo;
    }
    
    public void decimalAFraccion(double decimal) {
        int precision = 1000000;
        int numerador = (int) (decimal * precision);
        int denominador = precision;
        int gcd = BigInteger.valueOf(numerador).gcd(BigInteger.valueOf(denominador)).intValue();
        System.out.println(numerador / gcd + "/" + denominador / gcd);
    }

    public void invertirText(String cadena) {
        StringBuilder builder = new StringBuilder(cadena);
        builder.reverse();
        System.out.println(builder);
    }
    
    public <T> List<T> eliminarElementosDuplicados(List<T> lista) {
        return lista.stream().distinct().collect(Collectors.toList());
    }

}
