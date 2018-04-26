 import java.io.*;
 public class Leer{
	
		static String dato(){
			String sdato ="";
			try{
				InputStreamReader isr= new InputStreamReader(System.in);
				BufferedReader FlujoE = new BufferedReader(isr);
				sdato=FlujoE.readLine();
			}
			catch(IOException e){
				System.err.println("Errors: "+ e.getMessage());
			}
			return sdato;
		}
		static short datosShort(){
			try{
				return Short.parseShort(dato());
			}catch (NumberFormatException e){
				return Short.MIN_VALUE;
			}
		}
		static int datoInt(){
			try{
				return Integer.parseInt(dato());
			}catch(NumberFormatException e){
				return Integer.MIN_VALUE;
			}
		}
		static double datoDouble(){
			try{
				return Double.parseDouble(dato());
			}catch(NumberFormatException e){
				return Double.NaN;
			}
		}
		static float datoFloat(){
			try{
				return Float.parseFloat(dato());
			}catch (NumberFormatException e){
				return Float.NaN;
			}
		}
	
		static long datoLong(){
			try{
				return Long.parseLong(dato());
			}catch(NumberFormatException e){
				return Long.MIN_VALUE;
			}
		}
	}
	