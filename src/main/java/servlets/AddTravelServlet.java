package servlets;

import com.mongodb.MongoClient;
import dao.TravelDao;
import entity.Travel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/addTravel")
public class AddTravelServlet extends HttpServlet {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        response.setContentType("text/html;charset=utf-8");
////
////        PrintWriter out = response.getWriter();
////
////        out.println("<h1>Hello)</h1>");
////        out.close();
//        RequestDispatcher rd = getServletContext().getRequestDispatcher(
//                "/travels.jsp");
//        rd.forward(req, resp);
//    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        MongoHelper mongoHelper = new MongoHelper();
//
//        TravelDao travelDao = new TravelDao(mongoHelper);
//
//        resp.setContentType("text/html;charset=utf-8");
//        req.setCharacterEncoding("UTF-8");
//        int number = Integer.parseInt(req.getParameter("number"));
//        String startDate = req.getParameter("startDate");
//        Date date1 = null;
//        try {
//            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String endDate = req.getParameter("endDate");
//        Date date2 = null;
//        try {
//            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String busId = req.getParameter("busId");
//        String fromStationId = req.getParameter("fromStationId");
//        String toStationId = req.getParameter("toStationId");
//        String fromBusStopId = req.getParameter("fromBusStopId");
//        Travel travel = new Travel(number, date1, date2, busId, fromStationId, toStationId, fromBusStopId);
//        travelDao.addItem(travel);


        String number = req.getParameter("number");
//        String startDateStr = req.getParameter("startDate");
//        String endDateStr = req.getParameter("endDate");
        String busId = req.getParameter("busId");
//        String fromStationId = req.getParameter("fromStationId");
//        String toStationId = req.getParameter("toStationId");
//        String fromPlatformId = req.getParameter("fromPlatformId");

        if ((number == null || number.equals(""))
                || (busId == null || busId.equals(""))
//                || (fromStationId == null || fromStationId.equals(""))
//                || (toStationId == null || toStationId.equals(""))
//                || (fromPlatformId == null || fromPlatformId.equals(""))
//                || (startDateStr == null || startDateStr.equals(""))
//                || (endDateStr == null || endDateStr.equals(""))) {
            ) {
            req.setAttribute("error", "Mandatory Parameters Missing");
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/travel/addTravel.jsp");
            rd.forward(req, resp);
        } else {
            Travel travel = new Travel();
            travel.setNumber(Integer.parseInt(number));
            travel.setBusId(busId);
//            travel.setFromStationId(fromStationId);
//            travel.setToStationId(toStationId);
//            travel.setFromPlatformId(fromPlatformId);

//            Date startDate = null,
//                 endDate = null;
//            try {
//                startDate = new SimpleDateFormat(DATE_FORMAT).parse(startDateStr);
//                endDate = new SimpleDateFormat(DATE_FORMAT).parse(endDateStr);
//
//                travel.setStartDate(startDate);
//                travel.setEndDate(endDate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

            MongoClient mongo = (MongoClient) req.getServletContext()
                    .getAttribute("MONGO_CLIENT");
            TravelDao travelDao = new TravelDao(mongo);
            travelDao.addItem(travel);
            System.out.println("Travel Added Successfully with id=" + travel.getId());
            req.setAttribute("success", "Travel Added Successfully");
            List<Travel> travels = new ArrayList<>(travelDao.findAll());
            req.setAttribute("travels", travels);

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/travels.jsp");
            rd.forward(req, resp);
        }
    }
}
