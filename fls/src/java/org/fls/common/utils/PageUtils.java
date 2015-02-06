/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.utils;

/**
 * 分页工具
 *
 * @author Tone
 */
public class PageUtils {

    /**
     * 获取所在页码
     *
     * @param pageSize
     * @param allRow
     * @param index
     * @return int
     */
    public static int getPageIndex(int pageSize, int allRow, int index) {
        //pageSize=2;
        // System.out.println("pageSize:"+pageSize);
        //  System.out.println("allRow:"+allRow);
        //  System.out.println("index:"+index);
        int pageIndex = 1;
        if (index <= pageSize) {
            pageIndex = 1;
        } else {
            int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
            for (int i = 1; i <= totalPage; i++) {

                if (index <= i * pageSize) {

                    pageIndex = i;
                    break;
                }
            }
        }
        //System.out.println("pageIndex:"+pageIndex);
        return pageIndex;
    }
}
