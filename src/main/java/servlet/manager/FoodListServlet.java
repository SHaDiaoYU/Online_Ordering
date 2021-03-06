package servlet.manager;

import bean.Food;
import service.FoodService;
import service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 无用
 */
@WebServlet("/foodListServlet")
public class FoodListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FoodService service = new FoodServiceImpl();
        List<Food> foods = service.FindAll();

        //System.out.println(foods);
        request.setAttribute("foods",foods);


        request.getRequestDispatcher("/admin_foodList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
