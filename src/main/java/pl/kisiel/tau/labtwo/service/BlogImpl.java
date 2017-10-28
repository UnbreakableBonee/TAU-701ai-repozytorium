package pl.kisiel.tau.labtwo.service;

import pl.kisiel.tau.labtwo.blog.Blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogImpl implements BlogService {
    private List<Blog> arrayOfBlogs = new ArrayList<Blog>();

    public BlogImpl() {
        arrayOfBlogs.add(new Blog(1, "Pierwszy Wpis","Impra Jest tu","Impra jest" +
                "tu a ludzi w p...dużo!", "impra,ludzie",5,"Imprezy", new Date(1507507200)));
       arrayOfBlogs.add(new Blog(2, "Drugi Wpis","Impra tam tu","Impra jest" +
                "tu a ludzi w p...dużo!", "impra,ludzie",2,"Imprezy", new Date(1507507210)));
       arrayOfBlogs.add(new Blog(3, "Trzeci Wpis","Impra Jest tam","Impra jest" +
                "tu a ludzi w p...dużo!", "impra,ludzie",1,"Imprezy", new Date(1507507100)));
       arrayOfBlogs.add(new Blog(4, "Czwarty Wpis","Idsa","Impra jest" +
                "tu a ludzi w p...dużo!", "impra,ludzie",9999,"Imprezy", new Date(1507507240)));
    }
    @Override
    public int Create(Blog blog) throws Exception {
        for (Blog _blog : arrayOfBlogs) {
            if (_blog.getId() == blog.getId()){
                throw new Exception();
            }
        }
        arrayOfBlogs.add(blog);
        return blog.getId();
    }

    @Override
    public Blog Read(int id) {
        return arrayOfBlogs.get(id);
    }

    @Override
    public void Update(int id,Blog blog) {
        arrayOfBlogs.set(id,blog);
    }

    @Override
    public void Delete(int id) {
        arrayOfBlogs.remove(id);
    }
}
