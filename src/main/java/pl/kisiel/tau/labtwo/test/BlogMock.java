package pl.kisiel.tau.labtwo.test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.kisiel.tau.labtwo.blog.Blog;
import pl.kisiel.tau.labtwo.service.ApiBlogService;
import pl.kisiel.tau.labtwo.service.BlogImpl;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlogMock{
    @Mock
    private int idCorrection = -1;
    @Mock
    BlogImpl blog;

    @Test
    public void testReadObject() {
        Blog blog1 = blog.Read(1 + idCorrection);
        when(blog1.getTitle()).thenReturn("Pierwszy Wpis");
        when(blog1.getDescription()).thenReturn("impra,ludzie");
        blog1 = blog.Read(4 + idCorrection);
        when(blog1.getVisitCount()).thenReturn(9999);
        when(blog1.getCategory()).thenReturn("Imprezy");
        when(blog1.getMetaData()).thenReturn("impra,ludzie");
    }

    @Test
    public void testCreateObject() throws Exception {
        BlogImpl blog = new BlogImpl();
        blog.Create(new Blog(5, "Czwarty Wpis","Idsa","Impra jest" +
                "tu a ludzi w p...dużo!", "impra,ludzie",9999,"Imprezy", new Date(1507507240)));
        when(blog.Read(4 + idCorrection)).thenReturn(isNotNull());
    }

    @Test
    public void testUpdateObject() {
        BlogImpl blog = new BlogImpl();
        blog.Update(1 + idCorrection, new Blog(1, "Czwarty Wpis","Idsa","Impra jest" +
                "tu a ludzi w p...dużo!", "impra,ludzie",9999,"Imprezy", new Date(1507507240)));
        Blog blog1 = blog.Read(1 + idCorrection);
        when(blog1.getTitle()).thenReturn("Czwarty Wpis");
        when(blog1.getDescription()).thenReturn("Idsa");
        when(blog1.getMetaData()).thenReturn("impra,ludzie");
        when(blog1.getVisitCount()).thenReturn(9999);
    }

    @Test
    public void testDeleteObject() {
        BlogImpl blog = new BlogImpl();
        blog.Delete(4 + idCorrection);
        when(blog.equals(4 + idCorrection)).thenReturn(Boolean.FALSE);
    }


}
