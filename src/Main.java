import data.ListOfPrices;
import data.ListOfTitlesAndUrls;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static parsing.DownloadingResults.downloadingRes;

public class Main{
    public static void mainParsing() throws IOException {
        List<ListOfTitlesAndUrls> firstList = new ArrayList<>();
        List<ListOfPrices> secondList = new ArrayList<>();

        Document doc = Jsoup.connect("https://www.booklya.ua/books/java-j-yazyki-programmirovaniya-981/").get();

        Elements Elems1 = doc.getElementsByAttributeValue("class" , "goodsItem-t");
        Elements Elems2 = doc.getElementsByAttributeValue("itemprop" , "price");

        Elems1.forEach(Elem -> {
            Element elem1 = Elem;
            String url = elem1.attr("href");
            String name = elem1.text();
            firstList.add(new ListOfTitlesAndUrls(name , url));
        });

        Elems2.forEach(Elem -> {
            Element elem2 = Elem;
            String price = elem2.text();
            secondList.add(new ListOfPrices(price));
        });
        showRes(firstList ,secondList);
        downloadingRes(firstList ,secondList);
    }

    public static void showRes(List<ListOfTitlesAndUrls> firstList, List<ListOfPrices> secondList){
        for(int i = 0; i<firstList.size(); i++){
            System.out.println("title: " + firstList.get(i).getName()+
                    " | url: " + firstList.get(i).getUrl()+
                    " | price: " + secondList.get(i).getPrice()+"\n");
        }
    }

    public static void main(String[] args) throws IOException{
        mainParsing();
    }

}
