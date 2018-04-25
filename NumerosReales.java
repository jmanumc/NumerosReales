public class NumerosReales{
	
	public static void main(String [] ar){
		int a;
		System.out.println("< N. Real >: \n1.- <N. Real c/signo> \n2.- < N. Real s/signo >");
		System.out.println("Esperando...\n");
		a=Leer.datoInt();
		if(a==1){
			String cs = "<N. Real c/signo>";
			System.out.println("< N. Real c/signo>: \n1. +<N. Real s/signo> \n2. -< N. Real s/signo >");
			System.out.println("Esperando...\n");
			a=Leer.datoInt();

			if(a==1){
				String ntcs = "<N. Real c/signo>";
				System.out.println("< N. Real c/signo>: \n1. +<N. Real s/signo> \n2. -< N. Real s/signo >");	
			}else{
				String ntss = "<N. Real s/signo>";
				System.out.println("< N. Real s/signo>: \n1. <N. Real c/signo> \n2. < N. Real s/signo >");
			}	
		}else{
			String nss = "<N. Real s/signo>";
			System.out.println("< N. Real s/signo>: \n1. <N. Real c/signo> \n2. < N. Real s/signo >");
		}
	}
}