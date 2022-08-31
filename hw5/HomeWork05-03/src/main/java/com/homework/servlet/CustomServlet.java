package com.homework.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework.transaction.Transaction;
import com.homework.transaction.TransactionConverter;

@WebServlet("/get")
public class CustomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("transactionId") != null && request.getParameter("transactionName") != null
				&& request.getParameter("amountLocal") != null) {
			
			PrintWriter out = response.getWriter();
			
			long transactionId = Long.parseLong(request.getParameter("transactionId"));
			String transactionName = request.getParameter("transactionName");
			double amountLocal = Double.parseDouble(request.getParameter("amountLocal"));

			Transaction transaction = new Transaction(transactionId, transactionName, amountLocal);
			String formatedTransaction = TransactionConverter.format(transaction);

			out.write(formatedTransaction);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameters must be valid");
		}

	}
}
