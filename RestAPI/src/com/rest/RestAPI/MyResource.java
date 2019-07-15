package com.rest.RestAPI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.rest.dto.Businessman;
import com.rest.dto.Comments;
import com.rest.dto.Entrepreneur;
import com.rest.dto.Product;
import com.rest.dto.Student;
import com.ts.dao.BusinessmanDAO;
import com.ts.dao.CommentsDAO;
import com.ts.dao.EntrepreneurDAO;
import com.ts.dao.ProductDAO;
import com.ts.dao.StudentDAO;
@Path("myresource")
public class MyResource {
	@Path("getIt")
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Get it!";
    }
	@Path("gotIt")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String gotIt() {
        return "Got it!";
    }
    @Path("StudentregisterJ")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void  StudentregisterJ(Student obj) {
    	System.out.println("Inside REST.."+obj);//send to database code 
    	StudentDAO studentDAO = new StudentDAO();
    	studentDAO.register(obj); 
    }
    @Path("EntrepreneurregisterJ")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void EntrepreneurregisterJ(Entrepreneur obj) {
    	EntrepreneurDAO entrepreneurDAO = new EntrepreneurDAO();
    	entrepreneurDAO.register(obj); //send to database code 
    }
    @Path("BusinessmanregisterJ")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void BusinessmanregisterJ(Businessman obj) {
    	BusinessmanDAO businessmanDAO = new BusinessmanDAO();
    	businessmanDAO.register(obj);  
    }
    @Path("StudentLogin/{emailId}/{password}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Student StudentLogin(@PathParam("emailId") String emailId,@PathParam("password") String password) {
		Student student = new Student();
		student = null;
		StudentDAO studentDAO = new StudentDAO();
		student = studentDAO.getStudentByPassword(emailId, password);
		System.out.println(student);
	    return student ;
	}
    @Path("EntrepreneurLogin/{emailId}/{password}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public  Entrepreneur EntrepreneurLogin(@PathParam("emailId") String emailId,@PathParam("password") String password) {
		Entrepreneur entrepreneur = new Entrepreneur();
		EntrepreneurDAO entrepreneurDAO = new EntrepreneurDAO();
		entrepreneur = entrepreneurDAO.getEntrepreneurByPassword(emailId, password);
		return entrepreneur;
	}
    @Path("BusinessmanLogin/{emailId}/{password}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Businessman BusinessmanLogin(@PathParam("emailId") String emailId,@PathParam("password") String password) {
    	Businessman businessman = new Businessman();
		BusinessmanDAO businessmanDAO = new BusinessmanDAO();
		businessman = businessmanDAO.getBusinessmanByPassword(emailId, password);
		return businessman;
			
	}
    
    @Path("Login/{emailId}/{password}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
	public String Login(@PathParam("emailId") String emailId,@PathParam("password") String password) {
    	Businessman businessman = new Businessman();
    	String value = "";
		BusinessmanDAO businessmanDAO = new BusinessmanDAO();
		businessman = businessmanDAO.getBusinessmanByPassword(emailId, password);
		Entrepreneur entrepreneur = new Entrepreneur();
		EntrepreneurDAO entrepreneurDAO = new EntrepreneurDAO();
		entrepreneur = entrepreneurDAO.getEntrepreneurByPassword(emailId, password);
		Student student = new Student();
		StudentDAO studentDAO = new StudentDAO();
		student = studentDAO.getStudentByPassword(emailId, password);
		if(student != null) {
			value = "student";
		} else if(entrepreneur != null) {
			value = "entrepreneur";
		} else if(businessman != null) {
			value = "businessman";
		} else {
			value = "nothing";
		}
		
		System.out.println(value);
		return value;
	}
    
    
    @Path("getAllEntrepreneurs")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Entrepreneur> getAllEntrepreneurs() {
    	EntrepreneurDAO entrepreneurDAO = new EntrepreneurDAO();
		return entrepreneurDAO.getAllEntrepreneur();
        
	}
    @Path("getAllProducts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts() {
    	ProductDAO productDAO = new ProductDAO();
    	return productDAO.getAllProduct();
        
	}
    @Path("getStudentByEmail/{emailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Student getStudentByEmail(@PathParam("emailId") String emailId) {
    	StudentDAO studentDAO = new StudentDAO();
    	return studentDAO.getStudent(emailId);    
	}
    @Path("getEntrepreneurByEmail/{emailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Entrepreneur getEntrepreneurByEmail(@PathParam("emailId") String emailId) {
    	EntrepreneurDAO entrepreneurDAO = new EntrepreneurDAO();
		return entrepreneurDAO.getEntrepreneur(emailId);
	}
    @Path("getBusinessmanByEmail/{emailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Businessman getBusinessmanByEmail(@PathParam("emailId") String emailId) {
    	BusinessmanDAO businessmanDAO = new BusinessmanDAO();
		return businessmanDAO.getBusinessman(emailId);
	}
    @Path("getProductById/{productId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Product getProductById(@PathParam("productId") int productId) {
    	ProductDAO productDAO = new ProductDAO();
    	return productDAO.getProduct(productId);
	}
    @Path("getCommentById/{productId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Comments getCommentById(@PathParam("productId") int productId) {
    	CommentsDAO commentsDAO = new CommentsDAO();
    	return commentsDAO.getComments(productId);
	}
    @Path("getCommentByemailId/{emailId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Comments getCommentByemailId(@PathParam("emailId") String emailId) {
    	CommentsDAO commentsDAO = new CommentsDAO();
    	return commentsDAO.getComments(emailId);
	}
    @Path("addProduct")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product obj) {
    	ProductDAO productDAO = new ProductDAO();
    	productDAO.register(obj);
    }
    @POST
	@Path("/uploadImage")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadImage(@FormDataParam("Image") InputStream fileInputStream, @FormDataParam("Image") FormDataContentDisposition 
    formDataContentDisposition) throws IOException {
		int read = 0;
	    byte[] bytes = new byte[1024];
	    FileOutputStream out = new FileOutputStream(new File("/home/goutham/Desktop/project/RestAPI/WebContent/image", formDataContentDisposition.getFileName()));
	    while ((read = fileInputStream.read(bytes)) != -1) {
	    	System.out.println("uploading.......");
	    	out.write(bytes, 0, read);
	    }
	    out.flush();
	    out.close();
    
    }
}
