package readinglist;


/**
 * ****————————————————————本文件是Model层————————————————————
 * 负责定义MVC框架的book实体的属性、主键等
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Book {

    /*
    @Id 和 @GeneratedValue 注解被放在 id 字段上。
    这样，JPA（Java Persistence API）就知道 id 字段是数据库表的主键，并且其值应该由数据库自动生成。
     */
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) //别加分号
    private long id;//id是实体的主键
    private String reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getReader() {
        return reader;
    }
    public void setReader(String reader) {
        this.reader = reader;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
