package apiproject.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lei
 * @date 07/19/2021 6:08 PM
 */
public class BoardTagStringDemo {
    private static final String BOARD_TITLE_SUFFIX_PATTERN = "第\\d+名";

    public static String getTitleFromTag(String boardTag) {
        if (boardTag == null || "".equals(boardTag)) {
            return "";
        }
        Pattern pattern = Pattern.compile(BOARD_TITLE_SUFFIX_PATTERN);
        Matcher matcher = pattern.matcher(boardTag);
        int index = 0;
        while (matcher.find()) {
            index = matcher.start();
        }
        return boardTag.substring(0, index);
    }

    public static void main(String[] args) {
        String boardTag = "机投地方菜人气榜第3名";
        String res = getTitleFromTag(boardTag);
        System.out.println(res);
    }
}
