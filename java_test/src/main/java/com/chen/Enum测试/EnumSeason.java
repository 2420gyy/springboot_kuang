package com.chen.Enum测试;

/**
 * @author chenchen
 * @date 2021-11-13 10:58
 */
public enum EnumSeason {

    SPRING("1","春天"),
    SUMMER("2","夏天"),
    AUTUMN("3","秋天"),
    WINTER("4","冬天");

    private String code;
    private String seasonName;

    EnumSeason(String code, String seasonName) {
        this.code = code;
        this.seasonName = seasonName;
    }

    public String getCode() {
        return code;
    }

    public String getSeasonName() {
        return seasonName;
    }
}
