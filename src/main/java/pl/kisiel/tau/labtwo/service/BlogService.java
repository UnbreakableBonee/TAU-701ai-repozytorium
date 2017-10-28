package pl.kisiel.tau.labtwo.service;

import pl.kisiel.tau.labtwo.blog.Blog;

public interface BlogService {

    int Create(Blog blog) throws Exception;
    Blog Read(int id);

    void Update(int id, Blog blog);

    void Delete(int id);
}
