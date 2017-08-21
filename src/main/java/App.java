import models.Bouquet;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");



        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Bouquet> allFlowers = Bouquet.getAllFlowers();
            model.put("allFlowers", allFlowers);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/flowers", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Bouquet> bouquets = Bouquet.getAllFlowers();
            model.put("bouquet", bouquets);
            return new ModelAndView(model, "flower-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/flowers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "flower-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/flowers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Bouquet> bouquets = Bouquet.getAllFlowers();
            String flower1 = request.queryParams("flower1");
            String flower2 = request.queryParams("flower2");
            String teamHead = request.queryParams("teamHead");
            Bouquet newFlower = new Bouquet(flower1, flower2);
            newFlower.addMember(teamHead);
            model.put("bouquet", newFlower);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/flowers/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfFlowerToFind = Integer.parseInt(req.params("id"));
            Bouquet flowersMade = Bouquet.findById(idOfFlowerToFind);
            model.put("flowers", flowersMade);
            return new ModelAndView(model, "flower-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/flowers/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToEdit = Integer.parseInt(req.params("id"));
            Bouquet editFlowers = Bouquet.findById(idOfPostToEdit);
            model.put("editFlowers", editFlowers);
            return new ModelAndView(model, "flower-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/flowers/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToEdit = Integer.parseInt(req.params("id"));
            Bouquet editFlowers = Bouquet.findById(idOfPostToEdit);
            String flower1 = req.queryParams("flower1");
            editFlowers.setFlower1(flower1);
            model.put("newFlower1", editFlowers);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/flowers/:id/add-member", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToEdit = Integer.parseInt(req.params("id"));
            Bouquet editFlowers = Bouquet.findById(idOfPostToEdit);
            model.put("addMember", editFlowers);
            return new ModelAndView(model, "flower-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/flowers/:id/add-member", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int idOfPostToEdit = Integer.parseInt(request.params("id"));
            Bouquet editFlowers = Bouquet.findById(idOfPostToEdit);
            String member = request.queryParams("member");
            editFlowers.addMember(member);
            model.put("addMember", editFlowers);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
