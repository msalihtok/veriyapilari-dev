import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
//Mehmet Salih Tok 
//02185076032

public class test{
	public static void testHuffman(String orgStr, boolean show, String dotfilename){
		System.out.print("Huffman Algoritması ve Kod tablosu oluşturma...");
	    Huffman h = new Huffman(orgStr,show,dotfilename);
	    System.out.println("Tamamlandı... ");
	    
	    if (show){
			System.out.println("\n============= Kelime Sıklığı =============");
			for (Map.Entry<Character, Integer> entry: h.hmapWC.entrySet()){
				String key = entry.getKey().toString();
				int val = entry.getValue();
				if (key.equals("\n"))
					key = "\\n";
				System.out.println(key + " Oluşturuldu " + val + " kez ");
			}
			
			System.out.println("\n========== Her Karakter için Huffman Kodu =============");
			for (Map.Entry<Character, String> entry: h.hmapCode.entrySet()){
				String key = entry.getKey().toString();
				String val = entry.getValue();
				if (key.equals("\n"))
					key = "\\n";
				System.out.println(key + ": " + val); 
			}
			System.out.println();
		}
	    
	    System.out.print("Metni Kodlama...");
	    String e = h.encode();
	    System.out.println(" TAMAMLANDI ");
	    
	    System.out.print("* Kodlanmış metnin kodu çözülüyor...");
	    String d = h.decode();
	    myassert(orgStr.equals(d)) ;   // Check if original text and decoded text is exactly same
	    System.out.println(" TAMAMLANDI");
	    
	    double sl = orgStr.length() * 7 ;
	    double el = e.length();
	    System.out.println("\n========== SONUÇ ==========");
	    System.out.println("Belleğe dizin maaliyeti = " + (int)sl + " bit") ;
	    System.out.println("Kodlanmış Dizin maaliyeti= " + (int)el + " bit") ;
	    double r = ((el - sl)/sl) * 100 ;
	    System.out.println("% İndirgendi = " + (-r)) ;
	}
	
	public static String readFile(String fname){
		StringBuilder sb = new StringBuilder();
		File filename = new File(fname);
		try (BufferedReader in = new BufferedReader(new FileReader(filename))){
			String line = in.readLine();
			while (line != null){
				sb.append(line + "\n");
				line = in.readLine();
			}
		}
		catch (IOException e){
			System.out.println(e);
		}
		return sb.toString();
	}
	
  public static void myassert(boolean  x) {
	    if (!x) {
	    	throw new IllegalArgumentException("BAŞARISIZ") ;
	    }
  }
  
  public static void main(String[] args) {
	  System.out.println("----- Test BAŞLADI -----");
	  System.out.println("\n----- Test BİTTİ----- ");
  }
  
}