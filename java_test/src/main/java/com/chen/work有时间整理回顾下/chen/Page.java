package com.chen.work有时间整理回顾下.chen;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Page<E> extends ArrayList<E> {
    private int pageNum;
    private int pageSize;
}
