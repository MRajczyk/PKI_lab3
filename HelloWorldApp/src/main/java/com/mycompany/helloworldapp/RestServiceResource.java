/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.helloworldapp;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("RestService")
@RequestScoped
public class RestServiceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestServiceResource
     */
    public RestServiceResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.helloworldapp.RestServiceResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String sayPlainTextHello(String data) throws Exception {
        JSONObject jsonRequest;
        JSONObject jsonResponse = new JSONObject("{\"Hello\":\"World\"}");
        try {
            jsonRequest = new JSONObject(data);
            jsonResponse.put("Hello", jsonRequest.get("name"));
        }
        catch (JSONException e) {
        }
        return jsonResponse.toString();
    }

    /**
     * PUT method for updating or creating an instance of RestServiceResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST @Path("/score/wins")@Produces("text/plain")
    public int increaseWins() { return Scores.WINS++; }

    @POST @Path("/score/ties")@Produces("text/plain")
    public int increaseTies() { return Scores.TIES++;}

    @POST @Path("/score/losses")@Produces("text/plain")
    public int increaseLosses() {return Scores.LOSSES++;}
    
    @GET @Path("/score") @Produces("application/json")
    public String getScore() {
     String pattern =
     "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
     return String.format(pattern, Scores.WINS, Scores.LOSSES, Scores.TIES );
    }
    @PUT @Path("/score")
    @Produces("application/json")
    public String update(
    @QueryParam("wins")
    int wins,
    @QueryParam("losses") 
    int losses,
    @QueryParam("ties") 
    int ties) {
        Scores.WINS = wins;
        Scores.TIES = ties;
        Scores.LOSSES = losses;
        String pattern =
        "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
        return String.format(pattern, Scores.WINS, Scores.LOSSES, Scores.TIES );
    }
}
