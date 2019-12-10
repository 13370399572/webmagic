package com.music.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class TuPian  implements  PageProcessor{
	
	// 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

	@Override
	public void process(Page page) {
		List<String> links = page.getHtml().regex("//img\\d\\.mukewang.com/szimg\\S+\\.png").all();
		for (int i = 0; i < links.size(); i++) {
			String link = links.get(i);
			if (StringUtils.isNotEmpty(link)) {
				String linka= "http:"+link;
				try {
					URL url = new URL(linka);
					URLConnection connection = url.openConnection();
					InputStream inputStream = connection.getInputStream();
					ByteArrayOutputStream  byteArrayOutputStream = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					int len= 0;
					while ((len = inputStream.read(buf))!=-1) {
						byteArrayOutputStream.write(buf, 0, len);
					}
					byteArrayOutputStream.close();
					inputStream.close();
					File file = new File("D://test");
					if (!file.exists()) {
						file.mkdir();
					}
					File file2 = new File("D://test//"+i+".png");
					FileOutputStream fileOutputStream = new FileOutputStream(file2);
					fileOutputStream.write(byteArrayOutputStream.toByteArray());
					fileOutputStream.close();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

}
