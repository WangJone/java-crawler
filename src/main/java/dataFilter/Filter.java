package dataFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {
    private Pattern pattern = null;
    private Matcher matcher = null;
    private static final String regex_note = "<!--.[^-]*(?=-->)-->";//定义html注释标签
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\t|\r|\n";// 定义空格回车换行符
    private static final String regEx_w = "<w[^>]*?>[\\s\\S]*?<\\/w[^>]*?>";//定义所有w标签

    String string = null;
    public Filter()
    {}

    /**
     * Regular expression for dealing with HTML
     * @param html
     * @return
     */
    public String filterHTML(String html)
    {
        //去除脚本
        pattern = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(html);
        string = matcher.replaceAll("");
        //去除style标签
        pattern = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(string);
        string = matcher.replaceAll("");
        //去除标签
        pattern = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(html);
        string = matcher.replaceAll("");
        return string;
//        String re = "\\p{Punct}[a-z]{2}\\p{Punct}(.*?)\\p{Punct}\\p{Punct}[a-z]{2}\\p{Punct}";
//        Pattern p = Pattern.compile(re);
//        Matcher m = p.matcher(input);
//		m.matches()//整个式子匹配成功才返回true
//		m.lookingAt()//只有再式子的最前面匹配到了才返回true
//		Boolean b = m.find();//能匹配到式子就返回true
    }
}
