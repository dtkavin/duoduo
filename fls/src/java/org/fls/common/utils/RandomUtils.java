/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.utils;

/**
 * 随机数工具类
 *
 * @author Tone
 */
public class RandomUtils {
    /**
     *  或缺范围内的随机数
     * @param i
     * @return  int
     */
    public static int getRandom(int i) {
        double randmo = Math.random() * i;
        randmo = Math.ceil(randmo);
        return new Double(randmo).intValue();
    }
}
