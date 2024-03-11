package Observer;

public class Observers {
    public static void main(String[] args) {
        // สร้าง Concrete Subject (NewsAgency)
        NewsAgency newsAgency = new NewsAgency();

        // สร้าง Concrete Observer (NewsChannel)
        NewsChannel newsChannel = new NewsChannel();

        // ลงทะเบียน Observer (NewsChannel) กับ Subject (NewsAgency)
        newsAgency.registerObserver(newsChannel);

        // ตั้งข่าวให้กับ Concrete Subject (NewsAgency)
        newsAgency.setNews("Breaking news: COVID-19 vaccine found!");

        // ลบ Observer (NewsChannel) จาก Subject (NewsAgency)
        newsAgency.removeObserver(newsChannel);

        // ตั้งข่าวใหม่อีกครั้ง
        newsAgency.setNews("Weather update: Heavy rain expected tomorrow.");
    }
}
