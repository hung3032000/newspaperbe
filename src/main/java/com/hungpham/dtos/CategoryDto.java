package com.hungpham.dtos;

public class CategoryDto extends AbstractDto<CategoryDto> {
    private String categoryName;
    private boolean deleteFlag;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
