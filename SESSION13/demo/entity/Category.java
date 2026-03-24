package SESSION13.demo.entity;

public class Category {
    private String cate_id;
    private String cate_name;
    private Boolean status;

    public Category(){}
    public Category(String cate_id, String cate_name, Boolean status) {
        this.cate_id = cate_id;
        this.cate_name = cate_name;
        this.status = status;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Mã DM: %-10s | Tên danh mục: %-25s | Trạng thái: %s",
                cate_id,
                cate_name,
                (status ? "Hoạt động" : "Đang khóa"));
    }
}
