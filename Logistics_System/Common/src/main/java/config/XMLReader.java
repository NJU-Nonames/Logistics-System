package config;
import java.io.File;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author Martin3000
 * 
 */
public class XMLReader {
	// 配置文件名
	private static String filename = "src/main/resources/config.xml";
	private static IPconfig ipconfig;
	private static JDBCconfig jdbcconfig;
    private static Repertoryconfig repertoryconfig;
	
	/**
	 * 从配置文件中读取参数并保存到Config类中,
	 * 很多时候程序中会多次使用到配置中的参数, 
	 * 于是设置成静态方法,读取一次后就一直保存其中的参数，
	 * 不再反复读取
	 * 
	 * @return
	 */
	public static IPconfig loadipconfig() {
		if (ipconfig == null)
			ipconfig = getconfig();
		return ipconfig;
	}
	
	public static JDBCconfig loadjdbcconfig(){
		if(jdbcconfig == null)
			jdbcconfig = getjdbcconfig();
		return jdbcconfig;
	}
	
	public static Repertoryconfig loadrepertoryconfig(){
		if(repertoryconfig==null)
			repertoryconfig=getrepertoryconfig();
		return repertoryconfig;
		
	}
	
	private static Repertoryconfig getrepertoryconfig(){
		Repertoryconfig config = new Repertoryconfig();
		try {
			File f = new File(filename);
			if (!f.exists()) {
				System.out.println("  Error : IPConfig file doesn't exist!");
				System.exit(1);
			}
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			Element data;
			Iterator<?> itr = root.elementIterator("Repertoryconfig");
			data = (Element) itr.next();

			config.capacity = Integer.parseInt(data.elementText("capacity").trim());
			config.percent = Double.parseDouble(data.elementText("percent").trim());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return config;
	}

	private static IPconfig getconfig() {
		IPconfig config = new IPconfig();
		try {
			File f = new File(filename);
			if (!f.exists()) {
				System.out.println("  Error : IPConfig file doesn't exist!");
				System.exit(1);
			}
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			Element data;
			Iterator<?> itr = root.elementIterator("IPconfig");
			data = (Element) itr.next();

			config.IP = data.elementText("IPaddress").trim();
			config.PORT = data.elementText("Port").trim();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return config;

	}
    
    private static JDBCconfig getjdbcconfig(){
    	JDBCconfig config = new JDBCconfig();
		try {
			File f = new File(filename);
			if (!f.exists()) {
				System.out.println("  Error : JDBCConfig file doesn't exist!");
				System.exit(1);
			}
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			Element data;
			Iterator<?> itr = root.elementIterator("JDBCconfig");
			data = (Element) itr.next();

			
			config.port = data.elementText("Port").trim();
			config.name = data.elementText("Name").trim();
			config.admin = data.elementText("Admin").trim();
			config.password = data.elementText("Password").trim();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return config;
    }
}

