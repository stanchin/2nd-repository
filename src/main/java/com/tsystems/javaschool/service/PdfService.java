package com.tsystems.javaschool.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tsystems.javaschool.DTO.ClientNumberDTO;
import com.tsystems.javaschool.webservices.ReceiveRSClients;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Stateless
public class PdfService {

    @EJB
    private ReceiveRSClients receiveRSClients;

    public void createPdf(HttpServletResponse response, long tariffId, String tariffName){
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","attachment; filename=\"clients.pdf\"");

        List<ClientNumberDTO> clients = receiveRSClients.getClients(tariffId);

        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream os = null;
        try {
            PdfWriter.getInstance(document, baos);

            document.open();

            Paragraph paragraph1 = new Paragraph("This document contains clients from MobileOperatorSystem on "
                    + tariffName + " tariff.", FontFactory.getFont(FontFactory.COURIER,
                    14, Font.NORMAL, new CMYKColor(0, 255, 0, 0)));
            document.add(paragraph1);

            PdfPTable table = new PdfPTable(5);
            table.setSpacingBefore(25);
            table.setSpacingAfter(25);

            PdfPCell cell1 = new PdfPCell(new Phrase("Client name"));
            table.addCell(cell1);

            PdfPCell cell2 = new PdfPCell(new Phrase("Client surname"));
            table.addCell(cell2);

            PdfPCell cell3 = new PdfPCell(new Phrase("Client email"));
            table.addCell(cell3);

            PdfPCell cell4 = new PdfPCell(new Phrase("Client passport"));
            table.addCell(cell4);

            PdfPCell cell5 = new PdfPCell(new Phrase("Client number"));
            table.addCell(cell5);

            for (ClientNumberDTO c : clients){
                table.addCell(c.getName());
                table.addCell(c.getClientSurname());
                table.addCell(c.getClientEmail());
                table.addCell(String.valueOf(c.getClientPassport()));
                table.addCell(String.valueOf(c.getClientNumber()));
            }

            document.add(table);
            document.close();

            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setContentLength(baos.size());

            os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
