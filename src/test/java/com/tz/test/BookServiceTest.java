package com.tz.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tz.entity.Book;
import com.tz.entity.BookStyle;
import com.tz.entity.eum.Category;
import com.tz.entity.eum.Suit;
import com.tz.service.BookService;
import com.tz.service.BookStyleService;
import com.tz.util.BeansFactory;
import com.tz.util.TimeTool;
import com.tz.vo.PageBean;

public class BookServiceTest{
    private BookService bs = (BookService) BeansFactory.getInstance("bookService");
    private BookStyleService bss = (BookStyleService) BeansFactory.getInstance("bookStyleService");
    @Test
    public void insertBooktest(){
        List<Book> list = new ArrayList<Book>();
        Book book1 = new Book("9787533946418", "北纬78°", 39.00, 19.50, "浙江文艺出版社", TimeTool.parse("20161201000000", "yyyyMMddHHmmss"), Suit.不是套装, "陈丹燕", "中国",new BookStyle(bss.findStyleIdByName(Category.推荐图书.toString()),Category.推荐图书.toString()), "一个作家，一本书，激起你行走的渴望，改变你旅行的意义。陈丹燕旅行文学。", "beiwei78.jpg");
        Book book2 = new Book("9787513911139", "100の东京大人味发现°", 50.00, 34.50, "民主与建设出版社", TimeTool.parse("20161101000000", "yyyyMMddHHmmss"), Suit.不是套装, "吴东龙", "中国", new BookStyle(bss.findStyleIdByName(Category.推荐图书.toString()),Category.推荐图书.toString()), "超文艺、超时尚、很全面的东京旅游指南！台湾销售超火！从文化和设计角度深度解读东京，并提供完美的游览、住宿和美食攻略！", "100dongjindarenweifaxian.jpg");
        Book book3 = new Book("9787535477101", "别走，万一好笑呢°", 35.00, 26.30, "长江文艺出版社", TimeTool.parse("20161201000000", "yyyyMMddHHmmss"), Suit.不是套装, "银教授", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "微博人气博主@银教授个人作品集 银教授本人含泪自荐，希望你排着队拿着笑的号码牌，按顺序笑", "biezouwanyihaoxiaone.jpg");
        Book book4 = new Book("9787550019775", "此刻花开°", 68.00, 34.30, "百花洲文艺出版社", TimeTool.parse("20161201000000", "yyyyMMddHHmmss"), Suit.不是套装, "徐静", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "一场轻松自由的创作体验！风靡全球的纸雕艺术，比《秘密花园》更给力的减压新玩法。虽然我们不断被这个世界雕刻着，但我们亦可以雕刻出一个世界！", "cikehuakai.jpg");
        Book book5 = new Book("9787516413999", "洞见°", 48.00, 34.60, "企业管理出版社", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"), Suit.不是套装, "项保华", "中国", new BookStyle(bss.findStyleIdByName(Category.推荐图书.toString()),Category.推荐图书.toString()), "通过揭示体现在决策初心、判断、选择、落实背后的人性特征与事物规律，为提升个体及组织的决策管理水平与能力提供实用的操作指导。", "dongjian.jpg");
        Book book6 = new Book("9787308164207", "腾讯传°", 58.00, 40.10, "浙江大学出版社", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"), Suit.不是套装, "吴晓波", "中国", new BookStyle(bss.findStyleIdByName(Category.精选图书.toString()),Category.精选图书.toString()), "全景式记录腾讯成长轨迹，回望一代人的互联网情怀，解读中国互联网企业领先全球的真正秘密。", "tenxunchuan.jpg");
        Book book7 = new Book("9787550293151", "拉普拉斯的魔女°", 39.80, 28.70, "北京联合出版公司", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"), Suit.不是套装, "东野圭吾", "日本", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "东野圭吾：“我想摧毁自己以前写的小说，于是，这部作品就此诞生。” ", "book3_nav.jpg");
        Book book8 = new Book("9787540478612", "愿你的青春不负梦想", 36.00, 21.60, "湖南文艺出版社", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"), Suit.不是套装, "俞敏洪", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "50年心路历程×25年创业思考×80场演讲精华，与不甘平庸的你，谈谈如何度过不悔的青春，实现你心中的梦想。", "yuannideqingchunbufumengxiang.jpg");
        Book book9 = new Book("9787540478613", "情商高，就是说话让人舒服", 38.00, 19, "延边大学出版社", TimeTool.parse("20161001000000", "yyyyMMddHHmmss"), Suit.不是套装, "朱凌,常清", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "教你洞悉人性、说话动听！所谓情商高，就是会说话。不拆台不揭短，不生硬不伤人，让你的每一句话都说得得体又令人舒服，到哪都受欢迎！", "book3_nav.jpg");
        Book book10 = new Book("9787507838992", "销售心理战", 36.80, 18.40, "中国国际广播出版社", TimeTool.parse("20161201000000", "yyyyMMddHHmmss"), Suit.不是套装, "霍金斯", "英国", new BookStyle(bss.findStyleIdByName(Category.精选图书.toString()),Category.精选图书.toString()), "销售就是察言、观色、攻心，销售就是要搞定人，各界的销售大师们强烈推崇的销售心理学！", "xiaoshouxinlizhan.jpg");
        Book book11 = new Book("9787535448569", "小道理：分寸之间", 42.00, 33.10, "长江文艺出版社", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"), Suit.不是套装, "冯仑", "中国", new BookStyle(bss.findStyleIdByName(Category.推荐图书.toString()),Category.推荐图书.toString()), "商界精英的时代沉思录，地产导师的人生理想国。", "xiaodaolifencunzhijian.jpg");
        Book book12 = new Book("9787508667836", "名创优品没有秘密", 36.00, 27.00, "中信出版社", TimeTool.parse("20161201000000", "yyyyMMddHHmmss"), Suit.不是套装, "杜博奇", "中国", new BookStyle(bss.findStyleIdByName(Category.推荐图书.toString()),Category.推荐图书.toString()), "经济寒冬中的一匹黑马，关店浪潮下的逆势崛起！全面解读名创优品的商业模式，还原一个真实的零售世界！", "NO SECRETS.jpg");
        Book book13 = new Book("9787538890433", "写给年轻人的创业课", 39.80, 19.90, "黑龙江科学技术出版社", TimeTool.parse("20161201000000", "yyyyMMddHHmmss"), Suit.不是套装, "彭帅兴", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "每一个怀揣梦想的创业者都应该细读的暖心之作“拿来即用”的实战经验，“一针见血”的创业指导！", "xiegeinianqinrende1.jpg");
        Book book14 = new Book("9787201111728", "运营笔记", 39.80, 19.90, "天津人民出版社", TimeTool.parse("20161201000000", "yyyyMMddHHmmss"), Suit.不是套装, "类延昊", "中国", new BookStyle(bss.findStyleIdByName(Category.精选图书.toString()),Category.精选图书.toString()), "猫扑网辉煌时代缔造者之一类类告诉你：如何在互联网运营下半场到来之前，快速成长，实现运营人生的弯道超车。 ", "book3_nav.jpg");
        Book book15 = new Book("9787221135506", "太空", 38.00, 45.50, "贵州人民出版社", TimeTool.parse("20161101000000", "yyyyMMddHHmmss"), Suit.不是套装, "亚历山德拉·米热林斯卡", "波兰", new BookStyle(bss.findStyleIdByName(Category.推荐图书.toString()),Category.推荐图书.toString()), "浩瀚宇宙万千奇观，《太空》带你探索发现！本书献给喜欢仰望星空的少年科学家和梦想家！ ", "book3_nav.jpg");
        Book book16 = new Book("9787113215491", "欧洲", 38.00, 29.30, "中国铁道出版社", TimeTool.parse("20160501000000", "yyyyMMddHHmmss"), Suit.不是套装, "《亲历者》编辑部", "波兰", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "旅行达人实地感受，29项欧洲体验式旅行；全方位文化解读，你的欧洲之旅*精彩。", "book3_nav.jpg");
        Book book17 = new Book("9787519219420", "西藏", 39.80, 19.90, "世界图书出版公司", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"), Suit.不是套装, "梅里", "中国", new BookStyle(bss.findStyleIdByName(Category.精选图书.toString()),Category.精选图书.toString()), "西藏，一个可以改变人生的地方骑行，一种可以征服世界的方式不出门，你不知道你能走多远；不流泪，你不知道你有多坚强。", "book3_nav.jpg");
        Book book18 = new Book("9787201111735", "我与世界只差一个你", 49.00, 38.70, "天津人民出版社", TimeTool.parse("20161201000000", "yyyyMMddHHmmss"), Suit.不是套装, "张皓宸", "中国", new BookStyle(bss.findStyleIdByName(Category.推荐图书.toString()),Category.推荐图书.toString()), "12个温馨治愈的情感故事，给年轻人爱的正能量和信心，让你在面对爱时无惧，怀疑爱时坚定。", "woyushijiezhichayigeni.jpg");
        Book book19 = new Book("9787515818122", "卖产品就是卖自己", 35.00, 17.50, "中华工商联合出版社", TimeTool.parse("20161101000000", "yyyyMMddHHmmss"), Suit.不是套装, "梁汉桥", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "销售就是要玩转情商，销售就是要有效化解客户问题，销售就是要搞定人", "book3_nav.jpg");
        Book book20 = new Book("9787555106920", "男孩的冒险书", 198.00, 99.00, "广西科学技术出版社", TimeTool.parse("20161101000000", "yyyyMMddHHmmss"), Suit.不是套装, "康恩·伊古尔登", "英国", new BookStyle(bss.findStyleIdByName(Category.精选图书.toString()),Category.精选图书.toString()), "有史以来给男孩的完美手册升级！英国作者献给小男子汉的重磅手绘大作！原版连续12周《纽约时报》排行榜冠军，《时代周刊》鼎力推荐！", "book3_nav.jpg");
        Book book21 = new Book("9787507544824", "美联储主席", 58.00, 29.00, "华文出版社", TimeTool.parse("20170301000000", "yyyyMMddHHmmss"), Suit.不是套装, "斯凯恩", "美国", new BookStyle(bss.findStyleIdByName(Category.推荐图书.toString()),Category.推荐图书.toString()), "美联储主席又称“影子总统”，他们的权力美国第二，但全球NO.1。美元加不加息，他们说了算！他们讲话时，全球都得竖起耳朵听！", "book3_nav.jpg");
        Book book22 = new Book("9787550295179", "我只想一个人住在你心里", 45.00, 32.00, "北京联合出版公司", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"), Suit.不是套装, "孟瑞", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "孟瑞首部青春成长暖伤图文故事集，记录那些走过的青春，爱的人，追的梦，未走完的路和苍茫人世寻觅心安抚慰的你我！", "book3_nav.jpg");
       
        Book book23 = new Book();
        book23 = new Book("10", "tubiao", 0, 0, "", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"), Suit.不是套装, "", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "", "bullet1.gif");
        Book book24 = new Book();
        book24 = new Book("11", "gun1", 0, 0, "", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"),Suit.不是套装, "", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "", "advert1.jpg");
        Book book25 = new Book();
        book25 = new Book("12", "gun2", 0, 0, "", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"),Suit.不是套装, "", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "", "advert2.jpg");
        Book book26 = new Book();
        book26 = new Book("13", "gun3", 0, 0, "", TimeTool.parse("20170101000000", "yyyyMMddHHmmss"),Suit.不是套装, "", "中国", new BookStyle(bss.findStyleIdByName(Category.特价图书.toString()),Category.特价图书.toString()), "", "advert3.jpg");
        list.add(book1);list.add(book2);list.add(book3);list.add(book4);list.add(book5);
        list.add(book6);list.add(book7);list.add(book8);list.add(book9);list.add(book10);
        list.add(book11);list.add(book12);list.add(book13);list.add(book14);list.add(book15);
        list.add(book16);list.add(book17);list.add(book18);list.add(book19);list.add(book20);
        list.add(book21);list.add(book22);
        list.add(book23);list.add(book24);list.add(book25);
        list.add(book26);
        
        for (Book book : list) {
            bs.insertBook(book);
        }
    
    }
    
    @Test
    public void findAlltest(){
        PageBean<Book> list = bs.findAll("花", 3L, 1, 20);
        for (Book b : list.getDatas()) {
            System.out.println(b);
        }
        
    }

    @Test
    public void getRowstest(){
        System.out.println(bs.getRows("", 2L));
    }

    @Test
    public void getByidtest(){
        Book b = bs.getById(78);
        System.out.println(b.getBookname());
        
    }

    @Test
    public void getByisbn(){
        Book b = bs.getByIbsn("10");
        System.out.println(b);
    }

}
