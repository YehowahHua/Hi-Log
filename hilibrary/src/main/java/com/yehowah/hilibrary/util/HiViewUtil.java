package com.yehowah.hilibrary.util;

import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * created by cyh
 * on 2021/3/4 22:17
 * Description:
 **/
public class HiViewUtil {
    /**
     * 获取指定类型的子View
     * @param group ViewGroup
     * @param cls eg RecyclerView.class
     * @param <T>
     * @return 指定类型的View
     */
    public static <T> T findTypeView(@Nullable ViewGroup group, Class<T> cls) {
        if (group == null) {
            return null;
        }
        Deque<View> deque = new ArrayDeque<>();
        deque.add(group);
        while (!deque.isEmpty()) {
            View node = deque.removeFirst();
            if (cls.isInstance(node)) {
                return cls.cast(node);
            } else if (node instanceof ViewGroup) {
                ViewGroup container = (ViewGroup) node;
                for (int i = 0, cout = container.getChildCount(); i < cout; i++) {
                    deque.add(container.getChildAt(i));
                }
            }
        }
        return null;
    }
}
