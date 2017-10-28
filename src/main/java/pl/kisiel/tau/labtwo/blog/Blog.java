package pl.kisiel.tau.labtwo.blog;

import java.util.Date;

public class Blog {
    private int id;
    private String title;
    private String description;
    private String fullPost;
    private String metaData;
    private int visitCount;
    private String category;
    private Date createData;

    public Blog(int id, String title, String description, String fullPost, String metaData,
                int visitCount, String category, Date createData) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.fullPost = fullPost;
        this.metaData = metaData;
        this.visitCount = visitCount;
        this.category = category;
        this.createData = createData;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullPost() {
        return fullPost;
    }

    public void setFullPost(String fullPost) {
        this.fullPost = fullPost;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }
}
