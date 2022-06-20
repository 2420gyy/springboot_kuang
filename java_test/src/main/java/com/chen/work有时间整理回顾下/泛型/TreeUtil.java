package com.chen.work有时间整理回顾下.泛型;


import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 树工具
 *
 * @author wuyipeng
 * @since 17:07 2022-3-14
 */
public class TreeUtil {

    public static <ID, N extends ITreeNode<ID, N>> List<N> build(List<N> list) {
        return build(list, null);
    }

    public static <ID, N extends ITreeNode<ID, N>> List<N> build(List<N> list, ID rootId) {
        if (ObjectUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        Map<Optional<ID>, List<N>> pidMap = list.stream().collect(Collectors.groupingBy(item -> Optional.ofNullable(item.getParentId())));
        list.forEach(item -> item.setChildren(pidMap.get(Optional.ofNullable(item.getId()))));
        return pidMap.get(Optional.ofNullable(rootId));
    }

    public static <ID, N extends ITreeNode<ID, N>> N find(List<N> list, Function<N, Boolean> func) {
        for (N n : list) {
            Boolean find = func.apply(n);
            if (find) {
                return n;
            }
            if (!ObjectUtils.isEmpty(n.getChildren())) {
                return find(n.getChildren(), func);
            }
        }
        return null;
    }

    public static <ID, N extends ITreeNode<ID, N>> void foreach(N node, Consumer<N> consumer) {
        foreach(Collections.singletonList(node), consumer);
    }

    public static <ID, N extends ITreeNode<ID, N>> void foreach(List<N> list, Consumer<N> consumer) {
        for (N n : list) {
            consumer.accept(n);
            if (!ObjectUtils.isEmpty(n.getChildren())) {
                foreach(n.getChildren(), consumer);
            }
        }
    }
}
