package utils;

import java.util.ArrayList;
import java.util.List;

public class extra {
    public static void main1() {
        String x="document.querySelector('.atf-leaderboard').style.display = 'none';document.querySelector('.btf-leaderboard-desktop-only').style.display = 'none';document.querySelector('.open-ad-component.open-ad-component--body').style.display = 'none';document.querySelector('.btf-midpagefullwidth').style.display = 'none';document.querySelector('.btf-leaderboard-mobile-tablet').style.display = 'none'";
        String[] x1=x.split(";");
        ArrayList arrayList=new ArrayList<>(List.of(x1));
        System.out.println(arrayList.get(0));
        String total="";

        for (int i=0;i<arrayList.size();i++){
            total=arrayList.get(i)+";"+total;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        String x = "document.querySelector('.atf-leaderboard').style.display = 'none';document.querySelector('.btf-leaderboard-desktop-only').style.display = 'none';document.querySelector('.open-ad-component.open-ad-component--body').style.display = 'none';document.querySelector('.btf-midpagefullwidth').style.display = 'none';document.querySelector('.btf-leaderboard-mobile-tablet').style.display = 'none'";
        String[] x1 = x.split(";");
        ArrayList<String> arrayList = new ArrayList<>(List.of(x1));

        System.out.println(arrayList.get(0));

        StringBuilder total = new StringBuilder();

        for (String element : arrayList) {
            total.insert(0,element + ";");
        }
        System.out.println(total.toString());
    }
}
