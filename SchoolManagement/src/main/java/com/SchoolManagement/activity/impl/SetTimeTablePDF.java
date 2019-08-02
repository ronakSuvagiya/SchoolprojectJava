package com.SchoolManagement.activity.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.SchoolManagement.dto.ExamTimeTableDto;
import com.SchoolManagement.dto.TeacherTimeTableDto;
import com.SchoolManagement.dto.TimeTableDto;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class SetTimeTablePDF {
	
	
	

  public static void setPdf(TimeTableDto timetable,String path)
      throws FileNotFoundException, DocumentException {
	  
    final String RESULT = path + timetable.getStd_id()
        + timetable.getDiv_id() + timetable.getSchool_id() + ".pdf";
    
    Document document = new Document(PageSize.LETTER.rotate());
    PdfWriter.getInstance(document, new FileOutputStream(RESULT));

    PdfPTable table = new PdfPTable(6);
    table.setSpacingAfter(20f);
    table.setSpacingBefore(30f);
    table.setWidthPercentage(100);
    table.setWidths(new int[] {1, 1, 1, 1, 1, 1});

    String mon[] = timetable.getMon().split(",");
    String tue[] = timetable.getTue().split(",");
    String wed[] = timetable.getWed().split(",");
    String thu[] = timetable.getThu().split(",");
    String fri[] = timetable.getFri().split(",");
    String sat[] = timetable.getSat().split(",");

    PdfPCell Datacell1;

    for (int i = 0; i < mon.length; i++) {
      Datacell1 = new PdfPCell(new Phrase(mon[i]));
      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);

      if (i < tue.length)
        Datacell1 = new PdfPCell(new Phrase(tue[i]));
      else
        Datacell1 = new PdfPCell();
      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);

      if (i < wed.length)
        Datacell1 = new PdfPCell(new Phrase(wed[i]));
      else

        Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);

      if (i < thu.length)
        Datacell1 = new PdfPCell(new Phrase(thu[i]));
      else
        Datacell1 = new PdfPCell();
      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);

      if (i < fri.length)
        Datacell1 = new PdfPCell(new Phrase(fri[i]));
      else
        Datacell1 = new PdfPCell();
      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);

      if (i < sat.length)
        Datacell1 = new PdfPCell(new Phrase(sat[i]));
      else
        Datacell1 = new PdfPCell();
      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);
    }

    document.open();
    document.add(table);
    document.close();

  }
  
  public static void setPdfTeacher(TeacherTimeTableDto timetable,String path)
	      throws FileNotFoundException, DocumentException {
		  
	    final String RESULT = path + + timetable.getTeacherId() + timetable.getSchool_id() + ".pdf";
	    
	    Document document = new Document(PageSize.LETTER.rotate());
	    PdfWriter.getInstance(document, new FileOutputStream(RESULT));

	    PdfPTable table = new PdfPTable(6);
	    table.setSpacingAfter(20f);
	    table.setSpacingBefore(30f);
	    table.setWidthPercentage(100);
	    table.setWidths(new int[] {1, 1, 1, 1, 1, 1});

	    String mon[] = timetable.getMon().split(",");
	    String tue[] = timetable.getTue().split(",");
	    String wed[] = timetable.getWed().split(",");
	    String thu[] = timetable.getThu().split(",");
	    String fri[] = timetable.getFri().split(",");
	    String sat[] = timetable.getSat().split(",");

	    PdfPCell Datacell1;

	    for (int i = 0; i < mon.length; i++) {
	      Datacell1 = new PdfPCell(new Phrase(mon[i]));
	      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	      Datacell1.setBorder(1);
	      Datacell1.setPadding(10);
	      table.addCell(Datacell1);

	      if (i < tue.length)
	        Datacell1 = new PdfPCell(new Phrase(tue[i]));
	      else
	        Datacell1 = new PdfPCell();
	      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	      Datacell1.setBorder(1);
	      Datacell1.setPadding(10);
	      table.addCell(Datacell1);

	      if (i < wed.length)
	        Datacell1 = new PdfPCell(new Phrase(wed[i]));
	      else

	        Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	      Datacell1.setBorder(1);
	      Datacell1.setPadding(10);
	      table.addCell(Datacell1);

	      if (i < thu.length)
	        Datacell1 = new PdfPCell(new Phrase(thu[i]));
	      else
	        Datacell1 = new PdfPCell();
	      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	      Datacell1.setBorder(1);
	      Datacell1.setPadding(10);
	      table.addCell(Datacell1);

	      if (i < fri.length)
	        Datacell1 = new PdfPCell(new Phrase(fri[i]));
	      else
	        Datacell1 = new PdfPCell();
	      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	      Datacell1.setBorder(1);
	      Datacell1.setPadding(10);
	      table.addCell(Datacell1);

	      if (i < sat.length)
	        Datacell1 = new PdfPCell(new Phrase(sat[i]));
	      else
	        Datacell1 = new PdfPCell();
	      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	      Datacell1.setBorder(1);
	      Datacell1.setPadding(10);
	      table.addCell(Datacell1);
	    }

	    document.open();
	    document.add(table);
	    document.close();

	  }

  public static void setExamPdf(ExamTimeTableDto examTimeTableDto,String path)
      throws FileNotFoundException, DocumentException, ParseException {
    final String RESULT = path + examTimeTableDto.getTitle() +
        + examTimeTableDto.getStd_id() + examTimeTableDto.getSchool_id() + ".pdf";
    Document document = new Document(PageSize.LETTER.rotate());
    PdfWriter.getInstance(document, new FileOutputStream(RESULT));

    PdfPTable table = new PdfPTable(5);
    table.setSpacingAfter(20f);
    table.setSpacingBefore(30f);
    table.setWidthPercentage(100);
    table.setWidths(new int[] {1, 1, 1, 1, 1});

    String date[] = examTimeTableDto.getDate().split(",");
    String sub[] = examTimeTableDto.getSubject().split(",");
    String s_time[] = examTimeTableDto.getS_time().split(",");
    String e_time[] = examTimeTableDto.getE_time().split(",");

    PdfPCell Datacell1;

    Datacell1 = new PdfPCell(new Phrase("Date"));
    Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
    Datacell1.setBorder(1);
    Datacell1.setPadding(10);
    table.addCell(Datacell1);

    Datacell1 = new PdfPCell(new Phrase("Day"));
    Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
    Datacell1.setBorder(1);
    Datacell1.setPadding(10);
    table.addCell(Datacell1);

    Datacell1 = new PdfPCell(new Phrase("Subject"));
    Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
    Datacell1.setBorder(1);
    Datacell1.setPadding(10);
    table.addCell(Datacell1);

    Datacell1 = new PdfPCell(new Phrase("Start Date"));
    Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
    Datacell1.setBorder(1);
    Datacell1.setPadding(10);
    table.addCell(Datacell1);

    Datacell1 = new PdfPCell(new Phrase("End Date"));
    Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
    Datacell1.setBorder(1);
    Datacell1.setPadding(10);
    table.addCell(Datacell1);

    for (int i = 0; i < date.length; i++) {
      Datacell1 = new PdfPCell(new Phrase(date[i]));
      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);


      SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
      Date dt1 = format1.parse(date[i]);
      DateFormat format2 = new SimpleDateFormat("EEEE");
      String finalDay = format2.format(dt1);

      Datacell1 = new PdfPCell(new Phrase(finalDay));
      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);

      Datacell1 = new PdfPCell(new Phrase(sub[i]));
      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);

      Datacell1 = new PdfPCell(new Phrase(s_time[i]));
      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);

      Datacell1 = new PdfPCell(new Phrase(e_time[i]));
      Datacell1.setHorizontalAlignment(Element.ALIGN_LEFT);
      Datacell1.setBorder(1);
      Datacell1.setPadding(10);
      table.addCell(Datacell1);


    }

    document.open();
    document.add(table);
    document.close();

  }

}
