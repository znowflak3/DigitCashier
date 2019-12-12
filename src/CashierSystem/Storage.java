package CashierSystem;

import java.util.ArrayList;

//import direkt.Product;

public class Storage {
	
	public static ArrayList<Product> productsInStorage;
	public XMLTool xmlTool;
	
	public Storage()
	{
		  productsInStorage = new ArrayList<Product>();  
		  xmlTool = new XMLTool();
//		CreateTestStorage();
	}
	
//	private void CreateTestStorage()
//	{
//		  productsInStorage = new ArrayList<Product>();
//		  
//		  productsInStorage.add(new Product(00, "oxfile", 1, 250.50, 10, false, ProductType.KÖTT_FÅGEL_FISK));
//		  productsInStorage.add(new Product(01, "ryggbiff", 1, 189.90, 10, false, ProductType.KÖTT_FÅGEL_FISK));
//		  productsInStorage.add(new Product(02, "fläskfile", 1, 790.90, 10, false, ProductType.KÖTT_FÅGEL_FISK));
//		  productsInStorage.add(new Product(03, "revben", 1.5, 95.50, 10, false, ProductType.KÖTT_FÅGEL_FISK));
//		  productsInStorage.add(new Product(04, "lamstek", 1, 200.50, 10, false, ProductType.KÖTT_FÅGEL_FISK));
//		  productsInStorage.add(new Product(05, "nötfärs", 1, 79.90, 10, false, ProductType.KÖTT_FÅGEL_FISK ));
//		  productsInStorage.add(new Product(06, "kycklingfile", 1, 129.90, 10, false, ProductType.KÖTT_FÅGEL_FISK));
//		  productsInStorage.add(new Product(07, "anka", 1, 220.50, 10, false, ProductType.KÖTT_FÅGEL_FISK));
//		  productsInStorage.add(new Product(8, "lax", 1, 99.90, 10, false, ProductType.KÖTT_FÅGEL_FISK));
//		  productsInStorage.add(new Product(9, "makrill", 0.74, 69.90, 10, false, ProductType.KÖTT_FÅGEL_FISK));
//		  productsInStorage.add(new Product(10, "röd mjölk", 1.5, 12.90, 10, false, ProductType.MEJERI_OST_ÄGG));
//		  productsInStorage.add(new Product(11, "grön mjöl", 1.5, 12.90, 10, false, ProductType.MEJERI_OST_ÄGG));
//		  productsInStorage.add(new Product(12, "blå mjölk", 1.5, 13.10, 10, false, ProductType.MEJERI_OST_ÄGG));
//		  productsInStorage.add(new Product(13, "fil", 1, 15.50, 10, false, ProductType.MEJERI_OST_ÄGG));
//		  productsInStorage.add(new Product(14, "yoghurt", 1, 16.10, 10, false, ProductType.MEJERI_OST_ÄGG));
//		  productsInStorage.add(new Product(15, "herrgårds ost", 1, 79.90, 10, false, ProductType.MEJERI_OST_ÄGG));
//		  productsInStorage.add(new Product(16, "greve ost", 1, 79.90, 10, false, ProductType.MEJERI_OST_ÄGG));
//		  productsInStorage.add(new Product(17, "präst ost", 1, 79.90, 10, false, ProductType.MEJERI_OST_ÄGG));
//		  productsInStorage.add(new Product(18, "6-pack ägg", 0, 16.50, 10, false, ProductType.MEJERI_OST_ÄGG));
//		  productsInStorage.add(new Product(19, "12-pack ägg", 0, 29.90, 10, false, ProductType.MEJERI_OST_ÄGG));
//		  productsInStorage.add(new Product(20, "gul lök", 1, 3.90, 50, true, ProductType.FRUKT_GRÖNT));
//		  productsInStorage.add(new Product(21, "kvist tomat", 1, 24.90, 50, true, ProductType.FRUKT_GRÖNT));
//		  productsInStorage.add(new Product(22, "svensk gurka", 1, 15.90, 50, true, ProductType.FRUKT_GRÖNT));
//		  productsInStorage.add(new Product(23, "isbergssallad", 1, 14.90, 50, true, ProductType.FRUKT_GRÖNT)); 
//		  productsInStorage.add(new Product(24, "fast potatis", 1, 3.90, 50, true, ProductType.FRUKT_GRÖNT)); 
//		  productsInStorage.add(new Product(25, "söt potatis", 1, 34.40, 50, true, ProductType.FRUKT_GRÖNT));
//		  productsInStorage.add(new Product(26, "röda äpplen", 1, 24.90, 50, true, ProductType.FRUKT_GRÖNT));
//		  productsInStorage.add(new Product(27, "päron", 1, 19.90, 50, true, ProductType.FRUKT_GRÖNT));
//		  productsInStorage.add(new Product(28, "apelsin", 1, 15.50, 50, true, ProductType.FRUKT_GRÖNT));
//		  productsInStorage.add(new Product(29, "clementiner", 1, 13.90, 50, true, ProductType.FRUKT_GRÖNT));
//		  productsInStorage.add(new Product(30, "frallor", 0, 8.00, 10, false, ProductType.BRÖD_KAKOR));
//		  productsInStorage.add(new Product(31, "baguetter", 0, 13.00, 10, false, ProductType.BRÖD_KAKOR));
//		  productsInStorage.add(new Product(32, "bröd limpa", 0, 28.90, 10, false, ProductType.BRÖD_KAKOR));
//		  productsInStorage.add(new Product(33, "wasa knäckebröd", 0, 12.90, 10, false, ProductType.BRÖD_KAKOR));
//		  productsInStorage.add(new Product(34, "frukost knäckebröd", 0, 18.90, 10, false, ProductType.BRÖD_KAKOR));
//		  productsInStorage.add(new Product(35, "ballerina", 0, 12.90, 10, false, ProductType.BRÖD_KAKOR));
//		  productsInStorage.add(new Product(36, "maryland cookies", 0, 24.40, 10, false, ProductType.BRÖD_KAKOR));
//		  productsInStorage.add(new Product(37, "diggestive", 0, 9.90, 10, false, ProductType.BRÖD_KAKOR));
//		  productsInStorage.add(new Product(38, "smörgås rån", 0, 24.50, 10, false, ProductType.BRÖD_KAKOR));
//		  productsInStorage.add(new Product(39, "ris kakor", 0, 15.90, 10, false, ProductType.BRÖD_KAKOR));
//		  productsInStorage.add(new Product(40, "fryst ärtor", 0, 14.10, 10, false, ProductType.FRYST));
//		  productsInStorage.add(new Product(41, "frysta Broccoli", 1, 16.50, 10, false, ProductType.FRYST));
//		  productsInStorage.add(new Product(42, "paj", 0, 36.50, 10, false, ProductType.FRYST));
//		  productsInStorage.add(new Product(43, "gorbyspiroger 10-pack", 0, 79.90, 10, false, ProductType.FRYST));
//		  productsInStorage.add(new Product(44, "billys panpizza orginal 10-pack", 0, 89.90, 10, false, ProductType.FRYST));
//		  productsInStorage.add(new Product(45, "gorbyspirog", 0, 10.00, 10, false, ProductType.FRYST));
//		  productsInStorage.add(new Product(46, "billyspanpizza hawaii", 0, 11.50, 10, false, ProductType.FRYST));
//		  productsInStorage.add(new Product(47, "kebabflan", 1, 65.90, 10, false, ProductType.FRYST));
//		  productsInStorage.add(new Product(48, "american panpizza", 0, 40.50, 10, false, ProductType.FRYST));
//		  productsInStorage.add(new Product(49, "färdig mat", 0, 49.90, 10, false, ProductType.FRYST));
//		  productsInStorage.add(new Product(50, "snabb mackaroner", 1.5, 14.60, 10, false, ProductType.SKAFFERI));
//		  productsInStorage.add(new Product(51, "bakpulver", 0, 12.50, 10, false, ProductType.SKAFFERI));
//		  productsInStorage.add(new Product(52, "spaghetti", 1, 9.90, 10, false, ProductType.SKAFFERI));  
//		  productsInStorage.add(new Product(53, "strösocker", 2, 20.50, 10, false, ProductType.SKAFFERI));
//		  productsInStorage.add(new Product(54, "vetemjöl", 2, 21.90, 10, false, ProductType.SKAFFERI));
//		  productsInStorage.add(new Product(55, "rågsikt", 1.5, 26.70, 10, false, ProductType.SKAFFERI));
//		  productsInStorage.add(new Product(56, "konservchampinjoner", 0, 3.90, 10, false, ProductType.SKAFFERI));
//		  productsInStorage.add(new Product(57, "ströbröd", 0.5, 20.50, 10, false, ProductType.SKAFFERI));
//		  productsInStorage.add(new Product(58, "konservbönor", 0.5, 3.90, 10, false, ProductType.SKAFFERI));
//		  productsInStorage.add(new Product(59, "3-pack sås", 0, 24.50, 10, false, ProductType.SKAFFERI));
//}
	}
	