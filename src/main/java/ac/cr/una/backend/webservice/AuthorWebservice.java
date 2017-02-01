/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;
import ac.cr.una.backend.dao.AuthorContactDAO;
import ac.cr.una.backend.dao.AuthorContactDAOImple;
import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.dao.AuthorDAOImple;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.service.AuthorService;
import ac.cr.una.backend.service.AuthorServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;

import javax.ws.rs.core.MediaType;

/**
 *
 * @author Tuti
 */
@Path("authors")
public class AuthorWebservice {
    
     private AuthorDAO authorDAO;
     private AuthorContactDAO authorContactDAO;
     private AuthorService authorService;
   
     @Context
    private UriInfo context;

    public AuthorWebservice() {
    }
    
     @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuthorContact> getAllAuthor() {
        List<AuthorContact> authorList = null;
        authorDAO = new AuthorDAOImple();
        authorService = new AuthorServiceImpl(authorDAO);
        
         authorList = authorService.findAll();

        return authorList;
        
    }
     
       @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAuthorByName(@PathParam("name") String name) {
        Author author = null;
        authorDAO = new AuthorDAOImple();
        authorService = new AuthorServiceImpl(authorDAO);

        author = authorService.findByName(name);

        return author;
    }
     
     @DELETE
    @Path("/{idAuthor}")
    public boolean deleteAuthor(@PathParam("idAuthor") int idAuthor) {
        boolean result;
        authorDAO = new AuthorDAOImple();
        authorService = new AuthorServiceImpl(authorDAO);

        result = authorService.deleteALL();

        return result;
    }
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuthorContact createAuthorContact(AuthorContact authorContact) {

        authorContactDAO = new AuthorContactDAOImple();
        authorService = new AuthorServiceImpl(authorDAO);

        authorContact = authorService.save(authorContact);

        return authorContact;
    }
    
}