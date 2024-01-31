package com.jia.uils;

import com.jia.pojo.Article;

import java.util.List;

public class ToHtmlTableConverter {
    public static String convertToHtmlTable(List<Article> articleList) {
        StringBuilder htmlTable = new StringBuilder();

        // Start of HTML table
        htmlTable.append("<table border='1'>");

        // Table header
        htmlTable.append("<tr>");
        for (Article article : articleList) {
            for (java.lang.reflect.Field field : article.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    htmlTable.append("<th>").append(field.getName()).append("</th>");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        }
        htmlTable.append("</tr>");

        // Table data
        for (Article article : articleList) {
            htmlTable.append("<tr>");
            for (java.lang.reflect.Field field : article.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    htmlTable.append("<td>").append(field.get(article)).append("</td>");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            htmlTable.append("</tr>");
        }

        // End of HTML table
        htmlTable.append("</table>");

        return htmlTable.toString();
    }
}
