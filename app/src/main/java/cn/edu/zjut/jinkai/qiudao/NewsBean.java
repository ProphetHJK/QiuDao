package cn.edu.zjut.jinkai.qiudao;

public class NewsBean {
    private int id;//新闻的ID号
    private int comment;//新闻的评论数
    private int type;//新闻类别
    private String time;//新闻发布的时间
    private String title;//新闻的标题
    private String news_url;//新闻的链接地址
    private String icon_url;//新闻图片的链接地址
    private String des;//新闻的内容

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getType() {
        return type;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }

    public String getNews_url() {
        return news_url;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }
}
