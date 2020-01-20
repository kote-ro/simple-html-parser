package parsing;

import data.ListOfPrices;
import data.ListOfTitlesAndUrls;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DownloadingResults{
    public static void downloadingRes(List<ListOfTitlesAndUrls> firstList
                             , List<ListOfPrices> secondList) throws IOException {
        FileWriter fileWriter = new FileWriter("result.txt");
        for(int i = 0; i<firstList.size(); i++){
            String title = firstList.get(i).getName();
            String url = firstList.get(i).getUrl();
            String price = secondList.get(i).getPrice();
            fileWriter.write(title +" | "+ price+" | "+url+System.getProperty("line.separator"));
        }
        fileWriter.close();
    }
}
