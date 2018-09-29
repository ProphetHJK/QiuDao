package cn.edu.zjut.jinkai.qiudao;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


import android.content.Context;
import android.util.Log;

public class NewsUtils {

    // �������л�ȡJson���ݣ�����Json����
    public static ArrayList<NewsBean> getNetNews(Context context, String urlString) {
        ArrayList<NewsBean> arraylistNews = new ArrayList<NewsBean>();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                // ��ȡ���󵽵�����Ϣ
                InputStream is = conn.getInputStream();
                String result = StreamUtils.convertStream(is);
                JSONObject root_json = new JSONObject(result);
                JSONArray jsonArray  = root_json.getJSONArray("newss");
                for (int i = 0; i < jsonArray .length(); i ++ ){
                    JSONObject news_json = jsonArray.getJSONObject(i);
                    NewsBean newsBean = new NewsBean();
                    newsBean.setId(news_json.getInt("id"));
                    newsBean.setTime(news_json.getString("time"));
                    newsBean.setDes(news_json.getString("des"));
                    newsBean.setTitle(news_json.getString("title"));
                    newsBean.setNews_url(news_json.getString("news_url"));
                    newsBean.setIcon_url(news_json.getString("icon_url"));
                    Log.i("NewsUtils", newsBean.getIcon_url());
                    newsBean.setComment(news_json.getInt("comment"));
                    newsBean.setType(news_json.getInt("type"));
                    arraylistNews.add(newsBean);

                }

                // �����ȡ�������ϵ����ݣ���ɾ��֮ǰ��ȡ���������ݣ������µ���������
                new NewsDBUtils(context).deleteNews();
                new NewsDBUtils(context).saveNews(arraylistNews);

                is.close();

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return arraylistNews;
    }

    // �������ݿ⻺�浽������
    public static ArrayList<NewsBean> getDBNews(Context context){

        return new NewsDBUtils(context).getNews();
    }



}
