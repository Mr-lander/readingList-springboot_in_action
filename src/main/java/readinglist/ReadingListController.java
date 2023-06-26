package readinglist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Controller //声明：这是一个控制器,被注册为一个bean
@RequestMapping(value = "/readingList")//设置访问跟路名称 url筛选
public class ReadingListController {
private ReadingListRepository readingListRepository;

/*
 * 把ReadingListRepository添加到中
 * @Autowired 用添加消息，让Spring完�
 * 依赖注入
 */
@Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
    this.readingListRepository = readingListRepository;
}
/*
 * 访问跟路名称 url筛选
 * @PathVariable 获取url中的参数
 * @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
 * @RequestMapping(value = "/{reader}
 */
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        /*
        一个HTTP请求，一个model。model就像PHP中的$_Post()一样，一个HTTP请求期间分配一个model供你差遣。
         */
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);//键值对
        }
        System.out.println(reader);
        return "readingList";//返回视图名称，视图解機器会校驗是否存圤，如消息不存圶，就返回默认视图
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, @ModelAttribute Book book) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(book); // 打印出 book 对象的值
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        book.setReader(reader);
        //save是继承JpaRepository的18个方法之一，但是你不需要去实现。It's magic!
        readingListRepository.save(book);//
        return "redirect:/readingList/{reader}";
    }


}
