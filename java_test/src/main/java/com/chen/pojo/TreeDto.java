package com.chen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chenchen
 * @date 2021-11-20 15:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeDto {
    private String id;
    private String name;
    private String pid;
    private String isParent;
    private List<TreeDto> childTreeDto;
}
