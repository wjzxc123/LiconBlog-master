package com.Licon.blog.website.utils;



import com.Licon.blog.website.modal.Vo.MetaVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 后台公共函数
    * @ClassName: AdminCommons  
    * @Description: TODO  
    * @author Licon  
    * @date 2018年11月10日  
    *
 */
@Component
public final class AdminCommons {

    /**
     * 判断category和cat的交集
     *
     * @param cats
     * @return
     */
    public static boolean exist_cat(MetaVo category, String cats) {
        String[] arr = StringUtils.split(cats, ",");
        if (null != arr && arr.length > 0) {
            for (String c : arr) {
                if (c.trim().equals(category.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final String[] COLORS = {"default", "primary", "success", "info", "warning", "danger", "inverse", "purple", "pink"};

    public static String rand_color() {
        int r = Tools.rand(0, COLORS.length - 1);
        return COLORS[r];
    }

}
