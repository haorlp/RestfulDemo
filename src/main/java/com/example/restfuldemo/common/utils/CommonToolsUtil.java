package com.example.restfuldemo.common.utils;

import java.math.BigDecimal;

public class CommonToolsUtil {
    public static Double bigDecimalMultiply(Double first, Double second, Integer flag) {
        if (null == first || null == second) {
            return null;
        } else {
            try {
                BigDecimal bigFist = new BigDecimal(first);
                BigDecimal bigSecond = new BigDecimal(second);
                bigFist.setScale(4, BigDecimal.ROUND_HALF_DOWN);
                bigSecond.setScale(4, BigDecimal.ROUND_HALF_DOWN);
                bigFist = bigFist.multiply(bigSecond);
                if (1 == flag) {
                    return bigFist.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                }else {
                    return bigFist.doubleValue();
                }
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static Double bigDecimalSubtract(Double first, Double second, Integer flag) {
        if (null == first || null == second) {
            return null;
        } else {
            try {
                BigDecimal bigFist = new BigDecimal(first);
                BigDecimal bigSecond = new BigDecimal(second);
                bigFist.setScale(4, BigDecimal.ROUND_HALF_DOWN);
                bigSecond.setScale(4, BigDecimal.ROUND_HALF_DOWN);
                bigFist = bigFist.subtract(bigSecond);
                if (1 == flag) {
                    return bigFist.setScale(4, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                }else {
                    return bigFist.doubleValue();
                }
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static Double bigDecimalAdd(Double first, Double second, Integer flag) {
        if (null == first || null == second) {
            return null;
        } else {
            try {
                BigDecimal bigFist = new BigDecimal(first);
                BigDecimal bigSecond = new BigDecimal(second);
                bigFist.setScale(4, BigDecimal.ROUND_HALF_DOWN);
                bigSecond.setScale(4, BigDecimal.ROUND_HALF_DOWN);
                bigFist = bigFist.add(bigSecond);
                if (1 == flag) {
                    return bigFist.setScale(4, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                }else {
                    return bigFist.doubleValue();
                }
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static Integer compareToBigDecimal(Double first, Double second, Integer flag) {
        if (null == first || null == second) {
            return null;
        } else {
            try {
                BigDecimal bigFist = new BigDecimal(first);
                BigDecimal bigSecond = new BigDecimal(second);
                if (1 == flag) {
                    bigFist.setScale(4, BigDecimal.ROUND_HALF_DOWN);
                    bigSecond.setScale(4, BigDecimal.ROUND_HALF_DOWN);
                }
                return bigFist.compareTo(bigSecond);
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static Integer compareToBigDecimalByScale(String first, String second, Integer scale, Integer flag) {
        if ((null == first || 0 == first.length()) || (null == second || 0 == second.length())) {
            return null;
        } else {
            try {
                BigDecimal bigFist = new BigDecimal(first);
                BigDecimal bigSecond = new BigDecimal(second);
                if (1 == flag) {
                    bigFist.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
                    bigSecond.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
                }
                return bigFist.compareTo(bigSecond);
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static String bigDecimalSubtractByScale(String first, String second, Integer scale, Integer flag) {
        if ((null == first || 0 == first.length()) || (null == second || 0 == second.length())) {
            return null;
        } else {
            try {
                BigDecimal bigFist = new BigDecimal(first);
                BigDecimal bigSecond = new BigDecimal(second);
                bigFist.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
                bigSecond.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
                bigFist = bigFist.subtract(bigSecond);
                if (1 == flag) {
                    bigFist.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
                }
                String result = bigFist.toString();
                result = roundByScale(result, scale);
                return result;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static String bigDecimalAddByScale(String first, String second, Integer scale, Integer flag) {
        if ((null == first || 0 == first.length()) || (null == second || 0 == second.length())) {
            return null;
        } else {
            try {
                BigDecimal bigFist = new BigDecimal(first);
                BigDecimal bigSecond = new BigDecimal(second);
                bigFist.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
                bigSecond.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
                bigFist = bigFist.add(bigSecond);
                if (1 == flag) {
                    bigFist.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
                }
                String result = bigFist.toString();
                result = roundByScale(result, scale);
                return result;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static String bigDecimalMultiplyByScale(String first, String second, Integer scale, Integer flag) {
        if ((null == first || 0 == first.length()) || (null == second || 0 == second.length())) {
            return null;
        } else {
            try {
                BigDecimal bigFist = new BigDecimal(first);
                BigDecimal bigSecond = new BigDecimal(second);
                bigFist = bigFist.multiply(bigSecond);
                if (1 == flag) {
                    bigFist.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
                }
                String result = bigFist.toString();
                result = roundByScale(result, scale);
                return result;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static String bigDecimalDivideByScale(String first, String second, Integer scale, Integer flag) {
        if ((null == first || 0 == first.length()) || (null == second || 0 == second.length())) {
            return null;
        } else {
            try {
                BigDecimal bigFist = new BigDecimal(first);
                BigDecimal bigSecond = new BigDecimal(second);
                //                bigFist = bigFist.divide(bigSecond);
                if (1 == flag) {
                    bigFist = bigFist.divide(bigSecond, scale, BigDecimal.ROUND_HALF_DOWN);
//                    bigFist.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
                }else {
                    bigFist = bigFist.divide(bigSecond, 4, BigDecimal.ROUND_HALF_DOWN);
                }
                String result = bigFist.toString();
                result = roundByScale(result, scale);
                return result;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static Integer bigDecimalIsEqualZeroByScale(String data, Integer scale, Integer flag) {
        if (null == data || 0 == data.length()) {
            return null;
        }
        data = roundByScale(data, scale);
        BigDecimal bigDecimal = new BigDecimal(data);
        if (1 == flag) {
            bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
        }
        return bigDecimal.compareTo(BigDecimal.ZERO);
    }

    public static String strDataConvertOutput(String data, Integer startIndex, Integer endIndex) {
        // 前startIndex位字母不变
        String s1 = data.substring(0, startIndex);
        // 后startIndex位字母不变
        String s3 = data.substring(data.length() - endIndex);
        //需要被替换的字母
        String s2 = data.substring(startIndex, data.length() - endIndex);
        // 剩下的字母全部替换成*
        return (s1 + s2.replaceAll("[a-zA-Z0-9]", "*") + s3);
    }

    /**
     * @desc 将double格式化为指定小数位的String，不足小数位用0补全
     * @param str     需要格式化的数字
     * @param scale 小数点后保留几位
     * @return
     */
    public static String roundByScale(String str, int scale) {
        StringBuilder data = new StringBuilder(str);
        if (scale < 0) {
            data = null;
        }else {
            int index = data.lastIndexOf(".");
            if (-1 == index) {
                data.append(".");
                index = data.lastIndexOf(".") + 1;
            }else {
                index += 1;
            }

            String subStr = data.substring(index);
            int size = subStr.length();

            if (size <= scale) {
                for (int i = 0;i < (scale - size);i++) {
                    data.append("0");
                }
            }else {
                data.delete(index + scale, data.length());
            }
        }
        return  data.toString();
    }
}
