package pl.kisiel.tau.labone.test;


import org.junit.Assert;
import org.junit.Test;
import pl.kisiel.tau.labone.blog.Blog;
import pl.kisiel.tau.labone.service.BlogImpl;

import java.util.Date;

public class BlogTest {
    //korekcja stworzona ku celu ogarniania tablicy, by za każdym razem myśleć "jakie jest id obiektu" zamiast "jakie jest id tablicy"
    private int idCorrection = -1;
    @Test
    public void testReadObject() {
        BlogImpl blog = new BlogImpl();
        Blog blog1 = blog.Read(1 + idCorrection);
        Assert.assertEquals("Pierwszy Wpis",blog1.getTitle());
        Assert.assertEquals("Impra Jest tu",blog1.getDescription());
        Assert.assertEquals("impra,ludzie",blog1.getMetaData());
        blog1 = blog.Read(4 + idCorrection);
        Assert.assertEquals(9999,blog1.getVisitCount());
        Assert.assertEquals("Imprezy",blog1.getCategory());
        Assert.assertEquals("impra,ludzie",blog1.getMetaData());
    }

    @Test
    public void testCreateObject() throws Exception {
        BlogImpl blog = new BlogImpl();
        blog.Create(new Blog(5, "Czwarty Wpis","Idsa","Impra jest" +
                "tu a ludzi w p...dużo!", "impra,ludzie",9999,"Imprezy", new Date(1507507240)));
        Assert.assertNotNull(blog.Read(4 + idCorrection));
    }

    @Test
    public void testUpdateObject() {
        BlogImpl blog = new BlogImpl();
        blog.Update(1 + idCorrection, new Blog(1, "Czwarty Wpis","Idsa","Impra jest" +
                "tu a ludzi w p...dużo!", "impra,ludzie",9999,"Imprezy", new Date(1507507240)));
        Blog blog1 = blog.Read(1 + idCorrection);
        Assert.assertEquals("Czwarty Wpis",blog1.getTitle());
        Assert.assertEquals("Idsa",blog1.getDescription());
        Assert.assertEquals("impra,ludzie",blog1.getMetaData());
        Assert.assertEquals(9999,blog1.getVisitCount());
    }

    @Test
    public void testDeleteObject() {
        BlogImpl blog = new BlogImpl();
        blog.Delete(4 + idCorrection);
        Assert.assertFalse(blog.equals(4));
    }
}

