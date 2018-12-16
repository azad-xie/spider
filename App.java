package edu.csuft.azad.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
	// alt+/
	// 
	public static void main(String[] args) {
		//URL Ŀ��·��
		String url="https://movie.douban.com/top250";
		//ʹ��
		try {
			Document doc=Jsoup.connect(url).get();
			
			Elements es=doc.select(".grid_view .item");
			System.out.println(es.size());
			//�����洢ӰƬ�б�
			ArrayList<Film> list=new ArrayList<>();
			
			for(Element e:es) {
				Film f = new Film();
				//ÿһ��ӰƬ
				Element t=e.select(".title").first();
				String num=e.select(".star span").last().text();//.substring(0,t.length()-3);.star�ǰѷ�Χ�ڵı�ǩȡ����
				System.out.println(t.text() + ","+num);
				
				//f.id
				//f.title
				list.add(f);
				
			}
			//String title=doc.title();
			//String data=doc.title();
			//System.out.println(title);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
