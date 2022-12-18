import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Consulta {
	
	public JsonObject consulta(String cnpj){
		JsonObject atributos = null;
		try {
			String url = "https://api-publica.speedio.com.br/buscarcnpj?cnpj=" + cnpj;
			Document doc = Jsoup.connect(url).get();
			Element body = doc.select("body").first();
			atributos = (JsonObject) JsonParser.parseString(body.text());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return atributos;
	}
	
}
