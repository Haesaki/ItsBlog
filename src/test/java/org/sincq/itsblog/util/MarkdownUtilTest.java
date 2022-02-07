package org.sincq.itsblog.util;

import org.junit.jupiter.api.Test;

public class MarkdownUtilTest {
    @Test
    public void markdown2HtmlTest(){
        String str = "<p>day|time|spent\n" +
                ":---|:---:|--:\n" +
                "nov. 2. tue|10:00|4h 40m\n" +
                "nov. 3. thu|11:00|4h\n" +
                "nov. 7. mon|10:20|4h 20m\n" +
                "total:|| 13h</p>";
        String Code = "```java" +
                "public class MarkdownUtilTest {}" +
                "```";
        System.out.println(MarkdownUtil.markdown2HtmlExtensions(str));
        System.out.println(MarkdownUtil.markdown2Html("[ItsBlog](127.0.0.1:8080)"));
        System.out.println(MarkdownUtil.markdown2Html(Code));
    }
}
