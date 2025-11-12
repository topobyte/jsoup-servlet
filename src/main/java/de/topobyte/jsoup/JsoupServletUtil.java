// Copyright 2017 Sebastian Kuerten
//
// This file is part of jsoup-servlet.
//
// jsoup-servlet is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// jsoup-servlet is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with jsoup-servlet. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.jsoup;

import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.nodes.Document;

import jakarta.servlet.http.HttpServletResponse;

public class JsoupServletUtil
{

	public static void respond(HttpServletResponse response,
			ContentGeneratable generator) throws IOException
	{
		respond(response, generator, true);
	}

	public static void respond(HttpServletResponse response,
			ContentGeneratable generator, boolean writeDoctype)
			throws IOException
	{
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();

		generator.generate();

		Document document = generator.getBuilder().getDocument();
		writer.write("<!DOCTYPE html>");
		writer.write(document.toString());

		writer.close();
	}

	public static void respond(HttpServletResponse response, Document document)
			throws IOException
	{
		respond(response, document, true);
	}

	public static void respond(HttpServletResponse response, Document document,
			boolean writeDoctype) throws IOException
	{
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();
		writer.write("<!DOCTYPE html>");
		writer.write(document.toString());

		writer.close();
	}

}
