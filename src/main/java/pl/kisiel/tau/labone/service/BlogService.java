package pl.kisiel.tau.labone.service;

import pl.kisiel.tau.labone.blog.Blog;

public interface BlogService {

    int Create(Blog blog) throws Exception;
    Blog Read(int id);

    void Update(int id, Blog blog);

    void Delete(int id);
}
