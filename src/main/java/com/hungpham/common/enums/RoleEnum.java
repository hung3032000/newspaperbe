package com.hungpham.common.enums;

public enum RoleEnum {
    ADMIN,
    SUBADMIN,
    USER;

    @Override
    public String toString() {
        return this.name();
    }
}
