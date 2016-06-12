package de.topobyte.jsoup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.jsoup.nodes.Document;

public class JsoupServletUtil
{

	public static void respond(HttpServletResponse response,
			ContentGeneratable generator) throws IOException
	{
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();

		generator.generate();

		Document document = generator.getBuilder().getDocument();
		writer.write(document.toString());

		writer.close();
	}

	public static void respond(HttpServletResponse response, Document document)
			throws IOException
	{
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();
		writer.write(document.toString());

		writer.close();
	}

}
